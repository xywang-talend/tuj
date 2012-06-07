package org.talend.tac.cases.esbconductor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.talend.tac.base.WebdriverLogin;
import org.talend.tac.modules.impl.DuplicateESBConductorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestOpenLinksOfArtifactRepository extends WebdriverLogin {
	DuplicateESBConductorImpl duplicateESBConductorImpl;
	@BeforeMethod
	public void beforeMethod(){
		duplicateESBConductorImpl = new DuplicateESBConductorImpl(driver);
	}
	//open links of admin console
	@Test
	public void testOpenLinksOfArtifactRepository() {
		
		String karafPageTitleExpected = "Apache Archiva";
		duplicateESBConductorImpl.openLinkofArtifactRepository(karafPageTitleExpected);	
	}
	
	public void genenateUserPw() {
		
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_K);
			r.keyRelease(KeyEvent.VK_K);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_R);
			r.keyRelease(KeyEvent.VK_R);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyPress(KeyEvent.VK_F);
			r.keyRelease(KeyEvent.VK_F);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
	
}
