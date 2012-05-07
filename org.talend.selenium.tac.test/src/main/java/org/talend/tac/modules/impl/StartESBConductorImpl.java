package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.StartESBConductor;

public class StartESBConductorImpl extends StartESBConductor{

	public StartESBConductorImpl(WebDriver dirver) {
		super(dirver);
		this.driver=dirver;
	}
	public void addESBConductor(String label, String des, String repository,
				String group, String artifact, String version, String name, String type, 
				String context, String server) {
		this.intoESBConductorPage();
		this.addEsbConductor(label, des, repository, group, artifact, version, name, type, context, server);		 
	}
	
	public void deployAddedConductor(String label, String name, String deployPromptInfo,
			String deployId, String deployStatus) {
		this.deployStartConductor(label, name, deployPromptInfo, deployId, deployStatus);		
	}
	
	public void startDeployedConductor(String label,String name, String startPromptInfo,
			String startId,String startStatus) {
		this.deployStartConductor(label, name, startPromptInfo, startId, startStatus);
	}
	
	public void undeployStartedConductor(String label,String name) {
		this.undeployESBConductor(label, name);
		
	}

}
