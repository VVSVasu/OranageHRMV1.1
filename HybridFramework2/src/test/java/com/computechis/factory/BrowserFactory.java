package com.computechis.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	
	public static WebDriver startApplication(String url, String browserName) {
		WebDriver driver = null;
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\DriverExes\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addArguments("--disable-notifications");
			//options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\DriverExes\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\DriverExes\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeApplication(WebDriver driver) {
		driver.quit();
	}

}
