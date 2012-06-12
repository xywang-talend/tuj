package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.OccurrencesImpl;
import org.talend.mdm.impl.RecordImplProduct;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRecordOccurrences extends Login {
	OccurrencesImpl occurrences;
	@BeforeMethod
	public void beforeMethod(){
		occurrences = new OccurrencesImpl(driver);	
		logger.warn("Set Before Info");
	}
	
	@Test
	@Parameters( { "container","modle","entity","entity_Element","searchFeild","searchFeild_Element","opeartion", "value" ,"occurrences_all"})
	public void testSearchAllOccurrencesRecord(String container,String modle,String entity,String entity_Element,String searchFeild,String searchFeild_Element,String opeartion,String value,String recordAll) {
		occurrences.searchAllOccurrencesRecordImpl(container, modle, entity, entity_Element ,searchFeild,searchFeild_Element,opeartion,value,this.splitParameter(recordAll));
	}
	
	@Test
	@Parameters( { "container","modle","entity","id","boolean","boolean2","string","string2","integer","integer2","double","double2","datetime","datetime2","url.name","url.value","url2.name","url2.value","enum","enum2","father.type","father.name","father.address","father2.type","father2.name","father2.address","son.name","son.address","son.school","son2.name","son2.address","son2.school"})
	public void testCreateOccurrencesRecord(String container,String modle,String entity,String id,Boolean booLean,Boolean booLean2,String string,String string2,int integer,int integer2,double dou,double dou2,String dataTime,String dataTime2,String urlName,String urlValue,String url2Name,String url2Value,String enu,String enu2,String faterType,String fatherName,String fatherAdd,String fater2Type,String father2Name,String father2Add,String sonName,String sonAdd,String sonSchool,String son2Name,String son2Add,String son2School) {
		occurrences.createOccurrencesRecordImpl(container, modle, entity, id,booLean, booLean2, string, string2, integer, integer2, dou, dou2, dataTime, dataTime2, urlName, urlValue, url2Name, url2Value, enu, enu2, faterType, fatherName, fatherAdd, fater2Type, father2Name, father2Add, sonName, sonAdd, sonSchool, son2Name, son2Add, son2School);
		}
	
	@Test
	@Parameters( { "container","modle","entity","id","boolean","boolean2","string","string2","integer","integer2","double","double2","datetime","datetime2","url.name","url.value","url2.name","url2.value","enum","enum2","father.type","father.name","father.address","father2.type","father2.name","father2.address","son.name","son.address","son.school","son2.name","son2.address","son2.school"})
	public void testCreateOccurrencesRecordWithoutFillAllfieldsRequired(String container,String modle,String entity,String id,Boolean booLean,Boolean booLean2,String string,String string2,int integer,int integer2,double dou,double dou2,String dataTime,String dataTime2,String urlName,String urlValue,String url2Name,String url2Value,String enu,String enu2,String faterType,String fatherName,String fatherAdd,String fater2Type,String father2Name,String father2Add,String sonName,String sonAdd,String sonSchool,String son2Name,String son2Add,String son2School) {
		occurrences.createOccurrencesRecordWithoutFillAllfieldsRequiredImpl(container, modle, entity, id,booLean, booLean2, string, string2, integer, integer2, dou, dou2, dataTime, dataTime2, urlName, urlValue, url2Name, url2Value, enu, enu2, faterType, fatherName, fatherAdd, fater2Type, father2Name, father2Add, sonName, sonAdd, sonSchool, son2Name, son2Add, son2School);
		}
	
	@Test
	@Parameters( { "container","modle","entity","id","boolean","boolean2","string","string2","integer","integer2","double","double2","datetime","datetime2","url.name","url.value","url2.name","url2.value","enum","enum2","father.type","father.name","father.address","father2.type","father2.name","father2.address","son.name","son.address","son.school","son2.name","son2.address","son2.school"})
	public void testUpdateOccurrencesRecord(String container,String modle,String entity,String id,Boolean booLean,Boolean booLean2,String string,String string2,int integer,int integer2,double dou,double dou2,String dataTime,String dataTime2,String urlName,String urlValue,String url2Name,String url2Value,String enu,String enu2,String faterType,String fatherName,String fatherAdd,String fater2Type,String father2Name,String father2Add,String sonName,String sonAdd,String sonSchool,String son2Name,String son2Add,String son2School) {
		occurrences.updateOccurrencesRecordImpl(container, modle, entity, id,booLean, booLean2, string, string2, integer, integer2, dou, dou2, dataTime, dataTime2, urlName, urlValue, url2Name, url2Value, enu, enu2, faterType, fatherName, fatherAdd, fater2Type, father2Name, father2Add, sonName, sonAdd, sonSchool, son2Name, son2Add, son2School);
		}
	
	@Test
	@Parameters( { "container","modle","entity","id","boolean","boolean2","string","string2","integer","integer2","double","double2","datetime","datetime2","url.name","url.value","url2.name","url2.value","enum","enum2","father.type","father.name","father.address","father2.type","father2.name","father2.address","son.name","son.address","son.school","son2.name","son2.address","son2.school"})
	public void testLogicalDeleteOccurrencesRecord(String container,String modle,String entity,String id,Boolean booLean,Boolean booLean2,String string,String string2,int integer,int integer2,double dou,double dou2,String dataTime,String dataTime2,String urlName,String urlValue,String url2Name,String url2Value,String enu,String enu2,String faterType,String fatherName,String fatherAdd,String fater2Type,String father2Name,String father2Add,String sonName,String sonAdd,String sonSchool,String son2Name,String son2Add,String son2School) {
		occurrences.logicalDeleteOccurrencesRecord(container, modle, entity, id,booLean, booLean2, string, string2, integer, integer2, dou, dou2, dataTime, dataTime2, urlName, urlValue, url2Name, url2Value, enu, enu2, faterType, fatherName, fatherAdd, fater2Type, father2Name, father2Add, sonName, sonAdd, sonSchool, son2Name, son2Add, son2School);
		}

	@Test
	@Parameters( { "container","modle","entity","id"})
	public void testPhysicalDeleteOccurrencesRecord(String container,String modle,String entity,String id) {
		occurrences.physicalDeleteOccurrencesRecord(container, modle, entity, id);
		}
	
	
}
