package com.talend.tac.cases.projects;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddprojects extends Projects {

	@Test
	@Parameters({ "projectType",
			"addCommonProjectName", "addReferenceProjectName", "proLanguage" })
	public void testAddProjectCommonAndReference(String type, String proname, String name2, String language)
			throws Exception {
		this.openMenuProject();
		this.addProjectSVN_DEFAULT(proname, "project_common", language, Projects.PROJECT_ADD_TYPE_COMMON, type);
		this.addProjectSVN_DEFAULT(name2, "project_reference", language, Projects.PROJECT_ADD_TYPE_REF, type);
	}
	
	@Test
	@Parameters({ "svnUrl", "projectType", "svnUserName", "svnUserPassword",
			"projectWithSpaceChar",  "proLanguage" })
	public void testAddProjectLabelWithSpace(String url, String type, String user,
			String password, String proname,String language)
			throws Exception {
		this.openMenuProject();
		this.addProjectSVN_DEFAULT(proname, "project label with space", language, Projects.PROJECT_ADD_TYPE_COMMON, type);
	}
	
	//add a project and check it whether normal appear in project authorization page
	@Test
	@Parameters({ "svnUrl", "projectType", "svnUserName", "svnUserPassword",
		"addProjectAndCheckItAppearInProjectAuthorization",  "proLanguage" })
	public void testAddNewCommonProjectAndCheckItAppearInProjectAuthorizationAndReferences(String url, String type, String user,
			String password, String proname,String language) {
		
		this.openMenuProject();
		this.addProjectSVN_DEFAULT(proname, "add project and check it whether normal in project authorization page",
				language, Projects.PROJECT_ADD_TYPE_COMMON, type);	
		
		this.clickWaitForElementPresent("!!!menu.projectsauthorizations.element!!!");
		this.waitForElementPresent("//div[text()='Projects authorizations'" +
				" and @class='header-title']", WAIT_TIME);	
		this.waitForElementPresent("//span[text()='"+proname+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+proname+"']"));
		
		this.clickWaitForElementPresent("!!!menu.refprojects.element!!!");
		this.waitForElementPresent("//div[text()='Projects references' and @class='header-title']", WAIT_TIME);	
		this.waitForElementPresent("//span[text()='"+proname+" - trunk']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+proname+" - trunk']"));
		
		this.openMenuProject();
		deleteProjectOK(proname);
	}
	
	
	@Test
	@Parameters({ "svnUrl", "projectType", "svnUserName", "svnUserPassword",
		"addProjectAndCheckItAppearInProjectAuthorization",  "proLanguage" })
	public void testAddNewReferenceProjectAndCheckItAppearInProjectAuthorizationAndReferences(String url, String type, String user,
			String password, String proname,String language) {
		
		this.openMenuProject();
		this.addProjectSVN_DEFAULT(proname, "add project and check it whether normal in project authorization page",
				language, Projects.PROJECT_ADD_TYPE_REF, type);	
		
		this.clickWaitForElementPresent("!!!menu.projectsauthorizations.element!!!");
		this.waitForElementPresent("//div[text()='Projects authorizations'" +
				" and @class='header-title']", WAIT_TIME);	
		this.waitForElementPresent("//span[text()='"+proname+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+proname+"']"));
		
		this.clickWaitForElementPresent("!!!menu.refprojects.element!!!");
		this.waitForElementPresent("//div[text()='Projects references' and @class='header-title']", WAIT_TIME);	
		this.sleep(3000);
		Assert.assertTrue(selenium.getXpathCount("//span[@class='x-panel-header-text' and text()='Projects available as reference']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-border-layout-ct']//div[text()='"+proname+"']").intValue()>=1);
//		this.waitForElementPresent("//span[@class='x-panel-header-text' and text()='Projects available as reference']//ancestor::div[@class='x-panel-body x-panel-body-noheader']//div[@class='x-panel-body x-panel-body-noborder']//div[text()='"+proname+"']", WAIT_TIME);
//		Assert.assertTrue(selenium.isElementPresent("//span[@class='x-panel-header-text' and text()='Projects available as reference']//ancestor::div[@class='x-panel-body x-panel-body-noheader']//div[@class='x-panel-body x-panel-body-noborder']//div[text()='"+proname+"']"));
		////span[@class='x-panel-header-text' and text()='Projects available as reference']//ancestor::div[@class='x-panel-body x-panel-body-noheader x-border-layout-ct']//div[text()='"+proname+"']
		this.openMenuProject();
		deleteProjectOK(proname);
	}
	
}
