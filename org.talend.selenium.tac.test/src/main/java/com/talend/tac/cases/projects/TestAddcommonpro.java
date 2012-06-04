package com.talend.tac.cases.projects;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestAddcommonpro extends Projects {

	@Test
	@Parameters({ "sVNurl","projectType", "sVNuserName", "sVNuserPassword",
			"addCommontestProjectName", "addReferencetestProjectName","proLanguage"  })
	public void testAddTestProjects(String url,String type, String user, String password,
			String proname, String name2,String language) throws Exception {
		    this.openMenuProject();
			this.addProjectSVN_DEFAULT(proname, "", language, Projects.PROJECT_ADD_TYPE_COMMON, type);
		    this.addProjectSVN_DEFAULT(name2, "", language, Projects.PROJECT_ADD_TYPE_REF, type);
	}
}
