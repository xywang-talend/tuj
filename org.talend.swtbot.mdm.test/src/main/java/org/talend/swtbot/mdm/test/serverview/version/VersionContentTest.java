// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.swtbot.mdm.test.serverview.version;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

/**
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 * 
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class VersionContentTest extends SWTBotForMDMServiewView {

	private SWTBotTreeItem versionParentItem;

	private SWTBotTreeItem versionItem;

	@Before
	public void runBeforeEveryTest() {
		versionParentItem = serverItem.getNode("Version");
		versionParentItem.expand();

	}

	private void init() {
		versionParentItem.contextMenu("New").click();
		SWTBotShell newspShell = bot.shell("New Version");
		newspShell.activate();
		SWTBotText text = bot
				.textWithLabel("Enter a Name for the New Instance");
		text.setText("TestVersion");
		sleep();
		bot.button("OK").click();
		bot.activeEditor().save();
		sleep();
		versionItem = versionParentItem.expand().getNode("TestVersion");
		Assert.assertNotNull(versionItem);
		versionItem.doubleClick();
		sleep(2);
	}

	@After
	public void runAfterEveryTest() {

	}

	@Test
	public void setDescriptionTest() {
		init();
		String des = "This is a Version";
		bot.textWithLabel("Description").setText(des);
		Assert.assertEquals(des, bot.textWithLabel("Description").getText());
	}

	@Test
	public void setEntityIDTest() {
		bot.text(1).setText("r1");
		bot.buttonWithTooltip("Add").click();
		// String pro = "";
		// bot.styledText().setText(pro);
		// Assert.assertEquals(pro, bot.styledText().getText());
	}

	@Test
	public void setSOIDTest() {
		// bot.ccomboBoxWithLabel("Data Model").setText("DataModel");
		bot.ccomboBox(0).setText("DataModel");
		versionParentItem.expand().getNode("TestVersion").contextMenu("Delete")
				.click();
		sleep();
		bot.button("OK").click();
		sleep();
	}
}
