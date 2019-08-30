package com.makemytrip.script;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.generic.BaseLib;
import com.makemytrip.pageobject.Loginpage;

public class LoginTest extends BaseLib {

	Loginpage lp;

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		DriverLaunch();
		lp = new Loginpage();
		lp.login();
	}

	@Test(priority = 1)
	public void verifyLogoTest() {
		Assert.assertTrue(lp.verifyLogo());
		Reporter.log("logo is verified", true);
	}

	@Test(priority = 2)
	public void validatePageTitleTest() {
		String Actualtitle = lp.validatePageTitle();
		String ExpectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday";
		Assert.assertEquals(Actualtitle, ExpectedTitle);
		Reporter.log("Title is verified", true);
	}
}
