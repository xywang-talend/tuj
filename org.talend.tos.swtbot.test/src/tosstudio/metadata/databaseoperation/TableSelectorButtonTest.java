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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class TableSelectorButtonTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private TalendJobItem jobItem;

    private static final String DB_NAME = "postgres";

    private static final String JOB_NAME = "jobTest";

    private static final String TABLE_NAME = "test";

    @Before
    public void createJobAndMetadata() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.POSTGRESQL);
        dbItem.create();
        String sql = "create table " + TABLE_NAME + "(id int, name varchar(20));";
        dbItem.executeSQL(sql);
    }

    @Test
    public void tableSelectorButtonTest() {
        dbItem.setComponentType("tPostgresqlInput");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), dbItem.getItem(), dbItem.getComponentType(), new Point(100, 100));
        getTalendComponentPart(jobItem.getEditor(), dbItem.getItemName()).click();

        gefBot.viewByTitle("Component").setFocus();
        gefBot.buttonWithTooltip("Show the table list for the current conection").click();
        try {
            gefBot.waitUntil(Conditions.shellIsActive("Select Table Name"));
        } catch (TimeoutException e1) {
            gefBot.buttonWithTooltip("Show the table list for the current conection").click();
        }
        gefBot.waitUntil(Conditions.shellIsActive("Select Table Name"));
        SWTBotShell shell = gefBot.shell("Select Table Name").activate();
        try {
            gefBot.tree().expandNode(System.getProperty("postgresql.dataBase")).select(TABLE_NAME);
            gefBot.button("OK").click();
        } catch (WidgetNotFoundException e) {
            shell.close();
            Assert.fail(e.getCause().getMessage());
        }
        // text with label 'Table Name'
        String selectedTable = gefBot.text(7).getText();
        Assert.assertEquals("the table did not select", "\"" + TABLE_NAME + "\"", selectedTable);
    }

    @After
    public void removePreviousCreateItem() {
        String sql = "drop table " + TABLE_NAME + ";";
        dbItem.executeSQL(sql);
    }
}
