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

	public void deleteRecordImpl(String container,String modle,String entity,String IdValue){
		OperationType="PHYSICAL_DELETE";
		source="genericUI";
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.record.click.lastpage"));
		chooseRcord(entity,"id",IdValue);			
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,IdValue,OperationType,source);
	    JournalResultCount();
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
	

}
