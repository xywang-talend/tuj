package org.talend.mdm.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.talend.mdm.Base;
import org.testng.Assert;

public class Logon extends Base{
	public Logon(WebDriver driver) {
		super.setDriver(driver);
		this.driver = driver;
	}
	
	public void configureLogin(String userName, String userPassword) {
		WebElement userE = this.getElementByName(locator.getString("id.login.username"));
		userE.clear();
		userE.sendKeys(userName);
		WebElement passwordE = this.getElementByName(locator.getString("id.login.password"));
		passwordE.clear();
		passwordE.sendKeys(userPassword);
	}
	
    public void clickLogin(){
    	this.waitfor(By.name(locator.getString("name.login.login")), WAIT_TIME_MID);
    	Assert.assertTrue(this.isElementPresent(By.name(locator.getString("name.login.login")), WAIT_TIME_MID), "login button is not displayed right now.");
    	this.getElementByName(locator.getString("name.login.login")).click();
		logger.warn("Login MDM");
    }
    
    public void clickLogout(){
    	this.getElementByXpath(locator.getString("xpath.login.logout")).click();
    }
	
	public void logout() {
		logger.warn("Click MDM logout button");
		this.clickLogout();
		logger.warn("Logout MDM");
		Assert.assertTrue(this.isElementPresent(By.name(locator.getString("id.login.username")), WAIT_TIME_MAX));
	}
}