package com.talend.tac.cases.users;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.cases.Login;


public class TestDisplayUser extends Login {

	    
	//modify the users--->>according to role display
	@Test
	@Parameters({"userName"})
	public void testDidplayUsers(String userName) throws Exception {
	
		this.clickWaitForElementPresent("idMenuUserElement");
		
		this.waitForElementPresent("//div[text()='"+userName+"']", WAIT_TIME);
//		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[contains(@class,'grid3-hd-inner x-grid3-hd-login')]/a");
		selenium.setSpeed(MIN_SPEED);
		selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Show in Groups']");
		Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
        selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-role x-component']/a[@class='x-grid3-hd-btn'][1]");
	    
        selenium.click("//a[text()='Group By This Field']");
        Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid-group-div']"));
        selenium.setSpeed(MIN_SPEED);
	}
   
	@Test
	@Parameters({"userName"})
	public void testModifyDisplayUsersColumns(String userName) throws Exception {
		
		this.clickWaitForElementPresent("idMenuUserElement");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//div[contains(@class,'grid3-hd-inner x-grid3-hd-login')]/a", WAIT_TIME);
		selenium.click("//div[contains(@class,'grid3-hd-inner x-grid3-hd-login')]/a");

		selenium.setSpeed(MID_SPEED);
		selenium.mouseOver("//a[text()='Columns']");
	    selenium.setSpeed(MIN_SPEED);
		modifyDisplayUsersColumns("Login");
		
		modifyDisplayUsersColumns("Role");
		
		modifyDisplayUsersColumns("Role");
		
		modifyDisplayUsersColumns("Last name");
		
        modifyDisplayUsersColumns("First name");
        
        modifyDisplayUsersColumns("Type");
        
        modifyDisplayUsersColumns("Active");
        
        modifyDisplayUsersColumns("Creation");
        
        selenium.setSpeed(MID_SPEED);
		selenium.click("//a[text()='Sort Ascending']/img[@class=' x-menu-item-icon']");
		selenium.setSpeed(MIN_SPEED);
	}
    
    //Modify the user display order  
	@Test
	@Parameters({"userName","importUserName","copyUser"})
	public void testModifyDisplayUsersOrder(String userName,String importUserName,String copyUser) throws Exception {
		
		this.clickWaitForElementPresent("idMenuUserElement");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
	
		selenium.click("//div[contains(@class,'grid3-hd-inner x-grid3-hd-login')]/a");
		selenium.click("//a[text()='Show in Groups']");
		selenium.setSpeed(MIN_SPEED);
		   
		modifyDisplayUsersOrder("login",importUserName,copyUser);
		
		modifyDisplayUsersOrder("role",rb.getString("menu.role.viewer")+"/"+rb.getString("menu.role.designer"),
				rb.getString("menu.role.administrator"));
     
	}
    //hidden users/display users
	@Test
	@Parameters({"userName","loginName","loginNameNotChooseActive","loginNameChooseMulripleRoles"})
	public void testHiddenDidplayUsers(String userName,String loginName,
			String loginNameNotChooseActive,String loginNameChooseMulripleRoles) throws Exception {
		
		this.clickWaitForElementPresent("idMenuUserElement");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
	    selenium.setSpeed(MIN_SPEED);
	    
	    hiddenDisplayUsers(userName, "Role: Administrator (1 Member)");
        hiddenDisplayUsers(loginName, "Role: Designer (1 Member)");
	    hiddenDisplayUsers(loginNameNotChooseActive, "Role: Viewer (2 Members)");
	    hiddenDisplayUsers(loginNameChooseMulripleRoles, "Role: Viewer/Designer (1 Member)");
	    
	    hiddenDisplayUsers(userName, "Role: Administrator (1 Member)");
	    hiddenDisplayUsers(loginName, "Role: Designer (1 Member)");
	    hiddenDisplayUsers(loginNameNotChooseActive, "Role: Viewer (2 Members)");
	    hiddenDisplayUsers(loginNameChooseMulripleRoles, "Role: Viewer/Designer (1 Member)");
	 
	    
	}
	//hidden users/display users    
	public void hiddenDisplayUsers(String userName,String title) {
	 
		if(selenium.isTextPresent(userName) && selenium.isTextPresent(title)) {
			
			if(selenium.isVisible("//div[text()='"+userName+"']")) {
			 
				 selenium.mouseDown("//div[text()='"+title+"']");
				 selenium.setSpeed(MID_SPEED);
				 Assert.assertFalse(selenium.isVisible("//div[text()='"+userName+"']"));
				 selenium.setSpeed(MIN_SPEED);
			} else {
				 
				 selenium.mouseDown("//div[text()='"+title+"']");
				 selenium.setSpeed(MID_SPEED);
				 Assert.assertTrue(selenium.isVisible("//div[text()='"+userName+"']"));
				 selenium.setSpeed(MIN_SPEED);
			}
			
		} else {
			
			System.out.println("User does not exist or wrong title");
		}
		
		
	}	
	//modify the users dispaly columns
	public void modifyDisplayUsersColumns(String xpathName) throws Exception {
		

		if(selenium.isElementPresent("//span[text()='"+xpathName+"']")) {
			selenium.setSpeed(MID_SPEED);
			selenium.click("//a[text()='"+xpathName+"']/img[@class=' x-menu-item-icon']");
			Assert.assertFalse(selenium.isElementPresent("//span[text()='"+xpathName+"']"));
		    selenium.setSpeed(MIN_SPEED);
		} else {
			
			selenium.setSpeed(MID_SPEED);
			selenium.click("//a[text()='"+xpathName+"']/img[@class=' x-menu-item-icon']");
		    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+xpathName+"']"));
		    selenium.setSpeed(MIN_SPEED);
		}
		

	}
	//Modify the user display order 
	public void modifyDisplayUsersOrder(String xpathName,String value,String value1) {
		
		selenium.setSpeed(MID_SPEED);  
		selenium.click("//div[contains(@class,'grid3-hd-inner x-grid3-hd-"+xpathName+"')]/a");
		selenium.setSpeed(MIN_SPEED);
		selenium.click("//a[text()='Sort Descending']");
		System.out.println(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+xpathName+"']"));
		Assert.assertEquals(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+xpathName+"']"), value);
        
       
        selenium.setSpeed(MID_SPEED);
        selenium.click("//div[contains(@class,'x-grid3-hd-inner x-grid3-hd-"+xpathName+"')]/a");
        selenium.setSpeed(MIN_SPEED);  
		selenium.click("//a[text()='Sort Ascending']");
		System.out.println(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+xpathName+"']"));
		Assert.assertEquals(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-"+xpathName+"']"), value1);
		                                 
	}
}