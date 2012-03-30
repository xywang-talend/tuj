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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.Activator;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;
import org.talend.swtbot.mdm.test.serverview.util.Util;

/**
 * DataModelContentOperationTest is a SWTBot test class to test the operation
 * associated with the import,export.
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 * see bug 0017197.
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataModelContentTest extends SWTBotForMDMServiewView {

	private String DSTAR_DATAMODEL = "DStar.xsd";

	private SWTBotTreeItem dataModelItem;

	@Before
	public void runBeforeEveryTest() {
		dataModelItem = serverItem.getNode("Data Model [HEAD]");
		dataModelItem.expand();

		dataModelItem.contextMenu("New").click();
		SWTBotShell newDataModelShell = bot.shell("New Data Model");
		newDataModelShell.activate();
		SWTBotText text = bot
				.textWithLabel("Enter a name for the New Instance");
		text.setText("TestDataModel");
		sleep();
		bot.buttonWithTooltip("Add").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	@After
	public void runAfterEveryTest() {
		bot.activeEditor().save();
		bot.activeEditor().close();
		dataModelItem.getNode("TestDataModel").contextMenu("Delete").click();
		sleep();
		bot.button("OK").click();
		sleep();
	}

	// @Test
	public void importXSDTest() throws IOException, URISyntaxException {
		// File sourceFile = null;
		// try {
		// sourceFile = new
		// File(FileLocator.toFileURL(Platform.getBundle(Activator.PLUGIN_ID).getEntry("testDocuments"))
		// .getPath().substring(1)
		// + "testImport.xsd");
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		// File targetFile = new
		// File(Platform.getInstanceLocation().getURL().getPath().substring(1) +
		// "testImport.xsd");
		//
		// try {
		// if (sourceFile != null)
		// Util.copyFile(sourceFile, targetFile);
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// }
		bot.buttonWithTooltip("Import...").click();
		// // TODO: now SWTBot doesn't support native SWT dialogs,so this needs
		// more investigation.
		// /*
		// * SWTBotShell importDataModelShell =
		// bot.shell("Select the XML definition for XML Schema");
		// * importDataModelShell.activate();
		// bot.comboBox(1).setText("testxsd");
		// * System.out.println(bot.comboBox(1).getText() + "test");
		// bot.button("Open(O)").click();
		// */
		Util.getFileFromCurrentPluginSampleFolder(DSTAR_DATAMODEL)
				.getAbsolutePath();
	}

	// @Test
	public void importXSDSchemaFromLocalTest() {
		File sourceFile = null;
		try {
			sourceFile = new File(FileLocator
					.toFileURL(
							Platform.getBundle(Activator.PLUGIN_ID).getEntry(
									"testDocuments")).getPath().substring(1)
					+ "testImport.xsd");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File targetFile = new File(Platform.getInstanceLocation().getURL()
				.getPath().substring(1)
				+ "testImport.xsd");

		try {
			if (sourceFile != null)
				Util.copyFile(sourceFile, targetFile);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		bot.buttonWithTooltip("import/include specific Schema Namespace ...")
				.click();
		SWTBotShell importXSDSchemaShell = bot
				.shell("Import xsd schema modules");
		importXSDSchemaShell.activate();
		bot.button("Add xsd from local").click();
		/*
		 * bot.comboBox(0).setText("testxsd");
		 * System.out.println(bot.comboBox(1).getText() + "test");
		 * bot.button("Open(O)").click();
		 */
	}
}
