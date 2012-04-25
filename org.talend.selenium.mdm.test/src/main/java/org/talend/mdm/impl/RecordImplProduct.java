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
	 String OperationType,key,source;  
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
		source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		this.sleepCertainTime(3000);
		chooseRcord(entity,UniqueId,UniqueIdValue);			
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,UniqueIdValue,OperationType,source);
	    JournalResultCount();
	}	
	public void deleteRecordToRecycleImpl(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name){
		}
	public void testDuplicateRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String UniqueIdValueDup) {
		String[] parametersUniqueId={entity,UniqueId};	
		String[] parametersUniqueIdAssert={entity,UniqueId,UniqueIdValueDup};	
		String[] parametersUniqueIdValue={entity,UniqueIdValue};
		String[] UniqueIdAssert={UniqueId,UniqueIdValueDup};
		    OperationType="CREATE";
		    source="genericUI";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			this.sleepCertainTime(3000);
			chooseRcord(entity,UniqueId,UniqueIdValue);		
			this.sleepCertainTime(3000);
			this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));			
			this.sleepCertainTime(3000);			
			this.clickElementByXpath(this.getString(locator,"xpath.record.Duplicate.close.origin",parametersUniqueIdValue));
			this.sleepCertainTime(3000); 
			this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersUniqueId)), UniqueIdValueDup);
			this.sleepCertainTime(3000); 
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
			this.sleepCertainTime(3000); 
			this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
			this.sleepCertainTime(3000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersUniqueIdAssert)), WAIT_TIME_MAX),"duplicateARecord");
			this.sleepCertainTime(3000); 			
			openJournal(entity,UniqueIdValueDup,OperationType,source);
			this.sleepCertainTime(3000); 
			JournalCheckResult(UniqueIdValueDup,OperationType);
			this.sleepCertainTime(3000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",UniqueIdAssert )), WAIT_TIME_MIN));
			OperationType="UPDATE";
		    source="CompleteStoreURL";
		    this.clickElementByXpath("//span[@class='x-tab-strip-inner']//span[text()='Data Browser']");
		    this.sleepCertainTime(3000);		    
			openJournal(entity,UniqueIdValueDup,OperationType,source);
			this.sleepCertainTime(3000); 
			JournalCheckResult(UniqueIdValueDup,OperationType);
			this.sleepCertainTime(3000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.url.assert", UniqueIdValueDup)), WAIT_TIME_MIN));
					
			
		}	
   public void createRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Name,String NameValue,String Description,String DescriptionValue,String Price,String PriceValue) {
	        OperationType="CREATE";
	        source="genericUI";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			String[] parametersUniqueId={entity,UniqueId};	
			String[] parametersName={entity,Name};	
			String[] parametersDescription={entity,Description};	
			String[] parametersPrice={entity,Price};	
			String[] UniqueIdAssert={UniqueId,UniqueIdValue};
			String[] NameAssert={Name,NameValue};
			String[] DescriptionAssert={Description,DescriptionValue};
			String[] PriceAssert={Price,PriceValue};
			String[] parametersUniqueIdAssert={entity,UniqueId,UniqueIdValue};
			String[] parametersNameAssert={entity,Name,NameValue};
			String[] parametersDescriptionAssert={entity,Description,DescriptionValue};
			String[] parametersPriceAssert={entity,Price,PriceValue};
			this.sleepCertainTime(3000);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 
			this.sleepCertainTime(3000);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersUniqueId),UniqueIdValue);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersName), NameValue);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersDescription), DescriptionValue);
			this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersPrice), PriceValue);
			this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
			this.sleepCertainTime(3000);
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersUniqueIdAssert)), WAIT_TIME_MAX),"createARecord");
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersNameAssert)), WAIT_TIME_MAX),"createARecord");
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersDescriptionAssert)), WAIT_TIME_MAX),"createARecord");
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersPriceAssert)), WAIT_TIME_MAX),"createARecord");
			this.sleepCertainTime(3000);		    
			openJournal(entity,UniqueIdValue,OperationType,source);
			this.sleepCertainTime(3000); 
			JournalCheckResult(UniqueIdValue,OperationType);
			this.sleepCertainTime(3000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",UniqueIdAssert )), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",NameAssert )), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",DescriptionAssert )), WAIT_TIME_MIN));
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",PriceAssert )), WAIT_TIME_MIN));
			OperationType="UPDATE";
		    source="CheckAvailability";
		    this.clickElementByXpath("//span[@class='x-tab-strip-inner']//span[text()='Data Browser']");
		    this.sleepCertainTime(3000);		    
			openJournal(entity,UniqueIdValue,OperationType,source);
			this.sleepCertainTime(3000); 
			JournalCheckResult(UniqueIdValue,OperationType);
			this.sleepCertainTime(3000); 
			Assert.assertTrue(this.isElementPresent(By.xpath("//span[text()='Availability:true']"), WAIT_TIME_MIN));
			OperationType="UPDATE";
		    source="CompleteStoreURL";
		    this.clickElementByXpath("//span[@class='x-tab-strip-inner']//span[text()='Data Browser']");
		    this.sleepCertainTime(3000);		    
			openJournal(entity,UniqueIdValue,OperationType,source);
			this.sleepCertainTime(3000); 
			JournalCheckResult(UniqueIdValue,OperationType);
			this.sleepCertainTime(3000); 
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.url.assert", UniqueIdValue)), WAIT_TIME_MIN));
			
}
/*	public void testUpdateCheckAvailabilityRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue){
		String availability;
		boolean availabilityRsulte=false;
		OperationType="UPDATE";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);		
		this.sleepCertainTime(3000);
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
		{ this.sleepCertainTime(3000);
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
		this.sleepCertainTime(3000); 
		JournalCheckResult(UniqueIdValue,OperationType);
		this.sleepCertainTime(3000); 
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
		this.sleepCertainTime(3000); 
		JournalCheckResult(UniqueIdValue,OperationType);
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.url.update.assert", parameters)), WAIT_TIME_MIN));
		}	
	}
	*/
 public void testUpdatePriceRecordImpl(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Price,String PriceValue,String flag,String PriceValueOld) {
	        OperationType="UPDATE";
		    source="genericUI";
		    String recordSearchResult;	
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
			 if ( this.isElementPresent(By.xpath(locator.getString("xpath.record.update.price.max")), WAIT_TIME_MAX)){
				 this.sleepCertainTime(3000);
				 this.clickElementByXpath("//button[text()='Ok']");	
				 enterJournal(entity,UniqueIdValue,OperationType,source);					
				 recordSearchResult=this.getElementByXpath(locator.getString("xpath.record.update.journal.price")).getText();
					if (recordSearchResult.contains("No data to display"))
					{	Assert.assertTrue(true);
		          	}
					else
						Assert.assertTrue(false);
					}
			}
			if (flag.equals("1"))
			{			
			 if (this.isElementPresent(By.xpath(locator.getString("xpath.record.update.price.min")), WAIT_TIME_MAX)){
				 this.clickElementByXpath("//button[text()='Ok']");	
				 Assert.assertTrue(true);
				 enterJournal(entity,UniqueIdValue,OperationType,source);
				 recordSearchResult=this.getElementByXpath(locator.getString("xpath.record.update.journal.price")).getText();
					if (recordSearchResult.contains("No data to display"))
					{	Assert.assertTrue(true);
			         }
					else
						Assert.assertTrue(false);
					}
			}
			if (flag.equals("2"))
			{			
			  enterJournal(entity,UniqueIdValue,OperationType,source);
			  this.sleepCertainTime(3000);
			  JournalCheckResult(UniqueIdValue,OperationType);
			  this.sleepCertainTime(3000);
			  Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.price.assert", PriceValueOld)), WAIT_TIME_MIN));
			  Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.update.price.assert", PriceValue)), WAIT_TIME_MIN));
			}
			
}
	public void SearchRecordByValueImpl(String container,String modle,String entity,String entity_Element,String searchFeild,String searchFeild_Element,String opeartion,String value){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		this.dragAndDropBy(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.databrowser.bigger"))), -200, 0);
		this.sleepCertainTime(6000);
		searchCondition(searchFeild,opeartion,value);
		this.sleepCertainTime(3000);
		searchValueAssert(searchFeild_Element,opeartion,value,entity_Element);	
	}
	public void SearchRecordByStringImpl(String container,String modle,String entity,String entity_Element,String searchFeild,String searchFeild_Element,String opeartion,String value){

		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		this.dragAndDropBy(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.databrowser.bigger"))), -200, 0);
		this.sleepCertainTime(6000);
		searchCondition(searchFeild,opeartion,value);
		this.sleepCertainTime(3000);
		searchStringAssert(searchFeild_Element,opeartion,value,entity_Element);
		
	}	
	
	
	public void openWorkflowTask(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID,String productFamilyId,String productFamilyName,String frankSubmitedFamilyName){
		LogonImpl log = new LogonImpl(this.driver);
		log.logout();
		log.loginUserForce(userFrank, frankPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		this.dragAndDropBy(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.expend.record.pannel"))), -500, 0);
		
		//select a product record in data browser
		this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		
		//verify frank can not change price directly
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)).isEnabled());
		
		//get the initial price for the product record
		String priceInitial = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
		logger.info("for frank ,the initial price is:"+priceInitial);
		
		//select request price change  ,and launch process
		this.launchProcess("Request Price Change");
        this.checkProcessDoneAndClickOK();
		List a = new ArrayList<String>();
        for (String handle : driver.getWindowHandles()) {
        a.add(handle);
        }
        driver.switchTo().window(a.get(1).toString());
        Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.ok.button.click.bonita.login.welcom")), WAIT_TIME_MIN)!=null);
        driver.switchTo().window(a.get(0).toString());
    	
		//for frank ,open workflow created and,type in price changed ,verify the foreign key info ,change foreign key info and submit.
		WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		this.sleepCertainTime(5000);
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.workflowtaskspage.tasks.properties.waiting")).size()>=1);
		
		//resort tasks by date ,and open the first work flow task
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input")),WAIT_TIME_MIN).isDisplayed());
	    
	    //frank logout then login ,open work flow task from welcome page
	    log.logout();
	    log.loginUserForce(userFrank, frankPass);	 
	    WelcomeImpl wel = new WelcomeImpl(this.driver);
	    wel.openWorkFlowTaskFromWelcome();
	    Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.workflowtaskspage.tasks.properties.waiting")).size()>=1);
	    
		// resort tasks by date ,and open the first work flow task
		flow.sortWorkFlowTaskBydate();
		flow.openAWorkTask();
		Assert.assertTrue(this
				.waitfor(
						By.xpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input")),
						WAIT_TIME_MIN).isDisplayed());
   
	    // frank change product familyname,change price ,then submit
        this.clickElementByXpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input.clear"));
        logger.info("+++++++++++++++++++++++++++++++++++++++++++"+this.getValueInput(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input"))));
        Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input"))).equals(""), "test foreign key info display failed,as product family name shows wrong before frank submit !");
        this.clickElementByXpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input.search"));
        Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input.search.searchpanel")), WAIT_TIME_MIN).isDisplayed());
        this.waitfor(By.xpath("//div[contains(@class,'search-item')]//h3[contains(text(),'"+frankSubmitedFamilyName+"')]"), WAIT_TIME_MIN).click();
        this.sleepCertainTime(2000);
        Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input"))).equals(frankSubmitedFamilyName), "test foreign key info display failed,as product family name shows wrong before frank submit !");
        String priceSubmited;
	    priceSubmited =  (flow.changeProductPriceValidImpl(Double.parseDouble(priceInitial), 0.15)+"");
	    logger.info("price frank submited is:"+priceSubmited);

	    log.logout();
	    log.loginUserForce(userJennifer, jenniferPass);
	
		//for jennifer ,open work flow task from welcome page
		wel.openWorkFlowTaskFromWelcome();
		
		//sort work flow task by date and open the first work
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input")),WAIT_TIME_MIN).isDisplayed());
	    this.sleepCertainTime(3000);
	    Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.workflow.openedworkflowtask.productdemo.productfamily.input"))).equals(frankSubmitedFamilyName), "test foreign key info display failed,as product family name shows wrong when jennifer approve !");
	    String price = this.getElementByXpath(locator.getString("xpath.workflowtask.open.product.price.input")).getAttribute("value");
	   
	}
	
	public void foreignKeyInfoDisplay(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID,String productFamilyId,String productFamilyName,String frankSubmitedFamilyName){
		LogonImpl log = new LogonImpl(this.driver);
		log.logout();
		log.loginUserForce(userFrank, frankPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		this.dragAndDropBy(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.expend.record.pannel"))), -500, 0);
		
		//select a product record in data browser
		this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		
		//click family panel to get the record family id and name
		this.clickElementByXpath("//div[contains(@class,'gwt-Label ItemsDetailPanel-tabLabel') and contains(text(),'Family')]");
		String idBefore = this.getValue(this.findElementDefineDriver(this.driver,By.xpath("//div[contains(@class,'gwt-Label ItemsDetailPanel-tabLabel') and contains(text(),'Family')]//ancestor::div[contains(@id,'ItemsDetailPanel-mainPanel')]//div[contains(@class,'x-grid3-body')]//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-objectValue ')][1]//div")));
		String nameBefore = this.getValue(this.findElementDefineDriver(this.driver,By.xpath("//div[contains(@class,'gwt-Label ItemsDetailPanel-tabLabel') and contains(text(),'Family')]//ancestor::div[contains(@id,'ItemsDetailPanel-mainPanel')]//div[contains(@class,'x-grid3-body')]//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-objectValue ')][2]//div")));
		logger.info("for the selected record ,producr family: "+idBefore +" name "+nameBefore);
		
		//click product pannel to launch price change process
		this.clickElementByXpath("//div[contains(@class,'gwt-Label ItemsDetailPanel-tabLabel') and contains(text(),'Product')]");
		
		//verify frank can not change price directly
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)).isEnabled());
		
		//get the initial price for the product record
		String priceInitial = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
		logger.info("for frank ,the initial price is:"+priceInitial);
		
		//select request price change  ,and launch process
		this.launchProcess("Request Price Change");
		this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.status.info")), WAIT_TIME_MID);
		
		//click process ok button to verify can open bonita workflow console
		this.clickElementByXpath(locator.getString("xpath.record.launchprocess.success.ok.button"));
       
		List a = new ArrayList<String>();
        for (String handle : driver.getWindowHandles()) {
        a.add(handle);
        }
        driver.switchTo().window(a.get(1).toString());
        Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.ok.button.click.bonita.login.welcom")), WAIT_TIME_MIN)!=null);
        driver.switchTo().window(a.get(0).toString());
    	
		//for frank ,open workflow created and,type in price changed ,verify the foreign key info ,change foreign key info and submit.
		WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		this.sleepCertainTime(5000);
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    Assert.assertTrue(this.waitfor(By.xpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item ')]//input"),WAIT_TIME_MIN).isDisplayed());
        Assert.assertTrue(this.getValueInput(By.xpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item ')]//input")).equals(nameBefore), "test foreign key info display failed,as product family name shows wrong before frank submit !");
	    
	    // frank change product familyname,change price ,then submit
        this.clickElementByXpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item ')]//span[contains(@class,'x-form-twin-triggers')]//img[contains(@class,'x-form-trigger x-form-clear-trigger')]");
        logger.info("+++++++++++++++++++++++++++++++++++++++++++"+this.getValueInput(By.xpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item ')]//input")));
        Assert.assertTrue(this.getValueInput(By.xpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item ')]//input")).equals(""), "test foreign key info display failed,as product family name shows wrong before frank submit !");
        this.clickElementByXpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item ')]//span[contains(@class,'x-form-twin-triggers')]//img[contains(@class,'x-form-trigger x-form-search-trigger')]");
        Assert.assertTrue(this.waitfor(By.xpath("//div[contains(@id,'task-foreign-key-window') and contains(@class,'x-window x-window-plain x-resizable-pinned')]"), WAIT_TIME_MIN).isDisplayed());
        this.waitfor(By.xpath("//div[contains(@class,'search-item')]//h3[contains(text(),'"+frankSubmitedFamilyName+"')]"), WAIT_TIME_MIN).click();
        this.sleepCertainTime(2000);
        Assert.assertTrue(this.getValueInput(By.xpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item ')]//input")).equals(frankSubmitedFamilyName), "test foreign key info display failed,as product family name shows wrong before frank submit !");
        String priceSubmited;
	    priceSubmited =  (flow.changeProductPriceValidImpl(Double.parseDouble(priceInitial), 0.15)+"");
	    logger.info("price frank submited is:"+priceSubmited);

	    log.logout();
	    log.loginUserForce(userJennifer, jenniferPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		//select the record first
		this.sleepCertainTime(5000);
	    this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
	
		//open work flow task page
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		
		//sort work flow task by date and open the first work
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    Assert.assertTrue(this.waitfor(By.xpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item ')]//input"),WAIT_TIME_MIN).isDisplayed());
	    this.sleepCertainTime(3000);
	    Assert.assertTrue(this.getValueInput(By.xpath("//label[text()='Family:']//ancestor::div[contains(@class,'x-form-item')]//input")).equals(frankSubmitedFamilyName), "test foreign key info display failed,as product family name shows wrong when jennifer approve !");
	    String price = this.getElementByXpath(locator.getString("xpath.workflowtask.open.product.price.input")).getAttribute("value");
	    
	    //jennifer approved and submit
	    flow.approveBoxChecked();
	    flow.clickSubmit();
	 	this.waitfor(By.xpath(locator.getString("xpath.workflowtask.open.produce.submited.success.info")), WAIT_TIME_MID);
    	this.clickElementByXpath(locator.getString("xpath.workflowtask.open.product.submited.success.ok.button"));
		this.sleepCertainTime(5000);
		
		flow.uncheckHideFinishedTask();
		flow.clickSearch();
		flow.sortWorkFlowTaskBydate();
		this.sleepCertainTime(3000);
		flow.openAWorkTask();
		flow.openRelatedRecord();
        Assert.assertTrue(this.waitfor(By.xpath(this.getString(locator, "xpath.workflowtask.openrelatedrecord.open.closeTab", productUniqID)), WAIT_TIME_MIN)!=null);
      
        //verify price is really changed.
        //close the data browser first ,for xpath duplicated
        this.clickElementByXpath(locator.getString("xpath.databrowser.tab.close"));
        this.sleepCertainTime(3000);
    	price = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
        logger.info("afterapproved ,the price is:"+price);
//        Assert.assertTrue(price.equals(priceSubmited));
        Assert.assertTrue(Double.parseDouble(price)>Double.parseDouble(priceInitial));
        
        //verify family name not changed as submitted
      //click family panel to get the record family id and name
      	this.clickElementByXpath("//div[contains(@class,'gwt-Label ItemsDetailPanel-tabLabel') and contains(text(),'Family')]");
      	Assert.assertTrue(this.getValue(this.findElementDefineDriver(this.driver,By.xpath("//div[contains(@class,'gwt-Label ItemsDetailPanel-tabLabel') and contains(text(),'Family')]//ancestor::div[contains(@id,'ItemsDetailPanel-mainPanel')]//div[contains(@class,'x-grid3-body')]//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-objectValue ')][2]//div"))).equals(nameBefore));
      	logger.info("for the selected record after approved ,product family: "+idBefore +" name "+this.getValue(this.findElementDefineDriver(this.driver,By.xpath("//div[contains(@class,'gwt-Label ItemsDetailPanel-tabLabel') and contains(text(),'Family')]//ancestor::div[contains(@id,'ItemsDetailPanel-mainPanel')]//div[contains(@class,'x-grid3-body')]//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-objectValue ')][2]//div"))));
	    
	}
	
	
	public void priceChangeWorkFlowValidApprovedImpl(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID){
		LogonImpl log = new LogonImpl(this.driver);
		log.logout();
		log.loginUserForce(userFrank, frankPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		this.dragAndDropBy(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.expend.record.pannel"))), -500, 0);
		
		//select a product record in data browser
		this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		
		//open journal to verify number of action entry for frank ,then close journal
		this.openJournalFromDataBrowser();
		this.sleepCertainTime(5000);
		int beforeProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
		logger.info("beforeProcess:"+beforeProcess);
		this.closeJournal();
		
		//verify frank can not change price directly
		this.sleepCertainTime(5000);
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)).isEnabled());
		
		//get the initial price for the product record
		String priceInitial = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
		logger.info("for frank ,the initial price is:"+priceInitial);
		
		//select request price change  ,and launch process
		this.launchProcess("Request Price Change");
		this.checkProcessDoneAndClickOK();
		
        this.sleepCertainTime(5000);
        List a = new ArrayList<String>();
        for (String handle : driver.getWindowHandles()) {
        a.add(handle);
        }
        driver.switchTo().window(a.get(1).toString());
        Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.ok.button.click.bonita.login.welcom")), WAIT_TIME_MIN)!=null);
        driver.switchTo().window(a.get(0).toString());
    	
        //open journal and verify number of action entry for frank +1,then close journal
        this.openJournalFromDataBrowser();
    	this.sleepCertainTime(5000);
		int afterProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
		logger.info("afterProcess:"+afterProcess);
		Assert.assertTrue(afterProcess-beforeProcess==1);
		
		//open the journal record ,and verify the price is not changed directly
		 OperationType="ACTION";
		 source="genericUI";
		this.JournalCheckResult(productUniqID, OperationType);
		this.checkPropertiesBeforeAfterInDatachangesViewer("Price", priceInitial, priceInitial, true);
		
		//close datachangesviewer page.
		this.closeDatachangesViewer();
		
		//close journal
		this.closeJournal();
		
		//for frank ,open workflow created and,type in price changed ,then submit
		WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		this.sleepCertainTime(5000);
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    String priceSubmited;
	    priceSubmited =  (flow.changeProductPriceValidImpl(Double.parseDouble(priceInitial), 0.15)+"");
	    logger.info("price frank submited is:"+priceSubmited);
	    
	    log.logout();
	    log.loginUserForce(userJennifer, jenniferPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		//check in journal for jennifer update first
		this.sleepCertainTime(5000);
	    this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		
		this.openJournalFromDataBrowser();
		this.sleepCertainTime(5000);
		int beforeApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.jennifer")).size();
		logger.info("beforeApprove:"+beforeApprove);
		this.closeJournal();
		//open work flow task page
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		this.sleepCertainTime(10000);
		//sort work flow task by date and open the first work
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    String price = this.getElementByXpath(locator.getString("xpath.workflowtask.open.product.price.input")).getAttribute("value");
	    this.sleepCertainTime(5000);
	    //jennifer approved and submit
	    flow.approveBoxChecked();
	    flow.clickSubmit();
	 	this.waitfor(By.xpath(locator.getString("xpath.workflowtask.open.produce.submited.success.info")), WAIT_TIME_MID);
    	this.clickElementByXpath(locator.getString("xpath.workflowtask.open.product.submited.success.ok.button"));
		this.sleepCertainTime(5000);
		
		flow.uncheckHideFinishedTask();
		flow.clickSearch();
		flow.sortWorkFlowTaskBydate();
		this.sleepCertainTime(3000);
		flow.openAWorkTask();
		flow.openRelatedRecord();
    	this.sleepCertainTime(5000);
        Assert.assertTrue(this.waitfor(By.xpath(this.getString(locator, "xpath.workflowtask.openrelatedrecord.open.closeTab", productUniqID)), WAIT_TIME_MIN)!=null);
      
        //verify price is really changed.
        //close the data browser first ,for xpath duplicated
        this.clickElementByXpath(locator.getString("xpath.databrowser.tab.close"));
        this.sleepCertainTime(3000);
    	price = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
        logger.info("afterapproved ,the price is:"+price);
//        Assert.assertTrue(price.equals(priceSubmited));
        Assert.assertTrue(Double.parseDouble(price)>Double.parseDouble(priceInitial));
        
        //reopen data browser
        this.clickElementByXpath("//span[contains(@class,'x-panel-header-text') and text()='Home']");
        this.clickElementByXpath("//div[contains(@id,'menu-browserecords')]");
        this.chooseEntity(entity);
        this.sleepCertainTime(5000);
       
        //close the record opened
    	flow.closeRelatedRecord(productUniqID);
    
    	//close the work task
    	flow.closeAWorkTask();
    	
    	//verify in journal that an update entry for jennifer added
    	this.clickElementByXpath(locator.getString("xpath.datavrowser.tab"));
    	this.sleepCertainTime(3000);
    	this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
    	this.sleepCertainTime(5000)	;
 		this.openJournalFromDataBrowser();
 		this.sleepCertainTime(5000);
 		int afterApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.jennifer")).size();
 		logger.info("afterApprove:"+afterApprove);
 		Assert.assertTrue(afterApprove-beforeApprove==1);
 		
		 OperationType="UPDATE";
		 source="genericUI";
		this.JournalCheckResult(productUniqID, OperationType);
		this.checkPropertiesBeforeAfterInDatachangesViewer("Price", priceInitial, priceInitial, false);
		
		//close datachangesviewer page.
		this.closeDatachangesViewer();
 		this.closeJournal();
    	
	    
	}
	
	public void priceChangeWorkFlowValidNotApprovedImpl(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID){
		LogonImpl log = new LogonImpl(this.driver);
		log.logout();
		log.loginUserForce(userFrank, frankPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		this.dragAndDropBy(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.expend.record.pannel"))), -500, 0);
		
		//select a product record in data browser
		this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		
		//open journal to verify number of action entry for frank ,then close journal
		this.openJournalFromDataBrowser();
		this.sleepCertainTime(5000);
		int beforeProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
		logger.info("beforeProcess:"+beforeProcess);
		this.closeJournal();
		
		//verify frank can not change price directly
		this.sleepCertainTime(5000);
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)).isEnabled());
		
		//get the initial price for the product record
		String priceInitial = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
		logger.info("for frank ,the initial price is:"+priceInitial);
		
		//select request price change  ,and launch process
		this.launchProcess("Request Price Change");
		this.checkProcessDoneAndClickOK();
		
        this.sleepCertainTime(5000);
        List a = new ArrayList<String>();
        for (String handle : driver.getWindowHandles()) {
        a.add(handle);
        }
        driver.switchTo().window(a.get(1).toString());
        Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.ok.button.click.bonita.login.welcom")), WAIT_TIME_MIN)!=null);
        driver.switchTo().window(a.get(0).toString());
    	
        //open journal and verify number of action entry for frank +1,then close journal
        this.openJournalFromDataBrowser();
    	this.sleepCertainTime(5000);
		int afterProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
		logger.info("afterProcess:"+afterProcess);
		Assert.assertTrue(afterProcess-beforeProcess==1);
		this.closeJournal();
		
		//for frank ,open workflow created and,type in price changed ,then submit
		WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		this.sleepCertainTime(5000);
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    String priceSubmited;
	    priceSubmited =  (flow.changeProductPriceValidImpl(Double.parseDouble(priceInitial), 0.15)+"");
	    logger.info("price frank submited is:"+priceSubmited);
	    
	    log.logout();
	    log.loginUserForce(userJennifer, jenniferPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		//check in journal for jennifer update first
		this.sleepCertainTime(5000);
	    this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		
		this.openJournalFromDataBrowser();
		this.sleepCertainTime(5000);
		int beforeApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.jennifer")).size();
		logger.info("beforeApprove:"+beforeApprove);
		this.closeJournal();
		//open work flow task page
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		this.sleepCertainTime(10000);
		//sort work flow task by date and open the first work
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    String price = this.getElementByXpath(locator.getString("xpath.workflowtask.open.product.price.input")).getAttribute("value");
	    this.sleepCertainTime(5000);
	    //jennifer approved and submit
//	    flow.approveBoxChecked();
	    flow.clickSubmit();
	 	this.waitfor(By.xpath(locator.getString("xpath.workflowtask.open.produce.submited.success.info")), WAIT_TIME_MID);
    	this.clickElementByXpath(locator.getString("xpath.workflowtask.open.product.submited.success.ok.button"));
		this.sleepCertainTime(5000);
		
		flow.uncheckHideFinishedTask();
		flow.clickSearch();
		flow.sortWorkFlowTaskBydate();
		this.sleepCertainTime(3000);
		flow.openAWorkTask();
		this.sleepCertainTime(5000);
		flow.openRelatedRecord();
    	this.sleepCertainTime(5000);
        Assert.assertTrue(this.waitfor(By.xpath(this.getString(locator, "xpath.workflowtask.openrelatedrecord.open.closeTab", productUniqID)), WAIT_TIME_MIN)!=null);
      
        //verify price is not changed.
        //close the data browser first ,for xpath duplicated
        this.clickElementByXpath(locator.getString("xpath.databrowser.tab.close"));
    	price = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
        logger.info("afterapproved ,the price is:"+price);
        Assert.assertTrue(price.equals(priceInitial));
        
        //reopen data browser
        this.clickElementByXpath("//span[contains(@class,'x-panel-header-text') and text()='Home']");
        this.clickElementByXpath("//div[contains(@id,'menu-browserecords')]");
        this.chooseEntity(entity);
        this.sleepCertainTime(5000);
       
        //close the record opened
    	flow.closeRelatedRecord(productUniqID);
    
    	//close the work task
    	flow.closeAWorkTask();
    	
    	//verify in journal that an update entry for jennifer not added
    	this.clickElementByXpath(locator.getString("xpath.datavrowser.tab"));
    	this.sleepCertainTime(3000);
    	this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
    	this.sleepCertainTime(5000)	;
 		this.openJournalFromDataBrowser();
 		this.sleepCertainTime(5000);
 		int afterApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.jennifer")).size();
 		logger.info("afterApprove:"+afterApprove);
 		Assert.assertTrue(afterApprove-beforeApprove==0);
 		this.closeJournal();
	    
	}
	
	public void priceChangeWorkFlowInValidImpl(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID){
		LogonImpl log = new LogonImpl(this.driver);
		log.logout();
		log.loginUserForce(userFrank, frankPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		this.dragAndDropBy(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.expend.record.pannel"))), -500, 0);
		
		//select a product record in data browser
		this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		
		//open journal to verify number of action entry for frank ,then close journal
		this.openJournalFromDataBrowser();
		this.sleepCertainTime(5000);
		int beforeProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
		logger.info("beforeProcess:"+beforeProcess);
		this.closeJournal();
		
		//verify frank can not change price directly
		this.sleepCertainTime(5000);
		Assert.assertFalse(this.getElementByXpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)).isEnabled());
		
		//get the initial price for the product record
		String priceInitial = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
		logger.info("for frank ,the initial price is:"+priceInitial);
		
		//select request price change  ,and launch process
		this.launchProcess("Request Price Change");
		this.checkProcessDoneAndClickOK();
	    this.sleepCertainTime(5000);
        List a = new ArrayList<String>();
        for (String handle : driver.getWindowHandles()) {
        a.add(handle);
        }
        driver.switchTo().window(a.get(1).toString());
        Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.ok.button.click.bonita.login.welcom")), WAIT_TIME_MIN)!=null);
        driver.switchTo().window(a.get(0).toString());
    	
        //open journal and verify number of action entry for frank +1,then close journal
        this.openJournalFromDataBrowser();
    	this.sleepCertainTime(5000);
		int afterProcess = this.getElementsByXpath(locator.getString("xpath.journal.entry.action.frank")).size();
		logger.info("afterProcess:"+afterProcess);
		Assert.assertTrue(afterProcess-beforeProcess==1);
		this.closeJournal();
		
		//for frank ,open workflow created and,type in price changed ,then submit
		WorkFlowTaskImpl flow = new WorkFlowTaskImpl(this.driver);
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		this.sleepCertainTime(10000);
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    String priceSubmited;
	    priceSubmited =  (flow.changeProductPriceInvalidImpl(Double.parseDouble(priceInitial), 0.15)+"");
	    logger.info("price frank submited is:"+priceSubmited);
	    
	    //logout frank ,then login jennifer
	    log.logout();
	    log.loginUserForce(userJennifer, jenniferPass);
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		
		//check in journal for jennifer update first
		this.sleepCertainTime(5000);
	    this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		this.openJournalFromDataBrowser();
		this.sleepCertainTime(5000);
		int beforeApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.jennifer")).size();
		logger.info("beforeApprove:"+beforeApprove);
		this.closeJournal();
		
		//open work flow task page
		flow.openMenuGoven();
		flow.openMenuWorkFlowTask();
		this.sleepCertainTime(10000);
		
		//sort work flow task by date and open the first work
		flow.sortWorkFlowTaskBydate();
	    flow.openAWorkTask();
	    String price = this.getElementByXpath(locator.getString("xpath.workflowtask.open.product.price.input")).getAttribute("value");
	    this.sleepCertainTime(5000);
	    
	    //jennifer approved and submit
	    flow.approveBoxChecked();
	    flow.clickSubmit();
	 	this.waitfor(By.xpath(locator.getString("xpath.workflowtask.open.produce.submited.success.info")), WAIT_TIME_MID);
    	this.clickElementByXpath(locator.getString("xpath.workflowtask.open.product.submited.success.ok.button"));
		this.sleepCertainTime(5000);
		
		flow.uncheckHideFinishedTask();
		flow.clickSearch();
		flow.sortWorkFlowTaskBydate();
		this.sleepCertainTime(3000);
		flow.openAWorkTask();
		this.sleepCertainTime(5000);
		flow.openRelatedRecord();
    	this.sleepCertainTime(5000);
        Assert.assertTrue(this.waitfor(By.xpath(this.getString(locator, "xpath.workflowtask.openrelatedrecord.open.closeTab", productUniqID)), WAIT_TIME_MIN)!=null);
      
        //verify price is not changed.
        //close the data browser first ,for xpath duplicated
        this.clickElementByXpath(locator.getString("xpath.databrowser.tab.close"));
    	price = this.getValueInput(By.xpath(this.getString(locator, "xpath.record.priceinput.byID", productUniqID)));
        logger.info("afterapproved ,the price is:"+price);
        Assert.assertTrue(price.equals(priceInitial));
        
        //reopen data browser
        this.clickElementByXpath("//span[contains(@class,'x-panel-header-text') and text()='Home']");
        this.clickElementByXpath("//div[contains(@id,'menu-browserecords')]");
        this.chooseEntity(entity);
        this.sleepCertainTime(5000);
       
        //close the record opened
    	flow.closeRelatedRecord(productUniqID);
    
    	//close the work task
    	flow.closeAWorkTask();
    	
    	//verify in journal that an update entry for jennifer not added
    	this.clickElementByXpath(locator.getString("xpath.datavrowser.tab"));
    	this.sleepCertainTime(3000);
    	this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
    	this.sleepCertainTime(5000)	;
 		this.openJournalFromDataBrowser();
 		this.sleepCertainTime(5000);
 		int afterApprove = this.getElementsByXpath(locator.getString("xpath.journal.entry.update.jennifer")).size();
 		logger.info("afterApprove:"+afterApprove);
 		Assert.assertTrue(afterApprove-beforeApprove==0);
 		this.closeJournal();
	    
	}
	
	public void storeShowOnMapProcessImpl(String container,String model,String entity,String productUniqID){
		
		this.chooseContainer(container);
		this.chooseModle(model);
		this.clickSave();
		this.chooseEntity(entity);
		this.sleepCertainTime(5000);
		this.dragAndDropBy(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.record.expend.record.pannel"))), -500, 0);
		
		//select a product record with store associated  in data browser
		this.clickElementByXpath(this.getString(locator, "xpath.record.chooserecord.byID", productUniqID));
		this.sleepCertainTime(5000);
		
		//select show on map option  ,and launch process
		this.seletDropDownList(By.xpath(locator.getString("xpath.record.launchprocess.select.img")), "Show on map");
		this.sleepCertainTime(2000);
		this.clickElementByXpath(locator.getString("xpath.record.launchprocess.button"));
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.status.info")), WAIT_TIME_MID).isDisplayed());
		
		//click process ok button to verify can open a google map 
		this.clickElementByXpath(locator.getString("xpath.record.launchprocess.success.ok.button"));
        this.sleepCertainTime(5000);
        List a = new ArrayList<String>();
        for (String handle : driver.getWindowHandles()) {
        a.add(handle);
        }
        driver.switchTo().window(a.get(1).toString());
        Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.launchprocess.success.ok.button.click.store.google.map")), WAIT_TIME_MIN)!=null);
        driver.switchTo().window(a.get(0).toString());
    	
    
	}
	

	
   public void checkPropertiesBeforeAfterInDatachangesViewer(String properties,String valueBefore,String valueAfter,boolean compareType){
	   
	   String before = this.getValue(this.getElementByXpath("//span[text()='Before']//ancestor::div[@id='documentHistoryPanel1']//span[contains(text(),'"+properties+"')]")).trim();
       logger.info("in update detail panel,value before is :"+before);
       logger.info("parameters for value before is :"+valueBefore);
	   Assert.assertTrue(before.contains(valueBefore));
       String after = this.getValue(this.getElementByXpath("//span[text()='After']//ancestor::div[@id='documentHistoryPanel2']//span[contains(text(),'"+properties+"')]")).trim();
       logger.info("in update detail panel,value after is :"+after);
       logger.info("parameters for value after is :"+valueAfter);
       //true ,means before = after.
       if(compareType){
    	   Assert.assertTrue(before.equals(after));
    	   Assert.assertTrue(after.contains(valueAfter));
       }
       else{
    	   Assert.assertFalse(after.equals(before));
       }
       
   }

}
