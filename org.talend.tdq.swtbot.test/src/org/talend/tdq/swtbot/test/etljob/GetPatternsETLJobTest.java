package org.talend.tdq.swtbot.test.etljob;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.JobHelper;
import org.talend.swtbot.test.commons.SWTBotUtils;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class GetPatternsETLJobTest extends TalendSwtbotForTdq{
	
    private static String executionResult;

	@Test
	public void getPatternsETLJob(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree =new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class)));
		SWTBotTreeItem item = tree.expandNode("Libraries").getNode(3).expand().getNode(0).select();
		SWTBotUtils.clickContextMenu(item, "Get Patterns");
		try {
			bot.waitUntil(Conditions.shellIsActive("Confirm"));
			bot.button("No").click();
		} catch (TimeoutException e) {
			
		}
	
		bot.sleep(2000);
		bot.viewByTitle("Repository").setFocus();
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Job Designs").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Run job");
		 try {
	        	bot.shell("Find Errors in Jobs").close();
	        } catch (WidgetNotFoundException e) {
	        }

	        DefaultCondition condition = new DefaultCondition() {

	            public boolean test() throws Exception {
	                return bot.button(" Run").isEnabled();
	            }

	            public String getFailureMessage() {
	                return "job did not finish running";
	            }
	        };
	        bot.waitUntil(condition, 6000);
		  executionResult = bot.styledText().getText();
		  System.out.println("aaaaaaaaaa"+executionResult+"ddddddddddd");
		  String result = JobHelper.execResultFilter(executionResult);
		  System.out.println("aaaaaaaaaa"+result+"ddddddddddd");
		    if(result != null &&  !"".equals(result))
		        	Assert.fail("this job can't run correctly");
    	

		
	}
	@After
	public void afterClass(){
		JobHelper.deletleJob();
		
		bot.menu("Window").menu("Perspective").menu("Profiler").click();
		bot.sleep(2000);
	
	}
	

}
