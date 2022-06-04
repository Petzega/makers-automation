package com.makers.automation.helpers;

import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
    @After
    public void closeDriver() {
        getDriver().close();
        getDriver().quit();
    }
}
