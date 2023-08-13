package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObejects.admin.AdminDashboardPageObject;
import pageObejects.admin.AdminLoginPageObject;
import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointPageObject;

public class Level_10_Switch_Page_URL extends BaseTest {

	WebDriver driver;

	private String emailAddress = getEmailRandom();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private CustomerPageObject customerPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	
	private String adminUrl, endUserUrl;

	@Parameters({"browser","adminUrl","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String userUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		
		this.adminUrl = adminUrl;
		this.endUserUrl = userUrl;
		homePage = PageGeneratorManager.getHomePage(driver);
	}


	@Test
	public void User_01_To_Admin() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Wick");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToHomePageLogo();

		userLoginPage = homePage.clickToLoginLink();
		
		homePage = userLoginPage.loginToUser(emailAddress, "123456");
		
		homePage.clickToLogoutLink();

		//Home Page (User) -> Login Page (Admin)
		homePage.openPageUrl(driver, this.adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardPage	= adminLoginPage.loginToAdmin("admin@yourstore.com", "admin");
		
		Assert.assertTrue(adminLoginPage.isPageLoadedSuccess(driver));

	}

	@Test
	public void User_02_Admin_To_User() {
		
		adminLoginPage	= adminDashboardPage.clickToLogoutLink();
		
		//Login Page(Admin) -> Home Page(User)
		adminLoginPage.openPageUrl(driver, this.endUserUrl);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		userLoginPage = homePage.clickToLoginLink();
		
		homePage = userLoginPage.loginToUser(emailAddress, "123456");
	}
	

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
