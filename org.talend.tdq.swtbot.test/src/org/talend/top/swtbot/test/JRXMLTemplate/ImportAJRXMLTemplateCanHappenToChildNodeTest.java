package org.talend.top.swtbot.test.JRXMLTemplate;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
//import org.junit.Assert;
import org.junit.Test;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

public class ImportAJRXMLTemplateCanHappenToChildNodeTest extends TalendSwtbotForTdq{
	
	@Test
	public void ImportJRXMLTemplateCanHappenToChildNode(){
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries").getNode("JRXML Template").select();
		ContextMenuHelper.clickContextMenu(tree, "Import Built-in JRXML");
		bot.sleep(20000);
		//should not appear the option 
//		bot.viewByTitle("DQ Repository").setFocus();
//		tree = new SWTBotTree((Tree)bot.widget(WidgetOfType.widgetOfType(Tree.class),
//				bot.viewByTitle("DQ Repository").getWidget()));
//		tree.expandNode("Libraries","JRXML Template").getNode(0).select();
//		ContextMenuHelper.clickContextMenu(tree, "Import Built-in JRXML");
//		bot.sleep(10000);
	}
	
	

}
