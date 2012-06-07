package org.talend.tac.cases.esbconductor;

import org.testng.annotations.Test;
import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.RedefineContextImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestResetConfigProperties extends WebdriverLogin {
	 RedefineContextImpl redefineContextImpl;
     @BeforeMethod
     public void beforeMethod(){
         redefineContextImpl = new RedefineContextImpl(driver);
     }
   
     @Test
     @Parameters({"LabelForResetContext", "desOfService", "repositoryForContext", "groupForContext", "artifactForContext",
    		"versionForContext", "featureName", "typeForContext", "addedContext", "serverOfRuntime","contextVariableName","contextVariableValue"})
     public void testResetContextParameters(String label, String des, String repository,
             String group, String artifact, String version, String name, String type, 
             String context, String server,String variableName,String variableValue) {
    	 redefineContextImpl.resetContextParameters(label, des, repository, group, artifact, version, name, type, context, server, variableName, variableValue);
     }
     
}
