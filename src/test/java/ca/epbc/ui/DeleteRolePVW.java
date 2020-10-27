package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteRolePVW {

    private WebDriver driver;
    public static String role;

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        DeleteRolePVW.role = role;
    }

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

        AddRolePVW addrolepvw = new AddRolePVW();
        addrolepvw.test();

        //Click Delete
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Delete')]"))).click();
        //Confirm delete role
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='btn btn-danger mr-2']")));
        element.click();
        System.out.println("Role deleted successfully");
        //check role is deleted
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='MuiInputBase-input MuiInput-input MuiInputBase-inputAdornedStart']")));
        element.sendKeys(AddRolePVW.getRole());
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'No data')]")));

    }
}
