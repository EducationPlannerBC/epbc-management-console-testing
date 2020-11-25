package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAndPublishProgram {


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

        AddNewPrograms addProg = new AddNewPrograms();
        addProg.test();

        //Click Edit Program
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Edit')]"))).click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("openDateTime-formatted")));
        element.click();
        Thread.sleep(1000);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div/form/fieldset/div[6]/div[2]/div/section[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[1]/td[1]")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("closeDateTime-formatted")));
        element.click();
        Thread.sleep(1000);
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div/form/fieldset/div[7]/div[2]/div/section[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[2]/td[1]")));
        element.click();
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("description")));
        element.click();
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
        System.out.println("Program published successfully!");



    }
}
