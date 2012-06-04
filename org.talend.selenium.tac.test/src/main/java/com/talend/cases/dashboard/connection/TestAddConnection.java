package com.talend.cases.dashboard.connection;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestAddConnection extends Connection {
	@Test
	@Parameters( { "mysqlConnectionlabel", "mysqlDbname", "mysqlDbtype",
			"mysqlHost", "mysqlServerport", "mysqlUsername",
			"mysqlPassword", "mysqlDatasourse", "mysqlAdditional",
			"mysqlStattable", "mysqlLogstable","mysqlMeterstable" })
			public void testAddConnectionMysql(String label, String dbname, String dbtype,
					String host, String serverport, String username, String password,
					String datasourse, String additional, String stat, String logs,String meters) {
				this.addConnection(label, dbname, dbtype, host, serverport, username,
						password, datasourse, additional, stat, logs,meters);
	}

	@Test
	@Parameters( { "mssqlConnectionlabel", "mssqlDbname", "mssqlDbtype",
			"mssqlHost", "mssqlServerport", "mssqlUsername",
			"mssqlPassword", "mssqlDatasourse", "mssqlAdditional",
			"mssqlStattable", "mssqlLogstable", "mssqlMeterstable" })
	public void testAddConnectionMSSQL(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		this.openConnection();
		this.addConnection(label, dbname, dbtype, host, serverport, username,
				password, datasourse, additional, stat, logs,meters);

	}
	
	@Test
	@Parameters( { "oracleConnectionlabel", "oracleDbname", "oracleDbtype",
			"oracleHost", "oracleServerport", "oracleUsername",
			"oraclePassword", "oracleDatasourse", "oracleAdditional",
			"oracleStattable", "oracleLogstable", "oracleMeterstable" })
	public void testAddConnectionOracle(String label, String dbname, String dbtype,
			String host, String serverport, String username, String password,
			String datasourse, String additional, String stat, String logs,String meters) {
		this.openConnection();
		this.addConnection(label, dbname, dbtype, host, serverport, username,
				password, datasourse, additional, stat, logs,meters);

	}
	@Test
	@Parameters( { "mysqlConnectionlabel", "mysqlDbname", "mysqlDbtype",
		"mysqlHost", "mysqlServerport", "mysqlUsername",
		"mysqlPassword", "mysqlDatasourse", "mysqlAdditional",
		"mysqlStattable", "mysqlLogstable","mysqlMeterstable" })
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
