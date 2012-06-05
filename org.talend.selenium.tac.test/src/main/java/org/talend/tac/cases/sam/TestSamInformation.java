package org.talend.tac.cases.sam;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.SamInformationImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSamInformation extends WebdriverLogin{
	
	SamInformationImpl samInformationImpl;
    @BeforeMethod
    public void beforeMethod(){
    	samInformationImpl = new SamInformationImpl(driver);
    }
    @Test()
    @Parameters({"esbMonitorKarafUrl","serviceName","consumerJobName"})
    public void testCheckSamInfo(String karafURL,String providerName,String consumerName) {
    	samInformationImpl.checkSamInfo(karafURL, providerName, consumerName);
    }
}
