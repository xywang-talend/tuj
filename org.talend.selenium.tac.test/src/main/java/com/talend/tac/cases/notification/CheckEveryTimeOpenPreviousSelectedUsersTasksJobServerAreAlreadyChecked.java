package com.talend.tac.cases.notification;

import java.awt.event.KeyEvent;

import org.testng.Assert;

import com.talend.tac.cases.Login;

public class CheckEveryTimeOpenPreviousSelectedUsersTasksJobServerAreAlreadyChecked extends Login {
    
	/*creation method for test check every time open previous selected
   users/tasks/jobserver are already checked*/
	public void checkEveryTimeOpenPreviousSelectedUsersTasksJobServerAreAlreadyChecked(int categoryInput,
			String categoryInputValue, int eventInput, String eventInputValue, String notificationInformation
			, String xpathId, String checkValue, String checkValueAgain) {
		

		this.clickWaitForElementPresent("!!!menu.notification.element!!!");//into notification
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[contains(@class,'header-title') " +
				"and text()='Notification']"));//verify whether go to notification page
		selenium.setSpeed(MIN_SPEED);
		
		selenium.click("idSubModuleAddButton");//click add button
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//img[@class='gwt-Image x-component ']"));
		selenium.setSpeed(MIN_SPEED);	
		this.selectDropDownList("//input[@id='idLabelInput']", categoryInput);//choose a notification type
		Assert.assertEquals(selenium.getValue("idLabelInput"), categoryInputValue);
		this.selectDropDownList("//input[@id='idDescriptionInput']", eventInput);//choose a event
		String event = selenium.getValue("idDescriptionInput");
		System.out.println(event);
		selenium.setSpeed(MID_SPEED);
		Assert.assertEquals(event , eventInputValue);
		Assert.assertTrue(selenium.isTextPresent(notificationInformation));
		selenium.setSpeed(MIN_SPEED);
		selenium.click("idLabelInput");
		selenium.mouseDownAt("//div[@role='listitem']["+categoryInput+"]", ""+KeyEvent.VK_ENTER);
		
		selenium.click("//i[text()='"+notificationInformation+"']//ancestor::tbody//" +
		"button[@id='"+xpathId+"']");//click 'Users:/Task:/jobserver:' icon
		this.waitForElementPresent("//div[text()='"+checkValue+"']/parent::td/preceding-sibling::td", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+checkValue+"']/parent::td/preceding-sibling::td");//select user/task/jobserver
		selenium.click("//button[text()='Apply']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//i[text()=' - "+checkValue+"']"));
		selenium.setSpeed(MIN_SPEED);
		/*Open previous selected users/tasks/jobServer are already checked*/
		selenium.click("//i[text()='"+notificationInformation+"']//ancestor::tbody//" +
		"button[@id='"+xpathId+"']");//click 'Users:/Task:/jobserver:' icon
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+checkValue+"']//ancestor::div[@class='x-grid3-body']" +
		"//div[contains(@class,'x-grid3-row  x-unselectable-single x-grid3-highlightrow x-grid3-row-selected')]"));
		selenium.setSpeed(MIN_SPEED);
		selenium.click("//button[text()='Apply']");
		/*Open previous selected users/tasks/jobServer are already checked*/
		
		/*select an user/task/jobserver again*/
		selenium.click("//i[text()='"+notificationInformation+"']//ancestor::tbody//" +
				"button[@id='"+xpathId+"']");//click 'Users:/Task:/jobserver:' icon
		
		this.waitForElementPresent("//div[text()='"+checkValueAgain+"']", WAIT_TIME);
		selenium.controlKeyDown();
		selenium.click("//div[text()='"+checkValueAgain+"']/parent::td/preceding-sibling::td");//select user/task/jobserver
		selenium.controlKeyUp();
		selenium.click("//button[text()='Apply']");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//i[text()=' - "+checkValue+"']"));
		Assert.assertTrue(selenium.isElementPresent("//i[text()=' - "+checkValueAgain+"']"));
		selenium.setSpeed(MIN_SPEED);
		/*select an user/task/jobserver again*/
		
	}
	
	
}
