package com.talend.tac.cases.license;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.talend.tac.cases.Login;

public class TestUploadLicense extends Login {
	
	@Test
	public void testUploadNoLicense() {
		waitForElementPresent("idMenuLicenseElement", 30);
		selenium.click("idMenuLicenseElement");
		waitForElementPresent("//button[text()='Upload']", WAIT_TIME);
		selenium.click("//button[text()='Upload']");
		//assertTrue(selenium.isTextPresent("License not set: License invalid"));
	}
	
	@Test
	@Parameters( { "licenseFileInvalidPath" })
	public void testUploadInvalidLicense(String license) {
		waitForElementPresent("idMenuLicenseElement", 30);
		selenium.click("idMenuLicenseElement");
		waitForElementPresent("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", WAIT_TIME);
		selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(license));
		selenium.click("//button[text()='Upload']");
		//assertTrue(selenium.isTextPresent("License not set: License invalid"));
		
	}
	
	@Test
	@Parameters( { "licenseFilePath" })
	public void testUploadValidLicense(String license) {
		waitForElementPresent("idMenuLicenseElement", 30);
		selenium.click("idMenuLicenseElement");
		waitForElementPresent("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", WAIT_TIME);
		selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(license));
		selenium.click("//button[text()='Upload']");
		
	}
}
