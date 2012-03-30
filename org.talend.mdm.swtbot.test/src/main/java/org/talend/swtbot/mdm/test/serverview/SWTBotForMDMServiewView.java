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
package org.talend.swtbot.mdm.test.serverview;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * 
 * SWTBot test super class for MDM Repository View
 */
public class SWTBotForMDMServiewView {

	protected static SWTWorkbenchBot bot = new SWTWorkbenchBot();

	protected static SWTBotTreeItem serverItem;

	private static SWTBotTree serverTree;

	private static Tree swtTree;

	private static boolean isLoggined = false;

	private static final long ONE_MINUTE_IN_MILLISEC = 60000;

	public static void login() {

		bot.viewByTitle("MDM Server").toolbarButton("Add MDM Server Location")
				.click();
		SWTBotShell shell = bot.shell("Talend MDM Studio Login");
		bot.waitUntil(Conditions.shellIsActive("Talend MDM Studio Login"),
				ONE_MINUTE_IN_MILLISEC * 10);
		shell.activate();
		sleep();
		bot.comboBoxWithLabel("Description(*)").setText("administrator");
		sleep();
		bot.textWithLabel("Username").setText("admin");
		sleep();
		bot.textWithLabel("Password").setText("talend");
		sleep();
		if (bot.comboBoxWithLabel("Version").itemCount() > 0)
			bot.comboBoxWithLabel("Version").setSelection(0);
		sleep();
		bot.checkBox("Save this MDM Server Location").select();
		sleep();
		bot.button("OK").click();
		bot.waitUntil(
				Conditions.shellCloses(bot.shell("Progress Information")),
				ONE_MINUTE_IN_MILLISEC * 10);
	}

	private static void initServerView() {
		final SWTBotView view = bot
				.viewById("org.talend.mdm.workbench.views.ServerView");
		view.show();
		view.setFocus();
		// bot.perspectiveById("org.talend.mdm.perstective").activate();
		view.getWidget().getDisplay().syncExec(new Runnable() {

			public void run() {
				// SWTBotTree
				// tree=bot.treeWithLabel("http://localhost:8080/talend/TalendPort[HEAD] admin");
				Composite comp = (Composite) view.getWidget();
				comp = (Composite) comp.getChildren()[0];

				swtTree = (Tree) comp.getChildren()[0];
			}
		});
		serverTree = new SWTBotTree(swtTree);
		serverItem = serverTree
				.expandNode("http://localhost:8080/talend/TalendPort [HEAD] admin");
		serverItem.expand();
	}

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("beforeClass");
		if (!isLoggined) {
			// SWTBotView welcomeView = bot.viewByTitle("Welcome");
			// if (welcomeView != null)
			// welcomeView.close();
			bot.menu("Window").menu("Open Perspective").menu("Other...")
					.click();
			final SWTBotShell shellShowView = bot.shell("Open Perspective");
			bot.waitUntil(Conditions.shellIsActive("Open Perspective"));
			shellShowView.widget.getDisplay().syncExec(new Runnable() {

				public void run() {
					shellShowView.widget.setSize(new Point(300, 600));
				}
			});
			shellShowView.activate();
			bot.table().select("MDM");
			bot.button("OK").click();
			bot.perspectiveByLabel("MDM").activate();
			bot.viewByTitle("MDM Server").show();

			login();
			initServerView();
			importDemo();
			bot.waitUntil(Conditions.widgetIsEnabled(serverTree),
					ONE_MINUTE_IN_MILLISEC * 10);
			isLoggined = true;
		}
	}

	private static void importDemo() {
		serverItem.contextMenu("Import").click();
		bot.shell("Import Objects").activate();
		bot.radio("Select archive file:").click();
		bot.button("Import from Talend Exchange").click();
		SWTBotShell importDstarShell = bot
				.shell("Import from Talend Exchange options");
		importDstarShell.activate();
		bot.table().select(1);
		bot.button("OK").click();
		bot.waitUntil(Conditions.shellIsActive("Import Objects"));
		SWTBotShell shell = bot.shell("Import Objects");
		bot.waitUntil(Conditions.shellCloses(importDstarShell));
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

	@AfterClass
	public static void AfterClass() {
		System.out.println("AfterClass");
		// logout();
		bot.sleep(2000);
	}

	public static void logout() {
		serverItem.contextMenu("Logout").click();
	}

	protected static void sleep() {
		bot.sleep(1000);
	}

	protected static void sleep(int count) {
		bot.sleep(1000 * count);
	}
}
