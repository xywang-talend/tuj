package com.talend.tac.cases.audit;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestChangeCommondlineToLocalHost extends Audit {
	

	
	@Test
	@Parameters({"localhostAddress"})
	public void testCommondlineLocalhost(String ip){
		this.changeCommandLineConfig("primary", other.getString("commandline.conf.primary.host.editButton"), ip,  other.getString("commandLine.conf.primary.host.statusIcon"));
	}
}
