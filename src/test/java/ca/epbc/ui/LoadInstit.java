package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadInstit {
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
		
		Login login = new Login();
		login.test();
		
		//Load Institutions
		new WebDriverWait(driver, 50)
		.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(text(), '🏛 Institutions')]"))).click();
		//Check Instit list on displayed
		new WebDriverWait(driver, 50)
		.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Institutions')]")));
		
		
		
	}
}
