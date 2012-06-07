package org.talend.tac.modules;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;

public class AddESBConductor extends WebDriverBase{
	public AddESBConductor(WebDriver driver) {
        super.setDriver(driver);
        this.driver = driver;
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
	
	public void selectDropDownList(String name, String id, String value) {
		if(this.isElementPresent(By.xpath("//span[text()='Select" +
		    " Feature from Talend repository']"), 2)) {
			this.waitforElementDisplayed(By.xpath("//label[text()='"+name+"']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), 20);         
	        getElementByXpath("//label[text()='"+name+"']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
	        this.waitforElementDisplayed(By.xpath("//div[text()='"+value+"'and @role='listitem']"), 20);
	        getElementByXpath("//div[text()='"+value+"'and @role='listitem']").click();	        
		}
		else {
	  	    getElementByXpath("//label[text()='"+name+"']//following-sibling::div//input[@id='"+id+"']//following-sibling::div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
	        getElementByXpath("//div[text()='"+value+"'and @role='listitem']").click();
		}
	}
	
	public void intoESBConductorPage() {
         this.getElementById("!!!menu.esbconductor.element!!!").click();
         this.waitforTextDisplayed("ESB CONDUCTOR", WAIT_TIME_MAX);
    }	
	
	public void addEsbConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		this.getElementById("idESBConductorTaskGridAddButton").click();
        this.isElementPresent(By.xpath("//img[@class='gwt-Image" +
				" x-component ']"), WAIT_TIME_MAX);
        this.typeTextById("idESBConductorTasklabelInput", label);
        this.typeTextById("idESBConductorTaskdesInput", des);
        this.getElementById("idESBConductorTaskSelectButton").click();
        this.isElementPresent(By.xpath("//span[text()='Select" +
				" Feature from Talend repository']"), WAIT_TIME_MAX);
        this.waitforElementDisplayed(By.xpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), WAIT_TIME_MAX);         
        getElementByXpath("//label[text()='Repository:']//following-sibling::div//div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
        this.waitforElementDisplayed(By.xpath("//div[text()='"+repository+"'and @role='listitem']"), WAIT_TIME_MAX);
        getElementByXpath("//div[text()='"+repository+"'and @role='listitem']").click();
		this.getElementByXpath("//span[text()='" + group + "']").click();
		this.getElementByXpath("//div[text()='" + artifact + "']")
			.click();
		this.getElementByXpath("//div[text()='" + version + "']").click();
		this.getElementByXpath("//button[text()='OK']").click();
        this.selectDropDownList("Name:","idTaskProjectListBox", name);
        this.selectDropDownList("Type:","idJobConductorExecutionServerListBox", type);
        this.selectDropDownList("Context:","idESBConductorTaskContextListBox", context);
        logger.info("select context");
        this.selectDropDownList("Server:","idJobConductorExecutionServerListBox", server);
        logger.info("select server");
        this.getElementById("idFormSaveButton").click();      
		
	}
	
	public void addConductorWithExistingLabel() {
		Assert.assertTrue(this.isTextPresent("An execution task with" +
				" this name already exists"));
	}
	
	public void editEsbConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		String editPart="_Edit";
		this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']"), WAIT_TIME_MIN);
		this.mouseDown("//div[text()='"+label+"']");
		this.typeTextById("idESBConductorTasklabelInput",editPart);
		this.typeTextById("idESBConductorTaskdesInput", editPart);
		this.getElementByXpath("//input[@name='repositoryName']").clear();
		this.getElementById("idESBConductorTaskSelectButton").click();
        this.waitforElementDisplayed(By.xpath("//span[text()='Select" +
				" Feature from Talend repository']"), WAIT_TIME_MAX);		
        this.selectDropDownList("Repository:", "", repository);
        this.selectDropDownList("Group:", "", group);
        this.selectDropDownList("Artifact:", "", artifact);
        this.selectDropDownList("Version:", "", version);
		this.getElementByXpath("//button[text()='OK']").click();
        this.selectDropDownList("Name:","idTaskProjectListBox", name);
        this.selectDropDownList("Type:","idJobConductorExecutionServerListBox", type);
        this.selectDropDownList("Context:","idESBConductorTaskContextListBox", context);
        logger.info("select context");
        this.selectDropDownList("Server:","idJobConductorExecutionServerListBox", server);
        logger.info("select server");
        this.getElementById("idFormSaveButton").click(); 
	}
	
	public void verifyEditedConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		String editPart="_Edit";
		Assert.assertTrue(this.getElementById("idESBConductorTasklabelInput").getAttribute("value").equals(label+editPart));
		Assert.assertTrue(this.getElementById("idESBConductorTaskdesInput").getAttribute("value").equals(des+editPart));
		Assert.assertTrue(this.getElementByName("repositoryName").getAttribute("value").equals(repository));
		Assert.assertTrue(this.getElementById("idESBConductorTaskFeatureUrlInput").getAttribute("value").equals("mvn:"+group+"/"+artifact+"/"+version+"/xml"));
		Assert.assertTrue(this.getElementById("idTaskProjectListBox").getAttribute("value").equals(name));
		Assert.assertTrue(this.getElementById("idESBConductorTaskVersionInput").getAttribute("value").equals(version));
		Assert.assertTrue(this.getElementByName("applicationType").getAttribute("value").equals(type));
		Assert.assertTrue(this.getElementByName("contextName").getAttribute("value").equals(context));
		Assert.assertTrue(this.getElementByName("executionServerId").getAttribute("value").equals(server));
		Assert.assertTrue(this.getElementByName("bundleName").getAttribute("value").equals("jobFourthProvider"));
		Assert.assertTrue(this.getElementByName("pid").getAttribute("value").equals("jobFourthProvider"));
	}
	
}
