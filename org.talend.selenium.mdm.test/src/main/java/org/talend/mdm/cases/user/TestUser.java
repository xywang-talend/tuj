package org.talend.mdm.cases.user;

import org.talend.mdm.Login;
import org.talend.mdm.impl.LicenseImpl;
import org.talend.mdm.impl.UserImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestUser extends Login {
	UserImpl userImpl;
	LicenseImpl license;
	
	@BeforeMethod
	public void beforeMethod(){
		userImpl = new UserImpl(driver);
		license = new LicenseImpl(driver);
		logger.warn("Set Before Info");
	}
	
	@Test
	@Parameters( { "roles" })
	public void testAddUserAllowedAdmin(String roles) {
		license.openLicense();
		userImpl.addUserAllowed(roles, license.getAvailableAdmin());
	}
	
	@Test
	@Parameters( { "identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testAddUserAdminOverAllowed(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion,boolean active,String roles) {
		license.openLicense();
		userImpl.addUserOverAllowedAdmin(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles,license.getAvailableWeb());
	}
	
	@Test
	@Parameters( { "roles" })
	public void testAddUserAllowedWeb(String roles) {
		license.openLicense();
		userImpl.addUserAllowed(roles, license.getAvailableWeb());
	}
	
	@Test
	@Parameters( { "identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testAddUserWebOverAllowed(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion,boolean active,String roles) {
		license.openLicense();
		userImpl.addUserOverAllowedWeb(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles,license.getAvailableWeb());
	}
	
	@Test
	@Parameters( { "identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testAddUserWebOverAllowedInactive(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion,boolean active,String roles) {
		license.openLicense();
		userImpl.addUserOverAllowedWebInactive(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, roles,license.getAvailableWeb());
	}
	
	@Test
	@Parameters( {"user.name","identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testAddUserMultipleRoles(String userNameAdministrator,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String roles) {
		userImpl.addUserWithMultipleRoles("test",identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, splitParameter(roles));
	}
	
	@Test
	@Parameters( {"user.name","identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testUserSelectedAfterSave(String userNameAdministrator,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String roles) {
		userImpl.userSelectedAfterSave(userNameAdministrator,identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, splitParameter(roles));
	}
	
	@Test
	@Parameters( {"user.name","user.password","identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testUserLoginWithNewRole(String userNameAdministrator,String adminPass,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String roles) {
		userImpl.userLoginWithNewRole(userNameAdministrator,adminPass,identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, (roles));
	}
	
	@Test
	@Parameters( {"user.name","identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testaddUserWithMultipleRolesOneAllowedAnotherNot(String userNameAdministrator,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String roles) {
		userImpl.addUserWithMultipleRolesOneAllowedAnotherNot(userNameAdministrator,identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, splitParameter(roles));
	}
	
	@Test
	@Parameters( {"identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testAddUserWithPasswordNotEqualsConfirmPassword(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String roles) {
		userImpl.addUserWithPasswordNotEqualsConfirmPassword(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, splitParameter(roles));
	}
	
	@Test
	@Parameters( {"user.name","user.password" ,"identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testAddUserInactiveCheckLoginThenActive(String administrator,String adminPass,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String roles) {
		userImpl.AddUserInactiveCheckLoginThenActive(administrator, adminPass, identifier,
				firstName, lastName, password, confirmPassword, email, company,
				defaultVersion, active, (roles));
	}
	
	@Test
	@Parameters( {"identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active"})
	public void testAddUserWithoutSelectRoles(String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active) {
		userImpl.addUserWithoutSelectRoles(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active);
	}
	
	@Test
	@Parameters( {"url","user.name"})
	public void testFlushCache(String url,String userName){
		userImpl.flushCache(userName,url);
	}
	
	@Test
	@Parameters( {"user.name","user.password" ,"identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active","roles.customize", "roles" })
	public void testaddUserWithCustomizeRoles(String administrator,String administratorPass,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String rolesCustomize,String rolesSystem) {
		userImpl.addUserWithCustomizeRoles(administrator,administratorPass,identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, rolesCustomize,rolesSystem);
	}
	
	@Test
	@Parameters( {"user.name","user.password","identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles","container","modle","entity","UniqueId","Name","Description","Price"})
	public void testUserViewerReadOnlyAccess(String userNameAdministrator,String adminPass,String identifier,String firstName,String lastName,String password,String confirmPassword,String email,String company,String defaultVersion, boolean active,String roles,String container,String modle,String entity,String UniqueId,String Name,String Description,String Price) {
		userImpl.readOnlyAccessForViewer(userNameAdministrator,adminPass,identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, (roles),container,modle,entity, UniqueId, Name, Description, Price);
	}
}
