package org.talend.mdm.impl;

import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;;


public class RecordImpl extends Record{

	public RecordImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void deleteRecordImpl(String container,String modle,String entity,String subelement){
		this.deleteRecord(container,modle,entity,subelement);
	}
	
	public void createRecordImpl(String container,String modle,String entity,String subelement,String name,String age){
		this.createRecord(container, modle, entity, subelement, name, age);
	}
	public void updateRecordImpl(String container,String modle,String entity,String subelement,String name,String age){
		this.updateRecord(container, modle, entity, subelement, name, age);
	}
}
