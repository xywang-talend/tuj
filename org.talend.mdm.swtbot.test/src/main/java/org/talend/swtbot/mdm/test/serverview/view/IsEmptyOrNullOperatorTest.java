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
package org.talend.swtbot.mdm.test.serverview.view;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotCombo;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

public class IsEmptyOrNullOperatorTest extends SWTBotForMDMServiewView {
	private SWTBotTreeItem viewParentItem;

	private SWTBotTreeItem viewItem;

	private String[] array = new String[] { "Id", "Firstname", "Lastname",
			"CommissionCode", "StartDate", "TermDate" };

	private String PREFIX = "Browse_items_";

	@Before
	public void runBeforeEveryTest() {
		viewParentItem = serverItem.getNode("View [HEAD]");
		viewParentItem.expand();

	}

	private void setElements() {
		setViewableElementsTest();
		bot.buttonWithTooltip("Add", 1).click();

	}

	private void setViewableElementsTest() {
		bot.buttonWithTooltip("Add Multiple", 0).click();

		bot.shell("Select Multiple XPaths").activate();
		// bot.comboBox().setSelection("CONF");
		// sleep();
		SWTBotTreeItem parent = bot.tree().getTreeItem("Conf").expand()
				.getNode(0).expand();
		parent.select("id");
		sleep();
		bot.button("Add").click();
		sleep();
	}

	@After
	public void runAfterEveryTest() {
		bot.activeEditor().save();
		bot.activeEditor().close();
		viewParentItem.getNode(PREFIX + "Conf").contextMenu("Delete").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	private void createView() {
		viewParentItem.contextMenu("New").click();
		SWTBotShell newViewShell = bot.shell("New View");
		newViewShell.activate();
		bot.buttonWithTooltip("Select one Entity").click();
		bot.shell("Select one Entity").activate();

		bot.comboBoxWithLabel("Data Models:").setSelection("CONF");
		bot.tree().select("Conf");
		bot.button("Add").click();
		sleep();
		bot.button("OK").click();
		sleep(2);
	}

	private void init() {
		createView();
		setElements();
	}

	// new feature in 4.2,see bug 0018359.
	// @Test
	public void isEmptyOrNullOperatorTest() {
		init();
		bot.buttonWithTooltip("Add", 2).click();
		bot.table(2).click(0, 1);
		SWTBotCombo com = bot.comboBox();
		com.setFocus();
		com.setSelection("IsEmptyOrNull");
		Assert.assertEquals("IsEmptyOrNull", bot.ccomboBox().getText());
	}
}
