package com.website.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.website.pages.BaseClass;
import com.website.pages.SignUpPage;

public class SignUpTest extends BaseClass {
	
	SignUpPage sup;
	
	@Test
	public void TestSignUp() throws Exception{
		
		logger = reports.createTest("Sign Up Testing");
		
		sup = PageFactory.initElements(driver, SignUpPage.class);
		
		logger.info("Reading Data in the file");
		
		sup.SignUpProcess(edp.getStringData("SignUpData",0,0), edp.getStringData("SignUpData",0,1), 
				edp.getStringData("SignUpData",0,2),edp.getStringData("SignUpData",0,3),
				edp.getStringData("SignUpData",0,4), edp.getStringData("SignUpData",0,5));
		
		Thread.sleep(3000);
		
		String SignUpMsgExpected = cr.getSignUpMsg();
		String SignUpMsgActual = sup.getMsg();
		
		
		if(SignUpMsgExpected.equalsIgnoreCase(SignUpMsgActual)) {
			logger.pass("Test Case Passed, Sign Up successful");
		}else {
			logger.fail("Test Case Failed, Could not signed up");
			
		}
	}

}
