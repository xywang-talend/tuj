package org.talend.tac.modules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.server.SeleniumDriverResourceHandler;
import org.talend.tac.base.WebDriverBase;

import com.thoughtworks.selenium.Selenium;

public class GroupByESBConductor extends WebDriverBase{
	
	
	public GroupByESBConductor(WebDriver driver) {
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
	
	public void mouseMove(String xpathExpression) {
  	    Locatable hoverItem = (Locatable) driver.findElement(By.xpath(xpathExpression));
  	    Mouse mouse = ((HasInputDevices) driver).getMouse();
  	    mouse.mouseMove(hoverItem.getCoordinates());
  	    try {
			 Thread.sleep(3000);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
     }
	
	
	public void selectDropDownList(String name, String id, String value) {
	  	getElementByXpath("//label[text()='"+name+"']//following-sibling::div//input[@id='"+id+"']//following-sibling::div[contains(@class,'x-form-trigger x-form-trigger-arrow')]").click();
	    getElementByXpath("//div[text()='"+value+"'and @role='listitem']").click();
	}
		
    public void intoESBConductorPage() {
	    this.getElementById("!!!menu.esbconductor.element!!!").click();
	    this.waitforTextDisplayed("ESB CONDUCTOR", WAIT_TIME_MAX);
	}	
    
    public void selectDropDownListByClickArrow(String arrowXpath, String itemName,String classXpath) {		
	    this.getElementByXpath(arrowXpath).click();
		this.waitforElementDisplayed(By.xpath("//div[contains(@class,'"+classXpath+"') and text()='"+itemName+"']"), WAIT_TIME_MIN);
		this.mouseDown("//div[contains(@class,'"+classXpath+"') and text()='"+itemName+"']");
	}
	
	public void addEsbConductor(String label, String des, String repository,
			String group, String artifact, String version, String name, String type, 
			String context, String server,String tag,int times) {
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
        if(times==0) {
    	    this.typeTextById("idESBConductorApplicationGroupListBox", tag);
        }
        else {
			this.selectDropDownListByClickArrow("//input[@id='idESBConductorApplicationGroupListBox']/following-sibling::div", tag, "x-combo-list-item");
        }
        this.getElementById("idFormSaveButton").click();      
		
	}
	
	public void groupESBConductor() {

		//the element that I want to click (hidden)		
		
		WebElement tag = driver.findElement(By.xpath("//span[text()='Tag']"));
		this.moveToElement(tag);
		WebElement jjj = driver.findElement(By.xpath("//span[text()='Tag']//parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-applicationGroup x-component')]//a"));
		//build and perform the mouseOver with Advanced User Interactions API
		//then click when menu option is visible
		jjj.click();
		this.waitforElementDisplayed(By.xpath("//a[text()='Columns']"), WAIT_TIME_MIN);
		WebElement columns = driver.findElement(By.xpath("//a[text()='Columns']"));

		this.moveToElement(columns);
		this.checkColumn("Feature URL");
		this.checkColumn("Id");
		this.clickElementByXpath("//a[text()='Group By This Field']");
	}
	
	public void checkColumn(String columnName){
//		boolean present = this.isElementPresent(By.xpath("//span[text()='"+columnName+"']"),WAIT_TIME_MIN);
		WebElement tag = driver.findElement(By.xpath("//span[text()='Tag']"));
		boolean present = driver.findElement(By.xpath("//span[text()='"+columnName+"']")).isDisplayed();
		if(!present){			
			this.waitElememt();
			driver.findElement(By.xpath("//a[text()='"+columnName+"']/img")).click();
			this.waitElememt();
			driver.findElement(By.xpath("//span[text()='"+columnName+"']")).isDisplayed();
		}
		else{
			
			this.waitElememt();
			logger.info("//a[text()='"+columnName+"']");
			WebElement tag1 = driver.findElement(By.xpath("//span[text()='Tag']"));
			this.moveToElement(tag1);
			WebElement jjj = driver.findElement(By.xpath("//span[text()='Tag']//parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-applicationGroup x-component')]//a"));
			//build and perform the mouseOver with Advanced User Interactions API
			//then click when menu option is visible
			jjj.click();
			this.waitforElementDisplayed(By.xpath("//a[text()='Columns']"), WAIT_TIME_MIN);
			WebElement columns = driver.findElement(By.xpath("//a[text()='Columns']"));

			this.moveToElement(columns);
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			logger.info("234234234234234"+"//a[text()='"+columnName+"']/img");
			driver.findElement(By.xpath("//a[text()='"+columnName+"']/img")).click();
//			this.waitElememt();
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			Assert.assertFalse(this.isElementPresent(By.xpath("//span[text()='"+columnName+"']"),WAIT_TIME_MIN));
			
		}
	}
	
	public void waitElememt() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
