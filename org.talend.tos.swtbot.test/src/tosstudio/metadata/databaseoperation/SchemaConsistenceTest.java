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
public class SchemaConsistenceTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static String DB_NAME = "mysql";

    private static String TABLE1 = "test1";

    private static String TABLE2 = "test2";

    @Before
    public void createMetadata() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table " + TABLE1 + "(id int, name varchar(20));\n" + "create table " + TABLE2
                + "(id int, name varchar(20));";
        dbItem.executeSQL(sql);
    }

    @Test
    public void schemaConsistenceTest() {
        SWTBotShell tempShell = null;
        dbItem.getItem().contextMenu("Retrieve Schema").click();
        tempShell = gefBot.shell("Schema").activate();
        gefBot.button("Next >").click();
        gefBot.waitUntil(Conditions.waitForWidget(widgetOfType(Tree.class)), 10000);
        SWTBotTreeItem catalog = gefBot.treeInGroup("Select Schema to create").expandNode(System.getProperty("mysql.dataBase"));
        catalog.getNode(TABLE1).check();
        catalog.getNode(TABLE2).check();
        gefBot.waitUntil(Conditions.widgetIsEnabled(gefBot.button("Next >")), 30000);
        gefBot.button("Next >").click();

        int schemaCount = gefBot.tableInGroup("Schema", 0).rowCount();
        Assert.assertEquals("did not add all selected schemas", 2, schemaCount);

        gefBot.button("< Back").click();
        catalog.getNode(TABLE2).uncheck();
        gefBot.button("Next >").click();

        schemaCount = gefBot.tableInGroup("Schema", 0).rowCount();
        Assert.assertEquals("the de-selected schemas still in the list", 1, schemaCount);
        tempShell.close();
    }

    @After
    public void removePreviousCreateItem() {
        gefBot.closeAllShells();
        String sql = "drop table " + TABLE1 + ";\n" + "drop table " + TABLE2;
        dbItem.executeSQL(sql);
    }
}
