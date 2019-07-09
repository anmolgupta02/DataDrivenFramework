package com.website.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "/html/body/app-root/app-theme/div/div/div[1]/app-header/div[1]/nav/div/ul/li[7]/a")WebElement loginButtonTrigger;
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/form/div[2]/div/div/div/div[2]/input")WebElement emailField;
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/form/div[2]/div/div/div/div[3]/input")WebElement passField;
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/form/div[2]/div/div/div/div[4]/button")WebElement LoginButton;
	
	
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
	
	
	
}
