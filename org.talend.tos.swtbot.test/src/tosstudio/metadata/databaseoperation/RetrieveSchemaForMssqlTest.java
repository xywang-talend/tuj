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
public class RetrieveSchemaForMssqlTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static String DB_NAME = "mssql";

    private static String TABLE_NAME = "test";

    @Before
    public void createMetadata() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MSSQL);
        dbItem.create();
        String sql = "create table " + TABLE_NAME + "(id int, name varchar(20))";
        dbItem.executeSQL(sql);
    }

    @Test
    public void retrieveSchema() {
        dbItem.retrieveDbSchema(TABLE_NAME);
        Assert.assertNotNull("did not retrieve schema", dbItem.getSchema(TABLE_NAME));
    }

    @After
    public void removePreviousCreateItem() {
        String sql = "drop table " + TABLE_NAME;
        dbItem.executeSQL(sql);
    }
}
