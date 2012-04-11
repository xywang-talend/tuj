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
	public void deleteRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue){
		OperationType="PHYSICAL_DELETE";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);			
		chooseRcord(entity,UniqueId,UniqueIdValue);			
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,UniqueIdValue,OperationType);
	}	
	public void deleteRecordToRecycleImpl(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name){
		}
	public void testDuplicateRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String UniqueIdValueDup) {
		String[] parametersUniqueId={entity,UniqueId};	
		String[] parametersUniqueIdAssert={entity,UniqueId,UniqueIdValueDup};	
		String[] parametersUniqueIdValue={entity,UniqueIdValue};
		    OperationType="CREATE";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			chooseRcord(entity,UniqueId,UniqueIdValue);		
			this.sleepCertainTime(3000);
			this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));			
			this.sleepCertainTime(3000);			
			this.clickElementByXpath(this.getString(locator,"xpath.record.Duplicate.close.origin",parametersUniqueIdValue));	
			this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersUniqueId)), UniqueIdValueDup);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
			this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersUniqueIdAssert)), WAIT_TIME_MAX),"createARecord");
			this.sleepCertainTime(3000); 			
			openJournal(entity,UniqueIdValueDup,OperationType);
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
			openJournal(entity,UniqueIdValue,OperationType);
}
	public void testUpdateCheckAvailabilityRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue){
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
				
				
		openJournal(entity,UniqueIdValue,OperationType);
		JournalCheckResult(UniqueIdValue,OperationType);
		Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='Availability:true']"), WAIT_TIME_MIN));
		}
	}
  
	
	public void testUpdateCompleteStoreUrlRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String name,String url){
		OperationType="UPDATE";	
		String[] parameters={name,url};
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);			
		chooseRcord(entity,UniqueId,UniqueIdValue);		
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.update.url"));
		this.sleepCertainTime(3000);		
		this.modifyText(this.getElementByXpath(locator.getString("xpath.record.update.url.input.name")),name);
		this.modifyText(this.getElementByXpath(locator.getString("xpath.record.update.url.input.url")),url);
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.update.url.input.save"));
		
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		if (this.isTextPresent("No change since last save")){
			this.clickElementByXpath("//button[text()='Ok']");}
		else{
		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));			
		this.sleepCertainTime(3000); 				
		openJournal(entity,UniqueIdValue,OperationType);
		JournalCheckResult(UniqueIdValue,OperationType);		
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.url.update.assert", parameters)), WAIT_TIME_MIN));
		}	
	}
	   public void testUpdatePriceRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Price,String PriceValue,String flag,String PriceValueOld) {
		    
		    OperationType="UPDATE";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			chooseRcord(entity,UniqueId,UniqueIdValue);	
			
			String[] parametersPrice={entity,Price};
			this.sleepCertainTime(3000);
			this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersPrice)), PriceValue);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
			if (flag.equals("0"))
			{			
			 if (this.isElementPresent(By.xpath(locator.getString("xpath.record.update.price.max")), WAIT_TIME_MAX)){
				 this.clickElementByXpath("//button[text()='Ok']");	
				 enterJournal(entity,UniqueIdValue,OperationType);	
				 JournalCheckResult(UniqueIdValue,OperationType);
				  Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.price.assert", PriceValueOld)), WAIT_TIME_MIN));
			 }
			}
			if (flag.equals("1"))
			{			
			 if (this.isElementPresent(By.xpath(locator.getString("xpath.record.update.price.min")), WAIT_TIME_MAX)){
				 this.clickElementByXpath("//button[text()='Ok']");	
				 enterJournal(entity,UniqueIdValue,OperationType);	
				 JournalCheckResult(UniqueIdValue,OperationType);
				  Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.price.assert", PriceValueOld)), WAIT_TIME_MIN));
			 }
			}
			if (flag.equals("2"))
			{			
			  enterJournal(entity,UniqueIdValue,OperationType);	 
			  JournalCheckResult(UniqueIdValue,OperationType);
			  Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.price.assert", PriceValue)), WAIT_TIME_MIN));
			}
			
}
	public void SearchRecordByValueImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		searchCondition(searchFeild,opeartion,value);
		searchValueAssert(searchFeild,opeartion,value,entity);	
	}
	public void SearchRecordByStringImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){

		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		searchCondition(searchFeild,opeartion,value);
		searchStringAssert(searchFeild,opeartion,value,entity);
		
	}
	
	public void SearchRecordByDateImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		
    }
	
	public void priceChangeWorkFlowImpl(){
		LogonImpl log = new LogonImpl(this.driver);
	/*	log.logout();
		log.loginUserForce("frank", "frank");*/
		this.chooseContainer("Product");
		this.chooseModle("Product");
		this.clickSave();
		this.clickElementByXpath("//span[contains(@class,'x-panel-header-text') and text()='Actions']//ancestor::div[contains(@class,'x-panel x-component x-border-panel')]//div[contains(@class,'x-nodrag x-tool-right x-tool x-component')]");
		this.chooseEntity("Product");
		
/*		this.clickElementByXpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Product/Id') and text()='231035933']");
		
		this.openJournalFromDataBrowser();
		this.sleepCertainTime(5000);
		int beforeProcess = this.getElementsByXpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-8') and contains(text(),'frank')]//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner x-grid3-col-5') and contains(text(),'ACTION')]").size();
		logger.info("beforeProcess:"+beforeProcess);
		this.closeJournal();
			
		this.sleepCertainTime(5000);
		Assert.assertFalse(this.getElementByXpath("//div[text()='Price']//ancestor::tr//input").isEnabled());
//		this.clickElementByXpath("//div[contains(@class,'x-small-editor x-toolbar ItemDetailToolBar x-component x-toolbar-layout-ct')]//table[contains(@class,'x-toolbar-right-ct')]//em[@class='x-btn-arrow']");
		this.sleepCertainTime(5000);
//		this.clickElementByXpath("//div[contains(@class,'x-small-editor x-toolbar ItemDetailToolBar x-component x-toolbar-layout-ct')]//table[contains(@class,'x-toolbar-right-ct')]//div[contains(@class,'x-form-field-wrap  x-component')]//img");
		this.seletDropDownList(By.xpath("//div[contains(@class,'x-small-editor x-toolbar ItemDetailToolBar x-component x-toolbar-layout-ct')]//table[contains(@class,'x-toolbar-right-ct')]//div[contains(@class,'x-form-field-wrap  x-component')]//img"), "Request Price Change");
		this.clickElementByXpath("//div[contains(@class,'x-small-editor x-toolbar ItemDetailToolBar x-component x-toolbar-layout-ct')]//table[contains(@class,'x-toolbar-right-ct')]//button");
		this.sleepCertainTime(5000);
		this.waitfor(By.xpath("//span[text()='Process done']"), WAIT_TIME_MID);
		this.clickElementByXpath("//div[contains(@class,'x-window-plain x-window-dlg x-window x-component')]//button[contains(text(),'Ok')]");
        this.sleepCertainTime(5000);
        List a = new ArrayList<String>();
        for (String handle : driver.getWindowHandles()) {
        a.add(handle);
        }
        driver.switchTo().window(a.get(1).toString());
        Assert.assertTrue(this.waitfor(By.xpath("//div[contains(@id,'welcome-container')]"), WAIT_TIME_MIN)!=null);
        driver.switchTo().window(a.get(0).toString());
    	this.openJournalFromDataBrowser();
    	this.sleepCertainTime(5000);
		int afterProcess = this.getElementsByXpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-8') and contains(text(),'frank')]//ancestor::table[contains(@class,'x-grid3-row-table')]//div[contains(@class,'x-grid3-cell-inner x-grid3-col-5') and contains(text(),'ACTION')]").size();
		logger.info("afterProcess:"+afterProcess);
		Assert.assertTrue(afterProcess-beforeProcess==1);
		this.closeJournal();
		WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    flow.changeProductPriceValidImpl(16.99, 0.05);
	    */log.logout();
	    log.loginUserForce("jennifer", "jennifer");
//		this.chooseContainer("Product");
//		this.chooseModle("Product");
//		this.clickSave();
//		this.clickElementByXpath("//span[contains(@class,'x-panel-header-text') and text()='Actions']//ancestor::div[contains(@class,'x-panel x-component x-border-panel')]//div[contains(@class,'x-nodrag x-tool-right x-tool x-component')]");
//		this.chooseEntity("Product");
	    WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    String price = this.getElementByXpath("//label[text()='Price:']//ancestor::div[contains(@class,'x-form-item')]//input").getAttribute("value");
	    this.sleepCertainTime(10000);
	    logger.info(this.getText());
	    flow.approveBoxChecked();
	    flow.clickSubmit();
	 	this.waitfor(By.xpath("//span[contains(text(),'Successfully submitted.')]"), WAIT_TIME_MID);
    	this.clickElementByXpath("//span[contains(text(),'Successfully submitted.')]//ancestor::div[contains(@class,'x-window-bwrap')]//button[text()='OK']");
	    flow.openRelatedRecord();
	    this.sleepCertainTime(5000);
	    
	    
	}
	
	public void openJournalFromDataBrowser(){
		
		this.clickElementByXpath("//div[contains(@class,'x-small-editor x-toolbar ItemDetailToolBar x-component x-toolbar-layout-ct')]//button[contains(text(),'Journal')]");
		
	}
	
    public void closeJournal(){
		
		this.clickElementByXpath("//span[contains(@class,'x-tab-strip-text') and contains(text(),'Journal')]//ancestor::li[contains(@class,'x-tab-strip-closable  x-component')]//a[contains(@class,'x-tab-strip-close')]");
	
    }
	


}
