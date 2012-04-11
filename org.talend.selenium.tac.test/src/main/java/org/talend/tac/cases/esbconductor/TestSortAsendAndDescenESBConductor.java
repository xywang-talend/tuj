package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.GroupByESBConductorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSortAsendAndDescenESBConductor extends WebdriverLogin {
	GroupByESBConductorImpl groupByESBConductorImpl;
    @BeforeMethod
    public void beforeMethod(){
    	groupByESBConductorImpl = new GroupByESBConductorImpl(driver);
    }
	
	
	
	/*add esbconductor of service*/
	@Test
	@Parameters({"labelOfService_1","labelOfService_2","labelOfService_3", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime","tag_1","tag_2"})
	public void testSortESBConductor(String label1,String label2,String label3, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server,String tagA, String tagB) {
		groupByESBConductorImpl.addESBConductors(label1, des, repository, group, artifact, version,
				name, type, context, server,tagA,0);
		groupByESBConductorImpl.addESBConductors(label2, des, repository, group, artifact, version, 
				name, type, context, server, tagB, 0);
		groupByESBConductorImpl.addESBConductors(label3, des, repository, group, artifact, version,
				name, type, context, server, tagB, 0);
		groupByESBConductorImpl.SortESBConductor(label3, label1);
	}

}
