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
}
