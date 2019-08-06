package com.website.utility;

import java.io.File;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.Alert;
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
	
	public static void Downaload(String Source) throws IOException {
		
		String wget_command = "wget -P "+System.getProperty("user.dir")+"/Downloads/"+ Source +" --no-check-certificate ";

	    try {
	    Process exec = Runtime.getRuntime().exec(wget_command);
	    int exitVal = exec.waitFor(); 
	    System.out.println("Exit value: " + exitVal);
	    } catch (InterruptedException ex) {
	    System.out.println(ex.toString());
	    }
		}
	
	public void AcceptAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
		//APP_LOGS.debug("Alert is accepted");
		System.out.println("Alert is accepted");
	}
	
	
	
}
	

