package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.StopConductor;

public class StopESBConductorImpl extends StopConductor {

	public StopESBConductorImpl(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void addESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		this.intoESBConductorPage();
		this.addEsbConductor(label, des, repository, group, artifact, version, name, type, context, server);
	}
	
	public void deployStartConductor(String label,String name, String startPromptInfo,
			String startId,String startStatus) {
		this.deployConductor(label, name, startPromptInfo, startId, startStatus);
	}
	
	public void stopConductor(String label,String name,String stopId,
			String stopStatus, String stopPopupInfo, String StopPromptInfo) {
		this.StopDeployedConductor(label, name, stopId, stopStatus, stopPopupInfo, StopPromptInfo);
	}
	
	public void undeployStoppedConductor(String label,String name) {
		this.undeployESBConductor(label, name);
	}

}
