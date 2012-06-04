package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestAddServerLabelWithSpecialChar extends Server {
	@Test
	@Parameters({ "nullLabelServerHost" })
	public void testServerLabelSpecial(String host) throws InterruptedException {
		this.openServerMenu();
		this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
		Thread.sleep(3000);
		selenium.click("idSubModuleAddButton");
		Thread.sleep(3000);
		// lable
		this.typeString(other.getString("inputname.id.server.add.label"), "test_@server");
		// host
		this.typeString(other.getString("inputname.id.server.add.host"), host);
		Assert.assertTrue(selenium
				.isElementPresent("//img[@class='gwt-Image x-component ' and @role='alert']"));
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(
				selenium.isElementPresent("//div[text()='test_@server']"),
				"Test server label special  failed!");
		selenium.setSpeed(MIN_SPEED);

	}

}
