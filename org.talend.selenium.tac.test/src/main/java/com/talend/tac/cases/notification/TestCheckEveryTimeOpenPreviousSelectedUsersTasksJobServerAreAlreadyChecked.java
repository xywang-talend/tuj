package com.talend.tac.cases.notification;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCheckEveryTimeOpenPreviousSelectedUsersTasksJobServerAreAlreadyChecked extends 
CheckEveryTimeOpenPreviousSelectedUsersTasksJobServerAreAlreadyChecked{
   
	//test check every time open previous selected tasks are already checked
	@Test
	@Parameters({"categoryTask","eventTaskFailed","descriptionTaskFailed",
		"modifyTask", "TaskBaseBranch"})
	public void testCheckEveryTimeOpenPreviousSelectedTasksAreAlreadyChecked(String categoryTask, String eventTaskFailed,
			String descriptionTaskFailed, String tasklabel, String tasklabelOfBranch) {
		
		checkEveryTimeOpenPreviousSelectedUsersTasksJobServerAreAlreadyChecked(1, categoryTask, 1, 
				eventTaskFailed, descriptionTaskFailed, "idNotificationTaskButton", tasklabel, tasklabelOfBranch);	
				
	}
	
	//test check every time open previous selected users are already checked
	@Test
	@Parameters({"categoryUser","eventUserDeletion","descriptionUserDeletion","userName",
		"LoginNameChooseMulripleRoles"})
	public void testCheckEveryTimeOpenPreviousSelectedUsersAreAlreadyChecked(String categoryUser, String eventUserDeletion,
			String descriptionUserDeletion, String userName, String userNameMulripleRoles) {
		
		checkEveryTimeOpenPreviousSelectedUsersTasksJobServerAreAlreadyChecked(2, categoryUser, 3, 
				eventUserDeletion, descriptionUserDeletion, "idNotificationRepUserButton",
				userName, userNameMulripleRoles);
				
	}	
	
	//test check every time open previous selected jobservers are already checked
	@Test
	@Parameters({"categoryJobServer","eventJobServerAlert","descriptionJobServerAlert","serverForUseUnavailable","serverForUseAvailable"})
	public void testCheckEveryTimeOpenPreviousSelectedJobServersAreAlreadyChecked(String categoryJobServer, String eventJobServerAlert,
			String descriptionJobServerAlert, String jobServer, String jobserverAvailable) {
		
		checkEveryTimeOpenPreviousSelectedUsersTasksJobServerAreAlreadyChecked(3, categoryJobServer, 1, 
				eventJobServerAlert, descriptionJobServerAlert, "idNotificationJobserverButton", jobServer, jobserverAvailable);		
		
	}	
	
}
