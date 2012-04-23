package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.RecordImplAgency;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestRecordAgency extends Login {
	RecordImplAgency recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new RecordImplAgency(driver);	
		logger.info("Set Before Info");
	}		
	@Test
	@Parameters( { "container","modle","entity","feild2Value","feild2Name","feild1Name" })
	public void testDeleteRecord(String container,String modle,String entity,String feild2Value,String feild2Name,String feild1Name ) {
		recordImpl.deleteRecordImpl(container,modle,entity,feild2Value,feild2Name,feild1Name);
	}

	@Test
	@Parameters( { "container","modle","entity", "Name","NameValue","Identifie" ,"IdentifieValue","Zipcode","ZipcodeValue"})
	public void testCreateRecord(String container,String modle,String entity,String Name,String NameValue,String Identifie,String IdentifieValue,String Zipcode,String ZipcodeValue ) {
		recordImpl.createRecordImpl(container, modle, entity, Name,NameValue, Identifie,IdentifieValue,Zipcode,ZipcodeValue);
	}
	@Test
	@Parameters( { "container","modle","entity","feild2Value_old", "feild2Value","feild2Name" ,"feild1Name" })
	public void testDuplicateRecord(String container,String modle,String entity,String feild2Value_old,String feild2Value,String feild2Name,String feild1Name) {
		recordImpl.duplicateRecordImpl(container, modle, entity, feild2Value_old, feild2Value, feild2Name,feild1Name);
	}
	@Test
	@Parameters( { "container","modle","entity","Identifie" ,"IdentifieValue","Zipcode","ZipcodeValue"})
	public void testUpdateRecord(String container,String modle,String entity,String Identifie,String IdentifieValue,String Zipcode,String ZipcodeValue ) {
		recordImpl.updateRecordImpl(container, modle, entity,Identifie,IdentifieValue,Zipcode,ZipcodeValue);
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
