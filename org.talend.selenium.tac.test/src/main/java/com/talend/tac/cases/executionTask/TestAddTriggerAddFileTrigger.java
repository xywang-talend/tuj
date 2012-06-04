	package com.talend.tac.cases.executionTask;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.AntAction;
import com.talend.tac.base.Base;

public class TestAddTriggerAddFileTrigger extends TaskUtils {  
	
	//test add a cronTrigger use wrong form value
	@Test
	@Parameters({"TaskBaseBranch","addFileTriggerOfExistWrongForm","addFileTriggerOfExistDescriptionWrongForm"
		,"serverForUseAvailable"})
    public void testAddTriggerAddFileTriggerWrongFormValue(String taskLabel,String triggerLabel,String triggerDescription,
    		String serverName) {
    	
		addFileTrigger(taskLabel, triggerLabel, triggerDescription, "ss", "", "", serverName,
				"idJobConductorFileTriggerFtExitCheckBox");
		
		Assert.assertTrue(selenium.isElementPresent("//input[@id='idJobConductorFileTriggerLabelInput']//ancestor::div" +
				"[@class='x-form-item ']//img[@class='gwt-Image x-component ']"));//add assert for "label"  
		Assert.assertTrue(selenium.isElementPresent("//input[@id='idJobConductorFileTriggerCheckTimeIntervalInput']" +
				"//ancestor::div[@class='x-form-item ']//img[@class='gwt-Image x-component ']"));//add assert for "Pollint (s):"  
		Assert.assertTrue(selenium.isElementPresent("//input[@id='idJobConductorFileTriggerFolderPathInput']" +
				"//ancestor::div[@class='x-form-item ']//img[@class='gwt-Image x-component ']"));//add assert for "Folder path:" 
		Assert.assertTrue(selenium.isElementPresent("//input[@id='idJobConductorFileTriggerFileMaskInput']//ancestor::div" +
				"[@class='x-form-item ']//img[@class='gwt-Image x-component ']"));//add assert for "File mask:" 
        
		selenium.click("idFileTriggerSave");
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent("Fix errors in form before save"));
		selenium.setSpeed(MIN_SPEED);
		
	 }
	
	//test add a file trigger
	@Test
	@Parameters({"TaskBaseBranch","addFileTriggerOfExist","addFileTriggerOfExistDescription","FolderPath",
		"FileMaskOfTxt","serverForUseAvailable"})
    public void testAddTriggerAddFileTriggerAddExist(String taskLabel,String triggerLabel,String triggerDescription,
    		String folderPath,String fileMask,String serverName) {
    	
		String FilePath = this.getAbsolutePath(folderPath);		
		System.out.println(FilePath);
		
		AntAction antAction = new AntAction();
		properties.put("file.path", FilePath+"testFiletrigger.txt");
		antAction.runTarget("File.xml", "create", properties);
		
		addFileTrigger(taskLabel, triggerLabel, triggerDescription, "30", FilePath, fileMask, serverName,
				"idJobConductorFileTriggerFtExitCheckBox");
		
		selenium.setSpeed(MIN_SPEED);
		this.refreshTaskStatus(50000, taskLabel, "Running...");
		this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Running...']", Base.MAX_WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Running...']"));
		
		
	}
	
	//test add a	file trigger of label is exist
	@Test
	@Parameters({"TaskBaseBranch","addFileTriggerOfExist","addFileTriggerOfExistDescription","FolderPath",
		"FileMaskOfTxt","serverForUseAvailable"})
    public void testAddTriggerAddFileTriggerAddExistOfLabelExist(String taskLabel,String triggerLabel,String triggerDescription,
    		String folderPath,String fileMask,String serverName) {    	
		
		addFileTrigger(taskLabel, triggerLabel, triggerDescription, "60", folderPath, fileMask, serverName,
				"idJobConductorFileTriggerFtExitCheckBox");
		
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isTextPresent(rb.getString("trigger.error.uniqueLabel")));
		selenium.setSpeed(MIN_SPEED);
		
	}	
	
	//FileTriiger with Exist option is no longer executed after deletion of the cheked file
	@Test
	@Parameters({"taskForTestFileTrigger","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled", "addFileTriggerOfCheckExistOption",
		"addFileTriggerOfExistDescription","FolderPath",
		"FileMaskOfXml"})
	public void testFileTriigerWithExistOptionIsNoLongerExecutedAfterDeletionOfTheChekedFile(String label,
			String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic, String fileTriggerLabel,
			String fileTriggerDesc, String folderPath, String fileMask) {
		
		
		this.addTask(label, labelDescription, commonpro, branch, jobName,
				version, context, jobServer, statistic);
		
		String FilePath = this.getAbsolutePath(folderPath);		
		System.out.println(FilePath);
		
		AntAction antAction = new AntAction();
		properties.put("file.path", FilePath+"testFileTrigger.xml");
		antAction.runTarget("File.xml", "create", properties);	
		
		this.addFileTrigger(label, fileTriggerLabel, labelDescription, "40",
				FilePath, fileMask, jobServer,
				"idJobConductorFileTriggerFtExitCheckBox");	
		
		selenium.setSpeed(MIN_SPEED);
		this.waitForElementPresent("//span[text()='"+label+"']//ancestor::tr" +
				"//span[text()='Running...']", Base.MAX_WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']//ancestor::tr" +
				"//span[text()='Running...']"));		
		

		this.waitForElementPresent("//span[text()='"+label+"']//ancestor::tr" +
				"//span[text()='Ready to run']", Base.MAX_WAIT_TIME);
		
		AntAction antAction1 = new AntAction();
		antAction1.runTarget("File.xml", "delete", properties);	
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int logsConut = this.getXpathCount("//div[contains(@class,'x-grid3-" +
				"cell-inner x-grid3-col-startDate')]");
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.clickWaitForElementPresent("//span[text()='Logs']//ancestor::div[contains(@class,'x-tab-panel" +
				" x-component')]//td[11]/table[contains(@class,'x-component x-unselectable')]//button");
		int logsConutAfterDeleteFile = this.getXpathCount("//div[contains(@class,'x-grid3-" +
		"cell-inner x-grid3-col-startDate')]");
		
		Assert.assertEquals(logsConut, logsConutAfterDeleteFile);
		
		this.clearTask(label);
		
	}
	
	/**Check that the "Created" option does work, Check
	that task is executed only one time after the creation of the file.**/
	@Test
	@Parameters({"taskForTestFileTriggerOfCreationOption","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled", "FileTrigger1",
		"addFileTriggerOfExistDescription","FolderPath",
		"FileMaskOfCvs"})
	public void testCreateFileTriggerCheckCreatedOption(String label,
			String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic, String fileTriggerLabel,
			String fileTriggerDesc, String folderPath, String fileMask) {
		
		this.createFileTriggerCheckCreatedOption(label, labelDescription, commonpro, branch, jobName, version,
				context, jobServer, statistic, fileTriggerLabel, fileTriggerDesc, folderPath, fileMask, "withBackslash");
		
	}
	
	
	/**Check that the "Modified" option does work, Check
	that task is executed only one time after the modification of the file.**/
	@Test
	@Parameters({"taskForTestFileTriggerOfModifiedOption","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled", "FileTrigger3",
		"addFileTriggerOfExistDescription","FolderPath",
		"FileMaskOfLog"})
	public void testCreateFileTriggerCheckModifiedOption(String label,
			String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic, String fileTriggerLabel,
			String fileTriggerDesc, String folderPath, String fileMask) {
		
		this.createFileTriggerCheckModifiedOption(label, labelDescription, commonpro, branch, jobName, version,
				context, jobServer, statistic, fileTriggerLabel, fileTriggerDesc, folderPath, fileMask, "withBackslash");
		
	}
	

	/**input the path like "c:\task" and Check that the "Created" option does work, Check
	that task is executed only one time after the creation of the file.**/
	@Test
	@Parameters({"taskForTestFileTriggerOfCreationOptionFilePathNotWithLastBackslash","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled", "FileTrigger2",
		"addFileTriggerOfExistDescription","FolderPathNotWithLastBackslash",
		"FileMaskOfCvs"})
	public void testCreateFileTriggerCheckCreatedOptionFilePathNotWithLastBackSlash(String label,
			String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic, String fileTriggerLabel,
			String fileTriggerDesc, String folderPath, String fileMask) {
		
		this.createFileTriggerCheckCreatedOption(label, labelDescription, commonpro, branch, jobName, version,
				context, jobServer, statistic, fileTriggerLabel, fileTriggerDesc, folderPath, fileMask, "NotWithBackslash");
		
	}
	
	
	/**input the path like "c:\task" and Check that the "Modified" option does work, Check
	that task is executed only one time after the modification of the file.**/
	@Test
	@Parameters({"taskForTestFileTriggerOfModifiedOptionFilePathNotWithLastBackslash","labelDescription","addCommonProjectName","branchNameTrunk","jobNameTJava","version0.1",
		"context","serverForUseAvailable","statisticEnabled", "FileTrigger4",
		"addFileTriggerOfExistDescription","FolderPathNotWithLastBackslash",
		"FileMaskOfLog"})
	public void testCreateFileTriggerCheckModifiedOptionFilePathNotWithLastBackSlash(String label,
			String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic, String fileTriggerLabel,
			String fileTriggerDesc, String folderPath, String fileMask) {
		
		this.createFileTriggerCheckModifiedOption(label, labelDescription, commonpro, branch, jobName, version,
				context, jobServer, statistic, fileTriggerLabel, fileTriggerDesc, folderPath, fileMask, "NotWithBackslash");
		
	}
	
}
