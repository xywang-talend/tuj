package org.talend.tac.cases.esbconductor;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.SelectFeatureFromArchivaImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestSearchGroupId extends WebdriverLogin {
    SelectFeatureFromArchivaImpl selectFeature;
	
	@BeforeMethod
	public void beforeMethod(){
		selectFeature=new SelectFeatureFromArchivaImpl(driver);
    }
	
	@Test
	@Parameters({"labelOfService", "desOfService", "repository","group"})
	public void testSearchGroupId(String label,String des,String repository,String group) {
		selectFeature.testSearchId(label, des, repository, group);
	}
}
