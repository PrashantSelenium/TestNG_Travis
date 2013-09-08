package com.test.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WelcomePage {
public WebDriver driver ;
	@BeforeClass
	public  void setUp() throws Exception {
		try {
			driver = new FirefoxDriver();
			launchingBrowser();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public  void launchingBrowser() throws Exception {
		try {
			
			String applicationURL ="http://www.google.com";
			driver.get(applicationURL);
		} catch (Exception exception) {
			exception.printStackTrace();

		}

	}

	@Test
	public void testWelcomePageScreen() throws InterruptedException,
			IOException, Exception {
		try {
				String a= null;
			Assert.assertNotNull(a);
			Thread.sleep(1000);
		} catch (Exception t) {
			t.printStackTrace();

		}
	}

	@AfterClass
	public  void tearDown() {
		driver.quit();	}

}