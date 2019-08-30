package com.makemytrip.pageobject;

import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.generic.BaseLib;

public class ConfirmFlightPage extends BaseLib {
	//xpath = "//div[contains(@id,'fli_list_item')]"
	@FindBy(how=How.XPATH,using="//div[contains(@id,'fli_list_item')]")
	@CacheLookup
	private java.util.List<WebElement> noofdivs;

	@FindBy(xpath = "//body/div[@id='root']/div/div[@id='root-element']/div[@id='body--wraper']/div[@id='filter--wrapper']/div[contains(@class,'')]/div[contains(@class,'fli-intl-container clearfix')]/div[@id='fli-airline-filter']/span[3]/label[1]/span[1]")
	private WebElement selectAirlines;

	@FindBy(xpath = "//button[contains(@class,'fli_primary_btn btn text-uppercase continue_cta')]")
	private WebElement validatepagebycntnubtn;
	
	
	
	public ConfirmFlightPage() {
		PageFactory.initElements(driver, this);;
	}

	public void selectFligthwithlowestprice() {

		java.util.List<String> l = new java.util.ArrayList<String>();

		selectAirlines.click();
		java.util.List<WebElement> numofdiv = noofdivs;
		int count = numofdiv.size();
		for (int i = 0; i < count; i++) {
			String str = driver
					.findElement(By.xpath("//div[contains(@id,'fli_list_item" + i + "')]//span[@class='actual-price']"))
					.getText();
			str = str.replaceAll("\\D", "");
			l.add(str);
			Collections.sort(l);

			if (i == 2) {
				break;
			}
		}
		for (int j = 0; j < count; j++) {

			String str1 = driver
					.findElement(By.xpath("//div[contains(@id,'fli_list_item" + j + "')]//span[@class='actual-price']"))
					.getText();
			str1 = str1.replaceAll("\\D", "");
			if (str1.equals(l.get(0))) {
				driver.findElement(By.xpath("//div[contains(@id,'fli_list_item" + j
						+ "')]//div[@class='pull-left price']//following-sibling::div[1]")).click();
			}
			if (j == 2) {
				break;
			}
		}

	}

	public String validateConfirmFlightpage() {
		return validatepagebycntnubtn.getText();
	}
	
	public Bookinginfo continueToBooking() {
		validatepagebycntnubtn.click();
		System.out.println("hi");
		return new Bookinginfo();
	}

}
