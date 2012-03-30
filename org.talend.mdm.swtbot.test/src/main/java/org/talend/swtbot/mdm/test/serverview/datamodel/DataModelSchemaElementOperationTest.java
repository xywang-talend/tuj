package org.talend.swtbot.mdm.test.serverview.datamodel;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.editors.xsdeditor.XSDEditor;

@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelSchemaElementOperationTest extends SWTBotForMDMServiewView {

	private SWTBotTree conceptBotTree;

	private DataModelMainPage mainpage;

	private SWTBotTreeItem entityNode;

	private SWTBotTreeItem elementNode;

	private SWTBotTreeItem groupItem;

	private SWTBotTreeItem dataModelItem;

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
		sleep(2);

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
		newElement();
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

	public void newEntity() {
		conceptBotTree.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("ComplexTypeEntity");
		sleep();
		bot.button("OK").click();
		sleep(2);
		entityNode = conceptBotTree.getTreeItem("ComplexTypeEntity");
		entityNode.select();
		bot.toolbarButtonWithTooltip("Expand...", 0).click();
	}

	public void newElement() {
		groupItem = entityNode.getNode("ComplexTypeEntityType");
		groupItem.contextMenu("Add Element").click();

		SWTBotShell newElementShell = bot.shell("Add a new Business Element");
		newElementShell.activate();
		bot.textWithLabel("Business Element Name").setText("Ele");
		sleep();
		bot.button("OK").click();
		sleep(2);
		elementNode = groupItem.expand().getNode("Ele  [0...1]");
		elementNode.select();
	}

	// new feature in 4.2,see bug 0017128
	@Test
	public void autoPlaceCursorTest() {
		elementNode.select();
		bot.cTabItem(1).activate();
		sleep();
		bot.cTabItem(2).activate();
		entityNode = conceptBotTree.getTreeItem("ComplexTypeEntity");
		entityNode.select();
		bot.toolbarButtonWithTooltip("Expand...", 0).click();
	}

	@Test
	public void editElementTest() {
		elementNode.contextMenu("Edit Element").click();
		SWTBotShell newEleShell = bot.shell("Edit Business Element");
		newEleShell.activate();
		bot.textWithLabel("Business Element Name").setText("ConceptTest");
		sleep();
		bot.button("OK").click();
		sleep(2);
		Assert.assertNotNull(groupItem.getNode("ConceptTest  [0...1]"));
	}

	@Test
	public void addElementTest() {
		// SWTBotTreeItem groupItem = conceptNode.getNode("ReportingType");
		elementNode.contextMenu("Add Element (after)").click();
		SWTBotShell newEntityShell = bot.shell("Add a new Business Element");
		newEntityShell.activate();
		bot.textWithLabel("Business Element Name").setText("testElement");
		sleep();
		bot.button("OK").click();
		sleep(2);
		Assert.assertNotNull(groupItem.getNode("testElement  [0...1]"));
	}

	// @Test
	public void copyElementTest() {
		// TODO:I can not paste a element after I copy the element.
		elementNode.contextMenu("Copy Element").click();
		sleep();
		elementNode.contextMenu("Paste Element").click();
		sleep();
		SWTBotShell saveShell = bot.shell("Paste Element");
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
		// TODO:need assertion
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
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("English Label: en"));
	}

	@Test
	public void setDescriptionsTest() {
		elementNode.contextMenu("Set the Descriptions").click();
		sleep();
		SWTBotShell shell = bot.shell("Set the Descriptions of This Element");
		shell.activate();
		bot.comboBox().setSelection(0);
		bot.text().setText("enlish description");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.comboBox().setSelection(1);
		bot.text().setText("french description");
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.table().select(1);
		bot.buttonWithTooltip("Del").click();
		bot.button("OK").click();
		sleep();
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("English Description: enlish description"));
		sleep();
	}

	@Test
	public void setWriteAccessTest() {
		elementNode.contextMenu("Set the Roles with Write Access").click();
		SWTBotShell newViewShell = bot
				.shell("Set The Roles That Have Write Access");
		newViewShell.activate();
		bot.ccomboBox().setSelection("System_Web");
		bot.buttonWithTooltip("Add").click();

		bot.ccomboBox().setSelection("System_Admin");
		bot.buttonWithTooltip("Add").click();

		bot.table().select(0);
		bot.buttonWithTooltip("Move down the selected item").click();
		sleep(2);
		bot.buttonWithTooltip("Move up the selected item").click();
		sleep(2);

		bot.table().select("System_Web");
		bot.buttonWithTooltip("Delete the selected item").click();
		sleep();
		bot.button("OK").click();
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("Writable By : System_Admin"));
		sleep();
	}

	@Test
	public void setNoAccessTest() {
		elementNode.contextMenu("Set the Roles with No Access").click();
		SWTBotShell newViewShell = bot
				.shell("Set The Roles That Cannot Access This Field");
		newViewShell.activate();
		bot.ccomboBox().setSelection("System_Web");
		bot.buttonWithTooltip("Add").click();

		bot.ccomboBox().setSelection("System_Admin");
		bot.buttonWithTooltip("Add").click();

		bot.table().select(0);
		bot.buttonWithTooltip("Move down the selected item").click();
		sleep(2);
		bot.buttonWithTooltip("Move up the selected item").click();
		sleep(2);

		bot.table().select("System_Admin");
		bot.buttonWithTooltip("Delete the selected item").click();
		sleep();
		bot.button("OK").click();
		sleep();
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("No Access to : System_Web"));
	}

	// @Test
	public void setWorkflowAccessTest() {
		// TODO:check this action
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
		// test the filter of the composite by meanwhile.
		bot.textWithLabel("Filter:").setText("R");
		sleep();
		bot.textWithLabel("Filter:").setText("U");
		sleep();
		bot.textWithLabel("Filter:").setText("");
		sleep();
		bot.tree().select("ComplexTypeEntity");
		sleep();
		bot.button("Add").click();
		sleep();
		shell = bot.shell("Set the Foreign Key");
		shell.activate();
		bot.button("OK").click();
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("Foreign Key:  ComplexTypeEntity"));
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
		bot.table().click(0, 2);
		// bot.buttonWithTooltip("Select Xpath").click();
		//
		// bot.tree().expandNode("BrowseItem").expandNode("anonymous type")
		// .select("Owner");
		// sleep();
		// bot.button("Add").click();
		// sleep();
		//
		// // bot.textInGroup("Custom filters").setText("filter");
		// sleep();
		bot.button("OK").click();
		// Assert.assertNotNull(elementNode.expand().getNode("Annotations")
		// .expand().getNode("Foreign Key Filter: Reporting"));
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
		SWTBotShell shell1 = bot.shell("Select Xpath ...");
		shell1.activate();
		bot.tree().select(0);
		bot.button("Add").click();
		bot.waitUntil(Conditions.shellCloses(shell1));
		shell.activate();
		bot.button("Ok").click();
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
		Assert.assertNotNull(elementNode.expand().getNode("Annotations")
				.expand().getNode("Facet_Msg_EN: test error facet in English"));
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

	@Test
	public void newEntityTest() {
		elementNode.contextMenu("New Entity").click();
		SWTBotShell newEntityShell = bot.shell("New Entity");
		newEntityShell.activate();
		// create a entity with a complex type
		bot.textWithLabel("Name:").setText("ComplexTypeEntity1");
		sleep();
		bot.button("OK").click(); // create a entity with a simple type
		sleep(2);
	}
}
