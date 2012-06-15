package com.talend.tac.cases.commandline;

import java.util.LinkedHashMap;
import java.util.List;
import org.testng.Assert;

import com.talend.tac.base.AntAction;

public class CommandlineImpls extends CommandlineAction {	
	int randomNum;		
//	CommandlineAction cmdAction;
	CommandStatusChecker csc = new CommandStatusChecker();
	String commandActualStatus;
	public void commandlineInitLocalImpl(String commandResult, String commandStatus) {
		
		String initLocalResult = this.initLocal();
		System.err.println("initLocalResult>>>"+initLocalResult);
		int commandInitLocalId = this.getCommandId(initLocalResult);
		Assert.assertTrue(initLocalResult.contains(commandResult+" "+commandInitLocalId));
//		csc.checking(cmdAction, commandInitLocalId, 1000, 100);
		this.commandlineGetCommandStatusImpl(commandInitLocalId, commandStatus, 40);
		
	}
	
	public void commandlineGetCommandStatusImpl(int commandId, String commandStatus, int waitTime) {
		
		commandActualStatus = this.getCommandStatus(commandId);
		System.err.println("commandStatus>>>"+commandActualStatus);
		
		boolean flag = commandActualStatus.contains(commandStatus);
		if(flag == false) {
			
			for(int i=0; i<=waitTime; i++) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				commandActualStatus = this.getCommandStatus(commandId);
				System.err.println(commandId+">>>"+i+" times"+">>>>>>>>"+commandActualStatus);
				flag = commandActualStatus.contains(commandStatus);			
				if(flag == true) {
					
					break;
					
				}
			}
			
		}
		Assert.assertTrue(commandActualStatus.contains(commandStatus));
		System.err.println("***********testGetCommandStatus finished***********");
		
	}
	
	public void commandlineInitRemoteImpl(String commandResult, String commandStatus
			, String url, String root) {
		
		String initRemoteResult = this.initRemote(url+root);
		System.err.println(url+root);
		System.err.println("initRemoteResult>>>"+initRemoteResult);
		int commandInitRemoteId = this.getCommandId(initRemoteResult);
		System.out.println(">>>>>>>>>>"+initRemoteResult);
		System.out.println(">>>>>>>>>>"+commandResult+" "+commandInitRemoteId);
		Assert.assertTrue(initRemoteResult.contains(commandResult+" "+commandInitRemoteId));
//		csc.checking(cmdAction, commandInitRemoteId, 1000, 100);
		this.commandlineGetCommandStatusImpl(commandInitRemoteId, commandStatus, 100);
		
	}	
	
	public void commandlineLogonProjectImpl(String commandResult, String commandStatus
			, String commPro, String userName, String userPassword, String url, String root) {
		
		this.commandlineInitRemoteImpl(commandResult, commandStatus, url, root);
		System.err.println("commPro>>>"+commPro);
		String logonProject = this.logonProject(commPro, userName, userPassword);
		System.err.println("LogonPtoject>>>"+logonProject);
		int commandLogonProjectId = this.getCommandId(logonProject);
		Assert.assertTrue(logonProject.contains(commandResult+" "+commandLogonProjectId));
//		csc.checking(cmdAction, commandLogonProjectId, 1000, 100);
		this.commandlineGetCommandStatusImpl(commandLogonProjectId, commandStatus, 100);
		
	}	
	
	public void commandlineCreatRemoteProjectImpl(String commandResult, String commandStatus
			, String project, String description, String userName, String userPassword
			, String url, String root) {
		
		randomNum = this.randomNum();
		this.commandlineInitRemoteImpl(commandResult, commandStatus, url, root);
		
		String creatRemoteProjectResult = this.createProject(project+randomNum, description, userName, userPassword);
		System.err.println("creatRemoteProjectResult>>>"+creatRemoteProjectResult);		
		int commandCreatRemoteProjectResultId = this.getCommandId(creatRemoteProjectResult);
		Assert.assertTrue(creatRemoteProjectResult.contains(commandResult+" "+commandCreatRemoteProjectResultId));
//		csc.checking(cmdAction, commandCreatRemoteProjectResultId, 1000, 100);
		this.commandlineGetCommandStatusImpl(commandCreatRemoteProjectResultId, commandStatus, 100);
		
	}
	
	public void commandlineExportAllJobImpl(String commandResult, String commandStatus
			, String exportPath, String commPro, String userName, String userPassword, String url, String root) {
        
		this.commandlineLogonProjectImpl(commandResult, commandStatus, commPro, userName, userPassword, url, root);
		
		System.err.println(this.getAbsolutePath(exportPath));
		String exportAllJob = this.exportAllJob(this.getAbsolutePath(exportPath));
		System.err.println("exportAllJob>>>"+exportAllJob);
	
		int commandExportAllJobId = this.getCommandId(exportAllJob);
		Assert.assertTrue(exportAllJob.contains(commandResult+" "+commandExportAllJobId));
//		csc.checking(cmdAction, commandExportAllJobId, 1000, 100);
		this.commandlineGetCommandStatusImpl(commandExportAllJobId, commandStatus, 100);
		
		LinkedHashMap map = this.getFileNameList(this.getAbsolutePath(exportPath));
		map.containsValue("generateBigLogs.zip");
		map.containsValue("refJobByMaintRunJobRun.zip");
		map.containsValue("tjava.zip");
		map.containsValue("tjavaWithMulripleCheckPoint.zip");
		map.containsValue("tRunJob.zip");
		map.containsValue("trunjobWithCheckpoint.zip");
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
	
    public void commandlineLogoffProjectImpl(String commandResult, String commandStatus, String project, String user, String passwd
    		, String url, String root) {
		
		this.commandlineLogonProjectImpl(commandResult, commandStatus, project, user, passwd, url, root);	
		
		String logoffProjectResult = this.logOffProject();
		System.err.println("logoffProjectResult>>>"+logoffProjectResult);
		int commandLogoffProjectId = this.getCommandId(logoffProjectResult);
		Assert.assertTrue(logoffProjectResult.contains(commandResult+" "+commandLogoffProjectId));
//		csc.checking(cmdAction, commandLogoffProjectId, 1000, 100);
		this.commandlineGetCommandStatusImpl(commandLogoffProjectId, commandStatus, 60);
		System.err.println("***********testCommandlineHelpFiltr finished***********");
		
	}

	public void commandlineCreateLocalProjectImpl(String commandResult, String commandStatus
			, String project, String description, String userName, String userPassword) {
		
		this.commandlineInitLocalImpl(commandResult, commandStatus);
		
		String createLocalProjectResult = this.createProject(project+this.randomNum(), description, userName, userPassword);
		System.err.println("createLocalProjectResult>>>"+createLocalProjectResult);	
		int commandCreateLocalProjectResultId = this.getCommandId(createLocalProjectResult);
		Assert.assertTrue(createLocalProjectResult.contains(commandResult+" "+commandCreateLocalProjectResultId));
//		csc.checking(cmdAction, commandCreateLocalProjectResultId, 1000, 100);
		this.commandlineGetCommandStatusImpl(commandCreateLocalProjectResultId, commandStatus,60);
		
	}
	
	public void commandlineImportItems(String commandResult, String commandStatus
			, String project, String description, String userName, String userPassword
			, String url, String root, String importPath) {		
		
		this.commandlineCreatRemoteProjectImpl(commandResult, commandStatus, project, description, userName, userPassword, url, root);
		System.err.println("logon>>>>>"+project+randomNum);
		this.commandlineLogonProjectImpl(commandResult, commandStatus, project+randomNum, userName, userPassword, url, root);
		
		String importItemsResult = this.importItems(this.getAbsolutePath(importPath+"/imporJobs.zip"));
		
		int commandImportItemsResultId = this.getCommandId(importItemsResult);
		Assert.assertTrue(importItemsResult.contains(commandResult+" "+commandImportItemsResultId));
	    this.commandlineGetCommandStatusImpl(commandImportItemsResultId, commandStatus, 80);
		
	}

	public void commandlineExportItems(String commandResult, String commandStatus
			, String project, String userName, String userPassword
			, String url, String root, String exportPath) {		
		
		this.commandlineLogonProjectImpl(commandResult, commandStatus, project, userName, userPassword, url, root);
		
		String exportItemsResult = this.exportItems(this.getAbsolutePath(exportPath));
		
		int commandExportItemsResultId = this.getCommandId(exportItemsResult);
		Assert.assertTrue(exportItemsResult.contains(commandResult+" "+commandExportItemsResultId));
	    this.commandlineGetCommandStatusImpl(commandExportItemsResultId, commandStatus, 100);
	    LinkedHashMap map = this.getFileNameList(this.getAbsolutePath(exportPath));
		map.containsValue("REFERENCEPRO");
		this.delFolder(this.getAbsolutePath(exportPath+"/REFERENCEPRO"));		
	
	}
	
}
