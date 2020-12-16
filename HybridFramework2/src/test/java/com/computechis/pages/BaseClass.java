package com.computechis.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.computechis.factory.BrowserFactory;
import com.computechis.factory.DataProviderFactory;
import com.computechis.utilities.Utility;

@SuppressWarnings("unused")
public class BaseClass {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	String path;
	@BeforeSuite
	public void setupTestSuite() {
		path=System.getProperty("user.dir")+"\\Reports\\OrangeHRM.html";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}
	@BeforeClass
	public void setUp() {
		//ConfigDataProvider config = new ConfigDataProvider();
		driver = BrowserFactory.startApplication(DataProviderFactory.getConfig().getStagingURL(),
												DataProviderFactory.getConfig().getBrowser());
	}
	@AfterMethod
	public void tearDownTest(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test passed..");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test failed.." + result.getThrowable().getMessage());
			try {
				MediaEntityBuilder.createScreenCaptureFromPath(Utility.getScreenshot(driver)).build();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}else if(result.getStatus()==ITestResult.SKIP) {
			logger.skip("Test skipped..");
		}
		report.flush();
	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.closeApplication(driver);
		//driver.get(path);
	}
}
