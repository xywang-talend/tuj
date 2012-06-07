package com.talend.tac.cases.dbConfig;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import sun.nio.cs.ext.TIS_620;

public class TestTokenINDbConfigPage extends DbConfig {

	@Test
	public void testAddTokenForLicenseInDbCconfigPage() {

		selenium.windowMaximize();
		waitForPageReactivity();// wait and judge: if no license set,tac will
		// load directly to dbConfig page
		if (selenium.isElementPresent("idDbConfigLoginPasswordInput")) {
		} else {
			waitForElementPresent("idLoginOpenDbConfigButton", WAIT_TIME);
			selenium.click("idLoginOpenDbConfigButton");
		}
		selenium.type("idDbConfigLoginPasswordInput", "admin");
		selenium.click("idDbConfigSubmitButton");

		waitForCheckConnectionStatus("//div[text()='OK']", 5);//check status,5 OKs
		
		//wrong or invalid token
		inputWrongTokenAndCheck("wrong token");
		inputWrongTokenAndCheck("");
		inputWrongTokenAndCheck(" ");
		//try valid token
		clickWaitForElementPresent("//button[text()='Generate validation request']");
		waitForElementPresent("link=link", 30);
		selenium.click("link=link");
		selenium.selectWindow(selenium.getAllWindowNames()[1]);
		waitForElementPresent("//textarea", 20);
		selenium.setSpeed(MID_SPEED);
		String tokenTXT = selenium.getText("//textarea");
		selenium.setSpeed(MIN_SPEED);
		System.out.println(tokenTXT);
		selenium.close();
		selenium.selectWindow(null);
		waitForElementPresent("idTokenInput", WAIT_TIME);
		selenium.type("idTokenInput", tokenTXT);
		selenium.setSpeed(MID_SPEED);
		selenium.click("idEnterValidationButton");
		selenium.setSpeed(MIN_SPEED);
		this.waitForTextPresent(rb.getString("license.token.setOk"), WAIT_TIME);
		waitForCheckConnectionStatus("//div[text()='OK']", 5);

	}

	public void inputWrongTokenAndCheck(String invalidToken) {
		clickWaitForElementPresent("//button[text()='Generate validation request']");
		waitForElementPresent("idTokenInput", 30);
		selenium.type("idTokenInput", invalidToken);
		selenium.click("idEnterValidationButton");

		assertTrue(selenium.isTextPresent(rb
				.getString("license.token.prompt.error")));
	}
	@AfterTest
	public void killBrowser() {
		selenium.stop();
	}

}
