package org.talend.mdm.cases.dsc;

import org.talend.mdm.Login;
import org.talend.mdm.impl.DataStewardImpl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestDSC extends Login {
	DataStewardImpl dsc;
	@BeforeMethod
	public void beforeMethod(){
		dsc = new DataStewardImpl(driver);
	}
	
	
	@Test
	public void testCreateTaskWithTypeResolution(){
		
		dsc.createTaskWithTypeOfResolution("test", "Resolution", "");
		
	}
	
	
	
	
	@AfterMethod
	@Override
	public void logout() {
		
	}
}
