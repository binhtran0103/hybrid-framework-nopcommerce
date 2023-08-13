package commons;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	// Open a URL
		protected void openPageUrl(WebDriver driver, String pageUrl) {
			driver.get(pageUrl);
		}

		protected String getPageTitle(WebDriver driver) {
			return driver.getTitle();
		}

		protected String getCurrentUrl(WebDriver driver) {
			return driver.getCurrentUrl();
		}

		protected String getPageSource(WebDriver driver) {
			return driver.getPageSource();
		}

		protected void backToPage(WebDriver driver) {
			driver.navigate().back();
		}

		protected void forwardToPage(WebDriver driver) {
			driver.navigate().forward();
		}

		protected void refreshCurrentPage(WebDriver driver) {
			driver.navigate().refresh();
		}

		protected Alert waitForAlertPresence(WebDriver driver) {
			// WebDriverWait explicitWait = new WebDriverWait(driver, 30);
			// return explicitWait.until(ExpectedConditions.alertIsPresent());
			return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
		}

		protected void acceptAlert(WebDriver driver) {
			Alert alert = waitForAlertPresence(driver);
			alert.accept();
		}

		protected void cancelAlert(WebDriver driver) {
			waitForAlertPresence(driver).dismiss();
		}

		protected String getAlertText(WebDriver driver) {
			return waitForAlertPresence(driver).getText();
		}

		protected void sendKeyToAlert(WebDriver driver, String valueSendToKey) {
			waitForAlertPresence(driver).sendKeys(valueSendToKey);
		}

		protected void switchToWindowByID(WebDriver driver, String windowID) {
			Set<String> allIDs = driver.getWindowHandles();

			for (String id : allIDs) {
				if (!id.equals(windowID)) {
					driver.switchTo().window(id);
					break;
				}
			}
		}

		protected void CloseAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
			Set<String> allIDs = driver.getWindowHandles();

			for (String id : allIDs) {
				if (!id.equals(expectedID)) {
					driver.switchTo().window(id);
					driver.close();
				}
			}
			driver.switchTo().window(expectedID);
		}

		protected void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
			Set<String> allIDs = driver.getWindowHandles();

			for (String id : allIDs) {
				driver.switchTo().window(id);
				String actualTitle = driver.getTitle();
				if (actualTitle.equals(expectedTitle)) {
					break;
				}
			}
		}

		protected void closeAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
			Set<String> allIDs = driver.getWindowHandles();

			for (String id : allIDs) {
				if (!id.equals(expectedID)) {
					driver.switchTo().window(id);
					driver.close();
				}
			}
		}

		protected void sleepInSecond(long timeout) {
			try {
				Thread.sleep(timeout * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		protected void clickToElement(WebDriver driver, WebElement element) {
			element.click();
			
		}
		
		protected void sendKeyToElement(WebDriver driver, WebElement element, String value) {
			element.clear();
			element.sendKeys(value);
		}
		
		protected String getElementText(WebDriver driver, WebElement element) {
			return element.getText();
			
		}
		
		protected String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
			return element.getAttribute(attributeName);
			
		}
		
		protected void waitForElementVisible(WebDriver driver, WebElement element) {
			new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOf(element));
		}
		
		protected void waitForElementClickable(WebDriver driver, WebElement element) {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
		}

}
