package com.talend.tac.cases.menu;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.cases.Login;

public class TestMenuDisplayAfterChangeLicenseToCLOUD extends Login {
	
	//upload license and check upload result
	public void uploadLicense(String license) {
		
	   this.waitForElementPresent("//b[text()='admin, admin']", WAIT_TIME);
	   			
	   this.clickWaitForElementPresent("idMenuLicenseElement");
	   waitForElementPresent("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", WAIT_TIME);
	   selenium.type("//button[contains(text(),'Browse')]/ancestor::table[1]/preceding-sibling::input[1]", parseRelativePath(license));
	   selenium.click("//button[text()='Upload']");
			
       System.out.println("license upload is successful");	
       
       try {
		Thread.sleep(3000);
	   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	   }
       selenium.refresh();        
       
	}	
	
	//after upload license of 'CLOUD', check menu display of license'privilege 
	@Test
	@Parameters({"license.CLOUD"})
	public void testMenuDisplayAfterChangeLicenseToCLOUD(String license) {
		
	   this.uploadLicense(license);
		
	   this.waitForElementPresent("idMenuUserElement", WAIT_TIME);
	   Assert.assertTrue(selenium.isElementPresent("idMenuUserElement"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.project.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.projectsauthorizations.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.refprojects.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.lock.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("idMenuLicenseElement"));
	   Assert.assertTrue(selenium.isElementPresent("idMenuConfigElement"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.notification.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.softwareupdate.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.executionTasks.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.esbconductor.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.executionPlan.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.executionServers.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.virtual_server.element!!!"));
//	   Assert.assertTrue(selenium.isElementPresent("!!!menu.soamanager.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.businessModeler.browser.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.connections.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.dashjobs.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.dashamc.element!!!"));
//	   Assert.assertTrue(selenium.isElementPresent("!!!menu.soamanager.dashboard.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.commandline.dashboard.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.grid_task_executions_history.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.graphic_task_executions_history.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.audit.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.drools.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.servicelocator.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.serviceactivity.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("idMenuChangePasswordElement"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.settings.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.jobConductor.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.dashboard.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.task_executions_history.element!!!"));
	   Assert.assertTrue(selenium.isElementPresent("!!!menu.esb.element!!!"));
	   
	}
	
	//creation the case for change license to MDM
	@Test
	@Parameters({"license.MDM"})
	public void resetLicenseToMDM(String license) {
		
		uploadLicense(license);
		this.waitForElementPresent("idLeftMenuTreeLogoutButton", WAIT_TIME);
		
	}
	
}
