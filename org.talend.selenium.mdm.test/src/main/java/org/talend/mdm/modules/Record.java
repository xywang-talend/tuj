package org.talend.mdm.modules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.Base;
import org.testng.Assert;


public class Record extends Base{
	
	public Record(WebDriver driver) {
		super.setDriver(driver);
		this.driver = driver;
	}
public void createRecord(String container,String modle,String entity,String subelement,String name,String age) {
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 
	this.waitforElementDisplayed(By.xpath(locator.getString("xpath.record.choose.create.input.subelement")), WAIT_TIME_MAX);
	this.typeTextByXpath(locator.getString("xpath.record.choose.create.input.subelement"), subelement);
	this.typeTextByXpath(locator.getString("xpath.record.choose.create.input.name"), name);
	this.typeTextByXpath(locator.getString("xpath.record.choose.create.input.age"), age);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.create.record.assert",subelement)), WAIT_TIME_MAX),"createARecord");
 }
public void updateRecord(String container,String modle,String entity,String subelement,String name,String age) {
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	chooseRcord(subelement);	
	Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.choose.create.input.name")), 3000));
	this.modifyText(this.getElementByXpath(locator.getString("xpath.record.choose.create.input.name")), name);
	this.modifyText(this.getElementByXpath(locator.getString("xpath.record.choose.create.input.age")), age);
	//this.typeTextByXpath(locator.getString("xpath.record.choose.create.input.age"), age);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
	this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));
	logger.info(this.getString(locator, "xpath.record.choose.create.record.assert",name));
	//Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.create.record.assert",name)), WAIT_TIME_MAX),"updateARecord");
 }

public void deleteRecord(String container,String modle,String entity,String subelement) {
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);
	chooseRcord(subelement);	
//	System.out.println(this.getElementsByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)).size());
	
	this.clickElementByXpath(locator.getString("xpath.record.delete.record")); 
	this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose")); 	 
	this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose.yes")); 
//System.out.println(this.getElementsByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)).size());
//	Assert.assertFalse(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)), WAIT_TIME_MAX),"deletefalse");

//	System.out.println(this.getElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)).getText()+"--------");
//	logger.info(this.getElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)).getText()+"==============");
	
	/*try {
		Thread.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));
	//Assert.assertNull(this.getElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)), "----------------------------------");
	
}
public void chooseContainer(String container) {	
	 this.clickElementByXpath(locator.getString("xpath.record.choose.containe.arrows"));
	 this.clickElementByXpath(this.getString(locator, "xpath.record.choose.container", container)); 	
	 
    }
public void chooseModle(String modle) {	
	 this.clickElementByXpath(locator.getString("xpath.record.choose.modle.arrows"));
	 this.clickElementByXpath(this.getString(locator, "xpath.record.choose.modle",modle));
   }
public void clickSave() {	
	this.clickElementByXpath(locator.getString("xpath.record.chooseCM.save"));
	this.clickElementByXpath(locator.getString("xpath.record.chooseCM.save.ok"));
  }

public void chooseEntity(String entity) { 
	  this.clickElementByXpath(locator.getString("xpath.record.click.DataBrowser"));
	  this.clickElementByXpath(locator.getString("xpath.record.choose.entity.arrows"));	 
	  this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.entity",entity)), WAIT_TIME_MAX);
	  this.clickElementByXpath(this.getString(locator, "xpath.record.choose.entity",entity));
}      

public void chooseRcord(String subelement) {
	 this.clickElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement));
	 }

}