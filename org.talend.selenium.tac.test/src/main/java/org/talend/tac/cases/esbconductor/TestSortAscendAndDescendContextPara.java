package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.RedefineContextImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSortAscendAndDescendContextPara extends WebdriverLogin {
	 RedefineContextImpl redefineContextImpl;
     @BeforeMethod
     public void beforeMethod(){
         redefineContextImpl = new RedefineContextImpl(driver);
     }
   
     @Test
     @Parameters({"LabelForResetContext","NameA","NameB","NameC","CustomValueA","CustomValueB","CustomValueC"})
     public void testSortAscendAndDescendContextPara(String label,String variableNameA,String variableNameB,String variableNameC,String variableValueA,String variableValueB,String variableValueC) {
    	 redefineContextImpl.intoEsbpage();
    	 redefineContextImpl.addContextParas(label, variableNameA, variableValueA);
    	 redefineContextImpl.addContextParasForSort(label, variableNameB, variableValueB);
    	 logger.info("---------------VB:"+variableNameB);
    	 logger.info("+++++++++++++++VA:"+variableNameA);
    	 redefineContextImpl.sortConetextParas(variableNameB,variableNameA);
     }
     
}
