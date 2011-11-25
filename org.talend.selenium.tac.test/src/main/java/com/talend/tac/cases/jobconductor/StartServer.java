package com.talend.tac.cases.jobconductor;

import java.io.IOException;

public class StartServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public void run(){
		String path = "E://org.talend.remote.jobserver_4.2.0NB_r55432//org.talend.remote.jobserver_4.2.0NB_r55432//start_rs.bat";
		String commandstr = "cmd /c start " + path; 
		try {
			Process p=Runtime.getRuntime().exec(commandstr);
			Thread.sleep(1000000);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new StartServer().run();
	}

}
