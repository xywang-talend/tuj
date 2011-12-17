package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Test;

public class TestCleanServers extends Server{
  @Test
  public void testCleanServers() throws InterruptedException {
	 this.openServerMenu();
	 this.deleteAllServersNotUsed();
  }
}
