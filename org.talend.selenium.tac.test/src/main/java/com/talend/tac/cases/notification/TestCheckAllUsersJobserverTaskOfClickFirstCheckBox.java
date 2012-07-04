package com.talend.tac.cases.notification;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestCheckAllUsersJobserverTaskOfClickFirstCheckBox extends 
CheckAllUsersJobserverTaskOfClickFirstCheckBox {
    
	//test select all users of click first checkbox
	@Test
	@Parameters({"categoryUser","eventUserDeletion","descriptionUserDeletion","userName",
		"LoginNameChooseMulripleRoles"})
	public void testCheckAllUsersOfClickFirstCheckBox(String categoryUser, String eventUserDeletion,
			String descriptionUserDeletion, String userName, String userNameMulripleRoles) throws InterruptedException {
		
		checkAllUsersJobserverTaskOfClickFirstCheckBox(2, categoryUser, 3, 
				eventUserDeletion, descriptionUserDeletion, "idNotificationRepUserButton");
		
		Thread.sleep(3000);
		//get user count in notification page
		int actualUserCount = this.getXpathCount("//table[@cellspacing='3']//tr[1]//div[text()='Recipients: ']" +
				"//parent::td//following-sibling::td//td[1][@align='left']//div//i");
		
		//go to user page
		//get user count in user page
		this.openPage("idMenuUserElement", "//div[contains(text(),'Users') and @class='header-title']");
		int expectedUserCount = this.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-login']");
		
		Assert.assertTrue(actualUserCount == expectedUserCount);
			
	}
	
	//test select all tasks of click first checkbox
	@Test
	@Parameters({"categoryTask","eventTaskFailed","descriptionTaskFailed",
		"modifyTask", "TaskBaseBranch"})
	public void testCheckAllTasksOfClickFirstCheckBox(String categoryTask, String eventTaskFailed,
			String descriptionTaskFailed, String tasklabel, String tasklabelOfBranch) throws InterruptedException {
		
		checkAllUsersJobserverTaskOfClickFirstCheckBox(1, categoryTask, 1, 
				eventTaskFailed, descriptionTaskFailed, "idNotificationTaskButton");
		
		Thread.sleep(3000);
//		get task count in notification page
		int actualTaskCount = this.getXpathCount("//table[@cellspacing='3']//tr[2]//div[text()='Tasks: ']" +
				"//parent::td//following-sibling::td//td[1][@align='left']//div//i");
		
		//go to Task page
		//get task count in task page
			this.openPage("!!!menu.executionTasks.element!!!", "//div[contains(text(),'Conductor') and @class='header-title']");
		int expectedTaskCount = this.getXpathCount("//div[contains(text(),'Conductor') and @class='header-title']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-label']");
		
		Assert.assertTrue(actualTaskCount == expectedTaskCount);
 		
	}
	
	
	//test select all jobservers of click first checkbox
	@Test
	@Parameters({"categoryJobServer","eventJobServerAlert","descriptionJobServerAlert",
		"serverForUseUnavailable","serverForUseAvailable"})
	public void testCheckAllJobServersOfClickFirstCheckBox(String categoryJobServer, String eventJobServerAlert,
			String descriptionJobServerAlert, String jobServer, String jobserverAvailable) throws InterruptedException  {
		
		checkAllUsersJobserverTaskOfClickFirstCheckBox(3, categoryJobServer, 1, 
				eventJobServerAlert, descriptionJobServerAlert, "idNotificationJobserverButton");
		
		Thread.sleep(3000);
		//get server count in notification page
		int actualTaskCount = this.getXpathCount("//table[@cellspacing='3']//tr[2]//div[text()='jobServers: ']" +
				"//parent::td//following-sibling::td//td[1][@align='left']//div//i");
		
		//go to Task page
		//get server count in server page
		this.openPage("!!!menu.executionServers.element!!!", "//div[text()='Servers' and @class='header-title']");
		int expectedTaskCount = this.getXpathCount("//div[text()='Servers' and @class='header-title']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct']" +
				"//div[@class='x-grid3-cell-inner x-grid3-col-label']");
		
		Assert.assertTrue(actualTaskCount == expectedTaskCount);

	}
	
}
