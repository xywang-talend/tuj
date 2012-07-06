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
			this.waitforElementDisplayed(By.xpath(other.getString("ESBConduction.conf.rtifactRepositoryUrl.input")), WAIT_TIME_MIN);
			this.getElementByXpath(other.getString("ESBConduction.conf.rtifactRepositoryUrl.input")).clear();
			this.typeTextByXpath(other.getString("ESBConduction.conf.rtifactRepositoryUrl.input"), artifactRepositoryUrl);		
			this.getElementById("idConfigRefreshButton").click();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			this.getElementById("idConfigRefreshButton").click();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        this.clickElementByXpath("//div[contains(text(),'ESB conductor (4 Parameters')]");		
			this.AssertEqualsInConfigurationMenu("//div[text()='Artifact repository url']//parent::td//following-sibling::td[1]//div[contains(@class,' x-form-label x-component')]",other.getString("ESBConduction.conf.rtifactRepositoryUrl.input"), artifactRepositoryUrl,
					other.getString(urlStatus));
			this.AssertEqualsInConfigurationMenu("//div[text()='Artifact repository username']//parent::td//following-sibling::td[1]//div[contains(@class,' x-form-label x-component')]",other.getString("ESBConduction.conf.ArtifactRepositoryUserName.input"), artifactRepositoryUserName,
					other.getString(usernameStatus));
			logger.info("*********passwordStatus:"+pwStatus);
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
			assertEquals(this.getElementByXpath(locatorOfInput).getAttribute("value"),value);		
		}
	    
		public void selectFeatureWithUnavaiableArtifact(String label, String des,String repository) {
			this.commonMethodForSelectFeature(label, des);
			this.waitforElementDisplayed(By.xpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), 30);         
			getElementByXpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
	        Assert.assertFalse(this.isElementPresent(By.xpath("//div[text()='"+repository+"'and @role='listitem']"), 20));
		}
	    
		public void testCollapseAll(String repository) {
			this.waitforElementDisplayed(By.xpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), 30);         
			getElementByXpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
			this.waitforElementDisplayed(By.xpath("//div[text()='"+repository+"'and @role='listitem']"), WAIT_TIME_MAX);
	        getElementByXpath("//div[text()='"+repository+"'and @role='listitem']").click();
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        this.waitforElementDisplayed(By.xpath("//span[text()='Group']//ancestor::div[@class=' x-small-editor x-panel-header x-component x-unselectable']//following::div[@class='x-panel-bwrap']//tr[@class='x-toolbar-left-row']/td[1]"), WAIT_TIME_MIN);
	        this.clickElementByXpath("//span[text()='Group']//ancestor::div[@class=' x-small-editor x-panel-header x-component x-unselectable']//following::div[@class='x-panel-bwrap']//tr[@class='x-toolbar-left-row']/td[1]");	        
		}
		
		public void testExpandAll() {
	        this.waitforElementDisplayed(By.xpath("//span[text()='Group']//ancestor::div[@class=' x-small-editor x-panel-header x-component x-unselectable']//following::div[@class='x-panel-bwrap']//tr[@class='x-toolbar-left-row']/td[2]"), WAIT_TIME_MIN);
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        this.clickElementByXpath("//span[text()='Group']//ancestor::div[@class=' x-small-editor x-panel-header x-component x-unselectable']//following::div[@class='x-panel-bwrap']//tr[@class='x-toolbar-left-row']/td[2]");	        
		}
		
		public void SearchGroupId(String repository,String group) {
			this.waitforElementDisplayed(By.xpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), 30);         
			getElementByXpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
			this.waitforElementDisplayed(By.xpath("//div[text()='"+repository+"'and @role='listitem']"), WAIT_TIME_MAX);
	        getElementByXpath("//div[text()='"+repository+"'and @role='listitem']").click();
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        this.waitforElementDisplayed(By.xpath("//span[text()='Group']//ancestor::div[@class=' x-small-editor x-panel-header x-component x-unselectable']//following::div[@class='x-panel-bwrap']//tr[@class='x-toolbar-left-row']/td[1]"), WAIT_TIME_MIN);
	        this.clickElementByXpath("//span[text()='Group']//ancestor::div[@class=' x-small-editor x-panel-header x-component x-unselectable']//following::div[@class='x-panel-bwrap']//tr[@class='x-toolbar-left-row']/td[1]");	        
	        this.waitforElementDisplayed(By.xpath("//span[text()='Group']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder')]//preceding-sibling::div[contains(@class,'x-panel-tbar x-panel-tbar-noheader x-panel-tbar-noborder')]//input"), WAIT_TIME_MIN);
		    this.typeTextByXpath("//span[text()='Group']//ancestor::div[contains(@class,'x-panel-body x-panel-body-noheader x-panel-body-noborder')]//preceding-sibling::div[contains(@class,'x-panel-tbar x-panel-tbar-noheader x-panel-tbar-noborder')]//input", group);
		}
		
		public void SearchArtifact(String repository,String group) {
			this.waitforElementDisplayed(By.xpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), 30);         
			getElementByXpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
			this.waitforElementDisplayed(By.xpath("//div[text()='"+repository+"'and @role='listitem']"), WAIT_TIME_MAX);
	        getElementByXpath("//div[text()='"+repository+"'and @role='listitem']").click();
	        this.getElementByXpath("//span[text()='" + group + "']").click();	        
	        this.waitforElementDisplayed(By.xpath("//span[text()='Group']//ancestor::div[contains(@class,'x-window-body x-border-layout-ct')]//div[3]//input"), WAIT_TIME_MIN);
		    this.getElementByXpath("//span[text()='Group']//ancestor::div[contains(@class,'x-window-body x-border-layout-ct')]//div[3]//input").clear();
	        this.typeTextByXpath("//span[text()='Group']//ancestor::div[contains(@class,'x-window-body x-border-layout-ct')]//div[3]//input", "fea");		    
		}

}
