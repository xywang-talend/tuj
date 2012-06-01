package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.AddRuntimeServerWithInvalidHost;

public class AddRuntimeServerWithInvalidHostImpl extends AddRuntimeServerWithInvalidHost {
	public static String server_status_up = "UP";
	public static String server_status_down = "DOWN";
	public static String server_status_jobserverDown="INVALID :the CommandPort and FileTransferPort is misconfigured";
	
	public AddRuntimeServerWithInvalidHostImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
    
	public void addServerWithInvalidHost(String serverLabel,String invalidhost) {
		this.openServerMenu();
		this.addRuntimeServer(serverLabel,invalidhost);
		this.checkServerStatus(serverLabel,server_status_down);
		this.deleteServer(serverLabel);
	}
	
	public void addServerWithJobServerUnavaiable(String serverLabel,String host,String serviceName) {
		this.openServerMenu();
		this.uninstallService(serviceName);
		this.addRuntimeServer(serverLabel, host);
		this.checkServerStatus(serverLabel,server_status_jobserverDown);
		this.checkPortStatus();
		this.installJobServer(serviceName);
		this.deleteServer(serverLabel);
	}
	
	public void editESBRuntimeServer(String serverName) {
		this.openServerMenu();
		this.editExistingServer(serverName);
		this.verifyEditedServer(serverName);
	}
	
	public void sortESBRuntimeServers(String value, String value1) {
		this.openServerMenu();
		this.checkSortAscendingSortDescending(value, value1);
	}
	
	public void activityColumns() {
		this.openServerMenu();
		this.ActivityColumns();
	}
	
	public void duplicateServer(String label) {
		this.openServerMenu();
		this.duplicateRuntimeServer(label);
	}
	
	public void deleteUselessServers(String server1,String server2) {
		this.deleteServer(server1);
		this.deleteServer(server2);
	}
}
