package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;

public class RecordImplCustomTypes extends Record{
	 String OperationType,key,source;
	 boolean result;
  
	public RecordImplCustomTypes(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void createRecordAllFieldImpl(String container,String modle,String entity,String IdValue) {
	        OperationType="CREATE";
	        source="genericUI";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			this.sleepCertainTime(3000);
			this.clickCreateRecord();			
			this.sleepCertainTime(3000);
			
			this.clickElementByXpath("//div[text()='url1']//ancestor::div[@class='gwt-TreeItem']//img[@class='gwt-Image']");
			this.typeTextByXpath("//label[text()='Name:']//following-sibling::div//div//input", "baidu");
			this.typeTextByXpath("//label[text()='Url:']//following-sibling::div//div//input", "www.baidu.com");
			this.clickElementByXpath("//span[text()='Edit Url']//ancestor::div//button[text()='Save']");
			this.clickElementByXpath("//input[@name='CustomTypes/enum1']//ancestor::td//div//img[contains(@class,'x-form-trigger x-form-trigger-arrow')]");
			this.clickElementByXpath("//div[text()='one']");
		  this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
		  this.sleepCertainTime(10000);		  
		  chooseRcord(entity,"key1",IdValue);
		  openJournal(entity,IdValue,OperationType,source);
			this.sleepCertainTime(3000); 
			JournalCheckResult(IdValue,OperationType);
			this.sleepCertainTime(3000); 
			Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='url1:baidu@@www.baidu.com']"), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='enum1:one']"), WAIT_TIME_MIN));

}
	public void createRecordSomeFieldImpl(String container,String modle,String entity) {
		   OperationType="CREATE";
	        source="genericUI";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			this.sleepCertainTime(3000);
			this.clickCreateRecord();			
			this.sleepCertainTime(3000);
			
			this.clickElementByXpath("//div[text()='url1']//ancestor::div[@class='gwt-TreeItem']//img[@class='gwt-Image']");
			this.typeTextByXpath("//label[text()='Name:']//following-sibling::div//div//input", "baidu");
			this.typeTextByXpath("//label[text()='Url:']//following-sibling::div//div//input", "www.baidu.com");
			this.clickElementByXpath("//span[text()='Edit Url']//ancestor::div//button[text()='Save']");
		//	this.clickElementByXpath("//input[@name='CustomTypes/enum1']//ancestor::td//div//img[contains(@class,'x-form-trigger x-form-trigger-arrow')]");
		//	this.clickElementByXpath("//div[text()='one']");
		  this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
		  this.sleepCertainTime(10000);		 
	  Assert.assertTrue(this.isElementPresent(By.xpath("//span[contains(text(),'Unable to save item CustomTypes')]"), WAIT_TIME_MIN));
 	 
	
}
	

}
