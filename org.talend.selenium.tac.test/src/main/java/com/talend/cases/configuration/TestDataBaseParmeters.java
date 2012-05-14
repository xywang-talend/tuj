package com.talend.cases.configuration;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestDataBaseParmeters extends Login {
   
	public String getDataBaseInfoInConfigurationPage(String itemName) {
		
		this.waitForElementPresent("//div[contains(text(),'Database')]//parent::div" +
				"//following-sibling::div//div[text()='"+itemName+"']//parent::td//following-sibling::td//div[contains" +
				"(@class,'x-grid3-cell-inner x-grid3-col-value')]", WAIT_TIME);
		String infoActualResults = selenium.getText("//div[contains(text(),'Database')]//parent::div" +
				"//following-sibling::div//div[text()='"+itemName+"']//parent::td//following-sibling::td//div[contains" +
				"(@class,'x-grid3-cell-inner x-grid3-col-value')]");
		System.out.println(infoActualResults);
		return infoActualResults;
		
	}
	   
	public String getDataBaseInfoInDatabaseConfigurationPage(String itemName) {
		
		this.waitForElementPresent("idDbConfig"+itemName+"Input", WAIT_TIME);
		String infoExpectResults = selenium.getValue("idDbConfig"+itemName+"Input");
		System.out.println(infoExpectResults);
		return infoExpectResults;
		
	}
	
	//check database info in configuration page
	@Test
	public void testCheckInfoOfDatabaseInConfigurationPage() {
		
		this.clickWaitForElementPresent("idMenuConfigElement");
		
		this.waitForElementPresent("//div[contains(text(),'Database')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'Database')]");
		
		String urlActualResult = this.getDataBaseInfoInConfigurationPage("Url");
		String userNameActualResult = this.getDataBaseInfoInConfigurationPage("User");
		String driverActualResult = this.getDataBaseInfoInConfigurationPage("Driver");
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idLeftMenuTreeLogoutButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.clickWaitForElementPresent("idLoginOpenDbConfigButton");	
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Database configuration') and @class='header-title']"));		
		selenium.setSpeed(MIN_SPEED);
		
        if(selenium.isTextPresent("This page is protected by a password:")) {
        	
        	selenium.type("idDbConfigLoginPasswordInput", "admin");
        	selenium.click("idDbConfigSubmitButton");
        	
        }
		 
		String urlExpectResult = this.getDataBaseInfoInDatabaseConfigurationPage("Url");
		String userNameExpectResult = this.getDataBaseInfoInDatabaseConfigurationPage("UserNme");
		String driverExpectResult = this.getDataBaseInfoInDatabaseConfigurationPage("Driver");
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idDbConfigLogoutButton"); 
		Assert.assertTrue(selenium.isElementPresent("idLoginButton"));
		selenium.setSpeed(MIN_SPEED);							
		
		selenium.click("idLoginButton");
		
		this.waitForElementPresent("idLeftMenuTreeLogoutButton", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("idLeftMenuTreeLogoutButton"));
		
		Assert.assertEquals(urlExpectResult, urlActualResult);
		Assert.assertEquals(userNameExpectResult, userNameActualResult);
		Assert.assertEquals(driverActualResult, driverExpectResult);
		
		
		this.logout();
		
	}
	

	//Access H2 console from configuration page
	@Parameters({"url", "root",  "userName", "userPassword" })
	@Test
	public void testAccessH2ConsoleFromConfigurationPage(String url, String root, String user, String password) {
		
        this.clickWaitForElementPresent("idMenuConfigElement");
		
		this.waitForElementPresent("//div[contains(text(),'Database')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'Database')]");
		
		String tacUrl = this.setDefaultValue("http://localhost:8080/", System.getProperty("tomcat.url"), url) + this.setDefaultValue(root, "/org.talend.administrator");
		
		this.waitForTextPresent(tacUrl + "/h2console", WAIT_TIME);
		selenium.open(tacUrl + "/h2console");

		this.waitForElementPresent("login", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//a[text()='Preferences']"));
		Assert.assertTrue(selenium.isElementPresent("//a[text()='Tools']"));
		Assert.assertTrue(selenium.isElementPresent("//a[text()='Help']"));
		Assert.assertTrue(selenium.isElementPresent("//th[text()='Login']"));		
	}
	
	@Override
	public void logout() {
	}
}
