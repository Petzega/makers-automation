package com.makers.automation.helpers;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Hook {
    private static WebDriver driver;
//    @Before
    public static Connection connectionBD() throws ClassNotFoundException, IOException {
        Properties properties = new Properties();
        properties.load(Hook.class.getResourceAsStream("/config.properties"));
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =  DriverManager.getConnection(
                    properties.getProperty("URL"),
                    properties.getProperty("USER"),
                    properties.getProperty("PASS"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/drivers/chromedriver.exe").toString());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(
                "--verbose",
                "--disable-web-security",
                "--ignore-certificate-errors",
                "--allow-running-insecure-content",
                "--allow-insecure-localhost",
                "--no-sandbox",
                "--disable-gpu",
                "--disable-infobars",
                "--disable-dev-shm-usage",
                "--disable-browser-side-navigation"
        );
        if (driver == null) {
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }

    public void closeDriver() {
        getDriver().close();
        getDriver().quit();
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void takeScreenShot() {
        try {
            TakesScreenshot scrShot =((TakesScreenshot) getDriver());
            File source = scrShot.getScreenshotAs(OutputType.FILE);
            File route = new File("img/image.jpeg");
            FileUtils.copyFile(source, route);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validarExistenciaElemento(String element) {
        boolean validator = false;
        try {
            if (driver.findElements( By.xpath(element) ).size() != 0) {
                validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validator;
    }
}
