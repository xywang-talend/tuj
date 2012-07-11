package org.talend.mdm.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;

public class SocieteClienteImpl extends Record{
	public SocieteClienteImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	private void clickTabContrats(){
		
		this.clickElementByXpath(locator.getString("xpath.SocieteCliente.tab.contrats"));
		this.sleepCertainTime(5000);
	}
	public void folersOpenCloseSynchronizedInDataChangesViewerImpl(String container,String modle,String entity,String entityName,String keyName,String keyValue){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		
		//make a change to a record first
	    this.chooseRcord(entityName, keyName, keyValue);
	    this.sleepCertainTime(5000);
	    String commentBefore = this.getValueInput(By.xpath(locator.getString("xpath.SocieteCliente.create.commentaires.input")));
	    logger.warn("before update,record "+keyValue +" commenttaires:"+commentBefore);
	    this.typeTextByXpath(locator.getString("xpath.SocieteCliente.create.commentaires.input"), "comment"+keyValue);
	    this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	    this.sleepCertainTime(10000);
	    this.chooseRcord(entityName, keyName, keyValue);
	    this.sleepCertainTime(5000);
	    String commentafter = this.getValueInput(By.xpath(locator.getString("xpath.SocieteCliente.create.commentaires.input")));
	    logger.warn("after update,record "+keyValue +" commenttaires:"+commentafter);
	    Assert.assertNotSame(commentBefore, commentafter);
	   
	    //open journal ,open the related update entry for this record,and jump into data changes viewer
	    String OperationType = "UPDATE";
	    String source = "genericUI";
	    this.openJournal(entityName, keyValue, OperationType, source);
	    this.sleepCertainTime(5000);
	    this.doubleClick(this.chooseLatestRecordInJournal());
	    this.sleepCertainTime(10000);
	    
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.SocieteCliente.datachangesviewer.before.img.plus.beforeSocieteCliente")), WAIT_TIME_MIN).isDisplayed());
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.SocieteCliente.datachangesviewer.after.img.plus.beforeSocieteCliente")), WAIT_TIME_MIN).isDisplayed());
	    this.clickElementByXpath(locator.getString("xpath.SocieteCliente.datachangesviewer.before.img.plus.beforeSocieteCliente"));
	    this.sleepCertainTime(3000);
	    Assert.assertFalse(this.waitfor(By.xpath(locator.getString("xpath.SocieteCliente.datachangesviewer.before.img.plus.beforeSocieteCliente")), 10)!=null);
	    Assert.assertFalse(this.waitfor(By.xpath(locator.getString("xpath.SocieteCliente.datachangesviewer.after.img.plus.beforeSocieteCliente")), 10)!=null);
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.SocieteCliente.datachangesviewer.before.img.plus.beforecontrats")), 10).isDisplayed());
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.SocieteCliente.datachangesviewer.after.img.plus.beforecontrats")), 10).isDisplayed());
	    this.clickElementByXpath(locator.getString("xpath.SocieteCliente.datachangesviewer.before.img.plus.beforecontrats"));
	    Assert.assertFalse(this.waitfor(By.xpath(locator.getString("xpath.SocieteCliente.datachangesviewer.before.img.plus.beforecontrats")), 10)!=null);
	    Assert.assertFalse(this.waitfor(By.xpath(locator.getString("xpath.SocieteCliente.datachangesviewer.after.img.plus.beforecontrats")), 10)!=null);
	    Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.SocieteCliente.datachangesviewer.after.contrats")).size()>0);
	    Assert.assertTrue(this.getElementsByXpath(locator.getString("xpath.SocieteCliente.datachangesviewer.before.contrats")).size()>0);
	}
	public void browseSocieteClienteRecordWithFKContrats(String container,String modle,String entity,String entityName,String keyName,String keyValue,String numeroContrat,String numeroContratExterne){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
	    
		this.searchCondition(keyName, "is equal to", keyValue);
	    this.chooseRcord(entityName, keyName, keyValue);
	    this.sleepCertainTime(5000);
	    this.clickTabContrats();
	    
	    Assert.assertTrue(this.waitfor(By.xpath(this.getString(locator, "xpath.SocieteCliente.tab.clicked.associated.contrats.row", numeroContrat)), WAIT_TIME_MIN).isDisplayed());
	    this.clickElementByXpath(this.getString(locator, "xpath.SocieteCliente.tab.clicked.associated.contrats.row", numeroContrat));
	    this.clickElementByXpath(this.getString(locator, "xpath.SocieteCliente.tab.clicked.associated.contrats.row.openrecord.greenimage", numeroContrat));
	    this.sleepCertainTime(10000);
	    Assert.assertTrue(this.waitfor(By.xpath("//div[@id='ItemsDetailPanel-textTitle' and contains(text(),'Contrat')]"), WAIT_TIME_MIN).isDisplayed());
	    Assert.assertTrue(this.getValueInput(By.xpath("//input[@name='Contrat/numeroContrat']")).equals(numeroContrat));
	    Assert.assertTrue(this.getValueInput(By.xpath("//input[@name='Contrat/numeroContratExterne']")).equals(numeroContratExterne));
	  
	}
	
}
