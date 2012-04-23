package com.talend.tac.cases.executionTask;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ClearTaskTrigger extends TaskUtils {
    	
    @Test
    @Parameters({"labelStatisticViewTask","TaskWithtRunjob","taskForTestFileTriggerOfModifiedOptionFilePathNotWithLastBackslash",
    	"taskForTestFileTriggerOfCreationOptionFilePathNotWithLastBackslash","taskForTestFileTriggerOfModifiedOption","taskForTestFileTriggerOfCreationOption",
    	"taskForTestFileTrigger","taskProjectWithContainsSpaceChar","label","labelRefProJobByMainProTRunJobRun","TaskDeleteLogs",
    	"labelReferenceproTjava","TaskWithInactiveServer","duplicateTask","taskWithTjavaWithMulripleCheckpoint"
    	,"taskWithTrunjobWithCheckpoint","TaskLabelOfLatestJob", "TaskOfAutomatedSelectingComboValue"})
    public void clearsTasks(String labelStatisticViewTask,String TaskWithtRunjob, String taskForTestFileTriggerOfModifiedOptionFilePathNotWithLastBackslash,String taskForTestFileTriggerOfCreationOptionFilePathNotWithLastBackslash
    		,String taskForTestFileTriggerOfModifiedOption,String taskForTestFileTriggerOfCreationOption,
    		String taskForTestFileTrigger,String taskProjectWithContainsSpaceChar, String label, String labelRefProJobByMainProTRunJobRun, 
    		String taskDeleteLogs,String testAddTaskForTestReferenceproTjava,String TaskWithInactiveServer,String Copy_of_testTaskNotChooseActive,String taskWithTjavaWithMulripleCheckpoint
    		,String taskWithTrunjobWithCheckpoint, String TaskLabelOfLatestJob
    		, String TaskOfAutomatedSelectingComboValue) {
         
    	 clearTask(label);
         clearTask(taskProjectWithContainsSpaceChar);
         clearTask(taskForTestFileTrigger);
         clearTask(taskForTestFileTriggerOfCreationOption);
         clearTask(taskForTestFileTriggerOfModifiedOption);
         clearTask(taskForTestFileTriggerOfCreationOptionFilePathNotWithLastBackslash);
         clearTask(taskForTestFileTriggerOfModifiedOptionFilePathNotWithLastBackslash);
         clearTask(TaskWithtRunjob);
         clearTask(labelStatisticViewTask);
         clearTask(labelRefProJobByMainProTRunJobRun);
         clearTask("testTaskWithItems");
         clearTask(taskDeleteLogs);
         clearTask(testAddTaskForTestReferenceproTjava);
         clearTask(TaskWithInactiveServer);
         clearTask(Copy_of_testTaskNotChooseActive);
         clearTask(taskWithTjavaWithMulripleCheckpoint);
         clearTask(taskWithTrunjobWithCheckpoint);
         clearTask(TaskWithInactiveServer);    
         clearTask(TaskLabelOfLatestJob);
         clearTask(TaskOfAutomatedSelectingComboValue);
         
    }
	
  
    //add a method of remove all triggers
    @Test
    @Parameters({"modifyTask","labelTRunJobByTaskRun","TaskBaseBranch", "labelRefProJobByMainProTRunJobRun"})
    public void clearsAllTriggers(String modifyTask, String labelTRunJobByTaskRun, String TaskBaseBranch
          , String labelRefProJobByMainProTRunJobRun) {
    	
    	this.clickWaitForElementPresent("!!!menu.executionTasks.element!!!");
    	selenium.setSpeed(MID_SPEED);
    	Assert.assertTrue(selenium.isElementPresent("//div[contains(text(),'Conductor') and @class='header-title']"));
    	selenium.setSpeed(MIN_SPEED);
    	
    	clearTriggers(labelTRunJobByTaskRun);
    	clearTriggers(modifyTask);
    	clearTriggers(TaskBaseBranch);
    	clearTriggers(labelRefProJobByMainProTRunJobRun);
    	
    }   
    
}
