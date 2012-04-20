package org.talend.tac.modules;


import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;

public class DuplicateESBConductor extends WebDriverBase {
	public DuplicateESBConductor(WebDriver driver) {
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
        this.waitforTextDisplayed("ESB CONDUCTOR", WAIT_TIME_MIN);
    }
	
	public void duplicateEsbConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server) {
		String labelAfterCopy = "Copy_of_"+label;
		this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']"), WAIT_TIME_MIN);
		this.mouseDown("//div[text()='"+label+"']");
		this.getElementById("idESBConductorTaskGridDuplicateButton").click();
		this.clickElementById("idESBConductorTaskGridDuplicateButton");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.getElementById("idFormSaveButton").click();  
		this.getElementById("idESBConductorTaskGridRefreshButton").click();
		this.waitforElementDisplayed(By.xpath("//div[text()='"+labelAfterCopy+"']"), WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath("//div[text()='"+labelAfterCopy+"']" +
           "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
           "//preceding-sibling::td//span[text()='Ready to deploy']"), WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath("//div[text()='"+labelAfterCopy+"']" +
           "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
           "//following-sibling::td//div[text()='"+version+"']"), WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath("//div[text()='"+labelAfterCopy+"']" +
           "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
           "//following-sibling::td//span[@title='"+type+"']"), WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath("//div[text()='"+labelAfterCopy+"']" +
		   "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
		   "//following-sibling::td//span[@title='"+context+"']"), WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath("//div[text()='"+labelAfterCopy+"']" +
		   "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
		   "//following-sibling::td//span[@title='"+server+"']"), WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath("//div[text()='"+labelAfterCopy+"']" +
		   "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
		   "//following-sibling::td//span[@title='"+name+"']"), WAIT_TIME_MIN);
		this.waitforElementDisplayed(By.xpath("//div[text()='"+labelAfterCopy+"']" +
		   "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
		   "//following-sibling::td//div[text()='mvn:org.example/jobSecondProvider-feature/0.1.0/xml']"), WAIT_TIME_MIN);
	}
	
	public void openLinkOfArtifact(String PageTitleExpected) {
		this.waitforElementDisplayed(By.xpath("//button[@id='idESBConductorTaskGridAdminRepoButton']"), WAIT_TIME_MIN);
		this.clickElementById("idESBConductorTaskGridAdminRepoButton");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  List a = new ArrayList<String>();
	        for (String handle : driver.getWindowHandles()) {
	        a.add(handle);
	        }
	        driver.switchTo().window(a.get(1).toString());
		String idss =driver.getTitle() ;		
		logger.info("--------idss:"+idss);
		System.out.println(idss);				
		Assert.assertTrue(idss.contains(PageTitleExpected));		
		driver.switchTo().window(a.get(0).toString());
	}

}
