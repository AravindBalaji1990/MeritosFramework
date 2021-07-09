package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndeedHomePage extends BaseClass {

	public IndeedHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='text-input-what' and @name = 'q']")
	public WebElement txt_what;

	@FindBy(xpath = "//input[@id='text-input-where']")
	public WebElement txt_where;

	@FindBy(xpath = "//button[contains(text(),'Find jobs') and @type='submit']")
	public WebElement btn_submit;

}
