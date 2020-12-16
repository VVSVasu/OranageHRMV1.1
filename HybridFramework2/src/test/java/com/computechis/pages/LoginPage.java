package com.computechis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.computechis.utilities.Utility;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By user=By.id("txtUsername");
	By password=By.name("txtPassword");
	By loginButton=By.xpath("//input[@id='btnLogin']");
	
	public void typeUserName() {
		driver.findElement(user).sendKeys("Admin");
	}
	public void typePassword() {
		driver.findElement(password).sendKeys("admin123");
	}
	public void clickLoginBtn() {
		driver.findElement(loginButton).click();
	}
	public void loginToApplication() {
		driver.findElement(user).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(loginButton).click();
	}
	public void loginToApplication(String userName, String passwd) {
		/*driver.findElement(user).sendKeys(userName);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(loginButton).click();*/
		Utility.highLightElement(driver, driver.findElement(user));
		driver.findElement(user).sendKeys(userName);
		Utility.highLightElement(driver, driver.findElement(password));
		driver.findElement(password).sendKeys(passwd);
		Utility.highLightElement(driver, driver.findElement(loginButton));
		driver.findElement(loginButton).click();
		
	}

}
