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

public class CopyProgram {

    private WebDriver driver;
    public static String code;


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

        EditAndPublishProgram archProg = new EditAndPublishProgram();
        archProg.test();

        //Click Copy fee
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Copy')]"))).click();

        AddNewPrograms.getProggr();
        System.out.println(AddNewPrograms.getProggr());
        Thread.sleep(1000);
        //Program name
        code =  "C" + Calendar.getInstance().getTimeInMillis();
        System.out.println("New created campus is: " + code);

        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("code")));
        element.clear();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("code")));
        element.sendKeys(code);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Copy of TestProgram')]")));
        System.out.println("Program created successfully!");
    }
}
