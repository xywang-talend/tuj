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
	@Parameters({"url", "root", "language", "country", "testlink.id", "testlink.porject", "testlink.url", "container", "modle", "entity"})
	public void initDriver(String url, String root, String language, String country, String testlinkId, String testlinkProject , String testlinkUrl,
			String container, String modle, String entity, ITestContext context){
		this.driver=initWebdriver(url, root, language, country, testlinkId, testlinkProject, testlinkUrl, container, modle, entity, context);
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
	@Parameters({"testResultEscapeText"})
	public void generateXmlReport(String escapeText){
		boolean escape = false;
		try {
			escape = Boolean.parseBoolean(escapeText.trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Results result = new Results();
		result.crateXmlFile(result.getResults(failedTestCases), this.getAbsoluteFolderPath("org/talend/mdm/download")+ "/Failed.xml", escape);
		result.crateXmlFile(result.getResults(successTestCases), this.getAbsoluteFolderPath("org/talend/mdm/download")+ "/Succes.xml", escape);
	}
}
