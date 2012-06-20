package com.talend.tac.cases.commandline;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.base.AntAction;

public class TestCommandline extends CommandlineImpls {
	
	
	@Test
	@Parameters({"commandResult"})
	public void testCommandlineInitLocal(String commandResult) {
		
		this.commandlineInitLocalImpl(commandResult);
		
	}
	
	@Test
	public void testGetCommandStatus() {
		
		this.commandlineGetCommandStatusImpl(0, 50);
	}
	
	@Test
	@Parameters({"commandResult", "url", "root"})
	public void testCommandlineInitRemote(String commandResult
			, String url, String root) {
		
		this.commandlineInitRemoteImpl(commandResult, url, root);
		
	}	

	@Test
	@Parameters({"commandResult", "addCommonProjectName", 
		"userName", "userPassword", "url", "root"})
	public void testCommandlineLogonProject(String commandResult
			, String commPro, String userName, String userPassword, String url, String root) {
		
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);		
	}	

	@Test
	@Parameters({"commandResult", "projectName", "description",
		"userName", "userPassword", "url", "root", "addCommonProjectName"})
	public void testCommandlineCreatRemoteProject(String commandResult
			, String project, String description, String userName, String userPassword
			, String url, String root, String addCommonProjectName) {
		
		this.commandlineCreatRemoteProjectImpl(commandResult, project, description, userName, userPassword, url, root, addCommonProjectName);

		Assert.assertTrue(ss.contains(project));
		
	}
	
	@Test
	@Parameters({"commandResult", "exportPath", "addCommonProjectName", 
		"userName", "userPassword", "url", "root"})
	public void testCommandlineExportAllJob(String commandResult
			, String exportPath, String commPro, String userName, String userPassword
			, String url, String root) {
        
		this.commandlineExportAllJobImpl(commandResult, exportPath, commPro, userName, userPassword, url, root);
		
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
	@Parameters({"commandResult", "addCommonProjectName", 
		"userName", "userPassword", "url", "root"})
	public void testCommandlineLogoffProject(String commandResult
			, String commPro, String userName, String userPassword
			, String url, String root) {
        
		this.commandlineLogoffProjectImpl(commandResult, commPro, userName, userPassword, url, root);
		
	}
	
	@Test
	@Parameters({"commandResult", "projectLocalName", "description",
		"userName", "userPassword"})
	public void testCommandlineCreatLocalProject(String commandResult
			, String project, String description, String userName, String userPassword) {
		
		this.commandlineCreateLocalProjectImpl(commandResult, project, description, userName, userPassword);
		
	}
	
	@Test
	@Parameters({"commandResult", "projectName", "description",
		"userName", "userPassword", "url", "root", "importItemtsPath"})
	public void testCommandlineImportItems(String commandResult
			, String project, String description, String userName, String userPassword
			, String url, String root, String importPath) {
		
		this.commandlineImportItemsImpl(commandResult, project, description, userName, userPassword, url, root, importPath);
		
	}
	
	@Test
	@Parameters({"commandResult", "addReferenceProjectName",
		"userName", "userPassword", "url", "root", "exportPath"})
	public void testCommandlineExportItems(String commandResult
			, String project, String userName, String userPassword
			, String url, String root, String exportPath) {
		
		this.commandlineExportItemsImpl(commandResult, project, userName, userPassword, url, root, exportPath);
		
	}

	@Test
	@Parameters({"listCommandResult", "listCommandResult1"})
	public void testCommandlineListCommand(String commandResult, String commandResult1) {
		
		this.commandlineListCommandImpl(commandResult, commandResult1);
		
	}
	
	@Test
	@Parameters({"commandResult", "url", "root", "addCommonProjectName", 
		"userName", "userPassword", "serverForUseAvailable", "serverForUseUnavailable"})
	public void testCommandlineListExecutionServer(String commandResult
			, String url, String root,  String project, 
			String userName, String userPassword, String server, String server1) {
		
		this.commandlineListExecutionServerImpl(commandResult, url, root, project, userName
				, userPassword, server, server1);
		
	}	

	@Test
	@Parameters({"commandResult", "url", "root", "addCommonProjectName", 
		"userName", "userPassword"})
	public void testCommandlineListJob(String commandResult
			, String url, String root,  String project, 
			String userName, String userPassword) {
		
		this.commandlineListJobImpl(commandResult, url, root, project, userName
				, userPassword);
		
		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("refJobByMaintRunJobRun"));
		Assert.assertTrue(ss.contains("tRunJob"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));	

	}	

	@Test
	@Parameters({"commandResult", "url", "root", "addCommonProjectName", 
		"userName", "userPassword", "addCommonProjectName", 
		"addReferenceProjectName", "projectWithSpaceChar"})
	public void testCommandlineListProject(String commandResult
			, String url, String root,  String project, 
			String userName, String userPassword, String commPro,
			String refPro, String proSpace) {
		
		this.commandlineListProjectImpl(commandResult, url, root, project, userName
				, userPassword);
				
		Assert.assertTrue(ss.contains(commPro));
		Assert.assertTrue(ss.contains(refPro));
		Assert.assertTrue(ss.contains(proSpace));

	}

	@Test
	@Parameters({"commandResult", "url", "root", "addCommonProjectName", 
		"userName", "userPassword"})
	public void testCommandlineListItem(String commandResult
			, String url, String root,  String project, 
			String userName, String userPassword) {
		
		this.commandlineListItemImpl(commandResult, url, root, project, userName
				, userPassword);
				
		Assert.assertTrue(ss.contains("[PROCESS]"));
		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("[CONTEXT]"));
		Assert.assertTrue(ss.contains("contxt"));
		Assert.assertTrue(ss.contains("[CODE]"));
		Assert.assertTrue(ss.contains("[routines]"));
		Assert.assertTrue(ss.contains("[system]"));
		Assert.assertTrue(ss.contains("[SQLPATTERNS]"));
		Assert.assertTrue(ss.contains("[Netezza]"));
		
	}	

	@Test
	@Parameters({"commandResult", "url", "root", "projectName", 
		"userName", "userPassword"})
	public void testCommandlineChangeVersion(String commandResult
			, String url, String root,  String project, 
			String userName, String userPassword) {
		
		this.commandlineChangeVersionImpl(commandResult, url, root, project, userName
				, userPassword);
				
		Assert.assertTrue(otherVerionJobs.contains("generateBigLogs"));
		Assert.assertTrue(otherVerionJobs.contains("tjavaWithMulripleCheckPoint"));

	}

	@Test
	@Parameters({"commandResult", "url", "root"})
	public void testCommandlineShowVersion(String commandResult
			, String url, String root) {
		
		this.commandlineShowVersionImpl(commandResult, url, root);

	}
	
	@Test
	@Parameters({"commandResult", "url", "root", "addCommonProjectName", 
		"userName", "userPassword", "jdkPath"})
	public void testCommandlineExecuteJob(String commandResult
			, String url, String root,  String project, 
			String userName, String userPassword, String jdkPath) {
		
		this.commandlineExecuteJobImpl(commandResult, url, root, project, userName, userPassword, jdkPath);		

	}	

	@Test
	@Parameters({"commandResult", "projectName", 
		"userName", "userPassword", "url", "root", "importMetedataPath"})
	public void testCommandlineImportDatabaseMetadata(String commandResult
			, String commPro, String userName, String userPassword
			, String url, String root, String importMetedataPath) {
        
		this.commandlineImportDatabaseMetadataImpl(commandResult, url, root, commPro, userName, userPassword, importMetedataPath);
		
	}

	@Test
	@Parameters({"commandResult", "projectName", 
		"userName", "userPassword", "url", "root", "importMetedataPath"})
	public void testCommandlineDelimitedMetadata(String commandResult
			, String commPro, String userName, String userPassword
			, String url, String root, String importMetedataPath) {
        
		this.commandlineImportDelimitedMetadataImpl(commandResult, url, root, commPro, userName, userPassword, importMetedataPath);
		
	}
	
}



