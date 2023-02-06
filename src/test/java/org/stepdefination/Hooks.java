package org.stepdefination;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
//import com.example.utils.HelperClass;
import com.utilities.GlobalLibrary;
import io.cucumber.java.After;
import io.cucumber.java.en.When;




public class Hooks extends GlobalLibrary{
	
	@BeforeAll
	public static void removeFile() {
		
	}
	@AfterAll
//	@When("User closes the browser")
	public static void before_or_after_all() throws IOException {
//	public void user_closes_the_browser() throws IOException {
		takeScreenshotFullCall("1");
		quitBrowser();
	}
	
	
	@After
	public void includeScreenshot(Scenario scenario) throws IOException {
	//if(scenario.isFailed()) {
	File screenshot = ((TakesScreenshot)         driver).getScreenshotAs(OutputType.FILE);
	byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
	
	scenario.attach(fileContent, "image/png", "image1");
	//}
	}
//	HelperClass.tearDown();
}

//(fileContent, “image/png”, “image1”)//