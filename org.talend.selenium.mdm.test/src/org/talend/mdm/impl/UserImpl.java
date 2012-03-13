package org.talend.mdm.impl;

import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.User;


public class UserImpl extends User{

	public UserImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void addUserImpl(String identifier,String firstName,String lastName,String password,String confirmPassword,
			String email, String company, String defaultVersion, boolean active, String[] roles){
		this.gotoUserManagePage();
		this.addUser(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles);
	}
}
