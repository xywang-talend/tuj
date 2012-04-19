package org.talend.mdm.impl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;


public class RecordImplStore extends Record{
	 String OperationType,key,source;	

  
	public RecordImplStore(WebDriver driver) {
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

	public void deleteRecordImpl(String container,String modle,String entity,String storeId,String storeIdValue){
		OperationType="PHYSICAL_DELETE";
		source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		this.sleepCertainTime(3000);
		chooseRcord(entity,storeId,storeIdValue);			
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,storeIdValue,OperationType,source);
	}
	
	public void testDuplicateRecordImpl(String container,String modle,String entity,String storeId,String storeIdValue,String storeIdValueDup) {
		String[] parametersStoreId={entity,storeId};	
		String[] parametersStoreIdAssert={entity,storeId,storeIdValueDup};	
		String[] parametersStoreIdValue={entity,storeIdValue};
		    OperationType="CREATE";
		    source="genericUI";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			this.sleepCertainTime(3000);
			chooseRcord(entity,storeId,storeIdValue);		
			this.sleepCertainTime(3000);
			this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));			
			this.sleepCertainTime(3000);			
			this.clickElementByXpath(this.getString(locator,"xpath.record.Duplicate.close.origin",parametersStoreIdValue));
			this.sleepCertainTime(3000); 
			this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersStoreId)), storeIdValueDup);
			this.sleepCertainTime(3000); 
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
			this.sleepCertainTime(3000); 
			this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
			this.sleepCertainTime(3000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersStoreIdAssert)), WAIT_TIME_MAX),"duplicateARecord");
			this.sleepCertainTime(3000); 			
			openJournal(entity,storeIdValueDup,OperationType,source);
		}	
   public void createRecordImpl(String container,String modle,String entity,String storeId,String storeIdValue,String address,String addressValue) {
	        OperationType="CREATE";	 
	        source="genericUI";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			String[] parametersStoreId={entity,storeId};	
			String[] parametersAddress={entity,address};			
			String[] parametersStoreIdAssert={entity,storeId,storeIdValue};
			this.sleepCertainTime(8000);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 
			this.sleepCertainTime(3000);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersStoreId),storeIdValue);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersAddress), addressValue);	
			this.sleepCertainTime(3000);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
			this.sleepCertainTime(3000);
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersStoreIdAssert)), WAIT_TIME_MAX),"createARecord");
			this.sleepCertainTime(3000);		    
			openJournal(entity,storeIdValue,OperationType,source);
			this.sleepCertainTime(5000); 
			JournalCheckResult(storeIdValue,OperationType);
			this.sleepCertainTime(5000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.storeId",storeIdValue )), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.address",addressValue )), WAIT_TIME_MIN));
			this.clickElementByXpath("//span[@class='x-tab-strip-inner']//span[text()='Data Browser']");
			OperationType="UPDATE";
			source="GoogleMap";
			this.sleepCertainTime(5000); 
			openJournal(entity,storeIdValue,OperationType,source);
			this.sleepCertainTime(5000); 
			JournalCheckResult(storeIdValue,OperationType);
			this.sleepCertainTime(5000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.ceate.lat")), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.ceate.long")), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.ceate.googleMap")), WAIT_TIME_MIN));
		
}
	
	public void testUpdateAddressRecordImpl(String container,String modle,String entity,String storeId,String storeIdValue,String address,String addressValue) {
		OperationType="UPDATE";	
		source="GoogleMap";
		String latOld,longOld;
		String[] parametersAddress={entity,address};	
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);			
		chooseRcord(entity,storeId,storeIdValue);
		
		this.sleepCertainTime(8000);		
		logger.info(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersAddress));
		
		this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersAddress)), addressValue);
		
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		if (this.isTextPresent("No change since last save")){
			this.clickElementByXpath("//button[text()='Ok']");}
		else{
		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));
		this.sleepCertainTime(5000); 
		openJournal(entity,storeIdValue,OperationType,source);
		this.sleepCertainTime(5000); 
		JournalCheckResult(storeIdValue,OperationType);
		this.sleepCertainTime(5000); 
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.ceate.lat")), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.ceate.long")), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.ceate.googleMap")), WAIT_TIME_MIN));
		
		}	
	}
	

	
	
	public void openJournalFromDataBrowser(){
		this.clickJournal();	
	}
	
    public void closeJournal(){
		
		this.clickElementByXpath(locator.getString("xpath.journal.tab.close"));
	
    }
	


}
