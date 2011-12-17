package org.talend.repositorymanager.selenium.test.login;


import com.thoughtworks.selenium.Selenium;

public class Logout extends BaseSeleniumConfig {

    public Logout(Selenium selenium) {
        super.selenium = selenium;
    } 
	
	public void testLogout() throws Exception {
		selenium.click("idLeftMenuTreeLogoutButton");
	}

}