package com.makemytrip.pageobject;

import java.io.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.generic.BaseLib;
import com.makemytrip.generic.GenericLib;

public class Loginpage extends BaseLib {

	@FindBy(xpath = "//li[contains(@class,'makeFlex hrtlCenter font10 makeRelative lhUser')]")
	private WebElement tologin;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@class='capText font16']//span[contains(text(),'Login')]")
	private WebElement login;

	@FindBy(xpath = "//a[@class='mmtLogo makeFlex']//img")
	private WebElement logoverify;

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	public SearchFlightPage login() throws FileNotFoundException, IOException {
		tologin.click();
		username.click();
		username.sendKeys(GenericLib.getValue("uname"));
		password.click();
		password.sendKeys(GenericLib.getValue("pass"));
		login.click();
		return new SearchFlightPage();

	}

	public boolean verifyLogo() {
		return logoverify.isDisplayed();
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

}
