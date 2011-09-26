package com.talend.tac.cases.projects;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAddprojects extends Projects {

	@Test
	@Parameters({ "SVNurl", "ProjectType", "SVNuserName", "SVNuserPassword",
			"AddcommonProjectname", "AddreferenceProjectname", "Prolanguage" })
	public void testAddProjectCommonAndReference(String url, String type, String user,
			String password, String proname, String name2, String language)
			throws Exception {
		this.openMenuProject();
		this.addProjectSVN_DEFINED(proname, "project_common", language, Projects.PROJECT_ADD_TYPE_COMMON, type, url, user, password);
		this.addProjectSVN_DEFINED(name2, "project_reference", language, Projects.PROJECT_ADD_TYPE_REF, type, url, user, password);
	}
	
	@Test
	@Parameters({ "SVNurl", "ProjectType", "SVNuserName", "SVNuserPassword",
			"ProjectWithSpaceChar",  "Prolanguage" })
	public void testAddProjectLabelWithSpace(String url, String type, String user,
			String password, String proname,String language)
			throws Exception {
		this.openMenuProject();
		this.addProjectSVN_DEFAULT(proname, "project label with space", language, Projects.PROJECT_ADD_TYPE_COMMON, type);
	}
	
	//add a project and check it whether normal appear in project authorization page
	@Test
	@Parameters({ "SVNurl", "ProjectType", "SVNuserName", "SVNuserPassword",
		"AddProjectAndCheckItAppearInProjectAuthorization",  "Prolanguage" })
	public void testAddNewProjectAndCheckItAppearInProjectAuthorization(String url, String type, String user,
			String password, String proname,String language) {
		
		this.openMenuProject();
		this.addProjectSVN_DEFAULT(proname, "add project and check it whether normal in project authorization page",
				language, Projects.PROJECT_ADD_TYPE_COMMON, type);	
		
		this.clickWaitForElementPresent("!!!menu.projectsauthorizations.element!!!");
		this.waitForElementPresent("//div[text()='Projects authorizations'" +
				" and @class='header-title']", WAIT_TIME);	
		this.waitForElementPresent("//span[text()='"+proname+"']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent(""));
		
		this.openMenuProject();
		deleteProjectOK(proname);
	}
	
}
