package org.talend.swtbot.mdm.test.serverview.eventmanagement;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

@RunWith(SWTBotJunit4ClassRunner.class)
public class EventManagerTest extends SWTBotForMDMServiewView {

	private SWTBotTreeItem eventManagerNode;

	private SWTBotTreeItem eventManagementItem;

	@Before
	public void runBeforeEveryTest() {
		eventManagementItem = serverItem.getNode("Event Management");
		eventManagementItem.expand();

		eventManagerNode = eventManagementItem.getNode("Event Manager");
	}

	@After
	public void runAfterEveryTest() {

	}

	@Test
	public void browseTest() {
		eventManagerNode.contextMenu("Browse").click();
		sleep(5);
	}

	// @Test
	public void statusTest() {
		bot.buttonWithTooltip("Start").click();
		sleep();
		bot.buttonWithTooltip("Suspend").click();
		sleep();
		bot.buttonWithTooltip("Stop").click();
		sleep();
	}

	@Test
	public void searchTest() {
		bot.comboBoxWithLabel("Status").setSelection(1);
		bot.buttonWithTooltip("Search").click();
		sleep();
		bot.activeEditor().close();
	}
}
