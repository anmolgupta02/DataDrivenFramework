package com.website.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String captureScreenshot(WebDriver driver) throws Exception {
		
		//Optimising the path 
		String sspath = System.getProperty("user.dir")+"/ScreenShots/"+getCurrentDateTime()+".png";
		
		//Capture Screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.openqa.selenium.io.FileHandler.copy(src, new File(sspath));
		return sspath;
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return format.format(date);
		
	}
}
