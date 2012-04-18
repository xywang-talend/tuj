package org.talend.mdm.impl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;


public class RecordImplProductFamily extends Record{
	 String OperationType,key;	
	
	 boolean result;
  
	public RecordImplProductFamily(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void ExportRecordImpl(String container,String modle,String entity){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		clickExport();
		this.sleepCertainTime(8000);
	    
			}
	
	
	public void restoreFromRecycleImpl(String container,String modle,String entity,String feild2Value,String feild2Name){
		
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		clickRecycle();
		this.sleepCertainTime(5000);
		this.clickElementByXpath(this.getString(locator, "xpath.record.recycle.click.record",feild2Value));
		this.clickElementByXpath(this.getString(locator,"xpath.record.recycle.click.record.restore",feild2Value));
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.recycle.click.record.restore.yes"));
		 if (this.isElementPresent(By.xpath("//span[contains(text(),'Please input all necessary search ')]"),WAIT_TIME_MIN)){
			 this.clickElementByXpath("//button[text()='Ok']");}
		//assert the record restore in the entity		
		this.clickElementByXpath(locator.getString("xpath.record.click.databrowser"));	 
		this.clickElementByXpath(locator.getString("xpath.record.choose.entity.arrows"));
		
		this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.entity",entity)), WAIT_TIME_MIN);
		this.clickElementByXpath(this.getString(locator, "xpath.record.choose.entity",entity));   
		this.sleepCertainTime(5000);
		entity=entity.replaceAll(" ","");
		String[] parameters={entity,feild2Name,feild2Value};
		//this.clickElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",parameters));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.delete.record",parameters)), WAIT_TIME_MIN),"the record restore in the entity");
		chooseRcord(entity,feild2Name,feild2Value);
		this.sleepCertainTime(5000);
		deleteTheRecord(entity);
	}
	public void deleteRecordImpl(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name){
		OperationType="PHYSICAL_DELETE";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		entity=entity.replaceAll(" ","");
		String[] parametersFeild1={entity,feild2Name,feild2Value,entity,feild1Name};
		chooseRcord(entity,feild2Name,feild2Value);	
		key=this.getValue(this.getElementByXpath(this.getString(locator,"xpath.record.get.uuid",parametersFeild1)));
		logger.info(key);
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,key,OperationType);
	}

	public void deleteRecordToRecycleImpl(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name){
		 OperationType="LOGIC_DELETE";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		entity=entity.replaceAll(" ","");
	    String[] parameters_container={feild2Value,container};
		String[] parameters_modle={feild2Value,modle};
		String[] parameters_entity={feild2Value,entity};
		String[] parametersFeild1={entity,feild2Name,feild2Value,entity,feild1Name};
		chooseRcord(entity,feild2Name,feild2Value);	
		key=this.getValue(this.getElementByXpath(this.getString(locator,"xpath.record.get.uuid",parametersFeild1)));
		this.sleepCertainTime(5000);
		logger.info(this.getString(locator, "xpath.record.delete.record",entity));
		this.clickElementByXpath(this.getString(locator, "xpath.record.delete.record",entity)); 
		this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.choose")); 	 
		this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.choose.ok")); 	
				if (this.isElementPresent(By.xpath(locator.getString("xpath.record.delete.record.warn")),WAIT_TIME_MIN)){
					this.clickElementByXpath("//button[text()='No']");		
				}
		//go to journal to check
		this.sleepCertainTime(3000);
	    openJournal(entity,key,OperationType);
		// assert the record which been deleted in the recycle
		clickRecycle();	
		//this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.assert.clickRefresh")); 
		this.sleepCertainTime(3000);
		logger.info(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.container",parameters_container));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.container",parameters_container)), WAIT_TIME_MIN ),"container");
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.modle",parameters_modle)), WAIT_TIME_MIN ),"modle");
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.entity",parameters_entity)), WAIT_TIME_MIN ),"entity");
		
	}
	public void duplicateRecordImpl(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name,String feild1Name){
	    OperationType="CREATE";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		entity=entity.replaceAll(" ","");
		String[] parametersFeild1={entity,feild2Name,feild2Value_old,entity,feild1Name};	
		String[] parametersFeild2={entity,feild2Name};	
		String[] parametersFeild2Assert={entity,feild2Name,feild2Value};
		String[] Feild2Value={feild2Name,feild2Value};	
		
		chooseRcord(entity,feild2Name,feild2Value_old);		
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFeild2)), WAIT_TIME_MAX),"duplicateARecord");
		this.sleepCertainTime(5000);
		key=this.getValue(this.getElementByXpath(this.getString(locator,"xpath.record.get.uuid",parametersFeild1)));
		String[] parametersFeild2Value={entity,key};
		this.clickElementByXpath(this.getString(locator,"xpath.record.Duplicate.close.origin",parametersFeild2Value));
		this.sleepCertainTime(3000);
		this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFeild2)), feild2Value);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"createARecord");
		this.sleepCertainTime(3000); 
		openJournal(entity,key,OperationType);
		this.sleepCertainTime(3000); 
		JournalCheckResult(key,OperationType);
		this.sleepCertainTime(5000); 
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",Feild2Value )), WAIT_TIME_MIN));
		
	}	
public void createRecordImpl(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name){
	        OperationType="CREATE";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);	
			entity=entity.replaceAll(" ","");
			String[] parametersFeild1={entity,feild2Name,feild2Value,entity,feild1Name};
			String[] NameAssert={feild2Name,feild2Value};
			String[] parametersFeild2={entity,feild2Name};				
			String[] parametersFeild2Assert={entity,feild2Name,feild2Value};	
			logger.info(feild2Name);
			this.sleepCertainTime(3000);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 	
			this.waitforElementDisplayed(By.xpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), WAIT_TIME_MAX);
			this.sleepCertainTime(3000);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2), feild2Value);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"createARecord");
		    this.sleepCertainTime(3000); 
		    key=this.getValue(this.getElementByXpath(this.getString(locator,"xpath.record.get.uuid",parametersFeild1)));
		    String[] IdAssert={feild1Name,key};
		    this.sleepCertainTime(3000);
		    openJournal(entity,key,OperationType);
		    this.sleepCertainTime(5000);
		    JournalCheckResult(key,OperationType);
			this.sleepCertainTime(5000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",IdAssert )), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",NameAssert )), WAIT_TIME_MIN));
	
}
	public void updateRecordImpl(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name,String feild1Name){
		OperationType="UPDATE";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		entity=entity.replaceAll(" ","");
		String[] parametersFeild2={entity,feild2Name};
		String[] parametersFeild2Assert={entity,feild2Name,feild2Value};
		String[] NameAssert={feild2Name,feild2Value};
		chooseRcord(entity,feild2Name,feild2Value_old);	
		
		String[] parametersFeild1={entity,feild2Name,feild2Value,entity,feild1Name};
		this.sleepCertainTime(5000);
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), 3000));
		this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), feild2Value);
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		if (this.isTextPresent("No change since last save")){
			this.clickElementByXpath("//button[text()='Ok']");		
		}
		else 
		{
		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"updateARecord");
		this.sleepCertainTime(3000); 
		key=this.getValue(this.getElementByXpath(this.getString(locator,"xpath.record.get.uuid",parametersFeild1)));
		this.sleepCertainTime(3000);
		openJournal(entity,key,OperationType);
		JournalCheckResult(key,OperationType);
		this.sleepCertainTime(5000); 		
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",NameAssert )), WAIT_TIME_MIN));
		}
	}
	public void SearchRecordByValueImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		searchCondition(searchFeild,opeartion,value);
		this.sleepCertainTime(3000);
		searchValueAssert(searchFeild,opeartion,value,entity);
	}
	public void SearchRecordByStringImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){

		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		searchCondition(searchFeild,opeartion,value);
		this.sleepCertainTime(3000);
		searchStringAssert(searchFeild,opeartion,value,entity);
	}
	
	public void SearchRecordByDateImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		searchCondition(searchFeild,opeartion,value);
		this.sleepCertainTime(3000);
		searchDateAssert(searchFeild,opeartion,value,entity);
	}
}
