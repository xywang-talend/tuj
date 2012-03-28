package org.talend.mdm.modules;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public void createRecord(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name) {
	String[] parametersFeild1={entity,feild1Name};
	String[] parametersFeild2={entity,feild2Name};
	String[] parametersFeild3={entity,feild3Name};
	String[] parametersFeild1Assert={entity,feild1Name,feild1Value};
	String[] parametersFeild2Assert={entity,feild2Name,feild2Value};
	String[] parametersFeild3Assert={entity,feild3Name,feild3Value};	
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	this.clickElementByXpath(locator.getString("xpath.record.choose.create")); 	
	this.waitforElementDisplayed(By.xpath(this.getString(locator, "xpath.record.choose.create.input.feild1",parametersFeild1)), WAIT_TIME_MAX);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild1",parametersFeild1), feild1Value);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2), feild2Value);
	this.typeTextByXpath(this.getString(locator, "xpath.record.choose.create.input.feild3",parametersFeild3), feild3Value);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild1",parametersFeild1Assert)), WAIT_TIME_MAX),"createARecord");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"createARecord");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild3",parametersFeild3Assert)), WAIT_TIME_MAX),"createARecord");
     
}
public void updateRecord(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name) {
	String[] parametersFeild2={entity,feild2Name};
	String[] parametersFeild3={entity,feild3Name};
	String[] parametersFeild2Assert={entity,feild2Name,feild2Value};
	String[] parametersFeild3Assert={entity,feild3Name,feild3Value};
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	chooseRcord(entity,feild1Name,feild1Value);	
	this.sleepCertainTime(5000);
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), 3000));
	this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), feild2Value);
	this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild3",parametersFeild3)), feild3Value);
	this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));	
	if (this.isTextPresent("No change since last save")){
		this.clickElementByXpath("//button[text()='Ok']");		
	}
	else 
	{
	this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"updateARecord");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild3",parametersFeild3Assert)), WAIT_TIME_MAX),"updateARecord");
   }
}
public void duplicateRecord(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name,String feild1UpdateValue) {
	String[] parametersFeild1={entity,feild1Name};	
	String[] parametersFeild2={entity,feild2Name};
	String[] parametersFeild3={entity,feild3Name};
	String[] parametersFeild1Assert={entity,feild1Name,feild1UpdateValue};
	String[] parametersFeild2Assert={entity,feild2Name,feild2Value};
	String[] parametersFeild3Assert={entity,feild3Name,feild3Value};	
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	chooseRcord(entity,feild1Name,feild1Value);		
	this.sleepCertainTime(5000);
	this.clickElementByXpath(locator.getString("xpath.record.Duplicate.click"));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFeild1)), WAIT_TIME_MAX),"duplicateARecord");
	this.clickElementByXpath(locator.getString("xpath.record.Duplicate.close.origin"));	
	this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.Duplicate.input",parametersFeild1)), feild1UpdateValue);
	this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild2",parametersFeild2)), feild2Value);
	this.modifyText(this.getElementByXpath(this.getString(locator, "xpath.record.choose.create.input.feild3",parametersFeild3)), feild3Value);
	
	this.clickElementByXpath(locator.getString("xpath.record.Duplicate.saveAndClose"));	
	this.clickElementByXpath(locator.getString("xpath.record.click.refresh"));	
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild1",parametersFeild1Assert)), WAIT_TIME_MAX),"duplicateARecord");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild2",parametersFeild2Assert)), WAIT_TIME_MAX),"createARecord");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.record.assert.feild3",parametersFeild3Assert)), WAIT_TIME_MAX),"createARecord");
}


public void deleteRecord(String container,String modle,String entity,String feild1Value,String feild1Name) {
	
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);
	chooseRcord(entity,feild1Name,feild1Value);	
    this.sleepCertainTime(5000);
    deleteTheRecord(entity);
/*	logger.info(this.getString(locator, "xpath.record.delete.record",entity));
	this.clickElementByXpath(this.getString(locator, "xpath.record.delete.record",entity)); 
	this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose")); 	 
	this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose.yes")); 	
			if (this.isElementPresent(By.xpath(locator.getString("xpath.record.delete.record.warn")),WAIT_TIME_MIN)){
				this.clickElementByXpath("//button[text()='No']");		
			}*/
}
public void deleteTheRecord(String  entity){ 
	
logger.info(this.getString(locator, "xpath.record.delete.record",entity));
this.clickElementByXpath(this.getString(locator, "xpath.record.delete.record",entity)); 
this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose")); 	 
this.clickElementByXpath(locator.getString("xpath.record.delete.record.choose.yes")); 	
		if (this.isElementPresent(By.xpath(locator.getString("xpath.record.delete.record.warn")),WAIT_TIME_MIN)){
			this.clickElementByXpath("//button[text()='No']");		
		}
}
public void JournalOpenRecord(String container,String modle,String entity,String feild1Value,String feild1Name) {
	String[] parameters={entity,feild1Value};
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	//click the journal
	clickJournal();
	//input the search condition
	this.typeTextByXpath(locator.getString("xpath.record.choose.journal.entity"), entity);
	this.typeTextByXpath(locator.getString("xpath.record.choose.journal.key"), feild1Value);
	this.clickElementByXpath(locator.getString("xpath.record.choose.journal.operation.arrows")); 
	this.clickElementByXpath(locator.getString("xpath.record.choose.journal.operation.choose")); 
	logger.info(locator.getString("xpath.record.choose.journal.search"));
	this.sleepCertainTime(5000);
	this.clickElementByXpath(locator.getString("xpath.record.choose.journal.search")); 
	this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.journal.choose.record", feild1Value)), WAIT_TIME_MIN);
	this.doubleClick(this.getElementByXpath(this.getString(locator, "xpath.record.choose.journal.choose.record", feild1Value)));
	this.isElementPresent(By.xpath("//button[text()='Open Record']"), WAIT_TIME_MIN);
	this.clickElementByXpath("//button[text()='Open Record']");
	//assert can see the record detail	
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.journal.assert.open",parameters)), WAIT_TIME_MIN),"open detail");
  }

public void restoreFromRecycle(String container,String modle,String entity,String feild1Value,String feild1Name) {
	String[] parameters={entity,feild1Name,feild1Value};
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	clickRecycle();
	this.clickElementByXpath(this.getString(locator,"xpath.record.recycle.click.record.restore",feild1Value));
	this.clickElementByXpath(locator.getString("xpath.record.recycle.click.record.restore.yes"));
	 if (this.isElementPresent(By.xpath("//span[contains(text(),'Please input all necessary search ')]"),WAIT_TIME_MIN)){
		 this.clickElementByXpath("//button[text()='Ok']");}
	//assert the record restore in the entity		
	this.clickElementByXpath(locator.getString("xpath.record.click.databrowser"));	 
	this.clickElementByXpath(locator.getString("xpath.record.choose.entity.arrows"));
	
	this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.entity",entity)), WAIT_TIME_MIN);
	this.clickElementByXpath(this.getString(locator, "xpath.record.choose.entity",entity));   
	this.sleepCertainTime(5000);
	//this.clickElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",parameters));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.choose.delete.record",parameters)), WAIT_TIME_MIN),"the record restore in the entity");
	chooseRcord(entity,feild1Name,feild1Value);
	this.sleepCertainTime(5000);
	deleteTheRecord(entity);
}



public void deleteRecordToRecycle(String container,String modle,String entity,String feild1Value,String feild1Name) {
	String[] parameters_container={feild1Value,container};
	String[] parameters_modle={feild1Value,modle};
	String[] parameters_entity={feild1Value,entity};
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);
	chooseRcord(entity,feild1Name,feild1Value);	
	this.sleepCertainTime(5000);
	logger.info(this.getString(locator, "xpath.record.delete.record",entity));
	this.clickElementByXpath(this.getString(locator, "xpath.record.delete.record",entity)); 
	this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.choose")); 	 
	this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.choose.ok")); 	
			if (this.isElementPresent(By.xpath(locator.getString("xpath.record.delete.record.warn")),WAIT_TIME_MIN)){
				this.clickElementByXpath("//button[text()='No']");		
			}
	// assert the record which been deleted in the recycle
	clickRecycle();	
	//this.clickElementByXpath(locator.getString("xpath.record.delete.record.to.recycle.assert.clickRefresh")); 
	logger.info(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.container",parameters_container));
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.container",parameters_container)), WAIT_TIME_MIN ),"container");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.modle",parameters_modle)), WAIT_TIME_MIN ),"modle");
	Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.entity",parameters_entity)), WAIT_TIME_MIN ),"entity");
}

public void searchRecordByValue(String container,String modle,String entity,String searchFeild,String opeartion,String value) {
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	searchCondition(searchFeild,opeartion,value);
	searchValueAssert(searchFeild,opeartion,value,entity);
}

public void searchRecordByDate(String container,String modle,String entity,String searchFeild,String opeartion,String value) {
	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	searchCondition(searchFeild,opeartion,value);
	searchDateAssert(searchFeild,opeartion,value,entity);
}

public void searchDateAssert(String searchFeild,String opeartion,String value,String entity){
	String[] parametersSearch={entity,searchFeild};
	int recordCount;
	Date[] dates;
	Date searchDate = null;
	boolean result = false;	
	String recordSearchResult;
	logger.info(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText());
	recordSearchResult=this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText();
	if (recordSearchResult.contains("No data to display"))
	{
		recordCount=0;	
		logger.info("No data to display");
		result = true;
	}
	else
	{
	recordCount=Integer.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().split("of")[1].trim());
	logger.info(recordCount);
	dates = new Date[recordCount];
	try {
		searchDate=new SimpleDateFormat("yyyy-MM-dd").parse(value);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for (int i=0; i<=recordCount-1; i++)
  {  String dates_text=this.getElementsByXpath(this.getString(locator, "xpath.record.search.record.value",parametersSearch)).get(i).getText();
	 if( !dates_text.equals(" ")){  
		 try {
			dates[i]= (new SimpleDateFormat("yyyy-MM-dd")).parse(this.getElementsByXpath(this.getString(locator, "xpath.record.search.record.value",parametersSearch)).get(i).getText());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	   logger.info("$$$$$$$"+dates[i]);
	   logger.info("$$$$$$$"+value);
	    if (opeartion.contains("equals"))
	    {
	      if (dates[i].equals(searchDate))
	       {
		    result=true;
	       	}
	      else
		    result=false;
		
	    }

	if (opeartion.contains("is before"))
	{
	   if (dates[i].before(searchDate) )
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }

	if (opeartion.contains("is after"))
	{
	   if (dates[i].after(searchDate))
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }
	}
}
	
	}
	Assert.assertTrue(result); 	
	
}
public void searchRecordByString(String container,String modle,String entity,String searchFeild,String opeartion,String value) {

	chooseContainer(container);	
	chooseModle(modle);
	clickSave();
	chooseEntity(entity);	
	searchCondition(searchFeild,opeartion,value);
	searchStringAssert(searchFeild,opeartion,value,entity);
}


public void searchStringAssert(String searchFeild,String opeartion,String value,String entity){
	String[] parametersSearch={entity,searchFeild};
	int recordCount;
	String[] names;
	boolean result = false;	
	String recordSearchResult;
	logger.info(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText());
	recordSearchResult=this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText();
	if (recordSearchResult.contains("No data to display"))
	{
		recordCount=0;	
		logger.info("No data to display");
		result = true;
	}
	else
	{
	recordCount=Integer.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().split("of")[1].trim());
	logger.info(recordCount);
	names = new String[recordCount];
	for (int i=0; i<=recordCount-1; i++)
  {                                              
		String names_text=this.getElementsByXpath(this.getString(locator, "xpath.record.search.record.value",parametersSearch)).get(i).getText();
	 if( !names_text.equals(" ")){          
		 names[i]=this.getElementsByXpath(this.getString(locator, "xpath.record.search.record.value",parametersSearch)).get(i).getText();
	  // logger.info("$$$$$$$4"+names[i]);
	    //logger.info("$$$$$$$4"+value);
		 if (opeartion.contains("contains the word(s)"))
	    {
	      if (names[i].contains(value) )
	       {
		    result=true;
	       	}
	      else
		    result=false;
		
	    }

	if (opeartion.contains("contains a word starting with"))
	{
	   if (names[i].contains(value) && names[i].startsWith(value) )
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }

	if (opeartion.contains("contains the sentence"))
	{
	   if (names[i].contains(value))
	     {
		    result=true;
	      }
	    else
		    result=false;
		
	  }
	}
}
	
	}
	Assert.assertTrue(result); 	
	
}
public void searchValueAssert(String searchFeild,String opeartion,String value,String entity){
	String[] parametersSearch={entity,searchFeild};
	int recordCount;
	String recordSearchResult;
	int[] ages;
	boolean result = false;
	logger.info(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText());
	recordSearchResult=this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText();
	if (recordSearchResult.contains("No data to display"))
	{
		recordCount=0;	
		logger.info("No data to display");
		result = true;
	}
	else
	{
	recordCount=Integer.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().split("of")[1].trim());
	logger.info(recordCount);
	ages = new int[recordCount];
	for (int i=0; i<=recordCount-1; i++)
  {     logger.info(entity);
        logger.info(searchFeild);
		logger.info("________"+this.getString(locator, "xpath.record.search.record.value",parametersSearch)+"%%%%%%%");         
		
		String age_text=this.getElementsByXpath(this.getString(locator, "xpath.record.search.record.value",parametersSearch)).get(i).getText();
	 if( !age_text.equals(" ")){ 
		ages[i]=Integer.parseInt(this.getElementsByXpath(this.getString(locator, "xpath.record.search.record.value",parametersSearch)).get(i).getText());
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
}}
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
	Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.search.feild.arrows")), 3000));	
	this.sleepCertainTime(5000);
	this.clickElementByXpath(locator.getString("xpath.record.search.feild.arrows"));
	this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.search.feild",searchFeild)), WAIT_TIME_MAX);
	this.clickElementByXpath(this.getString(locator, "xpath.record.search.feild",searchFeild));	
}

public void searchOpeartion(String opeartion){	
	//choose the search operator		
	Assert.assertTrue(this.isElementPresent(By.xpath(locator.getString("xpath.record.search.operator.arrows")), 3000));
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

public void chooseRcord(String entity,String feild1Name, String feild1Value) {
	 String[] parameters={entity,feild1Name,feild1Value};
    
	 this.clickElementByXpath(this.getString(locator, "xpath.record.choose.delete.record",parameters));
	 }
public void clickRecycle() {	
	this.clickElementByXpath(locator.getString("xpath.record.recycle.click.brower")); 	
	this.clickElementByXpath(locator.getString("xpath.record.recycle.click.recycle")); 
  }
public void clickJournal() {	
	this.clickElementByXpath(locator.getString("xpath.record.recycle.click.brower")); 	
	this.clickElementByXpath(locator.getString("xpath.record.choose.journal")); 
  }
}