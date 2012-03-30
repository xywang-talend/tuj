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
package org.talend.swtbot.mdm.test.serverview.menu;

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
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class MenuContentTest extends SWTBotForMDMServiewView {

	private SWTBotTreeItem menuParentItem;

	private SWTBotTreeItem menuItem;

	@Before
	public void runBeforeEveryTest() {
		menuParentItem = serverItem.getNode("Menu [HEAD]");
		menuParentItem.expand();
		init();
	}

	@After
	public void runAfterEveryTest() {
		menuParentItem.getNode("TestMenu").contextMenu("Delete").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	private void init() {
		menuParentItem.contextMenu("New").click();
		SWTBotShell shell = bot.shell("New Menu");
		shell.activate();
		SWTBotText text = bot
				.textWithLabel("Enter a Name for the New Instance");
		text.setText("TestMenu");
		sleep();
		bot.button("OK").click();
		bot.activeEditor().save();
		sleep();
		menuItem = menuParentItem.getNode("TestMenu");
		Assert.assertNotNull(menuItem);
		sleep(2);
	}

	@Test
	public void setDescriptionTest() {
		String des = "This is a description for TestMenu";
		bot.textWithLabel("Description").setText(des);
		Assert.assertEquals(des, bot.textWithLabel("Description").getText());
	}

	// @Test
	public void editMenuEntryTest() {
		bot.tree().contextMenu("Edit").click();
		bot.shell("Edit the Menu Entry TestMenu").activate();
		bot.textWithLabel("Context").setText("TestMenu");
		bot.textWithLabel("Application").setText("TestMenu");
		bot.textWithLabel("Icon Path").setText("");// TODO:add the url of the
													// icon.
		bot.buttonWithTooltip("OK").click();
		sleep();
	}

	// @Test
	public void addBeforeEntryTest() {
		bot.tree().contextMenu("Add a menu entry before this entry").click();
		bot.shell("Edit the Menu Entry TestMenu").activate();
		bot.textWithLabel("ID").setText("BeforeEntry");
		bot.textWithLabel("Context").setText("BeforeEntry");
		bot.textWithLabel("Application").setText("BeforeEntry");
		bot.textInGroup("Menu Entry Labels").setText("BeforeEntry");
		bot.buttonWithTooltip("Add").click();
		bot.buttonWithTooltip("OK").click();
		Assert.assertNotNull(bot.tree().getTreeItem(
				"BeforeEntry - [en: BeforeEntry]"));
		sleep();
	}

	// @Test
	public void addAfterEntryTest() {
		bot.tree().contextMenu("Add a menu entry after this entry").click();
		bot.shell("Edit the Menu Entry TestMenu").activate();
		bot.textWithLabel("ID").setText("AfterEntry");
		bot.textWithLabel("Context").setText("AfterEntry");
		bot.textWithLabel("Application").setText("AfterEntry");
		bot.textInGroup("Menu Entry Labels").setText("AfterEntry");
		bot.buttonWithTooltip("Add").click();
		bot.buttonWithTooltip("OK").click();
		Assert.assertNotNull(bot.tree().getTreeItem(
				"AfterEntry - [en: AfterEntry]"));
		sleep();
	}

	// @Test
	public void addSubEntryTest() {
		bot.tree().contextMenu("Add a menu entry after this entry").click();
		bot.shell("Edit the Menu Entry TestMenu").activate();
		bot.textWithLabel("ID").setText("SubEntry");
		bot.textWithLabel("Context").setText("SubEntry");
		bot.textWithLabel("Application").setText("SubEntry");
		bot.textInGroup("Menu Entry Labels").setText("SubEntry");
		bot.buttonWithTooltip("Add").click();
		bot.buttonWithTooltip("OK").click();
		Assert.assertNotNull(bot.tree()
				.getTreeItem("TestMenu - [en: TestMenu]")
				.getNode("SubEntry - [en: SubEntry]"));
		sleep();
	}

	// @Test
	public void deleteEntryTest() {
		bot.tree().contextMenu("Delete Entry").click();
		Assert.assertNull(bot.tree().getTreeItem("TestMenu - [en: TestMenu]"));
		sleep();

	}
}
