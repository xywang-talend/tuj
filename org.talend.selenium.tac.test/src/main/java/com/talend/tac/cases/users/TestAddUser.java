package com.talend.tac.cases.users;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddUser extends Users {
    
	
	//clear all users---modify firstname and lastName to "admin,admin" ---user'role change to 'administrator'
    @Test	
    @Parameters({"userName"})
    public void clearAllUsers(String userName) {
    	 List<String> users = new ArrayList<String>(); 
    	 this.clickWaitForElementPresent("idMenuUserElement");

 		 this.waitForElementPresent("//div[text()='"+userName+"']", WAIT_TIME);
    	 selenium.setSpeed(MID_SPEED);
    	 if(selenium.isElementPresent("//i[text()='Administrator/Viewer/Operation manager/Designer']")) {
			 selenium.setSpeed(MIN_SPEED);
    		 selenium.mouseDown("//div[text()='"+userName+"']");
			 selenium.click("idRoleButton");
			 Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
			 selenium.click("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+rb.getString("menu.role.administrator")+"')]");
			 selenium.click("idValidateButton");

			 selenium.click("idFormSaveButton");
		
    	 } else {
    		 System.out.println("user role is administrator");
    		 selenium.setSpeed(MIN_SPEED);
    	 }
    	 selenium.setSpeed(MID_SPEED);
      	 if(!selenium.isElementPresent("//b[text()='admin, admin']")) {
			 selenium.setSpeed(MIN_SPEED);
      		 selenium.mouseDown("//div[text()='"+userName+"']");
			 this.typeString("idUserFirstNameInput", "admin");
			 this.typeString("idUserlastNameInput", "admin");
			 selenium.setSpeed(MID_SPEED);
			 selenium.click("idFormSaveButton");
			 selenium.setSpeed(MIN_SPEED);
    	 } else {
    		 System.out.println("user lastName is admin");
    		 selenium.setSpeed(MIN_SPEED);
    	 }
      	 users = this.findSpecialMachedStrings(".*@[a-zA-Z0-9]*\\.com");

    	 for(int i=0;i<users.size();i++) {
    		 System.out.println(users.get(i));
    		 if(!"admin@company.com".equals(users.get(i))) {
    			selenium.mouseDown("//div[text()='"+users.get(i)+"']");
  				selenium.chooseOkOnNextConfirmation();
  				selenium.click("idSubModuleDeleteButton");

  				selenium.getConfirmation().contains("you sure you want to remove the selected user");
  				selenium.setSpeed(MID_SPEED);
  				Assert.assertFalse(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-label' and (text()='"
  						+ users.get(i) + "')]"));
  				selenium.setSpeed(MIN_SPEED);
    		 } 
    	 }
    	 selenium.setSpeed(MIN_SPEED);
    }
    
    //add a user of user'role are all roles
    @Test	
    @Parameters({"userNameAllRoles","firstName","lastName","passWord","svnLogin","svnPassWord"})
	public void testAddUserAllRoles(String userName,String firstName,String lastName,String passWord,String svnLogin,
			String svnPassWord) throws Exception {
    	String roles = rb.getString("menu.role.administrator")+"/"+rb.getString("menu.role.viewer")+"/"
		+rb.getString("menu.role.operationManager")+"/"+rb.getString("menu.role.designer");
    	
    	addUser(userName, firstName, lastName, passWord,svnLogin,svnPassWord,"Data Integration");
        
        selenium.click("idRoleButton");
	    selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
	   
	    selenium.click("//span[text()='Role']/parent::div[not(contains(@style,'display: none'))]/" +
	    		"parent::td[not(contains(@style,'display: none'))]/preceding-sibling::td" +
	    		"[not(contains(@style,'display: none'))]/div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");

	    selenium.setSpeed(MIN_SPEED);
	    selenium.click("idValidateButton");
	    selenium.setSpeed(MID_SPEED);
        Assert.assertEquals(selenium.getValue("idActiveInput"), roles);
        selenium.setSpeed(MIN_SPEED);	
        selenium.click("idFormSaveButton");
        this.waitForElementPresent("//div[text()='"+userName+"']", WAIT_TIME);
        Assert.assertTrue(selenium.isElementPresent("//div[text()='"+userName+"']"));
       
	}
    
   
    //add a exist user(admin@company.com)
	@Test
	@Parameters({"userName","firstName","lastName","passWord","svnLogin","svnPassWord"})
	public void testAddExistUser(String userName,String firstName,String lastName,String passWord,
			String svnLogin,String svnPassWord) throws Exception {
	
	    addUser(userName, firstName, lastName, passWord, svnLogin, svnPassWord,"Data Integration");
		
	    selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+ rb.getString("menu.role.operationManager")+"')]");

		selenium.click("idValidateButton");
		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.operationManager"));
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.error.uniqueLogin")));
        selenium.setSpeed(MIN_SPEED);
	}
	
    //add a user of role is 'administrator'
	@Test
	@Parameters({"loginNameChooseAdministratorRole","firstName","lastName","passWord","svnLogin","svnPassWord"})
	public void testAddNewUserRoleAdministrator(String loginNameChooseAdministratorRole,String firstName,String lastName,
			String passWord,String svnLogin,String svnPassWord) throws Exception {
	    addUser(loginNameChooseAdministratorRole, firstName, lastName, passWord, svnLogin, svnPassWord,"Data Integration");
	    
	    selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+rb.getString("menu.role.administrator")+"')]");
		selenium.click("idValidateButton");

		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//div[text()='"+loginNameChooseAdministratorRole+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+loginNameChooseAdministratorRole+"']"));
			

	}
	
	//add a user of choose mulriple roles
	@Test
	@Parameters({"loginNameChooseMulripleRoles","firstName","lastName","passWord","svnLogin","svnPassWord"})
	public void testAddUserMulripleRoles(String loginNameChooseMulripleRoles,String firstName,String lastName,
			String passWord,String svnLogin,String svnPassWord) throws Exception {
		addUser(loginNameChooseMulripleRoles, firstName, lastName, passWord, svnLogin, svnPassWord,"Data Integration");
		
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.controlKeyDown();
		selenium.mouseDown("//td[not(contains(@style,'display: none'))]/div[text()='"+ rb.getString("menu.role.viewer") + "']" +
				"/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
		selenium.mouseDown("//td[not(contains(@style,'display: none'))]/div[text()='"+ rb.getString("menu.role.designer") + "']" +
		"/parent::td/preceding-sibling::td//div[@class='x-grid3-row-checker']");
		selenium.controlKeyUp();
		selenium.click("idValidateButton");
		selenium.setSpeed(MID_SPEED); 
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//div[text()='"+loginNameChooseMulripleRoles+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+loginNameChooseMulripleRoles+"']"));    
        
        
	}
	
	
	//add a user of uncheck 'Active'
	@Test
	@Parameters({"loginNameNotChooseActive","firstName","lastName","passWord","svnLogin","svnPassWord"})
	public void testAddUserNotChooseActive(String loginNameNotChooseActive,String firstName,String lastName,
			String passWord,String svnLogin,String svnPassWord) throws Exception {
	    
		addUser(loginNameNotChooseActive, firstName, lastName, passWord, svnLogin, svnPassWord,"Data Integration");
		
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+ rb.getString("menu.role.viewer")+"')]");
		selenium.click("idValidateButton");
		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.viewer"));

		selenium.click("//input[@name='active']");
		Assert.assertFalse(selenium.isChecked("//input[@name='active']"));
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='"+loginNameNotChooseActive+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+loginNameNotChooseActive+"']"));
		
    }
	
	//add a user of type choose "Data Integration"
	@Test
	@Parameters({"loginName","firstName","lastName","passWordww","svnLogin","svnPassWord"})
	public void testAddUserRoleDesignerTypeDataIntegration(String loginName,String firstName,String lastName,
			String passWordww,String svnLogin,String svnPassWord) throws Exception {
		addUser(loginName, firstName, lastName, passWordww, svnLogin, svnPassWord,"Data Integration");

		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+  rb.getString("menu.role.designer")+"')]");//choose a  role
		selenium.click("idValidateButton");
		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.designer"));
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='"+loginName+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+loginName+"']"));
		Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-userType']" +
		"/img[@alt='Data Integration']"));
		
	}
	
	//add a user of type choose "Data Quality"
	@Test
	@Parameters({"loginNameChooseTypeDataQuality","firstName","lastName",
		"passWordww","svnLogin","svnPassWord"})
	public void testAddUserTypeChooseDataQuality(String loginName,String firstName,String lastName,
			String passWordww,String svnLogin,String svnPassWord) throws Exception {
		addUser(loginName, firstName, lastName, passWordww, svnPassWord, svnPassWord,"Data Quality");
        if("Data Quality".equals(selenium.getValue("idTypeInput"))) {
        	
        	selenium.click("idRoleButton");
    		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
    		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"
    				+  rb.getString("menu.role.operationManager")+"')]");//choose a  role
    		selenium.click("idValidateButton");
    		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.operationManager"));
    		selenium.setSpeed(MID_SPEED);
    		selenium.click("idFormSaveButton");
    		selenium.setSpeed(MIN_SPEED);
    		
    		this.waitForElementPresent("//div[text()='"+loginName+"']", WAIT_TIME);
    		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+loginName+"']"));
    		Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-userType']" +
    				"/img[@alt='Data Quality']"));
    		
        	
        }
		
	}
	
	//add a user of a wrong username
	@Test
	@Parameters({"loginNameWrongForm","firstName","lastName","passWordww","svnLogin","svnPassWord"})
    public void testAddUserLoginWrongForm(String loginName,String firstName,String lastName,
			String passWordww,String svnLogin,String svnPassWord) throws Exception {
		addUser(loginName, firstName, lastName, passWordww, svnLogin, svnPassWord,"Data Integration");
        
    	selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"
				+  rb.getString("menu.role.operationManager")+"')]");//choose a  role
		selenium.setSpeed(MID_SPEED);
        Assert.assertTrue(selenium.isElementPresent("//img[@class='gwt-Image x-component ']"));
	    selenium.setSpeed(MIN_SPEED);
        
	}
	
	//add a user under MySql setting
	@Test
	@Parameters({"loginNameUnderMySql","firstName","lastName","passWordww","svnLogin","svnPassWord"})
	public void testUnderMysqlAddUser(String loginName,String firstName,String lastName,
			String passWordww,String svnLogin,String svnPassWord) throws Exception {
		addUser(loginName, firstName, lastName, passWordww, svnLogin, svnPassWord,"Data Integration");

		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+  rb.getString("menu.role.designer")+"')]");//choose a  role
		selenium.click("idValidateButton");
		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.designer"));
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='"+loginName+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+loginName+"']"));
		Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-userType']" +
		"/img[@alt='Data Integration']"));
		
	}
	
}
