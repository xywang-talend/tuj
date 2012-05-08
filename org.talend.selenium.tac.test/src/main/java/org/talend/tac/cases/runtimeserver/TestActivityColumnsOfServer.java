package org.talend.tac.cases.runtimeserver;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.AddRuntimeServerWithInvalidHostImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActivityColumnsOfServer extends WebdriverLogin {
	AddRuntimeServerWithInvalidHostImpl addRuntimeServerWithInvalidHostImpl;
    @BeforeMethod
    public void beforeMethod(){
    	addRuntimeServerWithInvalidHostImpl = new AddRuntimeServerWithInvalidHostImpl(driver);
    }
    
    @Test
    public void testActivityColumnsOfServer() {
    	addRuntimeServerWithInvalidHostImpl.activityColumns();   
    }
}
