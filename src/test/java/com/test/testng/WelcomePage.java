package com.test.testng;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomePage extends TestUtil {

	@Test
	public void testWelcomePageScreen() throws InterruptedException,
			IOException, Exception {
		String applicationURL = "http://www.google.com";
		driver.get(applicationURL);

		try {
			String a = null;
			Assert.assertNotNull(a);
			Thread.sleep(1000);
		} catch (Exception t) {
			t.printStackTrace();
		}
	}

}
