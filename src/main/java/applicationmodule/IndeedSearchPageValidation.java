package applicationmodule;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utility.*;

import pageobjects.IndeedHomePage;
import pageobjects.IndeedSearchPage;

public class IndeedSearchPageValidation extends IndeedSearchPage {

	public IndeedSearchPageValidation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void verifyPageLoaded() {
		if (ElementValidationScript.ElementPresent(driver, lbl_locationjob)) {
			Log.info("Page loaded sucess");
//			list_jobtitle.stream().forEach(i -> System.out.println(i.getText()));
//			list_jobtitle.stream().forEach(i -> Log.info("the jobs available : " + i.getText()));
		}

	}

}
