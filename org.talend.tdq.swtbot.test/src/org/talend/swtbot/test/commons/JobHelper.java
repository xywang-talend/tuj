package org.talend.swtbot.test.commons;

//Copyright (C) 2006-2012 Talend Inc. - www.talend.com



import java.io.File;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefFigureCanvas;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.talend.swtbot.test.commons.DndUtil;

/**
 * DOC yhbai class global comment. Detailled comment
 */
public class JobHelper  {

    private static String executionResult;
    static public SWTWorkbenchBot bot = new SWTWorkbenchBot();
    private static SWTBotTree tree;
    private static SWTGefBot gefBot = new SWTGefBot();

    /**
     * Filter all strings except the execution result.
     * 
     * @param result The result string in execution console
     * @return A string between statistics tags
     */
    public static String execResultFilter(String result) {
        if (result == null || "".equals(result))
            return null;

        String[] strs = result.split("\n");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].contains("Starting job") && !strs[i].contains("[exit code=0]") && !strs[i].contains("[statistics]")) {
                sb.append(strs[i] + "\n");
            }
        }

        return sb.toString().trim();
    }


    public static void runJob(long timeout) {
    	bot.cTabItem("Repository").setFocus();
		tree= new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),bot.viewByTitle("Repository").getWidget()));
		String jobname = tree.expandNode("Job Designs").getNode(0).getText();
		System.out.println("---------------"+jobname+"-------------");
		bot.editorByTitle("Job "+jobname).setFocus();
		String jobName = jobname.substring(0, jobname.indexOf(" "));
		System.out.println("---------------"+jobName+"------"+"Run (Job "+jobName+")-------");
		for(SWTBotView v :bot.views()){
			System.out.println("******"+v.getTitle());
		}
        runJob(jobName, timeout);
    }


    public static void runJob(String jobName, long timeout) {
    	
		try {
			bot.viewByTitle("Run job").show();
		} catch (Exception e1) {
			System.out.println("can't find run job button");
		}
		bot.viewByTitle("Run (Job "+jobName+")").setFocus();
		bot.button(" Run").click();
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
	        bot.waitUntil(condition, timeout);
	      
	        executionResult = bot.styledText().getText();
    }

    public static String getExecutionResult() {
        return executionResult;
    }
    
    public static void  deletleJob(){
    	bot.editorByTitle("Job "+tree.expandNode("Job Designs").getNode(0).getText()).close();
    	System.out.println("Job "+tree.expandNode("Job Designs").getNode(0).getText());
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Job Designs").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Delete");
		tree.expandNode("Recycle bin").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Delete forever");
		try {
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		SWTBotShell shell = bot.shell("Delete forever");
		bot.button("Yes").click();
		
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
    }
    public static void  deletlemetadata(){
    	
		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("Repository").getWidget()));
		tree.expandNode("Metadata").getNode(2).expand().getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Delete");
		tree.expandNode("Recycle bin").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree,"Delete forever");
		try {
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		SWTBotShell shell = bot.shell("Delete forever");
		bot.button("Yes").click();
		
			bot.waitUntil(Conditions.shellCloses(shell));
		} catch (Exception e) {
		}
    }
		
	    public static void  CreateJob(String fileName){
	    	bot.viewByTitle("Repository").setFocus();
	    	tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
					bot.viewByTitle("Repository").getWidget()));
			tree.expandNode("Job Designs").select();
			ContextMenuHelper.clickContextMenu(tree,"Create job");
			bot.waitUntil(Conditions.shellIsActive("New job"));
				SWTBotShell shell = bot.shell("New job");
				bot.textWithLabel("Name").setText(fileName);
				bot.button("Finish").click();
				shell.close();	
	    	
	    }
	    public static void dndPaletteToolOntoJob(SWTBotGefEditor jobEditor,String toolLable,Point point){
	    	jobEditor.activateTool(toolLable).click(point.x,point.y);
	    }
	    public static void dndMetadataOntoJob(SWTBotGefEditor jobEditor,SWTBotTreeItem sourceItem,String componentLabel,
	    		Point locationOnJob){
	    	SWTBotGefFigureCanvas figureCanvas = new SWTBotGefFigureCanvas((FigureCanvas)gefBot.widget(
	    			WidgetOfType.widgetOfType(FigureCanvas.class), jobEditor.getWidget()));
	    	DndUtil dndUtil = new DndUtil(jobEditor.getWidget().getDisplay());
	    	sourceItem.select();
	    	dndUtil.dragAndDrop(sourceItem, figureCanvas,locationOnJob);
	    	if(componentLabel != null && !"".equals(componentLabel)){
	    		gefBot.shell("Components").activate();
	    		gefBot.table(0).getTableItem(componentLabel).select();
	    		gefBot.button("OK").click();
	    	}
	   
	    	if(gefBot.activeShell().getText().equals("Added context")){
	    		gefBot.button("OK").click();
	    	}
	    	if(componentLabel.equals("tFileInputPositional")){
	    		gefBot.button("OK").click();
	    		
	    	}
	    	
	    	
	    	
	    }
	    
	    public static String getExpectResultFromFile(String fileName){
	    	
	    	String result = null;
	   // 	File resultFile = new File();
	    	return result;
	    }
	    /***
	     * public static String getExpectResultFromFile(String fileName) {
        String result = null;
        try {
            File resultFile = Utilities.getFileFromCurrentPluginSampleFolder(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(resultFile));
            String tempStr = null;
            StringBuffer rightResult = new StringBuffer();
            while ((tempStr = reader.readLine()) != null)
                rightResult.append(tempStr + "\n");
            result = rightResult.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
	     */
   

}

