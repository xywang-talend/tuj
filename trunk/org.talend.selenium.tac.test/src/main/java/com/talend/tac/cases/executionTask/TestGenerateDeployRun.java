package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestGenerateDeployRun extends Login {
   
	public void generateDeployRunTask(String taslLabel, String buttonXpath) {
		
    	this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");//into executiontask page
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	selenium.mouseDown("//span[text()='"+taslLabel+"']");//select an simple task
    	selenium.click(buttonXpath);//click function button
          	
	}
	
	//test deploy a simple task
	@Test(groups={"TestGenerateDeployRun"},dependsOnGroups={"ModifyTask"})
	@Parameters({"modifyTask"})
	public void testGenerateTask(String taskLabel) {
		 
		generateDeployRunTask(taskLabel,"idJobConductorTaskGenerateButton()");//click generate button
		selenium.setSpeed(MID_SPEED);
	   	Assert.assertTrue(selenium.isTextPresent("Generating..."));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='Ready to deploy']", WAIT_TIME);
    	Assert.assertTrue(selenium.isElementPresent("//span[text()='Ready to deploy']"));
    	
	}
	
	//test deploy a simple task
	@Test(dependsOnMethods={"testGenerateTask"})
	@Parameters({"modifyTask"})
	public void testDoployTask(String taskLabel) {
		 
		generateDeployRunTask(taskLabel,"//button[@id='idJobConductorTaskRunButton()' and text()='Deploy']");//click Deploy button
		this.waitForElementPresent("//span[text()='Ready to run']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Ready to run']"));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		
	}
	
	//test run a simple task
	@Test(dependsOnMethods={"testDoployTask"})
	@Parameters({"modifyTask"})
	public void testRunSimpleTask(String taskLabel) {
		 
		generateDeployRunTask(taskLabel,"//button[@id='idJobConductorTaskRunButton()' and text()='Run']");//click Run button
		this.waitForElementPresent("//span[text()='Real time statistics']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Real time statistics']"));
		this.waitForElementPresent("//label[text()='Ok']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
				
	}
	
	//Run a task with a job containing a subjob
	@Test(dependsOnMethods={"testRunSimpleTask"})
	@Parameters({"labelTRunJobByTaskRun"})
	public void testRunTaskWithJobContainingSubjob(String taskLabel) {
		
		generateDeployRunTask(taskLabel, "//button[@id='idJobConductorTaskRunButton()' and text()='Run']");//click Run button
		this.waitForElementPresent("//span[text()='Real time statistics']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Real time statistics']"));
		selenium.setSpeed(MID_SPEED);
	   	Assert.assertTrue(selenium.isTextPresent("Generating..."));
    	selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//label[text()='Ok']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		
	}
	
}
