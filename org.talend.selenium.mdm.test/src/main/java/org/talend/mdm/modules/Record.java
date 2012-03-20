package org.talend.mdm.modules;
import static org.junit.Assert.assertTrue;

import java.util.Enumeration;

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
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.subelement",subelement)), WAIT_TIME_MAX),"createARecord");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.name",name)), WAIT_TIME_MAX),"createARecord");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.age",age)), WAIT_TIME_MAX),"createARecord");
     
}
public void updateRecord(String container,String modle,String entity,String subelement,String name,String age) {
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	chooseRcord(subelement);	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.choose.create.input.name")), 3000));
	this.modifyText(this.getElementByXpath(locator.getString("xpath.record.choose.create.input.name")), name);
	this.modifyText(this.getElementByXpath(locator.getString("xpath.record.choose.create.input.age")), age);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
	this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.name",name)), WAIT_TIME_MAX),"updateARecord");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.age",age)), WAIT_TIME_MAX),"createARecord");
}

public void deleteRecord(String container,String modle,String entity,String subelement) {
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);
	chooseRcord(subelement);		
	this.clickElementByXpath(locator.getString("xpath.record.delete.record")); 
	this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose")); 	 
	this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose.yes")); 
//System.out.println(this.getElementsByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)).size());
//	Assert.assertFalse(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)), WAIT_TIME_MAX),"deletefalse");

//	System.out.println(this.getElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)).getText()+"--------");
//	logger.info(this.getElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)).getText()+"==============");
/*	
	try {
		Thread.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));
	Assert.assertNull(this.getElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",subelement)), "delete record");*/
}

public void searchRecordByValue(String container,String modle,String entity,String searchFeild,String opeartion,String value) {

	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	searchCondition(searchFeild,opeartion,value);
	searchAssert(opeartion,value);
}
public void searchAssert(String opeartion,String value){
	int recordCount;
	int[] ages;	
	boolean result = false;		
	recordCount=Integer.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().substring(9));
	ages = new int[recordCount];
	for (int i=0; i<recordCount; i++)
  {
	   ages[i]=Integer.parseInt(this.getElementsByXpath(locator.getString("xpath.record.search.record.value")).get(i).getText());
	   logger.info(opeartion);
	   if (opeartion.contains("is greater than"))
	{
	   if (Integer.parseInt(value) < ages[i])
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }

	if (opeartion.contains("is equal to"))
	{
	   if (Integer.parseInt(value) == ages[i])
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }

	if (opeartion.contains("is greater or equals"))
	{
	   if (Integer.parseInt(value) <= ages[i])
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }

	if (opeartion.contains("is lower than"))
	{
	   if (Integer.parseInt(value) > ages[i])
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }

	if (opeartion.contains("is lower or equals"))
	{
	   if ( ages[i] <= Integer.parseInt(value))
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }	

		if (opeartion.contains("is not equal to"))
		{
		   if ( ages[i] != Integer.parseInt(value))
		     {
			    result=true;
		      }
		    else
			    result=false;
			
		  }

	}
	
	 Assert.assertTrue(result);	
	
}
public void searchCondition(String searchFeild,String opeartion,String value) {	
	searchFeild(searchFeild);
	searchOpeartion(opeartion);
	searchValue(value);	
	//click the search button	
	this.clickElementByXpath(locator.getString("xpath.record.search.click"));	 
   }

public void searchFeild(String searchFeild){
	//choose the search feild
	this.clickElementByXpath(locator.getString("xpath.record.search.feild.arrows"));
	this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.search.feild",searchFeild)), WAIT_TIME_MAX);
	this.clickElementByXpath(this.getString(locator, "xpath.record.search.feild",searchFeild));	
}

public void searchOpeartion(String opeartion){
	//choose the search operator		
	this.clickElementByXpath(locator.getString("xpath.record.search.operator.arrows"));		
	this.isElementPresent(By.xpath(this.getString(locator,"xpath.record.search.operator",opeartion)), WAIT_TIME_MAX);
	this.clickElementByXpath(this.getString(locator,"xpath.record.search.operator",opeartion));
}

public void searchValue(String value){
	//input the search value
	this.modifyText(this.getElementByXpath(locator.getString("xpath.record.search.value")), value);
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