package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver driver = null;

	public static WebDriver OpenBrowser(String sBrowserName) throws Exception {
		try {

			if (sBrowserName.equals("Mozilla")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\aravind\\Desktop\\Selenium_Class\\LatestBrowserJar\\geckodriver-v0.22.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				Log.info("New driver instantiated");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				Log.info("Implicit wait applied on the driver for 10 seconds");
				// Handle the first tab
				Log.info("Web application launched successfully");
			}
			if (sBrowserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
						+ "\\src\\main\\resources\\browsers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");

			}
		} catch (Exception e) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
		}
		return driver;
	}

}
