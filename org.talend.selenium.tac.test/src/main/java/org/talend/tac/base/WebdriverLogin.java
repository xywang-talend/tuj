package org.talend.tac.base;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class WebdriverLogin extends WebDriverBase{
	protected WebDriver driver;
	
	@BeforeClass
	@Parameters({"url", "root"})
	public void initWebdriver(String url, String root, ITestContext context){
		if(null == System.getProperty("webdriver.firefox.bin.path") || "".equals(System.getProperty("webdriver.firefox.bin.path").trim()) || System.getProperty("webdriver.firefox.bin.path").trim().contains("webdriver.firefox.bin.path")) {
		} else{
			System.setProperty("webdriver.firefox.bin", System.getProperty("webdriver.firefox.bin.path").trim());
		}
		
		URL file = WebdriverLogin.class.getClassLoader().getResource("org/talend/tac/conf");
		PropertyConfigurator.configure( file.getPath() + "/log4j.properties" );
		
	    FirefoxProfile firefoxProfile = new FirefoxProfile();
	    firefoxProfile.setPreference("browser.download.folderList",2);
	    firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
	    firefoxProfile.setPreference("browser.download.dir",getAbsolutePath("org/talend/tac/folder/downloads"));
	    firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv, application/vnd.ms-excel, application/zip, application/pdf");

	    firefoxProfile.setPreference("dom.max_script_run_time", 0);
	    firefoxProfile.setPreference("dom.max_chrome_script_run_time", 0);
	    
	    
	    driver = new FirefoxDriver(firefoxProfile);
	    logger.info("Set Firefox Driver with Profile");
		
//		driver = new FirefoxDriver();
		logger.info("URL - " +url + root);
		
		
		driver.get(url + root);
		super.setDriver(driver);
		windowMaximize();
		
		onTestFailure(context, getAbsolutePath("org/talend/tac/folder/screen"));
	}
	
	@BeforeMethod
	@Parameters( { "userName", "userPassword", "message" })
	public void login(String user, String password, String message) {
		this.login(user, password);
		
		if (this.isTextPresent(message)) {
			this.getElementById("idLoginForceLogoutButton").click();
			this.getElementById("idLoginButton").click();
			logger.info("Force login TAC");
		}
		
	}

	public void login(String user, String password) {

		WebElement userE = this.getElementById("idLoginInput");
		userE.clear();
		userE.sendKeys(user);

		WebElement passwordE = this.getElementById("idLoginPasswordInput");
		passwordE.clear();
		passwordE.sendKeys(password);

		this.getElementById("idLoginButton").click();
		
		logger.info("Login TAC");
	}
	
	
	@AfterMethod
	public void logout() {
		this.getElementById("idLeftMenuTreeLogoutButton").click();
		logger.info("Logout TAC");
	}

	@AfterClass
	public void killBroswer() {
		driver.quit();
		logger.info("WebDriver Quit");
	}
}
