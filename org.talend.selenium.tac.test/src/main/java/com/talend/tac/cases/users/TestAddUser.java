package com.talend.tac.cases.users;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddUser extends Users {
    
	
	//clear all users---modify firstname and lastname to "admin,admin" ---user'role change to 'administrator'
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
			 this.typeString("idUserLastNameInput", "admin");
			 selenium.setSpeed(MID_SPEED);
			 selenium.click("idFormSaveButton");
			 selenium.setSpeed(MIN_SPEED);
    	 } else {
    		 System.out.println("user lastname is admin");
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
    @Parameters({"userNameAllRoles","FirstName","LastName","PassWord","SvnLogin","SvnPassWord"})
	public void testAddUserAllRoles(String userName,String FirstName,String LastName,String PassWord,String SvnLogin,
			String SvnPassWord) throws Exception {
    	String roles = rb.getString("menu.role.administrator")+"/"+rb.getString("menu.role.viewer")+"/"
		+rb.getString("menu.role.operationManager")+"/"+rb.getString("menu.role.designer");
    	
    	addUser(userName, FirstName, LastName, PassWord,SvnLogin,SvnPassWord,"Data Integration");
        
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
	@Parameters({"userName","FirstName","LastName","PassWord","SvnLogin","SvnPassWord"})
	public void testAddExistUser(String userName,String FirstName,String LastName,String PassWord,
			String SvnLogin,String SvnPassWord) throws Exception {
	
	    addUser(userName, FirstName, LastName, PassWord, SvnLogin, SvnPassWord,"Data Integration");
		
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
	@Parameters({"LoginNameChooseAdministratorRole","FirstName","LastName","PassWord","SvnLogin","SvnPassWord"})
	public void testAddNewUserRoleAdministrator(String LoginNameChooseAdministratorRole,String FirstName,String LastName,
			String PassWord,String SvnLogin,String SvnPassWord) throws Exception {
	    addUser(LoginNameChooseAdministratorRole, FirstName, LastName, PassWord, SvnLogin, SvnPassWord,"Data Integration");
	    
	    selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+rb.getString("menu.role.administrator")+"')]");
		selenium.click("idValidateButton");

		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//div[text()='"+LoginNameChooseAdministratorRole+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginNameChooseAdministratorRole+"']"));
			

	}
	
	//add a user of choose mulriple roles
	@Test
	@Parameters({"LoginNameChooseMulripleRoles","FirstName","LastName","PassWord","SvnLogin","SvnPassWord"})
	public void testAddUserMulripleRoles(String LoginNameChooseMulripleRoles,String FirstName,String LastName,
			String PassWord,String SvnLogin,String SvnPassWord) throws Exception {
		addUser(LoginNameChooseMulripleRoles, FirstName, LastName, PassWord, SvnLogin, SvnPassWord,"Data Integration");
		
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
		this.waitForElementPresent("//div[text()='"+LoginNameChooseMulripleRoles+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginNameChooseMulripleRoles+"']"));    
        
        
	}
	
	
	//add a user of uncheck 'Active'
	@Test
	@Parameters({"LoginNameNotChooseActive","FirstName","LastName","PassWord","SvnLogin","SvnPassWord","LoginNameNotChooseActive"})
	public void testAddUserNotChooseActive(String LoginNameNotChooseActive,String FirstName,String LastName,
			String PassWord,String SvnLogin,String SvnPassWord,String LoginNameNotChooseActive1) throws Exception {
	    
		addUser(LoginNameNotChooseActive, FirstName, LastName, PassWord, SvnLogin, SvnPassWord,"Data Integration");
		
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
		
		this.waitForElementPresent("//div[text()='"+LoginNameNotChooseActive1+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginNameNotChooseActive1+"']"));
		
    }
	
	//add a user of type choose "Data Integration"
	@Test
	@Parameters({"LoginName","FirstName","LastName","PassWordww","SvnLogin","SvnPassWord"})
	public void testAddUserRoleDesignerTypeDataIntegration(String LoginName,String FirstName,String LastName,
			String PassWordww,String SvnLogin,String SvnPassWord) throws Exception {
		addUser(LoginName, FirstName, LastName, PassWordww, SvnLogin, SvnPassWord,"Data Integration");

		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+  rb.getString("menu.role.designer")+"')]");//choose a  role
		selenium.click("idValidateButton");
		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.designer"));
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='"+LoginName+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginName+"']"));
		Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-userType']" +
		"/img[@alt='Data Integration']"));
		
	}
	
	//add a user of type choose "Data Quality"
	@Test
	@Parameters({"LoginNameChooseTypeDataQuality","FirstName","LastName",
		"PassWordww","SvnLogin","SvnPassWord"})
	public void testAddUserTypeChooseDataQuality(String LoginName,String FirstName,String LastName,
			String PassWordww,String SvnLogin,String SvnPassWord) throws Exception {
		addUser(LoginName, FirstName, LastName, PassWordww, SvnPassWord, SvnPassWord,"Data Quality");
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
    		
    		this.waitForElementPresent("//div[text()='"+LoginName+"']", WAIT_TIME);
    		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginName+"']"));
    		Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-userType']" +
    				"/img[@alt='Data Quality']"));
    		
        	
        }
		
	}
	
	//add a user of a wrong username
	@Test
	@Parameters({"LoginNameWrongForm","FirstName","LastName","PassWordww","SvnLogin","SvnPassWord"})
    public void testAddUserLoginWrongForm(String LoginName,String FirstName,String LastName,
			String PassWordww,String SvnLogin,String SvnPassWord) throws Exception {
		addUser(LoginName, FirstName, LastName, PassWordww, SvnLogin, SvnPassWord,"Data Integration");
        
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
	@Parameters({"LoginNameUnderMySql","FirstName","LastName","PassWordww","SvnLogin","SvnPassWord"})
	public void testUnderMysqlAddUser(String LoginName,String FirstName,String LastName,
			String PassWordww,String SvnLogin,String SvnPassWord) throws Exception {
		addUser(LoginName, FirstName, LastName, PassWordww, SvnLogin, SvnPassWord,"Data Integration");

		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+  rb.getString("menu.role.designer")+"')]");//choose a  role
		selenium.click("idValidateButton");
		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.designer"));
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='"+LoginName+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+LoginName+"']"));
		Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-userType']" +
		"/img[@alt='Data Integration']"));
		
	}
	
}
