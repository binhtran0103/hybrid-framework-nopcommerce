package pageUIs.jquery;

public class HomePageUI {
	public static final String COLUMN_TEXTBOX_BY_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_LINK_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_LINK_ACTIVE_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_ROW_VALUES = "xpath=//td[@data-key='Females' and text()='%s']/following-sibling::td[@data-key='Country' and text()='%s']/following-sibling::td[@data-key='Males' and text()='%s ']/following-sibling::td[@data-key='Total' and text()='%s']";
	public static final String ROW_ACTION_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	public static final String ALL_PAGES_LINK = "xpath=//a[contains(@class,'qgrd-pagination-page-link')]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String ALL_VALUE_BY_COLUMN_INDEX = "xpath=//tr/td[%s]";
}