package com.talend.tac.base;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.client.future.ConnectFuture;
import org.apache.sshd.common.RuntimeSshException;

public class Karaf {
    private String host = "localhost";
    private int port = 8101;
    private String user = "karaf";
    private String password = "karaf";
    

    public Karaf(String host){
    	this.host = host;
    }
    
    private SshClient client = null;
    private ClientSession session = null;
    private ClientChannel channel;
	
	private InputStream string2Input(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}
	
	private String[] arrayAppend(String array[], String append) {
		for(int i=0; i<array.length; i++) {
			array[i] = array[i]+append;
		}
		return array;
	}
	
	private String array2String(String array[]){
		String str = "";
		for(String element:array) {
			str = str + element;
		}
		return str;
	}
	
	private ClientSession connectKaraf(){
        client = SshClient.setUpDefaultClient();
        client.start();
        
        try {
			do {
				ConnectFuture future = client.connect(host, port);
				future.await();
				try {
					session = future.getSession();
				} catch (RuntimeSshException  e) {
					e.printStackTrace();
				}
			} while (session==null);
			session.authPassword(user, password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}
	
	private void action(InputStream input, int timeout){
		try {
			channel = session.createChannel("shell");
//      channel.setIn(System.in);
			channel.setIn(input);
			channel.setOut(System.out);
			channel.setErr(System.err);
			channel.open();
			channel.waitFor(ClientChannel.STDOUT_DATA, timeout);
		} catch (Throwable t) {
          t.printStackTrace();
          System.exit(1);
		} finally {
			try {
				client.stop();
			} catch (Throwable t) { }
		}
		System.exit(0);
	}
	
	private void doAction(String action, int timeout){		
		action(string2Input(action+"\n"),timeout);
	}
	
	private void doActions(String actions[], int timeout){
		action(string2Input(array2String(arrayAppend(actions,"\n"))),timeout);
	}
	
	private void doKarafAction(String action, int timeout){
		connectKaraf();
		doAction(action, timeout);
	}
	
	private void doKarafActions(String actions[], int timeout){
		connectKaraf();
		doActions(actions, timeout);
	}
	
	public void karafAction(String action, int timeout){
		AntAction antAction = new AntAction();
		
		Hashtable properties = new Hashtable();
		properties.put("karaf.path", new Base().getAbsolutePath(""));
		
		System.out.println(new Base().getAbsolutePath(""));
		properties.put("host", host);
		properties.put("action", action);
		properties.put("timeout", timeout);
		
		antAction.runTarget("Karaf.xml", properties);
		
		try {
			Thread.sleep(timeout + 3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * host, action, timeout
	 * @param args
	 */
	public static void main(String[] args) {
		Karaf karaf = new Karaf(args[0]);
		String action ="";
		for(int i=1; i<args.length -1; i++) {
			action = action + " " + args[i];
		}
		
		karaf.doKarafAction(action, Integer.parseInt(args[args.length-1]));
	}
}
