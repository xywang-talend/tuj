package com.talend.tac.cases.jobconductor;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.talend.tac.cases.Login;

public class Server extends Login {
	public static String server_status_up = "UP";
	public static String server_status_down = "DOWN";
	public static String server_status_inactive = "INACTIVE";
	public static boolean server_active_true = true;
	public static boolean server_active_false = false;

	public void openServerMenu() {
		this.waitForElementPresent("!!!menu.executionServers.element!!!",
				WAIT_TIME*2);
		selenium.click("!!!menu.executionServers.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Servers']//ancestor::div[@class=' x-viewport x-component x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Execution server']",
				WAIT_TIME*2);
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Servers']", WAIT_TIME);

	}

	public void addServer(String serverLabel, String des, String host,
			boolean active) {
		this.openServerMenu();
		waitForElementPresent("idSubModuleAddButton", WAIT_TIME);
		selenium.click("idSubModuleAddButton");
		this.waitForElementPresent("//input[@name='label']//parent::div//following-sibling::img", WAIT_TIME);
		// serverLabel
		this.typeString(other.getString("inputname.id.server.add.label"),
				serverLabel);
		// description
		this.typeString(other.getString("inputname.id.server.add.description"),
				des);
		// host
		this.typeString(other.getString("inputname.id.server.add.host"), host);
		if (active == false) {
			selenium.click("//input[@class=' x-form-checkbox' and @type='checkbox' and @name='active']");
		}
		selenium.click("idFormSaveButton");
		selenium.click("//span[text()='Rate']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']//preceding-sibling::div[@class='x-panel-tbar x-panel-tbar-noheader x-panel-tbar-noborder']//button[@id='idSubModuleRefreshButton']");
		this.waitForElementPresent("//div[text()='" + serverLabel + "']",
				WAIT_TIME);
		Assert.assertTrue(
				((selenium.isElementPresent("//div[text()='" + serverLabel
						+ "']"))), "server added failed!");

	}

	public void addServer(String serverLabel, String des, String host,
			String portCommond, String portTransfer, String portMonitor,
			String timeOut, String username, String password) {
		this.openServerMenu();
		waitForElementPresent("idSubModuleAddButton", 30000);
		selenium.click("idSubModuleAddButton");
		this.sleep(3000);
		// serverLabel
		selenium.setSpeed(MIN_SPEED);
		this.typeString(other.getString("inputname.id.server.add.label"),
				serverLabel);
		// description
		this.typeString(other.getString("inputname.id.server.add.description"),
				des);
		// host
		this.typeString(other.getString("inputname.id.server.add.host"), host);
		// port1
		this.typeString(other.getString("inputname.id.server.add.commandPort"),
				portCommond);
		// port2
		this.typeString(
				other.getString("inputname.id.server.add.fileTransfertPort"),
				portTransfer);
		// port3
		this.typeString(
				other.getString("inputname.id.server.add.monitoringPort"),
				portMonitor);
		// time
		this.typeString(
				other.getString("inputname.id.server.add.timeoutUnknownState"),
				timeOut);
		// user name
		this.typeString(other.getString("inputname.id.server.add.username"),
				username);
		// pass word
		this.typeString(other.getString("inputname.id.server.add.password"),
				password);
		// save
		selenium.click("idFormSaveButton");
		this.waitForElementPresent("//div[text()='" + serverLabel + "']",
				WAIT_TIME);

	}

	public void addRuntimeServer(String serverLabel, String des, String host,
			String portCommond, String portTransfer, String portMonitor,
			String timeOut, String username, String password, String mgmtRegPort, 
			String mgmtServerPort, String adminConsolePort,
			String changePort) {
		this.openServerMenu();
		waitForElementPresent("idSubModuleAddButton", 30000);
		selenium.click("idSubModuleAddButton");
		this.sleep(3000);
		// serverLabel
		selenium.setSpeed(MIN_SPEED);
		this.typeString(other.getString("inputname.id.server.add.label"),
				serverLabel);
		// description
		this.typeString(other.getString("inputname.id.server.add.description"),
				des);
		// host
		this.typeString(other.getString("inputname.id.server.add.host"), host);
		// port1
		this.typeString(other.getString("inputname.id.server.add.commandPort"),
				portCommond);
		// port2
		this.typeString(
				other.getString("inputname.id.server.add.fileTransfertPort"),
				portTransfer);
		// port3
		this.typeString(
				other.getString("inputname.id.server.add.monitoringPort"),
				portMonitor);
		// time
		this.typeString(
				other.getString("inputname.id.server.add.timeoutUnknownState"),
				timeOut);
		// user name
		this.typeString(other.getString("inputname.id.server.add.username"),
				username);
		// pass word
		this.typeString(other.getString("inputname.id.server.add.password"),
				password);
		//check runtime
		selenium.click("idAdvanceInput");
		Assert.assertTrue(selenium.isElementPresent("//input[@id='idAdvanceInput' and @checked]"));
		this.waitForElementPresent("//input[@name='mgmtServerPort']", WAIT_TIME);
		Assert.assertTrue(selenium.isVisible("//input[@name='mgmtServerPort']"));
		Assert.assertTrue(selenium.isVisible("//input[@name='mgmtRegPort']"));
		Assert.assertTrue(selenium.isVisible("//input[@name='adminConsolePort']"));
		
		if("YES".equals(changePort)) {
			
			// mgmtServerPort
			this.typeString("//input[@name='mgmtServerPort']", mgmtServerPort);
			// mgmtRegPort
			this.typeString("//input[@name='mgmtRegPort']",mgmtRegPort);
			// adminConsolePort
			this.typeString("//input[@name='adminConsolePort']", adminConsolePort);
			
		}
		
		// save
		selenium.click("idFormSaveButton");
		this.waitForElementPresent("//div[text()='" + serverLabel + "']",
				WAIT_TIME);
        
	}
	
	public void deleteServer(String serverLabel) {
		this.waitForElementPresent("//div[text()='" + serverLabel + "']",
				WAIT_TIME);
		this.sleep(2000);
		selenium.chooseOkOnNextConfirmation();
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ serverLabel + "')]");
		selenium.click("//div[text()='Servers']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
		selenium.getConfirmation();
		this.waitForElementDispear("//div[text()='" + serverLabel + "']",
				WAIT_TIME);

	}

	public void deleteAllServersNotUsed() {

		List<String> servers = new ArrayList<String>();
		selenium.click("!!!menu.executionServers.element!!!");
		this.sleep(5000);
		servers = this.findSpecialMachedStrings(".*test_[a-zA-Z0-9]*");
		for (int i = 0; i < servers.size(); i++) {
			if (servers.get(i).startsWith("test")) {
				selenium.refresh();
				this.sleep(5000);
				selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and text()='"
						+ servers.get(i) + "']");
				this.sleep(3000);
				selenium.chooseOkOnNextConfirmation();
				selenium.click("//div[text()='Servers']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
				selenium.getConfirmation();
			}

		}
		servers = null;
		servers = this.findSpecialMachedStrings("^Copy_of_[a-zA-Z0-9_]*");
		for (int i = 0; i < servers.size(); i++) {
			if (servers.get(i).startsWith("Copy_of_")) {
				selenium.refresh();
				this.sleep(5000);
				selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and text()='"
						+ servers.get(i) + "']");
				this.sleep(3000);
				selenium.chooseOkOnNextConfirmation();
				selenium.click("//div[text()='Servers']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
				selenium.getConfirmation();
			}

		}
	}

	public void checkServerStatus(String serverLabel, String serverStatus) {
		this.waitForElementPresent("//div[text()='" + serverLabel + "']",
				WAIT_TIME);
		this.waitForElementPresent(
				"//div[text()='"
						+ serverLabel
						+ "']//ancestor::table[contains(@class,'x-grid3-row-table')]//span[contains(@class,'serv-value') and text()='"
						+ serverStatus + "']", WAIT_TIME);
	}

	public void duplicateServer(String duplicatedServername)
			throws InterruptedException {
		this.openServerMenu();
		selenium.refresh();
		this.waitForElementPresent("//div[text()='" + duplicatedServername
				+ "']", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//div[text()='" + duplicatedServername + "']");
		this.sleep(2000);
		String des = selenium.getValue(
				other.getString("inputname.id.server.add.description"))
				.toString();
		String host = selenium.getValue(
				other.getString("inputname.id.server.add.host")).toString();
		String portCommond = selenium.getValue(
				other.getString("inputname.id.server.add.commandPort"))
				.toString();
		String portTransfer = selenium.getValue(
				other.getString("inputname.id.server.add.fileTransfertPort"))
				.toString();
		String portMonitor = selenium.getValue(
				other.getString("inputname.id.server.add.monitoringPort"))
				.toString();
		String timeOut = selenium.getValue(
				other.getString("inputname.id.server.add.timeoutUnknownState"))
				.toString();
		String username = selenium.getValue(
				other.getString("inputname.id.server.add.username")).toString();
		String password = selenium.getValue(
				other.getString("inputname.id.server.add.password")).toString();
		selenium.click("//div[text()='Servers']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDuplicateButton']");
		selenium.click("idFormSaveButton");
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='Copy_of_"
						+ duplicatedServername + "')]", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='Copy_of_"
				+ duplicatedServername + "')]");
		this.sleep(2000);
		Assert.assertEquals(
				selenium.getValue(
						other.getString("inputname.id.server.add.description"))
						.toString(), des);
		Assert.assertEquals(
				selenium.getValue(
						other.getString("inputname.id.server.add.host"))
						.toString(), host);
		Assert.assertEquals(
				selenium.getValue(
						other.getString("inputname.id.server.add.commandPort"))
						.toString(), portCommond);
		Assert.assertEquals(
				selenium.getValue(
						other.getString("inputname.id.server.add.fileTransfertPort"))
						.toString(), portTransfer);
		Assert.assertEquals(
				selenium.getValue(
						other.getString("inputname.id.server.add.monitoringPort"))
						.toString(), portMonitor);
		Assert.assertEquals(
				timeOut,
				selenium.getValue(
						other.getString("inputname.id.server.add.timeoutUnknownState"))
						.toString());
		Assert.assertEquals(
				username,
				selenium.getValue(
						other.getString("inputname.id.server.add.username"))
						.toString());
		Assert.assertEquals(
				password,
				selenium.getValue(
						other.getString("inputname.id.server.add.password"))
						.toString());

	}

}
