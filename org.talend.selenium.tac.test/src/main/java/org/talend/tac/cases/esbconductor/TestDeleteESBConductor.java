package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.DeleteESBConductorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDeleteESBConductor extends WebdriverLogin {
	DeleteESBConductorImpl deleteESBConductorImpl;
    @BeforeMethod
    public void beforeMethod(){
    	deleteESBConductorImpl = new DeleteESBConductorImpl(driver);
    }
	
	@Test
	@Parameters({"labelOfServicetodelete", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testDeleteESBConductorOfServiceCancel(String label, String des, String repository,
	        String group, String artifact, String version, String name, String type, 
			String context, String server) {
		deleteESBConductorImpl.deleteConductorCancel(label, des, repository, group, artifact, version, name, type, context, server);

	}
	
	@Test
	@Parameters({"labelOfServicetodelete", "name"})
	public void testDeleteESBConductorOfServiceOk(String label, String name) {
		deleteESBConductorImpl.deleteConductorOk(label, name);
	}
	
	@Test
	@Parameters({"deleteWithUndeployConductor", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testDeleteUndeployESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		deleteESBConductorImpl.deleteUndeployESBConductor(label, des, repository, group, artifact, version, name, type, context, server);
				
	}
	
}
