package com.talend.tac.cases.notification;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLicenseNotification extends AddNotification {
    
	//test add a license notification of event on license expiration
	@Test
	@Parameters({"categoryLicense", "eventOnLicenseExpiration", "descriptionOnLicenseExpiration"})
	public void testAddNotificationOfOnLicenseExpiration(String license, String eventOnLicenseExpiration
			,String descriptionOnLicenseExpiration) {
		
		addLicenseNotification(4, license,
				1, eventOnLicenseExpiration,
				descriptionOnLicenseExpiration);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventOnLicenseExpiration+"']/" +
        		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));		
 		selenium.setSpeed(MIN_SPEED);
		
		
	}
    
	//test add a license notification of event on token expiration
	@Test
	@Parameters({"categoryLicense", "eventOnTokenExpiration", "descriptionOnTokenExpiration"})
	public void testAddNotificationOfEventOnTokenExpiration(String license, String eventOnTokenExpiration
			,String descriptionOnTokenExpiration) {
		
		addLicenseNotification(4, license,
				2, eventOnTokenExpiration,
				descriptionOnTokenExpiration);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//div[text()='"+eventOnTokenExpiration+"']/" +
        		"parent::td/parent::tr//img[@class='gwt-Image' and @title='true']"));		
 		selenium.setSpeed(MIN_SPEED);
		
	}
	
}
