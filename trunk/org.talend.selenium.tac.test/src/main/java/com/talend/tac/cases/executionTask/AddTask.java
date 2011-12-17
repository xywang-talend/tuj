package com.talend.tac.cases.executionTask;

import org.testng.Assert;

import com.talend.tac.cases.Login;

public class AddTask extends Login {
   
	//creat a method of add task
	public void addTask(String label, String description, String projectName, String branchName,
			 String jobName, String version, String context, String serverName, String statisticName) {
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
	    selenium.setSpeed(MIN_SPEED);
	    selenium.click("idSubModuleAddButton");
		this.typeString("idJobConductorTaskLabelInput", label);//plan name /Label
		this.typeString("idJobConductorTaskDescInput", description);//plan name /Label
    	
    	if(!selenium.isChecked("idJobConductorTaskActiveListBox")) {
    		
    		selenium.click("idJobConductorTaskActiveListBox");//check active
        	Assert.assertTrue(selenium.isChecked("idJobConductorTaskActiveListBox"));	
    		
    	}    
    	this.selectDropDownList("idTaskProjectListBox", projectName);
    	this.selectDropDownList("idTaskBranchListBox", branchName);
    	this.selectDropDownList("idTaskJobListBox", jobName);
    	this.selectDropDownList("idTaskVersionListBox", version);
    	this.selectDropDownList("idTaskContextListBox", context);
    	this.selectDropDownList("idJobConductorExecutionServerListBox", serverName);
    	this.selectDropDownList("idJobConductorTaskStatisticsListBox", statisticName);
    	this.selectDropDownList("idJobConductorOnUnavailableJobServerListBox", "Wait");
    	

	}
	
}
