package com.computechis.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.computechis.factory.DataProviderFactory;
import com.computechis.pages.BaseClass;
import com.computechis.pages.LoginPage;
import com.computechis.pages.LogoutPage;
//import com.computechis.utilities.Utility;



public class LogoutTest extends BaseClass {
	public LoginPage lp;
	public LogoutPage lout;

	@Test(priority = 1)
	public void verifyTitle() {
		logger = report.createTest("Verify HomePage Tilte Test");
		logger.info("Veifying the current page title..");
		String expTitle="OrangeHRM";
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
//		Utility.verifyTitle(driver, driver.getTitle());
	}
	@Test(priority = 2)
	public void verifyURL() {
		logger = report.createTest("Verify HomePage URL Test");
		logger.info("Veifying the current page url..");
		/*String expTitle="https://opensource-demo.orangehrmlive.com/";
		String actTitle=driver.getCurrentUrl();
		Assert.assertEquals(expTitle, actTitle);*/
		Assert.assertEquals(driver.getCurrentUrl(), DataProviderFactory.getExcel().getStringData("Validataions", 0, 0));
	}
	@Test(priority = 3)
	public void logout() {
		logger = report.createTest("OrangeHRM LogoutTest");
		lp = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Browser and Application is up and running..");
		lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0), 
							DataProviderFactory.getExcel().getStringData("LoginTest", 0, 1));
		logger.pass("Login done successfully..");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		lout=PageFactory.initElements(driver, LogoutPage.class);
		lout.logoutFromTheApplicaion();
		logger.pass("Logout done successfully..");
	}

}
