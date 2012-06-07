package com.talend.tac.cases.welcomePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;

public class TestLoginPage extends Base {
   
	//creation the method for check login page 
	public void checkLoginPage(String licensePath, String suiteName, String appName) {
		
		selenium.windowMaximize();
		//go to db page
		if (selenium.isElementPresent("idDbConfigLoginPasswordInput")) {
		} else {
			waitForElementPresent("idLoginOpenDbConfigButton", WAIT_TIME);
			selenium.click("idLoginOpenDbConfigButton");
		}
		this.waitForElementPresent("idDbConfigLoginPasswordInput", WAIT_TIME);
		selenium.type("idDbConfigLoginPasswordInput", "admin");
		selenium.click("idDbConfigSubmitButton");
		
		//set license
		this.clickWaitForElementPresent("//button[text()='Set new license']");
		selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(licensePath));
		selenium.click("//button[text()='Upload']");
		selenium.waitForCondition("selenium.isTextPresent(\"New license set\")", WAIT_TIME*1000+"");
		clickWaitForElementPresent("//button[text()='OK']");
		
		//return to login page
		selenium.setSpeed(MID_SPEED);
		selenium.click("idDbConfigLogoutButton");
		selenium.setSpeed(MIN_SPEED);
		
		selenium.refresh();
		
		this.waitForElementPresent("//div[text()='"+suiteName+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+suiteName+"']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+appName+"']"));
		Assert.assertTrue(selenium.isElementPresent("loginVersion"));
		Assert.assertTrue(selenium.isElementPresent("//td[@class='logo']"));
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Login:']"));
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Password:']"));
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Remember me:']"));
		Assert.assertTrue(selenium.isElementPresent("idLoginInput"));
		Assert.assertTrue(selenium.isElementPresent("idLoginPasswordInput"));
		Assert.assertTrue(selenium.isElementPresent("//input[@id='idLoginPasswordInput' and @type='checkbox']"));
		Assert.assertTrue(selenium.isElementPresent("idLoginButton"));
		Assert.assertTrue(selenium.isElementPresent("idLoginOpenDbConfigButton"));
		
	}
	
	//check login page of license ESB
	@Test
	@Parameters({"licenseESB", "licenseESBSuiteName", "licenseESBAppName"})
	public void testLoginPageOfESB(String license, String suiteName, String appName) {
		
		this.checkLoginPage(license, suiteName, appName);
		
	}
	
	//check login page of license TDQ
	@Test
	@Parameters({"licenseTDQ", "licenseTDQSuiteName", "licenseTDQAppName"})
	public void testLoginPageOfTDQ(String license, String suiteName, String appName) {
		
		this.checkLoginPage(license, suiteName, appName);
		
	}
	
	//check login page of license TIS
	@Test
	@Parameters({"licenseTIS", "licenseTISSuiteName", "licenseTISAppName"})
	public void testLoginPageOfTIS(String license, String suiteName, String appName) {
		
		this.checkLoginPage(license, suiteName, appName);
		
	}
	//check login page of license MDM
	@Test
	@Parameters({"licenseMDM", "licenseMDMSuiteName", "licenseMDMAppName"})
	public void testLoginPageOfMDM(String license, String suiteName, String appName) {
		
		this.checkLoginPage(license, suiteName, appName);
		
	}
	
	//check login page of license CLOUD
	@Test
	@Parameters({"licenseCLOUD", "licenseCLOUDSuiteName", "licenseCLOUDAppName"})
	public void testLoginPageOfCLOUD(String license, String suiteName, String appName) {
		
		this.checkLoginPage(license, suiteName, appName);
		
	}
	@AfterClass
	public void killBroswer() {
		selenium.stop();
	}
	
}
