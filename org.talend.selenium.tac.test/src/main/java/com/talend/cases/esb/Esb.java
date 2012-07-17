package com.talend.cases.esb;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Karaf;
import com.talend.tac.cases.Login;
import com.talend.tac.cases.esb.serviceLocator.EsbUtil;


public class Esb extends EsbUtil {
	
	Karaf karaf = null;
//		new Karaf("192.168.0.94", "D:/jar");
	
	
	/**
	 * this method is only to open activity monitor page
	 */
	public void openServiceActivityMonitor(){
		this.clickWaitForElementPresent("!!!menu.serviceactivity.element!!!");
		this.waitForElementPresent("//div[@class='header-title' and text()='Service Activity Monitoring']", WAIT_TIME);
	}
	
	public void sendServiceRequest(String karafURL,String consumerName){
		karaf = new Karaf(karafURL);
		System.out.println("service request send-->  start!");
		karaf.karafAction("job:start "+consumerName+"", 10000);
		System.out.println("service request send-->  ended!");
	}
	
	public void generateEvents(String karafURL,String consumerName,int eventsNum){
		
		karaf = new Karaf(karafURL);
		System.out.println("service request send-->  start!");
		for (int i = 0; i < eventsNum; i++) {
			
			System.out.println(">>>"+getAbsolutePath("org/talend/tac/folder/esb/"+consumerName+"-0.1.jar"));
			karaf.karafAction("install -s file://"+getAbsolutePath("org/talend/tac/folder/esb/"+consumerName+"-0.1.jar")+"", 3000);
			karaf.karafAction("uninstall "+consumerName+"", 3000);
			System.err.println("generate events :"+i);
		}
	}

	
}
