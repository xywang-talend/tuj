package com.talend.tac.cases.commandline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Commandline {

	public StringBuffer runCommand(String server, int port, String command) throws UnknownHostException, IOException{
		StringBuffer sb = new StringBuffer();
		Socket s = new Socket(server, port);
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		
		command = command+"\n";
		os.write(command.getBytes());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String r = br.readLine();
		sb.append(r);
		while(!"".equals(r) && null!=r && !"\n".equals(r)){
			r = br.readLine();
			sb.append(r + "\n");
			if(r.contains("Copyright (C)") && r.contains("www.talend.com")) {
				r = br.readLine();
				sb.append(r);
				break;
			}
		}
		System.out.println(sb);
		return sb;
	}
}
