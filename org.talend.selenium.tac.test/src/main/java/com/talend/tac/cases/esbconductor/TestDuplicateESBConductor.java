package com.talend.tac.cases.esbconductor;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDuplicateESBConductor extends ESBConductorUtils {
   
	/*add esbconductor of service*/
	@Test
	@Parameters({"labelOfService", "desOfService", "repository", "group", "artifact",
		"version", "name", "type", "context", "serverOfRuntime"})
	public void testDuplicateESBConductorOfService(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		this.intoESBConductorPage();
		String labelAfterCopy = "Copy_of_"+label;
		this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+label+"']");
		this.sleep(2000);
		selenium.click("idESBConductorTaskGridDuplicateButton");
		this.sleep(2000);
		Assert.assertTrue(selenium.getValue("idESBConductorTasklabelInput").toString().equals(labelAfterCopy));
		selenium.click("idFormSaveButton");
		this.waitForElementPresent("//div[text()='"+labelAfterCopy+"']", WAIT_TIME);
		this.waitForElementPresent("//div[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+labelAfterCopy+"']");
		this.sleep(2000);
		Assert.assertTrue(selenium.getValue("idESBConductorTasklabelInput").toString().equals(labelAfterCopy));
		Assert.assertTrue(selenium.getValue("idESBConductorTaskdesInput").toString().equals(des));
		Assert.assertTrue(selenium.getValue("idTaskProjectListBox").toString().equals(name));
		Assert.assertTrue(selenium.getValue("idJobConductorExecutionServerListBox").toString().equals(type));
		Assert.assertTrue(selenium.getValue("idESBConductorTaskVersionInput").toString().equals(version));
		Assert.assertTrue(selenium.getValue("idESBConductorTaskContextListBox").toString().equals(context));
		Assert.assertTrue(selenium.getValue("//input[@name='repositoryName']").toString().equals(repository));
		
		
	}
	
}
