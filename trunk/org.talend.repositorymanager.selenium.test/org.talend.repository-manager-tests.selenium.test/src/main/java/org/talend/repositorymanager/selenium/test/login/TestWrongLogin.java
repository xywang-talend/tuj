package org.talend.repositorymanager.selenium.test.login;

public class TestWrongLogin extends BaseSeleniumConfig {

	public void testWrongLogin() throws Exception {
		selenium.open(getUrl());
		selenium.type("idLoginInput", "user@unknown-company.com");
		selenium.type("idLoginPasswordInput", "admin");
		selenium.keyDown("idLoginInput", "\\13");
		selenium.keyUp("idLoginInput", "\\13");
	}

}