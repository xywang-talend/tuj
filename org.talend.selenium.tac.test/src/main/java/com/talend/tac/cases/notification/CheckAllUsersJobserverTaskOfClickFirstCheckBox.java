package com.talend.tac.cases.notification;


import org.testng.Assert;
import com.talend.tac.cases.Login;

public class CheckAllUsersJobserverTaskOfClickFirstCheckBox extends Login {
	
	//open page
	public void openPage(String menuId, String pageTitle) {
		
		this.clickWaitForElementPresent(menuId);
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='"+pageTitle+"']"));
	    selenium.setSpeed(MIN_SPEED);
		
	}

	//get xpath count of same xpath
	public int getXpathCount(String xpath) {
	    
		this.waitForElementPresent(xpath, WAIT_TIME);
		
		Number xpathConut = selenium.getXpathCount(xpath);
		int i = xpathConut.intValue();
		
		System.out.println("*-*-*-*-*-*"+i);
		return i;
		
	}
	
	public void checkAllUsersJobserverTaskOfClickFirstCheckBox(int categoryInput,
			String categoryInputValue, int eventInput, String eventInputValue, String notificationInformation
			, String xpathId) {
	

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
		
		selenium.click("//i[text()='"+notificationInformation+"']//ancestor::tbody//" +
		"button[@id='"+xpathId+"']");//click 'Users:/Task:/jobserver:' icon
		selenium.setSpeed(MIN_SPEED);
		selenium.setSpeed(MAX_SPEED);
		selenium.click("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-checker x-component')]");//select user/task/jobserver of click first checkbox
		selenium.setSpeed(MIN_SPEED);
		selenium.setSpeed(MID_SPEED);
		selenium.click("//button[text()='Apply']");
		selenium.setSpeed(MIN_SPEED);
   		
	}	
	
}
