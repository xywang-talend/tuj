package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.Assert;

import com.talend.tac.cases.Login;

public class TestDuplicateServer extends Server {
	@Test
@Parameters({ "serverLablename", "portInvalidServer", "serverDescription",
			"serverHost", "serverCommondport", "serverFiletransfortport",
			"serverMonitorport", "serverTimeout", "serverUsername",
			"serverPassword" })
	public void testDuplicateServer(String lable, String invalidLable,
			String description, String host, String commondport,
			String transfortport, String monitorport, String time,
			String username, String password) throws InterruptedException {
		this.openServerMenu();
		this.duplicateServer(lable);
	}
}
