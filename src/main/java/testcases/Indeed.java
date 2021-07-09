package testcases;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import applicationmodule.IndeedHomePageValidation;
import applicationmodule.IndeedSearchPageValidation;
import pageobjects.BaseClass;
import utility.ElementValidationScript;
import utility.Utils;

public class Indeed {
	public WebDriver driver;
	public static Properties OR;

	@BeforeTest
	@Parameters({ "browsers" })
	public void beforeMethod(String browsers) throws Exception {
		// log4j invocation
		DOMConfigurator.configure("log4j.xml");
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Constant.properties");
		OR = new Properties(System.getProperties());
		OR.load(fs);
		driver = Utils.OpenBrowser(browsers);
		new BaseClass(driver);
	}

	@Test
	public void indeedTestcase() throws Exception {
		driver.get(String.valueOf(OR.get("url")));
		IndeedHomePageValidation indeedhomepagevalidation = new IndeedHomePageValidation(driver);
		indeedhomepagevalidation.enterFieldsToSearch(String.valueOf(OR.get("keyword")),
				String.valueOf(OR.get("place")));
		ElementValidationScript.screenshot(driver, "Search_Field_");
		indeedhomepagevalidation.clickSearch();
		IndeedSearchPageValidation indeedsearchpagevalidation = new IndeedSearchPageValidation(driver);
		indeedsearchpagevalidation.verifyPageLoaded();
		ElementValidationScript.screenshot(driver, "Search_Page_");

	}

	@AfterTest
	public void afterMethod() {
		// Closing the opened driver
		driver.quit();
	}

}
