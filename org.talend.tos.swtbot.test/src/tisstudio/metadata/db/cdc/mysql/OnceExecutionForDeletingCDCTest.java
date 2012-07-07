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
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
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
public class OnceExecutionForDeletingCDCTest extends TalendSwtBotForTos {

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
    public void onceExecutionForDeletingCDCTest() {
        isSubscriberCreated = dbItem.createCDCWith(copy_of_dbItem);
        dbItem.getCDCFoundation().contextMenu("Delete CDC").click();
        gefBot.shell("Create Subscriber and Execute SQL Script").activate();
        gefBot.button("Execute").click();
        try {
            gefBot.waitUntil(Conditions.shellIsActive("Execute SQL Statement"), 60000);
        } catch (TimeoutException e) {
            gefBot.button("Cancel").click();
            Assert.fail(e.getMessage());
        }
        gefBot.shell("Execute SQL Statement").activate();
        gefBot.button("OK").click();
        isSubscriberCreated = false;

        Assert.assertFalse("execute button is still enable", gefBot.button("Execute").isEnabled());
        gefBot.button("Close").click();
    }

    @After
    public void cleanUp() {
        if ("Execute SQL Statement".equals(gefBot.activeShell().getText())) {
            if ("OK".equals(gefBot.button(0).getText()))
                gefBot.button("OK").click();
            else
                gefBot.button("Cancel").click();
        }

        String sql = null;
        if (isSubscriberCreated)
            sql = "drop table tsubscribers;";
        dbItem.executeSQL(sql);
    }
}
