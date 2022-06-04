package com.makers.automation.pages;

import com.makers.automation.helpers.Hook;
import com.makers.automation.paths.MakersPath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MakersPage extends Hook {

    MakersPath makersPath = new MakersPath();
    WebDriverWait wait = new WebDriverWait(getDriver(), 30);
    private String celular = null;

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
            Assert.assertTrue(validarExistenciaElemento(makersPath.labelPonteContacto));
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }

    public void getCelularContactoPage() {
        try {
            String path = makersPath.textCelularServicio;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            celular = getDriver().findElement(By.xpath(path)).getText();
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }

    public void ingresarNombrePage() {
        try {
            String path = makersPath.inpNombre;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
            scrollIntoView(getDriver().findElement(By.xpath(path)));
            getDriver().findElement(By.xpath(path)).sendKeys("PETER JESUS");
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }

    public void ingresarApellidoPage() {
        try {
            String path = makersPath.inpApellido;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
            scrollIntoView(getDriver().findElement(By.xpath(path)));
            getDriver().findElement(By.xpath(path)).sendKeys("ZEGARRA CARDENAS");
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }

    public void ingresarEmailPage() {
        try {
            String path = makersPath.inpEmail;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
            getDriver().findElement(By.xpath(path)).sendKeys("petzega@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }

    public void ingresarTelefonoPage() {
        try {
            String path = makersPath.inpTelefono;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
            getDriver().findElement(By.xpath(path)).sendKeys("petzega@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }
    public void ingresarComentarioPage() {
        try {
            String path = makersPath.textAreaComentario;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
            getDriver().findElement(By.xpath(path)).sendKeys(celular);
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }

    public void clickBotonEnviarMensajePage() {
        try {
            takeScreenShot();
            String path = makersPath.btnEnviarMensaje;
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
            getDriver().findElement(By.xpath(path)).click();
            closeDriver();
        } catch (Exception e) {
            e.printStackTrace();
            closeDriver();
        }
    }
}
