package com.talend.tac.cases.projects;

import org.testng.annotations.Test;

public class TestClean extends Projects{

  @Test
  public void testDeleteAllNotUsed() throws InterruptedException{
	 this.openMenuProject();
	 this.deleteProjectsNotUsed();
  }
}
