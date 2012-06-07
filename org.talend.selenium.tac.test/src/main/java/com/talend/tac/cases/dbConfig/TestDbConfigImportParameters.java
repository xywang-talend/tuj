package com.talend.tac.cases.dbConfig;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDbConfigImportParameters extends DbConfig {


	@Test
	@Parameters({"dbConfigImportParametersPath","licenseFilePath"})
	public void testDbConfigImportParameters(String dbConfigParametersPath,String license) {

		selenium.windowMaximize();
		waitForPageReactivity();// wait and judge: if no license set,tac will
		// load directly to dbConfig page
		if (selenium.isElementPresent("idDbConfigLoginPasswordInput")) {
		} else{
			waitForElementPresent("idLoginOpenDbConfigButton", WAIT_TIME);
			selenium.click("idLoginOpenDbConfigButton");
		}
		this.waitForElementPresent("idDbConfigLoginPasswordInput", WAIT_TIME);
		selenium.type("idDbConfigLoginPasswordInput", "admin");
		selenium.click("idDbConfigSubmitButton");
		waitForCheckConnectionStatus("//div[text()='OK']", 5);//check status,5 OKs
		//import parameters
		this.clickWaitForElementPresent("//button[text()='Import parameters']");
		selenium.type("Path", parseRelativePath(dbConfigParametersPath));
		this.clickWaitForElementPresent("//button[text()='Upload']");
		this.sleep(MAX_WAIT_TIME*12);
		this.waitForElementPresent("//span[text()='Import succeed.']", WAIT_TIME);
		selenium.click("//button[text()='OK']");
		selenium.click("idDbConfigCheckButton");
		this.waitForCheckConnectionStatus("//div[text()='OK']", 4);
		//upload license
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
