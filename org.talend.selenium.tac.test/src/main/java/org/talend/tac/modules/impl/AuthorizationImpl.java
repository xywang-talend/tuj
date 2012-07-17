package org.talend.tac.modules.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.tac.modules.Authorization;

public class AuthorizationImpl extends Authorization {
	
	UserImpl userImpl = new UserImpl(driver);
	ProjectImpl projectImpl = new ProjectImpl(driver);
	public AuthorizationImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
    
	/*
	 * Simply create a authorization
	 * */
	public void authorizationImpl(String userName, String project, String userInfo){
		this.gotoAuthorzationPage();
		this.authorization(userName, project, userInfo);
	}
	
	/*
	 * Create an authorization that already exists
	 * */
	public void reAuthorizationImpl(String userName, String project, String userInfo){
		this.gotoAuthorzationPage();
		this.reAuthorization(userName, project, userInfo);
	}
	
	/*
	 * Delete an authorization(auto)
	 * */
	public void deleteAuthorizationImpl(String user, String firstName, String lastName
			, String passWord, String typeName, String role, String project, String userInfo){
		
		this.gotoAuthorzationPage();
		this.authorization(user, project, userInfo);
		this.deleteAuthorization(project, lastName, firstName, userInfo);
		
	}
	
	/*
	 * Turn an authorization to read-only(auto)
	 * */
	public void setAuthorizationReadOnlyImpl(String user, String project, String lastName,
			String firstName, String userReadwriteInfo, String userReadonlyInfo, String passWord, String typeName, String role){
		

		userImpl.addUserImpl(user, firstName, lastName, passWord, "",
				"", typeName, role);
		this.gotoAuthorzationPage();
		this.authorization(user, project, userReadwriteInfo);
		this.setAuthorizationReadOnly(project, lastName, firstName, userReadonlyInfo);
	}
	
	/*
	 * Turn an authorization to read-write
	 * */
	public void setAuthorizationReadAndWriteImpl(String project, String lastName,
			String firstName, String userReadwriteInfo){
		this.gotoAuthorzationPage();
		this.setAuthorizationReadAndWrite(project, lastName, firstName, userReadwriteInfo);
	}
	
	public void resetColumnImpl(){
		this.gotoAuthorzationPage();
		this.resetColumn();
	}
	
	public void refreshAfterNewProjectCreatedImpl(String project, String type) {
		
		projectImpl.addProjectImpl(project, type, 1);
		
		this.gotoAuthorzationPage();
		this.waitforElementDisplayed(By.xpath("//span[text()='Projects']//ancestor::div[contains(@class,'x-small-editor x-panel-head')]//following-sibling::div//span[text()='"+project+"']"), WAIT_TIME_MIN);
		
		projectImpl.deleteProjectImpl(project);
		
	}

	public void authDIUserToDIProImpl(String user, String firstName, String lastName, String passWord, 
			String role, String project, String typeDI, String userInfo) {
		
		userImpl.addUserImpl(user, firstName, lastName, passWord, "",
				"", typeDI, role);
		
		projectImpl.addProjectImpl(project, typeDI, 1);
		
		this.gotoAuthorzationPage();
		this.authorization(user, project, userInfo);
		
		this.deleteAuthorization(project, lastName, firstName, userInfo);		
		
	}

	public void authDIUserToDQProImpl(String user, String firstName, String lastName, String passWord, 
			String role, String project, String typeDQ, String userInfo) {
		
		
		projectImpl.addProjectImpl(project, typeDQ, 1);
		
		this.gotoAuthorzationPage();
		this.authorizationFailed(user, project, userInfo);		
		
	}	

	public void authDIUserToMDMProImpl(String user, String firstName, String lastName, String passWord, 
			String role, String project, String typeMDM, String userInfo) {
		
		
		projectImpl.addProjectImpl(project, typeMDM, 1);
		
		this.gotoAuthorzationPage();
		this.authorizationFailed(user, project, userInfo);		
		
	}

	public void authDQUserToDIProImpl(String user, String firstName, String lastName, String passWord, 
			String role, String project, String typeDQ, String userInfo) {
		
		userImpl.addUserImpl(user, firstName, lastName, passWord, "",
				"", typeDQ, role);
				
		this.gotoAuthorzationPage();
		this.authorization(user, project, userInfo);
		
		this.deleteAuthorization(project, lastName, firstName, userInfo);		
		
	}

	public void authDQUserToDQProImpl(String user, String firstName, String lastName, String passWord, 
			String role, String project, String typeDQ, String userInfo) {
		
		this.gotoAuthorzationPage();
		this.authorization(user, project, userInfo);
		
		this.deleteAuthorization(project, lastName, firstName, userInfo);		
		
	}

}
