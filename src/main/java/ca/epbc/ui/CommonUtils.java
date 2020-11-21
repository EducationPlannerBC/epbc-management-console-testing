package ca.epbc.ui;


import java.util.Random;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CommonUtils {
	
	private static Logger log = Logger.getLogger("CommonUtils.class");

	public static void login() throws Exception {

		WebDriver driver = WebDriverManager.getDriver();
		WebElement element = WebDriverManager.getElement();

		String username = null;
		String password = null;

		if (Config.ENVIROMENT.equals(Constants.PROD)) {
			driver.get("https://apply.educationplannerbc.ca/account/create");
			driver.navigate().to("https://apply.educationplannerbc.ca/account/create");
			driver.navigate().refresh();

		} else if (Config.ENVIROMENT.equals(Constants.DEV)) {
			driver.get("https://dev-mc.educationplannerbc.ca/login"); 
			driver.navigate().to("https://dev-mc.educationplannerbc.ca/login");
			driver.navigate().refresh();

//			username = "admin";
//			password = "admin";

		} else if (Config.ENVIROMENT.equals(Constants.TST)) {
			driver.get("https://tst-mc.educationplannerbc.ca/login"); 
			driver.navigate().to("https://tst-mc.educationplannerbc.ca/login");
			driver.navigate().refresh();

//			username = "admin";
//			password = "welcome";
		} else if (Config.ENVIROMENT.equals(Constants.STG)) {
			driver.get("https://stg-mc.educationplannerbc.ca/login"); 
//			driver.navigate().to("https:/stg-apply.educationplannerbc.ca/account/create" + "/account/login");
//			driver.navigate().refresh();

		} else if (Config.ENVIROMENT.equals(Constants.PVW)) {
		driver.get("https://pvw-mc.educationplannerbc.ca/login"); 
		driver.navigate().to("https://pvw-mc.educationplannerbc.ca/login");
		driver.navigate().refresh();

		}
	}

}


