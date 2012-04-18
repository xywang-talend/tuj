package org.talend.mdm;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Login extends Base{
	protected WebDriver driver;
	
	@BeforeClass
	@Parameters({"url", "root", "testlink.id", "testlink.porject"})
	public void initWebdriver(String url, String root, String testlinkId, String testlinkProject , ITestContext context){
		System.setProperty("testlink.id", testlinkId);
		System.setProperty("testlink.porject", testlinkProject);
		
		URL file = Login.class.getClassLoader().getResource("org/talend/mdm/resources");
		PropertyConfigurator.configure( file.getPath() + "/log4j.properties" );
		
	    FirefoxProfile firefoxProfile = new FirefoxProfile();
	    firefoxProfile.setPreference("browser.download.folderList",2);
	    firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
	    firefoxProfile.setPreference("browser.download.dir", this.getAbsoluteFolderPath("org/talend/mdm/download"));
	    firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv, application/vnd.ms-excel, application/zip, application/pdf");

	    driver = new FirefoxDriver(firefoxProfile);
	    logger.info("Set Firefox Driver with Profile");
		
//		driver = new FirefoxDriver();
		logger.info("URL - " +url + root);
		
		
		driver.get(url + root);
		super.setDriver(driver);
		windowMaximize();
		
		onTestListener(context, Login.class.getClassLoader().getResource("org/talend/mdm/download").getPath());
	}
	
	@BeforeMethod
	@Parameters( { "user.name", "user.password", "message" })
	public void login(String userName, String userPassword, String message) {
		this.login(userName, userPassword);
		
//		if (this.isTextPresent(message)) {
//			this.getElementById("idLoginForceLogoutButton").click();
//			this.getElementById("idLoginButton").click();
//			logger.info("Force login TAC");
//		}
		
		if(this.isTextPresent(message)) {
			this.getElementByLinkText("Force user to logout").click();
			this.login(userName, userPassword);
		} else {
			logger.info("Force Login MDM");
		}
	}

	public void login(String userName, String userPassword) {

		WebElement userE = this.getElementByName(locator.getString("id.login.username"));
		userE.clear();
		userE.sendKeys(userName);
		WebElement passwordE = this.getElementByName(locator.getString("id.login.password"));
		passwordE.clear();
		passwordE.sendKeys(userPassword);
		this.getElementByName("login").click();
		logger.info("Login MDM");
	}
	
	
	@AfterMethod
	public void logout() {
		
		logger.info("Click MDM logout button");
		this.getElementByXpath("//button[text()='Logout']").click();
		logger.info("Logout MDM");
	}

	@AfterClass
	public void killBroswer() {
		driver.quit();
		logger.info("WebDriver Quit");
	}
	
	@AfterSuite
	public void generateXmlReport(){
		Results result = new Results();
		
		result.crateXmlFile(result.getResults(failedTestCases), this.getAbsoluteFolderPath("org/talend/mdm/download")+ "/Failed.xml");
		result.crateXmlFile(result.getResults(successTestCases), this.getAbsoluteFolderPath("org/talend/mdm/download")+ "/Succes.xml");
	}
}
