package com.talend.tac.cases.commandline;

public class CommandStatusChecker{
	private CommandlineAction cmdAction;
	private int id;
	private boolean flag = false;
	
	public void checking(CommandlineAction cmdAction, int id, long period, int checkTimes){
		this.cmdAction = cmdAction;
		this.id = id;
		Checker checker = new Checker(period, checkTimes);
		Thread thread = new Thread(checker);
		thread.start();
	}
	
	private class Checker implements Runnable{
		private long period;
		private int checkTimes;
		private boolean running = true ; 
		int count = 0;
		public Checker(long period, int checkTimes){
			this.period = period;
			this.checkTimes = checkTimes;;
		}
		
		public void run() {
			while(running){
				count ++;
				try {
					Thread.sleep(period);
				} catch (InterruptedException e) {
				}
				flag = cmdAction.isCommandCompleted(id);
				if(flag){
					System.out.println("Task Done");
					this.shutDownThread();
					break;
				} else if(count > checkTimes){
					System.out.println("Haven't finished");
					this.shutDownThread();
					break;
				}
			}
		}
	    private synchronized void shutDownThread() {
	    	running = false ;
	    }
	    private synchronized boolean isShutDown() {
	        return running;
	    } 
	}
}
