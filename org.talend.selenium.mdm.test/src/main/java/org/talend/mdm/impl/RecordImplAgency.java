package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;


public class RecordImplAgency extends Record{
	 String OperationType,key,source;
	
	 boolean result;
  
	public RecordImplAgency(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	public void deleteRecordImpl(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name){
		OperationType="PHYSICAL_DELETE";
		source="genericUI";
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
	    openJournal(entity,key,OperationType,source);
	    JournalResultCount();
	}
	public void duplicateRecordImpl(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name,String feild1Name){
	    OperationType="CREATE";
	    source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		entity=entity.replaceAll(" ","");
		String[] parametersFeild1={entity,feild2Name,feild2Value_old,entity,feild1Name};	
		String[] parametersFeild1_dup={entity,feild2Name,feild2Value,entity,feild1Name};
		String[] parametersFeild2={entity,feild2Name};	
		String[] parametersFeild2Assert={entity,feild2Name,feild2Value};
		String[] Feild2Value={feild2Name,feild2Value};	
		
		chooseRcord(entity,feild2Name,feild2Value_old);		
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFeild2)), WAIT_TIME_MAX),"duplicateARecord");
		this.sleepCertainTime(5000);
		key=this.getValue(this.getElementByXpath(this.getString(locator,"xpath.record.get.uuid",parametersFeild1)));
		logger.info(key);
		String[] parametersFeild2Value={entity,key};
		String[] parametersFeild2ValueAssert={feild2Name,feild2Value};
		this.clickElementByXpath(this.getString(locator,"xpath.record.Duplicate.close.origin",parametersFeild2Value));
		this.sleepCertainTime(3000);
		this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFeild2)), feild2Value);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
		this.sleepCertainTime(5000);
		chooseRcord(entity,feild2Name,feild2Value);	
		this.sleepCertainTime(5000);
		key=this.getValue(this.getElementByXpath(this.getString(locator,"xpath.record.get.uuid",parametersFeild1_dup)));
		logger.info(key);
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"createARecord");
		this.sleepCertainTime(3000); 
		openJournal(entity,key,OperationType,source);
		this.sleepCertainTime(3000); 
		JournalCheckResult(key,OperationType);
		this.sleepCertainTime(5000); 
		logger.info(this.getString(locator, "xpath.record.ceate.jouranl",Feild2Value ));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",parametersFeild2ValueAssert )), WAIT_TIME_MIN));
		
	}	
public void createRecordImpl(String container,String modle,String entity,String Name,String NameValue,String Identifie,String IdentifieValue ,String Zipcode,String ZipcodeValue) {
	        OperationType="CREATE";
	        source="genericUI";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			String city,state,region,moreinfo;
			String[] parametersName={entity,Name};	
			String[] parametersID={entity,Identifie};
			String[] parametersZip={entity,Zipcode};
			String[] parametersNameAssert={entity,Name,NameValue};	
			String[] parametersIDAssert={entity,Identifie,IdentifieValue};		
			String[] parametersZipAssert={entity,Zipcode,ZipcodeValue};	
			this.sleepCertainTime(3000);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 				
			this.sleepCertainTime(3000);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersID), IdentifieValue);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersName), NameValue);		
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersZip), ZipcodeValue);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
			//get the auto genatate value
			this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
			chooseRcord(entity,Identifie,IdentifieValue);
			this.sleepCertainTime(3000);
			city=this.getValueInput(By.xpath("//input[@name='Agency/City']"));
			state=this.getValueInput(By.xpath("//input[@name='Agency/State']"));
			region=this.getValueInput(By.xpath("//input[@name='Agency/Region']"));
			this.sleepCertainTime(3000);
			this.clickElementByXpath("//a[text()='Map']//following-sibling::img");
			moreinfo=this.getValueInput(By.xpath("//label[text()='Url:']//following-sibling::div//div//input"));	
			this.clickElementByXpath("//button[text()='Cancel']");			
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersNameAssert)), WAIT_TIME_MAX),"createARecord");
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersZipAssert)), WAIT_TIME_MAX),"createARecord");
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersIDAssert)), WAIT_TIME_MAX),"createARecord");
		    this.sleepCertainTime(3000); 		  
		    String[] IdAssert={Identifie,IdentifieValue};
		    String[] NameAssert={Name,NameValue};
		    String[] ZipAssert={Zipcode,ZipcodeValue};
		    this.sleepCertainTime(3000);
		    openJournal(entity,IdentifieValue,OperationType,source);
		    this.sleepCertainTime(5000);
		    JournalCheckResult(IdentifieValue,OperationType);
			this.sleepCertainTime(5000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",IdAssert )), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",NameAssert )), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",ZipAssert )), WAIT_TIME_MIN));
			OperationType="UPDATE";
		    source="DStar_EnrichAgencyLocation";
		    this.clickElementByXpath("//span[@class='x-tab-strip-inner']//span[text()='Data Browser']");
		    this.sleepCertainTime(3000);
		    openJournal(entity,IdentifieValue,OperationType,source);
		    this.sleepCertainTime(5000);
		    JournalCheckResult(IdentifieValue,OperationType);
			this.sleepCertainTime(5000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.city", city)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.State", state)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.Region",region)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.MoreInfo",moreinfo)), WAIT_TIME_MIN));
}
	public void updateRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue ,String Zipcode,String ZipcodeValue) {
		String city,state,region,moreinfo;
		String cityOld,stateOld,regionOld,moreinfoOld;
		String[] parametersZip={entity,Zipcode};	
		OperationType="UPDATE";
	    source="DStar_EnrichAgencyLocation";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			this.sleepCertainTime(3000);
			this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
			//get the old value
			chooseRcord(entity,Identifie,IdentifieValue);
			this.sleepCertainTime(3000);
			cityOld=this.getValueInput(By.xpath("//input[@name='Agency/City']"));
			stateOld=this.getValueInput(By.xpath("//input[@name='Agency/State']"));
			regionOld=this.getValueInput(By.xpath("//input[@name='Agency/Region']"));
			this.sleepCertainTime(3000);
			this.clickElementByXpath("//a[text()='Map']//following-sibling::img");
			moreinfoOld=this.getValueInput(By.xpath("//label[text()='Url:']//following-sibling::div//div//input"));	
			this.clickElementByXpath("//button[text()='Cancel']");	
			this.sleepCertainTime(5000);
			this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersZip)), ZipcodeValue);
			this.sleepCertainTime(5000);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
			this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));			
			//get the value after update
			chooseRcord(entity,Identifie,IdentifieValue);
			this.sleepCertainTime(3000);
			city=this.getValueInput(By.xpath("//input[@name='Agency/City']"));
			state=this.getValueInput(By.xpath("//input[@name='Agency/State']"));
			region=this.getValueInput(By.xpath("//input[@name='Agency/Region']"));
			this.sleepCertainTime(3000);
			this.clickElementByXpath("//a[text()='Map']//following-sibling::img");
			moreinfo=this.getValueInput(By.xpath("//label[text()='Url:']//following-sibling::div//div//input"));	
			this.clickElementByXpath("//button[text()='Cancel']");	
			//assert in the journal
		    this.sleepCertainTime(3000);
		    openJournal(entity,IdentifieValue,OperationType,source);
		    this.sleepCertainTime(5000);
		    JournalCheckResult(IdentifieValue,OperationType);
			this.sleepCertainTime(5000); 		 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.city", cityOld)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.State", stateOld)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.Region",regionOld)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.MoreInfo",moreinfoOld)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.city", city)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.State", state)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.Region",region)), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.MoreInfo",moreinfo)), WAIT_TIME_MIN));
			
			
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
