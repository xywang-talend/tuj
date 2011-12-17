package com.talend.tac.cases.notification;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestModifyNotification extends Login {
    
	@Test
	@Parameters({"categoryUser","eventUserCreation","descriptionUserCreation","eventNewUser",
		"descriptionNewUser"})
	public void testModifyNotification(String categoryUser, String eventUserCreation, String descriptionUserCreation,
			String eventNewUser, String descriptionNewUser) {
		
		this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		selenium.setSpeed(MID_SPEED);
		selenium.mouseDown("//div[text()='"+eventUserCreation+"']/parent::td/" +
				"parent::tr//img[@class='gwt-Image' and @title='true']");//click a exist notification
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventUserCreation+"']"));
		String oldEvent = selenium.getValue("idDescriptionInput");
			
		selenium.click("idLabelInput");//modify category 
		selenium.mouseDownAt("//div[@role='listitem'][2]", ""+KeyEvent.VK_ENTER);
		selenium.click("idDescriptionInput");//modify event
		selenium.mouseDownAt("//div[@role='listitem'][1]", ""+KeyEvent.VK_ENTER);
		Assert.assertFalse(false, oldEvent);
		selenium.setSpeed(MID_SPEED);
		
		selenium.mouseDown("//span[text()='Notification']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel" +
				"-body-noborder x-border-layout-ct']//button[@id='idFormSaveButton']");
	
		selenium.mouseUp("//span[text()='Notification']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel" +
		"-body-noborder x-border-layout-ct']//button[@id='idFormSaveButton']");
		
		selenium.click("//span[text()='Notification']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-panel" +
				"-body-noborder x-border-layout-ct']//button[@id='idFormSaveButton']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventNewUser+"']/parent::td" +
				"/parent::tr//img[@class='gwt-Image' and @title='true']"));
		selenium.setSpeed(MIN_SPEED);
			
	}
	
}
