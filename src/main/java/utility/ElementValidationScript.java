package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

public class ElementValidationScript {
	public static boolean ElementPresent(WebDriver driver, WebElement element) {
		if (element.isDisplayed() == true && element.isEnabled() == true) {
			Log.info("The element is visible : " + element);
			return true;
		} else {
			Log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static boolean ElementPresentAndSelected(WebDriver driver, WebElement element) {
		if (element.isDisplayed() == true && element.isSelected() == true) {
			Log.info("The element is visible : " + element);
			return true;
		} else {
			Log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static boolean DropdownPresent(WebDriver driver, WebElement element, String data) {
		if (element.isDisplayed() == true && element.isEnabled() == true) {
			Select drp = new Select(element);
			drp.selectByVisibleText(data);
			Log.info("The element is visible : " + element);
			return true;
		} else {
			Log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static boolean TypeElement(WebDriver driver, WebElement element, String data) {
		if (element.isDisplayed() == true && element.isEnabled() == true) {
			element.clear();
			element.sendKeys(data);
			Log.info("The element is visible : " + element);
			return true;
		} else {
			Log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static boolean TypeElementJavaScript(WebDriver driver, WebElement element, String data) {
		if (element.isDisplayed() == true && element.isEnabled() == true) {
			element.clear();
			JavascriptExecutor sk = (JavascriptExecutor) driver;
			sk.executeScript("arguments[0].value='" + data + "';", element);
			Log.info("The element is visible : " + element);
			return true;
		} else {
			Log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static void expectedcondition(WebDriver driver, By locator, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.pollingEvery(200, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(ElementNotVisibleException.class);
	}

	public static void scrollintoview(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void FrameHandle(WebDriver driver, WebElement element) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(element);
	}

	public boolean UploadSendkeys(WebDriver driver, WebElement element, String pathToUpload) {
		if (element.isDisplayed() == true) {
			element.sendKeys(pathToUpload);
			Log.info("The element is visible : " + element);
			return true;
		} else {
			Log.error("The element is not visible : " + element);
			return false;
		}
	}

	public static void screenshot(WebDriver driver, String Screenshotname) throws IOException {
		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Calendar calobj = Calendar.getInstance();
		System.out.println("this is todays date and time : " + df.format(calobj.getTime()));
		String dirname = "./Screenshots_";
		// to check whether folder is there or not
		// if its not there we will create it
		File d = new File(dirname);
		if (d.exists() == true) {
			System.out.println("folder available");
		} else {
			d.mkdirs();
		}

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source,
				new File(dirname + "/" + Screenshotname + "_" + df.format(calobj.getTime()) + ".jpeg"));
	}
}
