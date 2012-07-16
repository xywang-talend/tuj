package org.talend.mdm.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void searchContratRecordByXpathExpressionWithAttribute(String container,String modle,String entity,String entityName,String keyName,String keyValue){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
	    
		this.searchCondition(keyName, "is equal to", keyValue);
		this.sleepCertainTime(5000);
		int N = this.getTotalRecordNum();
		logger.warn("bases on search condition ,totally record number is:"+N);
		boolean results = true;
		List<WebElement> a = this.getElementsByXpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Contrat/detailContrat/@xsi:type')]");
		Assert.assertTrue(N==a.size());
		for(int i = 0; i < N -1; i++){
			if(this.getValue(a.get(i)).equals(keyValue)){
				results = true;
			}
			else{
				results = false;
				break;
			}
		}
		Assert.assertTrue(results);
	    }
	
	public void browseContratRecordInFrench(String container,String modle,String entity,String entityName,String keyName,String keyValue,String numeroContratExterne,String language,String languageDefault,String searchOperator){
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
	    
		this.searchCondition(keyName, searchOperator, keyValue);
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
