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

public class AddAdmissionCateg {
    private WebDriver driver;
    public static String cadm;

    public static String getCadm() {
        return cadm;
    }

    public static void setCadm(String cadm) {
        AddAdmissionCateg.cadm = cadm;
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

    public static void setCamp(String camp) {
        AddCampus.camp = camp;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void test() throws Exception {
        driver = WebDriverManager.getDriver();
        WebDriverWait driverWait = WebDriverManager.getDriverWait();
        WebElement element = WebDriverManager.getElement();
        WebDriverManager.getElements();
        CommonUtils.login();

        ProgSelection prog = new ProgSelection();
        prog.test();

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Admission categories')]"))).click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Add New Admission Category')]"))).click();
        //Campus name
        cadm = "C" + Calendar.getInstance().getTimeInMillis();
        System.out.println("New created campus is: " + cadm);
        setCamp(cadm);

        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        element.sendKeys("Test Admission categories");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("code")));
        element.sendKeys(cadm);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("sequence")));
        element.sendKeys("3");

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Draft')]")));
        System.out.println("New campus saved successfully");

    }
}
