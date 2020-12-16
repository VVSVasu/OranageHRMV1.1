package com.computechis.unittest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.computechis.factory.BrowserFactory;
import com.computechis.factory.ConfigDataProvider;

public class TestBrowserFactory {
	WebDriver driver;
	@Test
	public void testBrowserLib() {
		ConfigDataProvider config = new ConfigDataProvider();
		 driver = BrowserFactory.startApplication(config.getStagingURL(), config.getBrowser());
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		 BrowserFactory.closeApplication(driver);
	}

}
