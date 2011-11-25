package com.talend.tac.cases.license;

import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class AddInvalidLicense extends Login{
	@Test
	public void testAddInvalidLicense() {

		waitForElementPresent("idMenuUserElement",30);
		
		waitForElementPresent("idMenuLicenseElement", 30);
		selenium.click("idMenuLicenseElement");

		waitForElementPresent("idEditButton", 30);
		org.testng.Assert.assertTrue(selenium.isElementPresent("idEditButton"));
		selenium.click("idEditButton");

		// wrong license "abc"
		inputWrongLicenseAndCheck("abc");

		// invalid license: no license
		inputWrongLicenseAndCheck("");
		inputWrongLicenseAndCheck(null);

		// invalid license that contains " "
		inputWrongLicenseAndCheck(" ");

	}

	public void inputWrongLicenseAndCheck(String invalidLicense) {
		selenium
				.type(
						"//span[text()='Enter your license key']/following-sibling::div/input",
						invalidLicense);
		selenium.click("//button[text()= 'Ok']");// save
		org.testng.Assert
				.assertTrue(selenium
						.isElementPresent("//i[text()='License not set: License invalid']"));
		selenium.click("//button[text()= 'Ok']");
	}
}
