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
	(xpath = "/html/body/app-root/app-theme/div/div/div[1]/app-header/div/nav/div/ul/li[9]/a")
	WebElement SignUpTrigger;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[2]/input")
	WebElement FirstName;
	
	@FindBy
	(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[3]/input")
	WebElement LastName;
	
	@FindBy
	(xpath="/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[4]/input")
	WebElement CompanyName;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[5]/input")
	WebElement Email;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[6]/input")
	WebElement password;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[7]/input")
	WebElement cpass;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[8]/button")
	WebElement singUpButton;
		
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/form/div/div/div[2]")
	WebElement msgbox;


	public void SignUpProcess(String Fname, String Lname, String CompName, String Email, String pass, String cpass) throws Exception {
	
		SignUpTrigger.click();
		
		Thread.sleep(2000);
		
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		CompanyName.sendKeys(CompName);
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

