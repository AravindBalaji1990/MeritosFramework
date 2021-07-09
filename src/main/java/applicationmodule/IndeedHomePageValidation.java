package applicationmodule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.*;

import pageobjects.IndeedHomePage;

public class IndeedHomePageValidation extends IndeedHomePage {

	public IndeedHomePageValidation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterFieldsToSearch(String keyword, String place) {

		if (ElementValidationScript.ElementPresent(driver, txt_what)) {
			ElementValidationScript.TypeElement(driver, txt_what, keyword);
		}
		if (ElementValidationScript.ElementPresent(driver, txt_where)) {
			ElementValidationScript.TypeElement(driver, txt_where, place);
		}
		
	}

	public void clickSearch() {
		if (ElementValidationScript.ElementPresent(driver, btn_submit)) {
			btn_submit.click();
		}
	}
	
	public void verifyPageLoaded() {
		
		
	}

}
