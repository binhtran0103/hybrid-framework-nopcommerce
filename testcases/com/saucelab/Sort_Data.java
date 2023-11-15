package com.saucelab;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.saucelab.InventoryPageObject;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class Sort_Data extends BaseTest {

	WebDriver driver;
	private LoginPageObject loginPage;
	private InventoryPageObject inventoryPage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.enterUserNameToTextbox("standard_user");
		loginPage.enterPasswordTextbox("secret_sauce");
		inventoryPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		inventoryPage.selectSortDropDown("Name (A to Z)");
		inventoryPage.sleepInSecond(3);
		Assert.assertTrue(inventoryPage.isProductNameSortAscending());

		inventoryPage.selectSortDropDown("Name (Z to A)");
		inventoryPage.sleepInSecond(3);
		Assert.assertTrue(inventoryPage.isProductNameSortDescending());

	}

	@Test
	public void Sort_02_Price() {
		inventoryPage.selectSortDropDown("Price (low to high)");
		inventoryPage.sleepInSecond(3);
		Assert.assertTrue(inventoryPage.isProductPriceSortAscending());

		inventoryPage.selectSortDropDown("Price (high to low)");
		inventoryPage.sleepInSecond(3);
		Assert.assertTrue(inventoryPage.isProductPriceSortDescending());

	}


	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
