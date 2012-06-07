package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.AddESBConductorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestEditESBConductor extends WebdriverLogin {
	AddESBConductorImpl addESBConductorImpl;
    @BeforeMethod
    public void beforeMethod(){
    	addESBConductorImpl = new AddESBConductorImpl(driver);
    }
	/*add esbconductor of service*/
	@Test
	@Parameters({"labelOfService", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testEditESBConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		addESBConductorImpl.editExsitingConductor(label, des, repository, group, artifact, version, name, type, context, server);
	}

}
