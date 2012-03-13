package org.talend.mdm.cases.user;

import org.talend.mdm.Login;
import org.talend.mdm.impl.UserImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestUser extends Login {
	UserImpl userImpl;
	@BeforeMethod
	public void beforeMethod(){
		userImpl = new UserImpl(driver);
		logger.info("Set Before Info");
	}
		
	@Test
	@Parameters( { "identifier", "first.name", "last.name", "password", "confirm.password", "email", "company", "default.version", "active", "roles" })
	public void testAddUser(String identifier,String firstName,String lastName,String password, String confirmPassword,
			String email, String company, String defaultVersion, String active, String roles) {
		userImpl.addUserImpl(identifier, firstName, lastName, password, confirmPassword, email, company, defaultVersion, Boolean.parseBoolean(active.trim()), this.splitParameter(roles));
	}
}
