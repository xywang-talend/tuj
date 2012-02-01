package org.talend.swtbot.test.commons;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.forms.finder.finders.SWTFormsBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.BeforeClass;

public class TalendSwtbotForTdq {

	private static final String GENERATION_ENGINE_INITIALIZATION_IN_PROGRESS = "Generation Engine Initialization in progress..."; //$NON-NLS-1$

	private static final long ONE_MINUTE_IN_MILLISEC = 600000;

	// static public SWTGefBot bot = new SWTGefBot();

	static public SWTWorkbenchBot bot = new SWTWorkbenchBot();

	static public SWTFormsBot formBot = new SWTFormsBot();

	protected static boolean isGenerationEngineInitialised = false;

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
		
//		try {
//			bot.viewByTitle("Welcome").close();
//			bot.menu("Window").menu("Perspective").menu("Data Profiler")
//					.click();
//			bot.cTabItem("Cheat Sheets").close();
//		} catch (WidgetNotFoundException e) {
//			System.out.println("Welcome page!");
//		}
//	}
		try {
			bot.viewByTitle("Welcome").close();
//			.click();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Welcome page!");
		}
		
		try {
			bot.menu("Window").menu("Perspective").menu("Data Profiler")
			.click();
		} catch (WidgetNotFoundException e1) {
			System.out.println("Haven't found Data Profiler!");
		}
		
		try {
			bot.cTabItem("Cheat Sheets").close();
		} catch (WidgetNotFoundException e) {
			System.out.println("Haven't found Cheat Sheets");
		}
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
	
	
}
