package com.makemytrip.script;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.generic.BaseLib;
import com.makemytrip.pageobject.Loginpage;
import com.makemytrip.pageobject.SearchFlightPage;
import org.testng.Assert;

public class SearchFlightTest extends BaseLib {

	Loginpage lp;
	SearchFlightPage sf;

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		DriverLaunch();
		lp = new Loginpage();
		sf = lp.login();
	}

	@Test(priority = 1)
	public void searchFlightTest() throws Exception {
		sf.searchFlight();
	}

	@Test(priority = 2)
	public void getSortBytextTest() throws InterruptedException {
		sf.searchFlight();
		String Actual = sf.getSortBytext();
		String Expected = "Sort By:";
		Assert.assertEquals(Expected, Actual);
	}

	@AfterMethod(enabled = true)
	public void tearDown() {
		driver.quit();
	}

}
