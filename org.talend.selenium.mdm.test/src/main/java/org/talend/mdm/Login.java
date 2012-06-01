package org.talend.mdm;

import org.talend.mdm.impl.LogonImpl;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Login extends Base{
	public LogonImpl log;
	@BeforeClass
	@Parameters({"url", "root", "language", "country", "testlink.id", "testlink.porject"})
	public void initDriver(String url, String root, String language, String country, String testlinkId, String testlinkProject , ITestContext context){
		this.driver=initWebdriver(url, root, language, country, testlinkId, testlinkProject, context);
		log = new LogonImpl(this.driver);
	}
	
	@BeforeMethod
	@Parameters( { "user.name", "user.password", "message" })
	public void login(String userName, String userPassword, String message) {
		log.loginUserForce(userName, userPassword);
	}

	@AfterClass
	public void killBroswer() {
		super.killBroswer();
	}
	
	@AfterSuite
	public void generateXmlReport(){
		Results result = new Results();
		result.crateXmlFile(result.getResults(failedTestCases), this.getAbsoluteFolderPath("org/talend/mdm/download")+ "/Failed.xml");
		result.crateXmlFile(result.getResults(successTestCases), this.getAbsoluteFolderPath("org/talend/mdm/download")+ "/Succes.xml");
	}
}
