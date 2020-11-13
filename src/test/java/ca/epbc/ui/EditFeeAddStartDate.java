package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditFeeAddStartDate {
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

        AddFee addStartDate = new AddFee();
        addStartDate.test();

        //Click Edit fee
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Edit')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("schedules[0].startDate-formatted")));
        element.click();
        Thread.sleep(1000);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div/form/fieldset/ul/li[2]/div[2]/div[2]/div/section[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("schedules[0].startDate-formatted")));
        element.click();
        //Save
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();
        AddFee.getFee();
        System.out.println("Fee to be edited:" + AddFee.getFee());
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), '" + AddFee.getFee() + "')]")));
        System.out.println("Fee edited successfully");




    }
}
