package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.AddressPageUI;
import pageUIs.user.OrderPageUI;


public class AddressPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;
	
	public AddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
