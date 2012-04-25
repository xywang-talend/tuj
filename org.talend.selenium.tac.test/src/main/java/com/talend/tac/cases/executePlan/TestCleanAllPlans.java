package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCleanAllPlans extends Plan {
    
	@Test
	
	public void testCleanPlans() {
		
	this.deleteAllPlan();
		
	}
	
}
