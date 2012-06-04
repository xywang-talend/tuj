package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddServer extends Server {
	@Test
	@Parameters({ "serverLablename","serverDescription",
			"serverHost", "serverCommondport", "serverFiletransfortport",
			"serverMonitorport", "serverTimeout", "serverUsername",
			"serverPassword" })
	public void testAddServerEvaluationsLocalHost(String lable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) throws InterruptedException {
        this.addServer(lable, description, host, commondport, transfortport, monitorport, time, username, password);
	    this.checkServerStatus(lable, server_status_up);
	}

	
	
}
