package com.ajiu.shuoshuo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

	public WebDriver getDriver(String chromedriver) {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		co.addArguments("no-sandbox");
//		co.addArguments("--disable-gpu");
//		co.addArguments("window-size=1024,768");
//		co.addArguments("incognito");
	    System.setProperty("webdriver.chrome.driver", chromedriver);
		WebDriver driver = new ChromeDriver(co);
		return driver;
	}
	public void closeDriver(WebDriver driver) {
		driver.close();
	}
	public void quitDriver(WebDriver driver) {
		driver.quit();
	}
	
}
