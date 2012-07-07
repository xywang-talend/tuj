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

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.junit.After;
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
public class CatchDeleteTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem, copy_of_dbItem;

    private static final String DB_NAME = "mysql";

    private static final String TABLE_NAME = "autotest";

    private boolean isTableCreated = false;

    private boolean isCDCCreated = false;

    private boolean isCDCAdded = false;

    @Before
    public void createDb() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, DbConnectionType.MYSQL);
        dbItem.create();
        copy_of_dbItem = (TalendDBItem) dbItem.copyAndPaste();
        isTableCreated = dbItem.executeSQL("create table " + TABLE_NAME + "(id int, name varchar(20), primary key(id));");
        dbItem.retrieveDbSchema(TABLE_NAME);
    }

    @Test
    public void catchDeleteTest() {
        isCDCCreated = dbItem.createCDCWith(copy_of_dbItem);
        isCDCAdded = dbItem.addCDCFor(TABLE_NAME, false, false, true);

        String sql_i = "insert into " + TABLE_NAME + " values(1, 'a');\n";
        String sql_u = "update " + TABLE_NAME + " set name='b' where id=1;\n";
        String sql_d = "delete from " + TABLE_NAME + " where id=1;\n";
        dbItem.executeSQL(sql_i + sql_u + sql_d);

        SWTBotShell shell = dbItem.viewAllChangesFor(TABLE_NAME);
        SWTBotTable table = gefBot.table();
        String events = null;
        for (int i = 0; i < table.rowCount(); i++) {
            String event = table.cell(i, "TALEND_CDC_TYPE");
            if (!"D".equals(event)) {
                if (events == null)
                    events = "";
                events = event + ".";
            }
        }
        shell.close();

        Assert.assertNull("catch other events [" + events + "] besides insert", events);
    }

    @After
    public void cleanUp() {
        if (isCDCAdded)
            dbItem.deactivateCDCFor(TABLE_NAME);
        if (isCDCCreated)
            dbItem.deleteCDC();
        String sql = "";
        if (isTableCreated)
            sql = sql + "drop table " + TABLE_NAME + ";\n";
        dbItem.executeSQL(sql);
    }
}
