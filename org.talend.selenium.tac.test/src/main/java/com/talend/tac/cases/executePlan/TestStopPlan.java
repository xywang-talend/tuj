package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestStopPlan extends Plan {
    
	@Test
	@Parameters({"plan.stop.task.label","labelDescription", "addCommonProjectName", "branchName",
		"jobName", "version", "context", "serverForUseAvailable",
		"statisticEnabled","plan.stop.label","plan.description"})
	public void testStopPlan(String tasklabel, String labelDescription, String commonpro,
			String branch, String jobName, String version, String context,
			String jobServer, String statistic, String planLabel, String planDescription) {
		
		/*add task*/
		this.addTask(tasklabel, labelDescription, commonpro, branch, jobName,
				version, context, jobServer, statistic);
		/*generate the task*/
	    this.generateDeployRunTask(tasklabel, "idJobConductorTaskGenerateButton");
		selenium.setSpeed(MID_SPEED);
	   	Assert.assertTrue(selenium.isTextPresent("Generating..."));
	   	selenium.setSpeed(MIN_SPEED);
	   	this.waitForElementPresent("//span[text()='Ready to deploy']", WAIT_TIME*3);
    	Assert.assertTrue(selenium.isElementPresent("//span[text()='Ready to deploy']"));
    	
    	/*add plan*/
    	this.addPlan(planLabel, tasklabel, planDescription);
    	/*run the plan*/    	
    	this.waitForElementPresent("//span[text()='"+planLabel+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+planLabel+"']");
    	this.waitForElementPresent("//span[contains(text(),'"+tasklabel+"') and @class='x-tree3-node-text']", WAIT_TIME);
    	selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader" +
		" x-panel-body-noborder x-border-layout-ct']//button[@id='idJobConductorTaskRunButton']");
    	/*stop plan*/
    	if(selenium.isElementPresent("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']" +
    			"//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]")) {
    		
    		selenium.click("//div[text()='Execution Plan']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']" +
    				"//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]");
    		
    	}    	
    	
    	selenium.chooseOkOnNextConfirmation();
    	selenium.setSpeed(MID_SPEED);
    	selenium.click("//a[text()='Stop']");
    	selenium.setSpeed(MIN_SPEED);
    	selenium.getConfirmation();
    	
    	/*check result*/
        this.waitForElementPresent("//span[text()='"+tasklabel+" : [KILLED]' and @class='x-tree3-node-text']", WAIT_TIME);
        this.waitForElementPresent("//span[text()='"+planLabel+"']//ancestor::table//span[text()='Error']", WAIT_TIME);
    	
	}
	
}
