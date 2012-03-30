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
package org.talend.swtbot.mdm.test.serverview.serviceconfiguration;

import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ServiceConfigurationTest extends SWTBotForMDMServiewView {

	private SWTBotTreeItem scItem;

	@Before
	public void runBeforeEveryTest() {
		scItem = serverItem.getNode("Service Configuration");
		scItem.expand();
		scItem.doubleClick();
		sleep(2);
	}

	@After
	public void runAfterEveryTest() {
		bot.activeEditor().close();
	}

	@Test
	public void serviceConfigurationContentTest() {

		bot.comboBox().setSelection("smtp");
		bot.button("Check").click();
		// Assert.assertEquals("Connection sucessfully!",
		// bot.text(1).getText());
		sleep();

		bot.comboBox().setSelection("svn");
		bot.button("Check").click();
		// Assert.assertEquals("Connection sucessfully!",
		// bot.text(1).getText());
		sleep();

		bot.comboBox().setSelection("workflow");
		bot.button("Check").click();
		// Assert.assertEquals("Connection sucessfully!",
		// bot.text(1).getText());
		sleep();
	}
}
