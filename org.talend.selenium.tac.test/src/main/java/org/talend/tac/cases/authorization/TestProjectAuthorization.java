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
	@Parameters( { "userName", "addCommonProjectName", "addReferenceProjectName", 
		"projectWithSpaceChar", "user.readwrite.info"})
	public void testAuthorization(String userName, String commonpro,
			String refPro, String spacePro, String userInfo){	
		
		authorizationImpl.authorizationImpl(userName, commonpro, userInfo);
		authorizationImpl.authorizationImpl(userName, refPro, userInfo);
		authorizationImpl.authorizationImpl(userName, spacePro, userInfo);
		
		
	}
	
	@Test
	@Parameters( { "userName", "addCommonProjectName", "user.readwrite.info" })
	public void testReAuthorization(String userName, String project, String userInfo){
		authorizationImpl.reAuthorizationImpl(userName, project, userInfo);
	}
	
	@Test
	@Parameters( {"user.Auth", "auth.FirstName", "auth.LastName", "user.passWord", "type.DI",
		"addCommonProjectName", "auth.user.readwrite.info"})
	public void testDeleteAuthorization(String user, String firstName, String lastName
			, String passWord, String typeName, String project, String userInfo){
					   	
		authorizationImpl.deleteAuthorizationImpl(user, firstName, lastName, passWord, typeName, rb.getString("menu.role.designer"), project, userInfo);
	
	}
	
	@Test
	@Parameters( {"user.Auth", "auth.FirstName", "auth.LastName",
		"addCommonProjectName", "user.readwrite.info", "auth.user.readonly.info"})
	public void testSetAuthorizationReadOnly(String user, String firstName, String lastName, 
			String project, String userReadwriteInfo, String userReadonlyInfo){
		authorizationImpl.setAuthorizationReadOnlyImpl(user, project, lastName, firstName, userReadwriteInfo, userReadonlyInfo);
	}
	
	@Test
	@Parameters( { "auth.FirstName", "auth.LastName", "addCommonProjectName", "user.readwrite.info"})
	public void testSetAuthorizationReadAndWrite(String firstName, String lastName
			, String project, String userReadwriteInfo){
		authorizationImpl.setAuthorizationReadAndWriteImpl(project, lastName, firstName, userReadwriteInfo);
	}
	

	@Test
	@Parameters( { "projectLabel", "type.DI"})
	public void testAfterNewProjectCreated(String project, String type){
		authorizationImpl.refreshAfterNewProjectCreated(project, type);
	}
	
	
}
