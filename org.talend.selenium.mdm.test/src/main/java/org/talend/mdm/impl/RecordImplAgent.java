package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;


public class RecordImplAgent extends Record{
	 String OperationType,key,source;
	
	 boolean result;
  
	public RecordImplAgent(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	public void deleteRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue){
		OperationType="PHYSICAL_DELETE";
		source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
		chooseRcord(entity,Identifie,IdentifieValue);			
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,IdentifieValue,OperationType,source);
	    JournalResultCount();
	}
public void createRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue,String Firstname,String FirstnameValue,String Lastname,String LastnameValue,String CommissionCode,String CommissionCodeValue,String StartDate,String StartDateValue ) {
	String[] parametersFirstname={entity,Firstname};
	String[] parametersLastname={entity,Lastname};
	String[] parametersID={entity,Identifie};
	String[] parametersStartDate={entity,StartDate};
	String[] IdAssert={Identifie,IdentifieValue};
    String[] FirstnameAssert={Firstname,FirstnameValue};
    String[] LastnameAssert={Lastname,LastnameValue};
    String[] CommissionCodeAssert={CommissionCode,CommissionCodeValue};
    String[] StartDateAssert={StartDate,StartDateValue};
    OperationType="CREATE";
    source="genericUI";
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);				
	this.sleepCertainTime(3000);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 				
	this.sleepCertainTime(3000);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersID), IdentifieValue);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFirstname), FirstnameValue);	
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersLastname), LastnameValue);
	this.clickElementByXpath("//input[@name='Agent/CommissionCode']//following-sibling::img");
	this.clickElementByXpath(this.getString(locator, "xpath.record.click.CommissionCode", CommissionCodeValue));
	this.sleepCertainTime(3000);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersStartDate), StartDateValue);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
	chooseRcord(entity,Identifie,IdentifieValue);
	this.sleepCertainTime(3000);
	openJournal(entity,IdentifieValue,OperationType,source);
    this.sleepCertainTime(5000);
    JournalCheckResult(IdentifieValue,OperationType);
	this.sleepCertainTime(5000); 
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",IdAssert )), WAIT_TIME_MIN));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",FirstnameAssert)), WAIT_TIME_MIN));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",LastnameAssert)), WAIT_TIME_MIN));	
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",CommissionCodeAssert )), WAIT_TIME_MIN));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",StartDateAssert)), WAIT_TIME_MIN));	
}
}
