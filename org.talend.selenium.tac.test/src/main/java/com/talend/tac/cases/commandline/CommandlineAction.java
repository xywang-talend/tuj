package com.talend.tac.cases.commandline;

import java.util.List;

public class CommandlineAction extends Commandline {
	Commandline cmd;
	
	public CommandlineAction(){
		cmd = new Commandline();
	}
	public CommandlineAction(String server, int port){
		cmd = new Commandline(server, port);
	}
	
	public String initLocal(){
		return cmd.command("initLocal");
	}
	
	public String getCommandStatus(int id){
		return cmd.command("getCommandStatus " + id);
	}
	
	public String initRemote(String url){
		return cmd.command("initRemote " + url);
	}
	
	public String logonProject(String project, String user, String passwd){
		return cmd.command("logonProject -pn " + project + " -ul " + user + " -up " + passwd);
	}
	
	public String createProject(String project, String description, String user, String passwd){
		return cmd.command("createProject -pn " + project + " -pd " + description + " -pl java -pa " + user + " -pap " + passwd);
	}
	
	public String exportAllJob(String path){
		return cmd.command("exportAllJob -dd " + path);
	}
	
	public List<String> helpFiltr(){
		return cmd.command("helpFilter" , "----");
	}

	public List<String> help(){
		return cmd.command("help" , "----");
	}

	public String logOffProject(){
		return cmd.command("logoffProject");
	}

	public String importItems(String path){
		return cmd.command("importItems "+path);
	}

	public String exportItems(String path){
		return cmd.command("exportItems "+path);
	}

	public List<String> listCommand(){
		return cmd.command("listCommand -a", "talend>");
	}

	public List<String> listExecutionServer(){
		return cmd.command("listExecutionServer", "talend>");
	}

	public List<String> listJob(){
		return cmd.command("listJob", "talend>");
	}

	public List<String> listProject(){
		return cmd.command("listProject", "talend>");
	}

	public List<String> listItem(){
		return cmd.command("listItem", "talend>");
	}

	public String changeJobVersion(){
		return cmd.command("changeVersion 2.0 -if type=process");
	}

	public List<String> listOtherVersionJob(){
		return cmd.command("listItem -if version=2.0", "talend>");
	}
	
	public List<String> showVersion(){
		return cmd.command("showVersion", "talend>");
	}
	
	public String executeJob(String jobName){
		System.err.println("executeJob "+jobName+" "+"-i "+this.getJDKPath());
		return cmd.command("executeJob "+jobName+" "+"-i "+this.getJDKPath());
	}
	
	public List<String> getCommandStatusAllInfo(int id){
		return cmd.command("getCommandStatus "+id, "talend>");
	}


	public List<String> getCommandStatusAllInfo(int id, String endInfo){
		return cmd.command("getCommandStatus "+id, endInfo);
	}
	
	public String importDatabaseMetadata(String databaseMetadataPath){		
		return cmd.command("importDatabaseMetadata "+databaseMetadataPath);
	}

	public String importDelimitedMetadata(String databaseMetadataPath){		
		return cmd.command("importDelimitedMetadata "+databaseMetadataPath);
	}
	
	public String executeJobOnServer(String jobName, String serverName){
		System.err.println("executeJobOnServer "+jobName+" "+"-es "+serverName);
		return cmd.command("executeJobOnServer "+jobName+" "+"-es "+serverName);
	}

	public String exportJob(String jobName, String exportPath){
		System.err.println("exportJob "+jobName+" "+"-dd "+exportPath);
		return cmd.command("exportJob "+jobName+" "+"-dd "+exportPath);
	}

	public String executeAllJob(){
		System.err.println("executeAllJob -i "+this.getJDKPath());
		return cmd.command("executeAllJob -i "+this.getJDKPath());
	}

	public String executeJobOfVersionOnServer(String jobName, String serverName){
		System.err.println("executeJobOnServer "+jobName+" -es "+serverName+" -jv 2.0");
		return cmd.command("executeJobOnServer "+jobName+" -es "+serverName+" -jv 2.0");
	}

	public boolean isCommandCompleted(int id) {
		return this.getCommandStatus(id).contains("COMPLETED");
	}
	
	public boolean commandStatusCheck(int id, int period, int checkTimes){
		boolean iscompleted = false;
		boolean running = true;
		int count = 0;
		while(running){
			count ++;
			try {
				Thread.sleep(period);
			} catch (InterruptedException e) {
			}
			System.err.println("id "+id+" "+count+" status>>>>>>>"+getCommandStatus(id));
			iscompleted = isCommandCompleted(id);
			if(iscompleted){
				System.out.println("Task Done");
				running = false;
				break;
			} else if(count > checkTimes){
				System.out.println("Haven't finished");
				running = false;
				break;
			}
		}
		return iscompleted;
	}
	
}
