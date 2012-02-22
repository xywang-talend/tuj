package com.talend.tac.cases.esbconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestStopConductor extends ESBConductorUtils {
   
	@Test
	@Parameters({"labelOfService", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testStopESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		
		String startId = "idESBConductorTaskGridStartButton";
		String startStatus = "Started";
		String startPromptInfo = "Bundle 'jobSecondProvider' started.";
		
		String stopId = "idESBConductorTaskGridStopButton";
		String stopStatus = "Stopped";
		String stopPopupInfo = "Are you sure you want to stop the bundle 'jobSecondProvider'";
		String StopPromptInfo = "Bundle 'jobSecondProvider' stopped.";
		
		this.addESBConductor(label, des, repository, group, artifact,
				version, name, type, context, server);
		
		this.deployStartConductor(label, name, startPromptInfo,
				startId, startStatus);
		
		this.undeployStopConductor(label, name, stopId,
						stopStatus, stopPopupInfo, 
						StopPromptInfo);
		
	}
	
}
