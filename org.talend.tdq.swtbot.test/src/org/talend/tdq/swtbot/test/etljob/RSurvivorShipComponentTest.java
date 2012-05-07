package org.talend.tdq.swtbot.test.etljob;


import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.talend.swtbot.test.commons.TalendSwtbotForTdq;
import org.talend.swtbot.test.commons.TalendSwtbotTdqCommon;
import org.talend.swtbot.test.commons.JobHelper;

public class RSurvivorShipComponentTest extends TalendSwtbotForTdq{
	
	private static final String FILENAME = "delimitedFile";
	private static final String JOBNAME ="jobTest";
	
	@Before
	public void beforeClass(){
		gefBot.menu("Window").menu("Perspective").menu("Integration").click();
		TalendSwtbotTdqCommon.createJobFileDelimitedConnectionTxt(bot, FILENAME);
		JobHelper.CreateJob(JOBNAME);
	}
		
	
	@Test
	public void RSurvivorShipComponent(){
		SWTBotGefEditor jobEditor = gefBot.gefEditor("Job "+JOBNAME+" 0.1");
		bot.viewByTitle("Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		SWTBotTreeItem sourceItem = tree.expandNode("Metadata","File delimited").getNode(0).select();
		
		JobHelper.dndMetadataOntoJob(jobEditor, sourceItem, "fFileInputDelimited", new Point(100,100));
		SWTBotGefEditPart metadata = getTalendComponentPart(jobEditor, "fFileInputDelimited");
	    Assert.assertNotNull("can not get component 'tRowGenerator'", metadata);
		JobHelper.dndPaletteToolOntoJob(jobEditor, "tMatchGroup", new Point(250,100));
		SWTBotGefEditPart tMatchGroup1 = getTalendComponentPart(jobEditor, "tMatchGroup_1");
	    Assert.assertNotNull("can not get component 'tRowGenerator'", tMatchGroup1);
		JobHelper.dndPaletteToolOntoJob(jobEditor, "tLogRow", new Point(400,100));
		SWTBotGefEditPart tLogRow1 = getTalendComponentPart(jobEditor, "tLogRow_1");
	    Assert.assertNotNull("can not get component 'tRowGenerator'", tLogRow1);
		JobHelper.dndPaletteToolOntoJob(jobEditor, "tRuleSurvivorship", new Point(550,100));
		SWTBotGefEditPart tRuleSurvivorship1 = getTalendComponentPart(jobEditor, "tRuleSurvivorship_1");
	    Assert.assertNotNull("can not get component 'tRowGenerator'", tRuleSurvivorship1);
		JobHelper.dndPaletteToolOntoJob(jobEditor, "tLogRow", new Point(700,100));
		SWTBotGefEditPart tLogRow2 = getTalendComponentPart(jobEditor, "tLogRow_2");
	    Assert.assertNotNull("can not get component 'tRowGenerator'", tLogRow2);
	    jobEditor.select(metadata);
	    jobEditor.clickContextMenu("Row").clickContextMenu("Main");
	    jobEditor.click(tMatchGroup1);
	    SWTBotGefEditPart rowMain = jobEditor.getEditPart("row1 (Main)");
	    Assert.assertNotNull("can not draw row line", rowMain);
	    /** edit the tMatchGroup1*/
	    tMatchGroup1.doubleClick();
	    gefBot.viewByTitle("Component").setFocus();
	    gefBot.buttonWithTooltip("Add",0).click();
	    gefBot.table(0).click(0, 0);
	    gefBot.ccomboBox("id").setSelection("colour");
	    gefBot.table(0).click(0, 1);
	    gefBot.ccomboBox("Exact").setSelection("Jaro");
	    gefBot.buttonWithTooltip("Add",1).click();
	   jobEditor.select(tMatchGroup1);
	   jobEditor.clickContextMenu("Row").clickContextMenu("main");
	   jobEditor.click(tLogRow1);
	   SWTBotGefEditPart rowMain2 = jobEditor.getEditPart("row2 (Main)");
	   Assert.assertNotNull("can not draw row line",rowMain2);
	   /** edit the tLogRow1*/
	   tLogRow1.doubleClick();
	   gefBot.viewByTitle("Component").setFocus();
	   gefBot.radio("Table (print values in cells of a table)").click();
	   jobEditor.select(tLogRow1);
	   jobEditor.clickContextMenu("Row").clickContextMenu("main");
	   jobEditor.click(tRuleSurvivorship1);
	   SWTBotGefEditPart rowMain3 = jobEditor.getEditPart("row3 (Main)");
	   Assert.assertNotNull("can not draw row line",rowMain3);
	   /** edit the tRuleSurvivorship1*/
	   tRuleSurvivorship1.doubleClick();
	   gefBot.ccomboBox(1).setSelection("GID");
	   gefBot.ccomboBox(2).setSelection("GRP_SIZE");
	   gefBot.table(0).click(0, 1);
	   gefBot.text("").setText("rulename");	   
	   gefBot.table(0).click(0, 3);
	   gefBot.ccomboBox("").setSelection("Smalllest");
	   jobEditor.select(tRuleSurvivorship1);
	   jobEditor.clickContextMenu("Row").clickContextMenu("main");
	   jobEditor.click(tLogRow2);
	   SWTBotGefEditPart rowMain4 = jobEditor.getEditPart("row4 (Main)");
	   Assert.assertNotNull("can not draw row line",rowMain4);
	   /** edit the tLogRow2*/
	   tLogRow1.doubleClick();
	   gefBot.viewByTitle("Component").setFocus();
	   gefBot.radio("Table (print values in cells of a table)").click();
	   gefBot.button(2).click();
	   SWTBotShell shell = gefBot.shell("Progress  Information");
	   gefBot.waitUntil(Conditions.shellCloses(shell), 6000);
	   if(gefBot.activeShell().getText().equals("Conflict")){
		   gefBot.button("OK").click();
	   }
	   
	   jobEditor.save();

       /* Run the job */
       JobHelper.runJob(6000);
	   
       String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
	    if(result != null &&  !"".equals(result))
	        	Assert.fail("this job can't run correctly"+result+"**********");
		/*¶ÁÎÄ¼þ*/
	}
	
	@After
	public void afterClass(){
	    JobHelper.deletleJob();
	    JobHelper.deletlemetadata();
	    bot.menu("Window").menu("Perspective").menu("Profiler").click();
		bot.sleep(2000);
	        
		
	}

}
