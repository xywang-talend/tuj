package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.StartESBConductorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestStartESBConductor extends WebdriverLogin {
	
	StartESBConductorImpl startESBConductorImpl;
    @BeforeMethod
    public void beforeMethod(){
    	startESBConductorImpl = new StartESBConductorImpl(driver);
    }
    
	@Test
	@Parameters({"labelOfService", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testStartESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		
		String deployId = "idESBConductorTaskGridDeployButton";
		String deployStatus = "Deployed and started";
		String deployPromptInfo = "Feature '"+name+"' deployed.";
		
		String startId = "idESBConductorTaskGridStartButton";
		String startStatus = "Started";
		String startPromptInfo = "Bundle 'jobSecondProvider' started.";
		
		startESBConductorImpl.addESBConductor(label, des, repository, group, artifact, version, name, type, context, server);		
		startESBConductorImpl.deployAddedConductor(label, name, deployPromptInfo, deployId, deployStatus);		
		startESBConductorImpl.startDeployedConductor(label, name, startPromptInfo,
				startId, startStatus);
		
	}
	
	
}
