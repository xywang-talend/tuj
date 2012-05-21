package com.talend.tac.cases.dbConfig;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

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
		clickWaitForElementPresent("//button[@id='idLicenseGenerateValidButton']");
		waitForElementPresent("link=link", 30);
		selenium.click("link=link");
		selenium.selectWindow(selenium.getAllWindowNames()[1]);
		waitForElementPresent("//textarea", 20);
		String tokenTXT = selenium.getText("//textarea");
		selenium.close();
		selenium.selectWindow(null);
		waitForElementPresent("idTokenInput", WAIT_TIME);
		selenium.type("idTokenInput", tokenTXT);
		selenium.click("idEnterValidationButton");
		Assert.assertTrue(this.waitForTextPresent(rb
				.getString("license.token.setOk"), WAIT_TIME));
//		assertTrue(selenium.isTextPresent(rb
//				.getString("license.token.setOk")));
		waitForCheckConnectionStatus("//div[text()='OK']", 5);

	}

	public void inputWrongTokenAndCheck(String invalidToken) {
		clickWaitForElementPresent("//button[@id='idLicenseGenerateValidButton']");
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
