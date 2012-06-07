package com.talend.tac.cases.audit;


import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TestAuditWithRemoteCommondline extends Audit {
	@Test
	@Parameters({"addCommonProjectName","trunjobWithCheckpoint", "tjavaWithMulripleCheckpoint", 
		"jobNameTJava"})
	public void testAuditTrunkWithRemoteCommondline(String projectName, String tRunJobCheckPoint, String tjavaCheckpoint,
			String tjava){

		//get get incipient report path
		String defaultPath = this.getDefaultReportPath();
		
		auditProcess(projectName, "trunk");
		int linksbefore = checkAuditListLink(projectName);
		Assert.assertTrue(checkAuditInfo(projectName),"TestAudit audit trunk failed!");
		this.sleep(5000);
		Assert.assertTrue((checkAuditListLink(projectName)==linksbefore +1),"TestAudit audit trunk failed,not create links!");
		String reportFileName = this.getReportFileName();
		File auditReportFile = this.checkReportPdf(defaultPath, projectName, tjava);
        Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+reportFileName, tRunJobCheckPoint));
	    Assert.assertTrue(this.isExistedInfoInPdf(defaultPath+"/"+reportFileName, tjavaCheckpoint));
	    auditReportFile.delete();
		
	}
	
}
