package stepdefinitions;

import org.openqa.selenium.WebDriver;

import commonfunctions.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GmailLoginPage;

public class Assessment1_Gmail {
	WebDriver driver;
	GmailLoginPage obj = new GmailLoginPage(driver);

	@Given("User is on gmail lodin page")
	public void user_is_on_gmail_lodin_page() {
		obj.launchUrlAndVerify("chrome", "http://www.gmail.com");
		driver = Utils.getDriver();
		obj = new GmailLoginPage(driver);
	}

	@Given("Enter username and password")
	public void enter_username_and_password() {
		//Update User-name and password here
		obj.enterUserNameAndPassword(".com", "");
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		obj.clickOnNext();
	}

	@Then("User should be logged into gmail account")
	public void user_should_be_logged_into_gmail_account() {
		obj.verifyLoggedAccount();
	}

	@When("Create a mail")
	public void create_a_mail() {
		obj.clickOnComposeButton();
	}

	@Then("Attach a file and add recipients and subjects")
	public void attach_a_file_and_add_recipients_and_subjects() {
		obj.enterDataAndAddAttachment("himanshis2580@gmail.com", "Test", "Files//abc.txt");
	}

	@Then("Click on send button")
	public void click_on_send_button() {
		obj.clickOnSentButton();
	}

	@Then("Verify the message for mail sent")
	public void verify_the_message_for_mail_sent() {
		obj.verifySentMessage();
	}
}
