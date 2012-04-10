package org.talend.mdm.impl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;


public class RecordImplProduct extends Record{
	 String OperationType,key;	

  
	public RecordImplProduct(WebDriver driver) {
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
		
	}
	public void deleteRecordImpl(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name){
			}	
	public void deleteRecordToRecycleImpl(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name){
		}
	public void duplicateRecordImpl(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name,String feild1Name){
		}	
   public void createRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Name,String NameValue,String Description,String DescriptionValue,String Price,String PriceValue) {
	        OperationType="CREATE";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			String[] parametersUniqueId={entity,UniqueId};	
			String[] parametersName={entity,Name};	
			String[] parametersDescription={entity,Description};	
			String[] parametersPrice={entity,Price};	
			String[] parametersUniqueIdAssert={entity,UniqueId,UniqueIdValue};
			String[] parametersNameAssert={entity,Name,NameValue};
			String[] parametersDescriptionAssert={entity,Description,DescriptionValue};
			String[] parametersPriceAssert={entity,Price,PriceValue};
			this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 
			
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersUniqueId),UniqueIdValue);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersName), NameValue);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersDescription), DescriptionValue);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersPrice), PriceValue);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersUniqueIdAssert)), WAIT_TIME_MAX),"createARecord");
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersNameAssert)), WAIT_TIME_MAX),"createARecord");
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersDescriptionAssert)), WAIT_TIME_MAX),"createARecord");
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersPriceAssert)), WAIT_TIME_MAX),"createARecord");
			this.sleepCertainTime(3000);		    
			JournalOpenRecordImpl(entity,UniqueIdValue,OperationType);
}
	public void updateRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue){
		String availability;
		boolean availabilityRsulte=false;
		OperationType="UPDATE";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);			
		chooseRcord(entity,UniqueId,UniqueIdValue);		
		this.sleepCertainTime(5000);
	   // update the Availability
		availability=this.getValue(this.getElementByXpath(this.getString(locator, "xpath.record.update.Availability",UniqueIdValue)));
		if (availability.equals("true"))
		{
			availabilityRsulte=true;
			Assert.assertTrue(availabilityRsulte);
		}
		else
		{
		this.clickElementByName("Product/Availability");		
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		if (this.isTextPresent("No change since last save")){
			this.clickElementByXpath("//button[text()='Ok']");}
		else{
		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));		
		availability=this.getValue(this.getElementByXpath(this.getString(locator, "xpath.record.update.Availability",UniqueIdValue)));
		logger.info(availability);
		if (availability.equals("true"))
		{availabilityRsulte=true;}		
		Assert.assertTrue(availabilityRsulte);
		}
		this.sleepCertainTime(3000); 
				
		JournalOpenRecordImpl(entity,UniqueIdValue,OperationType);
		JournalCheckResult(UniqueIdValue,OperationType);
		}
	}
	public void SearchRecordByValueImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		
	}
	public void SearchRecordByStringImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){

		
	}
	
	public void SearchRecordByDateImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		
}}
