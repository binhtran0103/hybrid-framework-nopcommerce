package pageUIs.jquery;

public class UploadPageUI {
	public static final String FILE_LOADED_BY_NAME = "xpath=//p[@class='name' and text()='%s']";
	public static final String MULTIPLE_START_BUTTON = "css=table button.start";
	public static final String FILE_UPLOADED_BY_NAME = "xpath=//p[@class='name']/a[text()='%s']";
	
	public static final String SPIN_BORDER_ICON_AT_MAIN_CONTENT = "CSS=div.spinner-border";
	public static final String SPIN_BORDER_ICON_AT_MAIN_UPLOAD = "CSS=div.spinner-border";
	public static final String MULTIPLE_PROGRESS_BAR_ICON = "CSS=div.progress-bar";
	public static final String UPLOAD_SUCCESS_MESSAGE = "CSS=div.mainUploadSuccess div.border-success.text-white";
	public static final String UPLOAD_SUCCESS_LINK = "CSS=div.mainUploadSuccessLink a.ajaxLink";
	public static final String CONTENT_TABLE = "CSS=div#filesContentTable";
	public static final String DOWNLOAD_BUTTON_BY_FILE_NAME = "xpath=//span[text()='%s']/parent::a/parent::div/following-sibling::div/span[text()='Download']";
	public static final String PLAY_BUTTON_BY_FILE_NAME = "xpath=//span[text()='%s']/parent::a/parent::div/following-sibling::div/button[contains(@class,'fileContentOptionPlay')]";
	
}
