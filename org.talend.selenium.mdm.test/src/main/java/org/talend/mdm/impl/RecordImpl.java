package org.talend.mdm.impl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;

public class RecordImpl extends Record{
	public RecordImpl(WebDriver driver) {
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
	
	public void restoreFromRecycleImpl(String container,String modle,String entity,String feild1Value,String feild1Name){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		clickRecycle();
		this.sleepCertainTime(5000);
		this.clickElementByXpath(this.getString(locator, "xpath.record.recycle.click.record",feild1Value));
		this.clickElementByXpath(this.getString(locator,"xpath.record.recycle.click.record.restore",feild1Value));
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
		String[] parameters={entity,feild1Name,feild1Value};
		//this.clickElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",parameters));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.delete.record",parameters)), WAIT_TIME_MIN),"the record restore in the entity");
		chooseRcord(entity,feild1Name,feild1Value);
		this.sleepCertainTime(5000);
		deleteTheRecord(entity);
	}
	
	public void deleteRecordImpl(String container,String modle,String entity,String feild1Value,String feild1Name){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		entity=entity.replaceAll(" ","");
		chooseRcord(entity,feild1Name,feild1Value);	
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	}
	
	public void JournalOpenRecordImpl(String entity,String feild1Value){
		String[] parameters={entity,feild1Value};
		//click the journal
		clickJournal();
		//input the search condition
		this.typeTextByXpath(locator.getString("xpath.record.choose.journal.entity"), entity);
		this.typeTextByXpath(locator.getString("xpath.record.choose.journal.key"), feild1Value);
		this.clickElementByXpath(locator.getString("xpath.record.choose.journal.operation.arrows")); 
		this.clickElementByXpath(locator.getString("xpath.record.choose.journal.operation.choose")); 		
		this.sleepCertainTime(2000);
		try {
			Robot bot = new Robot();
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);

			bot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.journal.choose.record", feild1Value)), WAIT_TIME_MIN);
		this.doubleClick(this.getElementByXpath(this.getString(locator, "xpath.record.choose.journal.choose.record", feild1Value)));
		this.isElementPresent(By.xpath("//button[text()='Open Record']"), WAIT_TIME_MIN);
		this.clickElementByXpath("//button[text()='Open Record']");
		//assert can see the record detail	
		this.sleepCertainTime(5000);
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.journal.assert.open",parameters)), WAIT_TIME_MIN),"open detail");
	}
	
	public void deleteRecordToRecycleImpl(String container,String modle,String entity,String feild1Value,String feild1Name){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		entity=entity.replaceAll(" ","");
	    String[] parameters_container={feild1Value,container};
		String[] parameters_modle={feild1Value,modle};
		String[] parameters_entity={feild1Value,entity};
		chooseRcord(entity,feild1Name,feild1Value);	
		this.sleepCertainTime(5000);
		logger.warn(this.getString(locator, "xpath.record.delete.record",entity));
		this.clickElementByXpath(this.getString(locator, "xpath.record.delete.record",entity)); 
		this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.choose")); 	 
		this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.choose.ok")); 	
			if (this.isElementPresent(By.xpath(locator.getString("xpath.record.delete.record.warn")),WAIT_TIME_MIN)){
				this.clickElementByXpath("//button[text()='No']");		
			}
		// assert the record which been deleted in the recycle
		clickRecycle();	
		//this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.assert.clickRefresh")); 
		logger.warn(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.container",parameters_container));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.container",parameters_container)), WAIT_TIME_MIN ),"container");
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.modle",parameters_modle)), WAIT_TIME_MIN ),"modle");
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.entity",parameters_entity)), WAIT_TIME_MIN ),"entity");
	}
	
	public void duplicateRecordImpl(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		entity=entity.replaceAll(" ","");
		String[] parametersFeild2Value={entity,feild2Value_old};	
		String[] parametersFeild2={entity,feild2Name};	
		String[] parametersFeild2Assert={entity,feild2Name,feild2Value};	
		chooseRcord(entity,feild2Name,feild2Value_old);		
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFeild2)), WAIT_TIME_MAX),"duplicateARecord");
		this.sleepCertainTime(5000);
		this.clickElementByXpath(this.getString(locator,"xpath.record.Duplicate.close.origin",parametersFeild2Value));	
		this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFeild2)), feild2Value);
		//this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), feild2Value);
		//this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild3",parametersFeild3)), feild3Value);
		
		this.clickElementByXpath(locator.getString("xpath.record.Duplicate.saveAndClose"));	
		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"createARecord");
	}	
	
	public void createRecordImpl(String container,String modle,String entity,String feild2Value,String feild2Name){
  /*     String feild1Value;*/
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		entity=entity.replaceAll(" ","");
		String[] parametersFeild2={entity,feild2Name};				
		String[] parametersFeild2Assert={entity,feild2Name,feild2Value};	
		logger.warn(feild2Name);
		this.clickCreateRecord();
//			this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 	
		this.waitforElementDisplayed(By.xpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), WAIT_TIME_MAX);
		this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2), feild2Value);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		
		//Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild1",parametersFeild1Assert)), WAIT_TIME_MAX),"createARecord");
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"createARecord");
	    this.sleepCertainTime(3000);  		
/*	    feild1Value=this.getText();*/
//	    JournalOpenRecordImpl(entity,feild1Value);
	}
	
	public void updateRecordImpl(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		entity=entity.replaceAll(" ","");
		String[] parametersFeild2={entity,feild2Name};
		String[] parametersFeild2Assert={entity,feild2Name,feild2Value};
		chooseRcord(entity,feild2Name,feild2Value_old);			
		this.sleepCertainTime(5000);
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), 3000));
		this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), feild2Value);
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		if (this.isTextPresent("No change since last save")){
			this.clickElementByXpath("//button[text()='Ok']");		
		}else{
			this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
			Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"updateARecord");
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
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		searchCondition(searchFeild,opeartion,value);
		searchDateAssert(searchFeild,opeartion,value,entity);
	}
}
