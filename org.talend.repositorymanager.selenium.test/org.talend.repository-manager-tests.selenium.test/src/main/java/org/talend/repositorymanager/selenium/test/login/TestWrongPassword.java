package org.talend.repositorymanager.selenium.test.login;

public class TestWrongPassword extends BaseSeleniumConfig {

	public void setUp() throws Exception {
		super.setUp();
	}

	public void testWrongPassword() throws Exception {
		selenium.open(getUrl());
		selenium.type("idLoginInput", "admin@company.com");
		selenium.type("idLoginPasswordInput", "wrong_password");
		selenium.keyDown("idLoginInput", "\\13");
		selenium.keyUp("idLoginInput", "\\13");
	}

}