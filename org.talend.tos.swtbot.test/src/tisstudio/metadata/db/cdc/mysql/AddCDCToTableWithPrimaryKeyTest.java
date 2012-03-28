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
public class AddCDCToTableWithPrimaryKeyTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem, copy_of_dbItem;

    private static final String DB_NAME = "mysql";

    private static final String TABLE_NAME = "autotest";

    private static final String TSUBSCRIBERS = "tsubscribers";

    private static final String TCDC_TABLE = "tcdc_" + TABLE_NAME;

    private boolean isTableCreated = false;

    @Before
    public void createDb() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, DbConnectionType.MYSQL);
        dbItem.create();
        copy_of_dbItem = (TalendDBItem) dbItem.copyAndPaste();
        dbItem.executeSQL("create table " + TABLE_NAME + "(id int, name varchar(20), primary key(id));");
        isTableCreated = true;
        dbItem.retrieveDbSchema(TABLE_NAME);
    }

    @Test
    public void addCDCToTableWithPrimaryKeyTest() {
        dbItem.createCDCWith(copy_of_dbItem);
        dbItem.addCDCFor(TABLE_NAME);

        copy_of_dbItem.retrieveDbSchema(TSUBSCRIBERS, TCDC_TABLE);
        Assert.assertNotNull("schema" + TSUBSCRIBERS + " did not create in new database", copy_of_dbItem.getSchema(TSUBSCRIBERS));
        Assert.assertNotNull("schema" + TCDC_TABLE + " did not create in new database", copy_of_dbItem.getSchema(TCDC_TABLE));
    }

    @After
    public void cleanUp() {
        dbItem.deleteCDC();
        String sql = "";
        if (isTableCreated)
            sql = sql + "drop table " + TABLE_NAME + ";\n";
        dbItem.executeSQL(sql);
    }
}
