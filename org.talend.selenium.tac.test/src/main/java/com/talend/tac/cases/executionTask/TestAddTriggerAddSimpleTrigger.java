package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;
import com.talend.tac.cases.executePlan.TriggerDate;

public class TestAddTriggerAddSimpleTrigger extends TaskUtils {
    	   
    TriggerDate date = new TriggerDate();
    //add a method of remove triggers
    public void clearTriggers(String taskLabel) {
    
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
			 		this.waitForElementPresent("//span[text()='"+taskLabel+"']", WAIT_TIME);
					selenium.mouseDown("//span[text()='Triggers']/parent::span/parent::em/parent::a/parent::li/" +
					"parent::ul/parent::div/parent::div/parent::div/parent::div//div[@class='x-grid3-cell-inner" +
					" x-grid3-col-label']");
					selenium.chooseOkOnNextConfirmation();
					selenium.click("idTriggerDelete");
					
					Assert.assertTrue(selenium.getConfirmation().matches("^Are you sure you want to remove the selected trigger [\\s\\S]$"));
				    								
			 	} else {
			 		
			 		System.out.println("element is no exist");
			 		break;
			 		
			 	}
			
			}
		
    	} else {
	 		
	 		System.out.println("element is no exist");
	 		
	 	}

    }	
    
	
    //add a method of remove all triggers
    @Test
    @Parameters({"localhostAddress","labelTRunJobByTaskRun","labelRefProJobByMainProTRunJobRun","labelReferenceproTjava",
    	"modifyTask","duplicateTask","TaskBaseBranch"})
    public void clearsAllTriggers(String localhostAddress,String labelTRunJobByTaskRun,String labelRefProJobByMainProTRunJobRun,
    		String labelReferenceproTjava,String modifyTask,String duplicateTask, String TaskBaseBranch ) {
    	changeCommandLineConfig(localhostAddress);
    	this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	
    	clearTriggers(labelTRunJobByTaskRun);
    	clearTriggers(labelRefProJobByMainProTRunJobRun);
    	clearTriggers(labelReferenceproTjava);
    	clearTriggers(modifyTask);
    	clearTriggers(TaskBaseBranch);
    	
    }
    
  /**add a simpleTrigger, set its 'NumberOfTriggerings'(1)
    when after trigger task second run finish---trigger will auto stop**/
    @Test
	@Parameters({"modifyTask","addSimpleTriggerNumberOfTriggeringsRunnedAutoStopLabel",
		"addSimpleTriggerNumberOfTriggeringsRunnedAutoStopDescription"})
    public void testAddSimpleTriggerNumberOfTriggeringsRunnedAutoStop(String taskLabel, String label, String description) {
   
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("idTriggerAdd simple trigger");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
        
        this.typeString("idJobConductorSimpleTriggerLableInput", label);//label
		
        this.typeString("idJobConductorSimpleTriggerDescInput", description);//description

        this.typeString("idJobConductorSimpleTriggerRptCountInput", "1");//Number of triggerings
	   
        this.typeString("idJobConductorSimpleTriggerRptIntervalInput", "5");//Time interval (s)
	       		
	    selenium.setSpeed(MID_SPEED);
	    selenium.click("idSimpleTriggerSave");
		selenium.setSpeed(MIN_SPEED);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {
    		
			selenium.click("idTriggerRefresh");
			
    	}
    	
		waitForElementPresent("//span[text()='2 / 2']",WAIT_TIME);
	  			
		selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='testAddSimpleTriggerNumberOfTriggeringsRunnedAutoStopLabel']//ancestor::tr//img"));
		selenium.setSpeed(MIN_SPEED);
			
		
	} 
    
    
	// add a simpleTrigger
	@Test
	@Parameters({"modifyTask", "addSimpleTriggerLabel","addSimpleTriggerDescription"})
	public void testAddTriggerAddSimpleTrigger(String taskLable, String label, String description) {
	  
		addSimpleTrigger(taskLable, label, description, date.getFuture(24), date.getFuture(48), "5", "20","future"  );
		
		selenium.setSpeed(MID_SPEED);
	    selenium.click("idSimpleTriggerSave");
		selenium.setSpeed(MIN_SPEED);
    	System.out.println(selenium.getValue("idJobConductorSimpleTriggerStartTime"));
    	System.out.println(selenium.getValue("idJobConductorSimpleTriggerEndTime"));
		
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {
    		
			selenium.click("idTriggerRefresh");
			
		}
		selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
	    selenium.setSpeed(MIN_SPEED);
	}	
	
	// add a simpleTrigger use default date, selected job is TRunJob(use tRunJob run child'job)
	@Test
	@Parameters({"labelTRunJobByTaskRun", "addSimpleTriggerLabelNotChooseDate","addSimpleTriggerNotChooseDateDescription"})
	public void testAddTriggerAddSimpleTriggerNotChooseDate(String taskLabel, String label, String description) throws InterruptedException {
		    
	    	       
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("idTriggerAdd simple trigger");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//span[text()='"+rb.getString("trigger.action.addSimpleTrigger")+"']"));
        
        this.typeString("idJobConductorSimpleTriggerLableInput", label);//label
		
        this.typeString("idJobConductorSimpleTriggerDescInput", description);//description
	   
        this.typeString("idJobConductorSimpleTriggerRptIntervalInput", "20");//Time interval (s)
	       		
	    selenium.setSpeed(MID_SPEED);
	    selenium.click("idSimpleTriggerSave");
		selenium.setSpeed(MIN_SPEED);
		if(!selenium.isElementPresent("//span[text()='"+label+"']")) {
    		
			selenium.click("idTriggerRefresh");
			
    	}
		selenium.setSpeed(MID_SPEED);
	    Assert.assertTrue(selenium.isElementPresent("//span[text()='"+label+"']"));
	    selenium.setSpeed(MIN_SPEED);
   	
	    this.waitForElementPresent("//span[text()='"+taskLabel+"']//ancestor::tr" +
				"//span[text()='Running...']", Base.MAX_WAIT_TIME);			
				
	    
	}
	
	//add a exist simpleTrigger
	@Test
	@Parameters({"modifyTask", "addSimpleTriggerLabel","addSimpleTriggerExistTriggerDescription"})
    public void testAddTriggerAddSimpleTriggerAddExist(String taskLabel, String label, String description) {
    	
		addSimpleTrigger(taskLabel, label, description, date.getFuture(24), date.getFuture(24), "5", "20", "future");
		
	    selenium.setSpeed(MID_SPEED);
	    selenium.click("idSimpleTriggerSave");
		selenium.setSpeed(MIN_SPEED);
		selenium.setSpeed("1000");
	    Assert.assertTrue(selenium.isTextPresent(rb.getString("trigger.error.uniqueLabel")));
		selenium.setSpeed(MIN_SPEED);   
	}
	
//	add a simpleTrigger of wrong form time interval 
	@Test
	@Parameters({"modifyTask", "addSimpleTriggerWrongFormLabel","addSimpleTriggerWrongFormDescription","addSimpleTriggerWrongFormStartTime",
		"addSimpleTriggerWrongFormEndTime","addSimpleTriggerWrongFormNumberOfTriggers","addSimpleTriggerWrongFormTimeInterval"})
    public void testAddTriggerAddSimpleTriggerAddWrongFormFileds(String taskLabel, String label, String description
    		, String startTime, String endTime, String numberOfTriggering, String timeInterval) {
    	
		this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	selenium.mouseDown("//span[text()='"+taskLabel+"']");//select a exist task
		selenium.click("idTriggerAdd trigger...");//add a trigger
		selenium.click("idTriggerAdd simple trigger");//add a SimpleTrigger
        Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
        
        this.typeString("idJobConductorSimpleTriggerLableInput", label);//label
    	selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Add simple trigger']//ancestor::fieldset//label[text()='Label:']/parent::div//img"));
		selenium.setSpeed(MIN_SPEED);
        this.typeString("idJobConductorSimpleTriggerDescInput", description);//description
      
        this.typeString("idJobConductorSimpleTriggerRptCountInput", numberOfTriggering);//Number of triggerings
    	selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Add simple trigger']//ancestor::fieldset//label[text()='Number of triggerings:']/parent::div//img"));
		selenium.setSpeed(MIN_SPEED);
        this.typeString("idJobConductorSimpleTriggerRptIntervalInput", timeInterval);//Time interval (s)
       	selenium.setSpeed(MID_SPEED);
		Assert.assertTrue(selenium.isElementPresent("//span[text()='Add simple trigger']//ancestor::fieldset//label[text()='Time interval (s):']/parent::div//img"));
		selenium.setSpeed(MIN_SPEED);
	    
	 }
	
	//add a overdue(start date) simpleTrigger
	@Test	
	@Parameters({"modifyTask", "addSimpleTriggerOverdueStartDataLabel","addSimpleTriggerOverdueStartDataDescription"})
    public void testAddTriggerAddSimpleTriggerAddOverdueStartData(String taskLabel, String label, String description) {
    	
		addSimpleTrigger(taskLabel, label, description, date.getPast(24), date.getCurrent(), "5", "20", "past");
	
	    selenium.setSpeed(MID_SPEED);
	    selenium.click("idSimpleTriggerSave");
		selenium.setSpeed(MIN_SPEED);
		selenium.setSpeed(MID_SPEED); 
	    Assert.assertTrue(selenium.isTextPresent(rb.getString("trigger.simpleTrigger.error.startTimeLessThenServerTime")));
	    selenium.setSpeed(MIN_SPEED); 		
	    
	}
	
	//add a overdue(end date) simpleTrigger
	@Test
	@Parameters({"modifyTask","addSimpleTriggerOverdueEndDatalabel","addSimpleTriggerOverdueEndDataDescription"})
    public void testAddTriggerAddSimpleTriggerAddOverdueEndData(String taskLabel, String label, String description) {
		System.out.println(date.getPast(24).months+"/-/-/-/-/");    
	    addSimpleTrigger(taskLabel, label, description, date.getCurrent(), date.getPast(24), "5", "20", "past");
	    System.out.println(date.getPast(24).months+"/-/-/-/-");
	    selenium.setSpeed(MID_SPEED);
	    selenium.click("idSimpleTriggerSave");
		selenium.setSpeed(MIN_SPEED);
		selenium.setSpeed("1000"); 
	    Assert.assertTrue(selenium.isTextPresent("End time cannot be before start time"));
	    selenium.setSpeed(MIN_SPEED);          
	   
	}
	
 	
}
