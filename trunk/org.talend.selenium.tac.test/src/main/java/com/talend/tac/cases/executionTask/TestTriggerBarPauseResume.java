package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestTriggerBarPauseResume extends Login {
    
	//pause a trigger/resume a trigger
	@Test(dependsOnGroups={"AddCronTrigger"})
	public void testTriggerBarPauseResume() {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
    	selenium.setSpeed(MIN_SPEED);
    	selenium.mouseDown("//span[text()='11']");//select a exist task
    	
        selenium.mouseDown("//span[text()='dsds']");//select an exist trigger
        selenium.click("//button[text()='Pause trigger']");//click 'pause' button
        selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//span[@title='All triggers paused']/img"));
        Assert.assertTrue(selenium.isElementPresent("//img[@alt='Paused']"));
        selenium.setSpeed(MIN_SPEED);
        selenium.click("//button[text()='Resume trigger']");//click 'resume' button
        selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//span[@title='At least one Trigger is running']/img"));
        selenium.setSpeed(MIN_SPEED);
	}    
	
}
