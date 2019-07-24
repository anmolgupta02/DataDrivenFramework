package com.website.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.website.pages.BaseClass;
import com.website.pages.HomePage;

public class LoginWithWrongCred extends BaseClass{
	
	HomePage homepage;

	@Test(priority=1)
	public void TestLoginWithWrongCed() throws Exception {
		
		logger = reports.createTest("login with wrong credentials");
		homepage = PageFactory.initElements(driver, HomePage.class);
		logger.info("Reading wrong credentials");
		
		
		homepage.LoginProcessNew(edp.getStringData("login",1,0), edp.getStringData("login",1,1));
		
		String founderror = homepage.getError(); 
		String expectedError = "Email not Found";
		
		Assert.assertTrue(founderror.equalsIgnoreCase(expectedError));
		
		logger.pass("Error message is correct! Case passed");
	}	
	
}
