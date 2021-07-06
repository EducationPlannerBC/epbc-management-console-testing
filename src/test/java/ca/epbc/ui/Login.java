package ca.epbc.ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
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

		// Login MC
		new WebDriverWait(driver, 50)
		.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Sign In')]")))
		.click();
		Thread.sleep(1000);
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("signin-username")));
		element.clear();
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("signin-username")));
		element.sendKeys("claudiu.vlasceanu@educationplannerbc.ca");
		Thread.sleep(1000);
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("signin-password")));
		element.clear();
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("signin-password")));
		element.sendKeys("B@mb00zle");
		//Click Login 
		new WebDriverWait(driver, 50)
		.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Sign In')]")))
		.click();
		new WebDriverWait(driver, 50)
		.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Welcome to Management Console')]")));
			
		new WebDriverWait(driver, 50)
		.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(text(), '🏛 Institutions')]")));
		

	}

}
