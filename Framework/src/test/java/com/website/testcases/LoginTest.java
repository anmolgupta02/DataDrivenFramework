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
	
	@Test
	public void TestLogin() throws Exception {
		
		logger = reports.createTest("Login to InstaCEI");
		
		homepage = PageFactory.initElements(driver, HomePage.class);
		
		logger.info("Reading File Content and Running");
		
		homepage.LoginProcess(edp.getStringData("login",0,0), edp.getStringData("login",0,1));
	
		logger.pass("Login Done! Case pased");
	}
	
}
