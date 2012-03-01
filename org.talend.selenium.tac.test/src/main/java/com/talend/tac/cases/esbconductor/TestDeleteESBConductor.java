package com.talend.tac.cases.esbconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDeleteESBConductor extends ESBConductorUtils {
   
	
	@Test
	@Parameters({"labelOfServicetodelete", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testDeleteESBConductorOfServiceCancel(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
	this.addESBConductor(label, des, repository, group, artifact, version, name, type, context, server);
	this.deleteESBConductorCancel(label);
	}
	
	@Test
	@Parameters({"labelOfServicetodelete", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testDeleteESBConductorOfServiceOk(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
	this.deleteESBConductorOK(label, name);
	}
	
	@Test
	@Parameters({"deleteWithUndeployConductor", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testDeleteUndeployESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		
		String deployId = "idESBConductorTaskGridDeployButton";
		String status = "Deployed and started";
		String promptInfo = "Feature '"+name+"' deployed.";

		String undeployId = "idESBConductorTaskGridUndeployButton";
		String undeployStatus = "Undeployed";
		String undeployPopupInfo = "Are you sure you want to undeploy the feature '"+name+"'";
		String undeployPromptInfo = "Feature '"+name+"' undeployed.";
		
		this.addESBConductor(label, des, repository, group, artifact,
				version, name, type, context, server);
		this.deployStartConductor(label, name, promptInfo, deployId, status);
		this.undeployStopConductor(label, name, undeployId, undeployStatus,
				undeployPopupInfo, undeployPromptInfo);
		this.deleteESBConductorOK(label, name);
		
	}
	
}
