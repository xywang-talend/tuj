package com.talend.tac.cases.projects;

import java.awt.event.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;

public class TestAddProjectUncheckadvanced extends Projects {
	TestDeletepro delete = new TestDeletepro();

	@Test
	@Parameters({"uncheckAdvancedProject" ,"projectType", "proLanguage" })
	public void testAddProjectWithoutClickAdvanced(String namecommon,String type, String language)
			throws InterruptedException {
	this.openMenuProject();
	this.addProjectSVN_DEFAULT(namecommon, "", language, Projects.PROJECT_ADD_TYPE_COMMON, type);
	this.deleteProjectOK(namecommon);
	}
}
