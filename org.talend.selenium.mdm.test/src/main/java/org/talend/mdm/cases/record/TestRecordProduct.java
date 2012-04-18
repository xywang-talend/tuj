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
		logger.info("Set Before Info");
	}		
	@Test
	@Parameters( { "container","modle","entity","UniqueId","UniqueIdValue" })
	public void testDeleteRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue ) {
		recordImpl.deleteRecordImpl(container,modle,entity,UniqueId,UniqueIdValue);
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
	@Parameters( { "container","modle","entity","UniqueId", "UniqueIdValue"})
	public void testUpdateCheckAvailabilityRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue) {
		recordImpl.testUpdateCheckAvailabilityRecordImpl(container, modle, entity,UniqueId, UniqueIdValue);
	}
	
	@Test
	@Parameters( { "container","modle","entity","UniqueId", "UniqueIdValue","name", "url_update"})
	public void testUpdateCompleteStoreUrlRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String name,String url) {
		recordImpl.testUpdateCompleteStoreUrlRecordImpl(container, modle, entity,UniqueId, UniqueIdValue,name,url);
	}
	
	@Test
	@Parameters( { "container","modle","entity", "UniqueId","UniqueIdValue","Price","PriceValue","flag","PriceValueOld"})
	public void testUpdatePriceRecord(String container,String modle,String entity,String UniqueId,String UniqueIdValue,String Price,String PriceValue,String flag,String PriceValueOld) {
		recordImpl.testUpdatePriceRecordImpl(container, modle, entity, UniqueId,UniqueIdValue,Price,PriceValue,flag,PriceValueOld);
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
}
