package com.talend.tac.cases.notification;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;


public class TestDuplicationNotification extends Login {
	@Test
	@Parameters({"eventUserDeletion"})
	public void testDuplicationNotification(String eventUserDeletion) {
		
		this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		selenium.setSpeed(MID_SPEED);
		selenium.mouseDown("//div[text()='"+eventUserDeletion+"']/parent::td/" +
				"parent::tr//img[@class='gwt-Image' and @title='true']");//click a exist notification
		selenium.click("idActiveInput");
		selenium.setSpeed(MID_SPEED);
		Assert.assertFalse(selenium.isChecked("idActiveInput"));
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idSubModuleDuplicateButton");
		
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventUserDeletion+"']/parent::td/parent::tr" +
				"//img[@class='gwt-Image' and @title='false']"));
	    selenium.setSpeed(MIN_SPEED); 
		
	}
	
}
