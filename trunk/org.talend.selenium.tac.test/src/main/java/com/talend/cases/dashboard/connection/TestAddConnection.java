package com.talend.cases.dashboard.connection;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestAddConnection extends Connection {
	@Test
	@Parameters( { "Mysql_Connectionlabel", "Mysql_Dbname", "Mysql_Dbtype",
			"Mysql_Host", "Mysql_Serverport", "Mysql_Username",
			"Mysql_Password", "Mysql_Datasourse", "Mysql_Additional",
			"Mysql_Stattable", "Mysql_Logstable","Mysql_meterstable" })
			public void testAddConnectionMysql(String label, String dbname, String dbtype,
					String host, String serverport, String username, String password,
					String datasourse, String additional, String stat, String logs,String meters) {
				this.addConnection(label, dbname, dbtype, host, serverport, username,
						password, datasourse, additional, stat, logs,meters);
	}

	@Test
	@Parameters( { "MSSQL_Connectionlabel", "MSSQL_Dbname", "MSSQL_Dbtype",
			"MSSQL_Host", "MSSQL_Serverport", "MSSQL_Username",
			"MSSQL_Password", "MSSQL_Datasourse", "MSSQL_Additional",
			"MSSQL_Stattable", "MSSQL_Logstable", "MSSQL_meterstable" })
	public void testAddConnectionMSSQL(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		this.openConnection();
		this.addConnection(label, dbname, dbtype, host, serverport, username,
				password, datasourse, additional, stat, logs,meters);

	}
	
	@Test
	@Parameters( { "Oracle_Connectionlabel", "Oracle_Dbname", "Oracle_Dbtype",
			"Oracle_Host", "Oracle_Serverport", "Oracle_Username",
			"Oracle_Password", "Oracle_Datasourse", "Oracle_Additional",
			"Oracle_Stattable", "Oracle_Logstable", "Oracle_meterstable" })
	public void testAddConnectionOracle(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		this.openConnection();
		this.addConnection(label, dbname, dbtype, host, serverport, username,
				password, datasourse, additional, stat, logs,meters);

	}
	@Test
	@Parameters( { "Mysql_Connectionlabel", "Mysql_Dbname", "Mysql_Dbtype",
		"Mysql_Host", "Mysql_Serverport", "Mysql_Username",
		"Mysql_Password", "Mysql_Datasourse", "Mysql_Additional",
		"Mysql_Stattable", "Mysql_Logstable","Mysql_meterstable" })
	public void testDeleteConnection(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		this.openConnection();
		this.addConnection("test_"+label, dbname, dbtype, host, serverport, username,
				password, datasourse, additional, stat, logs,meters);
		this.deleteConnectionCANCEL("test_"+label);
		this.deleteConnectionOK("test_"+label);
	}

	

	
}
