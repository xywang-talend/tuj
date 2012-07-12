package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.RecordImplEDA;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestRecordEDA extends Login {
	RecordImplEDA recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new RecordImplEDA(driver);	
	}		
	
	@Test
	@Parameters( { "container","modle","entity","IdValue","Type1","Type2"})
	public void testUpdateRecordAddMultipleField(String container,String modle,String entity,String IdValue,String Type1,String Type2) {
		recordImpl.testUpdateRecordAddMultipleFieldImpl(container, modle, entity,IdValue,Type1,Type2);
	}
	
	@Test
	@Parameters( { "container","modle","entity","IdValue","date1","date2"})
	public void testUpdateRecordDate(String container,String modle,String entity,String IdValue,String date1,String date2) {
		recordImpl.testUpdateRecordDateImpl(container, modle, entity,IdValue,date1,date2);
	}
}
