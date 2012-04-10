package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.RecordImplProduct;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestRecordProduct extends Login {
	RecordImplProduct recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new RecordImplProduct(driver);	
		logger.info("Set Before Info");
	}		
	@Test
	@Parameters( { "container","modle","entity","feild2Value","feild2Name","feild1Name" })
	public void testDeleteRecord(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name ) {
		recordImpl.deleteRecordImpl(container,modle,entity,feild2Value,feild2Name,feild1Name);
	}
	
	@Test
	@Parameters( { "container","modle","entity" })
	public void testExportRecord(String container,String modle,String entity ) {
		recordImpl.ExportRecordImpl(container,modle,entity);
	}
	
	@Test
	@Parameters( { "container","modle","entity","feild2Value","feild2Name" ,"feild1Name"})
	public void testDeleteRecordToRecycle(String container,String modle,String entity,String feild2Value,String feild2Name ,String feild1Name) {
		recordImpl.deleteRecordToRecycleImpl(container,modle,entity,feild2Value,feild2Name,feild1Name);
	}
	
	@Test
	@Parameters( { "container","modle","entity","feild2Value","feild2Name" })
	public void testRestoreFromRecycle(String container,String modle,String entity,String feild2Value,String feild2Name ) {
		recordImpl.restoreFromRecycleImpl(container, modle, entity, feild2Value, feild2Name);
	}		
	
	@Test
	@Parameters( { "container","modle","entity", "UniqueId","UniqueIdValue","Name","NameValue","Description","DescriptionValue","Price","PriceValue"})
	public void testCreateRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Name,String NameValue,String Description,String DescriptionValue,String Price,String PriceValue) {
		recordImpl.createRecordImpl(container, modle, entity, UniqueId,UniqueIdValue,Name,NameValue,Description,DescriptionValue,Price,PriceValue);
	}
	@Test
	@Parameters( { "container","modle","entity","feild2Value_old", "feild2Value","feild2Name" ,"feild1Name" })
	public void testDuplicateRecord(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name,String feild1Name) {
		recordImpl.duplicateRecordImpl(container, modle, entity, feild2Value_old, feild2Value, feild2Name,feild1Name);
	}
	@Test
	@Parameters( { "container","modle","entity","UniqueId", "UniqueIdValue"})
	public void testUpdateCheckAvailabilityRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue) {
		recordImpl.testUpdateCheckAvailabilityRecordImpl(container, modle, entity,UniqueId, UniqueIdValue);
	}
	
	@Test
	@Parameters( { "container","modle","entity","UniqueId", "UniqueIdValue","name", "url_update"})
	public void testUpdateCompleteStoreUrlRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String name,String url) {
		recordImpl.testUpdateCompleteStoreUrlRecordImpl(container, modle, entity,UniqueId, UniqueIdValue,name,url);
	}
	
	
	@Test
	@Parameters( { "container","modle","entity","searchFeild", "opeartion", "value" })
	public void testSearchRecordByValue(String container,String modle,String entity,String searchFeild,String opeartion,String value) {
		recordImpl.SearchRecordByValueImpl(container, modle, entity, searchFeild,opeartion,value);
	}
	@Test
	@Parameters( { "container","modle","entity","searchFeild", "opeartion", "value" })
	public void testSearchRecordByString(String container,String modle,String entity,String searchFeild,String opeartion,String value) {
		recordImpl.SearchRecordByStringImpl(container, modle, entity, searchFeild,opeartion,value);
	}
	
	@Test
	@Parameters( { "container","modle","entity","searchFeild", "opeartion", "value" })
	public void testSearchRecordByDate(String container,String modle,String entity,String searchFeild,String opeartion,String value) {
		recordImpl.SearchRecordByDateImpl(container, modle, entity, searchFeild,opeartion,value);
	}
	
	
	
	
}
