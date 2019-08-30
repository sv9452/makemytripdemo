package com.makemytrip.generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.google.common.io.Files;

public class ScreenshotLib extends BaseLib {

	public static String dateformate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		return sdf.format(date);
	}

	public static void takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File filefrom = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + dateformate() + ".jpg");
		Files.copy(filefrom, dest);
	}
	 
	

}
