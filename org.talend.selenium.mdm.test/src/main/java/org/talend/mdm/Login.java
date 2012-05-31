package org.talend.mdm;

import org.talend.mdm.impl.LogonImpl;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Login extends Base{
	public LogonImpl log = new LogonImpl(this.driver);
	@BeforeClass
	@Parameters({"url", "root", "testlink.id", "testlink.porject"})
	public void initDriver(String url, String root, String testlinkId, String testlinkProject , ITestContext context){
		this.driver=log.initWebdriver(url, root, testlinkId, testlinkProject, context);

	}
	
	@BeforeMethod
	@Parameters( { "user.name", "user.password", "message" })
	public void login(String userName, String userPassword, String message) {
    log.loginUserForce(userName, userPassword);
	}

	/*public void login(String userName, String userPassword) {

		WebElement userE = this.getElementByName(locator.getString("id.login.username"));
		userE.clear();
		userE.sendKeys(userName);
		WebElement passwordE = this.getElementByName(locator.getString("id.login.password"));
		passwordE.clear();
		passwordE.sendKeys(userPassword);
		this.getElementByName("login").click();
		logger.info("Login MDM");
	}
	*/
	
	@AfterMethod
	public void logout() {
		
//	log.logout();
	}

	@AfterClass
	public void killBroswer() {
		log.forceQuit();
	}
	
	@AfterSuite
	public void generateXmlReport(){
		Results result = new Results();
		
		result.crateXmlFile(result.getResults(failedTestCases), this.getAbsoluteFolderPath("org/talend/mdm/download")+ "/Failed.xml");
		result.crateXmlFile(result.getResults(successTestCases), this.getAbsoluteFolderPath("org/talend/mdm/download")+ "/Succes.xml");
	}
}
