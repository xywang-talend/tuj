package org.talend.tac.modules;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;

public class SelectFeatureFromArchiva extends WebDriverBase {
    
	public SelectFeatureFromArchiva(WebDriver driver) {
		super.setDriver(driver);
		this.driver=driver;
	}
	
	public void selectDropDownList(String name, String id, String value) {
	    getElementByXpath("//label[text()='"+name+"']//following-sibling::div//input[@id='"+id+"']//following-sibling::div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
	    getElementByXpath("//div[text()='"+value+"'and @role='listitem']").click();
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
	
    public void intoESBConductorPage() {		
		this.getElementById("!!!menu.esbconductor.element!!!");
		this.clickElementById("!!!menu.esbconductor.element!!!");
		this.waitforElementDisplayed(By.xpath("//div[@class='header-title' and text()" +
				"='ESB Conductor']"), WAIT_TIME_MIN);		
	}
	
	public void seletFeature(String label, String des, String repository,
			String group, String artifact, String version, String name) {
		this.commonMethodForSelectFeature(label, des);
        this.waitforElementDisplayed(By.xpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), WAIT_TIME_MAX);         
        getElementByXpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
        this.waitforElementDisplayed(By.xpath("//div[text()='"+repository+"'and @role='listitem']"), WAIT_TIME_MAX);
        getElementByXpath("//div[text()='"+repository+"'and @role='listitem']").click();
		this.getElementByXpath("//span[text()='" + group + "']").click();
		this.getElementByXpath("//div[text()='" + artifact + "']").click();
		this.getElementByXpath("//div[text()='" + version + "']").click();
		this.getElementByXpath("//button[text()='OK']").click();
		this.selectDropDownList("Name:","idTaskProjectListBox", name);		
	}
	
	
	 public void commonMethodForSelectFeature(String label,String des) {
		 this.intoESBConductorPage();
	     this.clickElementById("idESBConductorTaskGridAddButton");
	     this.isElementPresent(By.xpath("//img[@class='gwt-Image" +
		     " x-component ']"), WAIT_TIME_MAX);
	     this.typeTextById("idESBConductorTasklabelInput", label);
	     this.typeTextById("idESBConductorTaskdesInput", des);
	     this.getElementById("idESBConductorTaskSelectButton").click();
	     this.isElementPresent(By.xpath("//span[text()='Select" +
		     " Feature from Talend repository']"), WAIT_TIME_MAX);
	 }
	 
	 public void intoConfigurationPage() {
	     this.getElementById("idMenuConfigElement").click();
	     this.waitforTextDisplayed("CONFIGURATION", WAIT_TIME_MIN);
	 }	
		
     public void configurateEsbConductor(String artifactRepositoryUrl, String artifactRepositoryUserName
				, String artifactRepositoryPassWord, String mavenProtocolExpected,String urlStatus
				, String usernameStatus, String pwStatus, String mavenStatus) {		       
			this.waitforElementDisplayed(By.xpath("//div[@class='header-title' and text()='Configuration']"), WAIT_TIME_MIN);
			this.waitforElementDisplayed(By.xpath("//div[contains(text(),'ESB conductor (4 Parameters')]"), WAIT_TIME_MIN);
			this.mouseDown("//div[contains(text(),'ESB conductor (4 Parameters')]");
			String mavenProtocol = this.getElementByXpath("//div[contains(text(),'ESB conductor (4 Parameters')]/parent::div/following-sibling::div//table//div[text()='Maven protocol']" +
			"/parent::td/following-sibling::td[1]//div[1]").getText().trim();
	        Assert.assertEquals(mavenProtocol, mavenProtocolExpected);
			this.getElementByXpath(other.getString("ESBConduction.ArtifactRepositoryUrl.editButton")).click();
			this.waitforElementDisplayed(By.xpath(other.getString("commandline.conf.all.input")), WAIT_TIME_MIN);
			this.getElementByXpath(other.getString("commandline.conf.all.input")).clear();
			this.typeTextByXpath(other.getString("commandline.conf.all.input"), artifactRepositoryUrl);
			this.getElementByXpath(other.getString("ESBConduction.ArtifactRepositoryUserName.editButton")).click();
			this.waitforElementDisplayed(By.xpath(other.getString("commandline.conf.all.input")), WAIT_TIME_MIN);
			this.getElementByXpath(other.getString("commandline.conf.all.input")).clear();
			this.typeTextByXpath(other.getString("commandline.conf.all.input"), artifactRepositoryUserName);
			this.getElementByXpath(other.getString("ESBConduction.ArtifactRepositoryPassWord.editButton")).click();
			this.waitforElementDisplayed(By.xpath(other.getString("commandline.conf.all.input")), WAIT_TIME_MIN);
			this.getElementByXpath(other.getString("commandline.conf.all.input")).clear();
			this.typeTextByXpath(other.getString("commandline.conf.all.input"), artifactRepositoryPassWord);
			
			this.getElementById("idConfigRefreshButton").click();
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			this.getElementById("idConfigRefreshButton").click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.AssertEqualsInConfigurationMenu("//div[text()='Artifact repository url']//parent::td//following-sibling::td[1]//div[contains(@class,' x-form-label x-component')]",other.getString("commandline.conf.all.input"), artifactRepositoryUrl,
					other.getString(urlStatus));
			this.AssertEqualsInConfigurationMenu("//div[text()='Artifact repository username']//parent::td//following-sibling::td[1]//div[contains(@class,' x-form-label x-component')]",other.getString("commandline.conf.all.input"), artifactRepositoryUserName,
					other.getString(usernameStatus));
			logger.info("*********passwordStatus:"+pwStatus);
			this.AssertEqualsInConfigurationMenuForPassword("//div[text()='Artifact repository password']//parent::td//following-sibling::td[1]//div[contains(@class,' x-form-label x-component')]",other.getString("commandline.conf.all.input"), artifactRepositoryPassWord,
					other.getString(pwStatus));
			Assert.assertTrue(this.isElementPresent(By.xpath(other.getString(mavenStatus)),WAIT_TIME_MIN));		  
		    
		}
		
		public void AssertEqualsInConfigurationMenu(String locatorOfEditButton,String locatorOfInput,String value,String statusIconLocator){
			this.AssertEqualsInConfigurationMenu(locatorOfEditButton, locatorOfInput, value);
			this.waitforElementDisplayed(By.xpath(statusIconLocator), 20);//wait and check the icon status.
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
			assertEquals(this.getElementByXpath(locatorOfInput).getAttribute("value"),value);		
		}
	    
		public void selectFeatureWithUnavaiableArtifact(String label, String des,String repository) {
			this.commonMethodForSelectFeature(label, des);
			this.waitforElementDisplayed(By.xpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), 30);         
			getElementByXpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
	        Assert.assertFalse(this.isElementPresent(By.xpath("//div[text()='"+repository+"'and @role='listitem']"), 20));
//			Assert.assertTrue(this.isTextPresent("Operation failed: Software update repository cannot be reached (http://192.168.0.200:8082/archiva). -- For more information see your log file"));			
		}
	 

}

