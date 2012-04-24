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
	@Parameters( { "container","modle","entity","Identifie" ,"IdentifieValue"})
	public void testDeleteRecord(String container,String modle,String entity,String Identifie,String IdentifieValue ) {
		recordImpl.deleteRecordImpl(container,modle,entity, Identifie,IdentifieValue);
	}

	@Test
	@Parameters( { "container","modle","entity", "Name","NameValue","Identifie" ,"IdentifieValue","Zipcode","ZipcodeValue"})
	public void testCreateRecord(String container,String modle,String entity,String Name,String NameValue,String Identifie,String IdentifieValue,String Zipcode,String ZipcodeValue ) {
		recordImpl.createRecordImpl(container, modle, entity, Name,NameValue, Identifie,IdentifieValue,Zipcode,ZipcodeValue);
	}
	@Test
	@Parameters( { "container","modle","entity","Identifie" ,"IdentifieValue","IdentifieValueDup" })
	public void testDuplicateRecord(String container,String modle,String entity,String Identifie,String IdentifieValue,String IdentifieValueDup ) {
		recordImpl.duplicateRecordImpl(container, modle, entity, Identifie,IdentifieValue, IdentifieValueDup);
	}
	@Test
	@Parameters( { "container","modle","entity","Identifie" ,"IdentifieValue","Zipcode","ZipcodeValue"})
	public void testUpdateRecord(String container,String modle,String entity,String Identifie,String IdentifieValue,String Zipcode,String ZipcodeValue ) {
		recordImpl.updateRecordImpl(container, modle, entity,Identifie,IdentifieValue,Zipcode,ZipcodeValue);
	}
	
}
