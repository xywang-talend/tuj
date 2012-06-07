package com.talend.tac.cases.dbConfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDbConfig extends DbConfig {

	@Test(groups = { "initDB" })
	@Parameters( { "dbUrl", "dbUserName", "dbUserPassWd", "dbDriver",
			"licenseFilePath","licenseFileInvalidPath"})
	public void testDbConfig(String url, String userName, String userPassWd,
			String driver, String license,String invalidLicense) {

		this.DbConfigProcess(url, userName, userPassWd, driver);
		waitForCheckConnectionStatus("//div[text()='OK']",3);
		// simulate clicking ENTER to make button enabled.
		selenium.keyDown("idDbConfigDriverInput", "\\13");
		selenium.keyUp("idDbConfigDriverInput", "\\13");
		selenium.click("idDbConfigSaveButton");

		// if the parameter is saved successfully ,the save button will turn
		// gray.
		this.waitForElementPresent("//table[contains(@class,'disabled')]" +
				"//button[@id='idDbConfigSaveButton']", MAX_WAIT_TIME);
		waitForCheckConnectionStatus("//div[text()='OK']",4);
		//if no license, load the license from a file.
	
		//No license	
		selenium.click("//button[text()='Set new license']");
		selenium.click("//button[text()='Upload']");
		selenium.waitForCondition("selenium.isTextPresent(\"Invalid license key\")", WAIT_TIME*1000+"");
		clickWaitForElementPresent("//button[text()='OK']");
		this.clickWaitForElementPresent("//span[text()='New license set']/preceding-sibling::div//div");//close window
			
		//incorrect licence
		selenium.click("//button[text()='Set new license']");
		selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(invalidLicense));
		selenium.click("//button[text()='Upload']");
		selenium.waitForCondition("selenium.isTextPresent(\"Invalid license key\")", WAIT_TIME*1000+"");
		clickWaitForElementPresent("//button[text()='OK']");
		this.clickWaitForElementPresent("//span[text()='New license set']/preceding-sibling::div//div");//close window
			
		//correct licnese
		selenium.click("//button[text()='Set new license']");
		selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(license));
		selenium.click("//button[text()='Upload']");
		selenium.waitForCondition("selenium.isTextPresent(\"New license set\")", WAIT_TIME*1000+"");
		clickWaitForElementPresent("//button[text()='OK']");
		waitForCheckConnectionStatus("//div[text()='OK']",5);

		selenium.click("idDbConfigLogoutButton");
		waitForElementPresent("idLoginInput", WAIT_TIME);
	}

	@AfterClass
	public void killBrowser() {
		selenium.stop();
	}

}
