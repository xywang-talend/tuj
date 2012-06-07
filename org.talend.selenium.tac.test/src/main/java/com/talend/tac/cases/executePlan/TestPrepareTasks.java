package com.talend.tac.cases.executePlan;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestPrepareTasks extends Plan {

	@Test
	@Parameters({"task.label",
			"labelDescription", "addCommonProjectName", "branchName",
			"jobName", "version", "context", "serverForUseAvailable",
			"statisticEnabled" })
	public void testPrepareTask(
			String tasklabel, String labelDescription, String commonpro,
			String branch, String jobName, String version, String context,
			String jobServer, String statistic) {
		// this.addPlan(planLabel, rootTask, "treeManagePlan");
		
		addTask(tasklabel, labelDescription, commonpro, branch, jobName,
				version, context, jobServer, statistic);
		
	}



}
