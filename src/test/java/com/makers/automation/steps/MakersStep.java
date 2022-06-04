package com.makers.automation.steps;

import com.makers.automation.helpers.Hook;
import com.makers.automation.pages.MakersPage;
import cucumber.api.DataTable;
import org.junit.Assert;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class MakersStep extends Hook {
    DecimalFormat df = new DecimalFormat("#.00");

    MakersPage makersPage = new MakersPage();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public void countDataDB() throws ClassNotFoundException {
        try {
            String query = "select count(*) as count  from `tb_portafolio`;";
            PreparedStatement preparedStatement = connectionBD().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            connectionBD().close();
            while (resultSet.next()) {
                if (resultSet.getInt("count") == 0) {
                    Assert.fail("No hay data en la tabla");
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void truncateDataBD() throws ClassNotFoundException {
        String query = "truncate `tb_portafolio`;";
        try {
            Statement statement = connectionBD().prepareStatement(query);
            statement.execute(query);
            connectionBD().close();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertDataBD(DataTable dataTable) throws ClassNotFoundException {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        try {
            for (Map data : list) {
                String query = "insert into `tb_portafolio` " +
                        "(fecha, portafolio, nominal, precio, total) " +
                        "VALUES (\"" + data.get("fecha").toString() + "\",  " +
                        "\"" + data.get("portafolio").toString() + "\", " +
                        "\"" + data.get("nominal").toString() + "\", " +
                        "\"" + data.get("precio").toString() + "\", " +
                        "\"" + data.get("total").toString() + "\");";
                Statement statement = connectionBD().prepareStatement(query);
                statement.executeUpdate(query);
                connectionBD().close();
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCalcBD(String calculo, String id) throws ClassNotFoundException {
        try {
            String query = String.format("UPDATE `tb_portafolio` SET calculo = \"%1$s\" WHERE id = \"%2$s\";", calculo, id);
            Statement statement = connectionBD().prepareStatement(query);
            statement.executeUpdate(query);
            connectionBD().close();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet selectAllDataBD() throws ClassNotFoundException {
        ResultSet resultSet;
        try {
            String query = "select *  from `tb_portafolio`;";
            PreparedStatement preparedStatement = connectionBD().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            connectionBD().close();
        } catch (SQLException | IOException e) {
            throw  new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet selectDataDB(String portafolio) throws ClassNotFoundException {
        ResultSet resultSet;
        try {
            String query = String.format("select *  from `tb_portafolio` where  portafolio = '%s';", portafolio);
            PreparedStatement preparedStatement = connectionBD().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            connectionBD().close();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public void calcStep(String portafolio, int adicional) throws ClassNotFoundException {
        try {
            ResultSet resultSet = selectDataDB(portafolio);
            Double calcTotal = null;
            while (resultSet.next()) {
                calcTotal = resultSet.getString("portafolio").equals("OBL-RIESGO")
                        ? ((resultSet.getDouble("nominal") * resultSet.getDouble("precio")) + adicional)
                        : (resultSet.getDouble("nominal") * resultSet.getDouble("precio"));
                updateCalcBD(df.format(calcTotal), resultSet.getString("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void validateCalc() throws ClassNotFoundException {
        try {
            boolean validator = false;
            ResultSet resultSet = selectAllDataBD();
            System.out.println(ANSI_YELLOW + "ID" + "| \tPORTAFOLIO" + "| \tNOMINAL"  + "| \tCALCULO" + "| \tVALIDACION " + ANSI_RESET );
            while (resultSet.next()) {
                validator = df.format(resultSet.getDouble("total")).equals(resultSet.getString("calculo"));
                System.out.println(ANSI_GREEN + resultSet.getInt("id") + " | \t " +
                        resultSet.getString("portafolio") + "| \t" +
                        df.format(resultSet.getDouble("total")) + "| \t" +
                        resultSet.getString("calculo") + "| \t " + validator + ANSI_RESET);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void logIntoSomosMakers(String URL) {
        makersPage.logIntoPage(URL);
        makersPage.clickBotonContactoPage("CONTACTO");
    }
}
