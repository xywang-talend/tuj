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

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities.DbConnectionType;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AddSubscriberWhileAddingCDCTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem, copy_of_dbItem;

    private static final String DB_NAME = "mysql";

    private static final String TABLE_NAME = "autotest";

    private static final String SUBSCRIBER_NAME = "s1";

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
    public void addSubscriberWhileAddingCDCTest() {
        isCDCCreated = dbItem.createCDCWith(copy_of_dbItem);
        isCDCAdded = dbItem.addCDCFor(TABLE_NAME, SUBSCRIBER_NAME);

        copy_of_dbItem.retrieveDbSchema("tsubscribers");
        TalendSchemaItem schema = copy_of_dbItem.getSchema("tsubscribers");
        SWTBotShell shell = schema.dataViewer();

        SWTBotTree tree = gefBot.tree();
        List<String> subscriberList = new ArrayList<String>();
        for (int i = 0; i < tree.rowCount(); i++)
            subscriberList.add(tree.cell(i, "TALEND_CDC_SUBSCRIBER_NAME"));
        shell.close();
        Assert.assertTrue("could not add user subscriber name", subscriberList.contains(SUBSCRIBER_NAME));
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
