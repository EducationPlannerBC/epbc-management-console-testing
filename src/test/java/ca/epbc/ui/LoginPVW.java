package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginPVW {

    private WebDriver driver;

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        WebDriverManager.instance = null;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void test() throws Exception {
        driver = WebDriverManager.getDriver();
        WebDriverWait driverWait = WebDriverManager.getDriverWait();
        WebElement element = WebDriverManager.getElement();
        WebDriverManager.getElements();
        CommonUtils.login();

        // Login MC
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Login')]")))
                .click();
        Thread.sleep(1000);
        element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-username")));
        element.clear();
        element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-username")));
        element.sendKeys("claudiu.vlasceanu@educationplannerbc.ca");
        Thread.sleep(1000);
        element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
        element.clear();
        element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password")));
        element.sendKeys("Temp123!");
        Thread.sleep(1000);
        //Click Login
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Sign In')]")))
                .click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Welcome to Management Console')]")));
        System.out.println("Login succesfully");

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Institutions List')]")));
        System.out.println("Test passed");


    }
}
