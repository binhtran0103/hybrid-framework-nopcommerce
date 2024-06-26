package pageObject.jquery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputColumnTextboxByName(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendKeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
	}
	
	public void clickToPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		sendKeyToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
	}
	
	public boolean isActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
	}
	
	public boolean isRowValueDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
	}
	
	public void clickToRowActionByCountryName(String country, String rowAction) {
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
	}

	public List<String> getAllPageValueByColumnName(String columnName) {
		List<String> allValues = new ArrayList<String>();
		
		List<WebElement> allPageLinks = getListElement(driver, HomePageUI.ALL_PAGES_LINK);
		
		int columnIdex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
		
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			sleepInSecond(2);
			
			List<WebElement> allRowValues = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIdex));
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());	
				
			}
			
		}
		//Sort ASC/DESC
		
		return allValues;
	}

	public List<String> getAllPageValueByColumnNameInDB(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAllPageValueByColumnNameInAPI(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSendKey) {
		int columnIdex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
		
		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIdex));
		sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSendKey, rowIndex, String.valueOf(columnIdex));
		
	}

	public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropDownItem) {
		int columnIdex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIdex));
		selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropDownItem, rowIndex, String.valueOf(columnIdex));
		
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIdex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex,String.valueOf(columnIdex));
		checkToCheckBoxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex,String.valueOf(columnIdex));
		
	}

}
