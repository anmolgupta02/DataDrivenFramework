package com.website.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy
	(xpath = "/html/body/app-root/app-theme/div/div/div[1]/app-header/div[1]/nav/div/ul/li[7]/a")
	WebElement loginButtonTrigger;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/form/div[2]/div/div/div/div[2]/input")
	WebElement emailField;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/form/div[2]/div/div/div/div[3]/input")
	WebElement passField;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/form/div[2]/div/div/div/div[4]/button")
	WebElement LoginButton;
	
	@FindBy
	(xpath = "/html/body/ngb-modal-window/div/div/form/div[2]/div/div/div/div[1]")
	WebElement errorHolder;
	
	@FindBy
	(xpath="/html/body/ngb-modal-window/div/div/form/div[1]/button/span")
	WebElement cross;
	
	
	public void LoginProcess(String email, String Password) throws Exception {
			Thread.sleep(3000);
		loginButtonTrigger.click();
		emailField.sendKeys(email);
		passField.sendKeys(Password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginButton.click();
	}
	
	public void LoginProcessNew(String email, String Password) throws Exception {
//	ClickCross();
		Thread.sleep(3000);
	loginButtonTrigger.click();
	emailField.sendKeys(email);
	passField.sendKeys(Password);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	LoginButton.click();
	Thread.sleep(5000);
//	String actual = getError();
//	String expected = "Email not found";
//	
//	Assert.assertTrue(actual.equalsIgnoreCase(expected));
//	
	}
	
	public void ClickCross() {
		cross.click();
	}
	
	public String getError() {
		return errorHolder.getText();
	}
	
	
	
}
