package com.website.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage  {
	
	WebDriver driver;

	public SignUpPage(WebDriver driver){
		
		this.driver = driver; 
	}
	
	@FindBy
	(xpath = "")
	WebElement SignUpTrigger;
	
	@FindBy
	(xpath = "")
	WebElement FirstName;
	
	@FindBy
	(xpath="")
	WebElement LastName;
	
	@FindBy
	(xpath="")
	WebElement CompanyName;
	
	@FindBy
	WebElement Email;
	
	@FindBy
	(xpath = "")
	WebElement password;
	
	@FindBy
	(xpath = "")
	WebElement cpass;
	
	@FindBy
	(xpath = "")
	WebElement singUpButton;
		
	@FindBy
	(xpath = "")
	WebElement msgbox;


	public void SignUpProcess(String Fname, String Lname, String CompName, String Email, String pass, String cpass) throws Exception {
	
		SignUpTrigger.click();
		
		Thread.sleep(2000);
		
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		this.Email.sendKeys(Email);
		password.sendKeys(pass);
		this.cpass.sendKeys(cpass);
		
		Thread.sleep(5000);
		
		this.singUpButton.click();
		
	}
	
	public String getMsg() {
		return msgbox.getText();
	}

}

