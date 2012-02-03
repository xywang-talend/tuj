// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ChangeDatabaseAndRetrieveSchemaTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static final String DBNAME = "mysql";

    private static final String DATABASE_NAME = "autotest2";

    private static final String TABLE1 = "test1";

    private static final String TABLE2 = "test2";

    @Before
    public void createDBConnection() {
        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "use " + System.getProperty("mysql.dataBase") + ";\n" + "create table " + TABLE1
                + "(id int, name varchar(20));\n" + "create database " + DATABASE_NAME + ";\n" + "use " + DATABASE_NAME + ";\n"
                + "create table " + TABLE2 + "(id int, name varchar(20));\n";
        dbItem.executeSQL(sql);
    }

    @Test
    public void changeDatabase() {
        dbItem.retrieveDbSchema(TABLE1);
        TalendSchemaItem table1 = dbItem.getSchema(TABLE1);
        Assert.assertNotNull("did not retrieve schema", table1.getItem());

        SWTBotShell schemaShell = null;
        try {
            dbItem.getItem().doubleClick();
            schemaShell = gefBot.shell("Database Connection").activate();
            gefBot.button("Next >").click();
            gefBot.textWithLabel("DataBase").setText(DATABASE_NAME);
            gefBot.button("Finish").click();
            gefBot.shell("Confirm Reload Connection").activate();
            gefBot.button("OK").click();
            gefBot.shell("Modification").activate();
            gefBot.button("No").click();

            dbItem.getItem().contextMenu("Retrieve Schema").click();
            schemaShell = gefBot.shell("Schema").activate();
            gefBot.button("Next >").click();
            gefBot.waitUntil(Conditions.waitForWidget(widgetOfType(Tree.class)), 10000);
            SWTBotTreeItem catalog = gefBot.treeInGroup("Select Schema to create").expandNode(DATABASE_NAME);
            // catalog.getNode(TABLE1).check();
            // gefBot.waitUntil(Conditions.shellIsActive("Confirm"));
            // gefBot.button("OK").click();
            catalog.getNode(TABLE2).check();
            gefBot.button("Next >").click();
            gefBot.button("Finish").click();
            // gefBot.shell("Modification").activate();
            // gefBot.button("Yes").click();
            // gefBot.shell("No modification needed").activate();
            // gefBot.button("OK").click();

            Assert.assertNotNull("did not retrieve schema", table1.getItem());
            TalendSchemaItem table2 = dbItem.getSchema(TABLE2);
            Assert.assertNotNull("did not retrieve schema", table2.getItem());
        } catch (WidgetNotFoundException wnfe) {
            schemaShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            schemaShell.close();
            Assert.fail(e.getMessage());
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        String sql = "use " + System.getProperty("mysql.dataBase") + ";\n" + "drop table " + TABLE1 + ";\n" + "drop database "
                + DATABASE_NAME;
        dbItem.executeSQL(sql);
        Utilities.cleanUpRepository(dbItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
