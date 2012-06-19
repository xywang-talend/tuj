package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.User;
import org.testng.Assert;

public class UserImpl extends User{
    public LogonImpl log;
	public UserImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
		log = new LogonImpl(this.driver);
	}
	
	public void logoutThenloginAdministratorAndDeleteUser(String userName,String userPassword,String message,String userDelete){
		log.logout();
		log.loginAdministrator(userName, userPassword, message);
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		this.sleepCertainTime(5000);
		this.deleteUser(userDelete);
	}
	
	public void addUserImpl(String identifier,String firstName,String lastName,String password,String confirmPassword,
			String email, String company, String defaultVersion, boolean active, String[] roles){
		this.gotoUserManagePage();
		this.addUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
	}
	
	protected void addUserWithinLicenseAllowed(String roles,int n) {
		logger.warn("Start to add N users: ");
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
		logger.warn("N users added successfull! ");
	}
	
	public void addUserAllowed(String roles,int n){
		if(n!=0){
			this.gotoUserManagePage();
			this.addUserWithinLicenseAllowed(roles, n);
		}
	}
	
	public void addUserOverAllowedAdmin(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion,boolean active,String roles,int n){
		logger.warn("click administration to display menu user manage");
		logger.warn("click  menu user manage");
		this.gotoUserManagePage();
		logger.warn("user manage page opened!");
		logger.warn("user manage page opened!");
		this.clickAddNewUser();
		logger.warn("new user button clicked");
		this.configureUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, splitParameter(roles));
		this.clickSave();
		logger.warn("save new  user button clicked");
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("user.add.admin.over")), WAIT_TIME_MAX));
	}
	
	public void addUserOverAllowedWeb(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion,boolean active,String roles,int n){
		logger.warn("click administration to display menu user manage");
		logger.warn("click  menu user manage");
		this.gotoUserManagePage();
		logger.warn("user manage page opened!");
		logger.warn("user manage page opened!");
		this.clickAddNewUser();
		logger.warn("new user button clicked");
		this.configureUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, splitParameter(roles));
		this.clickSave();
		logger.warn("save new  user button clicked");
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("user.add.webuser.over")), WAIT_TIME_MAX));
	}
	
	public void addUserOverAllowedWebInactive(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion,boolean active,String roles,int n){
		logger.warn("click administration to display menu user manage");
		logger.warn("click  menu user manage");
		Assert.assertTrue(n==0, "users within license!");
		this.gotoUserManagePage();
		logger.warn("user manage page opened!");
		logger.warn("user manage page opened!");
		this.clickAddNewUser();
		logger.warn("new user button clicked");
		this.configureUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, splitParameter(roles));
	    this.clickSaveAndCheckExpectedTrue(identifier);
	    this.clickElementByXpath(this.getString(locator, "xpath.user.status", identifier));
	    Assert.assertTrue(this.getValue(this.getElementByXpath(this.getString(locator, "xpath.user.status", identifier))).equals("false"), "Inactive user "+identifier+" added failed!");
	    this.deleteUser(identifier);
	}
	
	public void addUserWithMultipleRoles(String userTest,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String[] roles){
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		this.searchUser(userTest);
		this.sleepCertainTime(5000);
		this.deleteAllUsersStartWith(userTest);
		this.sleepCertainTime(3000);
		this.searchUser("*");
		this.sleepCertainTime(5000);
		System.err.println("after delete,total user number is :"+this.getElementsByXpath(locator.getString("xpath.user.listdisplay.identiferlist")).size());
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.user.listdisplay.identiferlist")).size()==4);
		this.addUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
		this.deleteUser(identifier);
	}
	
	public void userSelectedAfterSave(String userNameAdministrator,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String[] roles){
		logger.warn("Ready to test user selected after saved succefully.");
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		logger.warn("expend administration and loged into user manage page ok.");
		logger.warn("select user administrator at first.");
		this.selectAUser(userNameAdministrator);
		logger.warn("select user administrator first ok.");
		logger.warn("configure a new user and save.");
		this.addUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
		logger.warn("configure a new user and saved ok.");
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.user.selecteduser.row", identifier)), WAIT_TIME_MAX));
		logger.warn("test user selected after saved ok ,with new user selected.");
		this.deleteUser(identifier);
		logger.warn("the new add user delete ok.");
	}
	
	public void addUserWithMultipleRolesOneAllowedAnotherNot(String userNameAdministrator,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String[] roles){
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		this.clickAddNewUser();
		this.configureUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
        this.clickSave();
        Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("user.add.admin.over")), WAIT_TIME_MAX));
	}
	
	public void addUserWithoutSelectRoles(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active){
		logger.warn("Ready to test add user without select any roles");
		this.openMenuAdministrator();
		logger.warn("open administration ok.");
		
		this.gotoUserManagePage();
		logger.warn("click user manage and log into user manage ok.");
		this.clickAddNewUser();
		logger.warn("click add new user button ok.");
		this.confBaseUserInfo(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active);
		logger.warn("configure user's information without select roles ok.");
		this.clickSave();
		logger.warn("save user  button click ok.");
        Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.user.add.user.without.roles.warning")), WAIT_TIME_MAX));
        logger.warn("test add user without select any roles ok , warning message appeared.");
	}
	
	public void addUserWithPasswordNotEqualsConfirmPassword(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String[] roles){
		logger.warn("Ready to test add user with confiugre user password not equals to confirm password.");
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		logger.warn("expend administration and loged into user manage page ok.");
		this.clickAddNewUser();
		logger.warn("click add new user button ok.");
		this.configureUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
		logger.warn("configure user information with password not equals to confirm password ok");
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.user.add.password.confirm.alert.img")), WAIT_TIME_MID));
		logger.warn("test add user with configure user password not equals to confirm password ok ,alert img appeared .");
	}
	
	public void addUserInactive(String userNameAdministrator,String userPassAdministrator,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String[] roles){
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		this.clickAddNewUser();
		this.configureUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, false, roles);
		this.clickSaveAndCheckExpectedTrue(identifier);
	    this.clickElementByXpath(this.getString(locator, "xpath.user.status", identifier));
	    Assert.assertTrue(this.getValue(this.getElementByXpath(this.getString(locator, "xpath.user.status", identifier))).equals("false"), "Inactive user "+identifier+" added failed!");
	}
	
	public void activeAnUserInactive(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String[] roles){
		this.openMenuAdministrator();
		this.gotoUserManagePage();
	    this.clickElementByXpath(this.getString(locator, "xpath.user.status", identifier));
	    Assert.assertTrue(this.getValue(this.getElementByXpath(this.getString(locator, "xpath.user.status", identifier))).equals("false"), "Inactive user "+identifier+" added failed!");
		this.clickActive();
		this.clickSave();
		this.clickFlushCacheOK();
		this.selectAUser(identifier);
		this.clickElementByXpath(this.getString(locator, "xpath.user.status", identifier));
		Assert.assertTrue(this.getValue(this.getElementByXpath(this.getString(locator, "xpath.user.status", identifier))).equals("true"), "Active user "+identifier+"  failed!");
	}
	
	public void AddUserInactiveCheckLoginThenActive(String administrator,String adminPass,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String roles) {
		this.addUserInactive(administrator, adminPass, identifier,
				firstName, lastName, password, confirmPassword, email, company,
				defaultVersion, active, splitParameter(roles));
		log.logout();
		log.loginWithExistInactiveUserImpl(identifier, password, locator
				.getString("login.exist.user.inactive.allert.message"));
		log.loginAdministrator(administrator, adminPass, locator
				.getString("login.administrator.forcelogin.message"));
		this.activeAnUserInactive(identifier, firstName, lastName,
				password, confirmPassword, email, company, defaultVersion,
				active, splitParameter(roles));
		log.logout();
		log.loginAdministrator(identifier, password, locator
				.getString("login.administrator.forcelogin.message"));
		this.logoutThenloginAdministratorAndDeleteUser(administrator, adminPass, locator.getString("login.administrator.forcelogin.message"), identifier);
	}
	
	public void flushCache(String userName,String cacheUrl){
		logger.warn("Ready to test flush cache!");
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		logger.warn("login ok and into user mange page ok.");
	    WebDriver driver2 = this.initNewDriver();
		this.openURL(driver2, cacheUrl+locator.getString("flushcache.url"));
		this.sleepCertainTime(5000);
		logger.warn("open url to check flush cache ok.");
		logger.warn("first time check without click flush cache button.");
		this.typeString(this.findElementDefineDriver(driver2, By.xpath(locator.getString("xpath.user.flushcache.urlopen.parainput"))), locator.getString("flushcache.para"));
		this.findElementDefineDriver(driver2, By.xpath(locator.getString("xpath.user.flushcache.urlopen.para.submit"))).click();
		this.sleepCertainTime(5000);
		Assert.assertTrue(driver2.findElement(By.tagName("body")).getText().contains(userName));
		logger.warn("first time checked ok ,with string administrator appear");
		logger.warn("second time ,select user adminisrator and click flush cache button");
		this.selectAUser(userName);
		this.sleepCertainTime(2000);
		this.clickFlushCacheButton();
		this.clickFlushCacheOK();
		logger.warn("second time click flush cache button ok.");
		driver2.navigate().back();
		logger.warn("driver2 controls browser back again.");
		this.typeString(this.findElementDefineDriver(driver2, By.xpath(locator.getString("xpath.user.flushcache.urlopen.parainput"))), locator.getString("flushcache.para"));
		this.findElementDefineDriver(driver2, By.xpath(locator.getString("xpath.user.flushcache.urlopen.para.submit"))).click();
		this.sleepCertainTime(5000);
		Assert.assertFalse(driver2.findElement(By.tagName("body")).getText().contains(userName));
		logger.warn("second time check with click flush cache button ok,string administraor not appeared.");
		driver2.quit();
		logger.warn("driver2 controls browser to quit.");
		
	}
	
	public void addUserWithCustomizeRoles(String administrator,String administratorPass,String identifier, String firstName, String lastName, String password, String confirmPassword, String email, String company,String defaultVersion,boolean active, String rolesCustomize,String rolesSystem){
		
		logger.warn("Ready to test add user with customized roles");
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		logger.warn("login ok and into user mange page ok.");
		this.clickAddNewUser();
		logger.warn("click add new user ok.");
		logger.warn("ready to configure new user's base infomation.");
		this.confBaseUserInfo(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active);
		logger.warn(" user's base infomation configure ok.");
		this.selectRoles(rolesCustomize);
		logger.warn("add demo roles only for user ok.");
		this.clickSave();
		logger.warn("user save button click ok.");
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.user.add.user.without.system.roles.warning")), WAIT_TIME_MAX));
		logger.warn("warning information let you to add system roles appear ok.");
		this.clickElementByXpath(locator.getString("xpath.user.add.user.without.system.roles.warning.ok"));
		this.selectRoles(rolesSystem);
		logger.warn("click ok button and select a system role for user");
		this.clickSaveAndCheckExpectedTrue(identifier);
		logger.warn("after select a system role for user and click save user button ,checked new user added ok.");
		log.logout();
		log.loginUserForce(identifier, password);
		this.logoutThenloginAdministratorAndDeleteUser(administrator, administratorPass, locator.getString("login.administrator.forcelogin.message"), identifier);
		
	}
	
	public void userLoginWithNewRole(String userNameAdministrator,String adminPass,String identifier, String firstName,String  lastName, String password, String confirmPassword, String email,String  company, String defaultVersion, boolean active, String roles){
		
		logger.warn("Ready to test user login with new role.");
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		logger.warn("expend administration and loged into user manage page ok.");
		logger.warn("configure a new user and save.");
		this.addUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
		logger.warn("configure a new user and saved ok.");
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.user.selecteduser.row", identifier)), WAIT_TIME_MAX));
		logger.warn("new user added ok,ready to check new user login.");
		log.logout();
		log.loginUserForce(identifier, password);
		logger.warn("test login with new user ok.");
		logger.warn("login administrator and delete the new user added just now.");
		this.logoutThenloginAdministratorAndDeleteUser(userNameAdministrator, adminPass, locator.getString("login.administrator.forcelogin.message"), identifier);
		logger.warn("delete the new user added ok.");
	}
	
	public void readOnlyAccessForViewer(String userNameAdministrator,String adminPass,String identifier, String firstName,String  lastName, String password, String confirmPassword, String email,String  company, String defaultVersion, boolean active, String roles,String container,String modle,String entity,String UniqueId,String Name,String Description,String Price){
		RecordImplProduct rec = new  RecordImplProduct(this.driver);
		this.openMenuAdministrator();
		this.gotoUserManagePage();
		this.addUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
		log.logout();
		log.loginUserForce(identifier, password);
		rec.chooseContainer(container);	
		rec.chooseModle(modle);
		rec.clickSave();
		rec.chooseEntity(entity);
		this.sleepCertainTime(5000);
		rec.clickCreateRecord();
		String[] parametersUniqueId={entity,UniqueId};	
		String[] parametersName={entity,Name};	
		String[] parametersDescription={entity,Description};	
		String[] parametersPrice={entity,Price};	
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersUniqueId)).isEnabled());
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersName)).isEnabled());
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersDescription)).isEnabled());
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersPrice)).isEnabled());
		this.logoutThenloginAdministratorAndDeleteUser(userNameAdministrator, adminPass, locator.getString("login.administrator.forcelogin.message"), identifier);
	}
}
