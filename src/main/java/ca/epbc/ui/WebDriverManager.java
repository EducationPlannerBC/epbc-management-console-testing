package ca.epbc.ui;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author cvlasceanu
 * 
 *         SantaClaus: a combination of a singleton and a factory. There's only
 *         one and he gives presents!
 * 
 *         Use a singleton to manage access to global objects. Reusing the same
 *         WebElement will minimize garbage collector usage.
 */
@SuppressWarnings("deprecation")
public final class WebDriverManager {

	public static WebDriverManager instance = null;

	// web driver objects
	private static WebDriver driver = null;
	private static WebDriverWait driverWait = null;
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	private static Select select = null;
	//private static WebDriver driver1 = null;

	/**
	 * private ctor - initialize everything
	 */
	private WebDriverManager() {
		driver = initDriver();
		driverWait = (new WebDriverWait(driver, Config.TIMEOUT));
		element = null;
		elements = null;
		select = null;
	}

	public static WebDriverManager getInstance() {
		if (instance == null) {
			instance = new WebDriverManager();
		}
		return instance;
	}

	private static WebDriver initDriver() {

		if (Config.SELECTED_DRIVER.equals(Constants.CHROME_DRIVER)) {

			File file = new File("bin/chromedriver.exe");
			
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--start-maximized");
			options.addArguments("test-type");
			//options.addArguments("headless");

			capabilities.setCapability("chrome.binary", file.getAbsolutePath());

			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities);
				

		} else if (Config.SELECTED_DRIVER.equals(Constants.FIREFOX_DRIVER)) {

		 
			ProfilesIni profile = new ProfilesIni();
 
			FirefoxProfile myprofile = profile.getProfile("profileToolsQA");
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if(Config.SELECTED_DRIVER.equals(Constants.IE_DRIVER)) {
			
			//File file = new File("lib/IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver",
//					file.getAbsolutePath());
//			
//			System.setProperty("webdriver.ie.driver", "C:\\repo\\epbc-ui-test\\TestProject\\lib\\IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
			
//			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//			InternetExplorerOptions options = new InternetExplorerOptions();
//			
//			options.addCommandSwitches("--start-maximized");
//			options.addCommandSwitches("test-type");
//			
//			capabilities.setCapability("internetExplorer.binary", file.getAbsolutePath());
//
//			
         //   driver = new InternetExplorerDriver();
			
			 String service = "C:\\repo\\epbc-ui-test\\TestProject\\lib\\IEDriverServer.exe";
			 System.setProperty("webdriver.ie.driver", service);
	 
			 // Create the DesiredCapability object of InternetExplorer
			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	 
			 // Settings to Accept the SSL Certificate in the Capability object
			 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	 
			 InternetExplorerDriver driver = new InternetExplorerDriver(capabilities); 
			// driver.get("URL for which certificate error is coming");
			 driver.get("https://tst-apply.educationplannerbc.ca/account/create" + "/account/login");
			
			
		}

		return driver;

	}

	public static WebDriver getDriver() {
		return getInstance().driver;
	}

	public static WebDriverWait getDriverWait() {
		return getInstance().driverWait;
	}

	public static WebElement getElement() {
		return getInstance().element;
	}

	public static List<WebElement> getElements() {
		return getInstance().elements;
	}

	public static Select getSelect() {
		return getInstance().select;
	}

}

