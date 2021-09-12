package commonfunctions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	public static WebDriver driver;
	final int timeout = 5;
	WebDriverWait wait;

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement findElementOfList(String xpath) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return driver.findElement(By.xpath(xpath));
	}

	public List<WebElement> findElementsOfList(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	public void launchUrl(String browser, String url) {
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ch = new ChromeOptions();
			ch.addArguments("--disable-web-security");
			ch.addArguments("--allow-running-insecure-content");
			ch.addArguments("--disable-extensions");
			ch.addArguments("--incognito");
			ch.addArguments("--disable-plugins-discovery");
			ch.addArguments("--start-maximized");
			driver = new ChromeDriver(ch);
		} else {
			System.out.println("Browser is not correct");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void closeWindow() {
		System.out.println("Handled By Hooks");
	}

	public void uploadFile(String path, WebElement webElement) {
		try {
			moveToElementAndClick(webElement);
			Robot rb = new Robot();
			// copying File path to Clipboard
			StringSelection str = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			// press Contol+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			// for pressing and releasing Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println("File is not present.");
		}
	}

	public void enterText(String value, WebElement webElement) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		webElement.clear();
		webElement.sendKeys(value);
		waitForPageload();
	}

	public void verifyElementPresent(WebElement webElement) {
		wait = new WebDriverWait(driver, timeout);
		waitForPageload();
		for (int i = 0; i <= 2; i++) {
			try {
				wait.until(ExpectedConditions.visibilityOf(webElement));
				break;
			} catch (Exception e) {
			}
		}
	}

	public void clickOnWebElement(WebElement webElement) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		webElement.click();
		waitForPageload();
	}

	public void selectDroppown(String value, WebElement webElement) {
		Select select = new Select(webElement);
		select.selectByVisibleText(value);
	}

	public void moveToElement(final WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void moveToElementAndClick(final WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	public void moveToElementUsingJS(final WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void waitForPageload() {
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

}
