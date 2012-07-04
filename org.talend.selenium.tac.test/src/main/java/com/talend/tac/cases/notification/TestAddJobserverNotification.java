package com.talend.tac.cases.notification;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestAddJobserverNotification extends AddNotification {
	
    //add a jobserver'notification(JobServerAlertNotification)
	@Test
	@Parameters({"categoryJobServer","eventJobServerAlert","descriptionJobServerAlert","serverForUseUnavailable"})
	public void testAddJobserversJobServerAlertNotification(String categoryJobServer, String eventJobServerAlert,
			String descriptionJobServerAlert, String jobServer) {
		
		this.addJobServerNotification(3, categoryJobServer, 1, eventJobServerAlert, descriptionJobServerAlert, jobServer);
	    
		selenium.click("idFormSaveButton");//clcik 'save'
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventJobServerAlert+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	//add a jobserver'notification(uncheck Active)
	@Test
	@Parameters({"categoryJobServer","eventJobServerAlert","descriptionJobServerAlert","serverForUseAvailable"})
	public void testAddJobserversNotificationUncheckActive(String categoryJobServer,String eventJobServerAlert,
			String descriptionJobServerAlert,String jobServer) {
		
		this.addJobServerNotification(3, categoryJobServer, 1, eventJobServerAlert, descriptionJobServerAlert, jobServer);

		selenium.click("idActiveInput");//uncheck  'Active'
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isChecked("idActiveInput"));
		selenium.setSpeed(MIN_SPEED);
				
		selenium.click("idFormSaveButton");//clcik 'save'
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventJobServerAlert+"']/" +
		"parent::td/parent::tr//img[@class='gwt-Image' and @title='false']"));
		selenium.setSpeed(MIN_SPEED);
	}

}
