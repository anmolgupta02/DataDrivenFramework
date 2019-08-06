package com.website.pages;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.website.utility.Helper;

public class CreateProject {
	Helper helper = new Helper();
	WebDriver driver;
	static String Source;

	public CreateProject(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "/html/body/app-root/app-theme/div/div/div[2]/app-nav-router/app-my-project/section/div/div/div/div[2]/img")
	WebElement plusButton;

	@FindBy(xpath = "/html/body/app-root/app-theme/div/div/div[2]/app-nav-router/app-features/section/div/form/div/div/div[1]/input")
	WebElement ProjectTitle;

	@FindBy(xpath = "/html/body/app-root/app-theme/div/div/div[2]/app-nav-router/app-features/section/div/form/div/div/div[2]/textarea")
	WebElement ProjectDescription;

	@FindBy(xpath = "/html/body/app-root/app-theme/div/div/div[2]/app-nav-router/app-features/section/div/form/div/div/div[3]/label")
	WebElement uploadButtonTrigger;

	@FindBy(xpath = "/html/body/app-root/app-theme/div/div/div[2]/app-nav-router/app-features/section/div/form/div/div/div[4]/button")
	WebElement NextButton;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/div/div/button")
	WebElement GenerateButton;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[1]/button")
	WebElement CloseButton;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/div/div[2]/button[1]")
	WebElement DownloadButton;

	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/div/div[2]/button[2]")
	WebElement ShareButton;

	public void CreateProjectProcess(String ProTitle, String ProDesc, String path) {

		plusButton.click();

		ProjectTitle.sendKeys(ProTitle);

		ProjectDescription.sendKeys(ProDesc);

		uploadButtonTrigger.sendKeys(path);

		NextButton.click();

	}

	public void AcceptAlert() {
		helper.AcceptAlert(driver);
	}

	public void Done() {
		CloseButton.click();
	}

	@SuppressWarnings({ "static-access" })
	public void DownloadImage() throws IOException {
		Source = DownloadButton.getAttribute("href");
		helper.Downaload(Source);
	}

}
