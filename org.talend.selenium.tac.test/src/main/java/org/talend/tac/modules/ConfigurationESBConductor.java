package org.talend.tac.modules;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;


public class ConfigurationESBConductor extends WebDriverBase {
	public ConfigurationESBConductor(WebDriver driver) {
		super.setDriver(driver);
		this.driver=driver;
	}
	
	public void mouseDown(String xpathExpression) {
  	    Locatable hoverItem = (Locatable) driver.findElement(By.xpath(xpathExpression));
  	    Mouse mouse = ((HasInputDevices) driver).getMouse();
  	    mouse.mouseDown(hoverItem.getCoordinates());
  	    try {
			 Thread.sleep(2000);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
     }
	
	public void intoConfigurationPage() {
        this.getElementById("idMenuConfigElement").click();
        this.waitforTextDisplayed("CONFIGURATION", WAIT_TIME_MIN);
   }	
	
	public void configurateEsbConductor(String artifactRepositoryUrl, String artifactRepositoryUserName
			, String artifactRepositoryPassWord, String mavenProtocolExpected,String urlStatus
			, String usernameStatus, String pwStatus, String mavenStatus) {
	       
	//	this.waitforElementDisplayed(By.xpath("//div[@class='header-title' and text()='Configuration']"), WAIT_TIME_MIN);
//		if(this.isElementPresent(By.xpath("//div[text()='Configuration' and @class='header-title']"+
//			"//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
//			"//button[@class='x-btn-text' and @aria-pressed='true']"),WAIT_TIME_MIN)) {			 
//			this.clickElementByXpath("//div[text()='Configuration' and @class='header-title']"+
//			"//ancestor::div[conta" +
//			"ins(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
//			"//button[@class='x-btn-text' and @aria-pressed='true']");
//			this.waitforElementDisplayed(By.xpath("//div[text()='Configuration' and @class='header-title']"+
//					"//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder x-border-layout-ct')]"+
//					"//button[@class='x-btn-text' and @aria-pressed='false']"), WAIT_TIME_MIN);
//			
//		}
		
		this.waitforElementDisplayed(By.xpath("//div[contains(text(),'ESB conductor (4 Parameters')]"), WAIT_TIME_MIN);
		this.mouseDown("//div[contains(text(),'ESB conductor (4 Parameters')]");
		String mavenProtocol = this.getElementByXpath("//div[contains(text(),'ESB conductor (4 Parameters')]/parent::div/following-sibling::div//table//div[text()='Maven protocol']" +
		"/parent::td/following-sibling::td[1]//div[1]").getText().trim();
        Assert.assertEquals(mavenProtocol, mavenProtocolExpected);
		this.getElementByXpath(other.getString("ESBConduction.ArtifactRepositoryUrl.editButton")).click();
		this.waitforElementDisplayed(By.xpath(other.getString("ESBConduction.conf.rtifactRepositoryUrl.input")), WAIT_TIME_MIN);
		this.getElementByXpath(other.getString("ESBConduction.conf.rtifactRepositoryUrl.input")).clear();
		this.typeTextByXpath(other.getString("ESBConduction.conf.rtifactRepositoryUrl.input"), artifactRepositoryUrl);
		this.getElementByXpath(other.getString("ESBConduction.ArtifactRepositoryUserName.editButton")).click();
		this.waitforElementDisplayed(By.xpath(other.getString("ESBConduction.conf.ArtifactRepositoryUserName.input")), WAIT_TIME_MIN);
		this.getElementByXpath(other.getString("ESBConduction.conf.ArtifactRepositoryUserName.input")).clear();
		this.typeTextByXpath(other.getString("ESBConduction.conf.ArtifactRepositoryUserName.input"), artifactRepositoryUserName);
		this.getElementByXpath(other.getString("ESBConduction.ArtifactRepositoryPassWord.editButton")).click();
		this.waitforElementDisplayed(By.xpath(other.getString("ESBConduction.conf.ArtifactRepositoryPassWord.input")), WAIT_TIME_MIN);
		this.getElementByXpath(other.getString("ESBConduction.conf.ArtifactRepositoryPassWord.input")).clear();
		this.typeTextByXpath(other.getString("ESBConduction.conf.ArtifactRepositoryPassWord.input"), artifactRepositoryPassWord);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getElementById("idConfigRefreshButton").click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.mouseDown("//div[contains(text(),'ESB conductor (4 Parameters')]");
		
		this.getElementById("idConfigRefreshButton").click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.mouseDown("//div[contains(text(),'ESB conductor (4 Parameters')]");
		logger.info("@@@@@@@@@-usernameStatusIcon:"+urlStatus);
		this.AssertEqualsInConfigurationMenu("//div[text()='Artifact repository url']//parent::td//following-sibling::td[1]//div[contains(@class,' x-form-label x-component')]",other.getString("ESBConduction.conf.rtifactRepositoryUrl.input"), artifactRepositoryUrl,
				other.getString(urlStatus));
		logger.info("@@@@@@@@@-usernameStatusIcon:"+usernameStatus);
		this.AssertEqualsInConfigurationMenu("//div[text()='Artifact repository username']//parent::td//following-sibling::td[1]//div[contains(@class,' x-form-label x-component')]",other.getString("ESBConduction.conf.ArtifactRepositoryUserName.input"), artifactRepositoryUserName,
				other.getString(usernameStatus));
		logger.info("@@@@@@@@@-usernameStatusIcon:"+pwStatus);
		this.AssertEqualsInConfigurationMenuForPassword("//div[text()='Artifact repository password']//parent::td//following-sibling::td[1]//div[contains(@class,' x-form-label x-component')]",other.getString("ESBConduction.conf.ArtifactRepositoryPassWord.input"), artifactRepositoryPassWord,
				other.getString(pwStatus));
		Assert.assertTrue(this.isElementPresent(By.xpath(other.getString(mavenStatus)),WAIT_TIME_MIN));		  
	    
	}
	
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value,String statusIconLocator){
		this.AssertEqualsInConfigurationMenu(locatorOfEditButton, locatorOfInput, value);
		this.waitforElementDisplayed(By.xpath(statusIconLocator), WAIT_TIME_MIN);//wait and check the icon status.
	}
	public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value){
		this.waitforElementDisplayed(By.xpath(locatorOfEditButton), WAIT_TIME_MIN);
		assertEquals(this.getElementByXpath(locatorOfEditButton).getText(), value);
		
	}
	
	public void AssertEqualsInConfigurationMenuForPassword(String locatorOfEditButton,String locatorOfInput,String value,String statusIconLocator){
		this.AssertEqualsInConfigurationMenuForPassword(locatorOfEditButton, locatorOfInput, value);
		this.waitforElementDisplayed(By.xpath(statusIconLocator), WAIT_TIME_MIN);//wait and check the icon status.
	}
	
	public void AssertEqualsInConfigurationMenuForPassword(String locatorOfEditButton,String locatorOfInput,String value){
		this.waitforElementDisplayed(By.xpath(locatorOfEditButton), WAIT_TIME_MIN);
		this.getElementByXpath(locatorOfEditButton).click();
		assertEquals(this.getElementByXpath(locatorOfInput).getAttribute("value"),value);		
	}

}
