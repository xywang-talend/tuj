package com.talend.tac.cases.audit;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestChangeCommondlineToRemote extends Audit {
	
	@Test
	@Parameters({"remotehostAddress"})
	public void testCommondlineRemote(String ip){
		this.changeCommandLineConfig(ip);
	}
}
