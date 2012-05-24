package com.talend.tac.cases.executionTask;

 
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.talend.tac.base.Base;

public class TestAddTaskBaseBranchProject  extends TaskUtils {
	public boolean deleteTask(String taskLabel) throws InterruptedException{
		boolean deleteOk = true;
		selenium.refresh();
		this.waitForElementPresent("//span[text()='" + taskLabel + "']",
				WAIT_TIME);
		Thread.sleep(3000);
		selenium.mouseDown("//span[text()='" + taskLabel + "']");
		Thread.sleep(3000);
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idSubModuleDeleteButton");//clcik "Delete"
		selenium.getConfirmation();
		Assert.assertTrue((selenium.getConfirmation()).contains(("you want to remove all of the related logs and archives")));	
		if(selenium.isElementPresent("//span[text()='" + taskLabel + "']")){
			deleteOk = false;
		}
		return deleteOk;
	}
	public int getTotalExecutionTimes(){
		int total = 0;
		selenium.click("//span//span[text()='Logs']");
		selenium.setSpeed(MAX_SPEED);
//		selenium.click("//img[@src='gxt/themes/access/images/grid/refresh.gif']");
		String strContains = selenium.getText("//div[@class='my-paging-display x-component ']");
		String to = (strContains.split("of")[1].trim());
		selenium.setSpeed(MIN_SPEED);
		System.out.println(to);
		return total=Integer.parseInt(to);
		
	}
	public void inputCheckBoxUncheck(String xpathinputBox){
		if(selenium.getValue(xpathinputBox).equals("on")){
			selenium.click(xpathinputBox);
		}
	}
	public void inputCheckBoxChecked(String xpathinputBox){
		if(!selenium.getValue(xpathinputBox).equals("on")){
			selenium.click(xpathinputBox);
		}
	}
	public String getLogsValue() {
		String logs = null;
		selenium.click("//span//span[text()='Logs']");
		selenium.setSpeed(MID_SPEED);
		selenium.click("//div[@class=' x-grid3-hd-inner x-grid3-hd-startDate x-component sort-desc ']//a[@class='x-grid3-hd-btn']");
		selenium.setSpeed(MIN_SPEED);
		selenium.click("//a[@class=' x-menu-item x-component' and text()='Sort Descending']");
		this.waitForElementPresent(
				"//div[@class='x-grid3-cell-inner x-grid3-col-startDate']",
				WAIT_TIME);
//		String time = selenium
//				.getText("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']");
		selenium.mouseDown("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']");
		selenium.setSpeed(MID_SPEED);
		logs = selenium
				.getValue("//textarea[@name='log']");
		selenium.setSpeed(MIN_SPEED);
		System.out.println(logs);
		return logs;
	}

	
	public void runTask(String tasklabel,int times,int waitTime) throws InterruptedException{
		for (int i = 0; i < times; i++) {
//			selenium.refresh();
			this.waitForElementPresent("//span[text()='" + tasklabel + "']",
					WAIT_TIME);
			Thread.sleep(2000);
			selenium.mouseDown("//span[text()='" + tasklabel + "']");
			Thread.sleep(2000);
			selenium.click("//button[@id='idJobConductorTaskRunButton'  and @class='x-btn-text ' and text()='Run']");
			// Date start = new Date();
			this.waitForElementPresent("//span[text()='Real time statistics']", Base.WAIT_TIME);
			Assert.assertTrue(
					waitForCondition("//label[text()='Ok']", waitTime),
					"task run failed!");
			// close the pop window
			selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
		   }
		}
	
	public void addFileTrigger(String tasklabel,String filetriggerlabel,String filePath,String seconds,String fileMarks,String servername){
		this.waitForElementPresent("//span[text()='"+tasklabel+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		selenium.click("//button[text()='Add trigger...']");//add a trigger
		selenium.click("//a[text()='Add file trigger']");//add a SimpleTrigger
		this.typeString("idJobConductorFileTriggerLabelInput", filetriggerlabel);
		this.typeString("idJobConductorFileTriggerCheckTimeIntervalInput", seconds);
		this.typeString("idJobConductorFileTriggerFolderPathInput", filePath);
		this.typeString("idJobConductorFileTriggerFileMaskInput", fileMarks);
		inputCheckBoxChecked("idJobConductorFileTriggerFtExitCheckBox");
		this.selectDropDownList("idJobConductorFileTriggerFileServerListBox", servername);
		selenium.click("idFileTriggerSave");
		this.waitForElementPresent("//span[text()='"+filetriggerlabel+"']", WAIT_TIME);
	
	}
	
	public void addSimpleTrigger(String tasklabel,String simplelabel,String timeInterval){
		selenium.refresh();
		this.waitForElementPresent("//span[text()='"+tasklabel+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("idTriggerAdd simple trigger");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
        
        this.typeString("idJobConductorSimpleTriggerLableInput",simplelabel);//label
		
        this.typeString("idJobConductorSimpleTriggerDescInput", "testdescription");//description
        this.typeString("idJobConductorSimpleTriggerRptIntervalInput", timeInterval);//Time interval (s)
	
        selenium.setSpeed(MID_SPEED);
        //click save button to save trigger
	    selenium.click("idSimpleTriggerSave");	
	    selenium.setSpeed(MIN_SPEED);
	    
	    this.waitForElementPresent("//span[text()='"+simplelabel+"']", WAIT_TIME);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+simplelabel+"']"));
		
	
	}

	@Test
	@Parameters({"TaskBaseBranch","AddcommonProjectname","ProjectBranch","jobNameBranchJob","version0.1",
		"context","ServerForUseAvailable","statisticEnabled"})
	public void testAddTaskBaseBranch(String label, String projectName, String branchName,
			 String jobName, String version, String context, String serverName, String statisticName){
		this.addTask(label,"",projectName,branchName, jobName, version, context, serverName, statisticName);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {
				
			selenium.click("idFormSaveButton");
	        this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			
		}
	}
	@Test
	@Parameters({"TaskBaseBranch"})
	public void testRunTaskBaseBranch(String tasklabel) throws InterruptedException{
//		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
//		Assert.assertTrue(selenium.isElementPresent("//div[text()='"
//				+ rb.getString("menu.jobConductor") + "']"));
//		// select a exist task
//		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		runTask(tasklabel,1,Base.MAX_WAIT_TIME);
		
		Assert.assertTrue(getLogsValue().contains("hello branch!!!"),
				"default context test failed");
		
	}
	
	@Test
	@Parameters({"labelStatisticViewTask", "statisticDisabled", "statisticEnabled"})
	public void testTaskStatisticViewDisable(String tasklabel, String statisticDisabled, String statisticEnabled) throws InterruptedException{
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
		// select a exist task
		this.waitForElementPresent("//span[text()='"+tasklabel+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		this.clickWaitForElementPresent("//span[text()='Edition']");
		this.selectDropDownList("idJobConductorTaskStatisticsListBox", statisticDisabled);
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		selenium.setSpeed(MAX_SPEED);
		selenium.mouseDown("//span[text()='" + tasklabel + "']");
		selenium.setSpeed(MIN_SPEED);
		
		selenium.click("//button[@id='idJobConductorTaskRunButton'  and @class='x-btn-text ' and text()='Run']");
		if(waitForCondition("//span[@class='x-window-header-text' and text()='Real time statistics']", 15)){
			Assert.fail("test statistic view disable failed!");
		}
		
		this.waitForElementPresent("//span[text()='Running...']", MAX_WAIT_TIME);
		this.waitForElementPresent("//span[text()='"+tasklabel+"']//ancestor::tr" +
				"//span[text()='Ready to run']", WAIT_TIME);
		//undo disable select		
		
		this.selectDropDownList("idJobConductorTaskStatisticsListBox", statisticEnabled);
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
	}
	
	
	@Test
	@Parameters({"AddcommonProjectname","ProjectBranch","jobNameBranchJob","version0.1",
		"context","ServerForUseAvailable","statisticEnabled"})
	public void testDeactiveTaskWithSimpleTrigger(String projectName, String branchName,
			 String jobName, String version, String context, String serverName, String statisticName) throws InterruptedException{
		 String label = "taskwithsimpletrigger";
		 int executiontime = 60000;
		 if(!selenium.isElementPresent("//span[text()='"+label+"']")){
			 addTask(label, "",projectName,branchName,jobName,version,context,serverName,statisticName);
		 }
		 if(!selenium.isElementPresent("//span[text()='"+label+"']")) {
			
			selenium.click("idFormSaveButton");
	        selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
			selenium.setSpeed(MIN_SPEED);
			
		}
		 
		 runTask(label,1,Base.MAX_WAIT_TIME);
        //add a simple trigger for the task
        addSimpleTrigger(label,"testDeactivesimpltrigger","25");
        //wait for 160 seconds so that the task run several times
        Thread.sleep(executiontime);
        //see task logs ,count the execution times
        selenium.click("//span//span[text()='Logs']");
		selenium.setSpeed(MID_SPEED);
//		selenium.click("");
		Assert.assertTrue(selenium.isElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']"), "task run failed!");
		Assert.assertTrue(getTotalExecutionTimes() > 0, "task run failed!");
		selenium.setSpeed(MIN_SPEED);
		selenium.refresh();
		this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.mouseDown("//span[text()='"+label+"']");
		this.waitForElementPresent("//span[text()='Execution task']/ancestor::fieldset//label[text()='Active:']/ancestor::div[@class='x-form-item ']//input", WAIT_TIME);
		inputCheckBoxUncheck("//span[text()='Execution task']/ancestor::fieldset//label[text()='Active:']/ancestor::div[@class='x-form-item ']//input");
//		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		Thread.sleep(3000);
		selenium.setSpeed(MIN_SPEED);
		Thread.sleep(3000);
		selenium.refresh();
		this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.mouseDown("//span[text()='"+label+"']");
		int totalafterdeactive = getTotalExecutionTimes();
		selenium.setSpeed(MIN_SPEED);
		Thread.sleep(executiontime);
		selenium.refresh();
		this.waitForElementPresent("//span[text()='"+label+"']", WAIT_TIME);
		selenium.setSpeed(MID_SPEED);
		selenium.mouseDown("//span[text()='"+label+"']");
		Assert.assertFalse( getTotalExecutionTimes()> totalafterdeactive, "task deactive failed!");
		selenium.setSpeed(MIN_SPEED);
		deleteTask(label);
	}
	@Test
	@Parameters({"labelStatisticViewTask", "statisticEnabled"})
	public void testTaskStatisticViewEnable(String tasklabel, String statisticEnabled) throws InterruptedException{
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
		Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
		// select a exist task
		this.waitForElementPresent("//span[text()='"+tasklabel+"']", WAIT_TIME);
		selenium.mouseDown("//span[text()='"+tasklabel+"']");
		this.clickWaitForElementPresent("//span[text()='Edition']");
		this.selectDropDownList("idJobConductorTaskStatisticsListBox", statisticEnabled);
		selenium.setSpeed(MID_SPEED);
		selenium.click("idFormSaveButton");
		selenium.setSpeed(MIN_SPEED);
		
		selenium.setSpeed(MAX_SPEED);
		selenium.mouseDown("//span[text()='" + tasklabel + "']");
		selenium.setSpeed(MIN_SPEED);
		
		this.clickWaitForElementPresent("//button[@id='idJobConductorTaskRunButton'  and @class='x-btn-text ' and text()='Run']");
		
		this.waitForElementPresent("//span[@class='x-window-header-text' and text()='Real time statistics']", WAIT_TIME);
		Assert.assertTrue(selenium.isElementPresent("//span[@class='x-window-header-text' and text()='Real time statistics']"),
			"test statistic view disable failed!");
		
	}
	
	
	@Test
	@Parameters({"AddcommonProjectname","ProjectBranch","jobNameBranchJob","version0.1",
		"context","ServerForUseAvailable","statisticEnabled"})
	public void testDeleteTaskExecutionLogs(String projectName,
			String branchName, String jobName, String version, String context,
			String serverName, String statisticName) throws InterruptedException {
		String label = "taskDeleteLogs";
		addTask(label, "",projectName, branchName, jobName, version, context,
				serverName, statisticName);
		if (!selenium.isElementPresent("//span[text()='" + label + "']")) {
			selenium.click("idFormSaveButton");
			this.waitForElementPresent("//span[text()='"
					+ label + "']", WAIT_TIME);
			selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"
					+ label + "']"));
			selenium.setSpeed(MIN_SPEED);
		}
		
		runTask(label,1,Base.MAX_WAIT_TIME);
		runTask(label,1,Base.WAIT_TIME);
		this.clickWaitForElementPresent("//span//span[text()='Logs']");
		Thread.sleep(3000);
		Assert.assertTrue((selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']")).intValue()==2,"task run generate logs failed !");
		selenium.chooseOkOnNextConfirmation();
		selenium.chooseOkOnNextConfirmation();
		selenium.click("idJobConductorJobLogClearLogButton");	
		Assert.assertTrue((selenium.getConfirmation()).contains("you sure you want clear the job execution logs for the current task"));
		
		Assert.assertTrue((selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']")).intValue()==0,"task run generate logs failed !");
		runTask(label,2,Base.WAIT_TIME);
		if(deleteTask(label)){
			addTask(label,"", projectName, branchName, jobName, version, context,
					serverName, statisticName);
			if (!selenium.isElementPresent("//span[text()='" + label + "']")) {
				selenium.click("idFormSaveButton");
				selenium.setSpeed(MID_SPEED);
				Assert.assertTrue(selenium.isElementPresent("//span[text()='"
						+ label + "']"));
				selenium.setSpeed(MIN_SPEED);
			}	
			selenium.setSpeed(MID_SPEED);
			selenium.mouseDown("//span[text()='"
						+ label + "']");
			selenium.click("//span//span[text()='Logs']");
			Thread.sleep(3000);
//			Assert.assertFalse(waitForCondition("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']",Base.WAIT_TIME/4), "delete  logs through delete task failed !");
			Assert.assertTrue((selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-startDate']")).intValue()==0,"delete  logs through delete task successful !");
			selenium.setSpeed(MIN_SPEED);
		}
	}
	
	@Test
	@Parameters({"AddcommonProjectname","ProjectBranch","jobWithContexts","version0.1",
		"context","ServerForUseAvailable","statisticEnabled","FolderPath","FileMask","ServerForUseAvailable"})
	public void testRemoveTaskWithComplicatedItems(String projectName,
			String branchName, String jobName, String version, String context,
			String serverName, String statisticName,String path,String mark,String server) throws InterruptedException{
		//add a task with several context
		String tasklabel = "testTaskWithItems";
		String simpletrigger = "testTaskRemoveSimpleTrigger";
		addTask(tasklabel,"", projectName, branchName, jobName, version, context,
				serverName, statisticName);
		if (!selenium.isElementPresent("//span[text()='" + tasklabel + "']")) {
			selenium.click("idFormSaveButton");
			selenium.setSpeed(MID_SPEED);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"
					+ tasklabel + "']"));
			selenium.setSpeed(MIN_SPEED);

		}
		String filetriggerlabel = "testFileTrigger";
		//add a file trigger for task added
		addFileTrigger(tasklabel,filetriggerlabel ,path,"1000",mark,server);	
		//add a simple trigger for task added
		addSimpleTrigger(tasklabel,simpletrigger,"1000");
		this.refreshTaskStatus(6000, tasklabel, "Generating...");
		
		this.refreshTaskStatus(100000, tasklabel, "Ready to run");
		this.waitForElementPresent("//span[text()='"+tasklabel+"']//ancestor::tr" +
			"//span[text()='Ready to run']", WAIT_TIME*6);
		
		//active one context of task
		selenium.mouseDown("//span[text()='"+tasklabel+"']");	
		this.clickWaitForElementPresent("//span[text()='Context parameters']");
		Thread.sleep(2000);
		if(selenium.isElementPresent("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col x-grid3-cc-override']")){
			selenium.mouseDown("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col x-grid3-cc-override']");
		
		}
			Assert.assertTrue(selenium.isElementPresent("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-override']"), "active context age failed!");
		//add a jvm parameter for task
//		addJVM();
		//then delete the task.
		
		deleteTask(tasklabel);
		//add a task with same name ,to see if these items exist still
		addTask(tasklabel,"", projectName, branchName, jobName, version, context,
				serverName, statisticName);
		if (!selenium.isElementPresent("//span[text()='" + tasklabel + "']")) {
			selenium.click("idFormSaveButton");
			this.waitForElementPresent("//span[text()='"
					+ tasklabel + "']", WAIT_TIME);
			Assert.assertTrue(selenium.isElementPresent("//span[text()='"
					+ tasklabel + "']"));
			selenium.setSpeed(MIN_SPEED);

		}
		selenium.mouseDown("//span[text()='"
				+ tasklabel + "']");
		this.clickWaitForElementPresent("//span[text()='Context parameters']");
		Thread.sleep(5000);
			Assert.assertFalse(selenium.isElementPresent("//div[text()='age']/ancestor::table[@class='x-grid3-row-table']//div[@class='x-grid3-check-col x-grid3-check-col-on x-grid3-cc-override']"), "task delete context failed!");
		this.clickWaitForElementPresent("//span[@class='x-tab-strip-text  ' and text()='Triggers']");
		Thread.sleep(5000);
		Assert.assertFalse(selenium.isElementPresent("//span[text()='"+filetriggerlabel+"']"), "test task remove failed!");
		Assert.assertFalse(selenium.isElementPresent("//span[text()='"+simpletrigger+"']"), "test task remove failed!");
	
	}
	public void addJVM(){
		this.clickWaitForElementPresent("//span[text()='JVM parameters']");
		this.clickWaitForElementPresent("idJobConductorCmdPrmAddButton");
		//jvm parameters
		this.clickWaitForElementPresent("//div[@class='x-grid3-cell-inner x-grid3-col-parameter']");
		this.waitForElementPresent("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']//input", WAIT_TIME);//jvm
		selenium.click("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']//input");
		selenium.type("//span[text()='JVM parameter']//ancestor::div[@class='x-grid3-viewport']//input","-Xms356M -Xmx1024M");
		//description
		this.clickWaitForElementPresent("//span[text()='Description']//ancestor::div[@class='x-grid3-viewport']//td[@class='x-grid3-col x-grid3" +
				"-cell x-grid3-td-description x-grid3-cell-last ']//img[@title='Click to edit']");
		this.waitForElementPresent("//span[text()='Description']//ancestor::div[@class='x-grid3-viewport']", WAIT_TIME);//jvm
		selenium.click("//span[text()='Description']//ancestor::div[@class='x-grid3-viewport']//input");
		selenium.type("//span[text()='Description']//ancestor::div[@class='x-grid3-viewport']//input","jvm set in task");
		selenium.keyDown("//span[text()='Description']//ancestor::div[@class='x-grid3-viewport']//input", "\\13");
	    selenium.setSpeed(MIN_SPEED);
	    
	    selenium.click("//button[@id='idJobConductorTaskRunButton()'  and @class='x-btn-text ' and text()='Run']");
	    this.waitForElementPresent("//label[text()='Ok']", WAIT_TIME);
	    selenium.click("//div[@class=' x-nodrag x-tool-close x-tool x-component']");
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

}