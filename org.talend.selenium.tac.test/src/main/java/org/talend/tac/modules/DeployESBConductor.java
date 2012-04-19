package org.talend.tac.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;

public class DeployESBConductor extends WebDriverBase{

	public DeployESBConductor(WebDriver driver) {
		super.setDriver(driver);
		this.driver=driver;
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
	
	 public void undeployESBConductor(String label, String name) {
	    	String promptInfo="Feature '"+name+"' undeployed.";
	    	String status = "Undeployed";   	
	    	this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']"), WAIT_TIME_MIN);
			this.mouseDown("//div[text()='"+label+"']");
			this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorTaskGridUndeployButton']"), WAIT_TIME_MIN);
		    this.getElementById("idESBConductorTaskGridUndeployButton").click();	
//			this.clickElementById("idESBConductorTaskGridUndeployButton");
			this.acceptAlert();		
			try {
				Thread.sleep(2000);
				this.waitforTextDisplayed(promptInfo, 20);
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}			
			this.getElementById("idESBConductorTaskGridRefreshButton").click();
			this.clickElementById("idESBConductorTaskGridRefreshButton");	
			this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']" +
					"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']"), WAIT_TIME_MIN);
		    Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+label+"']" +
					"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']"),WAIT_TIME_MIN));
	    			
	    }
	        
	    public void deployStartConductor(String label, String name) {
	    	String status = "Deployed and started";
	    	String promptInfo = "Feature '"+name+"' deployed.";
			this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']"), WAIT_TIME_MIN);
			this.mouseDown("//div[text()='"+label+"']");	
			this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorTaskGridDeployButton']"), WAIT_TIME_MIN);
		    this.getElementById("idESBConductorTaskGridDeployButton").click();
			this.clickElementById("idESBConductorTaskGridDeployButton");
			this.waitforTextDisplayed(promptInfo, WAIT_TIME_MIN);	
			this.clickElementById("idESBConductorTaskGridRefreshButton");
			this.clickElementById("idESBConductorTaskGridRefreshButton");	
			this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']" +
			"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']"), WAIT_TIME_MIN);
			Assert.assertTrue(this.isElementPresent(By.xpath("//div[text()='"+label+"']" +
			"//ancestor::table[@class='x-grid3-row-table']//span[text()='"+status+"']"),WAIT_TIME_MIN));;
		}
	
}
