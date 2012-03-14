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
	@Parameters( { "userName", "AddcommonProjectname", "AddreferenceProjectname", 
		"ProjectWithSpaceChar", "user.info"})
	public void testAuthorization(String user_name, String commonpro,
			String refPro, String spacePro, String user_info){	
		
		authorizationImpl.authorizationImpl(user_name, commonpro, user_info);
		authorizationImpl.authorizationImpl(user_name, refPro, user_info);
		authorizationImpl.authorizationImpl(user_name, spacePro, user_info);
		
		
	}
	
	@Test
	@Parameters( { "userName", "AddcommonProjectname",  "user.info" })
	public void testReAuthorization(String user_name, String project, String user_info){
		authorizationImpl.reAuthorizationImpl(user_name, project, user_info);
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
