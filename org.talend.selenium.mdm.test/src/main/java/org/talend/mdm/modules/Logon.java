package org.talend.mdm.modules;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.talend.mdm.Base;
import org.talend.mdm.Login;
import org.talend.mdm.Base.Browser;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Logon extends Base{
	
	
	
	public WebDriver initWebdriver(String url, String root, String testlinkId, String testlinkProject ,ITestContext context){
		
		System.setProperty("testlink.id", testlinkId);
		System.setProperty("testlink.porject", testlinkProject);
//		System.setProperty("webdriver.browser", "iexplore");
		
		URL file = Login.class.getClassLoader().getResource("org/talend/mdm/resources");
		PropertyConfigurator.configure( file.getPath() + "/log4j.properties" );
		
		if(null == System.getProperty("webdriver.browser") || "".equals(System.getProperty("webdriver.browser").trim()) || System.getProperty("webdriver.browser").trim().contains("webdriver.browser")) {
			driver = this.setFirefox();
		} else{
			
			try {
				driver = this.setWebDriver(Browser.valueOf(System.getProperty("webdriver.browser").trim()));
			} catch (Exception e) {
				logger.warn("Doesn't not support the browser of - " + System.getProperty("webdriver.browser").trim() + ", will use firefox!");
				driver = this.setFirefox();
			}
		}
	    driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	    logger.warn("Set Firefox Driver with Profile");
		
//		driver = new FirefoxDriver();
		logger.warn("URL - " +url + root);
		
		
		driver.get(url + root);
		super.setDriver(driver);
		windowMaximize();
		
		onTestListener(context, Login.class.getClassLoader().getResource("org/talend/mdm/download").getPath());
	return driver;
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
	
	public void killBroswer() {
		driver.quit();
		logger.warn("WebDriver Quit");
	}
	
}