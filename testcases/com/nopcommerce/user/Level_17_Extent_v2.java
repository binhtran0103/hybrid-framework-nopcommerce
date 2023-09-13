//package com.nopcommerce.user;
//
//import com.relevantcodes.extentreports.LogStatus;
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import pageObjects.user.HomePageObject;
//import pageObjects.user.RegisterPageObject;
//import pageObjects.user.UserLoginPageObject;
//import reportConfig.ExtentManager;
//
//import java.lang.reflect.Method;
//
//public class Level_17_Extent_v2 extends BaseTest {
//
//	WebDriver driver;
//	private String emailAddress = getEmailRandom();
//	private HomePageObject homePage;
//	private RegisterPageObject registerPage;
//	private UserLoginPageObject loginPage;
//	private String firstName, lastName, password;
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getHomePage(driver);
//		registerPage = PageGeneratorManager.getRegisterPage(driver);
//
//		firstName = "John";
//		lastName = "Kennedy";
//		password = "123456";
//	}
//
//	@Test
//	public void User_01_Register_Validate(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register_Validate");
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 1: Verify Register link displayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 2: Click to Register link");
//		registerPage = homePage.clickToRegisterLink();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 3: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 4: Verify error message at First name textbox");
//		Assert.assertEquals(registerPage.getFirstNameErrorMessage(),"First name is required.");
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 5: Verify error message at Last name textbox");
//		Assert.assertEquals(registerPage.getLastNameErrorMessage(),"Last name is required.");
//	}
//	@Test
//	public void User_02_Register_Success(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Register_Success");
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 1: Enter to First name textbox with value is "+ firstName);
//		registerPage.refreshCurrentPage(driver);
//		homePage.clickToRegisterLink();
//		registerPage.enterToFirstNameTextbox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 2: Enter to Last name textbox with value is "+ lastName);
//		registerPage.enterToLastNameTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 3: Enter to Email textbox with value is "+ emailAddress);
//		registerPage.enterToEmailTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 4: Enter to Password textbox with value is "+ password);
//		registerPage.enterToPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 5: Enter to Confirm Password textbox with value is "+ password);
//		registerPage.enterToConfirmPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 6: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 7: Verify success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//
//	}
//
//
//	@AfterClass
//	public void afterClass() {
//		closeBrowser();
//	}
//
//}
