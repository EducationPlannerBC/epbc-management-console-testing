package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignPermFeeAllActionPVW {

    private WebDriver driver;
    public static String role;

//    @After
//    public void tearDown() {
//        driver.close();
//        driver.quit();
//    }
//
//    @AfterClass
//    public static void afterClass() {
//        WebDriverManager.instance = null;
//    }

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

        AddRolePVW addrolepvw = new AddRolePVW();
        addrolepvw.test();

        //Add Permission
        AssignPermFeeAllActionPVW addFee = new AssignPermFeeAllActionPVW();
        addFee.addFee(element, driverWait, driver);

        //ALL
        AssignPermFeeAllActionPVW create = new AssignPermFeeAllActionPVW();
        create.create(element, driverWait, driver);



    }
    public void addFee(WebElement element, WebDriverWait driverWait, WebDriver driver) throws Exception {
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), '+ Assign permission')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div/form/div[1]/div/div/div[1]")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-2-option-0")));
        element.click();
    }
    public void create(WebElement element, WebDriverWait driverWait, WebDriver driver) throws Exception {
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div/form/div[2]/div/div/div[1]")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-3-option-4")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='btn btn-primary']")));
        element.click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'ALL')]")));

    }
    public void read(WebElement element, WebDriverWait driverWait, WebDriver driver) throws Exception {
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div/form/div[2]/div/div/div[1]")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("react-select-4-option-0")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='btn btn-primary']")));
        element.click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'READ')]")));

    }

}
