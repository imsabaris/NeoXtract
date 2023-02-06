package org.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFile", glue = "org\\stepdefination", dryRun = false, tags = "@TestCase_54_55", monochrome = true
, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

// "pretty",
//		"html:target/cucumber-html-report.html",
//		"junit:target/junit-reports/",
//		"json:target/json-reports.json/",

//, publish = true
)
public class TestRunnerClass extends AbstractTestNGCucumberTests {

}
