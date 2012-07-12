package com.talend.tac.cases.commandline;

import java.util.LinkedHashMap;
import java.util.List;
import org.testng.Assert;

import com.talend.tac.base.AntAction;

public class CommandlineImpls extends CommandlineAction {
	
	String ss = "";
	String otherVerionJobs = "";
	public void commandlineInitLocalImpl(String commandResult) {
		
		String initLocalResult = this.initLocal();
		System.err.println("initLocalResult>>>"+initLocalResult);
		int commandInitLocalId = this.getCommandId(initLocalResult);
		Assert.assertTrue(initLocalResult.contains(commandResult+" "+commandInitLocalId));
		this.commandlineGetCommandStatusImpl(commandInitLocalId, WAIT_TIME);
		
	}
	
	public void commandlineGetCommandStatusImpl(int commandId, int checkTimes) {
		
		Assert.assertTrue(this.commandStatusCheck(commandId, 1000, checkTimes));
		
	}
	
	public void commandlineInitRemoteImpl(String commandResult
			, String url, String root) {
		
		String initRemoteResult = this.initRemote(url+root);
		System.err.println(url+root);
		System.err.println("initRemoteResult>>>"+initRemoteResult);
		int commandInitRemoteId = this.getCommandId(initRemoteResult);
		System.out.println(">>>>>>>>>>"+initRemoteResult);
		System.out.println(">>>>>>>>>>"+commandResult+" "+commandInitRemoteId);
		Assert.assertTrue(initRemoteResult.contains(commandResult+" "+commandInitRemoteId));
		this.commandlineGetCommandStatusImpl(commandInitRemoteId, WAIT_TIME);
		
	}	
	
	public void commandlineLogonProjectImpl(String commandResult
			, String commPro, String userName, String userPassword, String url, String root) {
		
		this.commandlineInitRemoteImpl(commandResult, url, root);
		System.err.println("commPro>>>"+commPro);
		String logonProject = this.logonProject(commPro, userName, userPassword);
		System.err.println("LogonPtoject>>>"+logonProject);
		int commandLogonProjectId = this.getCommandId(logonProject);
		Assert.assertTrue(logonProject.contains(commandResult+" "+commandLogonProjectId));
		this.commandlineGetCommandStatusImpl(commandLogonProjectId, WAIT_TIME);
		
	}	
	
	public void commandlineCreatRemoteProjectImpl(String commandResult
			, String project, String description, String userName, String userPassword
			, String url, String root, String commPro) {
		
		this.commandlineInitRemoteImpl(commandResult, url, root);
		
		String creatRemoteProjectResult = this.createProject(project, description, userName, userPassword);
		System.err.println("creatRemoteProjectResult>>>"+creatRemoteProjectResult);		
		int commandCreatRemoteProjectResultId = this.getCommandId(creatRemoteProjectResult);
		Assert.assertTrue(creatRemoteProjectResult.contains(commandResult+" "+commandCreatRemoteProjectResultId));
		this.commandlineGetCommandStatusImpl(commandCreatRemoteProjectResultId, WAIT_TIME);
		
		this.commandlineListProjectImpl(commandResult, url, root, commPro, userName, userPassword);
		
	}
	
	public void commandlineExportAllJobImpl(String commandResult
			, String exportPath, String commPro, String userName, String userPassword, String url, String root) {
        
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);
		
		System.err.println(this.getAbsolutePath(exportPath));
		String exportAllJob = this.exportAllJob(this.getAbsolutePath(exportPath));
		System.err.println("exportAllJob>>>"+exportAllJob);
	
		int commandExportAllJobId = this.getCommandId(exportAllJob);
		Assert.assertTrue(exportAllJob.contains(commandResult+" "+commandExportAllJobId));
		this.commandlineGetCommandStatusImpl(commandExportAllJobId, WAIT_TIME*2);
		
		LinkedHashMap map = this.getFileNameList(this.getAbsolutePath(exportPath));
		Assert.assertTrue(map.containsValue("generateBigLogs.zip"));
		Assert.assertTrue(map.containsValue("refJobByMaintRunJobRun.zip"));
		Assert.assertTrue(map.containsValue("tjava.zip"));
		Assert.assertTrue(map.containsValue("tjavaWithMulripleCheckPoint.zip"));
		Assert.assertTrue(map.containsValue("tRunJob.zip"));
		Assert.assertTrue(map.containsValue("trunjobWithCheckpoint.zip"));
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/generateBigLogs.zip");
		new AntAction().runTarget("File.xml", "delete", properties);	
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/refJobByMaintRunJobRun.zip");
		new AntAction().runTarget("File.xml", "delete", properties);	
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/tjava.zip");
		new AntAction().runTarget("File.xml", "delete", properties);	
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/tjavaWithMulripleCheckPoint.zip");
		new AntAction().runTarget("File.xml", "delete", properties);	
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/tRunJob.zip");
		new AntAction().runTarget("File.xml", "delete", properties);	
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/trunjobWithCheckpoint.zip");
		new AntAction().runTarget("File.xml", "delete", properties);	
		System.err.println("***********testCommandlineExportAllJob finished***********");
		
	}
	
	public void commandlineHelpFiltrImpl(String helpFilterResult) {
		
		List<String> helpFiltrs = this.helpFiltr();
		System.err.println("helpFiltr>>>"+helpFiltrs);	
		
		String ss = "";
		for(int i=0; i<helpFiltrs.size(); i++) {
			
			ss = ss+helpFiltrs.get(i);
            System.err.println("i>>>>>>>>"+helpFiltrs.get(i));			
			
		}
		System.err.println("ss>>>"+ss);
		Assert.assertTrue(ss.contains(helpFilterResult));
		System.err.println("***********testCommandlineHelpFiltr finished***********");
		
	}

	public void commandlineHelpImpl(String helpResult, String helpResult1) {
		
		List<String> help = this.help();
		System.err.println("help>>>"+help);	
		
		String ss = "";
		for(int i=0; i<help.size(); i++) {
			
			ss = ss+help.get(i);
            System.err.println("i>>>>>>>>"+help.get(i));			
			
		}
		System.err.println("ss>>>"+ss);
		Assert.assertTrue(ss.contains(helpResult));
		Assert.assertTrue(ss.contains(helpResult1));
		System.err.println("***********testCommandlineHelp finished***********");
		
	}
	
    public void commandlineLogoffProjectImpl(String commandResult, String project, String user, String passwd
    		, String url, String root) {
		
		this.commandlineLogonProjectImpl(commandResult, project, user, passwd, url, root);	
		
		String logoffProjectResult = this.logOffProject();
		System.err.println("logoffProjectResult>>>"+logoffProjectResult);
		int commandLogoffProjectId = this.getCommandId(logoffProjectResult);
		Assert.assertTrue(logoffProjectResult.contains(commandResult+" "+commandLogoffProjectId));
		this.commandlineGetCommandStatusImpl(commandLogoffProjectId, WAIT_TIME);
		System.err.println("***********testCommandlineHelpFiltr finished***********");
		
	}

	public void commandlineCreateLocalProjectImpl(String commandResult
			, String project, String description, String userName, String userPassword) {
		
		this.commandlineInitLocalImpl(commandResult);
		
		String createLocalProjectResult = this.createProject(project, description, userName, userPassword);
		System.err.println("createLocalProjectResult>>>"+createLocalProjectResult);	
		int commandCreateLocalProjectResultId = this.getCommandId(createLocalProjectResult);
		Assert.assertTrue(createLocalProjectResult.contains(commandResult+" "+commandCreateLocalProjectResultId));
		this.commandlineGetCommandStatusImpl(commandCreateLocalProjectResultId,WAIT_TIME);		
		
		List<String> listCommandListProjectResult = this.listProject();
		System.err.println("listCommandResult>>>>>>>>"+listCommandListProjectResult);
		
		for(int i=0; i<listCommandListProjectResult.size(); i++) {
			
			ss = ss+listCommandListProjectResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandListProjectResult.get(i));			
			
		}
		System.err.println("ss>>>"+ss);	
		Assert.assertTrue(ss.contains(project));
	}
	
	public void commandlineImportItemsImpl(String commandResult
			, String project, String description, String userName, String userPassword
			, String url, String root, String importPath) {		
		
		
		this.commandlineLogonProjectImpl(commandResult, project, userName, userPassword, url, root);
		
		String importItemsResult = this.importItems(this.getAbsolutePath(importPath+"/importJobs.zip"));
		
		int commandImportItemsResultId = this.getCommandId(importItemsResult);
		Assert.assertTrue(importItemsResult.contains(commandResult+" "+commandImportItemsResultId));
	    this.commandlineGetCommandStatusImpl(commandImportItemsResultId, WAIT_TIME);
		
	}

	public void commandlineExportItemsImpl(String commandResult
			, String project, String userName, String userPassword
			, String url, String root, String exportPath) {		
		
		this.commandlineLogonProjectImpl(commandResult, project, userName, userPassword, url, root);
		
		String exportItemsResult = this.exportItems(this.getAbsolutePath(exportPath));
		
		int commandExportItemsResultId = this.getCommandId(exportItemsResult);
		Assert.assertTrue(exportItemsResult.contains(commandResult+" "+commandExportItemsResultId));
	    this.commandlineGetCommandStatusImpl(commandExportItemsResultId, WAIT_TIME);
	    LinkedHashMap map = this.getFileNameList(this.getAbsolutePath(exportPath));
	    properties.put("file.path", this.getAbsolutePath(exportPath)+"/REFERENCEPRO");
		new AntAction().runTarget("File.xml", "available_dir", properties);
		this.delFolder(this.getAbsolutePath(exportPath+"/REFERENCEPRO"));		
	
	}
	
	public void commandlineListCommandImpl(String commandResult, String commandResult1) {
		
		List<String> listCommandResult = this.listCommand();
		System.err.println("listCommandResult>>>>>>>>"+listCommandResult);
		String ss = "";
		for(int i=0; i<listCommandResult.size(); i++) {
			
			ss = ss+listCommandResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandResult.get(i));			
			
		}
		System.err.println("ss>>>"+ss);
		Assert.assertTrue(ss.contains(commandResult));
		Assert.assertTrue(ss.contains(commandResult1));
		
	}
	
	public void commandlineListExecutionServerImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword,
			 String listExecutionServer, String listExecutionServer1) {
		
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);
		
		List<String> listCommandResult = this.listExecutionServer();
		System.err.println("listCommandResult>>>>>>>>"+listCommandResult);
		String ss = "";
		for(int i=0; i<listCommandResult.size(); i++) {
			
			ss = ss+listCommandResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandResult.get(i));			
			
		}
		System.err.println("ss>>>"+ss);
		Assert.assertTrue(ss.contains(listExecutionServer));
		Assert.assertTrue(ss.contains(listExecutionServer1));
	}

	public void commandlineListJobImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> listCommandListJobResult = this.listJob();
		System.err.println("listCommandResult>>>>>>>>"+listCommandListJobResult);
		
		for(int i=0; i<listCommandListJobResult.size(); i++) {
			
			ss = ss+listCommandListJobResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandListJobResult.get(i));			
			
		}
		System.err.println("ss>>>"+ss);
				
	}	

	public void commandlineListProjectImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);
		
		List<String> listCommandListProjectResult = this.listProject();
		System.err.println("listCommandResult>>>>>>>>"+listCommandListProjectResult);
		
		for(int i=0; i<listCommandListProjectResult.size(); i++) {
			
			ss = ss+listCommandListProjectResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandListProjectResult.get(i));			
			
		}
		System.err.println("ss>>>"+ss);	
		
	}

	public void commandlineListItemImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);
		
		List<String> listCommandListItemResult = this.listItem();
		System.err.println("listCommandResult>>>>>>>>"+listCommandListItemResult);
		
		for(int i=0; i<listCommandListItemResult.size(); i++) {
			
			ss = ss+listCommandListItemResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandListItemResult.get(i));			
			
		}
		System.err.println("ss>>>"+ss);	
		
	}

	public void commandlineChangeVersionImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);
		
		String listCommandChangeJobVersionResult = this.changeJobVersion();
		System.err.println("changeJobVersionResult>>>>>>>>"+listCommandChangeJobVersionResult);
		
		int commandChangeJobVersionId = this.getCommandId(listCommandChangeJobVersionResult);
		this.commandlineGetCommandStatusImpl(commandChangeJobVersionId , WAIT_TIME);
		
		List<String> listCommandlistOtherVersionResult = this.listOtherVersionJob();
		System.err.println("listCommandResult>>>>>>>>"+listCommandlistOtherVersionResult);
		
		for(int i=0; i<listCommandlistOtherVersionResult.size(); i++) {			
			
			otherVerionJobs = otherVerionJobs+listCommandlistOtherVersionResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandlistOtherVersionResult.get(i));			
			
		}
		System.err.println("otherVerionJobs>>>"+otherVerionJobs);	
		
	}

	public void commandlineShowVersionImpl(String commandResult
			, String url, String root) {
		
		this.commandlineInitRemoteImpl(commandResult, url, root);
		
		List<String> showVerionResult = this.showVersion();
		System.err.println("changeJobVersionResult>>>>>>>>"+showVerionResult);		
	    
		String showVersionActual = "";
		for(int i=0; i<showVerionResult.size(); i++) {			
			
			showVersionActual = showVersionActual+showVerionResult.get(i);
            System.err.println("i>>>>>>>>"+showVerionResult.get(i));			
			
		}
		System.err.println("otherVerionJobs>>>"+otherVerionJobs);	
		
		Assert.assertTrue(!showVersionActual.equals(null));
		
	}

	public void commandlineExecuteJobImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);		
		
		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("refJobByMaintRunJobRun"));
		Assert.assertTrue(ss.contains("tRunJob"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));		
		System.err.println("ss>>>"+ss);	

		String commandExecuteJobResult = this.executeJob("tjavaWithMulripleCheckPoint");
		System.err.println("commandExecuteJobResult>>>>>>>>"+commandExecuteJobResult);
		int commandExecuteJobId = this.getCommandId(commandExecuteJobResult);
		Assert.assertTrue(commandExecuteJobResult.contains(commandResult+" "+commandExecuteJobId));
		this.commandlineGetCommandStatusImpl(commandExecuteJobId, WAIT_TIME);
		List<String> executeJobResult = this.getCommandStatusAllInfo(commandExecuteJobId);
		
		String executeJobResultInfo = "";
		for(int i=0; i<executeJobResult.size(); i++) {			
			
			executeJobResultInfo = executeJobResultInfo+executeJobResult.get(i);
            System.err.println("i>>>>>>>>"+executeJobResult.get(i));			
			
		}
		System.err.println("executeJobResultInfo>>>"+executeJobResultInfo);	
		
		Assert.assertTrue(executeJobResultInfo.contains("the first checkpoint"));
		Assert.assertTrue(executeJobResultInfo.contains("the second checkpoint"));
		Assert.assertTrue(executeJobResultInfo.contains("the third checkpoint"));
		Assert.assertTrue(executeJobResultInfo.contains("the fourth checkpoint"));
		
	}

	public void commandlineImportDatabaseMetadataImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword
			, String databaseMetadataPath) {		
		
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);
        
		System.err.println(this.getAbsolutePath(databaseMetadataPath)+"/test_db");
		String importDatebaseMetadataResult = this.importDatabaseMetadata(this.getAbsolutePath(databaseMetadataPath)+"/test_db.zip");		
		System.err.println("importDatebaseMetadataResult>>>>>>>>"+importDatebaseMetadataResult);
		int commandImportDatebaseMetadataId = this.getCommandId(importDatebaseMetadataResult);
		Assert.assertTrue(importDatebaseMetadataResult.contains(commandResult+" "+commandImportDatebaseMetadataId));
		this.commandlineGetCommandStatusImpl(commandImportDatebaseMetadataId, WAIT_TIME);
		
		
	}

	public void commandlineImportDelimitedMetadataImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword
			, String delimitedMetadataPath) {		
		
		this.commandlineLogonProjectImpl(commandResult, commPro, userName, userPassword, url, root);
		
		System.err.println(this.getAbsolutePath(delimitedMetadataPath)+"/test_delimited.zip");
		String importDelimitedMetadataPathResult = this.importDelimitedMetadata(this.getAbsolutePath(delimitedMetadataPath)+"/test_delimited.zip");		
		System.err.println("importDelimitedMetadataPathResult>>>>>>>>"+importDelimitedMetadataPathResult);
		int commandImportDelimitedMetadataPathId = this.getCommandId(importDelimitedMetadataPathResult);
		Assert.assertTrue(importDelimitedMetadataPathResult.contains(commandResult+" "+commandImportDelimitedMetadataPathId));
		this.commandlineGetCommandStatusImpl(commandImportDelimitedMetadataPathId, WAIT_TIME);
		
		
	}

	public void commandlineExecuteJobOnServerImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword
			, String serverHost) {
		
		
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);		
		
		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("refJobByMaintRunJobRun"));
		Assert.assertTrue(ss.contains("tRunJob"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));

		String commandExecuteJobOnServerResult = this.executeJobOnServer("tjavaWithMulripleCheckPoint", serverHost);
		System.err.println("commandExecuteJobOnServerResult>>>>>>>>"+commandExecuteJobOnServerResult);
		int commandExecuteJobOnServerId = this.getCommandId(commandExecuteJobOnServerResult);
		Assert.assertTrue(commandExecuteJobOnServerResult.contains(commandResult+" "+commandExecuteJobOnServerId));
		this.commandlineGetCommandStatusImpl(commandExecuteJobOnServerId, WAIT_TIME);
		List<String> executeJobOnServerResult = this.getCommandStatusAllInfo(commandExecuteJobOnServerId);
		
		String executeJobOnServerResultInfo = "";
		for(int i=0; i<executeJobOnServerResult.size(); i++) {			
			
			executeJobOnServerResultInfo = executeJobOnServerResultInfo+executeJobOnServerResult.get(i);
            System.err.println("i>>>>>>>>"+executeJobOnServerResult.get(i));			
			
		}
		System.err.println("executeJobOnServerResultInfo>>>"+executeJobOnServerResultInfo);	
		
		Assert.assertTrue(executeJobOnServerResultInfo.contains("Job STARTED"));
		Assert.assertTrue(executeJobOnServerResultInfo.contains("the first checkpoint"));
		Assert.assertTrue(executeJobOnServerResultInfo.contains("the second checkpoint"));
		Assert.assertTrue(executeJobOnServerResultInfo.contains("the third checkpoint"));
		Assert.assertTrue(executeJobOnServerResultInfo.contains("the fourth checkpoint"));
//		Assert.assertTrue(executeJobOnServerResultInfo.contains("Job ENDED"));
		
	}

	public void commandlineExportJobImpl(String commandResult
			, String project, String userName, String userPassword
			, String url, String root, String exportPath) {		
		
		this.commandlineListJobImpl(commandResult, url, root, project, userName, userPassword);

		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("refJobByMaintRunJobRun"));
		Assert.assertTrue(ss.contains("tRunJob"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));

		String exportJobResult = this.exportJob("tjavaWithMulripleCheckPoint", this.getAbsolutePath(exportPath));
		
		int commandExportJobResultId = this.getCommandId(exportJobResult);
		Assert.assertTrue(exportJobResult.contains(commandResult+" "+commandExportJobResultId));
	    this.commandlineGetCommandStatusImpl(commandExportJobResultId, WAIT_TIME);
	    LinkedHashMap map = this.getFileNameList(this.getAbsolutePath(exportPath));
		Assert.assertTrue(map.containsValue("tjavaWithMulripleCheckPoint.zip"));
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/tjavaWithMulripleCheckPoint.zip");
		new AntAction().runTarget("File.xml", "delete", properties);		
	
	}
	
	public void commandlineExecuteAllJobImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);	
		
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));

		String commandExecuteAllJobResult = this.executeAllJob();
		System.err.println("commandExecuteAllJobResult>>>>>>>>"+commandExecuteAllJobResult);
		int commandExecuteAllJobId = this.getCommandId(commandExecuteAllJobResult);
		Assert.assertTrue(commandExecuteAllJobResult.contains(commandResult+" "+commandExecuteAllJobId));
		this.commandlineGetCommandStatusImpl(commandExecuteAllJobId, WAIT_TIME*3);
		List<String> executeAllJobResult = this.getCommandStatusAllInfo(commandExecuteAllJobId);
		
		String executeAllJobResultInfo = "";
		for(int i=0; i<executeAllJobResult.size(); i++) {			
			
			executeAllJobResultInfo = executeAllJobResultInfo+executeAllJobResult.get(i);
            System.err.println("i>>>>>>>>"+executeAllJobResult.get(i));	
            
		}
		System.err.println("executeAllJobResultInfo>>>"+executeAllJobResultInfo);	
		
		Assert.assertTrue(executeAllJobResultInfo.contains("COMPLETED"));
		Assert.assertTrue(executeAllJobResultInfo.contains("the first checkpoint"));
		Assert.assertTrue(executeAllJobResultInfo.contains("the second checkpoint"));
		Assert.assertTrue(executeAllJobResultInfo.contains("the third checkpoint"));
		Assert.assertTrue(executeAllJobResultInfo.contains("the fourth checkpoint"));
		Assert.assertTrue(executeAllJobResultInfo.contains("JackZhang"));
		Assert.assertTrue(executeAllJobResultInfo.contains("23"));
		Assert.assertTrue(executeAllJobResultInfo.contains("Sat Aug 13 00:00:00 CDT 1988"));
		
	}
	public void commandlineExecuteJobOfVersionOnJobServerImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword
			, String server) {
		
		
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);	
		
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));

		String commandExecuteJobOfVersionOnServerResult = this.executeJobOfVersionOnServer("tjavaWithMulripleCheckPoint", server);
		System.err.println("commandExecuteJobOfVersionOnServerResult>>>>>>>>"+commandExecuteJobOfVersionOnServerResult);
		int commandExecuteJobOfVersionOnServerId = this.getCommandId(commandExecuteJobOfVersionOnServerResult);
		Assert.assertTrue(commandExecuteJobOfVersionOnServerResult.contains(commandResult+" "+commandExecuteJobOfVersionOnServerId));
		this.commandlineGetCommandStatusImpl(commandExecuteJobOfVersionOnServerId, WAIT_TIME*3);
		List<String> executeJobOfVersionOnServerResult = this.getCommandStatusAllInfo(commandExecuteJobOfVersionOnServerId);
		
		String executeJobOfVersionOnServerResultInfo = "";
		for(int i=0; i<executeJobOfVersionOnServerResult.size(); i++) {			
			
			executeJobOfVersionOnServerResultInfo = executeJobOfVersionOnServerResultInfo+executeJobOfVersionOnServerResult.get(i);
            System.err.println("i>>>>>>>>"+executeJobOfVersionOnServerResult.get(i));	
            
		}
		System.err.println("executeJobOfVersionOnServerResultInfo>>>"+executeJobOfVersionOnServerResultInfo);	
		
		Assert.assertTrue(executeJobOfVersionOnServerResultInfo.contains("Job STARTED"));
		Assert.assertTrue(executeJobOfVersionOnServerResultInfo.contains("the first checkpoint"));
		Assert.assertTrue(executeJobOfVersionOnServerResultInfo.contains("the second checkpoint"));
		Assert.assertTrue(executeJobOfVersionOnServerResultInfo.contains("the third checkpoint"));
		Assert.assertTrue(executeJobOfVersionOnServerResultInfo.contains("the fourth checkpoint"));
		Assert.assertTrue(executeJobOfVersionOnServerResultInfo.contains("Job ENDED SUCCESSFULLY"));
		
	}
	
	public void commandlineExecuteRouteImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		
		this.commandlineListItemImpl(commandResult, url, root, commPro, userName, userPassword);		
		
		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("refJobByMaintRunJobRun"));
		Assert.assertTrue(ss.contains("tRunJob"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));
		Assert.assertTrue(ss.contains("test"));
		System.err.println("ss>>>"+ss);	

		String commandExecuteRouteResult = this.executeRoute("test");
		System.err.println("commandExecuteRouteResult>>>>>>>>"+commandExecuteRouteResult);
		int commandExecuteRouteId = this.getCommandId(commandExecuteRouteResult);
		Assert.assertTrue(commandExecuteRouteResult.contains(commandResult+" "+commandExecuteRouteId));
		this.commandlineGetCommandStatusImpl(commandExecuteRouteId, WAIT_TIME);
		
	}
	
	public void commandlineExportRouteImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword
			,String exportPath) {
		
		this.commandlineListItemImpl(commandResult, url, root, commPro, userName, userPassword);
		Assert.assertTrue(ss.contains("test"));
		String commandExportRouteResult = this.exportRoute("test", this.getAbsolutePath(exportPath));
		System.err.println("commandExportRouteResult>>>>>>>>"+commandExportRouteResult);
		int commandExportRouteId = this.getCommandId(commandExportRouteResult);
		Assert.assertTrue(commandExportRouteResult.contains(commandResult+" "+commandExportRouteId));
		this.commandlineGetCommandStatusImpl(commandExportRouteId, WAIT_TIME*3);
		LinkedHashMap map = this.getFileNameList(this.getAbsolutePath(exportPath));
		Assert.assertTrue(map.containsValue("test.zip"));
		properties.put("file.path", this.getAbsolutePath(exportPath)+"test.zip");
		new AntAction().runTarget("File.xml", "delete", properties);
		
	}
	
	public void commandlineExportAllJobWithFiltersImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword
			,String exportPath) {
		
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);
		System.err.println(this.getAbsolutePath(exportPath));
		String ExportAllJobWithFilters = this.exportAllJobWithFilters(this.getAbsolutePath(exportPath),"tjava");
		System.err.println("exportAllJob>>>"+ExportAllJobWithFilters);
	
		int commandExportAllJobWithFiltersId = this.getCommandId(ExportAllJobWithFilters);
		Assert.assertTrue(ExportAllJobWithFilters.contains(commandResult+" "+commandExportAllJobWithFiltersId));
		this.commandlineGetCommandStatusImpl(commandExportAllJobWithFiltersId, WAIT_TIME*2);
				
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/tjava.zip");
		new AntAction().runTarget("File.xml", "available_file", properties);
		properties.put("file.path", this.getAbsolutePath(exportPath)+"/tjava.zip");
		new AntAction().runTarget("File.xml", "delete", properties);	
		System.err.println("***********testCommandlineExportAllJobWithFilters finished***********");
	}
	
	public void commandlineExecuteAllJobWithFiltersImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
      
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);			
		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("refJobByMaintRunJobRun"));
		Assert.assertTrue(ss.contains("tRunJob"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));
		System.err.println("ss>>>"+ss);	

		String commandExecuteAllJobWithFiltersResult = this.executeAllJobWithFilters("tRunJob");
		System.err.println("commandExecuteAllJobWithFiltersResult>>>>>>>>"+commandExecuteAllJobWithFiltersResult);
		int commandExecuteAllJobWithFiltersId = this.getCommandId(commandExecuteAllJobWithFiltersResult);
		Assert.assertTrue(commandExecuteAllJobWithFiltersResult.contains(commandResult+" "+commandExecuteAllJobWithFiltersId));
		this.commandlineGetCommandStatusImpl(commandExecuteAllJobWithFiltersId, WAIT_TIME*3);	
	}
	
	public void commandlineListItemWithFiltersImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		this.commandlineListItemImpl(commandResult, url, root, commPro, userName, userPassword);
		List<String> listCommandListItemResult = this.listItemWithFilters("version=2.0");
		System.err.println("listCommandResult>>>>>>>>"+listCommandListItemResult);
		
		for(int i=0; i<listCommandListItemResult.size(); i++) {
			
			ss = ss+listCommandListItemResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandListItemResult.get(i));			
			
		}
		System.err.println("ss>>>"+ss);	
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
	}
	
	public void commandlineListProjectAndReferenceImpl(String commandResult,String url, String root) {
		
		this.commandlineInitRemoteImpl(commandResult, url, root);
		List<String> listCommandListProjectResult = this.listProjectAndReference();
		System.err.println("listCommandResult>>>>>>>>"+listCommandListProjectResult);
		
		for(int i=0; i<listCommandListProjectResult.size(); i++) {
			
			ss = ss+listCommandListProjectResult.get(i);
            System.err.println("i>>>>>>>>"+listCommandListProjectResult.get(i));			
			
		}
		System.err.println("ss>>>"+ss);	
	}
	

	public void commandlineCreatJobImpl(String commandResult
			, String url, String root, String commPro, String userName,
			String userPassword, String path) {
		
		
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);		
		System.err.println("ss>>>"+ss);	

		Assert.assertFalse(ss.contains("jdGenerateJob"));		
		
		String commandCreatJobResult = this.creatJob(this.getAbsolutePath(path)+"/jdGenerateJob_0.1.jobscript");
		System.err.println("commandCreatJobResult>>>>>>>>"+commandCreatJobResult);
		int commandCreatJobId = this.getCommandId(commandCreatJobResult);
		Assert.assertTrue(commandCreatJobResult.contains(commandResult+" "+commandCreatJobId));
		this.commandlineGetCommandStatusImpl(commandCreatJobId, WAIT_TIME);
		
		String ss1 = "";
		List<String> commandListItemResultInfo = this.listItem();		
		for(int i=0; i<commandListItemResultInfo.size(); i++) {
			
			ss1 = ss1+commandListItemResultInfo.get(i);
            System.err.println("i>>>>>>>>"+commandListItemResultInfo.get(i));			
			
		}
		System.err.println("ss1>>>"+ss1);	
		Assert.assertTrue(ss1.contains("jsJob"));	
		
	}

	public void commandlineExportJobContainsSubjobImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword
			, String path) {
		
		
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);	
		
		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("refJobByMaintRunJobRun"));
		Assert.assertTrue(ss.contains("tRunJob"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("tt"));
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));

		String commandexportJobContainsSubjobResult = this.exportJobContainsSubjob("tRunJob", this.getAbsolutePath(path));
		System.err.println("commandexportJobContainsSubjobResult>>>>>>>>"+commandexportJobContainsSubjobResult);
		int commandexportJobContainsSubjobId = this.getCommandId(commandexportJobContainsSubjobResult);
		Assert.assertTrue(commandexportJobContainsSubjobResult.contains(commandResult+" "+commandexportJobContainsSubjobId));
		this.commandlineGetCommandStatusImpl(commandexportJobContainsSubjobId, WAIT_TIME*3);
		properties.put("unzip.to.dir", this.getAbsolutePath(path)+"/tRunJob.zip");
		new AntAction().runTarget("File.xml", "available_file", properties);	
		properties.put("zip.file", this.getAbsolutePath(path)+"/tRunJob.zip");
		properties.put("unzip.to.dir", this.getAbsolutePath(path)+"unzip");
		new AntAction().runTarget("File.xml", "unzip", properties);	
			
		properties.put("server.home", this.getAbsolutePath(path)+"unzip/tRunJob");
		properties.put("command", "tRunJob_run");
		properties.put("action", " > tRunJob.log");
		new AntAction().runTarget("Server.xml", "server-launcher", properties);			
		
		properties.put("file.path", this.getAbsolutePath(path)+"unzip/tRunJob/tRunJob.log");
		properties.put("context.pattern", "JackZhang");
		
		String isMatch = new AntAction().runTarget("File.xml", "check-file-context", properties, "is.match");
		System.out.println("IsMatch - " + isMatch);
		
		Assert.assertTrue("true".equals(isMatch));
		
		properties.put("file.path", this.getAbsolutePath(path)+"/tRunJob.zip");
		new AntAction().runTarget("File.xml", "delete", properties);
		this.delFolder(this.getAbsolutePath(path)+"unzip");
		
	}
	

	public void commandlineExportJobAndExecuteImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword
			, String path) {
		
		
		this.commandlineListJobImpl(commandResult, url, root, commPro, userName, userPassword);	
		
		Assert.assertTrue(ss.contains("generateBigLogs"));
		Assert.assertTrue(ss.contains("refJobByMaintRunJobRun"));
		Assert.assertTrue(ss.contains("tRunJob"));
		Assert.assertTrue(ss.contains("tjavaWithMulripleCheckPoint"));
		Assert.assertTrue(ss.contains("tjava"));
		Assert.assertTrue(ss.contains("tt"));
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));

		String commandexportJobContainsSubjobResult = this.exportJobContainsSubjob("tRunJob", this.getAbsolutePath(path));
		System.err.println("commandexportJobContainsSubjobResult>>>>>>>>"+commandexportJobContainsSubjobResult);
		int commandexportJobContainsSubjobId = this.getCommandId(commandexportJobContainsSubjobResult);
		Assert.assertTrue(commandexportJobContainsSubjobResult.contains(commandResult+" "+commandexportJobContainsSubjobId));
		this.commandlineGetCommandStatusImpl(commandexportJobContainsSubjobId, WAIT_TIME*3);
		properties.put("unzip.to.dir", this.getAbsolutePath(path)+"/tjavaWithMulripleCheckPoint.zip");
		new AntAction().runTarget("File.xml", "available_file", properties);	
		properties.put("zip.file", this.getAbsolutePath(path)+"/tjavaWithMulripleCheckPoint.zip");
		properties.put("unzip.to.dir", this.getAbsolutePath(path)+"unzip");
		new AntAction().runTarget("File.xml", "unzip", properties);	
			
		properties.put("server.home", this.getAbsolutePath(path)+"unzip/tjavaWithMulripleCheckPoint");
		properties.put("command", "tjavaWithMulripleCheckPoint_run");
		properties.put("action", " > tjavaWithMulripleCheckPoint.log");
		new AntAction().runTarget("Server.xml", "server-launcher", properties);			
		
		properties.put("file.path", this.getAbsolutePath(path)+"unzip/tjavaWithMulripleCheckPoint/tjavaWithMulripleCheckPoint.log");
		properties.put("context.pattern", "the first checkpoint");
		
		String isMatch = new AntAction().runTarget("File.xml", "check-file-context", properties, "is.match");
		System.out.println("IsMatch - " + isMatch);
		
		Assert.assertTrue("true".equals(isMatch));
		
		properties.put("file.path", this.getAbsolutePath(path)+"/tjavaWithMulripleCheckPoint.zip");
		new AntAction().runTarget("File.xml", "delete", properties);
		this.delFolder(this.getAbsolutePath(path)+"unzip");
		
	}

	public void commandlineDeleteItemImpl(String commandResult
			, String url, String root, String commPro, String userName, String userPassword) {
		
		
		this.commandlineListItemImpl(commandResult, url, root, commPro, userName, userPassword);		
		
		Assert.assertTrue(ss.contains("trunjobWithCheckpoint"));
		Assert.assertTrue(ss.contains("test"));
		Assert.assertTrue(ss.contains("PROCESS"));
		Assert.assertTrue(ss.contains("routines"));
		
		System.err.println("ss>>>"+ss);	

		String commandDeleteItemResult = this.deleteItem();
		System.err.println("commandDeleteItemResult>>>>>>>>"+commandDeleteItemResult);
		int commandDeleteItemId = this.getCommandId(commandDeleteItemResult);
		Assert.assertTrue(commandDeleteItemResult.contains(commandResult+" "+commandDeleteItemId));
		this.commandlineGetCommandStatusImpl(commandDeleteItemId, WAIT_TIME);
		
		String ss1 = "";
		List<String> commandListItemResultInfo = this.listItem();		
		for(int i=0; i<commandListItemResultInfo.size(); i++) {
			
			ss1 = ss1+commandListItemResultInfo.get(i);
            System.err.println("i>>>>>>>>"+commandListItemResultInfo.get(i));			
			
		}		
		
		Assert.assertFalse(ss.contains("trunjobWithCheckpoint"));
		Assert.assertFalse(ss.contains("test"));
		Assert.assertTrue(ss.contains("PROCESS"));
		Assert.assertTrue(ss.contains("routines"));
		
	}
	
}
