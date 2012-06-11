package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestDeleteTrigger extends Login {
    
	//delete a trigger
	@Test
	@Parameters({"modifyTask","addSimpleTriggerLabel"})
	public void testDeleteTrigger(String task, String trigger) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.mouseDown("//span[text()='"+task+"']");//select a exist task

    	selenium.mouseDown("//span[text()='"+trigger+"']");//select a exist task
    	
    	selenium.chooseOkOnNextConfirmation();
    	selenium.click("idTriggerDelete");
		Assert.assertTrue(selenium.getConfirmation().contains("Are you sure you want to remove the selected trigger"));
		
		selenium.click("idTriggerRefresh");
		
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(!selenium.isElementPresent("//span[text()='"+trigger+"']"));
    	selenium.setSpeed(MIN_SPEED);
		
	}
}
