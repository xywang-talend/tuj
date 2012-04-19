package org.talend.tac.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.HasInputDevices;
import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Locatable;
import org.talend.tac.base.WebDriverBase;
import org.testng.Assert;

public class ClearService extends WebDriverBase{

	public ClearService(WebDriver driver) {
		super.setDriver(driver);
		this.driver=driver;
	}
	
	public void mouseDown(String xpathExpression) {
  	    Locatable hoverItem = (Locatable) driver.findElement(By.xpath(xpathExpression));
  	    Mouse mouse = ((HasInputDevices) driver).getMouse();
  	    mouse.mouseDown(hoverItem.getCoordinates());
  	    try {
			 Thread.sleep(2000);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
     }
	
	public void intoESBConductorPage() {
        this.getElementById("!!!menu.esbconductor.element!!!").click();
        this.waitforTextDisplayed("ESB CONDUCTOR", WAIT_TIME_MIN);
    }
	
	public void clearAllEsbConductors() {
		int serviceCount = this.getElementsByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label']").size();
		System.out.println(serviceCount);
		String label;
		String name;		
		
		for(int i =0; i<serviceCount; i++) {
			
			label = this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label']").getText();
			System.out.println(label);
			name = this.getElementByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-applicationName']").getText();
			System.out.println(name);
			this.deleteESBConductorOK(label, name);
			
		}
		serviceCount = this.getElementsByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-label']").size();
		
		Assert.assertEquals(0, serviceCount);
	}
	
	public void deleteESBConductorOK(String label, String name) {
        
        this.waitforElementDisplayed(By.xpath("//div[text()='"+label+"']"), WAIT_TIME_MIN);
        this.mouseDown("//div[text()='"+label+"']");
        if(this.isElementPresent(By.xpath("//div[text()='"+label+"']" +
           "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
           "//preceding-sibling::td//span[text()='Ready to deploy']"),10) ||
            this.isElementPresent(By.xpath("//div[text()='"+label+"']" +
           "//ancestor::td[@class='x-grid3-col x-grid3-cell x-grid3-td-label ']"+
           "//preceding-sibling::td//span[text()='Undeployed']"),10)) {    
        logger.info(other.getString("ESBConductor.DeleteButtonId"));
        this.getElementByXpath("//button[@id='idESBConductorTaskGridDeleteButton']").click();
   //     this.clickElementById("idESBConductorTaskGridDeleteButton");
        this.acceptAlert();
        } 
    }
	
}
