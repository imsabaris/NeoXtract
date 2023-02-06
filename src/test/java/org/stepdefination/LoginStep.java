package org.stepdefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pages.LoginPage;
import com.pages.WorkspacePage;
import com.utilities.GlobalLibrary;

import io.cucumber.java.en.*;

public class LoginStep extends GlobalLibrary {
	LoginPage lp;
	WorkspacePage ws;

	@Given("User must be in login page")
	public void user_must_be_in_login_page() {

		lanuchChrome();
		passURL("https://stagextract.uniqreate.net/login");
	}

	@When("User must enter valid {string} and {string}")
	public void user_must_enter_valid_and(String user, String pass) {

		lp = new LoginPage();
		sendKeyCall(lp.getEmail(), user);
		sendKeyCall(lp.getPassword(), pass);

	}

	@When("User must click on submit button")
	public void user_must_click_on_submit_button() {
		clickbtn(lp.getSubmit());
	}

	@Then("To Verify user redirected to neoxtract page")
	public void to_Verify_user_redirected_to_neoxtract_page() {
		WebElement assigned = driver.findElement(By.xpath("//span[text()='Assigned']"));
		Assert.assertTrue("Test Successful",assigned.isDisplayed());
		System.out.println("logged in succefully");
		
	}
	
}