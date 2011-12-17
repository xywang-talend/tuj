package com.talend.tac.cases.executionTask;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;

public class TestAddJVMParametersForTask  extends JVMParameter {
    
	String jvmParameterCorrect = "-Xms512M -Xmx512M";
	String jvmParameterWrong = "jvm parameter of Wrong";
	String jvmParameterDescription = "jvm set in task";
	
	String expectationValue = jvmParameterCorrect+" "+"("+jvmParameterDescription+")";
    String expectationValueOfInactive = "";
	//test add a correct jvm parameter and active to task, then run it and check its value display in grid and RecoverLastExecution
	@Test	
//	(dependsOnGroups={"AddTask"})
    @Parameters({"labelAddJVMParametersForTask"})
	public void testAddActiveCorrectJVMParametersForTask(String label) {

    	this.addJVMParametersForTask("Active", label, jvmParameterCorrect, jvmParameterDescription, "Ok",Base.MAX_WAIT_TIME);
    	
    	this.checkJvmValueInGridRecoverLastExecution(expectationValue);
	    
    	this.deleteJVMParameter(label);
    	
    }
	
	//test add a correct jvm parameter and inactive to task, then run it and check its value without display in grid and RecoverLastExecution
	@Test
    @Parameters({"labelAddJVMParametersForTask"})
	public void testAddInactiveCorrectJVMParametersForTask(String label) {

    	this.addJVMParametersForTask("Inactive", label, jvmParameterCorrect, jvmParameterDescription, "Ok",Base.WAIT_TIME);
    	
    	this.checkJvmValueInGridRecoverLastExecution(expectationValueOfInactive);
	    
    	this.deleteJVMParameter(label);
    	
    }
	
	
	//test add a wrong jvm parameter and run it, run is block 
	@Test
    @Parameters({"labelAddJVMParametersForTask"})
	public void testAddActiveWrongJVMParametersForTask(String label) {

    	this.addJVMParametersForTask("Active", label, jvmParameterWrong, jvmParameterDescription, 
    			rb.getString("executionTask.errorStatus.runningError"),Base.WAIT_TIME);
	
    	this.deleteJVMParameter(label);
    	
    }	
	
}
