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
