package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;

public class RecordImplEDA extends Record{
	 String OperationType,key,source;
	 boolean result;
  
	public RecordImplEDA(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void testUpdateRecordAddMultipleFieldImpl(String container,String modle,String entity,String IdValue,String Type1,String Type2) {
        OperationType="UPDATE";
        source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);		
		this.sleepCertainTime(3000);
		entity="Eda";
		chooseRcord(entity, "idEda",IdValue);		
		this.clickElementByXpath(locator.getString("xpath.record.eda.type1"));
		this.clickElementByXpath(this.getString(locator, "xpath.record.eda.type.value", Type1));		
		this.clickElementByXpath(locator.getString("xpath.record.eda.type.add"));	
		this.clickElementByXpath(locator.getString("xpath.record.eda.type2"));
		this.clickElementByXpath(this.getString(locator, "xpath.record.eda.type.value", Type2));
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
		this.sleepCertainTime(10000);
		 //assert
		chooseRcord(entity, "idEda",IdValue);
		Assert.assertEquals(this.getValueInput(By.name("Eda/typesEda/typeEDA")),  Type1);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.record.eda.type"))), Type2);
		enterJournal(entity,IdValue,OperationType,source);
		JournalResultCount();
    }
	public void testUpdateRecordDateImpl(String container,String modle,String entity,String IdValue,String date) {
        OperationType="UPDATE";
        source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);		
		this.sleepCertainTime(3000);
		entity="Eda";
		chooseRcord(entity, "idEda",IdValue);
		this.typeTextByName("Eda/dateDebutEda", date);
		
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
		this.sleepCertainTime(10000);
		 //assert
		chooseRcord(entity, "idEda",IdValue);
		Assert.assertEquals(this.getValueInput(By.name("Eda/dateDebutEda")),date);
		enterJournal(entity,IdValue,OperationType,source);
		JournalResultCount();
    }
	



}
