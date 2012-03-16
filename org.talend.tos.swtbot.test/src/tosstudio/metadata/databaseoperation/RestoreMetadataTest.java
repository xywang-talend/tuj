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
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendRecycleBinItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class RestoreMetadataTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static final String DB_NAME = "mysql";

    private static final String TABLE_NAME = "test";

    @Before
    public void createMetadata() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table " + TABLE_NAME + "(id int, name varchar(20));";
        dbItem.executeSQL(sql);
        dbItem.retrieveDbSchema(TABLE_NAME);
    }

    @Test
    public void deleteAndRestoreMetadata() {
        TalendSchemaItem schemaItem = dbItem.getSchema(TABLE_NAME);
        schemaItem.delete();

        TalendRecycleBinItem metadata = MetadataHelper.getRecycleBinItem(TABLE_NAME);
        metadata.restore();
        Assert.assertNull("item still in recycle bin", metadata.getItem());
        Assert.assertNotNull("item did not restore from recycle bin", dbItem.getSchema(TABLE_NAME));
    }

    @After
    public void removePreviousCreateItem() {
        String sql = "drop table " + TABLE_NAME + ";";
        dbItem.executeSQL(sql);
    }
}
