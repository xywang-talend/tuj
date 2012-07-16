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
public class RetrieveSchemaInContextModeTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static final String DBNAME = "mysql";

    private static final String TABLENAME = "autotest";

    @Before
    public void createDBConnection() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        repositories.add(ERepositoryObjectType.CONTEXT);
        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table " + TABLENAME + "(id int, name varchar(20))";
        dbItem.executeSQL(sql);
    }

    @Test
    public void retrieveSchemaInContextMode() {
        dbItem.getItem().doubleClick();
        gefBot.shell("Database Connection").activate();
        gefBot.button("Next >").click();
        gefBot.button("Export as context").click();
        gefBot.shell("Create / Edit a context group").activate();
        gefBot.button("Finish").click();
        gefBot.button("Finish").click();
        gefBot.shell("Modification").activate();
        gefBot.button("No").click();
        dbItem.retrieveDbSchema(TABLENAME);
        Assert.assertNotNull("schemas did not retrieve", dbItem.getSchema(TABLENAME));
    }

    @After
    public void removePreviouslyCreateItems() {
        String sql = "drop table " + TABLENAME;
        dbItem.executeSQL(sql);
    }
}
