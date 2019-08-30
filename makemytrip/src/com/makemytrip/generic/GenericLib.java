package com.makemytrip.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class GenericLib extends BaseLib {

	public static String getValue(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(new File("./Config.properties")));
		return p.getProperty(key);
	}

	public static void selectdate(int month, String day) {
		boolean flag = false;
		String departureday = day;

		for (int row = 1; row <= 5; row++) {
			for (int cell = 1; cell <= 7; cell++) {
				String dateval = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[" + month
						+ "]/div[3]/div[" + row + "]/div[" + cell + "]")).getText();
				dateval = dateval.replaceAll("[\\D]", "");

				if (dateval.length() == 1) {
					dateval = dateval.substring(0, 1);
					if (dateval.equals(departureday)) {
						driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[" + month + "]/div[3]/div["
								+ row + "]/div[" + cell + "]")).click();
						flag = true;
						break;
					}
				}

				if (dateval.length() > 1) {
					dateval = dateval.substring(0, 2);
					if (dateval.equals(departureday)) {
						driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[" + month + "]/div[3]/div["
								+ row + "]/div[" + cell + "]")).click();
						flag = true;
						break;
					}
				}
			}

			if (flag) {
				break;
			}
		}
	}

}
