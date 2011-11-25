package com.talend.tac.cases.license;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.talend.tac.cases.Login;

public class TestAddInvalidTokenForLicense extends Login {
	@Test
	public void testAddInvalidTokenForLicense() {
		waitForElementPresent("idMenuLicenseElement", 30);
		assertTrue(selenium.isElementPresent("idMenuLicenseElement"));
		selenium.click("idMenuLicenseElement");
		selenium.mouseDown("idMenuLicenseElement");
		selenium.mouseUp("idMenuLicenseElement");
		waitForElementPresent("idGenerateButton", 30);

		inputWrongTokenAndCheck("wrong token");
		inputWrongTokenAndCheck("");
		inputWrongTokenAndCheck(" ");
		assertTrue(selenium.isElementPresent("idMenuLicenseElement"));
	}

	public void inputWrongTokenAndCheck(String invalidToken) {
		selenium.click("idGenerateButton");
		waitForElementPresent("idTokenInput", 30);
		selenium.type("idTokenInput", invalidToken);
		selenium.click("idEnterValidationButton");

		assertTrue(selenium.isTextPresent(rb
				.getString("license.token.prompt.error")));
//		selenium.click("//button[text()= 'Ok']");// click 'ok' of the popup

	}
}
