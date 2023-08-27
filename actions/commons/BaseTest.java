package commons;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;


public class BaseTest {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case CHROME:
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case SAFARI:
			driver = new SafariDriver();
			break;

		default:
			throw new RuntimeException("Browser name is not valid");
		}

		driver.manage().window().setPosition(new org.openqa.selenium.Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case CHROME:
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case SAFARI:
			driver = new SafariDriver();
			break;

		default:
			throw new RuntimeException("Browser name is not valid");
		}

		driver.manage().window().setPosition(new org.openqa.selenium.Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.get(url);
		return driver;
	}

	protected String getEmailRandom() {
		Random rand = new Random();
		return "john" + rand.nextInt(9999) + "@gmail.com";
	}

	protected void closeBrowser() {
		if (driver == null) {
			System.out.println("Browser is closed!");
		} else {
			driver.quit();
		}
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	

}
