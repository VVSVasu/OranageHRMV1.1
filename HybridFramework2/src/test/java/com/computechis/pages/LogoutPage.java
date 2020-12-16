package com.computechis.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computechis.utilities.Utility;

public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how=How.CSS, using="a#welcome") WebElement wLink;
	@FindBy(how=How.XPATH, using="//*[text()='Logout']") WebElement logoutLink;
	//By wLink = By.cssSelector("a#welcome");
	//By logLink = By.xpath("//a[text()='Logout']");
	//By logLink = By.xpath("//a[text()='Logout']");
	
	// Element action methods
	public void clickOnWelcome() {
		//driver.findElement(wLink).click();
		wLink.click();
	}
	public void clickonLogout() {
		//driver.findElement(logLink).click();
		logoutLink.click();
	}
	public void logoutFromTheApplicaion() {
		Utility.highLightElement(driver, wLink);
		wLink.click();
		Utility.waitTo(2);
		Utility.highLightElement(driver, logoutLink);
		logoutLink.click();
		//driver.findElement(wLink).click();
		//driver.findElement(logLink).click();
	}

}
