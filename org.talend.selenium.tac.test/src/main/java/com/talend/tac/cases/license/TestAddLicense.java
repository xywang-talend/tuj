package com.talend.tac.cases.license;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.talend.tac.cases.Login;

public class TestAddLicense extends Login {
	@Test(enabled=false,description="this case is out of date since 4.2")
	@Parameters( { "license" })
	public void testAddLicense(String license) {

		/*
		 * if there is no license, there will be an popup with No license
		 * available, please input your valid license or No license available,
		 * please input your valid license,just need to click "Ok".
		 */
		waitForElementPresent("idMenuUserElement", 30);
		selenium.click("idMenuUserElement");
		if (selenium.isElementPresent("//button[text()='Ok']")) {
			selenium.click("//button[text()='Ok']");
			waitForElementPresent("idMenuLicenseElement", 30);
			selenium.click("idMenuLicenseElement");
			selenium.mouseDown("idMenuLicenseElement");
			selenium.mouseUp("idMenuLicenseElement");
			waitForElementPresent("idEditButton", 30);
			assertTrue(selenium.isElementPresent("idEditButton"));
			selenium.click("idEditButton");
			selenium.type("//span[text()='Enter your license key']/following-sibling::div/input",
							license);
			selenium.click("//button[text()= 'Ok']");
			assertFalse(selenium.isElementPresent("//button[text()= 'Ok']"));
		} else {
			System.out.println("there is aready an invalid license");
		}
		// check again if the license set correctly (click user menu)
		selenium.click("idMenuUserElement");
		assertFalse(selenium.isElementPresent("//button[text()='Ok']"));
	}
}
