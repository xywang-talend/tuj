package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.ClearServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestClearService extends WebdriverLogin {
   
	ClearServiceImpl clearServiceImpl;
    @BeforeMethod
    public void beforeMethod(){
    	clearServiceImpl = new ClearServiceImpl(driver);
    }
	@Test
	public void clearAllServices() {
		clearServiceImpl.clearAllConductors();
	
	}
	
}
