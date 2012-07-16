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

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ModifyMetadataSchemaTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static final String DBNAME = "mysql";

    private static final String TABLENAME = "autotest";

    @Before
    public void createDBConnection() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table " + TABLENAME + "(id int, name varchar(20))";
        dbItem.executeSQL(sql);
    }

    @Test
    public void modifyMetadataSchema() {
        SWTBotShell schemaShell = null;
        int rowCount = 2;
        dbItem.retrieveDbSchema(TABLENAME);
        TalendSchemaItem schema = dbItem.getSchema(TABLENAME);
        schema.getItem().doubleClick();
        schemaShell = gefBot.shell("Schema").activate();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.button("Finish").click();
        gefBot.shell("Modification").activate();
        gefBot.button("No").click();

        schema.getItem().doubleClick();
        schemaShell = gefBot.shell("Schema").activate();
        rowCount = gefBot.tableInGroup("Schema", 1).rowCount();
        schemaShell.close();
        Assert.assertEquals("schemas added did not save", 3, rowCount);
    }

    @After
    public void removePreviouslyCreateItems() {
        String sql = "drop table " + TABLENAME;
        dbItem.executeSQL(sql);
    }
}
