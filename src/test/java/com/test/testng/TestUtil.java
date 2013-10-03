package com.test.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestUtil {

	public WebDriver driver;
	public String finalFormat;

	@BeforeClass()
	public void setup() throws Exception {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@AfterClass()
	public void stopRecording() throws Exception {

		driver.quit();

	}

}
