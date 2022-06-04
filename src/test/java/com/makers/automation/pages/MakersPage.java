package com.makers.automation.pages;

import com.makers.automation.helpers.Hook;
import com.makers.automation.paths.MakersPath;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MakersPage extends Hook {

    MakersPath makersPath = new MakersPath();
    WebDriverWait wait = new WebDriverWait(getDriver(), 30);

    public void logIntoPage(String URL) {
        try {
            getDriver().get(URL);
            getDriver().manage().window();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(makersPath.divPage)));
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }

    public void clickBotonContactoPage(String data) {
        try {
            String value = data.toUpperCase().charAt(0) + data.substring(1).toLowerCase();
            String path = String.format(makersPath.btnContacto, value);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            getDriver().findElement(By.xpath(path)).click();
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }


}
