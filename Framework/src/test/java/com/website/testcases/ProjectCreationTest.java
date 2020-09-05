package com.website.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.website.pages.BaseClass;
import com.website.pages.CreateProject;

public class ProjectCreationTest extends BaseClass {

	LoginTest lt;
	CreateProject cp;

	
	@Test(priority = 1)
	public void Init() throws Exception {
		
		lt = new LoginTest();
		
		lt.TestLogin();
	}
	
	
	@Test(priority = 2)
	public void createProject() throws Exception {
		
		//logger = reports.createTest("Upload New project Test");

		cp = PageFactory.initElements(driver, CreateProject.class);

		cp.CreateProjectProcess(edp.getStringData("ProjectDetails", 0, 0), edp.getStringData("ProjectDetails", 0, 1),
				System.getProperty("user.dir") + "/TestData/Noida.csv");

		cp.AcceptAlert();

		cp.DownloadImage();

	}

}
