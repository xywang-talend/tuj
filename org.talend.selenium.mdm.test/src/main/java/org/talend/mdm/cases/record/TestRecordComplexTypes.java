package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.RecordImplComplexTypes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestRecordComplexTypes extends Login {
	RecordImplComplexTypes recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new RecordImplComplexTypes(driver);	
	}		


	@Test
	@Parameters( { "container","modle","entity"})
	public void testCreateRecordSomeField(String container,String modle,String entity) {
		recordImpl.createRecordSomeFieldImpl(container, modle, entity);
	}
	
	@Test
	@Parameters( { "container","modle","entity","IdValue"})
	public void testCreateRecordAllField(String container,String modle,String entity,String IdValue) {
		recordImpl.createRecordAllFieldImpl(container, modle, entity,IdValue);
	}

	
}
