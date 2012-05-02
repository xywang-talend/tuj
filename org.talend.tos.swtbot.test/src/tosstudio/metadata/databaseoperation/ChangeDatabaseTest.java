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
package tosstudio.metadata.databaseoperation;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ChangeDatabaseTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static final String DBNAME = "mysql";

    private static final String DATABASE_NAME = "autotest2";

    @Before
    public void createDBConnection() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create database " + DATABASE_NAME;
        dbItem.executeSQL(sql);
    }

    @Test
    public void changeDatabase() {
        SWTBotShell schemaShell = null;
        SWTBotTreeItem treeItem = null;
        dbItem.getItem().doubleClick();
        schemaShell = gefBot.shell("Database Connection").activate();
        gefBot.button("Next >").click();
        gefBot.textWithLabel("DataBase").setText(DATABASE_NAME);
        gefBot.button("Finish").click();
        if ("TIS".equals(System.getProperty("buildType"))) {
            gefBot.shell("Confirm Reload Connection").activate();
            Utilities.deselectDefaultSelection("reload");
            gefBot.radio("don't reload").click();
            gefBot.button("OK").click();
        }
        gefBot.shell("Modification").activate();
        gefBot.button("No").click();

        dbItem.getItem().contextMenu("Retrieve Schema").click();
        schemaShell = gefBot.shell("Schema").activate();
        gefBot.button("Next >").click();
        gefBot.waitUntil(Conditions.waitForWidget(widgetOfType(Tree.class)), 10000);
        treeItem = gefBot.treeInGroup("Select Schema to create").getTreeItem(DATABASE_NAME);
        schemaShell.close();

        Assert.assertNotNull("database did not change", treeItem);
    }

    @After
    public void removePreviouslyCreateItems() {
        String sql = "drop database " + DATABASE_NAME;
        dbItem.executeSQL(sql);
    }
}
