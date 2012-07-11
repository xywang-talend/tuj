package org.talend.mdm.cases.record;

import org.talend.mdm.Login;
import org.talend.mdm.impl.EdaImpl;
import org.talend.mdm.impl.RecordImplAgent;
import org.talend.mdm.impl.SocieteClienteImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestRecordSocieteCliente extends Login {
	SocieteClienteImpl recordImpl;
	@BeforeMethod
	public void beforeMethod(){
		recordImpl = new SocieteClienteImpl(driver);	
		logger.warn("Set Before Info");
	}		
	@Test
	@Parameters( { "container","modle","entity","entity_name","primarykey.name","primarykey.value"})
	public void testSynchronizedInDataChangesViewer(String container,String modle,String entity,String entityName,String keyName,String keyValue) {
		recordImpl.folersOpenCloseSynchronizedInDataChangesViewerImpl(container, modle, entity,entityName,keyName,keyValue);
	}
	
	@Test
	@Parameters( { "container","modle","entity","entity_name","primarykey.name","primarykey.value","numeroContrat","numeroContratExterne"})
	public void testBrowseSocieteClienteRecordWithFKContrats(String container,String modle,String entity,String entityName,String keyName,String keyValue,String numeroContrat,String numeroContratExterne) {
		recordImpl.browseSocieteClienteRecordWithFKContrats(container, modle, entity,entityName,keyName,keyValue,numeroContrat, numeroContratExterne);
	}
}
