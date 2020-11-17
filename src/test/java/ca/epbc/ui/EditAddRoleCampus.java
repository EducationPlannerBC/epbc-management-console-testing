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

public class EditAddRoleCampus {

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

        AddCampus addcamp = new AddCampus();
        addcamp.test();

        //Click Edit campus
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Edit')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div/form/fieldset/div[3]/div/div/div[1]")));
        element.click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Canadian Applicant')]"))).click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();

        Thread.sleep(1000);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Canadian Applicant: applicant is a Cananadian citizen or permanent resident"));






    }
}
