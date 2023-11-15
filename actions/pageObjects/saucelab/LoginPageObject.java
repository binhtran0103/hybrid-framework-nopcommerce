package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.saucelab.LoginPageUI;

public class LoginPageObject extends BasePage {
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserNameToTextbox(String userName){
        waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX,userName);
    }

    public void enterPasswordTextbox(String password){
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public InventoryPageObject clickToLoginButton(){
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getInventoryPage(driver);
    }

    WebDriver driver;

}
