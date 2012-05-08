package org.talend.mdm.cases.dsc;

import org.talend.mdm.Login;
import org.talend.mdm.impl.DataStewardImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestDSC extends Login {
	DataStewardImpl dsc;
	@BeforeMethod
	public void beforeMethod(){
		dsc = new DataStewardImpl(driver);
	}
	
	
	@Test
	@Parameters( {"task.name","task.type.resotion","task.default.source","task.fieldName1"})
	public void testCreateTaskWithTypeResolution(String taskName,String taskType,String source ,String filedName1){
		
		dsc.createTaskWithTypeDefined(taskName, taskType, source,filedName1);
		
	}
	
	@Test
	@Parameters( {"task.name","task.type.data","task.default.source","task.fieldName1"})
	public void testCreateTaskWithTypeData(String taskName,String taskType,String source ,String filedName1){
		
		dsc.createTaskWithTypeDefined(taskName, taskType, source,filedName1);
		
	}
	
	@Test
	@Parameters( {"task.name","task.type.data","task.default.source","task.fieldName1"})
	public void testTaskAssignment(String taskName,String taskType,String source ,String filedName1){
		
		dsc.taskAssign(taskName, taskType, source,filedName1,"user","user","administrator","administrator");
		
	}
	
	
	
	@AfterMethod
	@Override
	public void logout() {
		
	}
}
