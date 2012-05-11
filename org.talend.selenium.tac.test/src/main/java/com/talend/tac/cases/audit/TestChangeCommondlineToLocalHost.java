package com.talend.tac.cases.audit;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestChangeCommondlineToLocalHost extends Audit {
	

	
	@Test
	@Parameters({"localhostAddress"})
	public void testCommondlineLocalhost(String ip){
		this.changeCommandLineConfig("primary", "commandline.conf.primary.host.editButton", "commandline.conf.primary.host.input", "commandline.conf.primary.host.value", ip,  other.getString("commandLine.conf.primary.host.statusIcon"));
	}
}
