package org.talend.repositorymanager.selenium.test.login;

import com.thoughtworks.selenium.Selenium;

public class TestAdminLogin extends BaseSeleniumConfig {
	Logout logout;
	LoginAdmin login_admin;

	public TestAdminLogin() {

	}
	
	public TestAdminLogin(Selenium selenium) {
		super.selenium = selenium;
	}

	public void setUp() throws Exception {
		super.setUp();
		login_admin = new LoginAdmin(super.selenium);
		logout = new Logout(super.selenium);
	}

	public void testLogin() throws Exception {		
		login_admin.testLogin();
		selenium.waitForPageToLoad("60000");
		logout.testLogout();
	}

}