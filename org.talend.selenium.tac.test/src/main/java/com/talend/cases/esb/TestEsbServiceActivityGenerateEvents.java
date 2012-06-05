package com.talend.cases.esb;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestEsbServiceActivityGenerateEvents extends Esb {
	@Test
	@Parameters({"esbMonitorKarafUrl","esbMonitorReceiveNewEventsConsumer","esbMonitorGenerateNumForPageDisplay"})
	public void testGenerateEventsForPageDisplay(String karafUrl,String consumerName,String intNum){
		this.generateEvents(karafUrl, consumerName, Integer.parseInt(intNum));
	}
	
	@Test
	@Parameters({"esbConfServiceActivityMonitorServer","esbMonitorKarafUrl","esbMonitorReceiveNewEventsConsumer","esbMonitorGenerateNumForTest"})
	public void testGenerateEventsTest(String localServer, String karafUrl,String consumerName,String intNum){
	    //go to configuration page 
	    this.clickWaitForElementPresent("idMenuConfigElement");
		  
	    this.mouseDownWaitForElementPresent("//div[contains(text(),'ESB')]");	   

		this.modifySAMServer(localServer, other.getString("esb.conf.ServiceActivityMonitorServerStatusIconLocator"));
		this.generateEvents(karafUrl, consumerName, Integer.parseInt(intNum));
	}
}
