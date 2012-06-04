package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLinktoLinuxAndWindows extends Server {
	@Test
	@Parameters({ "remoteLinuxServerIp", "remoteWindowServerIp" })
	public void testLinkToRemoteLinux(String linuxIp, String windowsIp)
			throws InterruptedException {
		this.openServerMenu();
		this.addServer("test_RemoteLinux", "", linuxIp,
				Server.server_active_true);
		this.checkServerStatus("test_RemoteLinux", Server.server_status_up);
		this.deleteServer("test_RemoteLinux");

	}

	@Test
	@Parameters({ "remoteLinuxServerIp", "remoteWindowServerIp" })
	public void testLinkToRemoteWindows(String linuxIp, String windowsIp)
			throws InterruptedException {
		this.openServerMenu();
		this.addServer("test_RemoteWindows", "", windowsIp,
				Server.server_active_true);
		this.checkServerStatus("test_RemoteWindows", Server.server_status_up);
		this.deleteServer("test_RemoteWindows");

	}

}
