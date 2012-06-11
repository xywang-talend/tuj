package com.talend.cases.dashboard.connection;

import static org.testng.Assert.*;
import junit.framework.Assert;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class Connection extends Login {
	
	public void openConnection(){
		// check menu connection
		this.clickWaitForElementPresent("!!!menu.connections.element!!!");
		this.waitForElementPresent(
				"//div[@class='header-title' and text()='Connections']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//span[@class='x-fieldset-header-text' and text()='Database connection']",
				WAIT_TIME);
		selenium.refresh();
		this.sleep(3000);
		this.waitForElementDispear(
				"//div[@class='header-title' and text()='Connections']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//div[text()='Loading...']",
				MAX_WAIT_TIME);
	}
	public void waitForCheckConnectionStatus(int OK_Num) {
		boolean flag = false;
		int seconds_Counter = 0;
		while (flag == false) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = selenium.getXpathCount("//div[text()='OK' or contains(text(),'Ok (')]").intValue() >= OK_Num;
			seconds_Counter++;
			if (seconds_Counter >= WAIT_TIME)
				assertTrue(selenium.getXpathCount("//div[text()='OK' or contains(text(),'Ok (')]")
						.intValue() >= OK_Num);
		}

	}
	public void configConnectionParameters(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meter){
		this.waitForElementPresent("idSubModuleAddButton", 30);
		selenium.click("idSubModuleAddButton");
		this.waitForElementPresent("//span[text()='Database connection']", 30);
		// configure database parameters
		// DB label
		typeAndBlur(other.getString("inputname.id.connection.add.label"), label);
		// database server port
		typeAndBlur(other.getString("inputname.id.connection.add.port"), serverport);
		// database host
		typeAndBlur(other.getString("inputname.id.connection.add.host"), host);
		// database name
		typeAndBlur(other.getString("inputname.id.connection.add.database"), dbname);
		// database user name
		typeAndBlur(other.getString("inputname.id.connection.add.username"), username);
		// database password
		typeAndBlur(other.getString("inputname.id.connection.add.password"), password);
		// data source
		typeAndBlur(other.getString("inputname.id.connection.add.dataSource"),
				datasourse);
		// additional parameters
		typeAndBlur(other.getString("inputname.id.connection.add.additionnalParams"),
				additional);
		// database state table
		typeAndBlur(other.getString("inputname.id.connection.add.statTable"), stat);
		// database logs table
		typeAndBlur(other.getString("inputname.id.connection.add.logTable"), logs);
		typeAndBlur("idConnectionFlowMeterTableInput", meter);
		selenium.setSpeed(MID_SPEED);
		// select db type
		selenium.click(other.getString("inputname.id.connection.add.dbtype"));
		selenium.mouseDown("//div[@role='listitem'][" + dbtype + "]");
		selenium.fireEvent(other.getString("inputname.id.connection.add.dbtype"), "blur");
		selenium.click(other.getString("inputname.id.connection.add.logTable"));
		selenium.setSpeed(MIN_SPEED);
	}
	public void addConnection(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meter) {
		this.configConnectionParameters(label, dbname, dbtype, host, serverport, username, password, datasourse, additional, stat, logs, meter);
		//check connections status
		selenium.click("idCheckUrlButton");
		waitForCheckConnectionStatus(4);
		this.clickWaitForElementPresent("//span[text()='Check connection']/preceding-sibling::div//div");
		// save button
		selenium.mouseDown("idFormSaveButton");
//		selenium.keyPressNative(Event.ENTER + "");
//		selenium.keyUpNative(Event.ENTER + "");
		selenium.click("idFormSaveButton");
		selenium.mouseUp("idFormSaveButton");
		// check whether add success
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.refresh();
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ label + "')]", WAIT_TIME);
			assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ label + "')]"), "DBConnection type: "+ dbtype + " added failed!");
	}
	
	public void duplicateConnection(String connectionLabel){
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ connectionLabel + "')]", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
				+ connectionLabel + "')]");
		this.sleep(2000);
		String Username=(selenium.getValue(other
				.getString("inputname.id.connection.add.username")));
		String Password=(selenium.getValue(other
				.getString("inputname.id.connection.add.password")));
		String Host=(selenium.getValue(other
				.getString("inputname.id.connection.add.host")));
		String Port=(selenium.getValue(other
				.getString("inputname.id.connection.add.port")));
		String Dbtype=(selenium.getValue(other
				.getString("inputname.id.connection.add.dbtype")));
		String Datasource=(selenium.getValue(other
				.getString("inputname.id.connection.add.dataSource")));
		String Logs=(selenium.getValue(other
				.getString("inputname.id.connection.add.logTable")));
		String Stat=(selenium.getValue(other
				.getString("inputname.id.connection.add.statTable")));
		String Meters=(selenium.getValue("idConnectionFlowMeterTableInput"));
		selenium.click("//div[text()='Connections']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDuplicateButton']");
		selenium.mouseDown("idFormSaveButton");
//		selenium.keyPressNative(Event.ENTER + "");
//		selenium.keyUpNative(Event.ENTER + "");
		selenium.click("idFormSaveButton");
		selenium.mouseUp("idFormSaveButton");
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='Copy_of_"
				+ connectionLabel + "')]", WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='Copy_of_"
				+ connectionLabel + "')]");
		Assert.assertEquals(Username,(selenium.getValue(other
				.getString("inputname.id.connection.add.username"))));
		Assert.assertEquals(Password,(selenium.getValue(other
				.getString("inputname.id.connection.add.password"))));
		Assert.assertEquals(Host,(selenium.getValue(other
				.getString("inputname.id.connection.add.host"))));
		Assert.assertEquals(Port,(selenium.getValue(other
				.getString("inputname.id.connection.add.port"))));
		Assert.assertEquals(Dbtype,(selenium.getValue(other
				.getString("inputname.id.connection.add.dbtype"))));
		Assert.assertEquals(Datasource,(selenium.getValue(other
				.getString("inputname.id.connection.add.dataSource"))));
		Assert.assertEquals(Logs,(selenium.getValue(other
				.getString("inputname.id.connection.add.logTable"))));
		Assert.assertEquals(Stat,(selenium.getValue(other
				.getString("inputname.id.connection.add.statTable"))));
		Assert.assertEquals(Meters,(selenium.getValue("idConnectionFlowMeterTableInput")));
		
	}
	
	public void deleteConnectionCANCEL(String connectionLabel){
		String warningmessage = other.getString("delete.connetion.warning");
		//delete choose cancel
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connectionLabel + "')]", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connectionLabel + "')]");
		selenium.chooseCancelOnNextConfirmation();
//		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[text()='Connections']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
//		selenium.getConfirmation();
		Assert.assertTrue(selenium.getConfirmation().contains(warningmessage));
		this.waitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connectionLabel + "')]", WAIT_TIME);
//			Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='test_"+ label + "')]"), "delete cancel failed!");
		selenium.setSpeed(MIN_SPEED);
	}
	public void deleteConnectionOK(String connectionLabel){
		String warningmessage = other.getString("delete.connetion.warning");
		//delete choose cancel
		selenium.refresh();
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connectionLabel + "')]", Base.WAIT_TIME);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connectionLabel + "')]");
		selenium.chooseOkOnNextConfirmation();
		selenium.click("//div[text()='Connections']/ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");
//		System.out.println(selenium.getConfirmation());
		Assert.assertTrue(selenium.getConfirmation().contains(warningmessage));
		this.waitForElementDispear("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"+ connectionLabel + "')]", WAIT_TIME);
		selenium.setSpeed(MIN_SPEED);
		
	}
	
}
