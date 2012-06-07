package com.talend.tac.cases.notification;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDeleteNotification extends AddNotification {
    
	//delete a notification(cancel Delete user Notification)
	@Test
	@Parameters({"eventNewUser"})
	public void testCancelDeleteUserNotification(String eventNewUser) {
		
		this.clickWaitForElementPresent("!!!menu.notification.element!!!");
		
	  	selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-category']");//click a exist notification
		selenium.chooseCancelOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");//click 'Delete' button
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.getConfirmation().matches("^Are you sure you want to remove the selected notification [\\s\\S]$"));
        selenium.setSpeed(MIN_SPEED);
	    selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventNewUser+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));		
		selenium.setSpeed(MIN_SPEED);
		
	}
	//delete a notification(Delete User Notification)
	@Test
	@Parameters({"eventNewUser"})
	public void testDeleteUserNotification(String eventNewUser) {
		
		this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		selenium.setSpeed(MID_SPEED);
				
    	selenium.mouseDown("//div[text()='"+eventNewUser+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']");//choose a notification type
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");//click 'Delete' button
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.getConfirmation().matches("^Are you sure you want to remove the selected notification [\\s\\S]$"));
        selenium.setSpeed(MIN_SPEED);
	 
        selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(!selenium.isElementPresent("//div[text()='"+eventNewUser+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));		
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	/**add a  user notificaton, select an user 'jackzhang@gmail.com', then into user page and 
	delete 'jackzhang@gmail.com', return notification page and check corresponding
	 notification is deleted**/
	@Test
	@Parameters({"categoryUser","eventUserCreation","descriptionUserCreation","LoginName"})
	public void testDeleteUserNotifitionByDeleteUser(String categoryUser, String eventUserCreation, 
			String descriptionUserCreation, String loginName) {
		
		this.addUserNotification(2, categoryUser, 2, eventUserCreation, descriptionUserCreation, loginName);
		selenium.click("idActiveInput");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isChecked("idActiveInput"));
		selenium.setSpeed(MID_SPEED);
		
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventUserCreation+"']/" +
        		"parent::td/parent::tr//img[@class='gwt-Image' and @title='false']"));		
 		selenium.setSpeed(MIN_SPEED);
 		this.clickWaitForElementPresent("idMenuUserElement");
 		this.waitForElementPresent("//div[text()='"+loginName+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+loginName+"']");//Select an existing user
		selenium.chooseOkOnNextConfirmation();	
		selenium.click("//div[text()='Users' and @class='header-title']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");//delete a user 

		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.getConfirmation().matches("^Are you sure you want to remove the selected user [\\s\\S]$"));
	    selenium.setSpeed(MIN_SPEED);
	    this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(!selenium.isElementPresent("//div[text()='"+eventUserCreation+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='false']"));
	    selenium.setSpeed(MIN_SPEED);
	    
	}
	
	/**add a  task notificaton, select an task 'BranchTask', then into Task page and 
	delete 'BranchTask', return notification page and check corresponding
	 notification is deleted**/
	@Test
	@Parameters({"eventTaskFailed","modifyTask"})
	public void testDeleteTaskByDeleteTask(String eventTaskFailed, String testModifyTask) {
		
		this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		
		this.waitForElementPresent("//div[text()='"+eventTaskFailed+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='false']", WAIT_TIME);
        Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventTaskFailed+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='false']"));
        
        this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
		selenium.setSpeed(MIN_SPEED);
	    selenium.click("idSubModuleRefreshButton"); //click "Refresh"
		selenium.mouseDown("//span[text()='"+testModifyTask+"']");//select a exist task
		selenium.chooseOkOnNextConfirmation();
		selenium.chooseOkOnNextConfirmation();
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[contains(text(),'Conductor') and @class='header-title']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");//clcik "Delete"
		selenium.setSpeed(MIN_SPEED);
		selenium.getConfirmation();
		selenium.getConfirmation().contains("Do you want to remove all of the related logs and archives");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//span[text()='"+testModifyTask+"']"));//the task cannot appear
		selenium.setSpeed(MIN_SPEED);
		
        this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		
        selenium.setSpeed(MAX_SPEED);
        Assert.assertFalse(selenium.isElementPresent("//div[text()='"+eventTaskFailed+"']/" +
	            "parent::td/parent::tr//img[@class='gwt-Image' and @title='false']"));
        selenium.setSpeed(MIN_SPEED);
	}
    
	
	/**add a  jobServer notificaton, select an jobServer 'use_server_unactive', then into jobServer page and 
	delete 'use_server_unactive', return notification page and check corresponding
	 notification is deleted**/
	@Test
	@Parameters({"eventJobServerAlert","serverForUseUnavailable"})
	public void testDeleteJobServerByDeleteJobServer(String eventJobServerAlert, String jobServer) {
		
		this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		
		this.waitForElementPresent("//div[text()='"+eventJobServerAlert+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventJobServerAlert+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));
				 
        this.clickWaitForElementPresent("!!!menu.executionServers.element!!!");
	    selenium.click("idSubModuleRefreshButton"); //click "Refresh"
	    this.waitForElementPresent("//div[text()='"+jobServer+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+jobServer+"']");//select a exist task
		selenium.chooseOkOnNextConfirmation();
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[text()='Servers' and @class='header-title']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']//button[@id='idSubModuleDeleteButton']");//clcik "Delete"
		selenium.setSpeed(MIN_SPEED);
		selenium.getConfirmation().contains("Are you sure you want to remove the selected execution server");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+jobServer+"']"));//the task cannot appear
		selenium.setSpeed(MIN_SPEED);
		
        this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		
		selenium.setSpeed(MAX_SPEED);
		Assert.assertFalse(selenium.isElementPresent("//div[text()='"+eventJobServerAlert+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));
        selenium.setSpeed(MIN_SPEED);
        
		
	}

}
