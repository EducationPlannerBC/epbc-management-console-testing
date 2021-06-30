package ca.epbc.ui;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class AddFee {

    private WebDriver driver;
    public static String fee;

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        WebDriverManager.instance = null;
    }

    public static String getFee() {
        return fee;
    }

    public static void setFee(String fee) {
        AddFee.fee = fee;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void test() throws Exception {
        driver = WebDriverManager.getDriver();
        WebDriverWait driverWait = WebDriverManager.getDriverWait();
        WebElement element = WebDriverManager.getElement();
        WebDriverManager.getElements();
        CommonUtils.login();

        SkookDashboard skook = new SkookDashboard();
        skook.test();

        // create Unique fee
        fee = "TestFee" + Calendar.getInstance().getTimeInMillis();
        System.out.println("New created fee is: " + fee);
        setFee(fee);
        //Click Fees
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Fees')]"))).click();

        //Add New Fee
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Add New Fee')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        element.sendKeys(fee);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div/div/div/form/fieldset/div[2]/div/div[2]/div/div[1]")));
        element.click();
        Thread.sleep(1000);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Application Fees')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("accountingCode")));
        element.sendKeys("1008");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("amount-formatted")));
        element.sendKeys("100");
        //Save
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();

        Thread.sleep(1000);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), '" + fee + "')]")));
        System.out.println("Fee saved succefully");
        


    }
}
