package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddNewAddrSkook {

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

        SelectSkookPVW edit = new SelectSkookPVW();
        edit.test();

        //Add New Address
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Add New Address')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("label")));
        element.sendKeys("Test label");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[7]/div/div/div/div/form/fieldset/div[2]/div/div/div[1]")));
        element.click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Physical Address')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("address.line1")));
        element.sendKeys("test addr");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("address.line2")));
        element.sendKeys("test addr1");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("address.line2")));
        element.sendKeys("test addr2");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("address.city")));
        element.sendKeys("Test City Test");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("address.postalCode")));
        element.sendKeys("V8X 1G4");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[7]/div/div/div/div/form/fieldset/div[7]/div/div/div[1]")));
        element.click();
        Thread.sleep(1000);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Aruba')]"))).click();
        Thread.sleep(1000);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//*[contains(text(), 'Save')]"))).click();
        System.out.println("click Save button");
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Aruba')]")));







        }
    }
