package com.talend.tac.cases.commandline;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.base.AntAction;

public class TestCommandline extends CommandlineImpls {
	
	
	@Test
	@Parameters({"commandResult", "commandStatus"})
	public void testCommandlineInitLocal(String commandResult, String commandStatus) {
		
		this.commandlineInitLocalImpl(commandResult, commandStatus);
		
	}
	
	@Test
	@Parameters({"commandStatus"})
	public void testGetCommandStatus(String commandStatus) {
		
		this.commandlineGetCommandStatusImpl(0, commandStatus, 50);
	}
	
	@Test
	@Parameters({"commandResult", "commandStatus", "url", "root"})
	public void testCommandlineInitRemote(String commandResult, String commandStatus
			, String url, String root) {
		
		this.commandlineInitRemoteImpl(commandResult, commandStatus, url, root);
		
	}	

	@Test
	@Parameters({"commandResult", "commandStatus", "addCommonProjectName", 
		"userName", "userPassword", "url", "root"})
	public void testCommandlineLogonProject(String commandResult, String commandStatus
			, String commPro, String userName, String userPassword, String url, String root) {
		
		this.commandlineLogonProjectImpl(commandResult, commandStatus, commPro, userName, userPassword, url, root);		
	}	

	@Test
	@Parameters({"commandResult", "commandStatus", "projectName", "description",
		"userName", "userPassword", "url", "root"})
	public void testCommandlineCreatRemoteProject(String commandResult, String commandStatus
			, String project, String description, String userName, String userPassword
			, String url, String root) {
		
		this.commandlineCreatRemoteProjectImpl(commandResult, commandStatus, project, description, userName, userPassword, url, root);
		
	}
	
	@Test
	@Parameters({"commandResult", "commandStatus", "exportPath", "addCommonProjectName", 
		"userName", "userPassword", "url", "root"})
	public void testCommandlineExportAllJob(String commandResult, String commandStatus
			, String exportPath, String commPro, String userName, String userPassword
			, String url, String root) {
        
		this.commandlineExportAllJobImpl(commandResult, commandStatus, exportPath, commPro, userName, userPassword, url, root);
		
	}
	
	@Test
	@Parameters({"helpFilterResult"})
	public void testCommandlineHelpFiltr(String helpFilterResult) {
		
		this.commandlineHelpFiltrImpl(helpFilterResult);
		
	}	

	@Test
	@Parameters({"helpResult", "helpResult1"})
	public void testCommandlineHelp(String helpResult, String helpResult1) {
		
		this.commandlineHelpImpl(helpResult, helpResult1);
		
	}
	
	@Test
	@Parameters({"commandResult", "commandStatus", "addCommonProjectName", 
		"userName", "userPassword", "url", "root"})
	public void testCommandlineLogoffProject(String commandResult, String commandStatus
			, String commPro, String userName, String userPassword
			, String url, String root) {
        
		this.commandlineLogoffProjectImpl(commandResult, commandStatus, commPro, userName, userPassword, url, root);
		
	}
	
	@Test
	@Parameters({"commandResult", "commandStatus", "projectName", "description",
		"userName", "userPassword"})
	public void testCommandlineCreatLocalProject(String commandResult, String commandStatus
			, String project, String description, String userName, String userPassword) {
		
		this.commandlineCreateLocalProjectImpl(commandResult, commandStatus, project, description, userName, userPassword);
		
	}
	
	@Test
	@Parameters({"commandResult", "commandStatus", "projectName", "description",
		"userName", "userPassword", "url", "root", "importItemtsPath"})
	public void testCommandlineImportItems(String commandResult, String commandStatus
			, String project, String description, String userName, String userPassword
			, String url, String root, String importPath) {
		
		this.commandlineImportItems(commandResult, commandStatus, project, description, userName, userPassword, url, root, importPath);
		
	}
	
	@Test
	@Parameters({"commandResult", "commandStatus", "addReferenceProjectName",
		"userName", "userPassword", "url", "root", "exportPath"})
	public void testCommandlineExportItems(String commandResult, String commandStatus
			, String project, String userName, String userPassword
			, String url, String root, String exportPath) {
		
		this.commandlineExportItems(commandResult, commandStatus, project, userName, userPassword, url, root, exportPath);
		
	}
	
}
