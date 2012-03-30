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
package org.talend.swtbot.mdm.test.serverview.datamodel;

import junit.framework.Assert;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.xsdeditor.XSDEditor;

@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelSchemaKeyOperationTest extends SWTBotForMDMServiewView {

	private SWTBotTree conceptBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	private SWTBotTreeItem keyNode;

	@Before
	public void runBeforeEveryTest() {
		dataModelItem = serverItem.getNode("Data Model [HEAD]");
		dataModelItem.expand();
		if (dataModelItem.getNodes().contains("TestDataModel"))
			dataModelItem.getNode("TestDataModel").doubleClick();
		else
			newDatamodel();

		final SWTBotEditor editor = bot.editorByTitle("TestDataModel");
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				XSDEditor ep = (XSDEditor) editor.getReference().getPart(true);
				mainpage = (DataModelMainPage) ep.getSelectedPage();
			}
		});
		Tree conceptTree = mainpage.getElementsViewer().getTree();
		conceptBotTree = new SWTBotTree(conceptTree);
		newEntity();
	}

	private void newDatamodel() {
		dataModelItem.contextMenu("New").click();
		SWTBotShell newDataContainerShell = bot.shell("New Data Model");
		newDataContainerShell.activate();
		SWTBotText text = bot
				.textWithLabel("Enter a name for the New Instance");
		text.setText("TestDataModel");
		sleep();
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.button("OK").click();
		sleep();
		Assert.assertNotNull(dataModelItem.getNode("TestDataModel"));
		sleep(2);
	}

	private void newEntity() {
		conceptBotTree.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("ComplexTypeEntity");
		sleep();
		bot.button("OK").click();
		sleep(2);
		keyNode = conceptBotTree.getTreeItem("ComplexTypeEntity").expand()
				.getNode("ComplexTypeEntity");
	}

	@After
	public void runAfterEveryTest() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				mainpage.doSave(new NullProgressMonitor());
				bot.activeEditor().close();
			}
		});
		dataModelItem.getNode("TestDataModel").contextMenu("Delete").click();
		bot.button("OK").click();
	}

	@Test
	public void newEntityTest() {
		keyNode.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("ComplexEntity");
		sleep();
		bot.button("OK").click(); // create a entity with a simple type
		sleep(2);
		Assert.assertNotNull(conceptBotTree.getTreeItem("ComplexEntity"));
	}

	@Test
	public void addKeyTest() {
		keyNode.contextMenu("Add Key").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Add a new Key");
		changeTypeShell.activate();
		bot.ccomboBox(1).setSelection(1);
		bot.text().setText("Test");
		bot.button("OK").click();
		Assert.assertNotNull(conceptBotTree.getTreeItem("ComplexTypeEntity")
				.expand().getNode("Test"));
	}

	@Test
	public void deleteKeyTest() {
		addKeyTest();
		conceptBotTree.getTreeItem("ComplexTypeEntity").expand()
				.getNode("Test").contextMenu("Delete Key").click();
		sleep();
	}

	@Test
	public void addFieldTest() {
		keyNode.contextMenu("New Field").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Select one field");
		changeTypeShell.activate();
		bot.ccomboBox().setText("Field");
		bot.button("OK").click();
	}

	@Test
	public void editKeyTest() {
		addKeyTest();
		conceptBotTree.getTreeItem("ComplexTypeEntity").expand()
				.getNode("Test").contextMenu("Edit Key").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Edit Key");
		changeTypeShell.activate();
		bot.text().setText("TestEditKey");
		bot.button("OK").click();
	}
}
