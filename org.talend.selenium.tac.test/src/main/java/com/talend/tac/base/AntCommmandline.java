package com.talend.tac.base;

import java.util.Hashtable;

public class AntCommmandline {
	
	public void startCommand(String talendAllHome, String CommandlineIp, String CommandlinePort){
		AntAction antAction = new AntAction();

		Hashtable properties = new Hashtable();
		properties.put("talend-all.home", talendAllHome);
		properties.put("commandline.ip", CommandlineIp);
		properties.put("commandline.port", CommandlinePort);
		
		antAction.runTarget("Server.xml", "launch-commandline", properties);
	}
	
	public static void main(String[] args){
		AntCommmandline bc = new AntCommmandline();
		bc.startCommand(args[0], args[1], args[2]);
	}
}
