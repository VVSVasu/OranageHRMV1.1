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
public class LoginTest extends BaseClass {
	
	
	public LoginPage lp;
	@Test
	public void login() {
		ExcelReader excel = new ExcelReader();
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(excel.getStringData("LoginTest", 0, 0),
							excel.getStringData("LoginTest", 0, 1));
	}

	

	

}
