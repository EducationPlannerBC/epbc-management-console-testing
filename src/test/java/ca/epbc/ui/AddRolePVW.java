package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.relation.Role;
import java.util.Calendar;

public class AddRolePVW {

    private WebDriver driver;
    public static String role;

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        WebDriverManager.instance = null;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        AddRolePVW.role = role;
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

        //Add Role
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Add New Role')]"))).click();
        // create Unique role
        role = Calendar.getInstance().getTimeInMillis() + "role";
        setRole(role);
        System.out.println("New created role is: " + role);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        element.sendKeys(role);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        element.sendKeys("Test Role");
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), '" + role + "')]")));
        System.out.println("Role saved successfully");

    }
}
