package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RewardPointPageObject;
import pageUIs.user.AddressPageUI;
import pageUIs.user.BasePageUI;
import pageUIs.user.CustomerPageUI;
import pageUIs.user.OrderPageUI;

public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	// Open a URL
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		// WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		// return explicitWait.until(ExpectedConditions.alertIsPresent());
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeOut)).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendKeyToAlert(WebDriver driver, String valueSendToKey) {
		waitForAlertPresence(driver).sendKeys(valueSendToKey);
	}

	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void CloseAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedID);
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public String getDynamicLocator(String locator, String... values) {
		return String.format(locator, (Object[]) values);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	
	public void clickToElement(WebDriver driver, String locator, String... restParam) {
		getElement(driver, getDynamicLocator(locator, restParam)).click();
	}
	
	public By getByLocator(String locatorValue) {
		By by = null;
		if(locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("Xpath")) {
			by = By.xpath(locatorValue.substring(6));
		}else if(locatorValue.startsWith("css=") || locatorValue.startsWith("Css=") || locatorValue.startsWith("CSS=")) {
			by = By.cssSelector(locatorValue.substring(4));
		}else if(locatorValue.startsWith("name=") || locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=")) {
			by = By.name(locatorValue.substring(4));
		}else if(locatorValue.startsWith("id=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=")) {
			by = By.id(locatorValue.substring(3));
		}else if(locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLASS=")) {
			by = By.className(locatorValue.substring(6));
		}else if(locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("TAGNAME=")) {
			by = By.tagName(locatorValue.substring(8));
		}else {
			throw new RuntimeException("Locator type is not valid");
		}
		return by;
	}

	public List<WebElement> getListElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}
	
	public List<WebElement> getListElement(WebDriver driver, String locator, String...restParam) {
		return driver.findElements(getByLocator(getDynamicLocator(locator, restParam)));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();

	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String valueToSend, String... restParam) {
		getElement(driver, getDynamicLocator(locator, restParam)).clear();
		getElement(driver, getDynamicLocator(locator, restParam)).sendKeys(valueToSend);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();

	}
	
	public String getElementText(WebDriver driver, String locator, String...resParam) {
		return getElement(driver, getDynamicLocator(locator, resParam)).getText();

	}

	public void selectDropDown(WebDriver driver, String locator, String itemText) {
		new Select(getElement(driver, locator)).selectByVisibleText(itemText);
	}

	public String getFirstSelectedOption(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
	}

	public boolean isDropDownMultiple(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String xpathParent, String xpathChild,
			String expectedText) {
		getElement(driver, xpathParent).click();
		sleepInSecond(1);

		List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));

		for (WebElement tempElement : allItems) {
			if (tempElement.getText().equals(expectedText)) {
				// Scroll to element
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);

				tempElement.click();
				break;
			}
		}

	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String...restParam) {
		return getElement(driver, getDynamicLocator(locator, restParam)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
		return getElement(driver, locator).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaColor) {
		return Color.fromString(rgbaColor).asHex().toUpperCase();
	}

	public int getListElementSize(WebDriver driver, String locator, String...restParams) {
		return getListElement(driver, getDynamicLocator(locator, restParams)).size();
	}

	public void checkToCheckBoxRadio(WebDriver driver, String locator) {
		if (!getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	
	public void checkToCheckBoxRadio(WebDriver driver, String locator, String...restParam) {
		if (!getElement(driver, getDynamicLocator(locator, restParam)).isSelected()) {
			getElement(driver, getDynamicLocator(locator, restParam)).click();
		}
	}

	public void UncheckToCheckBox(WebDriver driver, String locator) {
		if (getElement(driver, locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...restParam) {
		return getElement(driver, getDynamicLocator(locator, restParam)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getElement(driver, locator)).perform();
	}

	public void rightClickToElemet(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDropToElement(WebDriver driver, String sourceXpath, String targetXpath) {
		new Actions(driver).dragAndDrop(getElement(driver, sourceXpath), getElement(driver, targetXpath)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator) {
		new Actions(driver).sendKeys(getElement(driver, locator)).perform();
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
		new Select(getElement(driver, locator)).selectByVisibleText(itemValue);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue, String... restParam) {
		new Select(getElement(driver, getDynamicLocator(locator, restParam))).selectByVisibleText(itemValue);
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getElement(driver, locator));
	}

	public void setAttributeInDOM(WebDriver driver, String locator, String attributeName,
			String attributeValue) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
				getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getElement(driver, locator));
	}

	public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		return (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(driver, locator));

	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeOut))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String...restParam) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeOut))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParam))));
	} 

	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeOut))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeOut))
				.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String...restParam) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeOut))
				.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParam))));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeOut))
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	public long longTimeOut = GlobalConstants.LONG_TIMEOUT;

}
