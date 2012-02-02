package com.talend.tac.cases.esbconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddESBConductor extends ESBConductorUtils {
   
	/*add esbconductor of service*/
	@Test
	@Parameters({"labelOfService", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testAddESBConductorOfService(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		
		this.addESBConductor(label, des, repository, group, artifact, version,
				name, type, context, server);
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+label+"']" +
				"//ancestor::table[@class='x-grid3-row-table']//span[text()='Ready to deploy']"));
		
	}
	
}
