package com.makemytrip.generic;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseLib {
	public static WebDriver driver;
	static String browser;
	static String URL;
	
	
		

	public static void DriverLaunch() throws FileNotFoundException, IOException {
		
		browser=GenericLib.getValue("browsername");
		URL=GenericLib.getValue("url");
		

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./exefile/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(URL);
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./exefile/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
		}

		else if (browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.chrome.driver", "./exefile/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
		}
	}
}
