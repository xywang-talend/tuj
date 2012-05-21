package com.talend.tac.cases.users;

import java.awt.Event;

import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class Users extends Login {
	
	//creat a method for 'add user'
	public void addUser(String user,String firstname,String lastname,String password,
			String SvnLogin,String SvnPassWord,String typeName) {
		

		this.clickWaitForElementPresent("idMenuUserElement");
		Assert.assertTrue(selenium.isTextPresent("admin@company.com"));
		selenium.setSpeed(MID_SPEED);
		selenium.click("idSubModuleAddButton");//add a user
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//img[@class='gwt-Image x-component ']"));
		selenium.setSpeed(MIN_SPEED);
		this.typeString("idUserLoginInput", user);//user name
		this.typeString("idUserFirstNameInput", firstname);
		this.typeString("idUserLastNameInput", lastname);
		this.typeString("idUserPasswordInput", password);
		this.typeString("idSvnLogin", SvnLogin);
		this.typeString("idSvnPwd", SvnPassWord);
	    if(selenium.isVisible("//label[text()='Type:']/parent::div//div[@class='x-form-trigger x-form-trigger-arrow']")) {
	    	
	    	selenium.click("//label[text()='Type:']/parent::div//div[@class='x-form-trigger x-form-trigger-arrow']");
			this.waitForElementPresent("//div[contains(@class, 'x-combo-list')]/" +
					"descendant::div[contains(@class, 'x-combo-list-item')][text()='"+typeName+"']", WAIT_TIME);
			if(selenium.isElementPresent("//div[contains(@class, 'x-combo-list')]/" +
					"descendant::div[contains(@class, 'x-combo-list-item')][text()='"+typeName+"']")) {
				selenium.mouseDownAt("//div[contains(@class, 'x-combo-list')]/" +
					"descendant::div[contains(@class, 'x-combo-list-item')][text()='"+typeName+"']", ""+Event.ENTER); 
			    Assert.assertEquals(selenium.getValue("idTypeInput"), typeName);
			}
		    
	    }
		
	}
	
	//login tac
	public void loginTac(String user, String password) {

//		selenium.setSpeed(MID_SPEED);
		
		selenium.windowMaximize();
		this.waitForElementPresent("idLoginInput", WAIT_TIME);
		selenium.type("idLoginInput", user);
		selenium.type("idLoginPasswordInput", password);
		
		selenium.keyPressNative(Event.TAB +"");
		this.waitForElementPresent("idLoginInput", Base.WAIT_TIME);
		selenium.click("idLoginButton");
		selenium.setSpeed(MID_SPEED);
		if (selenium
				.isTextPresent("Failed to log on: user "+user+" already logged on to webapp")) {
			selenium.click("idLoginForceLogoutButton");
			selenium.click("idLoginButton");
		}
		selenium.setSpeed(MIN_SPEED);
		// selenium.waitForPageToLoad("30000");// no need
	}
	
	//creation method for delete a user
	public void deleteUser(String userName,String deleteUserName){		

		this.clickWaitForElementPresent("idMenuUserElement");
		this.waitForElementPresent("//div[text()='"+userName+"']", WAIT_TIME);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(selenium.isElementPresent("//div[text()='"+deleteUserName+"']")) {
			
			selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isTextPresent(userName));
			selenium.setSpeed(MIN_SPEED);
			selenium.mouseDown("//div[text()='"+deleteUserName+"']");//Select an existing user
			selenium.chooseOkOnNextConfirmation();
			selenium.click("idSubModuleDeleteButton");
		    Assert.assertTrue(selenium.getConfirmation().matches("^"+other.getString("delete.User.confirmation")+"[\\s\\S]$"));
			
		}
			  
	}
	
}
