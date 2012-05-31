package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Logon;
import org.testng.Assert;

public class LogonImpl extends Logon{
	public LogonImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void loginAdministrator(String userName,String userPassword ,String message){
		Assert.assertTrue(this.isTextPresent(locator.getString("mdm.suit.name")));
		Assert.assertTrue(this.isTextPresent(locator.getString("mdm.edition.name")));
		this.configureLogin(userName, userPassword);
		this.clickLogin();
		if(this.isTextPresent(message)) {
			this.getElementByLinkText("Force user to logout").click();
			this.configureLogin(userName, userPassword);
			this.clickLogin();
			logger.warn("Force Login MDM");
		}
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.sheet.welcome")), WAIT_TIME_MAX));
	}
	
	public void loginUserForce(String userName,String userPassword){
		Assert.assertTrue(this.isTextPresent(locator.getString("mdm.suit.name")));
		Assert.assertTrue(this.isTextPresent(locator.getString("mdm.edition.name")));
		this.configureLogin(userName, userPassword);
		this.clickLogin();
		this.sleepCertainTime(3000);
		if(this.isTextPresent(this.getString(locator, "login.user.forcelogin.message", userName))) {
			this.getElementByLinkText("Force user to logout").click();
			this.configureLogin(userName, userPassword);
			this.clickLogin();
			logger.warn("Force Login MDM");
		} 
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.sheet.welcome")), WAIT_TIME_MAX));
	}
	
	public void loginAdministratorImpl(String userName,String userPassword ,String message){
		Assert.assertTrue(this.isTextPresent(locator.getString("mdm.suit.name")));
		Assert.assertTrue(this.isTextPresent(locator.getString("mdm.edition.name")));
		this.configureLogin(userName, userPassword);
		this.clickLogin();
		if(this.isTextPresent(message)) {
			this.getElementByLinkText("Force user to logout").click();
			this.configureLogin(userName, userPassword);
			this.clickLogin();
			logger.warn("Force Login MDM");
		}
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.sheet.welcome")), WAIT_TIME_MAX));
		this.logout();
		this.killBroswer();
	}
	
	public void loginWithExistInactiveUserImpl(String inactiveName,String inactivePass,String wrongMessage){
		logger.warn("test login with wrong password .");
		this.configureLogin(inactiveName, inactivePass);
		this.clickLogin();
		this.sleepCertainTime(5000);
		this.logger.warn(wrongMessage);
	    this.acceptAlert(wrongMessage);
	    this.sleepCertainTime(5000);
		this.refreshBrowser();
	}
	
	public void loginWithWrongNamePassImpl(String wrongName,String wrongPass,String wrongMessage){
		logger.warn("test login with wrong password .");
		this.configureLogin(wrongName, wrongPass);
		this.clickLogin();
		this.sleepCertainTime(5000);
		this.logger.warn(wrongMessage);
	    Assert.assertTrue(this.isTextPresent(wrongMessage));
	    this.configureLogin("", "");
		this.clickLogin();
		this.sleepCertainTime(5000);
	    Assert.assertTrue(this.isTextPresent(wrongMessage));
	    this.killBroswer();
	}
	
	public void loginAdministratorLogoutImpl(String userName,String userPassword ,String message){
		Assert.assertTrue(this.isTextPresent(locator.getString("mdm.suit.name")));
		Assert.assertTrue(this.isTextPresent(locator.getString("mdm.edition.name")));
		this.configureLogin(userName, userPassword);
		this.clickLogin();
		if(this.isTextPresent(message)) {
			this.getElementByLinkText("Force user to logout").click();
			this.configureLogin(userName, userPassword);
		} else {
			logger.warn("Force Login MDM");
		}
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.sheet.welcome")), WAIT_TIME_MAX));
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.login.logout")), WAIT_TIME_MAX));
		this.logout();
		this.killBroswer();
	}
	
	public void loginAdministratorSessionTimeoutImpl(String userName,String userPassword ,String message,int sessionTimeout){
		this.configureLogin(userName, userPassword);
		this.sleepCertainTime(3000);
		this.clickLogin();
		if(this.isTextPresent(message)) {
			this.getElementByLinkText("Force user to logout").click();
			this.configureLogin(userName, userPassword);
		} else {
			logger.warn("Force Login MDM");
		}
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.sheet.welcome")), WAIT_TIME_MAX));
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.login.logout")), WAIT_TIME_MAX));
		this.sleepCertainTime(sessionTimeout);
	    this.clickLogout();
	    this.sleepCertainTime(5000);
	    Assert.assertTrue(this.isTextPresent(locator.getString("session.timeout.info")));
	    this.clickElementByXpath(locator.getString("xpath.login.session.timeout.button.ok"));
	    this.sleepCertainTime(5000);
	    Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.login.username")), WAIT_TIME_MAX));
		this.killBroswer();
	}
	
	public void forceQuit(){
		this.killBroswer();
	}
	
}
