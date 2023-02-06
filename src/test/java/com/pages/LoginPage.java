package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GlobalLibrary;

public class LoginPage extends GlobalLibrary {
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
			
	@FindBy(xpath = "//button//span[@class='uq_user_name']")
	private WebElement userNameValidate;

	
	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() { 
		return submit;
	}

	public WebElement getUserNameValidate() {
		return userNameValidate;
	}
	
	
	
	
}

