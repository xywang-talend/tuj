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
	@Parameters( { "container","modle","entity","subelement" })
	public void testDeleteRecord(String container,String modle,String entity,String subelement) {
		recordImpl.deleteRecordImpl(container,modle,entity,subelement);
	}
	@Test
	@Parameters( { "container","modle","entity","subelement", "name", "age" })
	public void testCreateRecord(String container,String modle,String entity,String subelement,String name,String age) {
		recordImpl.createRecordImpl(container, modle, entity, subelement, name, age);
	}
	@Test
	@Parameters( { "container","modle","entity","subelement", "name", "age" })
	public void testUpdateRecord(String container,String modle,String entity,String subelement,String name,String age) {
		recordImpl.updateRecordImpl(container, modle, entity, subelement, name, age);
	}
	@Test
	@Parameters( { "container","modle","entity","searchFeild", "opeartion", "value" })
	public void testSearchRecordByValue(String container,String modle,String entity,String searchFeild,String opeartion,String value) {
		recordImpl.SearchRecordByValueImpl(container, modle, entity, searchFeild,opeartion,value);
	}
}
