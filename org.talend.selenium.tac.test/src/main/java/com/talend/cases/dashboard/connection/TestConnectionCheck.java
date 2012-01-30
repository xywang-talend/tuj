package com.talend.cases.dashboard.connection;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestConnectionCheck extends Connection {
	@Test
	@Parameters( { "Mysql_Connectionlabel", "Mysql_Dbname", "Mysql_Dbtype",
			"Mysql_Host", "Mysql_Serverport", "Mysql_Username",
			"Mysql_Password", "Mysql_Datasourse", "Mysql_Additional",
			"Mysql_Stattable", "Mysql_Logstable", "Mysql_meterstable" })
	public void testCheckConnectionMysqlWithRightParamters(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		this.openConnection();
		this.configConnectionParameters(label, dbname, dbtype, host, serverport, username, password, datasourse, additional, stat, logs, meters);
		//check connections status
		selenium.click("idCheckUrlButton");
		waitForCheckConnectionStatus(4);
		this.clickWaitForElementPresent("//span[text()='Check connection']/preceding-sibling::div//div");
		
	}

	@Test
	@Parameters( { "Mysql_Connectionlabel", "Mysql_Dbname", "Mysql_Dbtype",
			"Mysql_Host", "Mysql_Serverport", "Mysql_Username",
			"Mysql_Password", "Mysql_Datasourse", "Mysql_Additional",
			"Mysql_Stattable", "Mysql_Logstable" , "Mysql_meterstable"})
	public void testConnectionCheckWithStringPort(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		serverport = "testport";
		this.openConnection();
		this.configConnectionParameters(label, dbname, dbtype, host, serverport, username, password, datasourse, additional, stat, logs, meters);
		selenium.click("idCheckUrlButton");
		Assert.assertTrue(this.waitForTextPresent("Cannot connect to database (cause Illegal connection port value '"+serverport+"')", WAIT_TIME),"check connection with string ports failed!");

	}
	
	@Test
	@Parameters( { "Mysql_Connectionlabel", "Mysql_Dbname", "Mysql_Dbtype",
			"Mysql_Host", "Mysql_Serverport", "Mysql_Username",
			"Mysql_Password", "Mysql_Datasourse", "Mysql_Additional",
			"Mysql_Stattable", "Mysql_Logstable" , "Mysql_meterstable"})
	public void testConnectionCheckWithWrongPassword(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		password = "testpass";
		this.openConnection();
		this.configConnectionParameters(label, dbname, dbtype, host, serverport, username, password, datasourse, additional, stat, logs, meters);
		selenium.click("idCheckUrlButton");
		Assert.assertTrue(this.waitForTextPresent("Cannot connect to database (cause Access denied for user", WAIT_TIME),"check connection with wrong password failed!");
	}

	@Test
	@Parameters( { "Mysql_Connectionlabel", "Mysql_Dbname", "Mysql_Dbtype",
			"Mysql_Host", "Mysql_Serverport", "Mysql_Username",
			"Mysql_Password", "Mysql_Datasourse", "Mysql_Additional",
			"Mysql_Stattable_notexist", "Mysql_Logstable" ,"Mysql_meterstable"})
	public void testConnectionCheckWithStatTableNotExist(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		
		this.openConnection();
		this.configConnectionParameters(label, dbname, dbtype, host, serverport, username, password, datasourse, additional, stat, logs, meters);
		selenium.click("idCheckUrlButton");
		waitForCheckConnectionStatus(3);
		Assert.assertTrue(this.waitForTextPresent("Table '"+dbname+"."+stat+"' doesn't exist", WAIT_TIME),"check connection with stat table not exist failed!");

	}
	
	@Test
	@Parameters( { "Mysql_Connectionlabel", "Mysql_Dbname", "Mysql_Dbtype",
			"Mysql_Host", "Mysql_Serverport", "Mysql_Username",
			"Mysql_Password", "Mysql_Datasourse", "Mysql_Additional",
			"Mysql_Stattable", "Mysql_Logstable_notexist" ,"Mysql_meterstable"})
	public void testConnectionCheckWithLogsTableNotExist(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		
		this.openConnection();
		this.configConnectionParameters(label, dbname, dbtype, host, serverport, username, password, datasourse, additional, stat, logs, meters);
		selenium.click("idCheckUrlButton");
		waitForCheckConnectionStatus(3);
		Assert.assertTrue(this.waitForTextPresent("Table '"+dbname+"."+logs+"' doesn't exist", WAIT_TIME),"check connection with logs table not exist failed!");

	}

	@Test
	@Parameters( { "Mysql_Connectionlabel", "Mysql_Dbname", "Mysql_Dbtype",
			"Mysql_Host", "Mysql_Serverport", "Mysql_Username",
			"Mysql_Password", "Mysql_Datasourse", "Mysql_Additional",
			"Mysql_Stattable", "Mysql_Logstable" ,"Mysql_meterstable_notexist"})
	public void testConnectionCheckWithMetersTableNotExist(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		
		this.openConnection();
		this.configConnectionParameters(label, dbname, dbtype, host, serverport, username, password, datasourse, additional, stat, logs, meters);
		selenium.click("idCheckUrlButton");
		waitForCheckConnectionStatus(3);
		Assert.assertTrue(this.waitForTextPresent("Table '"+dbname+"."+meters+"' doesn't exist", WAIT_TIME),"check connection with meters table not exist failed!");

	}

	
}
