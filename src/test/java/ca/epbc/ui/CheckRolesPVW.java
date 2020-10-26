package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckRolesPVW {

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

        //Login
        LoginPVW loginpvw = new LoginPVW();
        loginpvw.test();

        CheckRolesPVW goToRoles = new CheckRolesPVW();
        goToRoles.goToRoles(element, driverWait, driver);

        //type user
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='MuiInputBase-input MuiInput-input MuiInputBase-inputAdornedStart']")));
        element.sendKeys("root");
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Super User Role')]")));
        System.out.println("User & role found");
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//a[@title='View details for root']"))).click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Super User Role')]")));
        System.out.println("Super User Role");


    }
    public void goToRoles(WebElement element, WebDriverWait driverWait, WebDriver driver) throws Exception {
        //Click Users
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Users')]"))).click();
        //Click Roles
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Roles')]"))).click();
    }
}
