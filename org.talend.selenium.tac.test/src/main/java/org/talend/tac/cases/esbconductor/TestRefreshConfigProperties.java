package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.RedefineContextImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRefreshConfigProperties extends WebdriverLogin {
	 RedefineContextImpl redefineContextImpl;
     @BeforeMethod
     public void beforeMethod(){
         redefineContextImpl = new RedefineContextImpl(driver);
     }
   
     @Test
     @Parameters({"LabelForResetContext"})
     public void testRefreshConfigProperties(String label) {
    	 redefineContextImpl.intoEsbpage();
    	 redefineContextImpl.refershConfigProperties(label);
     }
     
}
