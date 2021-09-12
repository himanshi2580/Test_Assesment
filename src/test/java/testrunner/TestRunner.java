package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions",
		"hooks" }, monochrome = true, plugin = { "pretty", "html:target/htmlReports.html",
				"json:target/jsonReports.json", "junit:target/xmlReports.xml" })

public class TestRunner {

}
