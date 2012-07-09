package org.talend.mdm.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;

public class ThirdEntityImpl extends Record{
	public ThirdEntityImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private void expendAllFields(){
		//expend
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.expend.img"));
		this.sleepCertainTime(2000);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.expend.img"));
		this.sleepCertainTime(2000);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.expend.img"));
		this.sleepCertainTime(2000);
		
		this.clickElementByXpath(locator.getString("xpath.thirdentity.optionalDetails.expend.img"));
		this.sleepCertainTime(2000);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.expend.img"));
		this.sleepCertainTime(2000);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.expend.img"));
		this.sleepCertainTime(2000);
		
	}
	public void createThirdEntityRecordSuccessImpl(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		int recordCount = this.getTotalRecordNum();
		logger.warn("before create ,total record num is:"+recordCount);
		this.clickCreateRecord();
		this.expendAllFields();
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.key.input"), key);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.name.input"), name);
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatory1.input"), mdM1);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional2.input"), mdO2);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded3.input"), mdOu3);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input"), mdMu4);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.mandatory51.input"), mdO5m51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.optional51.input"), mdO5o51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.mandatory61.input"), mdOu6m61);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.optional62.input"), mdOu6o62);
		
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.mandatory1.input"), odM1);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional2.input"), odO2);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded3.input"), odOu3);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.mandatoryUbounded4.input"), odMu4);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.mandatory51.input"), odO5m51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.optional51.input"), odO5o51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.mandatory61.input"), odOu6m61);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.optional62.input"), odOu6o62);
		
		
	    this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	    this.sleepCertainTime(10000);
	    int recordCountAfter = this.getTotalRecordNum();
		logger.warn("after create ,total record num is:"+recordCountAfter);
		Assert.assertTrue(recordCountAfter-recordCount==1);
		this.expendAllFields();
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.key.input"))), key);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.name.input"))), name);
		
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatory1.input"))), mdM1);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional2.input"))), mdO2);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded3.input"))), mdOu3);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input"))), mdMu4);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.mandatory51.input"))), mdO5m51);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.optional51.input"))), mdO5o51);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.mandatory61.input"))), mdOu6m61);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.optional62.input"))), mdOu6o62);
		
		
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.optionalDetails.mandatory1.input"))), odM1);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.optionalDetails.optional2.input"))), odO2);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded3.input"))), odOu3);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.optionalDetails.mandatoryUbounded4.input"))), odMu4);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.mandatory51.input"))), odO5m51);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.optional51.input"))), odO5o51);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.mandatory61.input"))), odOu6m61);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.optional62.input"))), odOu6o62);
		
	
	}	
	
	public void createThirdEntityRecordSuccessWithMutipleOccurrencesImpl(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		int recordCount = this.getTotalRecordNum();
		logger.warn("before create ,total record num is:"+recordCount);
		this.clickCreateRecord();
		this.expendAllFields();
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.key.input"), key);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.name.input"), name);
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatory1.input"), mdM1);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional2.input"), mdO2);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded3.input"), mdOu3);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input"), mdMu4);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.mandatory51.input"), mdO5m51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.optional51.input"), mdO5o51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.mandatory61.input"), mdOu6m61);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.optional62.input"), mdOu6o62);
		
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.mandatory1.input"), odM1);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional2.input"), odO2);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded3.input"), odOu3);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.mandatoryUbounded4.input"), odMu4);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.mandatory51.input"), odO5m51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.optional51.input"), odO5o51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.mandatory61.input"), odOu6m61);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.optional62.input"), odOu6o62);
		
		
		//add mutiple occurrences of mandatoryUbounde4,add multiple optionalUbounde6
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input")).size()==1);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.mandatoryUbounded4.addoccurrences.img"));
		this.sleepCertainTime(2000);
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input")).size()==2);
		
		
		logger.warn(this.getElementsByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.optionalUbounded6")).size());
		this.sleepCertainTime(10000);
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.optionalUbounded6")).size()==1);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.optionalUbounded6.addoccurrences.img"));
		this.sleepCertainTime(2000);
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.optionalUbounded6")).size()==2);
		
		//fill mandatoryUbounde4 just created
		this.typeTextByXpath("//div[contains(@id,'TreeDetail-tree')]/div[2]/div/div[4]/div/div[5]//input", mdMu4);
		
	    this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	    this.sleepCertainTime(10000);
	    int recordCountAfter = this.getTotalRecordNum();
		logger.warn("after create ,total record num is:"+recordCountAfter);
		Assert.assertTrue(recordCountAfter-recordCount==1);
		
		
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.expend.img"));
		this.sleepCertainTime(2000);
		Assert.assertEquals(this.getValueInput(By.xpath("//div[contains(@id,'TreeDetail-tree')]/div[2]/div/div[4]/div/div[5]//input")), mdMu4);
		
	}
	
	public void updateThirdEntityRecordSuccessWithMutipleOccurrencesImpl(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
	    Assert.assertTrue(this.waitfor(By.xpath(this.getString(locator, "xpath.thirdentity.record.select.by.key", key)), WAIT_TIME_MID).isDisplayed());
		this.clickElementByXpath(this.getString(locator, "xpath.thirdentity.record.select.by.key", key));
		
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.expend.img"));
		this.sleepCertainTime(2000);
		//remove mutiple occurrences of mandatoryUbounde4,remove multiple optionalUbounde6
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input")).size()==2);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.mandatoryUbounded4.removeoccurrences.img"));
		Assert.assertTrue(this.waitfor(By.xpath("//span[contains(text(),'Do you really want to delete the selected record?')]"), WAIT_TIME_MIN).isDisplayed());	   
		this.clickElementByXpath("//span[contains(text(),'Confirmation')]//ancestor::div[contains(@class,'x-window-plain x-window-dlg x-window x-component')]//button[contains(text(),'Yes')]");
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input")).size()==1);
		
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.optionalUbounded6")).size()==2);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.optionalUbounded6.removeoccurrences.img"));
		Assert.assertTrue(this.waitfor(By.xpath("//span[contains(text(),'Do you really want to delete the selected record?')]"), WAIT_TIME_MIN).isDisplayed());	   
		this.clickElementByXpath("//span[contains(text(),'Confirmation')]//ancestor::div[contains(@class,'x-window-plain x-window-dlg x-window x-component')]//button[contains(text(),'Yes')]");
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.optionalUbounded6")).size()==1);
		
	    this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.record.save.success.warning.info")), WAIT_TIME_MIN).isDisplayed());
	    this.sleepCertainTime(10000);
		
	    this.clickElementByXpath(this.getString(locator, "xpath.thirdentity.record.select.by.key", key));
		this.sleepCertainTime(6000);
		this.clickElementByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.expend.img"));
		this.sleepCertainTime(2000);
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input")).size()==1);
		Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.thirdentity.mamdatoryDetails.optionalUbounded6")).size()==1);
		
	}
	public void createThirdEntityRecordFailedImpl(String container,String modle,String entity,String key,String name,String mdM1,String mdO2,String mdOu3
			,String mdMu4,String mdO5m51,String mdO5o51,String mdOu6m61,String mdOu6o62
			,String odM1,String odO2,String odOu3,String odMu4,String odO5m51,String odO5o51,String odOu6m61,String odOu6o62){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		int recordCount = this.getTotalRecordNum();
		logger.warn("before create ,total record num is:"+recordCount);
		this.clickCreateRecord();
		this.expendAllFields();
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.key.input"), key);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.name.input"), name);
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatory1.input"), mdM1);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional2.input"), mdO2);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded3.input"), mdOu3);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.mandatoryUbounded4.input"), mdMu4);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.mandatory51.input"), mdO5m51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optional5.optional51.input"), mdO5o51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.mandatory61.input"), mdOu6m61);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.mandatoryDetails.optionalUbounded6.optional62.input"), mdOu6o62);
		
		
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.mandatory1.input"), odM1);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional2.input"), odO2);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded3.input"), odOu3);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.mandatoryUbounded4.input"), odMu4);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.mandatory51.input"), odO5m51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optional5.optional51.input"), odO5o51);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.mandatory61.input"), odOu6m61);
		this.typeTextByXpath(locator.getString("xpath.thirdentity.optionalDetails.optionalUbounded6.optional62.input"), odOu6o62);
		
		
	    this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.thirdentity.create.notinputallfieldsrequired.warning.info")), WAIT_TIME_MIN).isDisplayed());
	    this.clickElementByXpath(locator.getString("xpath.thirdentity.create.notinputallfieldsrequired.warning.ok.button"));
	    this.sleepCertainTime(5000);
	    int recordCountAfter = this.getTotalRecordNum();
		logger.warn("after create ,total record num is:"+recordCountAfter);
		Assert.assertTrue(recordCountAfter-recordCount==0);
		
	}
	
	
	
}
