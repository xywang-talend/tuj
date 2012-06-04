package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.Assert;

public class TestAddServerWithInvalidports extends Server {
	@Test
	@Parameters({ "portInvalidServer", "serverDescription",
			"serverHost", "serverCommondport", "serverFiletransfortport",
			"serverMonitorport", "serverTimeout", "serverUsername",
			"serverPassword" })
	public void addServerInvalid(String invalidLable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) {
		this.openServerMenu();
		this.waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
		addServerwithInvalideports(invalidLable);
		
		selenium.setSpeed(MIN_SPEED);

	}

	
	public void addServerwithInvalideports(String invalideServername) {
		selenium.click("idSubModuleAddButton");
		// lable
		this.typeString(other.getString("inputname.id.server.add.label"),
				invalideServername);
		selenium.setSpeed(MIN_SPEED);

		// description
		this.typeString(other.getString("inputname.id.server.add.description"),
				"description");

		// host
		this.typeString(other.getString("inputname.id.server.add.host"),
				"localhost");

		// port1 invalid with characters
		this.typeString(other.getString("inputname.id.server.add.commandPort"),
				"1023");

		// if the warning img present,it's true
		// Assert.assertTrue(selenium.isElementPresent(""), "");
		// port valid
		this.typeString(
				other.getString("inputname.id.server.add.fileTransfertPort"),
				"1024");
		// port invalid with characters
		this.typeString(
				other.getString("inputname.id.server.add.monitoringPort"),
				"888s");
		// count the warning images
		if (selenium.getXpathCount("//img[@class='gwt-Image x-component ' and @role='alert']").intValue() != 2) {// Xpath of warning
															// image
			Assert.fail("ports verify failed!");
		} else {
			selenium.click("idFormCancelButton");
		}
		selenium.setSpeed(MIN_SPEED);

	}
	
}
