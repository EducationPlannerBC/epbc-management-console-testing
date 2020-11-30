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

public class DeleteAdmCateg {


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

        AddAdmissionCateg del = new AddAdmissionCateg();
        del.test();

        //Click Delete
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Delete')]"))).click();
        //Confirm delete role
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='btn btn-danger mr-2']")));
        element.click();
        System.out.println("Program deleted successfully");
        Thread.sleep(1000);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Admission category deleted successfully!"));



    }
}
