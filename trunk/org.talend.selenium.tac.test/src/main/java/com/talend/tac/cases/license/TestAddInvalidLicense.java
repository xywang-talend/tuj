package com.talend.tac.cases.license;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.talend.tac.cases.Login;

public class TestAddInvalidLicense extends Login {
	@Test(enabled=false,description="this case is out of date since 4.2")
	public void testAddInvalidLicense() {

		waitForElementPresent("idMenuLicenseElement", 30);
		assertTrue(selenium.isElementPresent("idMenuLicenseElement"));
		
		// sometimes "idEditButton" can't be found. 
		selenium.click("idMenuLicenseElement");
		selenium.mouseDown("idMenuLicenseElement");
		selenium.mouseUp("idMenuLicenseElement");
		waitForElementPresent("idEditButton", 30);
		assertTrue(selenium.isElementPresent("idEditButton"));

		// wrong license "abc"
		inputWrongLicenseAndCheck("abc");

		// invalid license: no license
		inputWrongLicenseAndCheck("");

		// invalid license that contains " " , " abc "
		inputWrongLicenseAndCheck(" ");

	}

	public void inputWrongLicenseAndCheck(String invalidLicense) {
		selenium.click("idEditButton");
		selenium
				.type(
						"//span[text()='Enter your license key']/following-sibling::div/input",
						invalidLicense);
		selenium.click("//button[text()= 'Ok']");// click save
		assertTrue(selenium.isTextPresent(rb
				.getString("license.error.invalid")));
		selenium.click("//button[text()= 'Ok']");// click 'ok' of the popup

	}
}
