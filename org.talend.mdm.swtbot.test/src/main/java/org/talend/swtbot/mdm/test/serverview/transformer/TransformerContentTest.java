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
package org.talend.swtbot.mdm.test.serverview.transformer;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

/**
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class TransformerContentTest extends SWTBotForMDMServiewView {

	private SWTBotTreeItem jobParentItem;

	private SWTBotTreeItem jobCategoryItem;

	private SWTBotTreeItem jobItem = null;

	@Before
	public void runBeforeEveryTest() {
		jobParentItem = serverItem.getNode("Job Repository");
		jobParentItem.expand();

		jobCategoryItem = jobParentItem.getNode("Deployed Jobs");
		if (jobCategoryItem.getItems().length > 0) {
			jobItem = jobCategoryItem.getNode(0);
			jobItem.doubleClick();
		}
	}

	@After
	public void runAfterEveryTest() {
	}

	@Test
	public void checkTest() {
		if (jobItem != null)
			bot.button("Check").click();
	}
}
