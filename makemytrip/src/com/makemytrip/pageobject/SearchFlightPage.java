package com.makemytrip.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.generic.BaseLib;
import com.makemytrip.generic.GenericLib;

public class SearchFlightPage extends BaseLib {

	@FindBy(xpath = "//li[@class='selected']//span[@class='tabsCircle appendRight5']")
	private WebElement oneway;

	@FindBy(xpath = "//span[contains(text(),'From')]")
	private WebElement source;

	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement destination;

	@FindBy(xpath = "//div[contains(text(),'BKK')]")
	private WebElement sourcecity;

	@FindBy(xpath = "//div[contains(text(),'DEL')]")
	private WebElement destinationcity;

	@FindBy(xpath = "//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")
	private WebElement searchbtn;

	@FindBy(xpath = "//span[@class='sort-label']")
	private WebElement sortbyxpathpath;

	public SearchFlightPage() {
		PageFactory.initElements(driver, this);
	}

	public ConfirmFlightPage searchFlight() {

		oneway.click();
		source.click();
		sourcecity.click();
		destination.click();
		destinationcity.click();
		GenericLib.selectdate(2, "12");
		searchbtn.click();
		return new ConfirmFlightPage();
	}

	public String getSortBytext() {
		return (sortbyxpathpath.getText());
	}

}
