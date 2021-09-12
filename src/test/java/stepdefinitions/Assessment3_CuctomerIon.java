package stepdefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import commonfunctions.Utils;
import io.cucumber.java.en.Given;
import pages.CustomerIOnPage;

public class Assessment3_CuctomerIon {
	WebDriver driver;
	CustomerIOnPage obj = new CustomerIOnPage(driver);

	@Given("User is on Customer IOn sites")
	public void user_is_on_customer_i_on_sites() {
		obj.launchUrlAndVerify("chrome", "https://customer.i-on.in:9443/signUp");
		driver = Utils.getDriver();
		obj = new CustomerIOnPage(driver);
	}

	@Given("Fill the details in the form")
	public void enter_the_details() throws IOException {
		obj.enterDetails();
	}
}
