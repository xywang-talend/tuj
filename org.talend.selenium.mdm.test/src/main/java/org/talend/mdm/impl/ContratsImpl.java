package org.talend.mdm.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;

public class ContratsImpl extends Record{
	public ContratsImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void browseContratRecordBySearch(String container,String modle,String entity,String entityName,String keyName,String keyValue,String numeroContratExterne){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
	    
		this.searchCondition(keyName, "is equal to", keyValue);
	    this.chooseRcord(entityName, keyName, keyValue);
	    this.sleepCertainTime(5000);
	    Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.Contrats.create.numeroContrat.input"))).equals(keyValue));
	    Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.Contrats.create.numeroContratExterne.input"))).equals(numeroContratExterne));
	    Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.Contrats.create.numeroContrat.input")).isEnabled());
	}
	
	public void browseContratRecordInFrench(String container,String modle,String entity,String entityName,String keyName,String keyValue,String numeroContratExterne,String language,String languageDefault){
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.language.selection")), WAIT_TIME_MIN).isDisplayed());
		this.setLanguage(language);
		this.locator=this.locatorfr;
		this.sleepCertainTime(5000);
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
	    
		this.searchCondition(keyName, "est égal à", keyValue);
	    this.chooseRcord(entityName, "numeroContrat", keyValue);
	    this.sleepCertainTime(5000);
	    Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.Contrats.create.numeroContrat.input"))).equals(keyValue));
	    Assert.assertTrue(this.getValueInput(By.xpath(locator.getString("xpath.Contrats.create.numeroContratExterne.input"))).equals(numeroContratExterne));
	    Assert.assertFalse(this.getElementByXpath(locator.getString("xpath.Contrats.create.numeroContrat.input")).isEnabled());
	    this.setLanguage(languageDefault);
	    this.locator=this.locatoren;
	    this.sleepCertainTime(5000);
	    
	}
}
