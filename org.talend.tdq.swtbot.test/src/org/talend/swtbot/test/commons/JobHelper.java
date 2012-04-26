package org.talend.swtbot.test.commons;

//Copyright (C) 2006-2012 Talend Inc. - www.talend.com

import java.io.BufferedReader;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
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
	    	bot.viewByTitle("DQ Repository").setFocus();
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
    /**
     *  
        
            gefBot.table(0).getTableItem(componentLabel).select();
            gefBot.button("OK").click();
            if (componentLabel.equals("tFileInputPositional"))
                gefBot.button("OK").click();
        }
        if (gefBot.activeShell().getText().equals("Added context"))
            gefBot.button("Yes").click();
    }
     */



    /**
     * Link input component to tLogRow.
     * 
     * @param jobEditor
     * @param component The input component
     * @param rowName The name of row in the context menu of component.
     * @param point Where to put component 'tLogRow'
     * @param tLogRowName Actual name of component 'tLogRow' in job.
     */
//    public static void connect2TLogRow(SWTBotGefEditor jobEditor, SWTBotGefEditPart component, String rowName, Point point,
//            String tLogRowName) {
//        Utilities.dndPaletteToolOntoJob(jobEditor, "tLogRow", point);
//        SWTBotGefEditPart tLogRow = UTIL.getTalendComponentPart(jobEditor, tLogRowName);
//        Assert.assertNotNull("can not get component '" + tLogRowName + "'", tLogRow);
//        connect(jobEditor, component, tLogRow, rowName);
//    }
//
//    /**
//     * Link input component to tLogRow. "tLogRow_1" as default component name.
//     * 
//     * @param jobEditor
//     * @param component The input component
//     * @param rowName The name of row in the context menu of component.
//     * @param point Where to put component 'tLogRow'
//     */
//    public static void connect2TLogRow(SWTBotGefEditor jobEditor, SWTBotGefEditPart component, String rowName, Point point) {
//        connect2TLogRow(jobEditor, component, rowName, point, "tLogRow_1");
//    }
//
//    /**
//     * Link input component to tLogRow. "tLogRow_1" as default component name. "Main" as default row name.
//     * 
//     * @param jobEditor
//     * @param component The input component
//     * @param point Where to put component 'tLogRow'
//     */
//    public static void connect2TLogRow(SWTBotGefEditor jobEditor, SWTBotGefEditPart component, Point point) {
//        connect2TLogRow(jobEditor, component, "Main", point);
//    }
//
//    /**
//     * Link input component to tLogRow. "Main" as default row name.
//     * 
//     * @param jobEditor
//     * @param component The input component
//     * @param point Where to put component 'tLogRow'
//     * @param tLogRowName Actual name of component 'tLogRow' in job.
//     */
//    public static void connect2TLogRow(SWTBotGefEditor jobEditor, SWTBotGefEditPart component, Point point, String tLogRowName) {
//        connect2TLogRow(jobEditor, component, "Main", point, tLogRowName);
//    }
//
//    public static void connect(SWTBotGefEditor jobEditor, SWTBotGefEditPart sourceComponent, SWTBotGefEditPart targetComponent,
//            String rowName) {
//        jobEditor.select(sourceComponent).setFocus();
//        sourceComponent.click();
//        jobEditor.clickContextMenu("Row").clickContextMenu(rowName);
//        jobEditor.click(targetComponent);
//        jobEditor.save();
//    }
//
//    public static void connect(SWTBotGefEditor jobEditor, SWTBotGefEditPart sourceComponent, SWTBotGefEditPart targetComponent) {
//        connect(jobEditor, sourceComponent, targetComponent, "Main");
//    }
//
//    /**
//     * Helper method for activate components from palette to job. Same as
//     * <code>jobEditor.activateTool(toolLabel).click(locationOnJob.x, locationOnJob.y);</code>
//     * 
//     * @param jobEditor
//     * @param toolLabel
//     * @param locationOnJob
//     */
//    public void activateTool(SWTBotGefEditor jobEditor, String toolLabel, Point locationOnJob) {
//        GEFBOT.viewByTitle("Palette").setFocus();
//        GEFBOT.textWithTooltip("Enter component prefix or template (*, ?)").setText(toolLabel);
//        GEFBOT.toolbarButtonWithTooltip("Search").click();
//        GEFBOT.sleep(500);
//
//        SWTBotGefFigureCanvas paletteFigureCanvas = new SWTBotGefFigureCanvas((FigureCanvas) GEFBOT.widget(WidgetOfType
//                .widgetOfType(FigureCanvas.class)));
//        SWTBotGefFigureCanvas jobFigureCanvas = new SWTBotGefFigureCanvas((FigureCanvas) GEFBOT.widget(
//                WidgetOfType.widgetOfType(FigureCanvas.class), jobEditor.getWidget()));
//
//        int x = 50;
//        int y = 50;
//        int folderLevel = 1;
//        if (toolLabel.contains("tFile") || toolLabel.contains("tAdvanced"))
//            folderLevel = 2;
//
//        DndUtil dndUtil = new DndUtil(jobEditor.getWidget().getDisplay());
//        dndUtil.dragAndDrop(paletteFigureCanvas, new Point(x, y + 20 * folderLevel), jobFigureCanvas, locationOnJob);
//    }
//
//    public static String getExpectResultFromFile(String fileName) {
//        String result = null;
//        try {
//            File resultFile = Utilities.getFileFromCurrentPluginSampleFolder(fileName);
//            BufferedReader reader = new BufferedReader(new FileReader(resultFile));
//            String tempStr = null;
//            StringBuffer rightResult = new StringBuffer();
//            while ((tempStr = reader.readLine()) != null)
//                rightResult.append(tempStr + "\n");
//            result = rightResult.toString().trim();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }

}

