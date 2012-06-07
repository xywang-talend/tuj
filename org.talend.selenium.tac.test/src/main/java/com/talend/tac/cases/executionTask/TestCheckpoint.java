package com.talend.tac.cases.executionTask;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;

public class TestCheckpoint extends TaskUtils {
	
	String tjavaWithMulripleCheckpointExpectedLogsValue = "the second checkpointthe third checkpointthe fourth checkpoint";
	String tjavaWithMulripleCheckpointAactualLogsValue = null;
	String trunjobWithCheckpointExpectedLogsValue = "ref_23ref_jackzhangref_88-08-13";
	String trunjobWithCheckpointActualLogsValue = null;

	//add method for test checkpoint
	public List<String> checkPoint(String label, String description,String commonpro,String branchName,String jobName,
			String version,String context,String serverName,String statisticName,String xpathOfCheckPoint,String regex) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
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
		this.waitForElementPresent("//label[text()='Ok']", Base.MAX_WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//label[text()='Ok']"));
		selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");//close window of 'Real time statistics'
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//span[text()='Logs']");
		selenium.setSpeed(MIN_SPEED);
		
		/*clear logs*/
		selenium.chooseOkOnNextConfirmation();
		this.waitForElementPresent("idJobConductorJobLogClearLogButton", WAIT_TIME);
		selenium.click("idJobConductorJobLogClearLogButton");
		selenium.setSpeed(MID_SPEED);
		selenium.getConfirmation();
		selenium.setSpeed(MIN_SPEED);
		/*clear logs*/
		
		
		if(selenium.isElementPresent("//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]")) {
	    	
	    	selenium.click("//table[contains(@class,'x-btn x-toolbar-more x-component x-btn-icon')]");
	    	
	    }	
	    
	    selenium.click("idJobConductorTaskRecoverButton");//into Error recovery management page
	    
	    this.clickWaitForElementPresent("//span[text()='Recovery checkpoints']");
	    
	    this.clickWaitForElementPresent(xpathOfCheckPoint);//click checkpoint
	    selenium.setSpeed(MID_SPEED);
	    selenium.click("//button[text()='Launch recovery']");//run the checkpoint
	    selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//label[text()='Ok']", WAIT_TIME);
	    
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");//into task page
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
	    selenium.setSpeed(MIN_SPEED);
	    
		selenium.mouseDown("//span[text()='"+label+"']");
		
		/*check logs*/
		selenium.setSpeed(MID_SPEED);
		selenium.click("//span[text()='Logs']");

		
		if(!selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']")) {
			
			selenium.click("//div[contains(@qtip,'Size')]");
			
		}
		
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']");
		selenium.setSpeed(MIN_SPEED);
		
		String getLogs = selenium.getValue("//textarea[@name='log']");
		
		System.out.println(getLogs);
		
		
		String findedString = "";
		String[] texts;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		List<String> strs = new ArrayList<String>();
		texts = getLogs.split("\n");
		for (int i = 0; i < texts.length; i++) {
		
			matcher = pattern.matcher(texts[i].trim());
			if (matcher.matches()) {
				findedString = texts[i].trim();
				strs.add(findedString);
				continue;
			}
		}
		return strs;

		/*check logs*/
	}
   
	
	//check logs of first checkpoint of tjavaWithMulripleCheckpoint
	@Test
	@Parameters({"taskWithTjavaWithMulripleCheckpoint","labelDescription","addCommonProjectName","branchNameTrunk","tjavaWithMulripleCheckpoint","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testFirstCheckPointOfTjavaWithMulripleCheckpoint(String label, String description,String commonpro,String branchName,String jobName,
			String version,String context,String serverName,String statisticName) {
		List<String> strs = new ArrayList<String>();	
		strs = checkPoint(label, description, commonpro, branchName, jobName, version, context, serverName, statisticName,
           "//img[@title='CONNECTION:SUBJOB_OK:tJava_1:OnSubjobOk']","^the.*");
		
		for(int i=0;i<strs.size();i++) {
			
			System.out.println(strs.get(i));
			tjavaWithMulripleCheckpointAactualLogsValue = strs.get(0)+strs.get(1)+strs.get(2);
			
		}
		
		System.out.println("*-*-*-*-*-"+tjavaWithMulripleCheckpointAactualLogsValue);
		
		Assert.assertEquals(tjavaWithMulripleCheckpointAactualLogsValue, tjavaWithMulripleCheckpointExpectedLogsValue);
		
	}
    
	//check logs of trunjobWithCheckpoint
	@Test
	@Parameters({"taskWithTrunjobWithCheckpoint","labelDescription","addCommonProjectName","branchNameTrunk","trunjobWithCheckpoint","version0.1",
		"context","serverForUseAvailable","statisticEnabled"})
	public void testFirstCheckPointOftrunjobWithCheckpoint(String label, String description,String commonpro,String branchName,String jobName,
			String version,String context,String serverName,String statisticName) {
		
		List<String> strs = new ArrayList<String>();	
		strs = checkPoint(label, description, commonpro, branchName, jobName, version, context, serverName, statisticName,
           "//img[@title='CONNECTION:SUBJOB_OK:tJava_1:OnSubjobOk']","^ref_.*");
		
		for(int i=0;i<strs.size();i++) {
			
			System.out.println(strs.get(i));
			trunjobWithCheckpointActualLogsValue = strs.get(0)+strs.get(1)+strs.get(2);
			
		}
		
		System.out.println("*-*-*-*-*-"+trunjobWithCheckpointActualLogsValue);
		
		Assert.assertEquals(trunjobWithCheckpointActualLogsValue, trunjobWithCheckpointExpectedLogsValue);
		
	}
    	
}
