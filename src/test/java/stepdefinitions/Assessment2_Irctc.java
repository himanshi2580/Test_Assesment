package stepdefinitions;

import org.openqa.selenium.WebDriver;
import commonfunctions.Utils;
import io.cucumber.java.en.Given;
import pages.IRCTCPage;

public class Assessment2_Irctc {
	WebDriver driver;
	IRCTCPage obj = new IRCTCPage(driver);

	@Given("User is on IRCTC sites")
	public void user_is_on_irctc_sites() {
		obj.launchUrlAndVerify("chrome", "http://www.irctc.co.in/");
		driver = Utils.getDriver();
		obj = new IRCTCPage(driver);
		obj.clickOnAlert();
	}

	@Given("User fills the From and To location")
	public void user_fills_the_from_and_to_location() {
		obj.enterFrom("C SHIVAJI MAH T - CSTM");
		obj.enterTo("HOWRAH JN - HWH");
	}

	@Given("Select TATKAL ticket")
	public void select_tatkal_ticket() {
		obj.selectCategory("TATKAL");
	}

	@Given("Select Date one month from Today Date")
	public void select_date_month_from_today_date() {
		obj.enterDate();
	}

	@Given("Select AC three Tier")
	public void select_ac_tier() {
		obj.selectClass("AC 3 Tier (3A)");
	}

	@Given("Select Train with Available Berth")
	public void select_train_with_available_berth() {
		obj.checkboxAvailableBirth();
	}

	@Given("Click on Search")
	public void click_on_search() {
		obj.clickOnSearchButton();
		obj.verifySearchPage();
	}
}
