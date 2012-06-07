package com.talend.tac.cases.jobconductor;

import org.testng.Assert;
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
		
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
		
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
        this.checkServerStatus(lable, server_status_down);
        
        Assert.assertFalse(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));		
		
	}
	
    /*/add runtime server,  set Mgmt-Server port/Mgmt-Reg port/Mgmt-Server port: are null
	 check prompt info*/
	@Test
	@Parameters({ "RuntimeServerChangeDefaultPortLablename","ServerDescription",
			"ServerHost", "ServerCommondport", "ServerFiletransfortport",
			"ServerMonitorport", "ServerTimeout", "ServerUsername",
			"ServerPassword" })
	public void testAddTalendRuntimeServerAndSetRuntimePortsAreNull(String lable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) {
		
		this.addRuntimeServer(lable, description, host, commondport, transfortport, monitorport,
				time, username, password, "", "", "",
				"YES");
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Mgmt-Server port:']" +
		"//parent::div//img[@class='gwt-Image x-component ']"));
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Mgmt-Reg port:']" +
		"//parent::div//img[@class='gwt-Image x-component ']"));
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Mgmt-Server port:']" +
		"//parent::div//img[@class='gwt-Image x-component ']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='Fix errors in form before save']"));
		
	}
	
	/*add runtime server of uncheck 'active'*/
	@Test
	@Parameters({ "ServerLablenameOfUncheckActive","ServerDescription",
			"ServerHost", "ServerCommondport", "ServerFiletransfortport",
			"ServerMonitorport", "ServerTimeout", "ServerUsername",
			"ServerPassword" })
	public void testAddRuntimeServerOfUncheckActive(String lable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) {
		
		this.openServerMenu();
		waitForElementPresent("idSubModuleAddButton", 30000);
		selenium.click("idSubModuleAddButton");
		this.sleep(3000);
		// serverLabel
		selenium.setSpeed(MIN_SPEED);
		this.typeString(other.getString("inputname.id.server.add.label"),
				lable);
		// description
		this.typeString(other.getString("inputname.id.server.add.description"),
				description);
		// host
		this.typeString(other.getString("inputname.id.server.add.host"), host);
		// port1
		this.typeString(other.getString("inputname.id.server.add.commandPort"),
				commondport);
		// port2
		this.typeString(
				other.getString("inputname.id.server.add.fileTransfertPort"),
				transfortport);
		// port3
		this.typeString(
				other.getString("inputname.id.server.add.monitoringPort"),
				monitorport);
		// time
		this.typeString(
				other.getString("inputname.id.server.add.timeoutUnknownState"),
				time);
		// user name
		this.typeString(other.getString("inputname.id.server.add.username"),
				username);
		// pass word
		this.typeString(other.getString("inputname.id.server.add.password"),
				password);
		//uncehck active
		selenium.click("//div[@class='x-form-check-wrap x-form-field x-component ']//input[@name='active']");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(selenium.isElementPresent("//div[contains(@class,'x-form-check-wrap x-form-field x-component')]" +
				"//input[@name='active' and @checked]"));
		//check runtime
		selenium.click("idAdvanceInput");
		Assert.assertTrue(selenium.isElementPresent("//input[@id='idAdvanceInput' and @checked]"));
		this.waitForElementPresent("//input[@name='mgmtServerPort']", WAIT_TIME);
		Assert.assertTrue(selenium.isVisible("//input[@name='mgmtServerPort']"));
		Assert.assertTrue(selenium.isVisible("//input[@name='mgmtRegPort']"));
		Assert.assertTrue(selenium.isVisible("//input[@name='adminConsolePort']"));
		// save
		selenium.click("idFormSaveButton");
		this.waitForElementPresent("//div[text()='" + lable + "']",
				WAIT_TIME);
		
		this.checkServerStatus(lable, server_status_inactive);
		
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
		" x-grid3-col-talendRuntime') and text()='Job Server']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner" +
				" x-grid3-col-talendRuntime') and text()='Talend Runtime']"));
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+lable+"']//ancestor::table[contains(@class,'x-grid3-row-table')]//button[text()='Admin server']"));
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+lable+"']//ancestor::div[@class='x-grid3-row-body']//td[@class='status-img-INACTIVE-Talend-Runtime']"));
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+lable+"']//ancestor::div[@class='x-grid3-row-body']//td//span[text()='CPU Number']//following-sibling::span[text()='null']"));
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+lable+"']//ancestor::div[@class='x-grid3-row-body']//td//td[text()='Used CPU']//following-sibling::td[2][text()='0 %']"));
	    
	}
	
}
