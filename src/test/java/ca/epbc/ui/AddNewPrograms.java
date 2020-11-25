package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class AddNewPrograms {

    private WebDriver driver;
    public static String proggr;

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        WebDriverManager.instance = null;
    }


    public static String getProggr() {
        return proggr;
    }

    public static void setProggr(String proggr) {
        AddNewPrograms.proggr = proggr;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void test() throws Exception {
        driver = WebDriverManager.getDriver();
        WebDriverWait driverWait = WebDriverManager.getDriverWait();
        WebElement element = WebDriverManager.getElement();
        WebDriverManager.getElements();
        CommonUtils.login();

        Programs prog = new Programs();
        prog.test();

        //Add New Program
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Add New Program')]"))).click();
        //Program name
        proggr = "P" + Calendar.getInstance().getTimeInMillis();
        System.out.println("New created campus is: " + proggr);
        setProggr(proggr);

        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        element.sendKeys("TestProgram");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("code")));
        element.sendKeys(proggr);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        element.sendKeys("This is a test program from automation code");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("sequence")));
        element.sendKeys("3");

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                                .presenceOfElementLocated(By.cssSelector("[class='badge badge-info ml-2']")));

        Thread.sleep(1000);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Program created successfully!"));
        System.out.println("New program saved successfully");

        }
    }
