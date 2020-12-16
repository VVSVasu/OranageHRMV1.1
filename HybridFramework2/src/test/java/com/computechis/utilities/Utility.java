package com.computechis.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	/*
	 * Screenshot-which will return path 
	 * Sync issues - 
	 * Highlight element
	 * Datetimeutility alerts
	 */
	public static void waitTo(long seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	public static String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date d = new Date();
		return dateFormat.format(d);
	}
	public static String  getScreenshot(WebDriver driver) {
		String path = System.getProperty("user.dir")+"\\Screenshots\\HRM_"+getCurrentTime()+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture the screenshot");
		}
		return path;
	}

	public static void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public static void dismissAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public static String verifyAlertText(WebDriver driver, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent()).getText();
	}
	public static void verifyAlertPartially(WebDriver driver, String expectedAlertText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String actualAlertText =wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertTrue(actualAlertText.contains(expectedAlertText));
	}
	public static void verifyTitle(WebDriver driver,String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean status = wait.until(ExpectedConditions.titleIs(title));
		Assert.assertTrue(status);
	}

	public static void verifyContainsTitle(WebDriver driver,String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(wait.until(ExpectedConditions.titleContains(title)));
	}

	public static void verifyURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(url)));
	}
	public static void verifyURLContains(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
	}
	public static void handleFrameUsingId(WebDriver driver, String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}

	public static void handleFrameUsingName(WebDriver driver, String name) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}

	public static void handleFrameUsingElement(WebDriver driver, WebElement frameElement) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		waitTo(1);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		highLightElement(driver, element);
		return element;
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		highLightElement(driver, element);
		return element;
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator, int time, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(webElement));
		highLightElement(driver, element);
		return element;
	}
}
