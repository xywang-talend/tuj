package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.AddESBConductorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddESBConductor extends WebdriverLogin {
	AddESBConductorImpl addESBConductorImpl;
    @BeforeMethod
    public void beforeMethod(){
    	addESBConductorImpl = new AddESBConductorImpl(driver);
    }
	/*add esbconductor of service*/
	@Test
	@Parameters({"labelOfService", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testAddESBConductorOfService(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		addESBConductorImpl.addESBConductor(label, des, repository, group, artifact, version,
				name, type, context, server);
	}
	
	/*add esbconductor with already label*/
	@Test
	@Parameters({"labelOfService", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testAddESBConductorWithAlreadyLabel(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		
		addESBConductorImpl.addESBConductorWithExistingLabel(label, des, repository, group, artifact, version,
				name, type, context, server);		
	}
	
}
