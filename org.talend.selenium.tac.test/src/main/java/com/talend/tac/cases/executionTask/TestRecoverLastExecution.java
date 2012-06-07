package com.talend.tac.cases.executionTask;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRecoverLastExecution extends AddTask {
	
	String expectedLogsValue = "the second checkpointthe third checkpointthe fourth checkpoint";
	String actualLogsValue = null;
	
	//check logs of first checkpoint of tjavaWithMulripleCheckpoint
	@Test
	@Parameters({"taskWithTjavaWithMulripleCheckpoint","labelDescription","addCommonProjectName","branchNameTrunk","tjavaWithMulripleCheckpoint","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testFirstCheckPointOfTjavaWithMulripleCheckpoint(String label, String description,String commonpro,String branchName,String jobName,
			String version,String context,String serverName,String statisticName) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
	    selenium.setSpeed(MIN_SPEED);
	    
	    this.addTask(label, description, commonpro, branchName, jobName, version, context, serverName, statisticName);
	    
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}
		
		selenium.mouseDown("//span[text()='"+label+"']");
		selenium.setSpeed(MID_SPEED);
		selenium.click("//button[@id='idJobConductorTaskRunButton' and text()='Run']");//click Run button
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//span[text()='Real time statistics']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Real time statistics']"));
		this.waitForElementPresent("//label[text()='Ok']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");//close window of 'Real time statistics'
		
		if(selenium.isElementPresent("//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]")) {
	    	
	    	selenium.click("//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]");
	    	
	    }	
	    
	    selenium.click("idJobConductorTaskRecoverButton");//into 
	    
	    this.clickWaitForElementPresent("//span[text()='Recovery checkpoints']");
	    
	    this.clickWaitForElementPresent("//img[@title='CONNECTION:SUBJOB_OK:tJava_1:OnSubjobOk']");
	    selenium.setSpeed(MID_SPEED);
	    selenium.click("//button[text()='Launch recovery']");
	    selenium.setSpeed(MIN_SPEED);
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[text()='"+rb.getString("menu.jobConductor")+"']"));
	    selenium.setSpeed(MIN_SPEED);
	    
		selenium.mouseDown("//span[text()='"+label+"']");
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//span[text()='Logs']");
		selenium.setSpeed(MIN_SPEED);
		
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']");
		
		String getLogs = selenium.getValue("//textarea[@name='log']");
		
		System.out.println(getLogs);
		
		List<String> strs = new ArrayList<String>();
		String findedString = "";
		String[] texts;
		Pattern pattern = Pattern.compile("^the.*");
		Matcher matcher;

		// System.out.println(text);
		texts = getLogs.split("\n");
		for (int i = 0; i < texts.length; i++) {
			// System.out.println("text " + i +": " + texts[i]);
			matcher = pattern.matcher(texts[i].trim());
			if (matcher.matches()) {
				findedString = texts[i].trim();
				strs.add(findedString);
				// System.out.println(texts[i].trim());
				continue;
			}
		}
		
	    
		for(int i=0;i<strs.size();i++) {
			
			System.out.println(strs.get(i));
			actualLogsValue = strs.get(0)+strs.get(1)+strs.get(2);
	        	      		
		}
		
		System.out.print("*-*-*-*-*-"+actualLogsValue);
		
		Assert.assertEquals(actualLogsValue, expectedLogsValue);
		
	}
    
    	
}
