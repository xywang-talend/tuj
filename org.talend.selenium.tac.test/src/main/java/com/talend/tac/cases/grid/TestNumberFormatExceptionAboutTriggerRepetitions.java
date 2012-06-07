package com.talend.tac.cases.grid;



import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.talend.tac.base.Base;


public class TestNumberFormatExceptionAboutTriggerRepetitions extends Grid {


	@Test 
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testNumberFormatExceptionBigger(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName){
		this.openTaskMenu();
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
		this.waitForElementPresent("//span[text()='" + label + "']",
				Base.WAIT_TIME);
		this.sleep(2000);
		selenium.mouseDown("//span[text()='" + label + "']");
		selenium.click("idTriggerAdd trigger...");// add a trigger
		selenium.click("idTriggerAdd simple trigger");// add a SimpleTrigger
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"
				+ rb.getString("trigger.action.addSimpleTrigger") + "']"));
		this.typeString("idJobConductorSimpleTriggerLableInput", "testNumberFormate");// label
		this.typeString("idJobConductorSimpleTriggerRptCountInput",
				"1000000000000000");
		this.typeString("idJobConductorSimpleTriggerRptIntervalInput",
				"40");
		this.waitForElementPresent("//img[@role='alert' and @class='gwt-Image x-component ']", WAIT_TIME);
		selenium.click("idSimpleTriggerSave");
	   this.waitForElementPresent("Fix errors in form before save", WAIT_TIME);
		Assert.assertFalse(this.waitElement("//span[text()='testNumberFormate']", WAIT_TIME));
		this.deleteTask(label);
	    }
	
	
	@Test 
	@Parameters({"grid.task.label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","ServerForUseAvailable","statisticEnabled"})
	public void testNumberFormatExceptionSmaller(String label, String description, String projectName, String branchName, String jobName, String version, String context, String serverName, String statisticName){
		this.openTaskMenu();
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
		this.waitForElementPresent("//span[text()='" + label + "']",
				Base.WAIT_TIME);
	    this.addSimpleTriggerForTask(label, "testNumberFormateEqual", "3600", "100000");
	    this.waitForElementPresent("//span[@title='Generating...']", WAIT_TIME);
//	    this.waitForElementPresent("//span[@title='Ready to deploy']", MAX_WAIT_TIME);
	    this.waitForElementPresent("//span[@title='Ready to run']", MAX_WAIT_TIME);
	    this.deleteSimpleTriggerOfTask(label, "testNumberFormateEqual");
	    this.addSimpleTriggerForTask(label, "testNumberFormateSmaller", "3600", "99999");
	    this.deleteSimpleTriggerOfTask(label, "testNumberFormateSmaller");
	    this.deleteTask(label);
	    }
	
	
	
}
