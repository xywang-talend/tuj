package com.talend.cases.esb;


import org.testng.Assert;
import org.testng.annotations.Test;



public class TestEsbServiceActivityColumns extends Esb {
	

	
	
	@Test
	public void testActivityColumns(){
		this.openServiceActivityMonitor();
		this.openColumns("Date / Time");
		this.checkColumn("Flow ID");
		this.checkColumn("Date / Time");
		this.checkColumn("Provider Host");
		this.checkColumn("Provider IP");
		this.checkColumn("Consumer Host");
		this.checkColumn("Consumer IP");
		this.checkColumn("PortType");
		this.checkColumn("Operation");
		this.checkColumn("Transport");
		this.checkColumn("Elapsed");
		this.checkColumn("Type");
//		selenium.type("//div[@class='my-paging-text x-component ' and text()='Page']//ancestor::tr[@class='x-toolbar-left-row']//td[5]//input","1");
		selenium.refresh();
		this.openColumns("Date / Time");
		this.chooseColumn("Flow ID");
		this.unChooseColumn("PortType");
//		selenium.type("//div[@class='my-paging-text x-component ' and text()='Page']//ancestor::tr[@class='x-toolbar-left-row']//td[5]//input","1");
//	    selenium.refresh();
		selenium.click("//a[@class=' x-menu-item x-menu-item-arrow x-component' and text()='Columns']");
		this.openColumns("Date / Time");
		this.waitForElementPresent("//a[contains(@class,'x-menu-item x-menu-check-item x-menu-checked x-component') and text()='Flow ID']", WAIT_TIME);
	    this.waitForElementPresent("//a[@class=' x-menu-item x-menu-check-item x-component' and text()='PortType']", WAIT_TIME);
		this.unChooseColumn("Flow ID");
		this.unChooseColumn("Date / Time");
		this.unChooseColumn("Provider Host");
		this.unChooseColumn("Provider IP");
		this.unChooseColumn("Consumer Host");
		this.unChooseColumn("Consumer IP");
		this.unChooseColumn("PortType");
		this.unChooseColumn("Operation");
		this.unChooseColumn("Transport");
		this.unChooseColumn("Elapsed");
		this.waitForElementPresent("//a[@class=' x-menu-item x-menu-check-item x-menu-checked x-component x-item-disabled' and text()='Type']", WAIT_TIME);
	   
	}
	public void openColumns(String beginTag){
		this.waitForElementPresent("//span[text()='"+beginTag+"']", WAIT_TIME);
		this.sleep(2000);
		selenium.click("//span[text()='"+beginTag+"']//parent::div[contains(@class,'x-grid3-hd-inner x-grid3-hd-timestamp x-component')]//a");
		this.waitForElementPresent("//a[text()='Columns']", WAIT_TIME);
//		this.waitForElementPresent("//a[text()='Filters']", WAIT_TIME);
		selenium.mouseOver("//a[text()='Columns']");
	}
	
	public void checkColumn(String columnName){
		boolean present = selenium.isElementPresent("//span[text()='"+columnName+"']");
		if(!present){
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementPresent("//span[text()='"+columnName+"']", WAIT_TIME);
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementDispear("//span[text()='"+columnName+"']", WAIT_TIME);
		}
		else{
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementDispear("//span[text()='"+columnName+"']", WAIT_TIME);
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementPresent("//span[text()='"+columnName+"']", WAIT_TIME);
		}
		
	}
	
	public void chooseColumn(String columnName){
		boolean present = selenium.isElementPresent("//span[text()='"+columnName+"']");
		if(!present){
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementPresent("//span[text()='"+columnName+"']", WAIT_TIME);
		}
	}
	
	public void unChooseColumn(String columnName){
		boolean present = selenium.isElementPresent("//span[text()='"+columnName+"']");
		if(present){
			selenium.click("//a[text()='"+columnName+"']");
			this.waitForElementDispear("//span[text()='"+columnName+"']", WAIT_TIME);
		}
	}
	
}
