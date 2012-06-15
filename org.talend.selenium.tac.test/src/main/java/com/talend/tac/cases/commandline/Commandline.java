package com.talend.tac.cases.commandline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Commandline {
	protected String server = "localhost";
	protected int port = 8002;
	Socket socket = null;
	StringBuffer sb = new StringBuffer();
	int timeout = 3000;
	PrintWriter pw;
	BufferedReader br;
	
	public Commandline() {
		if(System.getProperty("commandline.server")!=null)
			this.server = System.getProperty("commandline.server");
		
		if(System.getProperty("commandline.port")!=null)
			this.port = Integer.parseInt(System.getProperty("commandline.port"));
	}
	
	public Commandline(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	public void init(String server, int port, int timeout) throws UnknownHostException, IOException{
		socket = new Socket(server, port);
		socket.setSoTimeout(timeout);
        boolean autoflush = false;
        pw = new PrintWriter(socket.getOutputStream(),autoflush);
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	public void closeConnection() throws IOException{
		pw.close();
		br.close();
		socket.close();
	}
	
	public String command(String server, int port, int timeout, String command) {
		String result = null;
		try {
			this.init(server, port, timeout);
            pw.println(command);
            pw.flush();
			result = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sb.append(result);
		System.out.println("- " + result);
		return result;
	}

	public String command(String command) {
		return this.command(server, port, timeout, command);
	}

	public List<String> command(String server, int port, int timeout, String command, String end) {
		List<String> results = new ArrayList<String>();
		String result = null;
		try {
			socket = new Socket(server, port);
			socket.setSoTimeout(timeout);
            boolean autoflush = false;
            pw = new PrintWriter(socket.getOutputStream(),autoflush);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
            pw.println(command);
            pw.flush();
			
			result = br.readLine();
			
			sb.append(result);
			results.add(result);
			
			while(!"".equals(result) && null!=result && !"\n".equals(result)){
				result = br.readLine();
//				System.out.println("==== " + result);
				sb.append(result.trim() + "\n");
				results.add(result);
				if(result.toLowerCase().contains(end)){
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				this.closeConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return results;
	}
	
	public List<String> command(String command, String end) {
		return this.command(server, port, timeout, command, end);
	}
}
