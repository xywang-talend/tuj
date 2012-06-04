package com.talend.tac.cases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import com.talend.tac.base.Base;

public class TestLogin extends Base {

	@Test
	@Parameters( { "userName", "userPassword" })
	public void testWrongLogin(String user, String password) {
		waitForElementPresent("idLoginInput", 20);
		waitForElementPresent("idLoginPasswordInput", 20);
		selenium.windowMaximize();
		selenium.type("idLoginInput", user);
		selenium.type("idLoginPasswordInput", password);
		selenium.keyDown("idLoginPasswordInput", "\\13");
		selenium.keyUp("idLoginPasswordInput", "\\13");
		selenium.click("idLoginButton");
//		assertTrue(selenium.isTextPresent(this.getString("login.error.unknownUser", user)));// unknown user
this.waitForElementPresent("//div[text()=\"Unknown user '" + user +"'\"]", WAIT_TIME);
	}

	@Test
	@Parameters( { "userName", "userPassword" })
	public void testWrongPasswd(String user, String password) {
		waitForElementPresent("idLoginInput", 20);
		waitForElementPresent("idLoginPasswordInput", 20);
		selenium.windowMaximize();
		selenium.type("idLoginInput", user);
		selenium.type("idLoginPasswordInput", password);
		selenium.keyDown("idLoginPasswordInput", "\\13");
		selenium.keyUp("idLoginPasswordInput", "\\13");
		selenium.click("idLoginButton");
//		assertTrue(selenium.isTextPresent(rb.getString("login.error.badPassword")));// Incorrect password
this.waitForElementPresent("//div[text()='" + rb.getString("login.error.badPassword") + "']", WAIT_TIME);
	} 
	
	//login with a deactivated user
	@Test
	@Parameters( { "uncheckActiveUser", "passWord" })
	public void testDeactivatedUserLogin(String user, String password) {
		waitForElementPresent("idLoginInput", 20);
		waitForElementPresent("idLoginPasswordInput", 20);
		selenium.windowMaximize();
		selenium.type("idLoginInput", user);
		selenium.type("idLoginPasswordInput", password);
		selenium.keyDown("idLoginPasswordInput", "\\13");
		selenium.keyUp("idLoginPasswordInput", "\\13");
		selenium.click("idLoginButton");
		this.waitForElementPresent("//div[text()=\"User '" + user +"' is disabled\"]", WAIT_TIME);
}
	//login and logout to check if the "save login" works.
	@Test
	@Parameters( { "userName", "userPassword" })
	public void testSaveLoginOrNot(String user, String password) {
	
		waitForElementPresent("idLoginInput", WAIT_TIME);
		waitForElementPresent("idLoginPasswordInput", WAIT_TIME);
		waitForElementPresent("//input[@id='idLoginPasswordInput' and @checked]", WAIT_TIME);
		selenium.windowMaximize();
		
		selenium.type("idLoginInput", user);
		selenium.type("idLoginPasswordInput", password);
		selenium.keyDown("idLoginPasswordInput", "\\13");
		selenium.keyUp("idLoginPasswordInput", "\\13");
		selenium.click("idLoginButton");
		this.clickWaitForElementPresent("idLeftMenuTreeLogoutButton");
		
		waitForElementPresent("//input[@id='idLoginPasswordInput' and @checked]", WAIT_TIME);
		assertEquals(selenium.getValue("idLoginInput"), user);
//		assertEquals(selenium.getValue("idLoginPasswordInput"), password);
		selenium.click("//input[@id='idLoginPasswordInput' and @checked]");
		selenium.click("idLoginButton");
		this.clickWaitForElementPresent("idLeftMenuTreeLogoutButton");
		
		waitForElementPresent("idLoginInput", WAIT_TIME);
		assertEquals(selenium.getValue("idLoginInput"), "");
		assertEquals(selenium.getValue("idLoginPasswordInput"), "");
	}
	
	@Test
	@Parameters( { "userName", "userPassword" })
	public void testLogin(String user, String password) {
		waitForElementPresent("idLoginInput", WAIT_TIME);
		waitForElementPresent("idLoginPasswordInput", WAIT_TIME);
		selenium.windowMaximize();
		
		selenium.type("idLoginInput", user);
		selenium.type("idLoginPasswordInput", password);
		selenium.keyDown("idLoginPasswordInput", "\\13");
		selenium.keyUp("idLoginPasswordInput", "\\13");
		selenium.click("idLoginButton");

//		// wait for this HTML page fully loaded
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		selenium.setSpeed(MID_SPEED);
		if (selenium.isTextPresent("Failed to log on: user " + user
				+ " already logged on to webapp")) {
			selenium.click("idLoginForceLogoutButton");
			selenium.click("idLoginButton");
		}
		selenium.setSpeed(MIN_SPEED);
		// assertTrue(selenium.isElementPresent("idLeftMenuTreeLogoutButton"));
		this.waitForElementPresent("idLeftMenuTreeLogoutButton", WAIT_TIME);
		selenium.click("idLeftMenuTreeLogoutButton");
	}
	
	@Test
	@Parameters( { "userName", "userPassword" })
	public void testLoginWithLdapUserWhenLdapIsDisabled(String user, String password) {
		waitForElementPresent("idLoginInput", WAIT_TIME);
		waitForElementPresent("idLoginPasswordInput", WAIT_TIME);
		selenium.windowMaximize();
		selenium.type("idLoginInput", user);
		selenium.type("idLoginPasswordInput", password);
		selenium.keyDown("idLoginPasswordInput", "\\13");
		selenium.keyUp("idLoginPasswordInput", "\\13");
		selenium.click("idLoginButton");

		this.waitForElementPresent("You are using a Ldap account with non Ldap authentication.", WAIT_TIME);
	}


	@Test
	@Parameters( { "importUserName", "importPassWord" })
	public void testLoginWithImportUser(String user, String password) {
		waitForElementPresent("idLoginInput", WAIT_TIME);
		waitForElementPresent("idLoginPasswordInput", WAIT_TIME);
		selenium.windowMaximize();
		selenium.type("idLoginInput", user);
		selenium.type("idLoginPasswordInput", password);
		selenium.keyDown("idLoginPasswordInput", "\\13");
		selenium.keyUp("idLoginPasswordInput", "\\13");
		selenium.click("idLoginButton");

		this.waitForTextPresent("Welcome", WAIT_TIME);
	}


	@AfterTest
	public void logout() {
		// selenium.click("idLeftMenuTreeLogoutButton");
		selenium.stop();
	}

}
