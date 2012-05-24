package com.talend.tac.cases.executionTask;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.AntAction;
import com.talend.tac.base.Base;
import com.talend.tac.cases.Login;
import com.talend.tac.cases.executePlan.TriggerDate;

public class TaskUtils extends Login {
   
    TriggerDate date = new TriggerDate();
	Hashtable properties = new Hashtable();
	
    boolean success;
    public BufferedReader bufread;
	public BufferedWriter bufwriter;
	File writefile;
	String filepath,filecontent,read;
	String readStr="";
			
	//get xpath count of same xpath
	public int getXpathCount(String xpath) {
		
		selenium.setSpeed(MID_SPEED);
		selenium.click("//span[text()='Logs']");
		selenium.setSpeed(MIN_SPEED);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Number xpathConut = selenium.getXpathCount(xpath);
		int i = xpathConut.intValue();
		
		System.out.println("*-*-*-*-*-*"+i);
		return i;
		
	}
	
  //add method for test change trigger name	
	public void renameTrigger(String taskLabel, String labelBeforeModify, String labelAfterModified, 
			String description ,String triggerType) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");//into JobConductor page
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	Assert.assertTrue(selenium.isElementPresent("//span[text()='"+taskLabel+"']"));  
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task    	  	
    		
    	this.waitForElementPresent("//span[text()='"+labelBeforeModify+"']", WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+labelBeforeModify+"']")); 
	    selenium.setSpeed(MIN_SPEED);
    	selenium.mouseDown("//span[text()='"+labelBeforeModify+"']");//select a exist trigger 
    	
    	if(selenium.isElementPresent("idJobConductor"+triggerType+"TriggerLableInput")) {
    		
    		this.typeString("idJobConductor"+triggerType+"TriggerLableInput", labelAfterModified);//modify label
    		
    	} else {
    		
    		this.typeString("idJobConductor"+triggerType+"TriggerLabelInput", labelAfterModified);//modify label
    		                 
    	}
    	
        this.typeString("idJobConductor"+triggerType+"TriggerDescInput", description);//modify description
         
        if(selenium.isElementPresent("//input[@id='idJobConductorFileTriggerFileServerListBox']/parent::div//div[@class='x-form-trigger x-form-trigger-arrow ']")) {
    		
        	selenium.click("//input[@id='idJobConductorFileTriggerFileServerListBox']/parent::div//div[@class='x-form-trigger x-form-trigger-arrow ']");
    		this.waitForElementPresent("//div[text()='use_server_available']", WAIT_TIME);
    		selenium.mouseDown("//div[text()='use_server_available']");
        
        }
	   
        if(selenium.isElementPresent("id"+triggerType+"tTriggerSave")) {
        	
        	selenium.click("id"+triggerType+"tTriggerSave");//click save button
        	
        } else {
        	
        	selenium.click("id"+triggerType+"TriggerSave");//click save button
        	
        }
   		
        if(!selenium.isElementPresent("//span[text()='"+labelAfterModified+"']")) {
        	
    		selenium.click("idTriggerRefresh");//click refresh button
        	
        }

        selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(!selenium.isElementPresent("//span[text()='"+labelBeforeModify+"']"));
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+labelAfterModified+"']"));
		selenium.setSpeed(MIN_SPEED);
		
	}
	
	
    
    public boolean runtask(String tasklabel,int waitTime) throws InterruptedException {
		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + tasklabel + "']",
				WAIT_TIME);
		selenium.mouseDown("//span[text()='" + tasklabel + "']");
		Thread.sleep(3000);
		selenium.click("//button[@id='idJobConductorTaskRunButton'  and @class='x-btn-text ' and text()='Run']");
//		Date start = new Date();	
	    if(this.waitForCondition("//span[text()='"+tasklabel+"']//ancestor::tr" +
				"//span[text()='Error while generating job']", waitTime)) {
	    	return false;
	    	
	    } else {	
			success = (waitForCondition("//label[text()='Ok']", waitTime));
			// close the pop window
			selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
			// System.out.println(checkContextValue(start));
			return success;
	    }
	}
	    
    public boolean waitForCondition(String locator,int seconds) throws InterruptedException{
		boolean conditionPresent = true;
		for (int second = 0;; second++) {
			if (second >= seconds){
				conditionPresent = false;
				break;
			}
			
				if (selenium.isElementPresent(locator)){
					break;
				}
				else{
				Thread.sleep(1000);
			    } 
		}
		
		return conditionPresent;
	}   
    
    
	//into JobConductor page
	public void intoJobConductor(String taskLabel) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
	    selenium.setSpeed(MIN_SPEED);
	    
	    this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
	    selenium.mouseDown("//span[text()='"+taskLabel+"']");//select an exist task
	    						
	}
	
  //creat a method of add task
	public void addTask(String label, String description, String projectName, String branchName,
			 String jobName, String version, String context,
			 String serverName, String statisticName) {
//		itemName = "job";
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
        selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
	    selenium.setSpeed(MIN_SPEED);
	    selenium.click("idSubModuleAddButton");
		this.typeString("idJobConductorTaskLabelInput", label);//plan name /Label
		this.typeString("idJobConductorTaskDescInput", description);//plan name /Label
    	
    	if(!selenium.isChecked("idJobConductorTaskActiveListBox")) {
    		
    		selenium.click("idJobConductorTaskActiveListBox");//check active
        	Assert.assertTrue(selenium.isChecked("idJobConductorTaskActiveListBox"));	
    		
    	}    
    	this.selectDropDownList("idTaskProjectListBox", projectName);
    	this.selectDropDownList("idTaskBranchListBox", branchName);
    	
    	if(selenium.isElementPresent("idItemListCombo")) {
    		this.selectDropDownList("idItemListCombo", "job");
    	}
    	

 	    if(selenium.isElementPresent("idTaskApplicationListBox")) {
    		
 	    	this.selectDropDownList("idTaskApplicationListBox", jobName);
    	
    	} else {

    		this.selectDropDownList("idTaskJobListBox", jobName);
        	
    	}
    	
    	this.selectDropDownList("idTaskVersionListBox", version);
    	this.selectDropDownList("idTaskContextListBox", context);
    	this.selectDropDownList("idJobConductorExecutionServerListBox", serverName);
    	this.selectDropDownList("idJobConductorTaskStatisticsListBox", statisticName);
    	this.selectDropDownList("idJobConductorOnUnavailableJobServerListBox", "Wait");    	
    	
    	if(!selenium.isElementPresent("//span[text()='"+label+"']")) {	
			selenium.click("idFormSaveButton");
	        this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
						
		}		
		
	}
	
	//creation method for generate/deploy/run task
	public void generateDeployRunTask(String taskLabel, String buttonXpath) {
		
    	this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");//into executiontask page
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select an simple task
    	selenium.click(buttonXpath);//click function button
          	
	}
	
	//creation method for change commandline host address
	public void changeCommandLineConfig(String hostAddress) {
		
		selenium.refresh();
		this.clickWaitForElementPresent("idMenuConfigElement");//into Configuration page
		this.waitForElementPresent("//div[contains(text(),'CommandLine/primary')]", WAIT_TIME);
		selenium.mouseDown("//div[contains(text(),'CommandLine/primary')]");
		this.clickWaitForElementPresent(other.getString("commandline.conf.primary.host.editButton"));
		this.waitForElementPresent(other.getString("commandline.conf.primary.host.input"), WAIT_TIME); 
		System.out.println("*--------------*");
		this.typeString(other.getString("commandline.conf.primary.host.input"),hostAddress);
		selenium.setSpeed("2000");
//		assertEquals(selenium.getText(other.getString("commandline.conf.primary.host.value")), hostAddress);
		selenium.setSpeed("0");
			
	}
	
	 //creat a add trigger method(addSimpleTrigger)
    public void addSimpleTrigger(String taskLabel, String triggerlabel, String triggerdescription, TriggerDate startDate
    		, TriggerDate endDate, String triggerCount, String repeatInterval, String type) {
    	this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);		
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("idTriggerAdd simple trigger");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
        
        this.typeString("idJobConductorSimpleTriggerLableInput", triggerlabel);//label
		
        this.typeString("idJobConductorSimpleTriggerDescInput", triggerdescription);//description
   
       
    	
        //######################################################################################3
        System.out.println("+++----"+endDate.days);
        System.out.println("+++----"+date.getCurrent().days); 	
    	if("future".equals(type)) {
    		selenium.click("//label[text()='Start time:']/parent::div//img");//start date
    		if(date.isClickFutureMonthButton(startDate)) {//type in start time
    			
            	selenium.setSpeed(MID_SPEED);
            	selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-right-icon x-component']");
            	selenium.click("//td[@class='x-date-active']/a/span[text()='"+startDate.days+"']");
            	selenium.setSpeed(MIN_SPEED);
            	
            }
            
        	else{//click tianshu}  
            	selenium.setSpeed(MID_SPEED);
            	selenium.click("//td[@class='x-date-active']/a/span[text()='"+startDate.days+"']");
            	selenium.setSpeed(MIN_SPEED);
            	
            }
    		selenium.click("//label[text()='End time:']/parent::div//img");//start date
    		if(date.isClickFutureMonthButton(endDate)) {//type in start time
    			
            	selenium.setSpeed(MID_SPEED);
            	selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-right-icon x-component']");
            	selenium.click("//td[@class='x-date-active']/a/span[text()='"+endDate.days+"']");
            	selenium.setSpeed(MIN_SPEED);
            	
            }
            
        	else{//click tianshu}  
            	selenium.setSpeed(MID_SPEED);
            	selenium.click("//td[@class='x-date-active']/a/span[text()='"+endDate.days+"']");
            	selenium.setSpeed(MIN_SPEED);
            	
            }  
    		
    	} 
    	
    	
    	else {
    	
    		selenium.click("//label[text()='Start time:']/parent::div//img");//start date
    	
    	    if(date.isClickPastMonthButton(startDate)) {//type in start time
    			
            	selenium.setSpeed(MID_SPEED);
            	selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component']");
            	selenium.click("//td[@class='x-date-active']/a/span[text()='"+startDate.days+"']");
            	selenium.setSpeed(MIN_SPEED);
            	
            } else{//click tianshu}  
            	selenium.setSpeed(MID_SPEED);
            	
            	if((startDate.days).equals(date.getCurrent().days)) {
            		
            		selenium.click("//td[contains(@class,'x-date-today')]//span[text()='"+startDate.days+"']");
            		
            	} else {
            		
            		selenium.click("//td[@class='x-date-active']/a/span[text()='"+startDate.days+"']");
            	
            	}
            	
            	selenium.setSpeed(MIN_SPEED);
            	
            } 
    		selenium.click("//label[text()='End time:']/parent::div//img");//start date
    		if(date.isClickPastMonthButton(endDate)) {//type in start time
    			
            	selenium.setSpeed(MID_SPEED);
            	selenium.click("//div[@class=' x-icon-btn x-nodrag x-date-left-icon x-component']");
            	selenium.click("//td[@class='x-date-active']/a/span[text()='"+endDate.days+"']");
            	selenium.setSpeed(MIN_SPEED);
            	
            }  else{//click tianshu}  
            	selenium.setSpeed(MID_SPEED);
                        	
            	if((endDate.days).equals(date.getCurrent().days)) {
            		
            		selenium.click("//td[contains(@class,'x-date-today')]//span[text()='"+endDate.days+"']");
            		            	
            	} else {
            		
            		selenium.click("//td[@class='x-date-active']/a/span[text()='"+endDate.days+"']");
            	
            	}
            	
            	selenium.setSpeed(MIN_SPEED);
    		
    	   }
    	
    	}
        this.typeString("idJobConductorSimpleTriggerRptCountInput", triggerCount);//Number of triggerings
	   
        this.typeString("idJobConductorSimpleTriggerRptIntervalInput", repeatInterval);//Time interval (s)
	    
    }    
    
    //creat a add trigger method(addCronTrigger)
	public void addTriggerAddCronTrigger(String taskLabel,String labelCronTrigger, String descriptionSronTrigger,String years,
			String weeksStart, String weeksEnd, String monthsStart, String monthsEnd) {
    	this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("idTriggerAdd CRON trigger");//add a  CronTrigger
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addCronTrigger")+"']"));
		selenium.setSpeed(MIN_SPEED);
		this.typeString("idJobConductorCronTriggerLabelInput", labelCronTrigger);//label

		this.typeString("idJobConductorCronTriggerDescInput", descriptionSronTrigger);//description
			
		selenium.click("idSchedulingUiConfigButton");//choose data

		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='"+years+"']");//choose years
		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='"+weeksStart+"']");//choose day of weeks
		selenium.shiftKeyDown();
		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='"+weeksEnd+"']");
		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='"+monthsStart+"']");//choose months
		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='"+monthsEnd+"']");
		selenium.mouseDown("//div[@class='x-column-inner']/div[2]/div[2]/div/div/div[text()='00']");//choose hours
		selenium.mouseDown("//div[@class='x-column-inner']/div[2]/div[2]/div/div/div[text()='23']");
		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='00']");//choose minutes
		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='29']");
		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='30']");
		selenium.mouseDown("//div[contains(@class,'x-view-item') and text()='59']");
		selenium.shiftKeyUp();
		selenium.click("idSchedulingApplyButton");//save data
		
	}
	
	//creat method(addFileTrigger) for test add file trigger
	public void addFileTrigger(String taskLabel, String triggerLabel, String triggerDescription,
			 String intervalTime, String folderPath, String fileMask, String serverName, String xpathOfTriggerOption) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task
    	
    	if(!selenium.isChecked("idJobConductorTaskActiveListBox")) {
    		
    		selenium.click("idJobConductorTaskActiveListBox");//check active
        	Assert.assertTrue(selenium.isChecked("idJobConductorTaskActiveListBox"));
        	selenium.click("idFormSaveButton");
    		
    	}
    
    	
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task again
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("idTriggerAdd file trigger");//add a FileTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addFileTrigger")+"']"));
		
    	this.typeString("idJobConductorFileTriggerLabelInput", triggerLabel);//label
				                                                                     
		this.typeString("idJobConductorFileTriggerDescInput", triggerDescription);//description
		
		this.typeString("idJobConductorFileTriggerCheckTimeIntervalInput", intervalTime);//checkTimeInterval
		
		this.typeString("idJobConductorFileTriggerFolderPathInput", folderPath);//folderPath
		
		this.typeString("idJobConductorFileTriggerFileMaskInput", fileMask);//fileMask
		
		selenium.click(xpathOfTriggerOption);//select a trigger option
		Assert.assertTrue(selenium.isChecked(xpathOfTriggerOption));
	
        this.selectDropDownList("idJobConductorFileTriggerFileServerListBox", serverName);
		
		selenium.click("idFileTriggerSave");
	
		if(!selenium.isElementPresent("//span[text()='"+triggerLabel+"']")) {
			selenium.click("idTriggerRefresh");
    	}
		
		if(!selenium.isElementPresent("//input[@name='label']//ancestor::" +
				"div[@class='x-form-item ']//img[@class='gwt-Image x-component ']")) {
			
			this.waitForElementPresent("//span[text()='"+triggerLabel+"']", WAIT_TIME);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+triggerLabel+"']"));
			
		}
		
		
	}
	 //add a method of remove tasks
	public void clearTask(String taskLabel) {
		
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
		selenium.setSpeed(MIN_SPEED);
	    selenium.click("idSubModuleRefreshButton"); //click "Refresh"
		
		if(selenium.isElementPresent("//span[text()='"+taskLabel+"']")) {
			
			selenium.mouseDown("//span[text()='"+taskLabel+"']");//select  exist task
			selenium.chooseOkOnNextConfirmation();
			selenium.chooseOkOnNextConfirmation();
			selenium.click("idSubModuleDeleteButton");//clcik "Delete"
			selenium.getConfirmation();
			Assert.assertTrue((selenium.getConfirmation()).contains("you want to remove all of the related logs and archives"));
			
		} else {
			
			System.out.println("the task is not exist");
			
		}
				
	}
	
    //add a method of remove triggers
    public void clearTriggers(String taskLabel) {
    	
    	this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task
    	selenium.setSpeed(MID_SPEED);
    	if(selenium.isElementPresent("//span[text()='Triggers']/parent::span/parent::em/parent::a/parent::li/" +
    			"parent::ul/parent::div/parent::div/parent::div/parent::div//div[@class='x-grid3-cell-inner" +
    			" x-grid3-col-label']")) {
    	   
    		selenium.setSpeed(MIN_SPEED);	
			for(int i=0;;i++) {
				
				selenium.setSpeed(MID_SPEED);
			 	if(selenium.isElementPresent("//span[text()='Triggers']/parent::span/parent::em/parent::a/parent::li/" +
		    			"parent::ul/parent::div/parent::div/parent::div/parent::div//div[@class='x-grid3-cell-inner" +
		    			" x-grid3-col-label']")) {
				   
			 		selenium.setSpeed(MIN_SPEED);
					selenium.mouseDown("//span[text()='Triggers']/parent::span/parent::em/parent::a/parent::li/" +
					"parent::ul/parent::div/parent::div/parent::div/parent::div//div[@class='x-grid3-cell-inner" +
					" x-grid3-col-label']");
					selenium.chooseOkOnNextConfirmation();
					selenium.click("idTriggerDelete");
					Assert.assertTrue((selenium.getConfirmation()).contains("you sure you want to remove the selected trigger"));								
			 	} else {
			 		
			 		System.out.println("trigger element is no exist");
			 		break;
			 		
			 	}
			
			}
		
    	} else {
	 		
	 		System.out.println("task element is no exist");
	 		
	 	}

    }
    
    /**Check that the "Created" option does work, Check
	that task is executed only one time after the creation of the file.**/
    public void createFileTriggerCheckCreatedOption(String label,
			String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic, String fileTriggerLabel,
			String fileTriggerDesc, String folderPath, String fileMask, String filePathType) {
		
		this.addTask(label, labelDescription, commonpro, branch, jobName,
				version, context, jobServer, statistic);
		
		String FilePath = this.getAbsolutePath(folderPath);		
		System.out.println(FilePath);
		
		this.addFileTrigger(label, fileTriggerLabel, labelDescription, "30",
				FilePath, fileMask, jobServer,
				"idJobConductorFileTriggerFtCreateCheckBox");
		
		AntAction antAction = new AntAction();

		if("NotWithBackslash".equals(filePathType)) {
			
			properties.put("file.path", FilePath+"\\testFileTrigger.cvs");
			System.out.println(">>>>>>>>>*--------"+FilePath+"\\testFileTrigger.cvs");
			
		} else if("withBackslash".equals(filePathType)){
			
			properties.put("file.path", FilePath+"testFileTrigger.cvs");
			
		}
		
		antAction.runTarget("File.xml", "create", properties);
		
		this.waitForElementPresent("//span[text()='"+label+"']//ancestor::tr" +
				"//span[text()='Running...']", Base.MAX_WAIT_TIME);	

		this.waitForElementPresent("//span[text()='"+label+"']//ancestor::tr" +
				"//span[text()='Ready to run']", Base.MAX_WAIT_TIME);		
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int logsConut = this.getXpathCount("//div[contains(@class,'x-grid3-" +
				"cell-inner x-grid3-col-startDate')]");		
		
		Assert.assertEquals(logsConut, 1);	
		
		this.clearTask(label);
		AntAction antAction1 = new AntAction();
		antAction1.runTarget("File.xml", "delete", properties);	
		
	}
	
	
	/**Check that the "Modified" option does work, Check
	that task is executed only one time after the modification of the file.**/ 
	public void createFileTriggerCheckModifiedOption(String label,
			String labelDescription,String commonpro,String branch,String jobName,
			String version,String context,String jobServer,String statistic, String fileTriggerLabel,
			String fileTriggerDesc, String folderPath, String fileMask, String filePathType) {
		
		this.addTask(label, labelDescription, commonpro, branch, jobName,
				version, context, jobServer, statistic);
		
		String FilePath = this.getAbsolutePath(folderPath);		
		System.out.println(FilePath);
		
		this.addFileTrigger(label, fileTriggerLabel, labelDescription, "30",
				FilePath, fileMask, jobServer,
				"idJobConductorFileTriggerFtModifiedCheckBox");
		
		AntAction antAction = new AntAction();
		
		if("NotWithBackslash".equals(filePathType)) {
			
			properties.put("file.path", FilePath+"\\testFileTrigger.log");
			
		} else if("withBackslash".equals(filePathType)) {
			
			properties.put("file.path", FilePath+"testFileTrigger.log");
			
		}
		
		antAction.runTarget("File.xml", "create", properties);
		
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
    
		int logsConut = this.getXpathCount("//div[contains(@class,'x-grid3-" +
				"cell-inner x-grid3-col-startDate')]");		
		
		Assert.assertEquals(logsConut, 0);	
		
		selenium.click("//span[text()='Triggers']");
		
		AntAction antAction1 = new AntAction();
		antAction1.runTarget("File.xml", "modify", properties);
		
		this.waitForElementPresent("//span[text()='"+label+"']//ancestor::tr" +
				"//span[text()='Running...']", Base.MAX_WAIT_TIME);

		this.waitForElementPresent("//span[text()='"+label+"']//ancestor::tr" +
				"//span[text()='Ready to run']", Base.MAX_WAIT_TIME);		
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int logsConutAfterMofified = this.getXpathCount("//div[contains(@class,'x-grid3-" +
				"cell-inner x-grid3-col-startDate')]");		
		
		Assert.assertEquals(logsConutAfterMofified, 1);	
		
		this.clearTask(label);
		AntAction antAction2 = new AntAction();
		antAction2.runTarget("File.xml", "delete", properties);	
		
	}
	
  //read content in file
	public String readfile(String path) {
		
		try {
			filepath=path; //get file page
			File file=new File(filepath);
			FileReader fileread=new FileReader(file);
			bufread=new BufferedReader(fileread);
			while((read=bufread.readLine())!=null) {
			
				readStr=readStr + "\n" + read;
				
			}
		}catch(Exception d){
			
			System.out.println("-*-"+d.getMessage());
			
		}
		
		return readStr; //return read content from textfile
		
	}
	
	public void refreshTaskStatus(long waitTime, String taskLabel, 
			String status) {
		
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!selenium.isElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='"+status+"']")) {
			
			selenium.click("//div[text()='Job Conductor' and @class='header-title']//ancestor::div[contains(@class,'x-panel-noborder x-panel x-component x-border-panel')]//following-sibling::div//button[@id='idSubModuleRefreshButton']");
			
		}
		
	}
	
}
