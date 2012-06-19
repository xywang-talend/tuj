package org.talend.mdm.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;
import org.testng.Assert;

public class OccurrencesImpl extends Record{
	public OccurrencesImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void searchAllOccurrencesRecordImpl(String container,String modle,String entity,String entity_Element,String searchFeild,String searchFeild_Element,String opeartion,String value,String[] s){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		searchCondition(searchFeild,opeartion,value);
		this.sleepCertainTime(5000);
		for(int i=0; i<s.length; i++){
			Assert.assertTrue(this.waitfor(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+s[i]+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]"), WAIT_TIME_MIN).isDisplayed());
		}
	}	
	
	public void createOccurrencesRecordImpl(String container,String modle,String entity,String id,Boolean booLean,Boolean booLean2,String string,String string2,int integer,int integer2,double dou,double dou2,String dataTime,String dataTime2,String urlName,String urlValue,String url2Name,String url2Value,String enu,String enu2,String faterType,String fatherName,String fatherAdd,String fater2Type,String father2Name,String father2Add,String sonName,String sonAdd,String sonSchool,String son2Name,String son2Add,String son2School){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		int recordCount = Integer
				.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().split("of")[1].trim());
		logger.warn("before create ,total record num is:"+recordCount);
		this.clickCreateRecord();
		if(booLean){
		this.clickElementByXpath(locator.getString("xpath.occurrences.boolean.input"));
		}
		if(booLean2){
			this.clickElementByXpath(locator.getString("xpath.occurrences.boolean2.input"));
			}
		this.typeTextByXpath(locator.getString("xpath.occurrences.string.input"), string);
		this.typeTextByXpath(locator.getString("xpath.occurrences.string2.input"), string2);
		this.typeTextByXpath(locator.getString("xpath.occurrences.integer.input"), integer+"");
		this.typeTextByXpath(locator.getString("xpath.occurrences.integer2.input"), integer2+"");
		this.typeTextByXpath(locator.getString("xpath.occurrences.double.input"), dou+"");
		this.typeTextByXpath(locator.getString("xpath.occurrences.double2.input"), dou2+"");
		this.typeTextByXpath(locator.getString("xpath.occurrences.datetime.input"), dataTime);
		this.typeTextByXpath(locator.getString("xpath.occurrences.datetime2.input"),dataTime2);
		//fill url
		this.sleepCertainTime(3000);
		this.doubleClick(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.occurrences.url.openeditpanel.img"))));
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.occurrences.url.editurl")), WAIT_TIME_MIN).isDisplayed());
		this.typeTextByXpath(locator.getString("xpath.occurrences.url.name.input"), urlName);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.url.value.input"), urlValue);
	    this.clickElementByXpath(locator.getString("xpath.occurrences.url.save.button"));
	    
		//fill url2
	    this.sleepCertainTime(3000);
	    this.clickElementByXpath(locator.getString("xpath.occurrences.url2.openeditpanel.img"));
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.occurrences.url.editurl")), WAIT_TIME_MIN).isDisplayed());
		this.typeTextByXpath(locator.getString("xpath.occurrences.url.name.input"), url2Name);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.url.value.input"), url2Value);
	    this.clickElementByXpath(locator.getString("xpath.occurrences.url.save.button"));
	    
	    //fill enu ,enu2
	    this.seletDropDownList(By.xpath(locator.getString("xpath.occurrences.enu.selectdropdownlist.arrow")), enu);
	    this.seletDropDownList(By.xpath(locator.getString("xpath.occurrences.enu2.selectdropdownlist.arrow")), enu2);
	    
	    //fill father 
	    this.seletDropDownList(By.xpath(locator.getString("xpath.occurrences.father.type.selectdropdownlist.arrow")), faterType);
	    this.clickElementByXpath("//div[text()='father']//ancestor::tbody[2]/tr[1]/td[1]/img");
	    this.typeTextByXpath(locator.getString("xpath.occurrences.father.name.input"), fatherName);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.father.address.input"), fatherAdd);
	
	   //fill son
	    this.clickElementByXpath("//div[text()='son']//ancestor::tbody[2]/tr[1]/td[1]/img");
	    
	    this.typeTextByXpath(locator.getString("xpath.occurrences.son.name.input"), sonName);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.son.address.input"), sonAdd);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.son.school.input"), sonSchool);
	    
	    this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	    this.sleepCertainTime(10000);
	    int recordCountAfter = Integer
				.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().split("of")[1].trim());
		logger.warn("after create ,total record num is:"+recordCountAfter);
		Assert.assertTrue(recordCountAfter-recordCount==1);
		
		//verify record saved success
	   this.sleepCertainTime(5000);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.string.input"))), string);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.string2.input"))), string2);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.integer.input"))), integer+"");
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.integer2.input"))), integer2+"");
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.double.input"))), dou+"");
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.double2.input"))), dou2+"");
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.datetime.input"))), dataTime);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.datetime2.input"))),dataTime2);
	   
		
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.enu.input"))), enu);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.enu2.input"))), enu2);
		    
		    //father 
	    Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.father.type.input"))), faterType);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.father.name.input"))), fatherName);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.father.address.input"))), fatherAdd);
		
		   //son
		    
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.son.name.input"))), sonName);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.son.address.input"))), sonAdd);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.son.school.input"))), sonSchool);
		    
		this.clickElementByXpath("//a[contains(text(),'testUrl')]");
		List a = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	     a.add(handle);
	    }
	    driver.switchTo().window(a.get(1).toString());
	    Assert.assertTrue(this.waitfor(By.xpath("//input[@id='kw']"), WAIT_TIME_MIN).isDisplayed());
	    driver.switchTo().window(a.get(0).toString());
	    this.sleepCertainTime(5000)	;
	    
	    //click '+' on 'enum2', 'father2', 'son2' fields, fill all the fields, save it
	    Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/enum2']").size()==1);
	    
	    this.clickElementByXpath("//input[@name='Occurrences/enum2']//ancestor::tr//img[contains(@id,'Add')]");
	    this.sleepCertainTime(3000);
	    Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/enum2']").size()==2);
	    this.seletDropDownList(By.xpath("//div[contains(@id,'TreeDetail-root')]/div/div[19]//img[contains(@class,'x-form-trigger x-form-trigger-arrow')]"), enu2);
	   
	    Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/father2']").size()==1);
	    this.clickElementByXpath("//input[@name='Occurrences/father2']//ancestor::tr//img[contains(@id,'Add')]");
	    this.sleepCertainTime(3000);
	    Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/father2']").size()==2);
	    
	    Assert.assertTrue(this.getElementsByXpath("//div[text()='son2']").size()==1);
	    this.clickElementByXpath("//div[text()='son2']//ancestor::tr//img[contains(@id,'Add')]");
	    this.sleepCertainTime(3000);
	    Assert.assertTrue(this.getElementsByXpath("//div[text()='son2']").size()==2);
	    
	    //fill father2 just created
	    Assert.assertEquals(this.getValueInput(By.xpath(" //div[contains(@id,'TreeDetail-root')]/div/div[24]//input[@name='Occurrences/father2']")), fater2Type);
		this.clickElementByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[24]/table/tbody/tr/td[1]//img");
		this.typeTextByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[24]//input[@name='Occurrences/father2/Name']", father2Name);
		this.typeTextByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[24]//input[@name='Occurrences/father2/Address']", father2Add);
		
		//fill son2 just create
		this.clickElementByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[27]/table/tbody/tr/td[1]//img");
		this.sleepCertainTime(3000);
		this.typeTextByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[27]//input[@name='Occurrences/son2/Name']", son2Name);
		this.typeTextByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[27]//input[@name='Occurrences/son2/Address']", son2Add);
		this.typeTextByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[27]//input[@name='Occurrences/son2/School']", son2School);
		    
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
		this.sleepCertainTime(20000);
	
		//verify enu2 just created
		Assert.assertEquals(this.getValueInput(By.xpath("//div[contains(@id,'TreeDetail-root')]/div/div[19]//input")), enu2);
			
		//verify father2 just created
		this.clickElementByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[24]/table/tbody/tr/td[1]//img");
		Assert.assertEquals(this.getValueInput(By.xpath("//div[contains(@id,'TreeDetail-root')]/div/div[24]//input[@name='Occurrences/father2/Name']")), father2Name);
		Assert.assertEquals(this.getValueInput(By.xpath("//div[contains(@id,'TreeDetail-root')]/div/div[24]//input[@name='Occurrences/father2/Address']")), father2Add);
		
		//verify son2 just created
		this.clickElementByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[27]/table/tbody/tr/td[1]//img");
		this.sleepCertainTime(3000);
		Assert.assertEquals(this.getValueInput(By.xpath("//div[contains(@id,'TreeDetail-root')]/div/div[27]//input[@name='Occurrences/son2/Name']")), son2Name);
		Assert.assertEquals(this.getValueInput(By.xpath("//div[contains(@id,'TreeDetail-root')]/div/div[27]//input[@name='Occurrences/son2/Address']")), son2Add);
		Assert.assertEquals(this.getValueInput(By.xpath("//div[contains(@id,'TreeDetail-root')]/div/div[27]//input[@name='Occurrences/son2/School']")), son2School);
		  
	}	
	
	
	public void createOccurrencesRecordWithoutFillAllfieldsRequiredImpl(String container,String modle,String entity,String id,Boolean booLean,Boolean booLean2,String string,String string2,int integer,int integer2,double dou,double dou2,String dataTime,String dataTime2,String urlName,String urlValue,String url2Name,String url2Value,String enu,String enu2,String faterType,String fatherName,String fatherAdd,String fater2Type,String father2Name,String father2Add,String sonName,String sonAdd,String sonSchool,String son2Name,String son2Add,String son2School){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		int recordCount = Integer
				.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().split("of")[1].trim());
		logger.warn("before create ,total record num is:"+recordCount);
		this.clickCreateRecord();
		if(booLean){
		this.clickElementByXpath(locator.getString("xpath.occurrences.boolean.input"));
		}
		if(booLean2){
			this.clickElementByXpath(locator.getString("xpath.occurrences.boolean2.input"));
			}
		this.typeTextByXpath(locator.getString("xpath.occurrences.string.input"), string);
		this.typeTextByXpath(locator.getString("xpath.occurrences.string2.input"), string2);
		this.typeTextByXpath(locator.getString("xpath.occurrences.integer.input"), integer+"");
		this.typeTextByXpath(locator.getString("xpath.occurrences.integer2.input"), integer2+"");
		this.typeTextByXpath(locator.getString("xpath.occurrences.double.input"), dou+"");
		this.typeTextByXpath(locator.getString("xpath.occurrences.double2.input"), dou2+"");
		this.typeTextByXpath(locator.getString("xpath.occurrences.datetime.input"), dataTime);
		this.typeTextByXpath(locator.getString("xpath.occurrences.datetime2.input"),dataTime2);
		//fill url
		this.sleepCertainTime(3000);
		this.doubleClick(this.findElementDefineDriver(this.driver, By.xpath(locator.getString("xpath.occurrences.url.openeditpanel.img"))));
		this.sleepCertainTime(3000);
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.occurrences.url.editurl")), WAIT_TIME_MIN).isDisplayed());
		this.typeTextByXpath(locator.getString("xpath.occurrences.url.name.input"), urlName);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.url.value.input"), urlValue);
	    this.clickElementByXpath(locator.getString("xpath.occurrences.url.save.button"));
	    
		//fill url2
	    this.sleepCertainTime(3000);
		this.clickElementByXpath(locator.getString("xpath.occurrences.url2.openeditpanel.img"));
		Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.occurrences.url.editurl")), WAIT_TIME_MIN).isDisplayed());
		this.typeTextByXpath(locator.getString("xpath.occurrences.url.name.input"), url2Name);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.url.value.input"), url2Value);
	    this.clickElementByXpath(locator.getString("xpath.occurrences.url.save.button"));
	    
	    //fill enu ,enu2
	    this.seletDropDownList(By.xpath(locator.getString("xpath.occurrences.enu.selectdropdownlist.arrow")), enu);
	    this.seletDropDownList(By.xpath(locator.getString("xpath.occurrences.enu2.selectdropdownlist.arrow")), enu2);
	    
	    //fill father 
	    this.seletDropDownList(By.xpath(locator.getString("xpath.occurrences.father.type.selectdropdownlist.arrow")), faterType);
	    this.clickElementByXpath("//div[text()='father']//ancestor::tbody[2]/tr[1]/td[1]/img");
	    this.typeTextByXpath(locator.getString("xpath.occurrences.father.name.input"), fatherName);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.father.address.input"), fatherAdd);
	
	   //fill son
	    this.clickElementByXpath("//div[text()='son']//ancestor::tbody[2]/tr[1]/td[1]/img");
	    
	    this.typeTextByXpath(locator.getString("xpath.occurrences.son.name.input"), sonName);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.son.address.input"), sonAdd);
	    this.typeTextByXpath(locator.getString("xpath.occurrences.son.school.input"), sonSchool);
	    
	    this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
	    Assert.assertTrue(this.waitfor(By.xpath(locator.getString("xpath.occurrences.create.notinputallfieldsrequired.warning.info")),WAIT_TIME_MIN).isDisplayed());
	    this.clickElementByXpath(locator.getString("xpath.occurrences.create.notinputallfieldsrequired.warning.ok.button"));
	    this.sleepCertainTime(10000);
	    int recordCountAfter = Integer
				.parseInt(this.getElementByXpath(locator.getString("xpath.record.search.record.count")).getText().split("of")[1].trim());
		logger.warn("after create ,total record num is:"+recordCountAfter);
		Assert.assertTrue(recordCountAfter-recordCount==0);
		
	}
	
	public void updateOccurrencesRecordImpl(String container,String modle,String entity,String id,Boolean booLean,Boolean booLean2,String string,String string2,int integer,int integer2,double dou,double dou2,String dataTime,String dataTime2,String urlName,String urlValue,String url2Name,String url2Value,String enu,String enu2,String faterType,String fatherName,String fatherAdd,String fater2Type,String father2Name,String father2Add,String sonName,String sonAdd,String sonSchool,String son2Name,String son2Add,String son2School){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		Assert.assertTrue(this.waitfor(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+id+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]"), WAIT_TIME_MIN).isDisplayed());
		this.clickElementByXpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+id+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]");
		//verify record saved success
	    this.sleepCertainTime(5000);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.string.input"))), string);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.string2.input"))), string2);
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/integer']")), integer+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/integer2']")), integer2+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/double']")), dou+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/double2']")), dou2+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/datetime']")), dataTime);
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/datetime2']")),dataTime2);
	
	    //click '+' on 'enum2', 'father2', 'son2' fields, fill all the fields, save it
	    Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/enum2']").size()==2);
	    
	    //remove an occurrence of enu2
	    this.clickElementByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[19]//img[@id='Remove']");
	    Assert.assertTrue(this.waitfor(By.xpath("//span[contains(text(),'Do you really want to delete the selected record?')]"), WAIT_TIME_MIN).isDisplayed());	   
	    this.clickElementByXpath("//span[contains(text(),'Confirmation')]//ancestor::div[contains(@class,'x-window-plain x-window-dlg x-window x-component')]//button[contains(text(),'Yes')]");
	    this.sleepCertainTime(3000);
	    Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/enum2']").size()==1);
	   
	  //remove an occurrence of father2
	    Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/father2']").size()==2);
	    this.clickElementByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[23]//input[@name='Occurrences/father2']//ancestor::tr[1]//img[contains(@id,'Remove')]");
	    Assert.assertTrue(this.waitfor(By.xpath("//span[contains(text(),'Do you really want to delete the selected record?')]"), WAIT_TIME_MIN).isDisplayed());	   
	    this.clickElementByXpath("//span[contains(text(),'Confirmation')]//ancestor::div[contains(@class,'x-window-plain x-window-dlg x-window x-component')]//button[contains(text(),'Yes')]");
	    this.sleepCertainTime(3000);
	    Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/father2']").size()==1);
	    
	  //remove an occurrence of son2
	    Assert.assertTrue(this.getElementsByXpath("//div[text()='son2']").size()==2);
	    this.clickElementByXpath("//div[contains(@id,'TreeDetail-root')]/div/div[25]//div[contains(text(),'son2')]//ancestor::tr[1]//img[contains(@id,'Remove')]");
	    Assert.assertTrue(this.waitfor(By.xpath("//span[contains(text(),'Do you really want to delete the selected record?')]"), WAIT_TIME_MIN).isDisplayed());	   
	    this.clickElementByXpath("//span[contains(text(),'Confirmation')]//ancestor::div[contains(@class,'x-window-plain x-window-dlg x-window x-component')]//button[contains(text(),'Yes')]");
	    this.sleepCertainTime(3000);
	    Assert.assertTrue(this.getElementsByXpath("//div[text()='son2']").size()==1);
	    
		this.clickElementByXpath(locator.getString("xpath.record.choose.create.input.save"));
		this.sleepCertainTime(10000);
	
		Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/enum2']").size()==1);
		Assert.assertTrue(this.getElementsByXpath("//input[@name='Occurrences/father2']").size()==1);
		Assert.assertTrue(this.getElementsByXpath("//div[text()='son2']").size()==1);
		         
	}	
	
	
	
	public void logicalDeleteOccurrencesRecord(String container,String modle,String entity,String id,Boolean booLean,Boolean booLean2,String string,String string2,int integer,int integer2,double dou,double dou2,String dataTime,String dataTime2,String urlName,String urlValue,String url2Name,String url2Value,String enu,String enu2,String faterType,String fatherName,String fatherAdd,String fater2Type,String father2Name,String father2Add,String sonName,String sonAdd,String sonSchool,String son2Name,String son2Add,String son2School){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
//		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		Assert.assertTrue(this.waitfor(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+id+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]"), WAIT_TIME_MIN).isDisplayed());
		this.clickElementByXpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+id+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]");
		//verify record saved success
	    this.sleepCertainTime(5000);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.string.input"))), string);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.string2.input"))), string2);
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/integer']")), integer+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/integer2']")), integer2+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/double']")), dou+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/double2']")), dou2+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/datetime']")), dataTime);
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/datetime2']")),dataTime2);
		
		 String[] parameters_container={id,container};
		//delete this record to recycle bin first
		this.deleteToRecycleBin();
		this.clickRecycle();
		this.clickElementByXpath(locator.getString("xpath.record.recyclebin.search.button"));
		this.sleepCertainTime(4000);
		Assert.assertTrue(this.isElementPresent(By.xpath(this.getString(locator, "xpath.record.delete.record.to.recycle.assert.container",parameters_container)), WAIT_TIME_MIN ),"container");
	    //restore record from recycle bin
		this.clickElementByXpath(this.getString(locator, "xpath.record.recycle.click.record",id));
		this.clickElementByXpath(this.getString(locator,"xpath.record.recycle.click.record.restore",id));
		this.sleepCertainTime(5000);
		this.clickElementByXpath(locator.getString("xpath.record.recycle.click.record.restore.yes"));
		this.sleepCertainTime(3000);
		this.switchtoTabDataBrowser();
		Assert.assertTrue(this.waitfor(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+id+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]"),WAIT_TIME_MIN).isDisplayed());
		this.clickElementByXpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+id+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]");
		//verify record saved success
	    this.sleepCertainTime(5000);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.string.input"))), string);
		Assert.assertEquals(this.getValueInput(By.xpath(locator.getString("xpath.occurrences.string2.input"))), string2);
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/integer']")), integer+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/integer2']")), integer2+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/double']")), dou+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/double2']")), dou2+"");
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/datetime']")), dataTime);
		Assert.assertEquals(this.getValueInput(By.xpath("//input[@name='Occurrences/datetime2']")),dataTime2);
		
	}
	
	public void physicalDeleteOccurrencesRecord(String container,String modle,String entity,String id){
		chooseContainer(container);	
		chooseModle(modle);
		clickSave();
		chooseEntity(entity);	
		maxDataBrowserBoard();
		this.sleepCertainTime(6000);
		Assert.assertTrue(this.waitfor(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+id+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]"), WAIT_TIME_MIN).isDisplayed());
		this.clickElementByXpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-Occurrences/id')  and contains(text(),'"+id+"')]//ancestor::table[contains(@class,'x-grid3-row-table')]");
		String OperationType="PHYSICAL_DELETE";
		String source="genericUI";
	    this.sleepCertainTime(5000);
	    deleteTheRecord(entity);
	    this.sleepCertainTime(5000);
	    openJournal(entity,id,OperationType,source);
	    JournalResultCount();
	}
	
}
