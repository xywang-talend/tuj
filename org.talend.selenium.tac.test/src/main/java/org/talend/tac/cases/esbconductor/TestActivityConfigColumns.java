package org.talend.tac.cases.esbconductor;

import org.testng.annotations.Test;
import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.RedefineContextImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestActivityConfigColumns extends WebdriverLogin {
	 RedefineContextImpl redefineContextImpl;
     @BeforeMethod
     public void beforeMethod(){
         redefineContextImpl = new RedefineContextImpl(driver);
     }
   
     @Test
     @Parameters({"LabelForResetContext"})
     public void testControlDisplayofMenu(String label) {
    	 redefineContextImpl.controlDisplayMenu(label);
     }
     
}
