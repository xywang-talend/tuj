package com.talend.tac.cases.license;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.talend.tac.cases.Login;

public class TestAddTokenForLicense extends Login {
	@Test
	public void testAddTokenForLicense() {
		waitForElementPresent("idMenuLicenseElement", 30);
		assertTrue(selenium.isElementPresent("idMenuLicenseElement"));
		selenium.click("idMenuLicenseElement");
		selenium.mouseDown("idMenuLicenseElement");
		selenium.mouseUp("idMenuLicenseElement");
		waitForElementPresent("idGenerateButton", 30);
		selenium.click("idGenerateButton");
		waitForElementPresent("link=link", 30);
		selenium.click("link=link");
		// selenium.waitForPageToLoad("3000");
		selenium.selectWindow(selenium.getAllWindowNames()[1]);
		waitForElementPresent("//textarea", 20);
		String tokenTXT = selenium.getText("//textarea");
		selenium.close();
		selenium.selectWindow(null);
		assertTrue(selenium.isElementPresent("idLeftMenuTreeLogoutButton"));
		selenium.type("idTokenInput", tokenTXT);
		selenium.click("idEnterValidationButton");
//		assertTrue(selenium.isTextPresent("New validation token set"));

	}
}
