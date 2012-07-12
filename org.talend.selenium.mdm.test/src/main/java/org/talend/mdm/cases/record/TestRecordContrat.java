package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.ContratsImpl;
import org.talend.mdm.impl.RecordImplAgent;
import org.talend.mdm.impl.SocieteClienteImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestRecordContrat extends Login {
	ContratsImpl recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new ContratsImpl(driver);	
		logger.warn("Set Before Info");
	}		
	@Test
	@Parameters( { "container","modle","entity","entity_name","primarykey.name","primarykey.value","numeroContratExterne"})
	public void testBrowseContratRecordBySearch(String container,String modle,String entity,String entityName,String keyName,String keyValue,String numeroContratExterne) {
		recordImpl.browseContratRecordBySearch(container, modle, entity,entityName,keyName,keyValue, numeroContratExterne);
	}
	
	@Test
	@Parameters( { "container","modle","entity","entity_name","primarykey.name","primarykey.value","numeroContratExterne","language.france","language.english"})
	public void testBrowseContratRecordInFrench(String container,String modle,String entity,String entityName,String keyName,String keyValue,String numeroContratExterne,String language,String languageDefault) {
		recordImpl.browseContratRecordInFrench(container, modle, entity,entityName,keyName,keyValue, numeroContratExterne,language,languageDefault);
	}
	
}
