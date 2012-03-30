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
package org.talend.swtbot.mdm.test.repositoryview;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.talend.mdm.repository.ui.navigator.MDMRepositoryView;


/**
 * SWTBot test super class for MDM Repository View
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class SWTBotForMDMRepositoryView {
    protected static SWTWorkbenchBot bot = new SWTWorkbenchBot();

    protected static SWTBotTreeItem repositoryItem;

    private static SWTBotTree repositoryTree;

    private static Tree swtTree;

    private static final long ONE_MINUTE_IN_MILLISEC = 60000;
    
    private static boolean isLoggined = false;

    private static SWTBotView view;

    private static void initRepositoryView() {
       view = bot
                .viewById(MDMRepositoryView.VIEW_ID);
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
        repositoryTree = new SWTBotTree(swtTree);
        repositoryItem=repositoryItem.getNode(0);
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("beforeClass");
        if (!isLoggined) {
            // SWTBotView welcomeView = bot.viewByTitle("Welcome");
            // if (welcomeView != null)
            // welcomeView.close();
            bot.perspectiveByLabel("MDM").activate();
            view.show();

            initRepositoryView();
            //importDemo();
            bot.waitUntil(Conditions.widgetIsEnabled(repositoryTree),
                    ONE_MINUTE_IN_MILLISEC * 10);
            isLoggined = true;
        }
    }

    private static void importDemo() {
        repositoryItem.contextMenu("Import Items").click();
        SWTBotShell shell=bot.shell("Import Repository items");
        shell.activate();
        bot.radio("Select archive file:").click();
        bot.button("Import from Talend Exchange").click();
        SWTBotShell importDstarShell = bot
                .shell("Import from Talend Exchange options");
        importDstarShell.activate();
        bot.table().select(1);
        bot.button("OK").click();
        bot.waitUntil(Conditions.shellIsActive("Import Repository items"));

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


    protected static void sleep() {
        bot.sleep(1000);
    }

    protected static void sleep(int count) {
        bot.sleep(1000 * count);
    }
}
