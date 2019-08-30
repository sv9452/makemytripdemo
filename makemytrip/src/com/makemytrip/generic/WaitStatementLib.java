package com.makemytrip.generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib extends BaseLib {
	public static By locater1;

	public static void implicit_wait(long iwt) {
		driver.manage().timeouts().implicitlyWait(iwt, TimeUnit.SECONDS);
	}

	public static void explicit_wait(int ewt, String path, By aname) {
		WebDriverWait wait = new WebDriverWait(driver, ewt);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
	}

}
