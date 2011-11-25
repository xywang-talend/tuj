package com.talend.tac.cases.executionTask;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talend.tac.base.Base;

public class TestDeleteJVMParameter extends JVMParameter {
    
	  
	String jvmParameterCorrect = "-Xms512M -Xmx512M";
	String jvmParameterDescription = "jvm set in task";
	
	String expectationValue = jvmParameterCorrect+" "+"("+jvmParameterDescription+")";
	
	//test delete a  jvm parameter
	@Test
	@Parameters({"labelAddJVMParametersForTask"})
	public void testDelteJVMParameter(String label) {

    	this.addJVMParametersForTask("Active", label, jvmParameterCorrect, jvmParameterDescription, "Ok",Base.WAIT_TIME);
	    
    	this.deleteJVMParameter(label);
    	
	}
	
}
