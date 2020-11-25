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

public class AddNewQuestion {

    private WebDriver driver;
    public static String qkey;

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @AfterClass
    public static void afterClass() {
        WebDriverManager.instance = null;
    }


    public static void setQkey(String qkey) {
        AddNewQuestion.qkey = qkey;
    }

    @SuppressWarnings("deprecation")
    @Test
    public void test() throws Exception {
        driver = WebDriverManager.getDriver();
        WebDriverWait driverWait = WebDriverManager.getDriverWait();
        WebElement element = WebDriverManager.getElement();
        WebDriverManager.getElements();
        CommonUtils.login();

        SkookDashboard skook = new SkookDashboard();
        skook.test();

        // create Unique q key
        qkey = Calendar.getInstance().getTimeInMillis() + "TE";
        System.out.println("New created role is: " + qkey);
        setQkey(qkey);
        //Click BBQ
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Broad Based Questionnaire')]"))).click();
       //Check the qkey not exit
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class='MuiInputBase-input MuiInput-input MuiInputBase-inputAdornedStart']")));
        element.sendKeys(qkey);

        //New Question
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Add New Question')]"))).click();

        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("questionText")));
        element.sendKeys("test question");

        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("questionKey")));
        element.sendKeys(qkey);
        //help text
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("help")));
        element.sendKeys("Computers must store all data in a binary format - that is, with zeros and ones. So each letter that you're reading right now is stored on my server as a series of zeros and ones. That needs to go from my server to your browser, and your browser needs to understand what those zeros and ones are referring to.In the early days of computing, everyone had their own ideas about which binary codes should refer to which textual characters - there was no universal standard saying 01100001=a, 01100010=b, etc., but that changed in the 1980s with the formation of Unicode. Unicode is an international standards body that works towards a universal specification for text characters. Before Unicode was formed, everyone had their own ways of storing and rendering text, and so whenever two programs from different programmers or organisations had to \"talk\" to one another, they'd have to build a \"translator\" so that they could understand which codes referred to which textual characters.");
        element = driverWait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div/form/fieldset/div[4]/div/div/div[1]")));
        element.click();
        Thread.sleep(1000);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Information Only')]"))).click();
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//*[contains(text(), 'Save')]"))).click();

        Thread.sleep(1000);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(qkey));
        System.out.println("Question saved succefully");







    }
}
