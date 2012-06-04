package com.talend.tac.cases.grid;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;


public class TestGridExecutionsAgainGenerating extends Grid {

	@Test
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testTaskRegenerating(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName) {
		this.cleanTask();
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
	    selenium.mouseDown("//span[text()='" + label + "']");
	    this.sleep(3000);
	    selenium.click("//div[contains(text(),'Conductor')]//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idJobConductorTaskGenerateButton']");
	    this.waitForTextPresent("Generating...", WAIT_TIME);
	    this.waitForElementPresent("//span[text()='Ready to deploy']", MAX_WAIT_TIME);
	    this.sleep(3000);
	    selenium.click("//div[contains(text(),'Conductor')]//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idJobConductorTaskDeployButton']");
	    Assert.assertFalse(this.waitElement("//span[text()='Generating...']", WAIT_TIME), "test failed because task was regenerated!");
	    this.waitForElementPresent("//span[text()='Ready to run']", MAX_WAIT_TIME);
	    this.deleteTask(label);
	}
	
}
