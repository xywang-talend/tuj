package org.talend.mdm.impl;

import org.openqa.selenium.WebDriver;
import org.talend.mdm.modules.Record;;


public class RecordImpl extends Record{

	public RecordImpl(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void restoreFromRecycleImpl(String container,String modle,String entity,String feild1Value,String feild1Name){
		this.restoreFromRecycle(container,modle,entity,feild1Value,feild1Name);
	}
	public void deleteRecordImpl(String container,String modle,String entity,String feild1Value,String feild1Name){
		this.deleteRecord(container,modle,entity,feild1Value,feild1Name);
	}
	public void JournalOpenRecordImpl(String container,String modle,String entity,String feild1Value,String feild1Name){
		this.JournalOpenRecord(container,modle,entity,feild1Value,feild1Name);
	}
	public void deleteRecordToRecycleImpl(String container,String modle,String entity,String feild1Value,String feild1Name){
		this.deleteRecordToRecycle(container,modle,entity,feild1Value,feild1Name);
	}
	public void duplicateRecordImpl(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name,String feild1UpdateValue){
		this.duplicateRecord(container, modle, entity, feild1Value, feild2Value, feild3Value,feild1Name,feild2Name,feild3Name,feild1UpdateValue);
	}
	
	public void createRecordImpl(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name){
		this.createRecord(container, modle, entity, feild1Value, feild2Value, feild3Value,feild1Name,feild2Name,feild3Name);
	}
	public void updateRecordImpl(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name){
		this.updateRecord(container, modle, entity, feild1Value, feild2Value, feild3Value,feild1Name,feild2Name,feild3Name);
	}
	public void SearchRecordByValueImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		this.searchRecordByValue(container, modle, entity, searchFeild,opeartion,value);
	}
	public void SearchRecordByStringImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		this.searchRecordByString(container, modle, entity, searchFeild,opeartion,value);
	}
	
	public void SearchRecordByDateImpl(String container,String modle,String entity,String searchFeild,String opeartion,String value){
		this.searchRecordByDate(container, modle, entity, searchFeild,opeartion,value);
	}
}
