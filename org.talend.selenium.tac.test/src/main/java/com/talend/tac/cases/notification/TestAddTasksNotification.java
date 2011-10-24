package com.talend.tac.cases.notification;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddTasksNotification extends AddNotification {
    
    //add a task'notification(TaskFailedNotification)
	@Test
	@Parameters({"categoryTask","eventTaskFailed","descriptionTaskFailed","TaskBaseBranch"})
	public void testAddTaskFailedNotification(String categoryTask, String eventTaskFailed, 
			String descriptionTaskFailed,String taskBaseBranch) {
		
		this.addTaskNotification(1, categoryTask, 1, eventTaskFailed, descriptionTaskFailed,taskBaseBranch);
		
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventTaskFailed+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));
		selenium.setSpeed(MIN_SPEED);
		
	}

	//add a task'notification(Uncheck Active)
	@Test          
	@Parameters({"categoryTask","eventTaskFailed","descriptionTaskFailed","modifyTask"})
	public void testAddTaskNotificationUncheckActive(String categoryTask, String eventTaskFailed,
			String descriptionTaskFailed, String testAddsimpleTask) {
		
		this.addTaskNotification(1, categoryTask, 1, eventTaskFailed, descriptionTaskFailed,testAddsimpleTask);
		selenium.click("idActiveInput");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isChecked("idActiveInput"));
		selenium.setSpeed(MIN_SPEED);
				
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventTaskFailed+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='false']"));
		selenium.setSpeed(MIN_SPEED);
	}

}
