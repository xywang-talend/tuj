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
		logger.info("Set Before Info");
	}
		
	
	@Test
	@Parameters( { "roles" })
	public void testAddUserAllowedAdmin(String roles) {
		license.openLicense();
		userImpl.addUserAllowed(roles, license.getAvailableAdmin());
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
		userImpl.addUserWithMultipleRoles(userNameAdministrator,identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, active, splitParameter(roles));
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
}
