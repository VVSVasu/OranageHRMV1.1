package com.computechis.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.computechis.factory.BrowserFactory;
import com.computechis.factory.ConfigDataProvider;
import com.computechis.factory.DataProviderFactory;
import com.computechis.factory.ExcelReader;
import com.computechis.pages.BaseClass;
import com.computechis.pages.LoginPage;

@SuppressWarnings("unused")
public class LoginTestDDT1 extends BaseClass {
	
	
	public LoginPage lp;
	@Test
	public void login() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0),
							DataProviderFactory.getExcel().getStringData("LoginTest", 0, 1));
	}

	

	

}
