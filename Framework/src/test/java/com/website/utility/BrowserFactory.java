package com.website.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String baseURL, String browserName ) {
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/home/appventurez/Documents/seljars/chromedriver");
			driver = new ChromeDriver();
		
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/appventurez/Documents/seljars/geckodriver");
			driver = new FirefoxDriver();
		}	
		else {
			System.out.println("The browser is not suported by this system");
		}
	
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
}
