package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddTask  extends TaskUtils {
	

	//add a task
	@Test
	@Parameters({"modifyTask","TaskWithJobOfGenerateBigLogs","labelDescription","addCommonProjectName","branchNameTrunk","jobNameOfgenerateBigLogs","version0.1",
		"context","serverForUseAvailable","statisticEnabled", "firefox.download.path"})
	public void testAddTaskWithJobOfGenerateBigLogs (String taskLabel, String label, String labelDescription,String commonpro,String trunk,String jobName,
			String version,String context,String jobServer,String statistic, String downloadPath) {
				
		addTask(label, labelDescription, commonpro, trunk, jobName, version, 
				context, jobServer, statistic);	
		
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}		
		
		
	}
	
	@Test
	@Parameters({"label","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testAddTask(String label, String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic) {
	   	
		this.addTask(label, labelDescription, commonpro, branch, jobName, version, context, jobServer, statistic);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}		
				
	}
    
	//add a exist task
	@Test
	@Parameters({"label","existLabelDescription","addReferenceProjectName","branchNameTrunk","jobNameReferencetjava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testAddExistTask(String label, String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic) {
		
		selenium.refresh();
		
		this.addTask(label, labelDescription, commonpro, branch, jobName, version, context, jobServer, statistic);

		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(rb.getString("executionTask.error.uniqueLabel")));
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	//add a task of uncheck active 
	@Test
	@Parameters({"labelNotChooseActive","notChooseLabelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testAddNotChooseActiveTask(String label, String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic) {
		
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
	    selenium.setSpeed(MIN_SPEED);
	    selenium.click("idSubModuleAddButton");
		this.typeString("idJobConductorTaskLabelInput", label);//plan name /Label
		this.typeString("idJobConductorTaskDescInput", labelDescription);//plan name /Label
    	
    	if(!selenium.isChecked("idJobConductorTaskActiveListBox")) {
    		
    		selenium.click("idJobConductorTaskActiveListBox");//check active
        	Assert.assertTrue(selenium.isChecked("idJobConductorTaskActiveListBox"));	
    		
    	}    
    	this.selectDropDownList("idTaskProjectListBox", commonpro);
    	this.selectDropDownList("idTaskBranchListBox", branch);
    	
    	if(selenium.isElementPresent("idItemListCombo")) {
    		this.selectDropDownList("idItemListCombo", "job");
    	}
    	
 	    if(selenium.isElementPresent("idTaskApplicationListBox")) {
    		
 	    	this.selectDropDownList("idTaskApplicationListBox", jobName);
    	
    	} else {

    		this.selectDropDownList("idTaskJobListBox", jobName);
        	
    	}
    	
    	this.selectDropDownList("idTaskVersionListBox", version);
    	this.selectDropDownList("idTaskContextListBox", context);
    	this.selectDropDownList("idJobConductorExecutionServerListBox", jobServer);
    	this.selectDropDownList("idJobConductorTaskStatisticsListBox", statistic);
    	this.selectDropDownList("idJobConductorOnUnavailableJobServerListBox", "Wait");     
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idJobConductorTaskActiveListBox");//uncheck "Active"		
		Assert.assertFalse(selenium.isElementPresent("//input[@id='idJobConductorTaskActiveListBox' and @checked]"));
		selenium.setSpeed(MIN_SPEED);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {
			
			selenium.click("idFormSaveButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}
	}
	

	//add a task for t
	//add a task for test run tRunJob
	@Test
	@Parameters({"labelTRunJobByTaskRun","labelTRunJobByTaskRunDescription","addCommonProjectName","branchNameTrunk","jobNameTRunJob","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testAddTaskForTestRunTRunJob(String label, String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic) {
		
		this.addTask(label, labelDescription, commonpro, branch, jobName, version, context, jobServer, statistic);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}		
				
	}
	
	//add a task for test run RefJobByMaintRunJobRun
	@Test
	@Parameters({"labelRefProJobByMainProTRunJobRun","labelRefJobByMaintRunJobRunDescription","addCommonProjectName","branchNameTrunk","jobNameRefJobByMaintRunJobRun","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testAddTaskForTestRefJobByMaintRunJobRun(String label, String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic) {
		
		
		this.addTask(label, labelDescription, commonpro, branch, jobName, version, context, jobServer, statistic);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {
					
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}		
				
	}
	
	//add a task for test run tjava(from referencepro)
	@Test
	@Parameters({"labelReferenceproTjava","labelReferenceproTjavaDescription","addReferenceProjectName","branchNameTrunk","jobNameReferencetjava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testAddTaskForTestChooseReferecePro(String label, String labelDescription,String referencepro,String branch,String jobName,
			String version,String context,String jobServer,String statistic) {
		
		
			
		this.addTask(label, labelDescription, referencepro, branch, jobName, version, context, jobServer, statistic);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}		
				
	}
	
	@Test
	@Parameters({"labelAddJVMParametersForTask","labelAddJVMParametersForTaskDescription","addCommonProjectName","branchNameTrunk",
		"jobNameTJava","version0.1","context","serverForUseAvailable","statisticEnabled"})
	public void testAddSimpleTask(String label,String description,String projectName,String branchName,
			String jobName,String version,String context,String serverName,String statisticName) {
		
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
		
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}
		
	}
	
	//add a task with a unactive server
	@Test
	@Parameters({"TaskWithInactiveServer","labelDescription","addCommonProjectName","branchNameTrunk",
		"jobNameTJava","version0.1","context","ServerForUseUnavailable","statisticEnabled"})
	public void testAddTaskWithInactiveServer(String label,String description,String projectName,String branchName,
			String jobName,String version,String context,String serverName,String statisticName) {
		
		this.addTask(label, description, projectName, branchName, jobName, version, context, serverName, statisticName);
		
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}
		
	}
	
	
	//add a task with latest job
	@Test
	@Parameters({"TaskLabelOfLatestJob","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","versionLatest",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testAddTaskWithLatestJob(String label, String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic) {
	   	
		this.addTask(label, labelDescription, commonpro, branch, jobName, version, context, jobServer, statistic);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}
		
		selenium.click("idSubModuleRefreshButton");
		
		this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+label+"']");
		
		String versionActual = selenium.getValue("idTaskVersionListBox");    	
    	Assert.assertEquals(versionActual, version);
				
	}
	
	//add a task of automated selecting combo value
	@Test
	@Parameters({"TaskOfAutomatedSelectingComboValue","labelReferenceproTjavaDescription","addReferenceProjectName","branchNameTrunk","jobNameReferencetjava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testAddTaskOfAutomatedSelectingComboValue(String label, String labelDescription,String referencepro,String trunk,String jobName,
			String version,String context,String jobServer,String statistic) {
	   	
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
	    selenium.setSpeed(MIN_SPEED);
	    selenium.click("idSubModuleAddButton");
		this.typeString("idJobConductorTaskLabelInput", label);//plan name /Label
		this.typeString("idJobConductorTaskDescInput", labelDescription);//plan name /Label
    	
    	if(!selenium.isChecked("idJobConductorTaskActiveListBox")) {
    		
    		selenium.click("idJobConductorTaskActiveListBox");//check active
        	Assert.assertTrue(selenium.isChecked("idJobConductorTaskActiveListBox"));	
    		
    	}    
    	this.selectDropDownList("idTaskProjectListBox", referencepro);
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String branchActual = selenium.getValue("idTaskBranchListBox");
    	
    	String jobNameActual;
    	
    	if(selenium.isElementPresent("idTaskApplicationListBox")) {
    		
    		jobNameActual = selenium.getValue("idTaskApplicationListBox");
    	
    	} else {

        	jobNameActual = selenium.getValue("idTaskJobListBox");
        	
    	}
    	
    	
    	Assert.assertEquals(branchActual, trunk);
    	Assert.assertEquals(jobNameActual, jobName);
    	
    	this.selectDropDownList("idTaskVersionListBox", version);
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String contextActual = selenium.getValue("idTaskContextListBox");
		
		Assert.assertEquals(contextActual, context);
		
    	this.selectDropDownList("idJobConductorExecutionServerListBox", jobServer);
    	this.selectDropDownList("idJobConductorTaskStatisticsListBox", statistic);
    	this.selectDropDownList("idJobConductorOnUnavailableJobServerListBox", "Wait");	
    	
    	if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}
				
	}
	
}