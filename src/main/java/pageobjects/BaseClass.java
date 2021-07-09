package pageobjects;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	public static WebDriver driver;

	// constructor to initialize the same
	public BaseClass(WebDriver driver) {
		BaseClass.driver = driver;
	}

}
