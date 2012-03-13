package org.talend.tac.cases.authorization;

import org.talend.tac.base.WebdriverLogin;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.talend.tac.modules.impl.AuthorizationImpl;

public class TestProjectAuthorization extends WebdriverLogin {
	AuthorizationImpl authorizationImpl;
	@BeforeMethod
	public void beforeMethod(){
		authorizationImpl = new AuthorizationImpl(driver);
	}
	
	@Test
	@Parameters( { "user_name", "project" })
	public void testAuthorization(String user_name, String project){
		authorizationImpl.authorizationImpl(user_name, project);
	}
	
	@Test
	@Parameters( { "user_name", "project" })
	public void testReAuthorization(String user_name, String project){
		authorizationImpl.reAuthorizationImpl(user_name, project);
	}
	
	@Test
	@Parameters( {"project",  "last.name", "first.name" })
	public void testDeleteAuthorization(String project, String lastName, String firstName){
		authorizationImpl.deleteAuthorization(project, lastName, firstName);
	}
	@Test
	@Parameters( {"project",  "last.name", "first.name" })
	public void testSetAuthorizationReadOnly(String project, String lastName, String firstName){
		authorizationImpl.setAuthorizationReadOnly(project, lastName, firstName);
	}
	
	@Test
	@Parameters( {"project",  "last.name", "first.name" })
	public void testSetAuthorizationReadAndWrite(String project, String lastName, String firstName){
		authorizationImpl.setAuthorizationReadAndWrite(project, lastName, firstName);
	}
}
