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
package org.talend.swtbot.mdm.test.serverview.common;

import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ImportObjectsTest extends SWTBotForMDMServiewView {

	private static final long ONE_MINUTE_IN_MILLISEC = 60000;

	@Before
	public void runBeforeEveryTest() {
	}

	@After
	public void runAfterEveryTest() {
	}

	// @Test
	public void importObjectsTest() {
		serverItem.contextMenu("Import").click();
		bot.shell("Import Objects").activate();
		bot.radio("Select archive file:").click();
		bot.button("Import from Talend Exchange").click();
		bot.shell("Import from Talend Exchange options").activate();
		bot.table().select(1);
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellIsActive("Import Objects"));
		SWTBotShell shell = bot.shell("Import Objects");
		sleep(10);
		bot.button("Finish").click();
		bot.waitUntil(Conditions.shellCloses(shell));
		sleep();
		bot.shell("Confirm Overwrite").activate();
		bot.button("Yes To All").click();
		bot.waitUntil(
				Conditions.shellCloses(bot.shell("Progress Information")),
				ONE_MINUTE_IN_MILLISEC * 10);

	}
}
