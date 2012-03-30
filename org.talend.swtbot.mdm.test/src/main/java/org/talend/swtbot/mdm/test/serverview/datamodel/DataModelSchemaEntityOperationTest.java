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

/**
 * 
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelSchemaEntityOperationTest extends SWTBotForMDMServiewView {

	private SWTBotTree conceptBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem dataModelItem;

	private SWTBotTreeItem conceptNode;

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

	private void newEntity() {
		conceptBotTree.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("ComplexTypeEntity");
		sleep();
		bot.button("OK").click();
		sleep(2);
		conceptNode = conceptBotTree.getTreeItem("ComplexTypeEntity");
		conceptNode.select();
		bot.toolbarButtonWithTooltip("Expand...", 0).click();
	}

	private void newElement() {
		conceptBotTree.getTreeItem("ComplexTypeEntity")
				.getNode("ComplexTypeEntityType").contextMenu("Add Element")
				.click();

		SWTBotShell newElementShell = bot.shell("Add a new Business Element");
		newElementShell.activate();
		bot.textWithLabel("Business Element Name").setText("Ele");
		sleep();
		bot.button("OK").click();
		sleep(2);
		conceptNode = conceptBotTree.getTreeItem("ComplexTypeEntity");
		conceptNode.select();
		bot.toolbarButtonWithTooltip("Expand...").click();
	}

	@Test
	public void newEntityTest() {
		conceptNode.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("newEntity");
		sleep();
		bot.button("OK").click();
		sleep(2);
	}

	@Test
	public void deleteEntityTest() {
		conceptNode.select();
		conceptNode.contextMenu("Delete Entity").click();
		sleep();
	}

	@Test
	public void editEntityTest() {
		conceptNode.contextMenu("Edit Entity").click();
		SWTBotShell editEntityShell = bot.shell("Edit Entity");
		editEntityShell.activate();
		bot.textWithLabel("Enter a new Name for the Entity").setText(
				"EditEntity");
		sleep();
		bot.button("OK").click();
		sleep(2);
		Assert.assertEquals("EditEntity", conceptNode.getText());
		// new feature in 4.2,see bug 0017070:
		// Assert.assertNotNull(conceptNode.getNode("EditEntity"));
	}

	@Test
	public void generateDefaultViewTest() {
		bot.activeEditor().save();
		conceptNode.contextMenu("Generate default Browse Items Views").click();
		sleep();
		SWTBotShell generateViewShell = bot
				.shell("Generate default Browse Items Views");
		generateViewShell.activate();
		bot.button("Finish").click();
	}

	// @Test
	public void copyEntityTest() {
		conceptNode.contextMenu("Copy Entity").click();
		sleep();
		conceptNode.select();
		conceptNode.contextMenu("Paste Entity").click();
		sleep();
		SWTBotShell saveShell = bot.shell("Copy Entity");
		saveShell.activate();
		bot.button("OK").click();
		sleep();
	}

	@Test
	public void changeToSimpleTypeTest() {
		conceptNode.contextMenu("Change to a Simple Type").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Make Simple Type");
		changeTypeShell.activate();
		bot.radio("Custom").click();
		sleep();
		bot.ccomboBoxWithLabel("Type").setSelection(1);
		sleep();
		bot.button("OK").click();
		sleep(2);
	}

	@Test
	public void changeToComplexTypeTest() {
		conceptNode.contextMenu("Change to a Complex Type").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Complex Type Properties");
		changeTypeShell.activate();
		bot.radio("Sequence").click();
		bot.button("OK").click();
		sleep(2);
	}

	@Test
	public void addKeyTest() {
		conceptNode.contextMenu("Add Key").click();
		sleep();
		SWTBotShell changeTypeShell = bot.shell("Add a new Key");
		changeTypeShell.activate();
		bot.ccomboBox(1).setSelection(1);
		bot.text().setText("Test");
		bot.button("OK").click();
	}

	@Test
	public void setLabelsTest() {
		conceptNode.contextMenu("Set the Labels").click();
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
		conceptNode.contextMenu("Set the Descriptions").click();
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
	public void setLookupFieldsTest() {
		newElement();
		conceptNode.contextMenu("Set Lookup Fields").click();
		sleep();
		SWTBotShell shell = bot.shell("Set Lookup Fields");
		shell.activate();
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
	}

	@Test
	public void setWriteAccessTest() {
		conceptNode.contextMenu("Set the Roles with Write Access").click();
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
		conceptNode.contextMenu("Set the Roles with No Access").click();
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
		conceptNode.contextMenu("Set the Workflow Access").click();
		SWTBotShell shell = bot.shell("Set the Workflow Access");
		shell.activate();
		bot.buttonWithTooltip("Add Multiple").click();
		bot.button("OK").click();
	}

	@Test
	public void genarateWorkflowTest() {
		conceptNode.contextMenu("Genarate Workflow").click();
		SWTBotShell shell = bot.shell("Genarate Workflow");
		shell.activate();
		bot.buttonWithTooltip("Add").click();
		bot.button("OK").click();
	}

	// @Test
	public void addValidationRuleTest() {
		conceptNode.contextMenu("Set the Validation Rule").click();
		SWTBotShell shell = bot.shell("Add a Validation Rule");
		shell.activate();
		bot.text().setText("vadation rule");
		bot.buttonWithTooltip("Add").click();
		bot.button("OK").click();
	}

	// @Test
	public void deleteValidationRuleTest() {
		conceptNode.contextMenu("Delete All Validation Rules").click();
		SWTBotShell shell = bot.shell("Confirm");
		shell.activate();
		bot.button("OK").click();
	}
}
