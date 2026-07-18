package app.vercel.northwind.login;

import app.vercel.northwind.base.BaseTest;

import app.vercel.northwind.utils.DataTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testValidarCamposObrigatoriosVazios() {

        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.click();
        inputPassword.click();
        btnLogin.click();


        WebElement mensagem = driver.findElement(By.cssSelector("[data-testid='password-error']"));
        Assertions.assertTrue((mensagem.isDisplayed()));
        Assertions.assertEquals("Email e senha são obrigatórios", mensagem.getText());
    }

    @Test
    public void testValidarFormatoEmailInvalido() {

        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(DataTest.EMAIL_INVALIDO);
        inputPassword.sendKeys(DataTest.SENHA_VALIDA);
        btnLogin.click();


        WebElement mensagem = driver.findElement(By.cssSelector("[data-testid='email-error']"));
        Assertions.assertTrue((mensagem.isDisplayed()));
        Assertions.assertEquals(DataTest.MSG_EMAIL_INVALIDO, mensagem.getText());
    }

    @Test
    public void testValidarUsuarioNaoCadastrado() {

        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(DataTest.EMAIL_INEXISTENTE);
        inputPassword.sendKeys(DataTest.SENHA_VALIDA);
        btnLogin.click();


        WebElement mensagem = driver.findElement(By.cssSelector("[data-testid='email-error']"));
        Assertions.assertTrue((mensagem.isDisplayed()));
        Assertions.assertEquals(DataTest.MSG_USUARIO_NAO_ENCONTRADO, mensagem.getText());
    }

    @Test
    public void testValidarSenhaIncorreta() {

        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(DataTest.EMAIL_VALIDO);
        inputPassword.sendKeys(DataTest.SENHA_INVALIDA);
        btnLogin.click();


        WebElement mensagem = driver.findElement(By.cssSelector("[data-testid='password-error']"));
        Assertions.assertTrue((mensagem.isDisplayed()));
        Assertions.assertEquals(DataTest.MSG_SENHA_INVALIDA, mensagem.getText());
    }

    @Test
    public void testLoginComSucesso() {

        WebElement inputEmail = driver.findElement(By.name("email"));
        WebElement inputPassword = driver.findElement(By.name("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        inputEmail.sendKeys(DataTest.EMAIL_VALIDO);
        inputPassword.sendKeys(DataTest.SENHA_VALIDA);
        btnLogin.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("https://northwind-test-platform.vercel.app/products"));
        Assertions.assertEquals("https://northwind-test-platform.vercel.app/products", driver.getCurrentUrl());
    }
}
