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

public class Level_08_Switch_Page extends BaseTest {

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
		
		//addressPage = customerPage.openAddressPage(driver);
		//Address page -> Order Page
		//orderPage = addressPage.openOrderPage(driver);
		
		//Order Page -> Customer Page 
		//customerPage = orderPage.openCustomerPage(driver);
		
		//Customer Page -> Order Page 
		//orderPage = customerPage.openOrderPage(driver);
		
		//Order page -> Address Page 
		//addressPage = orderPage.openAddressPage(driver);
		//Address Page -> Reward Point 
		//rewardPointPage = addressPage.openRewardPointPage(driver);
		//Customer Page -> Reward Point Page 
		//rewardPointPage = customerPage.openRewardPointPage(driver);
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
