package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestCheckRegenerateTask extends Login {
    
	//add case for check regenerate task
	@Test
	@Parameters({"jobNameTRunJob","version0.1","context"})
	public void testCheckRegenerateTask(String jobName, String version, String context) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");//into task page 
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
	    selenium.setSpeed(MIN_SPEED);
	    
	    this.waitForElementPresent("//span[text()='testAddsimpleTask']", WAIT_TIME);
	    selenium.mouseDown("//span[text()='testAddsimpleTask']");//select an exist task
	    
	    if(!selenium.isElementPresent("//span[text()='testAddsimpleTask']//ancestor::tr//span[text()=" +
	    		"'Ready to deploy']")) {
	    	
	    	 selenium.setSpeed(MID_SPEED);
	 	    selenium.click("idJobConductorTaskGenerateButton");//generate task
	 	    selenium.setSpeed(MIN_SPEED);
	    	
	    }
	   	    
	    this.waitForElementPresent("//span[text()='testAddsimpleTask']//ancestor::tr//span[text()=" +
	    		"'Ready to deploy']", Base.MAX_WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='testAddsimpleTask']//ancestor::tr" +
	    		"//span[text()='Ready to deploy']"));

 	    if(selenium.isElementPresent("idTaskApplicationListBox")) {
    		
 	    	this.selectDropDownList("idTaskApplicationListBox", jobName);
    	
    	} else {

    		this.selectDropDownList("idTaskJobListBox", jobName);
        	
    	}
 	    
 	    this.selectDropDownList("idTaskVersionListBox", version);
    	this.selectDropDownList("idTaskContextListBox", context);
    	if(!selenium.isChecked("idJobConductorRegenerateJobOnChangeCheckBox")) {
    		
    		selenium.click("idJobConductorRegenerateJobOnChangeCheckBox");//check regenerate
        	Assert.assertTrue(selenium.isChecked("idJobConductorRegenerateJobOnChangeCheckBox"));	
    		
    	} 
    	selenium.click("idFormSaveButton");
    	
    	this.waitForElementPresent("//span[text()='testAddsimpleTask']//ancestor::tr//span[text()" +
	    		"='Ready to generate']", WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='testAddsimpleTask']//ancestor::tr" +
	    		"//span[text()='Ready to generate']"));
	    		
	}
	
}
