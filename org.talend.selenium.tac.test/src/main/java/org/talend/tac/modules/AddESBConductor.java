package org.talend.tac.modules;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.tac.base.WebDriverBase;

public class AddESBConductor extends WebDriverBase{
	public AddESBConductor(WebDriver driver) {
        super.setDriver(driver);
        this.driver = driver;
    }
	
	public void selectDropDownList(String name, String id, String value) {
  	   getElementByXpath("//label[text()='"+name+"']//following-sibling::div//input[@id='"+id+"']//following-sibling::div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
		   getElementByXpath("//div[text()='"+value+"'and @role='listitem']").click();
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
}
