package org.talend.tac.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;

public class DeployWithInactiveRuntime extends WebDriverBase{
	public DeployWithInactiveRuntime(WebDriver driver) {
        super.setDriver(driver);
        this.driver = driver;
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
			 Thread.sleep(3000);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
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
		this.getElementByXpath(
			"//span[text()='Select Feature from Talend repository']"
					+ "//ancestor::div[@class=' x-window x-component']"
					+ "//button[text()='OK']").click();
        this.selectDropDownList("Name:","idTaskProjectListBox", name);
        this.selectDropDownList("Type:","idJobConductorExecutionServerListBox", type);
        this.selectDropDownList("Context:","idESBConductorTaskContextListBox", context);
        logger.info("select context");
        this.selectDropDownList("Server:","idJobConductorExecutionServerListBox", server);
        logger.info("select server");
        this.getElementById("idFormSaveButton").click();      
		
	}
	
	public void deployStartConductor(String label, String name,String status) {
		
		this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']"), WAIT_TIME_MAX);
		this.mouseDown("//div[text()='"+label+"']");	
		this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorTaskGridDeployButton']"), WAIT_TIME_MAX);
	    this.getElementById("idESBConductorTaskGridDeployButton").click();
		this.clickElementById("idESBConductorTaskGridDeployButton");
		Assert.assertTrue(this.isTextPresent("Error: deployment of feature '"+name+"' might have failed: JobServer is inactive -- For more information see your log file"));
		this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorTaskGridRefreshButton']"), WAIT_TIME_MAX);
	    this.getElementById("idESBConductorTaskGridRefreshButton").click();
		this.clickElementById("idESBConductorTaskGridRefreshButton");	
		this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']" +
		"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']"), 10);
		Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+label+"']" +
		"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']"),10));;
	}
}
