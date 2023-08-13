package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointPageObject;

public class Level_12_Dynamic_Locator_Rest_Parameter extends BaseTest {

	WebDriver driver;

	private String emailAddress = getEmailRandom();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private AddressPageObject addressPage;
	private OrderPageObject orderPage;
	private RewardPointPageObject rewardPointPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}


	@Test
	public void User_01_Register_Success() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login_Success() {
		homePage = registerPage.clickToHomePageLogo();

		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextBox(emailAddress);
		loginPage.enterToPassWordTextbox("123456");
		homePage =loginPage.clickToLoginButton();

		customerPage= homePage.clckToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

	}
	
	@Test
	public void User_03_Switch_Multiple_Page() {
		//Customer Page -> Address Page
		
		addressPage = (AddressPageObject) customerPage.openDynamicSideBarPage("Addresses");
		//Address page -> Order Page
		orderPage = (OrderPageObject) addressPage.openDynamicSideBarPage("Orders");
		
		//Order Page -> Customer Page 
		customerPage = (CustomerPageObject) orderPage.openDynamicSideBarPage("Customer info");
		
		//Customer Page -> Order Page 
		orderPage = (OrderPageObject) customerPage.openDynamicSideBarPage("Orders");
		
		//Order page -> Address Page 
		addressPage = (AddressPageObject) orderPage.openDynamicSideBarPage("Addresses");
		//Address Page -> Reward Point 
		rewardPointPage = (RewardPointPageObject) addressPage.openDynamicSideBarPage("Reward points");
		
		//Reward point Page -> Customer 
		customerPage = (CustomerPageObject) rewardPointPage.openDynamicSideBarPage("Customer info");
		//Customer Page -> Reward Point Page 
		rewardPointPage =  (RewardPointPageObject) customerPage.openDynamicSideBarPage("Reward points");
		
	}
	
	@Test
	public void User_04_Switch_Multiple_Page() {
		
		//Reward point Page -> Customer 
		rewardPointPage.openDynamicSideBarPageByName("Customer info");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		//Customer Page -> Reward Point Page 
		customerPage.openDynamicSideBarPageByName("Addresses");
		addressPage = PageGeneratorManager.getAddressPage(driver);
		
		addressPage.openDynamicSideBarPageByName("Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
