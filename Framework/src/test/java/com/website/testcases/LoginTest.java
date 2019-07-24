package com.website.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import com.website.pages.BaseClass;
import com.website.pages.HomePage;

public class LoginTest extends BaseClass {

	HomePage homepage;
	
	@Test(priority = 1)
	public void TestLogin() throws Exception {
		
		logger = reports.createTest("Login to InstaCEI");
		
		homepage = PageFactory.initElements(driver, HomePage.class);
		
		logger.info("Reading File Content and Running");
		
		homepage.LoginProcess(edp.getStringData("login",0,0), edp.getStringData("login",0,1));
		logger.info("The login process is complete");
		Thread.sleep(5000);
		String landingHeadingExp = cr.getLandingHeading();
		String actualHeading = homepage.getHeading();
		
		if(landingHeadingExp.equalsIgnoreCase(actualHeading)) {
			logger.pass("Login Done! Case pased");
		}else {
			logger.fail("Login could not be done");
		}
		
		
		
	}
//	
//	@Test()
//	public void TestLoginWithWrongCed() throws Exception {
//		
//		logger = reports.createTest("login with wrong credentials");
//		homepage = PageFactory.initElements(driver, HomePage.class);
//		logger.info("Reading wrong credentials");
//		homepage.ClickCross();
//		
//		homepage.LoginProcessNew(edp.getStringData("login",1,0), edp.getStringData("login",1,1));
//		
//		String founderror = homepage.getError(); 
//		String expectedError = cr.getErrorMsg();
//		
//		//Assert.assertTrue(founderror.equalsIgnoreCase(expectedError));
//		
//		if(founderror.equalsIgnoreCase(expectedError)) {
//			logger.pass("Error message is correct! Case passed");
//		}
//		else {
//			logger.fail("Error message is not correct Failing the test");
//		}
//	
//	}
	
}
