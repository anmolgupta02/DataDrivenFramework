package com.website.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.website.utility.BrowserFactory;
import com.website.utility.ConfigReader;
import com.website.utility.ExcelDataProvider;
import com.website.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	
	//Global Variables for Files
	public ConfigReader cr;
	public ExcelDataProvider edp;
	
	//Global Variables for ExtentReports
	public ExtentReports reports;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setupFile() {
		try {
			//Init objects for ConfigReader and ExcelDataProvider
			edp = new ExcelDataProvider();
			cr = new ConfigReader();
		} catch (Exception e) {
			System.out.println("Could not read file "+e);
		}
		
		//Init ExtentReporter variables
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("/home/appventurez/eclipse-workspace/Framework/Reports/LoginReport "+Helper.getCurrentDateTime()+".html"));
		reports = new ExtentReports();
		reports.attachReporter(extent); 
	}
	@BeforeTest
	public void setup() {
		
		//Passing data from config file to browser Factory.
		driver = BrowserFactory.startApplication(driver,cr.getBaseURL(),cr.getBrowserName());
	}
	
	
	@AfterTest
	public void TearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void TearDownMethod(ITestResult result) throws IOException, Exception {
		
		//Capture ScreenShot after each and every failed case.
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			//Adding ScreenShot in the logs
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
	
	//FLushing Extent Test to generate report.
		reports.flush();
	}

}
