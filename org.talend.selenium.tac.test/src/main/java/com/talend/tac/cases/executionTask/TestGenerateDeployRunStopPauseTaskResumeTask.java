package com.talend.tac.cases.executionTask;



import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.executePlan.TriggerDate;

public class TestGenerateDeployRunStopPauseTaskResumeTask extends TaskUtils {
	
	TriggerDate date = new TriggerDate();
	//add a task of project contains space and run it, check it running whether normal
	@Test
	@Parameters({"taskProjectWithContainsSpaceChar","labelDescription","projectWithSpaceChar","branchNameTrunk",
		"jobNameTJava","version0.1","context","serverForUseAvailable","statisticEnabled"})
	public void testRunTaskOfItsProjectWithContainsSpaceChar(String label,String description,String projectName,String branchName,
			String jobName,String version,String context,String serverName,String statisticName) {
		
		this.addTask(label, description, projectName,
				branchName, jobName, version, context, serverName, statisticName);
		
		generateDeployRunTask(label,"//button[@id='idJobConductorTaskRunButton' and text()='Run']");//click Run button
		this.waitForElementPresent("//span[text()='Real time statistics']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Real time statistics']"));
		this.waitForElementPresent("//label[text()='Ok']", MAX_WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
		
		int logsConut = this.getXpathCount("//div[contains(@class,'x-grid3-" +
		"cell-inner x-grid3-col-startDate')]");
		
		Assert.assertEquals(logsConut, 1);
		
		
	}
	//test generate a simple task
	@Test
	@Parameters({"modifyTask"})
	public void testGenerateTask(String taskLabel) {
		 
		
		generateDeployRunTask(taskLabel,"idJobConductorTaskGenerateButton");//click generate button
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Generating...']", WAIT_TIME);
	   	Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
	   			"//span[text()='Generating...']"));
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
    			"//span[text()='Ready to deploy']", Base.MAX_WAIT_TIME);
    	Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
    			"//span[text()='Ready to deploy']"));
    	
	}
	
	//test deploy a simple task
	@Test
	@Parameters({"modifyTask"})
	public void testDeployTask(String taskLabel) {
		
		generateDeployRunTask(taskLabel,"//button[@id='idJobConductorTaskDeployButton' and text()='Deploy']");//click Deploy button
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Ready to run']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Ready to run']"));
//		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		
	}
	
	//test run a simple task
	@Test
	@Parameters({"modifyTask"})
	public void testRunSimpleTask(String taskLabel) {
		 
		generateDeployRunTask(taskLabel,"//button[@id='idJobConductorTaskRunButton' and text()='Run']");//click Run button
		this.waitForElementPresent("//span[text()='Real time statistics']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Real time statistics']"));
		this.waitForElementPresent("//label[text()='Ok']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
//		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
				
	}
    
	//test generate a task with latest job
	@Test
	@Parameters({"TaskLabelOfLatestJob"})
	public void testGenerateTaskWithLatestJob(String taskLabel) {
		 
		
		generateDeployRunTask(taskLabel,"idJobConductorTaskGenerateButton");//click generate button
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Generating...']", WAIT_TIME);
	   	Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
	   			"//span[text()='Generating...']"));
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
    			"//span[text()='Ready to deploy']", Base.MAX_WAIT_TIME);
    	Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
    			"//span[text()='Ready to deploy']"));
    	
	}
	
	//test deploy a task with latest job
	@Test
	@Parameters({"TaskLabelOfLatestJob"})
	public void testDeployTaskWithLatestJob(String taskLabel) {
		
		generateDeployRunTask(taskLabel,"//button[@id='idJobConductorTaskDeployButton' and text()='Deploy']");//click Deploy button
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Ready to run']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Ready to run']"));
//		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		
	}
	
	//test run a task with latest job
	@Test
	@Parameters({"TaskLabelOfLatestJob"})
	public void testRunTaskWithLatestJob(String taskLabel) {
		 
		generateDeployRunTask(taskLabel,"//button[@id='idJobConductorTaskRunButton' and text()='Run']");//click Run button
		this.waitForElementPresent("//span[text()='Real time statistics']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Real time statistics']"));
		this.waitForElementPresent("//label[text()='Ok']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
//		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
				
	}

	
	//test stop a running task
	@Test	
	@Parameters({"modifyTask", "statisticRemoved(regeneration needed, fastest)", "statisticEnabled(regeneration needed)"})
	public void testStopARunningTask(String taskLabel, String statisticRemovedRegeneration, String statisticEnabledReGeneration) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");//into executiontask page
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select an simple task
		selenium.click("//button[@id='idJobConductorTaskRunButton' and text()='Run']");//click Run button
		
		selenium.setSpeed(MID_SPEED);
		selenium.mouseDown("//span[text()='"+taskLabel+"']");//select an simple task
		selenium.setSpeed(MIN_SPEED);
		selenium.chooseOkOnNextConfirmation();		
		selenium.click("idJobConductorTaskStopButton");//click stop button
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.getConfirmation().matches("^Are you sure you want to stop the task " +
				"'"+taskLabel+"' before its normal end [\\s\\S]$"));
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr[@role='presentation']" +
				"//span[text()='Killed by user']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr[@role='presentation']" +
				"//span[text()='Killed by user']"));
		
		
	}
    
	
	//test generating a task using remote CommandLine
	/*needed start a remote commandLine*/
	@Test
	@Parameters({"remotehostAddress", "modifyTask", "localhostAddress"})
	public void testGenerateTaskUsingRemoteCommandLine(String remotehostAddress, String taskLabel,String localhostAddress) {
		
		changeCommandLineConfig(remotehostAddress);	
		
		generateDeployRunTask(taskLabel,"idJobConductorTaskGenerateButton");//click generate button
		selenium.setSpeed(MID_SPEED);
	   	Assert.assertTrue(selenium.isTextPresent("Generating..."));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
    			"//span[text()='Ready to deploy']", Base.MAX_WAIT_TIME);
    	Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
    			"//span[text()='Ready to deploy']"));
    	
    	changeCommandLineConfig(localhostAddress);
    	
	}
    

	//test generating a task using remote wrong CommandLine
	@Test
	@Parameters({"remotehostAddressWithWrong", "modifyTask", "localhostAddress"})
	public void testGenerateTaskUsingRemoteWrongCommandLine(String remotehostAddressWithWrong, String taskLabel,String localhostAddress) {
		
		changeCommandLineConfig(remotehostAddressWithWrong);
		
		generateDeployRunTask(taskLabel,"idJobConductorTaskGenerateButton");//click generate button	
    	this.waitForElementPresent("//span[text()='"+rb.getString("executionTask.errorStatus.connectionToCommandLineFailed")+"']", WAIT_TIME);
    	Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("executionTask.errorStatus.connectionToCommandLineFailed")+"']"));
    	
    	changeCommandLineConfig(localhostAddress);
    	
	}
		
    
	
	//Run a task with a Inactive server
	@Test	
	@Parameters({"TaskWithInactiveServer","labelDescription","addCommonProjectName","branchNameTrunk",
		"jobNameTJava","version0.1","context","serverForUseUnavailable","statisticEnabled"})
	public void testRunTaskWithInactiveServer(String label,String description,String projectName,String branchName,
			String jobName,String version,String context,String serverName,String statisticName) {
				
		generateDeployRunTask(label, "//button[@id='idJobConductorTaskRunButton' and text()='Run']");//click Run button
		this.waitForElementPresent("//span[text()='JobServer is inactive']", WAIT_TIME*4);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='JobServer is inactive']"));
		this.waitForElementPresent("//label[text()='JobServer is inactive']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='JobServer is inactive']"));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		
		
	}
	
	//run a generating task and check warn info
	@Test
	@Parameters({"modifyTask"})
	public void testRunAGeneratingTask(String taskLabel) {
		
		generateDeployRunTask(taskLabel, "idJobConductorTaskGenerateButton");//click generate button
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Generating...']", WAIT_TIME);
		
		selenium.setSpeed(MAX_SPEED);
		selenium.click("//button[@id='idJobConductorTaskRunButton']");
		selenium.setSpeed(MIN_SPEED);	
		
		this.waitForElementPresent("//div[contains(text(),'The requested action cannot be carried out because the execution task')]", WAIT_TIME);             
		Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'The requested action cannot be carried out because the execution task')]"), "//div[contains,(text()'The requested action cannot be carried out because the execution task')]" +
				" is without appear");
		
		
	}
	
	//test pauseTask button and resumeTask button
	@Test
	@Parameters({"TaskBaseBranch","addCronTriggerLabel","addCronTriggerDescription"})
	public void testPauseTaskResumeTask(String taskLabel, String cronTriggerLabel,String description) {
		
		intoJobConductor(taskLabel);
		
		addTriggerAddCronTrigger(taskLabel,cronTriggerLabel, description, date.getFuture(+1).years, 
				"Sunday", "Saturday", "January", "December");
    			
		selenium.click("idCrontTriggerSave");
				
		selenium.setSpeed(MID_SPEED);
		
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+cronTriggerLabel+"']"));
		selenium.setSpeed(MIN_SPEED);
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idJobConductorTaskPauseButton");
		selenium.getConfirmation();
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
				"//img[@title='All triggers paused']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
				"//img[@title='All triggers paused']"), "//span[text()='"+taskLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
						"//img[@title='All triggers paused'] is without appear");
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+cronTriggerLabel+"']//ancestor::table[@class='x-grid3-row-table']" +
				"//img[@title='Paused']"), "//span[text()='"+cronTriggerLabel+"']//ancestor::table[@class='x-grid3-row-table']//img[@alt='Paused'] is without appear");
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idJobConductorTaskResumeTriggerButton");
		selenium.getConfirmation();
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
				"//img[@title='At least one Trigger is running' ]", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
				"//img[@title='At least one Trigger is running' ]"), "//span[text()='"+taskLabel+"']//ancestor::table[@class='x-grid3-row-table']//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-triggersStatus')]" +
						"//img[@title='At least one Trigger is running' ] is without appear");

		this.waitForElementPresent("//span[text()='"+cronTriggerLabel+"']//ancestor::table[@class='x-grid3-row-table']" +
		"//img[@title='Normal']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+cronTriggerLabel+"']//ancestor::table[@class='x-grid3-row-table']" +
		"//img[@title='Normal']"), "//span[text()='"+cronTriggerLabel+"']//ancestor::table[@class='x-grid3-row-table']//img[@alt='Normal'] is without appear");
		selenium.setSpeed(MIN_SPEED);
        
	    clearTriggers(taskLabel);
	    
	}
	
	//test add a simple trigger to a generating task
	@Test
	@Parameters({"TaskBaseBranch"})
	public void testAddSimpleTriggerToGeneratingTask(String taskLabel) {
		
		intoJobConductor(taskLabel);
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idJobConductorTaskGenerateButton");//click generate button
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Generating...']", WAIT_TIME);
		
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("idTriggerAdd simple trigger");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
        
        this.typeString("idJobConductorSimpleTriggerLableInput", "simpleTrigger");//label
	   
        this.typeString("idJobConductorSimpleTriggerRptIntervalInput", "20");//Time interval (s)
	       		
	    selenium.setSpeed(MAX_SPEED);
	    selenium.click("idSimpleTriggerSave");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[contains(text(),'Save failed: The parent item of the trigger is currently locked, please retry later')]", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Save failed: The parent item of the trigger is currently locked, please retry later')]"));
		
	}
	
	//test generate a task of uncheck 'Active'
	@Test	
	@Parameters({"duplicateTask"})
	public void testGenerateUncheckActiveTask(String taskLabel) {
		
        intoJobConductor(taskLabel);
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idJobConductorTaskGenerateButton");//click generate button
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForTextPresent("The execution task \"Copy_of_testTaskNotChooseActive\" is inactive, the task can't be launched!", WAIT_TIME);
		Assert.assertTrue(selenium.isTextPresent("The execution task \"Copy_of_testTaskNotChooseActive\" is inactive, the task can't be launched!"));
		
	}
	
}
  