package org.talend.tac.modules;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;


public class GroupByESBConductor extends WebDriverBase {
	
	
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
	    this.waitforTextDisplayed("ESB CONDUCTOR", WAIT_TIME_MIN);
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
        if(times==0) {
    	    this.typeTextById("idESBConductorApplicationGroupListBox", tag);
        }
        else {
			this.selectDropDownListByClickArrow("//input[@id='idESBConductorApplicationGroupListBox']/following-sibling::div", tag, "x-combo-list-item");
        }
        this.getElementById("idFormSaveButton").click();      
		
	}
	
	public void groupESBConductor() {
		this.focusElement();
		this.checkColumn("Id");
		this.checkColumn("Error status");
		this.checkColumn("Description");
		this.checkColumn("Repository");
		this.clickElementByXpath("//a[text()='Group By This Field']");
		Assert.assertTrue(this.getElementsByXpath("//div[contains(@class,'x-grid-group-div') and contains(text(),'Tag:  (')]").size()>=2);

	}
	
	public void checkColumn(String columnName){
		boolean present = this.isElementPresent(By.xpath("//span[text()='"+columnName+"']"),10);
		if(!present){
			logger.info("clumnName:"+columnName);			
			this.waitforElementDisplayed(By.xpath("//a[text()='"+columnName+"']"), 10);
			this.getElementByXpath("//a[text()='"+columnName+"']").click();
			this.waitforElementDisplayed(By.xpath("//span[text()='"+columnName+"']"), 10);
			this.getElementByXpath("//a[text()='"+columnName+"']").click();
		}
		else{
			this.waitforElementDisplayed(By.xpath("//a[contains(text(),'"+columnName+"')]"), 20);
			this.clickElementByXpath("//a[contains(text(),'"+columnName+"')]");
			this.waitThreeSeconds();
			Assert.assertFalse(this.isElementPresent(By.xpath("//span[text()='"+columnName+"']"), 10));
			this.clickElementByXpath("//a[contains(text(),'"+columnName+"')]");
		}		
	}
	
	public void focusElement() {
		
		WebElement tag = driver.findElement(By.xpath("//span[text()='Tag']"));
		this.moveToElement(tag);
		WebElement jjj = driver.findElement(By.xpath("//span[text()='Tag']//parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-applicationGroup x-component')]//a"));
		jjj.click();
		this.waitforElementDisplayed(By.xpath("//a[text()='Columns']"), WAIT_TIME_MIN);
	    WebElement columns = driver.findElement(By.xpath("//a[text()='Columns']"));
	    this.moveToElement(columns);
	}
	
	public void checkSortAscendingSortDescending(String value, String value1) {
		WebElement element = driver.findElement(By.xpath("//span[text()='Tag']"));
		this.moveToElement(element);
		WebElement drop = driver.findElement(By.xpath("//span[text()='Tag']//parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-applicationGroup x-component')]//a"));
		drop.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.clickElementByXpath("//a[text()='Sort Descending']");
		Assert.assertEquals(this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label']").getText(), value);       
       
		WebElement elementagain = driver.findElement(By.xpath("//span[text()='Tag']"));
		this.moveToElement(elementagain);
		WebElement dropagain = driver.findElement(By.xpath("//span[text()='Tag']//parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-applicationGroup x-component')]//a"));
		dropagain.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        this.clickElementByXpath("//a[text()='Sort Ascending']");      
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 this.clickElementById("idESBConductorTaskGridRefreshButton");
		Assert.assertEquals(this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label']").getText(), value1);
		
	}
	
	public void waitThreeSeconds() {
		  try {
		   Thread.sleep(3000);
		  } catch (InterruptedException e) {
		   e.printStackTrace();
		  }
		 }
	
}
