package com.talend.tac.cases.esbconductor;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ClearService extends ESBConductorUtils {
   
	@Test
	public void clearAllServices() {
		
		this.intoESBConductorPage();
		
		int serviceCount = selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-label']").intValue();
		System.out.println(serviceCount);
		String label;
		String name;		
		
		for(int i =0; i<serviceCount; i++) {
			
			label = selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-label']");
			System.out.println(label);
			name = selenium.getText("//div[@class='x-grid3-cell-inner x-grid3-col-applicationName']");
			System.out.println(name);
			this.deleteESBConductorOK(label, name);
			
		}
		serviceCount = selenium.getXpathCount("//div[@class='x-grid3-cell-inner x-grid3-col-label']").intValue();
		
		Assert.assertEquals(0, serviceCount);
	}
	
}
