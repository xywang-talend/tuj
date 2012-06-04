package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;
public class TestModifyTask extends Login {
    
	//creation method for modify task
	public void modifiedTask() {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
	    
	}
	
	@Test
	@Parameters({"label","modifyTask","addReferenceProjectName","branchNameTrunk","jobNameReferencetjava","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testModifyTask(String label,String modifyLabel,String projectName,String branchName,String jobName,
			String version,String context,String jobServer,String statistic) {
		
		modifiedTask();
		
		selenium.setSpeed(MID_SPEED);
		if(!selenium.isElementPresent("//span[text()='"+modifyLabel+"']")) {
		    selenium.setSpeed(MIN_SPEED);
			this.waitForElementPresent("//span[text()='"+label+"']	", WAIT_TIME);
		    selenium.mouseDown("//span[text()='"+label+"']");//select a exist task

            this.typeString("idJobConductorTaskLabelInput", modifyLabel);//task name /Label            
            this.selectDropDownList("idTaskProjectListBox", projectName);
        	this.selectDropDownList("idTaskBranchListBox", branchName);

        	if(selenium.isElementPresent("idItemListCombo")) {
        		
        		this.selectDropDownList("idItemListCombo", "job");
        		
        	}
        		
        	this.selectDropDownList("idTaskApplicationListBox", jobName);
        	this.selectDropDownList("idTaskVersionListBox", version);
        	this.selectDropDownList("idTaskContextListBox", context);
 
			selenium.click("idFormSaveButton");
			this.waitForElementPresent("//span[text()='"+modifyLabel+"']", WAIT_TIME);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+modifyLabel+"']"));
			
		}	
		selenium.setSpeed(MIN_SPEED);
	}
	
	//test modify job of generating task and check warn info
	@Test
	@Parameters({"TaskBaseBranch","jobNameTJava","version0.1",
		"context"})
	public void testModifyJobOfGeneratingTaskAndCheckWarnInfo(String label,String jobName,String version,String context) throws InterruptedException {
		
		modifiedTask();		
		
		this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+label+"']");//select a exist task
        selenium.setSpeed(MID_SPEED);
		selenium.click("idJobConductorTaskGenerateButton");//generate task
		selenium.setSpeed(MIN_SPEED);
		Thread.sleep(3000); 

 	    if(selenium.isElementPresent("idTaskApplicationListBox")) {
    		
 	    	this.selectDropDownList("idTaskApplicationListBox", jobName);
    	
    	} else {

    		this.selectDropDownList("idTaskJobListBox", jobName);
        	
    	}
 	    
    	this.selectDropDownList("idTaskVersionListBox", version);
    	this.selectDropDownList("idTaskContextListBox", context);
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idFormSaveButton");
		
		selenium.setSpeed(MAX_SPEED);
		if(selenium.isTextPresent(rb.getString("executionTask.locked"))) {			
			
			Assert.assertTrue(selenium.isTextPresent(rb.getString("executionTask.locked")));
				
			
		} else {
			
			Assert.assertTrue(selenium.isTextPresent("Another operation is locking the" +
			" task '"+label+"', please retry later "));
			
		}
		selenium.setSpeed(MIN_SPEED);
		
	}
	
}
