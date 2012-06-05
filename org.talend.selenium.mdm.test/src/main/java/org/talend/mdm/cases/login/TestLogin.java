package org.talend.mdm.cases.login;

import org.talend.mdm.Base;
import org.talend.mdm.impl.LogonImpl;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestLogin extends Base {
	LogonImpl log;
	@BeforeMethod
	public void beforeMethod(){
		log = new LogonImpl(driver);
	}
	
	@Test
	@Parameters( { "url", "root", "language", "country", "testlink.id", "testlink.porject","user.name","user.password","message" })
	public void testRightLogin(String url,String root, String language, String country, String testlinkId, String testlinkProject ,String userName,String userPassword,String message,ITestContext context) {
		log.initWebdriver(url, root, language, country, testlinkId, testlinkProject, context);
		log.loginAdministratorImpl( userName, userPassword , message);
	}
	
	@Test
	@Parameters( { "url", "root", "language", "country", "testlink.id", "testlink.porject","user.name","user.password","message" })
	public void testLogoutCorrectly(String url,String root, String language, String country, String testlinkId, String testlinkProject ,String userName,String userPassword,String message,ITestContext context) {
		log.initWebdriver(url, root, language, country, testlinkId, testlinkProject, context);
		log.loginAdministratorLogoutImpl( userName, userPassword , message);
	}
	
	@Test
	@Parameters( { "url", "root", "language", "country", "testlink.id", "testlink.porject","user.name","user.password","message" ,"session.timeout"})
	public void testLoginAndSessionTimeout(String url, String root, String language, String country, String testlinkId, String testlinkProject ,String userName,String userPassword,String message,int timeout,ITestContext context) {
		log.initWebdriver(url, root, language, country, testlinkId, testlinkProject, context);
		log.loginAdministratorSessionTimeoutImpl(userName, userPassword, message, timeout);
	}
	@Test
	@Parameters( { "url", "root", "language", "country", "testlink.id", "testlink.porject","user.name","user.password","message.wrong.username" })
	public void testWongLogin(String url,String root, String language, String country, String testlinkId, String testlinkProject ,String userName,String userPassword,String message,ITestContext context) {
		log.initWebdriver(url, root, language, country, testlinkId, testlinkProject, context);
		log.loginWithWrongNamePassImpl( userName, userPassword , message);
	}
}
