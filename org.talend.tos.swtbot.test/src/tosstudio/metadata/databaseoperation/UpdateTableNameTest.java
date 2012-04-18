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

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
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
public class UpdateTableNameTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static String DB_NAME = "mysql";

    private static String TABLE_NAME = "autotest1";

    private static String NEW_TABLE_NAME = "newtest";

    private boolean isNewTableCreated = false;

    @Before
    public void createMetadata() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table " + TABLE_NAME + "(id int, name varchar(20));";
        dbItem.executeSQL(sql);
    }

    @Test
    public void updateTableNameTest() {
        dbItem.retrieveDbSchema(TABLE_NAME);
        Assert.assertNotNull("schema did not retrieved", dbItem.getSchema(TABLE_NAME).getItem());

        String sql = "ALTER TABLE " + TABLE_NAME + " RENAME TO " + NEW_TABLE_NAME;
        dbItem.executeSQL(sql);
        isNewTableCreated = true;
        dbItem.retrieveDbSchema(NEW_TABLE_NAME);
        Assert.assertNotNull("schema did not retrieved", dbItem.getSchema(NEW_TABLE_NAME).getItem());
        Assert.assertNull("old schema did not delete", dbItem.getSchema(TABLE_NAME).getItem());
    }

    @After
    public void removePreviousCreateItem() {
        String sql = "drop table " + NEW_TABLE_NAME;
        if (!isNewTableCreated)
            sql = "drop table " + TABLE_NAME;
        dbItem.executeSQL(sql);
    }
}
