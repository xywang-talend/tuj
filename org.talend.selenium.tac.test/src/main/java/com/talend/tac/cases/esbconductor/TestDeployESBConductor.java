package com.talend.tac.cases.esbconductor;

import junit.framework.Assert;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDeployESBConductor extends ESBConductorUtils {
    
	@Test
	@Parameters({"labelOfService", "name"})
	public void testDeployESBConductor(String label, String name) {

		String deployId = "idESBConductorTaskGridDeployButton";
		String status = "Deployed and started";
		String promptInfo = "Feature '"+name+"' deployed.";
		
		this.intoESBConductorPage();
		
		this.deployStartConductor(label, name, promptInfo,
				deployId, status);
				
	}
	

	@Test
	@Parameters({"labelOfService", "name"})
	public void testUndeployESBConductor(String label, String name) {
		
		String undeployId = "idESBConductorTaskGridUndeployButton";
		String status = "Undeployed";
		String popupInfo = "Are you sure you want to undeploy the feature '"+name+"'";
		String promptInfo = "Feature '"+name+"' undeployed.";
		
		this.intoESBConductorPage();
		
		this.undeployStopConductor(label, name, undeployId,
				status, popupInfo, 
				promptInfo);
		Assert.assertEquals(serviceStatus, true);
						
	}
	
}
