package org.talend.repositorymanager.selenium.test.login;

import com.thoughtworks.selenium.Selenium;

public class LoginAdmin extends BaseSeleniumConfig {

    public LoginAdmin(Selenium selenium) {
        super.selenium = selenium;
    } 
	
	public void testLogin() throws Exception {
		selenium.open(getUrl());
		selenium.type("idLoginInput", "admin@company.com");
		selenium.type("idLoginPasswordInput", "admin");
		selenium.keyDown("idLoginInput", "\\13");
		selenium.keyUp("idLoginInput", "\\13");		
	}

}
