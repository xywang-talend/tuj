package com.talend.tac.cases.users;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class TestModifyUser extends Users {

   
	//login user --->>uncheck "active"
	@Test
	@Parameters({"userName"})
	public void testLastLoginUserNotChooseActive(String userName) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
		this.waitForElementPresent("//div[text()='"+userName+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isTextPresent(userName));
        selenium.mouseDown("//div[text()='"+userName+"']");
        
		selenium.click("//input[@name='active']");
        
		Assert.assertFalse(selenium.isChecked("//input[@name='active']"));
		
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.error.lastActiveAdmin")));
	    selenium.setSpeed(MIN_SPEED);
	}
	//modify user'role of last a "administrator" user
	@Test
	@Parameters({"userName"})
	public void testModifyLastAdministrationUserRole(String userName) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.setSpeed(MIN_SPEED);
        selenium.mouseDown("//div[text()='"+userName+"']");
		selenium.click("idRoleButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.setSpeed(MIN_SPEED);
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+rb.getString("menu.role.designer")+"')]");	
		selenium.click("idValidateButton");
		
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.error.roleModification.lastAdministrator")));
	    selenium.setSpeed(MIN_SPEED);
	
	}
	
	//modify user(admin@company.com)'role to all roles
	@Test
//	(dependsOnMethods={"testModifyLastAdministrationUserRole"})
	@Parameters({"userName", "userPassword"})
	public void testUserChooseAllRoles(String userName,String userPassword) throws Exception {
		String roles = rb.getString("menu.role.administrator")+"/"+rb.getString("menu.role.viewer")+"/"
		+rb.getString("menu.role.operationManager")+"/"+rb.getString("menu.role.designer");
		this.clickWaitForElementPresent("idMenuUserElement");
		
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.mouseDown("//div[text()='"+userName+"']");//Select Login user
		
		if(selenium.isTextPresent("Role: Administrator/Viewer/Operation manager/Designer (1 Member)")) {
			System.out.println("right are all roles");
		} else {
			System.out.println("!-------------------------------ss right are all roles");
			
			selenium.click("idRoleButton");
			selenium.setSpeed(MAX_SPEED);
			Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
			selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-checker x-component']");
			selenium.click("idValidateButton");
	        Assert.assertEquals(selenium.getValue("idActiveInput"), roles);

			selenium.click("idFormSaveButton");

	        selenium.refresh();

	        Assert.assertEquals(selenium.getText("//div[@class='x-grid-group-div']"), "Role: Administrator/Viewer/Operation manager/Designer (1 Member)");
			Assert.assertTrue(selenium.isElementPresent("!!!menu.jobConductor.element!!!"));
	        selenium.setSpeed(MIN_SPEED);
		}
	}	
	
	//modify user(admin@company.com)'name(lastname,firstname) 
	@Test
	@Parameters({"userName","firstName","lastName","svnLogin","svnPassWord"})
	public void testModityAdminUserFiled(String userName, String firstName,String lastName
			,String svnLogin,String svnPassWord) throws Exception {
		this.clickWaitForElementPresent("idMenuUserElement");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(userName));
		selenium.setSpeed(MIN_SPEED);
		selenium.mouseDown("//div[text()='"+userName+"']");
		selenium.type("idUserFirstNameInput", firstName);
		selenium.fireEvent("idUserFirstNameInput", "blur");
		selenium.type("idUserLastNameInput", lastName);
		selenium.fireEvent("idUserLastNameInput", "blur");
		selenium.type("//input[@name='authenticationLogin']", svnLogin);
		selenium.fireEvent("//input[@name='authenticationLogin']", "blur");
		selenium.type("//input[@name='authenticationPassword']", svnPassWord);
		selenium.fireEvent("//input[@name='authenticationPassword']", "blur");
		
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MID_SPEED);
		Assert.assertEquals(selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-lastName']"), lastName);
		selenium.setSpeed(MIN_SPEED);
		
		selenium.refresh();
		this.waitForElementPresent("//b[text()='zhang, jack']", WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//b[text()='zhang, jack']"));
	}
    
	//modify user(aaa@gmail.com)'loginName to 'account@company.com'
	@Test
	@Parameters({"userName","modifiyUserName","dulicateUser"})
	public void testModifyUser(String userName,String modifiyUserName,String dulicateUser) throws Exception {
	    
		this.clickWaitForElementPresent("idMenuUserElement");
		Assert.assertTrue(selenium.isTextPresent(userName));
		if(selenium.isTextPresent(modifiyUserName)) {
			System.out.println(dulicateUser +  " is exist user");
			
		} else {
			selenium.mouseDown(dulicateUser);
			selenium.type("idUserLoginInput", modifiyUserName);
			selenium.fireEvent("idUserLoginInput", "blur");
			
			selenium.click("idFormSaveButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//div[text()='"+modifiyUserName+"']"));
			selenium.setSpeed(MIN_SPEED);
		}
		
	}
	
	//change a user role, login again, check its role whether normal display in the Lower-Left Corner
	@Test
	@Parameters({"loginNameChangeRoleAndCheckRoleDisplay","firstName","lastName","passWord",
		"svnLogin","svnPassWord","userName", "userPassword"})
    public void testChangeUserRoleAndCheckRoleDisplay(String loginName,String firstName,String lastName,
			String loginUserPassWord,String svnLogin,String svnPassWord,String adminUser, String adminPassword) {
		
		this.waitForElementPresent("//b[text()='admin, admin']", WAIT_TIME);
		this.waitForElementPresent("//i[text()='Administrator/Viewer/Operation manager/Designer']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//i[text()='Administrator/Viewer/Operation manager/Designer']"));
		Assert.assertTrue(selenium.isElementPresent("//b[text()='admin, admin']"));
		//add user(loginNameChangeRoleAndCheckRoleDisplay@gmail.com)
		this.addUser(loginName, firstName, lastName, loginUserPassWord, svnLogin, svnPassWord, "Data Quality");
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+ rb.getString("menu.role.viewer")+"')]");
		selenium.click("idValidateButton");
		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.viewer"));
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		this.waitForElementPresent("//div[text()='"+loginName+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+loginName+"']"));		
		//logout tac
		selenium.click("idLeftMenuTreeLogoutButton");
		this.waitForElementPresent("idLoginButton", WAIT_TIME);
		//with loginNameChangeRoleAndCheckRoleDisplay@gmail.com login TAC
		this.loginTac(loginName, loginUserPassWord);
		//check role whether normal display in the Lower-Left Corner
		this.waitForElementPresent("//i[text()='"+rb.getString("menu.role.viewer")+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//i[text()='"+rb.getString("menu.role.viewer")+"']"));
		Assert.assertTrue(selenium.isElementPresent("//b[text()='"+lastName+", "+firstName+"']"));
		//logout tac		
		selenium.click("idLeftMenuTreeLogoutButton");
		this.waitForElementPresent("idLoginButton", WAIT_TIME);
		//with admin user login tac
		this.loginTac(adminUser, adminPassword);
		//change user(loginNameChangeRoleAndCheckRoleDisplay@gmail.com)'role to "Operation manager"
		this.clickWaitForElementPresent("idMenuUserElement");
		this.waitForElementPresent("//div[text()='"+loginName+"']", WAIT_TIME);
		selenium.mouseDown("//div[text()='"+loginName+"']");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selenium.click("idRoleButton");
		Assert.assertTrue(selenium.isTextPresent(rb.getString("user.roles.title")));
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-name' and (text()='"+ rb.getString("menu.role.operationManager")+"')]");

		selenium.click("idValidateButton");
		Assert.assertEquals(selenium.getValue("idActiveInput"), rb.getString("menu.role.operationManager"));
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		
		Assert.assertTrue(selenium.isElementPresent("//div[text()='"+loginName+"']//ancestor::div[contains(@class,'x-grid-group')]" +
				"//div[contains(text(),'Role: Operation manager')]"));
		selenium.setSpeed(MIN_SPEED);
        //logout
		selenium.click("idLeftMenuTreeLogoutButton");
		this.waitForElementPresent("idLoginButton", WAIT_TIME);
		//with loginNameChangeRoleAndCheckRoleDisplay@gmail.com login TAC 
		this.loginTac(loginName, loginUserPassWord);
		//check role whether normal display in the Lower-Left Corner again
		this.waitForElementPresent("//i[text()='"+rb.getString("menu.role.operationManager")+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//i[text()='"+rb.getString("menu.role.operationManager")+"']"));
		Assert.assertTrue(selenium.isElementPresent("//b[text()='"+lastName+", "+firstName+"']"));
		
		//logout tac		
		selenium.click("idLeftMenuTreeLogoutButton");
		this.waitForElementPresent("idLoginButton", WAIT_TIME);
		//with admin user login tac
		this.loginTac(adminUser, adminPassword);
		//delete the user ( loginNameChangeRoleAndCheckRoleDisplay@gmail.com)
		deleteUser(adminUser, loginName);
		
	}
		
}
