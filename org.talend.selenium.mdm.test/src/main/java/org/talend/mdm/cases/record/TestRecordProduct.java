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
		logger.warn("Set Before Info");
	}		
	@Test
	@Parameters( { "container","modle","entity","UniqueId","UniqueIdValue" })
	public void testDeleteRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue ) {
		recordImpl.deleteRecordImpl(container,modle,entity,UniqueId,UniqueIdValue);
	}
	
	@Test
	@Parameters( { "container","modle","entity","UniqueId","UniqueIdValue" })
	public void testDeleteToRecycleRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue ) {
		recordImpl.deleteRecordToRecycleImpl(container,modle,entity,UniqueId,UniqueIdValue);
	}
	
	@Test
	@Parameters( { "container","modle","entity","UniqueId","UniqueIdValue" })
	public void testRestoreFromRecycleRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue ) {
		recordImpl.restoreFromRecycleImpl(container,modle,entity,UniqueId,UniqueIdValue);
	}
	
	@Test
	@Parameters( { "container","modle","entity", "UniqueId","UniqueIdValue","Name","NameValue","Description","DescriptionValue","Price","PriceValue"})
	public void testCreateRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Name,String NameValue,String Description,String DescriptionValue,String Price,String PriceValue) {
		recordImpl.createRecordImpl(container, modle, entity, UniqueId,UniqueIdValue,Name,NameValue,Description,DescriptionValue,Price,PriceValue);
	}
	@Test
	@Parameters( { "container","modle","entity", "UniqueId","UniqueIdValue","UniqueIdValueDup"})
	public void testDuplicateRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String UniqueIdValueDup) {
		recordImpl.testDuplicateRecordImpl(container, modle, entity, UniqueId,UniqueIdValue,UniqueIdValueDup);
	}
		
	@Test
	@Parameters( { "container","modle","entity", "UniqueId","UniqueIdValue","Price","PriceValue","flag","PriceValueOld"})
	public void testUpdatePriceRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Price,String PriceValue,String flag,String PriceValueOld) {
		recordImpl.testUpdatePriceRecordImpl(container, modle, entity, UniqueId,UniqueIdValue,Price,PriceValue,flag,PriceValueOld);
	}
	
	@Test
	@Parameters( { "container","modle","entity", "UniqueId","UniqueIdValue","Price","PriceValue","flag","PriceValueOld"})
	public void testUpdatePriceRecordRowEditer(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Price,String PriceValue,String flag,String PriceValueOld) {
		recordImpl.testUpdatePriceRecordRowEditerImpl(container, modle, entity, UniqueId,UniqueIdValue,Price,PriceValue,flag,PriceValueOld);
	}
	
	
	
	
	
	@Test
	@Parameters( { "container","modle","entity","entity_Element","searchFeild","searchFeild_Element","opeartion", "value" })
	public void testSearchRecordByValue(String container,String modle,String entity,String entity_Element,String searchFeild,String searchFeild_Element,String opeartion,String value) {
		recordImpl.SearchRecordByValueImpl(container, modle, entity,entity_Element ,searchFeild,searchFeild_Element,opeartion,value);
	}
	@Test
	@Parameters( { "container","modle","entity","entity_Element","searchFeild","searchFeild_Element","opeartion", "value" })
	public void testSearchRecordByString(String container,String modle,String entity,String entity_Element,String searchFeild,String searchFeild_Element,String opeartion,String value) {
		recordImpl.SearchRecordByStringImpl(container, modle, entity, entity_Element ,searchFeild,searchFeild_Element,opeartion,value);
	}

	@Test
	@Parameters( {"user.frank.name","user.frank.password","user.jennifer.name","user.jennifer.password", "container","modle","entity","UniqueIdValue"})
	public void testPriceChangeValidApprovedWorkflow(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID) {
		recordImpl.priceChangeWorkFlowValidApprovedImpl(userFrank, frankPass, userJennifer, jenniferPass, container, model, entity,productUniqID);
	}
	
	@Test
	@Parameters( {"user.frank.name","user.frank.password","user.jennifer.name","user.jennifer.password", "container","modle","entity","UniqueIdValue"})
	public void testPriceValidNotApproveWorkFlow(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID) {
		recordImpl.priceChangeWorkFlowValidNotApprovedImpl(userFrank, frankPass, userJennifer, jenniferPass, container, model, entity,productUniqID);
	}
	
	@Test
	@Parameters( {"user.frank.name","user.frank.password","user.jennifer.name","user.jennifer.password", "container","modle","entity","UniqueIdValue"})
	public void testPriceChangeInvalidWorkflow(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID) {
		recordImpl.priceChangeWorkFlowInValidImpl(userFrank, frankPass, userJennifer, jenniferPass, container, model, entity,productUniqID);
	}
	
	@Test
	@Parameters( {"container","modle","entity","UniqueIdValue"})
	public void testStoreShowOnMapProcess(String container,String model,String entity,String productUniqID) {
		recordImpl.storeShowOnMapProcessImpl(container, model, entity,productUniqID);
	}
	
	@Test
	@Parameters( {"user.frank.name","user.frank.password","user.jennifer.name","user.jennifer.password", "container","modle","entity","UniqueIdValue","familyid","familyname","franksubmited.familyname"})
	public void testForeignKeyInforDisplay(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID,String productFamilyId,String productFamilyName,String frankSubmitedFamilyName) {
		recordImpl.foreignKeyInfoDisplay(userFrank, frankPass, userJennifer, jenniferPass, container, model, entity,productUniqID, productFamilyId, productFamilyName, frankSubmitedFamilyName);
	}
	
	@Test
	@Parameters( {"user.frank.name","user.frank.password","user.jennifer.name","user.jennifer.password", "container","modle","entity","UniqueIdValue","familyid","familyname","franksubmited.familyname"})
	public void testTwoWaysOpenWorkFlow(String userFrank,String frankPass,String userJennifer,String jenniferPass,String container,String model,String entity,String productUniqID,String productFamilyId,String productFamilyName,String frankSubmitedFamilyName) {
		recordImpl.openWorkflowTask(userFrank, frankPass, userJennifer, jenniferPass, container, model, entity,productUniqID, productFamilyId, productFamilyName, frankSubmitedFamilyName);
	}
	
	@Test
	@Parameters( { "container","modle","entity", "UniqueId","UniqueIdValue","Name","NameValue","Description","DescriptionValue","Price","PriceValue","storeId","storeIdValue","address","addressValue"})
	public void testCreateRecordProductWithStore(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Name,String NameValue,String Description,String DescriptionValue,String Price,String PriceValue,String storeId, String storeIdValue, String address, String addressValue) {
		recordImpl.createRecordProductWithStoreImpl(container, modle, entity, UniqueId,UniqueIdValue,Name,NameValue,Description,DescriptionValue,Price,PriceValue,storeId, storeIdValue, address, addressValue);
	}
	
	@Test
	@Parameters( { "container","modle","entity", "UniqueId","UniqueIdValue","storeId","storeIdValue","address","addressValue"})
	public void testRecordAddMultipleStoresToProduct(String container,String model,String entity,String uniqueId,String uniqueIdValue,String storeId, String storeIdValue, String address, String addressValue) {
		recordImpl.addMutipleStoresToAProduct(container, model, entity, uniqueId, uniqueIdValue, storeIdValue, addressValue);
		}
}
