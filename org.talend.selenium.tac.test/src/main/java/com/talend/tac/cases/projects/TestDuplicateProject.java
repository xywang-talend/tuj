
package com.talend.tac.cases.projects;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDuplicateProject extends Projects {
	@Test
	@Parameters({ "duplicateProName" ,"projectType"})
	public void testDuplicateProject(String duplicateproname,String type) throws InterruptedException {
		this.openMenuProject();
		this.duplicateProject(duplicateproname);
	}
	
}
