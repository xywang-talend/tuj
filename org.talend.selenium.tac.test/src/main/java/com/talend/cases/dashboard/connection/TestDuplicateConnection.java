package com.talend.cases.dashboard.connection;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class TestDuplicateConnection extends Connection {
	@Test
	@Parameters({ "mysqlConnectionlabel" })
	public void testDuplicateConnectionMysql(String label)
			throws InterruptedException {
		this.openConnection();
		this.duplicateConnection(label);
	}



}
