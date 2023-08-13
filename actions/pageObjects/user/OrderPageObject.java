package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.OrderPageUI;

public class OrderPageObject extends MyAccountSideBarPageObject{
	private WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}



}
