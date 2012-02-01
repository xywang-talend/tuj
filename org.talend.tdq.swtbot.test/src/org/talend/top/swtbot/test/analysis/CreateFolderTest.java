package org.talend.top.swtbot.test.analysis;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.test.commons.ContextMenuHelper;
import org.talend.swtbot.test.commons.TalendSwtbotForTdq;

@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateFolderTest extends TalendSwtbotForTdq {

	private final String FOLDERNAME = "folder1";

	@Test
	public void createFolder() {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Data Profiling").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "Create Folder");
		bot.waitUntil(Conditions.shellIsActive("New folder"));
		bot.textWithLabel("Name").setText(FOLDERNAME);
		bot.button("Finish").click();
		Assert.assertNotNull(tree.expandNode("Data Profiling").getNode(0)
				.expand().select(FOLDERNAME + " (0)"));
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		tree.expandNode("Recycle Bin").select(FOLDERNAME);
		ContextMenuHelper.clickContextMenu(tree, "Delete");
		bot.waitUntil(Conditions.shellIsActive("Delete forever"));
		bot.button("Yes").click();
	}

}
