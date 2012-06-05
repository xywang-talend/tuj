package org.talend.mdm.cases.welcome;

import org.talend.mdm.Login;
import org.talend.mdm.impl.WelcomeImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestWelcomePage extends Login {
	WelcomeImpl welcom;
	@BeforeMethod
	public void beforeMethod(){
		welcom = new WelcomeImpl(driver);
	}
	
	@Test
	public void testWelcomLayoutResort() {
	welcom.reSortWindows();
	}
}
