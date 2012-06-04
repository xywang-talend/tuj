package com.talend.tac.cases.jobconductor;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDeleteServer extends Server{
	@Test
	@Parameters({ "serverUnused"})
	public void testDeleteServerUnused(String unusedServername) throws InterruptedException {
	this.openServerMenu();
	this.deleteServer(unusedServername);
	}
}
