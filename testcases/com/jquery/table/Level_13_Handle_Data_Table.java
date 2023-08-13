package com.jquery.table;

import java.util.ArrayList;
import java.util.List;

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

public class Level_13_Handle_Data_Table extends BaseTest {

	WebDriver driver;
	pageObject.jquery.HomePageObject homePage;
	List<String> allValueUI = new ArrayList<String>();
	List<String> allValueDB = new ArrayList<String>();
	List<String> allValueAPI = new ArrayList<String>();

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = pageObject.jquery.PageGeneratorManager.getHomePage(driver);
	}


	
	public void TC_01_Search() {
		homePage.inputColumnTextboxByName("Females", "283821");
		homePage.inputColumnTextboxByName("Males", "295140");
		homePage.inputColumnTextboxByName("Country", "Afghanistan");
		homePage.inputColumnTextboxByName("Total", "791312");

	}

	
	public void TC_02_Paging() {
		homePage.clickToPageNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isActiveByNumber("10"));
		
		homePage.clickToPageNumber("4");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isActiveByNumber("4"));
		
		homePage.clickToPageNumber("16");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isActiveByNumber("16"));
		
		homePage.clickToPageNumber("23");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isActiveByNumber("23"));

	}
	
	
	public void TC_03_Displayed() {
		homePage.inputColumnTextboxByName("Country", "Afghanistan");
		Assert.assertTrue(homePage.isRowValueDisplayed("384187", "Afghanistan", "407124", "791312"));
		Assert.assertTrue(homePage.isRowValueDisplayed("276880", "Angola", "276472", "553353"));
		Assert.assertTrue(homePage.isRowValueDisplayed("338282", "Argentina", "349238", "687522"));
	}
	
	
	public void TC_04_Icon_Button_Checkbox() {
		homePage.clickToRowActionByCountryName("Afghanistan", "remove");
		homePage.clickToRowActionByCountryName("AFRICA", "remove");
		homePage.clickToRowActionByCountryName("Albania", "remove");
		homePage.clickToRowActionByCountryName("Algeria", "remove");
		homePage.clickToRowActionByCountryName("Angola", "remove");
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToRowActionByCountryName("Afghanistan", "edit");
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToRowActionByCountryName("AFRICA", "edit");
		homePage.refreshCurrentPage(driver);
		
	}
	
	
	public void TC_05_Action_By_Index() {
		allValueUI = homePage.getAllPageValueByColumnName("Country");
		
		//DB
		allValueDB = homePage.getAllPageValueByColumnNameInDB("Country");
		
		//API 
		allValueAPI = homePage.getAllPageValueByColumnNameInAPI("Country");
		
		Assert.assertEquals(allValueUI, allValueDB);
		
		homePage.getAllPageValueByColumnName("Total");
		
		
	}
	
	@Test
	public void TC_06_Action_By_Index() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person","2","Oliver heldens");
		homePage.enterToTextboxByColumnNameAndRowIndex("Company","1","HELDEEP");
		
		homePage.selectDropdownByColumnNameAndRowIndex("Country","3","United Kingdom");
		homePage.selectDropdownByColumnNameAndRowIndex("Country","1","Japan");
		
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?","2");
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
