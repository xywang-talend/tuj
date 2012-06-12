package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.User;

public class UserImpl extends User {

	public UserImpl(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
	}
    
	/*
	 * add method for add user
	 * */
	public void addUserImpl(String user, String firstName, String lastName, String passWord
			, String svnLogin, String svnPassWord, String typeName, String role) {
		
		logger.info("go to user page");
		this.gotoUserPage();
		logger.info("add user");
		this.addUser(user, firstName, lastName, passWord, svnLogin, svnPassWord, typeName, role);
		
	}
	
}
