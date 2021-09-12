package pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import commonfunctions.Utils;

public class IRCTCPage {
	Utils util = new Utils();
	WebDriver driver;

	public IRCTCPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[@type='submit' and text()='OK']")
	public WebElement button_ok;

	@FindBy(how = How.XPATH, using = "//label[text()='From']//preceding::input[1]")
	public WebElement input_from;

	@FindBy(how = How.XPATH, using = "//label[text()='To']//preceding::input[1]")
	public WebElement input_to;

	@FindBy(how = How.XPATH, using = "//label[text()='DD/MM/YYYY *']//preceding::input[1]")
	public WebElement input_date;

	@FindBy(how = How.XPATH, using = "(//div[@class='form-group'])[1]")
	public WebElement list_class;

	@FindBy(how = How.XPATH, using = "(//div[@class='form-group'])[2]")
	public WebElement list_category;

	@FindBy(how = How.XPATH, using = "//button[text()='Search']")
	public WebElement button_search;

	@FindBy(how = How.XPATH, using = "//ul[@role='listbox']")
	public WebElement listbox;

	@FindBy(how = How.XPATH, using = "//span[text()='Modify Search']")
	public WebElement verifySearchPage;

	@FindBy(how = How.XPATH, using = "//label[text()='Train with Available Berth ']")
	public WebElement checkbox_availableBirth;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ui-datepicker-header')]//a[1]")
	public WebElement prev;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ui-datepicker-header')]//a[2]")
	public WebElement next;

	public void launchUrlAndVerify(String browser, String url) {
		util.launchUrl(browser, url);
	}

	public void clickOnAlert() {
		util.waitForPageload();
		util.verifyElementPresent(button_ok);
		util.moveToElementUsingJS(button_ok);
	}

	public void enterFrom(String value) {
		util.enterText(value, input_from);
	}

	public void enterTo(String value) {
		util.enterText(value, input_to);
	}

	public void enterDate() {
		Date newDate = DateUtils.addDays(new Date(), 4);
		SimpleDateFormat date = new SimpleDateFormat("dd");
		int value = Integer.parseInt(date.format(newDate));
		input_date.click();
		input_date.clear();
		List<WebElement> list = util.findElementsOfList(".//tbody//a");
		for (WebElement element : list) {
			if (Integer.parseInt(element.getText()) == value) {
				util.moveToElementAndClick(element);
				break;
			}
		}
	}

	public void selectClass(String value) {
		util.clickOnWebElement(list_class);
		selectValueFromTheList(value);
	}

	public void selectCategory(String value) {
		util.moveToElementAndClick(list_category);
		util.waitForPageload();
		util.verifyElementPresent(listbox);
		selectValueFromTheList(value);
	}

	public void clickOnSearchButton() {
		util.clickOnWebElement(button_search);
	}

	public void checkboxAvailableBirth() {
		util.clickOnWebElement(checkbox_availableBirth);
	}

	public void verifySearchPage() {
		util.verifyElementPresent(verifySearchPage);
		util.closeWindow();
	}

	public void selectValueFromTheList(String value) {
		util.waitForPageload();
		util.verifyElementPresent(listbox);
		WebElement listOption = util.findElementOfList(("//li//span[text()='" + value + "']"));
		util.moveToElementUsingJS(listOption);
		util.waitForPageload();
	}
}
