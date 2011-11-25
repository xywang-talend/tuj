package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestDuplicateTrigger extends Login {
    
	//add method for duplication trigger
	public void duplicateTrigger(String task, String trigger, String triggerType) {
	   
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+task+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+task+"']");//select a exist task
    	
    	this.waitForElementPresent("//span[text()='"+trigger+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+trigger+"']");//select a exist task
    	
    	selenium.click("idTriggerDuplicate");
    	
        if(selenium.isElementPresent("id"+triggerType+"tTriggerSave")) {
        	
        	selenium.click("id"+triggerType+"tTriggerSave");
        	
        } else {
        	
        	selenium.click("id"+triggerType+"TriggerSave");
        	
        }
    	
    	selenium.setSpeed(MID_SPEED);
    	
    	if(!selenium.isElementPresent("//span[text()='Copy_of_"+trigger+"']")) {
			selenium.click("idTriggerRefresh");
    	}

    	Assert.assertTrue(selenium.isElementPresent("//span[text()='Copy_of_"+trigger+"']"));
    	selenium.setSpeed(MIN_SPEED);   
    	
	}
	
	//test duplication a simple trigger
	@Test
	@Parameters({"labelTRunJobByTaskRun","addSimpleTriggerLabelNotChooseDate","simpleTriggerType"})
	public void testDuplicationSimpleTrigger(String task, String trigger, String triggerType) {
		
		duplicateTrigger(task, trigger, triggerType);
		
	}
	
	//test duplication a Cron trigger
	@Test
	@Parameters({"labelRefProJobByMainProTRunJobRun","cronTiggerLabelAfterModified","cronTriggerType"})
	public void testDuplicationCronTrigger(String task, String trigger, String triggerType) {
		
		duplicateTrigger(task, trigger, triggerType);
		
	}
	
}
