package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import commonfunctions.Utils;

public class GmailLoginPage {
	Utils util = new Utils();
	WebDriver driver;

	public GmailLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	public WebElement input_email;

	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
	public WebElement button_next;

	@FindBy(how = How.XPATH, using = "//div[@id='profileIdentifier']")
	public WebElement verifyEmail;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	public WebElement input_password;

	@FindBy(how = How.XPATH, using = "//div[text()='Primary']")
	public WebElement verifyGmailLogin;

	@FindBy(how = How.XPATH, using = "//div[text()='Compose']")
	public WebElement button_compose;

	@FindBy(how = How.XPATH, using = "//textarea[@name='to']")
	public WebElement textarea_to;

	@FindBy(how = How.XPATH, using = "//textarea[@name='subjectbox']")
	public WebElement textarea_subject;

	@FindBy(how = How.XPATH, using = "//div[@id=':1de']")
	public WebElement link_attach;

	@FindBy(how = How.XPATH, using = "//div[text()='Send']")
	public WebElement button_sent;

	@FindBy(how = How.XPATH, using = "//span[text()='Message sent.']")
	public WebElement verifyMessageSent;

	public void launchUrlAndVerify(String browser, String url) {
		util.launchUrl(browser, url);
	}

	public void enterUserNameAndPassword(String username, String password) {
		util.verifyElementPresent(input_email);
		util.enterText(username, input_email);
		util.clickOnWebElement(button_next);
		util.verifyElementPresent(verifyEmail);
		util.enterText(password, input_password);
	}

	public void clickOnNext() {
		util.clickOnWebElement(button_next);
	}

	public void verifyLoggedAccount() {
		util.verifyElementPresent(verifyGmailLogin);
	}

	public void clickOnComposeButton() {
		util.clickOnWebElement(button_compose);
	}

	public void enterDataAndAddAttachment(String to, String sub, String path) {
		util.enterText(to, textarea_to);
		util.enterText(sub, textarea_subject);
		util.uploadFile(path, link_attach);
	}

	public void clickOnSentButton() {
		util.clickOnWebElement(button_sent);
	}

	public void verifySentMessage() {
		util.verifyElementPresent(verifyMessageSent);
		util.closeWindow();
	}
}
