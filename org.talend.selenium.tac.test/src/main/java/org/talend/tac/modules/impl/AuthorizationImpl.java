package org.talend.tac.modules.impl;

import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.Authorization;

public class AuthorizationImpl extends Authorization {

	public AuthorizationImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void authorizationImpl(String user_name, String project, String user_info){
		this.gotoAuthorzationPage();
		this.authorization(user_name, project, user_info);
	}
	
	public void reAuthorizationImpl(String user_name, String project, String user_info){
		this.gotoAuthorzationPage();
		this.reAuthorization(user_name, project, user_info);
	}
	
	public void deleteAuthorizationImpl(String project, String lastName, String firstName){
		this.gotoAuthorzationPage();
		this.deleteAuthorization(project, lastName, firstName);
	}
	
	public void setAuthorizationReadOnlyImpl(String project, String lastName, String firstName){
		this.gotoAuthorzationPage();
		this.setAuthorizationReadOnly(project, lastName, firstName);
	}
	
	public void setAuthorizationReadAndWriteImpl(String project, String lastName, String firstName){
		this.gotoAuthorzationPage();
		this.setAuthorizationReadAndWrite(project, lastName, firstName);
	}
	
	public void resetColumnImpl(){
		this.gotoAuthorzationPage();
		this.resetColumn();
	}
}
