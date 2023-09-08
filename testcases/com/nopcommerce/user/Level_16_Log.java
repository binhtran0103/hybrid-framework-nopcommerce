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

public class Level_16_Log extends BaseTest {

	WebDriver driver;
	private String emailAddress = getEmailRandom();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}


	@Test
	public void User_01_Register_Success() {
		
		log.info("User 01 - Step 01: Verify Register link is displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		log.info("User 01 - Step 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("User 01 - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User 01 - Step 04: Verify error message at Firstname textbox");
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		log.info("User 01 - Step 05: Verify error message at Lastname textbox");
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required");
		
		log.info("User 01 - Step 06: Enter to Firstname textbox");
		registerPage.enterToFirstNameTextbox("John");
		
		log.info("User 01 - Step 07: Enter to Last name textbox");
		registerPage.enterToLastNameTextbox("Wick");
		
		log.info("User 01 - Step 08: Enter to Email textbox");
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("User 01 - Step 09: Enter to Password textbox");
		registerPage.enterToPasswordTextbox("123456");
		
		log.info("User 01 - Step 10: Enter to Confirm Password textbox");
		registerPage.enterToConfirmPasswordTextbox("123456");
		
		log.info("User 01 - Step 11: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("User 01 - Step 12: Verify Register success message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");

	}


	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
