package app.vercel.northwind.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
*/

public class LoginTest {

    private WebDriver driver;
    /*
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }
    */
    @BeforeEach
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        //baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void testValidarAcessoSemCredenciais() {
        driver.get("https://northwind-test-platform.vercel.app/");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assertions.assertTrue(driver.findElement(By.cssSelector("[data-testid='password-error']")).isDisplayed(),"Email e senha são obrigatórios");
        //<p data-testid="password-error" class="mt-2 text-sm text-red-300 flex items-center gap-1"><span class="w-1 h-1 bg-red-300 rounded-full"></span>Email e senha são obrigatórios</p>
    }
    /*
    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://northwind-test-platform.vercel.app/");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    }
    */

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    /*
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
    */
}


