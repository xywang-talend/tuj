package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.RecordImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestRecord extends Login {
	RecordImpl recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new RecordImpl(driver);	
		logger.info("Set Before Info");
	}		
	@Test
	@Parameters( { "container","modle","entity","feild1Value","feild1Name" })
	public void testDeleteRecord(String container,String modle,String entity,String feild1Value,String feild1Name ) {
		recordImpl.deleteRecordImpl(container,modle,entity,feild1Value,feild1Name);
	}
	
	@Test
	@Parameters( { "container","modle","entity","feild1Value","feild1Name" })
	public void testJournalOpenRecord(String container,String modle,String entity,String feild1Value,String feild1Name ) {
		recordImpl.JournalOpenRecordImpl(container,modle,entity,feild1Value,feild1Name);
	}
	
	
	@Test
	@Parameters( { "container","modle","entity","feild1Value","feild1Name" })
	public void testDeleteRecordToRecycle(String container,String modle,String entity,String feild1Value,String feild1Name ) {
		recordImpl.deleteRecordToRecycleImpl(container,modle,entity,feild1Value,feild1Name);
	}
	
	@Test
	@Parameters( { "container","modle","entity","feild1Value","feild1Name" })
	public void testRestoreFromRecycle(String container,String modle,String entity,String feild1Value,String feild1Name ) {
		recordImpl.restoreFromRecycleImpl(container, modle, entity, feild1Value, feild1Name);
	}		
	
	@Test
	@Parameters( { "container","modle","entity","feild1Value", "feild2Value", "feild3Value","feild1Name","feild2Name","feild3Name" })
	public void testCreateRecord(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name) {
		recordImpl.createRecordImpl(container, modle, entity, feild1Value, feild2Value, feild3Value,feild1Name,feild2Name,feild3Name);
	}
	@Test
	@Parameters( { "container","modle","entity","feild1Value", "feild2Value", "feild3Value","feild1Name","feild2Name","feild3Name","feild1UpdateValue" })
	public void testDuplicateRecord(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name,String feild1UpdateValue) {
		recordImpl.duplicateRecordImpl(container, modle, entity, feild1Value, feild2Value, feild3Value,feild1Name,feild2Name,feild3Name,feild1UpdateValue);
	}
	@Test
	@Parameters( { "container","modle","entity","feild1Value", "feild2Value", "feild3Value","feild1Name","feild2Name","feild3Name"})
	public void testUpdateRecord(String container,String modle,String entity,String feild1Value,String feild2Value,String feild3Value,String feild1Name,String feild2Name,String feild3Name) {
		recordImpl.updateRecordImpl(container, modle, entity, feild1Value, feild2Value, feild3Value,feild1Name,feild2Name,feild3Name);
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
