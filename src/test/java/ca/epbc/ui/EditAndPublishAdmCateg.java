package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAndPublishAdmCateg {

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

        AddAdmissionCateg edit = new AddAdmissionCateg();
        edit.test();

        //Click Edit Adm Categ
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Edit')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("openDateTime-formatted")));
        element.sendKeys("November 03, 2020 at 12:00 am");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("closeDateTime-formatted")));
        element.sendKeys("January 03, 2021 at 12:00 am");
        //Tick publish
        ((WebElement) driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox' and @aria-label='publish checkbox']"))))
                .click();

        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();
        Thread.sleep(1000);
        //Publish
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector("[class='btn btn-primary mr-2']"))).click();

        Thread.sleep(1000);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Published')]")));
        System.out.println("Adm Categ published successfully!");


    }
}
