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
public class DataModelTypesTypeOperationTest extends SWTBotForMDMServiewView {

	private SWTBotTree conceptBotTree;

	private SWTBotTree typesBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	private SWTBotTreeItem typeNode;

	@Before
	public void runBeforeEveryTest() {
		dataModelItem = serverItem.getNode("Data Model [HEAD]");
		dataModelItem.expand();

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
		sleep(4);

		final SWTBotEditor editor = bot.editorByTitle("TestDataModel");
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				XSDEditor ep = (XSDEditor) editor.getReference().getPart(true);
				mainpage = (DataModelMainPage) ep.getSelectedPage();
			}
		});
		Tree elemetnsTree = mainpage.getElementsViewer().getTree();
		conceptBotTree = new SWTBotTree(elemetnsTree);
		Tree typesTree = mainpage.getTypesViewer().getTree();
		typesBotTree = new SWTBotTree(typesTree);
		newEntity();
		bot.activeEditor().save();

	}

	public void newEntity() {
		conceptBotTree.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("ComplexTypeEntity");
		sleep();
		bot.button("OK").click();
		sleep(2);
		typeNode = typesBotTree.getTreeItem("ComplexTypeEntityType");
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
	public void createComplexTypeTest() {
		typeNode.contextMenu("Create a Complex Type").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Complex Type Properties");
		changeTypeShell.activate();
		bot.ccomboBox(0).setText("ComplexType");
		bot.radio("Sequence").click();
		bot.button("OK").click();
		sleep(2);
		Assert.assertNotNull(typesBotTree.getTreeItem("ComplexType"));
	}

	@Test
	public void addSimpleTypeTest() {
		typeNode.contextMenu("Create a Simple Type").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("New Simple Type");
		changeTypeShell.activate();
		bot.radio("Custom").click();
		sleep();
		bot.ccomboBoxWithLabel("Type").setSelection(0);
		sleep();
		bot.button("OK").click();
		sleep();
		Assert.assertNotNull(typesBotTree.getTreeItem("PICTURE : string"));
	}

	@Test
	public void addElementTest() {
		typeNode.contextMenu("Add Element").click();
		SWTBotShell newEntityShell = bot.shell("Add a new Business Element");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Business Element Name").setText("testElement");
		sleep();
		bot.button("OK").click(); // create a entity with a simple type
		sleep(2);
		Assert.assertNotNull(typeNode.expand().getNode("testElement  [0...1]"));
	}

	@Test
	public void editComplexTypeTest() {
		typeNode.contextMenu("Edit a Complex Type").click();
		sleep();
		SWTBotShell editTypeShell = bot.shell("Edit Complex Type");
		editTypeShell.activate();
		bot.text().setText("TextEditComplexType");
		bot.button("OK").click();
		Assert.assertNotNull(typesBotTree.getTreeItem("TextEditComplexType"));
	}

	// @Test
	public void deleteComplexTypeTest() {
		createComplexTypeTest();
		typesBotTree.getTreeItem("ComplexType")
				.contextMenu("Delete type definition").click();
		sleep();
	}
}
