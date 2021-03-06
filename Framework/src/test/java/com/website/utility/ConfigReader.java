package com.website.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties pro;
	public ConfigReader() throws Exception {
		String filepath = System.getProperty("user.dir")+"/Configuration/config.properties";
		File src = new File(filepath);
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	}
	
	public String getBrowserName() {
		
		return pro.getProperty("browser");
	}
	
	public String getBaseURL() {
		return pro.getProperty("baseURL");
	}
	public String getErrorMsg() {
		return pro.getProperty("errorMsg");
	}
	
	public String getLandingHeading() {
		return pro.getProperty("landingHeading");
	}
	
	public String getSignUpMsg() {
		return pro.getProperty("SignUpMessage");
	}
	
}
