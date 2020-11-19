package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditProgram {


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


    }
}
