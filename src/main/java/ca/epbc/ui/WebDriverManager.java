package ca.epbc.ui;

import java.io.File;
import java.util.List;

import com.sun.javafx.geom.Edge;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
			options.addArguments("headless");

			capabilities.setCapability("chrome.binary", file.getAbsolutePath());

			capabilities.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(capabilities);
				

		} else if (Config.SELECTED_DRIVER.equals(Constants.FIREFOX_DRIVER)) {

		 
			ProfilesIni profile = new ProfilesIni();
 
			FirefoxProfile myprofile = profile.getProfile("profileToolsQA");
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if(Config.SELECTED_DRIVER.equals(Constants.IE_DRIVER)) {
			

			// Defining System Property for the IEDriver
			File file = new File("bin/msedgedriver.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			// Instantiate a IEDriver class.
			WebDriver driver=new InternetExplorerDriver();
			driver.manage().window().maximize();

		} else if (Config.SELECTED_DRIVER.equals(Constants.EDGE_DRIVER)){

			// Defining System Property for Edge
			File file = new File("bin/msedgedriver.exe");
			System.setProperty("webdriver.edge.driver", file.getAbsolutePath());

			driver=new EdgeDriver();
			driver.manage().window().maximize();

			//Initialize the EdgeOptions class
			EdgeOptions edgeOptions =new EdgeOptions();

			//Use the addArguments method for configuring headless
			//edgeOptions.addArguments("headless");

			//Pass the edgeOptions object to the Edge Driver
			//driver= new EdgeDriver(edgeOptions);



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

