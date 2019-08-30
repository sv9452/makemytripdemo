package com.makemytrip.script;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.generic.BaseLib;
import com.makemytrip.pageobject.ConfirmFlightPage;
import com.makemytrip.pageobject.Loginpage;
import com.makemytrip.pageobject.SearchFlightPage;

public class ConfirmFlightTest extends BaseLib {
	ConfirmFlightPage cf;
	SearchFlightPage sf;
    
	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException, Exception {
		DriverLaunch();
		Loginpage lp = new Loginpage();
		sf=lp.login();
		Thread.sleep(8000);
		cf = sf.searchFlight();
	}

	@Test(priority=1,enabled=true)
	public void selectFligthwithlowestpriceTest() throws InterruptedException {
		Thread.sleep(8000);
		cf.selectFligthwithlowestprice();
		Thread.sleep(5000);
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		java.util.Set handle=driver.getWindowHandles();
		Iterator itr=handle.iterator();
		String str1=(String)itr.next();
		String str2=(String)itr.next();
		driver.switchTo().window(str2);
		validateConfirmFlightpageTest();
		((JavascriptExecutor)driver).executeScript("scroll(0,600)");
		Thread.sleep(4000);
		continueToBookingTest();
		}
	
    @Test(priority=2,enabled=false)
	public void validateConfirmFlightpageTest() {
		String Actual = cf.validateConfirmFlightpage();
		String Expected = "CONTINUE";
		Assert.assertEquals(Expected, Actual);
	}
    
    @Test(priority=3,enabled=false)
    public void continueToBookingTest() {
    	cf.continueToBooking();
    	
    }

}
