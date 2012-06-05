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
	}		
	@Test
	@Parameters( { "container","modle","entity","feild1Value","feild1Name" })
	public void testDeleteRecord(String container,String modle,String entity,String feild1Value,String feild1Name ) {
		recordImpl.deleteRecordImpl(container,modle,entity,feild1Value,feild1Name);
	}
	
	/*@Test
	@Parameters( { "container","modle","entity","feild1Value","feild1Name" })
	public void testExportRecord(String container,String modle,String entity,String feild1Value,String feild1Name ) {
		recordImpl.ExportRecordImpl(container,modle,entity);
	}*/
	
	@Test
	@Parameters( { "container","modle","entity" })
	public void testExportRecord(String container,String modle,String entity ) {
		recordImpl.ExportRecordImpl(container,modle,entity);
	}
	/*@Test
	@Parameters( { "container","modle","entity","feild1Value","feild1Name" })
	public void testJournalOpenRecord(String container,String modle,String entity,String feild1Value,String feild1Name ) {
		recordImpl.JournalOpenRecordImpl(container,modle,entity,feild1Value,feild1Name);
	}
	*/
	
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
	@Parameters( { "container","modle","entity", "feild2Value","feild2Name" })
	public void testCreateRecord(String container,String modle,String entity,String feild2Value,String feild2Name) {
		recordImpl.createRecordImpl(container, modle, entity, feild2Value, feild2Name);
	}
	@Test
	@Parameters( { "container","modle","entity","feild2Value_old", "feild2Value","feild2Name" })
	public void testDuplicateRecord(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name) {
		recordImpl.duplicateRecordImpl(container, modle, entity, feild2Value_old, feild2Value, feild2Name);
	}
	@Test
	@Parameters( { "container","modle","entity","feild2Value_old", "feild2Value","feild2Name"})
	public void testUpdateRecord(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name) {
		recordImpl.updateRecordImpl(container, modle, entity,feild2Value_old, feild2Value, feild2Name);
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
