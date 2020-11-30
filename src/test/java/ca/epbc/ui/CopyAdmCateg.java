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

public class CopyAdmCateg {


    private WebDriver driver;
    public static String newCode;


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

        EditAndPublishAdmCateg copy = new EditAndPublishAdmCateg();
        copy.test();

        //Click Copy fee
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Copy')]"))).click();

        AddNewPrograms.getProggr();
        System.out.println(AddNewPrograms.getProggr());
        Thread.sleep(1000);
        //Program name
        newCode = "NC" + Calendar.getInstance().getTimeInMillis();
        System.out.println("New created campus is: " + newCode);

        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("code")));
        element.clear();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("code")));
        element.sendKeys(newCode);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Copy of Test Admission categories')]")));
        System.out.println("Copy Adm Categ created successfully!");

    }
}
