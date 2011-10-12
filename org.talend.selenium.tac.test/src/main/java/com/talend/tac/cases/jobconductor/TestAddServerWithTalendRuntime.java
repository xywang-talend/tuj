package com.talend.tac.cases.jobconductor;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddServerWithTalendRuntime extends Server {

	@Test
	@Parameters({ "ServerLablename","ServerDescription",
			"ServerHost", "ServerCommondport", "ServerFiletransfortport",
			"ServerMonitorport", "ServerTimeout", "ServerUsername",
			"ServerPassword" })
	public void testAddServerWithTalendRuntime(String lable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) {
		
		this.addRuntimeServer(lable, description, host, commondport, transfortport, monitorport,
				time, username, password, "", "", "",
				"No");
		this.checkServerStatus(lable, server_status_up);
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='testRuntimeServer']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='testRuntimeServer']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
		
	}

	@Test
	@Parameters({ "ServerLablename","ServerDescription",
			"ServerHost", "ServerCommondport", "ServerFiletransfortport",
			"ServerMonitorport", "ServerTimeout", "ServerUsername",
			"ServerPassword" })
	public void testAddTalendRuntimeServerWithWrongFormatPort(String lable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) {
		
		this.addRuntimeServer(lable, description, host, commondport, transfortport, monitorport,
				time, username, password, "wrongFormatPort", "wrongFormatPort", "wrongFormatPort",
				"YES");
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Mgmt-Server port:']" +
				"//parent::div//img[@class='gwt-Image x-component ']"));
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Mgmt-Reg port:']" +
		"//parent::div//img[@class='gwt-Image x-component ']"));
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Mgmt-Server port:']" +
		"//parent::div//img[@class='gwt-Image x-component ']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='Fix errors in form before save']"));
		
	}
	

	@Test
	@Parameters({ "RuntimeServerChangeDefaultPortLablename","ServerDescription",
			"ServerHost", "ServerCommondport", "ServerFiletransfortport",
			"ServerMonitorport", "ServerTimeout", "ServerUsername",
			"ServerPassword" })
	public void testAddTalendRuntimeServerAndChangeDefaultPort(String lable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) {
		
		this.addRuntimeServer(lable, description, host, commondport, transfortport, monitorport,
				time, username, password, "6565", "6566", "6567",
				"YES");
        this.checkServerStatus(lable, server_status_up);
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='testRuntimeServer']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='testRuntimeServer']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
		
	}
	
}
