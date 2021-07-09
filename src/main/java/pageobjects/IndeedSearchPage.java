package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndeedSearchPage extends BaseClass {

	public IndeedSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@id='jobsInLocation']")
	public WebElement lbl_locationjob;

	@FindBy(xpath = "//a[@data-tn-element='jobTitle']")
	public List<WebElement> list_jobtitle;

}
