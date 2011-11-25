package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.cases.Login;
@Test
public class TestDuplicateTask  extends Login {
    
	@Test
	@Parameters({"labelNotChooseActive","duplicateTask"})
	public void testDuplicateTask(String label, String duplicateLabel) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
		selenium.click("idSubModuleRefreshButton");
		if(!selenium.isElementPresent("//span[text()='"+duplicateLabel+"']")) {
			selenium.mouseDown("//span[text()='"+label+"']");//select a exist task
	        selenium.click("idSubModuleDuplicateButton");
	        					
			selenium.click("idFormSaveButton");
			this.waitForElementPresent("//span[text()='"+duplicateLabel+"']", WAIT_TIME);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+duplicateLabel+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}		
	}
}
