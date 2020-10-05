package ca.epbc.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChasePaymentMeth {
	

	private WebDriver driver;

	public void chasePaymentMeth(WebElement element2, WebDriverWait driverWait2, WebDriver driver2) throws Exception {
		driver = WebDriverManager.getDriver();
		WebDriverWait driverWait = WebDriverManager.getDriverWait();
		WebElement element = WebDriverManager.getElement();
		WebDriverManager.getElements();
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);

		((WebElement) driverWait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='radio' and @value='credit']"))))
						.click();
		Thread.sleep(1000);
		element = driverWait.until(ExpectedConditions
				.presenceOfElementLocated(By.id("root_emailConfirmation_applicantEmailConfirmation")));
		element.click();
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("root_consent_applicantConsent")));
		element.click();
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("root_consent_certification")));
		element.click();
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
		element.click();
		Thread.sleep(1500);
		new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
		// Switch to iFrame
		WebElement iFrame = driver.findElement(By.tagName("iframe"));
		Thread.sleep(500);
		driver.switchTo().frame(iFrame);
		System.out.println("Iframe index is: " + iFrame);
		Thread.sleep(100);
		((JavascriptExecutor) this.driver).executeScript("window.scrollTo(0, 2300)", new Object[0]);
		Thread.sleep(100);
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("CardNumber")));
		element.clear();
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("CardNumber")));
		element.sendKeys("4444333322221111");
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("Expiry")));
		element.clear();
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("Expiry")));
		element.sendKeys("1222");
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("CVV")));
		element.clear();
		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("CVV")));
		element.sendKeys("111");

		element = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.submit-button")));
		element.click();

	}

}
