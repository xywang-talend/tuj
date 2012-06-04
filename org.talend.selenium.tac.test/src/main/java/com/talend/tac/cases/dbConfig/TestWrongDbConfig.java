package com.talend.tac.cases.dbConfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestWrongDbConfig extends DbConfig {

	
	@Test
	@Parameters( { "dbUrl", "dbUserName", "dbUserPassWd", "dbDriver" })
	public void testWrongDriverDbConfig(String url, String userName,
			String userPassWd, String driver) {
		this.DbConfigProcess(url, userName, userPassWd, driver);
		this.waitForElementPresent("//div[contains(text(),'Cannot instantiate')]", WAIT_TIME);
		waitForCheckConnectionStatus("//td[@align='LEFT']/img", 5);
		selenium.click("idDbConfigLogoutButton");
//		waitForElementPresent("idLoginInput", WAIT_TIME);
	}

	@Test
	@Parameters( { "dbUrl", "dbUserName", "dbUserPassWd", "dbDriver" })
	public void testWrongAccountDbConfig(String url, String userName,
			String userPassWd, String driver) {
		this.DbConfigProcess(url, userName, userPassWd, driver);
		this.waitForElementPresent("//div[contains(text(),'Wrong user name or password')]", WAIT_TIME);
		waitForCheckConnectionStatus("//td[@align='LEFT']/img", 5);
		selenium.click("idDbConfigLogoutButton");
//		waitForElementPresent("idLoginInput", WAIT_TIME);
	}

	@AfterClass
	public void killBrowser() {
		selenium.stop();	
	}

}
