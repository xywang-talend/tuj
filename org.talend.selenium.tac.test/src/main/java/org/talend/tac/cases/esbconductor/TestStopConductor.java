package org.talend.tac.cases.esbconductor;



import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.RedefineContextImpl;
import org.talend.tac.modules.impl.StopESBConductorImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestStopConductor extends WebdriverLogin {	
	StopESBConductorImpl stopESBConductorImpl;
	RedefineContextImpl redefine;
    @BeforeMethod
    public void beforeMethod(){
    	stopESBConductorImpl = new StopESBConductorImpl(driver);
    	redefine = new RedefineContextImpl(driver);
    }
   
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
		
		stopESBConductorImpl.addESBConductor(label, des, repository, group,
				artifact, version, name, type, context, server);
		stopESBConductorImpl.deployStartConductor(label, name, startPromptInfo,
				startId, startStatus);
		stopESBConductorImpl.stopConductor(label, name, stopId, stopStatus,
				stopPopupInfo, StopPromptInfo);
	}
	
	@AfterMethod
	@Parameters({"labelOfService","name"})
	public void deleteUselessServices(String label,String name) {
		stopESBConductorImpl.undeployESBConductor(label, name);
		redefine.deleteServiceOrRoute(label);
	}
	
}
