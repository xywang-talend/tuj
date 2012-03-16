package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.User;
import org.testng.Assert;


public class UserImpl extends User{

	public UserImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	public void addUserImpl(String identifier,String firstName,String lastName,String password,String confirmPassword,
			String email, String company, String defaultVersion, boolean active, String[] roles){
		this.gotoUserManagePage();
		this.addUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
	}
	
	protected void addUserWithinLicenseAllowed(String roles,int n) {
		logger.info("Start to add N users: ");
		for(int i=0;i<n;i++)
		{
			String identifier="testUser"+i;
			String password="password"+i;
			String confirmPassword=password;
			String firstName="testfirstName"+i;
			String lastName="testlastName"+i;
			String email="test@email"+i+".com";
			String company="testcompany"+i;
			String defaultVersion="testdefaultVersion";
			boolean active=true;
		this.addUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
	
	}
		logger.info("N users added successfull! ");
		}
	
	
	public void addUserAllowed(String roles,int n){
		if(n!=0){
			this.gotoUserManagePage();
			this.addUserWithinLicenseAllowed(roles, n);
		}
		
	}
	
	
	public void addUserOverAllowedWeb(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion,boolean active,String roles,int n){
		logger.info("click administration to display menu user manage");
		logger.info("click  menu user manage");
		this.gotoUserManagePage();
		logger.info("user manage page opened!");
		logger.info("user manage page opened!");
		this.clickAddNewUser();
		logger.info("new user button clicked");
		this.configureUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
		this.clickSave();
		logger.info("save new  user button clicked");
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("user.add.webuser.over")), WAIT_TIME_MAX));
	}
	
	
	public void addUserOverAllowedWebInactive(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion,boolean active,String roles,int n){
		logger.info("click administration to display menu user manage");
		logger.info("click  menu user manage");
		Assert.assertTrue(n==0, "users within license!");
		this.gotoUserManagePage();
		logger.info("user manage page opened!");
		logger.info("user manage page opened!");
		this.clickAddNewUser();
		logger.info("new user button clicked");
		this.configureUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
	    this.clickSaveAndCheckExpectedTrue(identifier);
	    this.clickElementByXpath(this.getString(locator, "xpath.user.status", identifier));
	    Assert.assertTrue(this.getValue(this.getElementByXpath(this.getString(locator, "xpath.user.status", identifier))).equals("false"), "Inactive user "+identifier+" added failed!");
	}
}
