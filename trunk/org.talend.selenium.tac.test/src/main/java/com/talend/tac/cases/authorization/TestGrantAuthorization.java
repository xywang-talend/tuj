package com.talend.tac.cases.authorization;

import org.testng.annotations.Test;

import com.talend.tac.cases.Login;

public class TestGrantAuthorization extends Login{
  @Test
	public void testGrantAuthorization() {
	  
	  waitForElementPresent("!!!menu.projectsauthorizations.element!!!", 30);
	  selenium.click("!!!menu.projectsauthorizations.element!!!");
	  selenium.mouseDown("!!!menu.projectsauthorizations.element!!!");
	  selenium.mouseUp("!!!menu.projectsauthorizations.element!!!");
	  
	  waitForElementPresent("//span[text()='project']",20);
	  org.testng.Assert.assertTrue(selenium.isElementPresent("//span[text()='project']"));
	  
	 int StartLeft = selenium.getElementPositionLeft("//div[text()='admin@company.com']").intValue();
	 int StartTop = selenium.getElementPositionTop("//div[text()='admin@company.com']").intValue();
	 int PositionLeft = selenium.getElementPositionLeft("//span[text()='project']").intValue();
	 int PositionTop = selenium.getElementPositionTop("//span[text()='project']").intValue();
	 int PositionWith = selenium.getElementWidth("//span[text()='project']").intValue();
	 int PositionHigh = selenium.getElementHeight("//span[text()='project']").intValue();
	 
	 int endLeft = Math.round(PositionLeft + (PositionWith / 2)) ;
	 int endTop = Math.round(PositionTop + (PositionHigh / 2));
	 System.out.println("Start: (" + StartLeft + "," + StartTop + ")");
	 System.out.println("Position: (" + PositionLeft + "," + PositionTop + ")");
	 System.out.println("END: (" + endLeft + "," + endTop + ")");
	 
	 String movementsString = (endLeft - StartLeft) + "," + (endTop - StartTop);
//	 selenium.dragAndDropToObject("//div[text()='admin@company.com']", "//span[text()='pro_r54828_420nb']");
	 
	 selenium.dragAndDrop("//div[text()='admin@company.com']",movementsString);
	 selenium.mouseDownAt("//div[text()='admin@company.com']", movementsString);
	 selenium.mouseMoveAt("//span[text()='project']",movementsString);
	 selenium.mouseUpAt("//span[text()='project']", movementsString);
  }

}
