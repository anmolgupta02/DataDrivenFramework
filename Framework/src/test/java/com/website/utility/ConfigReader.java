package com.website.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties pro;
	public ConfigReader() throws Exception {
		
		File src = new File("/home/appventurez/eclipse-workspace/Framework/Configuration/config.properties");
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
	
	
}
