package org.talend.swtbot.test.commons;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.forms.finder.finders.SWTFormsBot;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.AbstractMatcher;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.hamcrest.Description;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.talend.core.model.process.INode;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.designer.core.ui.editor.connections.ConnLabelEditPart;
import org.talend.designer.core.ui.editor.connections.ConnectionLabel;
import org.talend.designer.core.ui.editor.nodes.NodePart;

public class TalendSwtbotForTdq {
	
	
	   /**
  * 
  */
	private static final String GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS = "Generation Engine Initialization in progress..."; //$NON-NLS-1$

	private static final long ONE_MINUTE_IN_MILLISEC = 600000;
	static public SWTWorkbenchBot bot = new SWTWorkbenchBot();

	static public SWTFormsBot formBot = new SWTFormsBot();

	protected static boolean isGenerationEngineInitialised = false;



    static public SWTGefBot gefBot = new SWTGefBot();


    private static String buildTitle;

    public static List<ERepositoryObjectType> repositories = new ArrayList<ERepositoryObjectType>();
	
    public static Map<ERepositoryObjectType, List<String>> reporsitoriesFolders = new Hashtable<ERepositoryObjectType, List<String>>();
    /**
     * wait for the Generation engine to be intialised, and this is done only once during the lifetime of the
     * application.
     */

	@BeforeClass
	public static void before() {
		System.out.println("Initialization ..............");
		if (!isGenerationEngineInitialised) {
			try {
				bot.waitUntil(
						Conditions
								.shellIsActive(GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS),
						ONE_MINUTE_IN_MILLISEC);
				SWTBotShell shell = bot
						.shell(GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS);
				bot.waitUntil(Conditions.shellCloses(shell),
						ONE_MINUTE_IN_MILLISEC);
//				ONE_MINUTE_IN_MILLISEC * 10);
			} catch (TimeoutException te) {
				System.out
						.println("timeout execption when waiting for "
								+ GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS
								+ " shell, we never the less continue hoing it has been closed on purpose.");
			}
			isGenerationEngineInitialised = true;
		}
		

		try {
			bot.viewByTitle("Welcome").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Welcome page!");
		}
		
		
		try {
			bot.menu("Window").menu("Perspective").menu("Profiler")
			.click();
		} catch (WidgetNotFoundException e1) {
			System.out.println("Haven't found Profiler!");
		}
		
		
		try {
			bot.cTabItem("Cheat Sheets").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Cheat Sheets");
		}
		try {
			bot.cTabItem("Talend Platform").close();
		} catch (Exception e) {
			System.out.println("Haven't found Talend Platform");
		}
//		try {
//			bot.menu("Window").menu("Show view...").click();
//			bot.waitUntil(Conditions.shellIsActive("Show View"));
//			SWTBotTree tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
//					.widgetOfType(Tree.class)));
//			tree.expandNode("General").select("Error Log");
//			bot.button("OK").click();
//		} catch (Exception e) {
//			System.out.println("can't find the view Error log");
//		} 
	}
	
//	@AfterClass
//	public static void after(){
//		try {
//			// empty recycle bin
//			SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
//					WidgetOfType.widgetOfType(Tree.class),
//					bot.viewByTitle("DQ Repository").getWidget()));
//			List<String> lists = tree.expandNode("Recycle Bin").getNodes();
//			if(lists.size()!=0) {
//				System.out.println("-- Try to empty recycle bin ---");
//				tree.getTreeItem("Recycle Bin").contextMenu("Empty recycle bin").click();
//				bot.waitUntil(Conditions.shellIsActive("Empty recycle bin"));
//				SWTBotShell shell = bot.shell("Empty recycle bin");
//				bot.button("Yes").click();
//				bot.waitUntil(Conditions.shellCloses(shell));
//			}
//		} catch (Exception e) {
//			System.out.println("Couldn't Empty recycle bin !");
//		}
//		
//	}
	  /**
     * return the first talend component EditPart (NodePart) that relates to the label componentLabel for a given
     * editor.
     * 
     * @param gefEditor the editor to look in for the component
     * @param componentLabel the displayed label of the component
     * @return the component found with the given label or null if none found
     */
    public SWTBotGefEditPart getTalendComponentPart(SWTBotGefEditor gefEditor, final String componentLabel) {
        List<SWTBotGefEditPart> editParts = gefEditor.editParts(new AbstractMatcher<EditPart>() {

            protected boolean doMatch(Object item) {
                boolean result = false;
                if (item instanceof NodePart) {
                    // get the parent and look for one children of type NodeLabelEditPart that has a figure named
                    // componentName
                    EditPart np = (EditPart) item;
                    INode node = (INode) np.getModel();
                    result = componentLabel.equals(node.getLabel());
                } else if (item instanceof ConnLabelEditPart) {
                    // get the parent and look for one children of type NodeLabelEditPart that has a figure named
                    // componentName
                    EditPart np = (EditPart) item;
                    ConnectionLabel cl = (ConnectionLabel) np.getModel();
                    result = componentLabel.equals(cl.getLabelText());
                }// else return default result that is false
                return result;
            }

            public void describeTo(Description description) {
                description.appendText("NodePart with NodeLabelEditPart figure named (").appendText(componentLabel)
                        .appendText(")");
            }
        });
        return editParts.size() > 0 ? editParts.get(0) : null;
    }

	
	
	public SWTBotTableItem getTableItem(String table) {
		SWTBotTableItem tableItem;
		
		int index = table.indexOf("(");
		String first = table.substring(0, index -1);
		String second = table.substring(index + 1, table.length() -1);
		
		tableItem = bot.table().getTableItem(first.toLowerCase()+ "(" + second.toUpperCase() +")");
		if(tableItem == null)
			tableItem = bot.table().getTableItem(first.toUpperCase()+ "(" + second.toLowerCase() +")");
		if(tableItem == null)
			tableItem = bot.table().getTableItem(table.toLowerCase());
		if(tableItem == null)
			tableItem = bot.table().getTableItem(table.toUpperCase());
		
		return tableItem;
	}
	
	@AfterClass
	public static void resetActivePerspective(){
    	SWTWorkbenchBot bot = new SWTWorkbenchBot();
    	bot.closeAllShells();
    	bot.saveAllEditors();
    	bot.closeAllEditors();
    	TalendSwtbotTdqCommon.cleanUpRepository();
    	bot.resetActivePerspective();
    }
		
}
