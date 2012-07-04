package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.GroupByESBConductorImpl;
import org.talend.tac.modules.impl.RedefineContextImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSortAsendAndDescenESBConductor extends WebdriverLogin {
	GroupByESBConductorImpl groupByESBConductorImpl;
	RedefineContextImpl redefine;
    @BeforeMethod
    public void beforeMethod(){
    	groupByESBConductorImpl = new GroupByESBConductorImpl(driver);
    	redefine = new RedefineContextImpl(driver);
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
	
	@AfterMethod
	@Parameters({"labelOfService_1","labelOfService_2","labelOfService_3"})
	public void deleteUselessServices(String label1,String label2,String label3) {
		redefine.deleteServiceOrRoute(label1);
		redefine.deleteServiceOrRoute(label2);
		redefine.deleteServiceOrRoute(label3);
	}

}
