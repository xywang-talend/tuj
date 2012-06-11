package org.talend.mdm.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;

public class RecordImplDataTypes extends Record{
	 String OperationType,key,source;
	 boolean result;
  
	public RecordImplDataTypes(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void deleteRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue){
		OperationType="PHYSICAL_DELETE";
		source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
		chooseRcord(entity,Identifie,IdentifieValue);			
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,IdentifieValue,OperationType,source);
	    JournalResultCount();
	}
	
	public void duplicateRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue,String IdentifieValueDup ) {
		String[] parametersID={entity,Identifie};	
		String[] parametersIDclose={entity,IdentifieValue};	
		String[] parametersIDAssert={entity,Identifie,IdentifieValueDup};
		String[] parametersIDValueAssert={Identifie,IdentifieValueDup};
		OperationType="CREATE";
	    source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		this.sleepCertainTime(10000);
		this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
		this.sleepCertainTime(10000);
		chooseRcord(entity,Identifie,IdentifieValue);
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));	
		this.clickElementByXpath(this.getString(locator,"xpath.record.Duplicate.close.origin",parametersIDclose));
		this.sleepCertainTime(10000);
		this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersID)), IdentifieValueDup);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		this.sleepCertainTime(10000);
//		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersIDAssert)), WAIT_TIME_MAX),"duplicateARecord");
		this.sleepCertainTime(3000); 
		openJournal(entity,IdentifieValueDup,OperationType,source);
		this.sleepCertainTime(3000); 
		JournalCheckResult(IdentifieValueDup,OperationType);
		this.sleepCertainTime(5000);		
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.ceate.jouranl",parametersIDValueAssert )), WAIT_TIME_MIN));
		
	}	
	
	public void createRecordAllFieldImpl(String container,String modle,String entity,String IdValue) {
	        OperationType="CREATE";
	        source="genericUI";
			chooseContainer(container);	
			chooseModle(modle);
			clickSave();
			chooseEntity(entity);
			this.sleepCertainTime(3000);
			this.clickCreateRecord();			
			this.sleepCertainTime(3000);
			
			this.clickElementByXpath("//input[@name='DataTypesTest/boolean2']");
		  this.typeTextByName("DataTypesTest/date2", "2012-05-06");
		  this.typeTextByName("DataTypesTest/string2", "test");
		  this.typeTextByName("DataTypesTest/integer2", "15");
		  this.typeTextByName("DataTypesTest/datetime2", "2012-05-03T13:14:16");
		  this.typeTextByName("DataTypesTest/decimal2", "3.6");
		  this.typeTextByName("DataTypesTest/float2", "3.2");
		  this.typeTextByName("DataTypesTest/double2", "3.9");
		  this.typeTextByName("DataTypesTest/ID1", "a");
		  this.typeTextByName("DataTypesTest/base64Binary1", "#x20?");
		  this.typeTextByName("DataTypesTest/gDay1", "---03");
		  this.typeTextByName("DataTypesTest/gMonth1", "--05");
		  this.typeTextByName("DataTypesTest/gMonthDay1", "--03-03");
		  this.typeTextByName("DataTypesTest/gYear1", "2012");		  
		  this.typeTextByName("DataTypesTest/gYearMonth1", "2012-01");
		  this.typeTextByName("DataTypesTest/hexBinary1", "5F");
		  this.typeTextByName("DataTypesTest/int1", "0");
		  this.typeTextByName("DataTypesTest/language1", "zh");
		  this.typeTextByName("DataTypesTest/negativeInteger1", "-1");
		  this.typeTextByName("DataTypesTest/long1", "0");
		  this.typeTextByName("DataTypesTest/nonNegativeInteger1", "1");
		  this.typeTextByName("DataTypesTest/nonPositiveInteger1", "-1");
		  this.typeTextByName("DataTypesTest/normalizedString1", "1");
		  this.typeTextByName("DataTypesTest/positiveInteger1", "1");
		  this.typeTextByName("DataTypesTest/short1", "0");
		  this.typeTextByName("DataTypesTest/token1", "1");
		  this.typeTextByName("DataTypesTest/unsignedByte1", "1");
		  this.typeTextByName("DataTypesTest/unsignedInt1", "1");
		  this.typeTextByName("DataTypesTest/unsignedLong1", "1");
		  this.typeTextByName("DataTypesTest/unsignedShort1", "1");
		  this.typeTextByName("DataTypesTest/duration1", "P1Y2M3DT10H30M");
		  this.typeTextByName("DataTypesTest/byte1", "1");
		  this.typeTextByName("DataTypesTest/IDREF1", "a");
		  this.typeTextByName("DataTypesTest/IDREFS1", "a");
		  this.typeTextByName("DataTypesTest/QName1", "d");
		  this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
		  this.sleepCertainTime(10000);
		  
		  chooseRcord(entity,"id",IdValue);
	  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/date2")), "2012-05-06");		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/string2")),  "test");
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/integer2")), "15");
		  
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/datetime2")), "2012-05-03T13:14:16");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/decimal2")), "3.6");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/float2")), "3.2");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/double2")), "3.9");
	
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/ID1")), "a");

		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/base64Binary1")), "#x20?");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/gDay1")), "---03");
	
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/gMonth1")), "--05");
		 
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/gMonthDay1")), "--03-03");
		 
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/gYear1")), "2012");
		  
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/gYearMonth1")), "2012-01");
		 
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/hexBinary1")), "5F");
	
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/int1")), "0");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/language1")), "zh");

		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/negativeInteger1")), "-1");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/long1")), "0");
		 
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/nonNegativeInteger1")), "1");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/nonPositiveInteger1")), "-1");
		 
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/normalizedString1")), "1");
	
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/positiveInteger1")), "1");
		 
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/short1")), "0");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/token1")), "1");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/unsignedByte1")), "1");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/unsignedInt1")), "1");
		 
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/unsignedLong1")), "1");
		 
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/unsignedShort1")), "1");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/duration1")), "P1Y2M3DT10H30M");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/byte1")), "1");
		
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/IDREF1")), "a");
	
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/IDREFS1")), "a");
	
		  Assert.assertEquals(this.getValueInput(By.name("DataTypesTest/QName1")), "d");
		 
		  openJournal(entity,IdValue,OperationType,source);
		    JournalResultCount();
}
	public void createRecordSomeFieldImpl(String container,String modle,String entity) {
        OperationType="CREATE";
        source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		this.sleepCertainTime(3000);
		this.clickCreateRecord();			
		this.sleepCertainTime(3000);
		
		this.clickElementByXpath("//input[@name='DataTypesTest/boolean2']");
	  this.typeTextByName("DataTypesTest/date2", "2012-05-06");
	  this.typeTextByName("DataTypesTest/string2", "test");
	  this.typeTextByName("DataTypesTest/integer2", "15");
	  this.typeTextByName("DataTypesTest/datetime2", "2012-05-03T13:14:16");
	  this.typeTextByName("DataTypesTest/decimal2", "3.6");
	  this.typeTextByName("DataTypesTest/float2", "3.2");
	  this.typeTextByName("DataTypesTest/double2", "3.9");
	  this.typeTextByName("DataTypesTest/ID1", "a");
	  this.typeTextByName("DataTypesTest/base64Binary1", "#x20?");
	  this.typeTextByName("DataTypesTest/gDay1", "---03");
	  this.typeTextByName("DataTypesTest/gMonth1", "--05");
	  this.typeTextByName("DataTypesTest/gMonthDay1", "--03-03");
	  this.typeTextByName("DataTypesTest/gYear1", "2012");		  
	  this.typeTextByName("DataTypesTest/gYearMonth1", "2012-01");
	  this.typeTextByName("DataTypesTest/hexBinary1", "5F");
	  this.typeTextByName("DataTypesTest/int1", "0");
	  this.typeTextByName("DataTypesTest/language1", "zh");
	  this.typeTextByName("DataTypesTest/negativeInteger1", "-1");
	  this.typeTextByName("DataTypesTest/long1", "0");
	  this.typeTextByName("DataTypesTest/nonNegativeInteger1", "1");
	  this.typeTextByName("DataTypesTest/nonPositiveInteger1", "-1");
	  this.typeTextByName("DataTypesTest/normalizedString1", "1");
	  this.typeTextByName("DataTypesTest/positiveInteger1", "1");
	  this.typeTextByName("DataTypesTest/short1", "0");
	  this.typeTextByName("DataTypesTest/token1", "1");
	  this.typeTextByName("DataTypesTest/unsignedByte1", "1");
	  this.typeTextByName("DataTypesTest/unsignedInt1", "1");
	  this.typeTextByName("DataTypesTest/unsignedLong1", "1");
	  this.typeTextByName("DataTypesTest/unsignedShort1", "1");
	  this.typeTextByName("DataTypesTest/duration1", "P1Y2M3DT10H30M");
	  this.typeTextByName("DataTypesTest/byte1", "1");
	  this.typeTextByName("DataTypesTest/IDREF1", "a");
	  this.typeTextByName("DataTypesTest/IDREFS1", "a");
	  //not input the last field
	//  this.typeTextByName("DataTypesTest/QName1", "d");
	  this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	  this.sleepCertainTime(2000);
	  Assert.assertTrue(this.isElementPresent(By.xpath("//span[contains(text(),'Unable to save item DataTypesTest., Unable to create/update the item')]"), WAIT_TIME_MIN));
 	 
	
}
	
	public void updateRecordImpl(String container,String modle,String entity,String Identifie,String IdentifieValue ,String Zipcode,String ZipcodeValue) {
		String city,state,region,moreinfo;
		String cityOld,stateOld,regionOld,moreinfoOld;
		String[] parametersZip={entity,Zipcode};	
		OperationType="UPDATE";
	    source="DStar_EnrichAgencyLocation";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
		//get the old value
		chooseRcord(entity,Identifie,IdentifieValue);
		this.sleepCertainTime(3000);
		cityOld=this.getValueInput(By.xpath("//input[@name='Agency/City']"));
		stateOld=this.getValueInput(By.xpath("//input[@name='Agency/State']"));
		regionOld=this.getValueInput(By.xpath("//input[@name='Agency/Region']"));
		this.sleepCertainTime(3000);
		this.clickElementByXpath("//a[text()='Map']//following-sibling::img");
		moreinfoOld=this.getValueInput(By.xpath("//label[text()='Url:']//following-sibling::div//div//input"));	
		this.clickElementByXpath("//button[text()='Cancel']");	
		this.sleepCertainTime(5000);
		this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersZip)), ZipcodeValue);
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
		this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));			
		//get the value after update
		this.sleepCertainTime(5000);
		chooseRcord(entity,Identifie,IdentifieValue);
		this.sleepCertainTime(5000);
		city=this.getValueInput(By.xpath("//input[@name='Agency/City']"));
		state=this.getValueInput(By.xpath("//input[@name='Agency/State']"));
		region=this.getValueInput(By.xpath("//input[@name='Agency/Region']"));
		this.sleepCertainTime(3000);
		this.clickElementByXpath("//a[text()='Map']//following-sibling::img");
		this.sleepCertainTime(3000);
		moreinfo=this.getValueInput(By.xpath("//label[text()='Url:']//following-sibling::div//div//input"));	
		this.clickElementByXpath("//button[text()='Cancel']");	
		//assert in the journal
	    this.sleepCertainTime(3000);
	    openJournal(entity,IdentifieValue,OperationType,source);
	    this.sleepCertainTime(5000);
	    JournalCheckResult(IdentifieValue,OperationType);
		this.sleepCertainTime(5000); 		 
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.city", cityOld)), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.State", stateOld)), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.Region",regionOld)), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.MoreInfo",moreinfoOld)), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.city", city)), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.State", state)), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.Region",region)), WAIT_TIME_MIN));
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.ceate.MoreInfo",moreinfo)), WAIT_TIME_MIN));
	}
}
