package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.RecordImplAgent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestRecordAgent extends Login {
	RecordImplAgent recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new RecordImplAgent(driver);	
		logger.info("Set Before Info");
	}		
	@Test
	@Parameters( { "container","modle","entity","Identifie" ,"IdentifieValue"})
	public void testDeleteRecord(String container,String modle,String entity,String Identifie,String IdentifieValue ) {
		recordImpl.deleteRecordImpl(container,modle,entity, Identifie,IdentifieValue);
	}

	@Test
	@Parameters( { "container","modle","entity","Identifie" ,"IdentifieValue", "Firstname","FirstnameValue","Lastname","LastnameValue","CommissionCode" ,"CommissionCodeValue","StartDate","StartDateValue"})
	public void testCreateRecord(String container,String modle,String entity,String Identifie,String IdentifieValue,String Firstname,String FirstnameValue,String Lastname,String LastnameValue,String CommissionCode,String CommissionCodeValue,String StartDate,String StartDateValue ) {
		recordImpl.createRecordImpl(container, modle, entity,Identifie,IdentifieValue,Firstname,FirstnameValue,Lastname,LastnameValue,CommissionCode,CommissionCodeValue,StartDate,StartDateValue );
	}
	
}
