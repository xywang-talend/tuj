package com.talend.tac.cases.esbconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestStartESBConductor extends ESBConductorUtils {

	
	@Test
	@Parameters({"labelOfService", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testStartESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		
		this.addESBConductor(label, des, repository, group, artifact, version, name, type, context, server);
		
		this.deployStartConductor(label, name, "Feature '"+name+"' deployed.",
				"idESBConductorTaskGridDeployButton", "Deployed and started");
		this.deployStartConductor(label, name, "Bundle 'jobSecondProvider' started.",
				"idESBConductorTaskGridStartButton", "Started");
		
	}
	
}
