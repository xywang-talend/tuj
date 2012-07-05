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
package tisstudio.metadata.db.cdc.mysql;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities.DbConnectionType;
import org.talend.swtbot.items.TalendDBItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateSubscribersTableTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem, copy_of_dbItem;

    private static final String DB_NAME = "mysql";

    private boolean isSubscriberCreated = false;

    @Before
    public void createDb() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, DbConnectionType.MYSQL);
        dbItem.create();
        copy_of_dbItem = (TalendDBItem) dbItem.copyAndPaste();
    }

    @Test
    public void createSubscribersTableTest() {
        dbItem.getParentNode().expandNode(dbItem.getItemFullName()).getNode("CDC Foundation").contextMenu("Create CDC").click();
        gefBot.shell("Create Change Data Capture").activate();
        gefBot.button("...").click();
        gefBot.shell("Repository Content").activate();
        gefBot.tree().expandNode("Db Connections").select(copy_of_dbItem.getItemFullName());
        gefBot.button("OK").click();
        gefBot.button("Create Subscriber").click();
        gefBot.shell("Create Subscriber and Execute SQL Script").activate();
        gefBot.button("Execute").click();
        gefBot.shell("Execute SQL Statement").activate();
        if ("Table 'tsubscribers' already exists".equals(gefBot.label(1).getText())) {
            isSubscriberCreated = true;
            gefBot.button("Cancel").click();
            gefBot.button("Close").click();
            gefBot.button("Cancel").click();
            Assert.fail("Table 'tsubscribers' already exists");
        }
        gefBot.button("OK").click();
        isSubscriberCreated = true;
        gefBot.button("Close").click();
        gefBot.button("Finish").click();
        copy_of_dbItem.retrieveDbSchema("tsubscribers");
        Assert.assertNotNull("schema 'tsubscribers' did not create in database", copy_of_dbItem.getSchema("tsubscribers"));
    }

    @After
    public void cleanUp() {
        String sql = null;
        if (isSubscriberCreated)
            sql = "drop table tsubscribers;";
        dbItem.executeSQL(sql);
    }
}
