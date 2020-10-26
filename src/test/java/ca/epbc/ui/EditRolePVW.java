package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class EditRolePVW {

    private WebDriver driver;
    public static String secondRole;

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        WebDriverManager.instance = null;
    }


    public static String getSecondRole() {
        return secondRole;
    }

    public static void setSecondRole(String secondRole) {
        EditRolePVW.secondRole = secondRole;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void test() throws Exception {
        driver = WebDriverManager.getDriver();
        WebDriverWait driverWait = WebDriverManager.getDriverWait();
        WebElement element = WebDriverManager.getElement();
        WebDriverManager.getElements();
        CommonUtils.login();

        AddRolePVW addrolepvw = new AddRolePVW();
        addrolepvw.test();

        //Click Edit role
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Edit')]"))).click();
        //Edit role & name
        secondRole = Calendar.getInstance().getTimeInMillis() + "secondRole";
        setSecondRole(secondRole);
        System.out.println("New created role is: " + secondRole);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        element.clear();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        element.sendKeys(secondRole);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        element.clear();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        element.sendKeys("Test Role");
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), '" + secondRole + "')]")));
        System.out.println("Role edited successfully");



    }
}
