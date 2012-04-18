package org.talend.mdm.modules;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.talend.mdm.Base;
import org.talend.mdm.Login;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Logon extends Base{
	
	
	
	public void initWebdriver(String url, String root, ITestContext context){
		
		URL file = Login.class.getClassLoader().getResource("org/talend/mdm/resources");
		PropertyConfigurator.configure( file.getPath() + "/log4j.properties" );
		
	    FirefoxProfile firefoxProfile = new FirefoxProfile();
	    firefoxProfile.setPreference("browser.download.folderList",2);
	    firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
	    firefoxProfile.setPreference("browser.download.dir",Login.class.getClassLoader().getResource("org/talend/mdm/download").getPath());
	    firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
	    
	    driver = new FirefoxDriver(firefoxProfile);
	    logger.info("Set Firefox Driver with Profile");
		logger.info("URL - " +url + root);
		
		driver.get(url + root);
		super.setDriver(driver);
		windowMaximize();
		
		onTestListener(context, Login.class.getClassLoader().getResource("org/talend/mdm/download").getPath());
	}
	
	
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
		logger.info("Login MDM");
    }
    
    public void clickLogout(){
    	this.getElementByXpath(locator.getString("xpath.login.logout")).click();
    }
	
	public void logout() {
		logger.info("Click MDM logout button");
		this.clickLogout();
		logger.info("Logout MDM");
		Assert.assertTrue(this.isElementPresent(By.name(locator.getString("id.login.username")), WAIT_TIME_MAX));
	}
	
	public void killBroswer() {
		driver.quit();
		logger.info("WebDriver Quit");
	}
	
}