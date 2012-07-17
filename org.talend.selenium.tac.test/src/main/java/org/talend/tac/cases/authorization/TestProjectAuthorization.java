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
	@Parameters( {"userAuth", "auth.FirstName", "auth.LastName", "user.passWord", "type.DI",
		"addCommonProjectName", "auth.user.readwrite.info"})
	public void testDeleteAuthorization(String user, String firstName, String lastName
			, String passWord, String typeName, String project, String userInfo){
					   	
		authorizationImpl.deleteAuthorizationImpl(user, firstName, lastName, passWord, typeName, rb.getString("menu.role.designer"), project, userInfo);
	
	}
	
	@Test
	@Parameters( {"userAuth", "auth.FirstName", "auth.LastName",
		"addCommonProjectName", "user.readwrite.info", "auth.user.readonly.info", "user.passWord", "type.DI"})
	public void testSetAuthorizationReadOnly(String user, String firstName, String lastName, 
			String project, String userReadwriteInfo, String userReadonlyInfo, String passWord, String typeName){
		authorizationImpl.setAuthorizationReadOnlyImpl(user, project, lastName, firstName, userReadwriteInfo, userReadonlyInfo
				, passWord, typeName, rb.getString("menu.role.designer"));
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
		authorizationImpl.refreshAfterNewProjectCreatedImpl(project, type);
	}	

	@Test
	@Parameters( {"userAuthDI", "di.FirstName", "di.LastName", "user.passWord", "type.DI",
		"proAuthDI", "di.user.info"})
	public void testAuthDIUserToDIPro(String user, String firstName, String lastName
			, String passWord, String typeDI, String project, String userInfo){
					   	
		authorizationImpl.authDIUserToDIProImpl(user, firstName, lastName, passWord, rb.getString("menu.role.designer"), project, typeDI, userInfo);
	
	}

	@Test
	@Parameters( {"userAuthDI", "dq.FirstName", "dq.LastName", "user.passWord", "type.DQ",
		"proAuthDQ", "dq.user.info"})
	public void testAuthDIUserToDQPro(String user, String firstName, String lastName
			, String passWord, String typeDQ, String project, String userInfo){
					   	
		authorizationImpl.authDIUserToDQProImpl(user, firstName, lastName, passWord, rb.getString("menu.role.designer"), project, typeDQ, userInfo);
	
	}

	@Test
	@Parameters( {"userAuthDI", "mdm.FirstName", "mdm.LastName", "user.passWord", "type.MDM",
		"proAuthMDM", "mdm.user.info"})
	public void testAuthDIUserToMDMPro(String user, String firstName, String lastName
			, String passWord, String typeMDM, String project, String userInfo){
					   	
		authorizationImpl.authDIUserToMDMProImpl(user, firstName, lastName, passWord, rb.getString("menu.role.designer"), project, typeMDM, userInfo);
	
	}

	@Test
	@Parameters( {"userAuthDQ", "dq.FirstName", "dq.LastName", "user.passWord", "type.DQ",
		"proAuthDQ", "dq.user.info"})
	public void testAuthDQUserToDIPro(String user, String firstName, String lastName
			, String passWord, String typeDQ, String project, String userInfo){
					   	
		authorizationImpl.authDQUserToDIProImpl(user, firstName, lastName, passWord, rb.getString("menu.role.designer"), project, typeDQ, userInfo);
	
	}

	@Test
	@Parameters( {"userAuthDQ", "dq.FirstName", "dq.LastName", "user.passWord", "type.DQ",
		"proAuthDQ", "dq.user.info"})
	public void testAuthDQUserToDQPro(String user, String firstName, String lastName
			, String passWord, String typeDQ, String project, String userInfo){
					   	
		authorizationImpl.authDQUserToDQProImpl(user, firstName, lastName, passWord, rb.getString("menu.role.designer"), project, typeDQ, userInfo);
	
	}
	
}
