package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.RecordImplStore;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRecordStore extends Login {
	RecordImplStore recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new RecordImplStore(driver);	
		logger.warn("Set Before Info");
	}
	
	@Test
	@Parameters( { "container","modle","entity","storeId","storeIdValue" })
	public void testDeleteRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue ) {
		recordImpl.deleteRecordImpl(container,modle,entity,UniqueId,UniqueIdValue);
	}
		
	@Test
	@Parameters( { "container","modle","entity", "storeId","storeIdValue","address","addressValue"})
	public void testCreateRecord(String container,String modle,String entity,String storeId,String storeIdValue,String address,String addressValue) {
		recordImpl.createRecordImpl(container, modle, entity,storeId,storeIdValue,address,addressValue);
	}
	
	@Test
	@Parameters( { "container","modle","entity", "storeId","storeIdValue","storeIdValueDup"})
	public void testDuplicateRecord(String container,String modle,String entity,String storeId,String storeIdValue,String storeIdValueDup) {
		recordImpl.testDuplicateRecordImpl(container, modle, entity,storeId, storeIdValue,storeIdValueDup);
	}
	
	
	
	@Test
	@Parameters( { "container","modle","entity","storeId","storeIdValue","address","addressValue"})
	public void testUpdateAddressRecord(String container,String modle,String entity,String storeId,String storeIdValue,String address,String addressValue) {
		recordImpl.testUpdateAddressRecordImpl(container, modle, entity,storeId,storeIdValue,address,addressValue);
	}
	
	
}
