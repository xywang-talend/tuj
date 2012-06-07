package com.talend.tac.cases.projects;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDeletepro extends Projects {

	@Test
	@Parameters({ "deleteProjectName" })
	public void testDeletepro(String deleteProname) throws Exception {
		//
		this.openMenuProject();
		//this.waitForElementPresent("!!!menu.project.element!!!", 30);
		this.duplicateProject(deleteProname);
		this.deleteProjectCANCEL("Copy_of_"+deleteProname);
		this.deleteProjectOK("Copy_of_"+deleteProname);
		
	}



}
