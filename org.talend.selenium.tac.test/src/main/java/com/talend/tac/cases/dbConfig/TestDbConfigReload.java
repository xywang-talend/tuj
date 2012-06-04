package com.talend.tac.cases.dbConfig;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDbConfigReload extends DbConfig {

	@Test(groups = { "initDB" })
	@Parameters( { "dbUrl", "dbUserName", "dbUserPassWd", "dbDriver",
			"licenseFilePath" })
	public void testDbConfigReload(String url, String userName, String userPassWd,
			String driver, String license) {

		this.DbConfigProcess(url, userName, userPassWd, driver);
		//check the number of xpath >=2
		waitForCheckConnectionStatus("//div[contains(text(),'Cannot instantiate')]",2);
//		waitForCheckConnectionStatus("//div[text()='OK']",2);
		waitForCheckConnectionStatus("//td[@align='LEFT']/img", 5);//tac changes, does't show "OK" if set wrong prarmeters
		selenium.click("idDbConfigReloadButton");
		waitForCheckConnectionStatus("//div[text()='OK']",5);
		selenium.click("idDbConfigLogoutButton");
		waitForElementPresent("idLoginInput", WAIT_TIME);
	}

	@AfterTest
	public void killBrowser() {
		selenium.stop();
	}

}
