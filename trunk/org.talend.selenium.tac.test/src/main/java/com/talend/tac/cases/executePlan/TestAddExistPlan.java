package com.talend.tac.cases.executePlan;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestAddExistPlan extends Plan {
	
	@Test
	@Parameters({"plan.label","plan.description","plan.task"})
	public void testAddPlanExist(String label,String description,String task) {
		
		addPlan(label,task, description);
	    
	}   
	
	
	
}
