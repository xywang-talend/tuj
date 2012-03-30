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
public class DataModelTypesElementOperationTest extends SWTBotForMDMServiewView {

	private SWTBotTree conceptBotTree;

	private SWTBotTree typesBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	private SWTBotTreeItem typeNode;

	private SWTBotTreeItem elementNode;

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
		elementNode = typesBotTree.getTreeItem("ComplexTypeEntityType")
				.expand().getNode("subelement");
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
	public void CreateComplexType() {
		elementNode.contextMenu("Create a Complex Type").click();
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
	public void CreateSimpleType() {
		elementNode.contextMenu("Create a Simple Type").click();
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
	public void editElementTest() {
		elementNode.contextMenu("Edit Element").click();
		SWTBotShell newEntityShell = bot.shell("Edit Business Element");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Business Element Name").setText("element");
		sleep();
		bot.button("OK").click(); // create a entity with a simple type
		sleep(2);
	}

	@Test
	public void addElementTest() {
		// SWTBotTreeItem groupItem = conceptNode.getNode("ReportingType");
		elementNode.contextMenu("Add Element (after)").click();
		SWTBotShell newEntityShell = bot.shell("Add a new Business Element");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Business Element Name").setText("element");
		sleep();
		bot.button("OK").click(); // create a entity with a simple type
		sleep(2);
		Assert.assertNotNull(typesBotTree.getTreeItem("ComplexTypeEntityType")
				.expand().getNode("element  [0...1]"));
	}

	// @Test
	public void copyElementTest() {
		elementNode.contextMenu("Copy Element").click();
		sleep();
		elementNode.contextMenu("Paste Element").click();
		sleep();
		SWTBotShell saveShell = bot.shell("Copy Element");
		saveShell.activate();
		bot.button("OK").click();
		sleep();
	}

	@Test
	public void changeToComplexTypeTest() {
		elementNode.contextMenu("Change to a Complex Type").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Complex Type Properties");
		changeTypeShell.activate();
		bot.radio("Sequence").click();
		bot.button("OK").click();
		sleep(2);
	}

	@Test
	public void changeToSimpleTypeTest() {
		elementNode.contextMenu("Change to a Simple Type").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Make Simple Type");
		changeTypeShell.activate();
		bot.radio("Custom").click();
		sleep();
		bot.ccomboBoxWithLabel("Type").setSelection(0);
		sleep();
		bot.button("OK").click();
		sleep(2);
	}

	@Test
	public void setLabelsTest() {
		elementNode.contextMenu("Set the Labels").click();
		sleep();
		SWTBotShell shell = bot.shell("Set the Labels");
		shell.activate();
		bot.comboBox().setSelection(0);
		bot.text().setText("en");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox().setSelection(1);
		bot.text().setText("fr");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.table().select(1);
		bot.buttonWithTooltip("Del").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	@Test
	public void setDescriptionsTest() {
		elementNode.contextMenu("Set the Descriptions").click();
		sleep();
		SWTBotShell shell = bot.shell("Set the Descriptions of This Element");
		shell.activate();
		bot.comboBox().setSelection(0);
		bot.text().setText("enlish descriptions");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox().setSelection(1);
		bot.text().setText("french descriptions");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.table().select(1);
		bot.buttonWithTooltip("Del").click();
		sleep();
		bot.button("OK").click();
	}

	@Test
	public void setWriteAccessTest() {
		elementNode.contextMenu("Set the Roles with Write Access").click();
		SWTBotShell newViewShell = bot
				.shell("Set The Roles That Have Write Access");
		newViewShell.activate();
		bot.ccomboBox().setSelection(0);
		bot.buttonWithTooltip("Add").click();

		bot.ccomboBox().setSelection(1);
		bot.buttonWithTooltip("Add").click();

		bot.table().select(0);
		bot.buttonWithTooltip("Move down the selected item").click();
		sleep(2);
		bot.buttonWithTooltip("Move up the selected item").click();
		sleep(2);

		bot.table().select(0);
		bot.buttonWithTooltip("Delete the selected item").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	@Test
	public void setNoAccessTest() {
		elementNode.contextMenu("Set the Roles with No Access").click();
		SWTBotShell newViewShell = bot
				.shell("Set The Roles That Cannot Access This Field");
		newViewShell.activate();
		bot.ccomboBox().setSelection(0);
		bot.buttonWithTooltip("Add").click();

		bot.ccomboBox().setSelection(1);
		bot.buttonWithTooltip("Add").click();

		bot.table().select(0);
		bot.buttonWithTooltip("Move down the selected item").click();
		sleep(2);
		bot.buttonWithTooltip("Move up the selected item").click();
		sleep(2);

		bot.table().select(1);
		bot.buttonWithTooltip("Delete the selected item").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	// @Test
	public void setWorkflowAccessTest() {
		elementNode.contextMenu("Set the Workflow Access").click();
		SWTBotShell shell = bot.shell("Set the Workflow Access");
		shell.activate();
	}

	@Test
	public void setForeignKeyTest() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				mainpage.doSave(new NullProgressMonitor());
			}
		});
		elementNode.contextMenu("Set the Foreign Key").click();
		SWTBotShell shell = bot.shell("Set the Foreign Key");
		shell.activate();
		bot.buttonWithTooltip("Select xpath").click();
		// test the filter of the composite by meanwhile.see bug 0016511
		bot.textWithLabel("Filter:").setText("R");
		sleep();
		bot.textWithLabel("Filter:").setText("U");
		sleep();
		bot.textWithLabel("Filter:").setText("");
		sleep();
		bot.tree().select(0);
		sleep();
		bot.button("Add").click();
		sleep();
		shell = bot.shell("Set the Foreign Key");
		shell.activate();
		bot.button("OK").click();
	}

	@Test
	public void setForeignKeyFilterTest() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				mainpage.doSave(new NullProgressMonitor());
			}
		});
		elementNode.contextMenu("Set the Foreign Key Filter").click();
		SWTBotShell shell = bot.shell("Set Foreign Key Filter");
		shell.activate();
		bot.buttonWithTooltip("Add").click();
		// TODO:check
		// bot.buttonWithTooltip("Select Xpath").click();
		//
		// bot.tree().expandNode("BrowseItem").select("Owner");
		// sleep();
		// bot.button("Add").click();
		// sleep();

		bot.text().setText("filter");
		sleep();
		bot.button("OK").click();
	}

	@Test
	public void setForeignKeyInfoTest() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				mainpage.doSave(new NullProgressMonitor());
			}
		});
		elementNode.contextMenu("Set the Foreign Key Infos").click();
		SWTBotShell shell = bot.shell("Set the Foreign Key Infos");
		shell.activate();
		bot.buttonWithTooltip("Select xpath").click();
		// test the filter of the composite meanwhile.
		bot.textWithLabel("Filter:").setText("R");
		sleep();
		bot.textWithLabel("Filter:").setText("U");
		sleep();
		bot.textWithLabel("Filter:").setText("");
		sleep();
		bot.tree().select(0);
		sleep();
		bot.button("Add").click();
		sleep();
		shell.activate();
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.button("OK").click();
	}

	@Test
	public void setFacetTest() {
		elementNode.contextMenu("Set the facet message").click();
		sleep();
		SWTBotShell shell = bot
				.shell("Set multilingual facet error messages for the content of this element");
		shell.activate();
		bot.comboBox().setSelection(0);
		bot.text().setText("test error facet in English");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox().setSelection(1);
		bot.text().setText("test error facet in French");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.table().select(1);
		bot.buttonWithTooltip("Del").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	@Test
	public void setDisplayFormatTest() {
		elementNode.contextMenu("Set the display format").click();
		sleep();
		SWTBotShell shell = bot
				.shell("Set the display format for the content of this element");
		shell.activate();
		bot.comboBox().setSelection(0);
		bot.text().setText("test error format in English");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox().setSelection(1);
		bot.text().setText("test error format in French");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.table().select(1);
		bot.buttonWithTooltip("Del").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	// @Test
	public void copyXpathTest() {
		// TODO:it dose nothing now,need to check
		elementNode.contextMenu("Copy Xpath").click();
		sleep();

	}

}
