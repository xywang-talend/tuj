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

import java.io.IOException;
import java.net.URISyntaxException;

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
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class SpecialColumnNameTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDBItem dbItem;

    private static final String JOB_NAME = "jobTest";

    private static final String DB_NAME = "mysql";

    private static final String TABLE_NAME = "test";

    @Before
    public void createJobAndMetadata() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();

        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table " + TABLE_NAME + "(id int, class varchar(20), _static varchar(20));\n" + "insert into "
                + TABLE_NAME + " values(1, 'a', 'a');";
        dbItem.executeSQL(sql);
        dbItem.retrieveDbSchema(TABLE_NAME);
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        TalendSchemaItem schemaItem = dbItem.getSchema(TABLE_NAME);
        /*
         * Assert column name of schema
         */
        SWTBotShell shell = schemaItem.editSchema();
        try {
            SWTBotTable table = gefBot.tableInGroup("Schema", 1);
            Assert.assertEquals("did not add underline before keyword column", "_class", table.cell(1, "Column"));
            Assert.assertEquals("keyword column did not keep intact", "class", table.cell(1, "Db Column"));
            Assert.assertEquals("did not add underline before column which contain underline", "__static",
                    table.cell(2, "Column"));
            Assert.assertEquals("column which contain underline did not keep intact", "_static", table.cell(2, "Db Column"));
        } finally {
            shell.close();
        }

        /*
         * Use in job and assert the result
         */
        schemaItem = dbItem.getSchema(TABLE_NAME);
        schemaItem.setComponentType("tMysqlInput");
        schemaItem.setExpectResult("1|a|a");
        MetadataHelper.output2Console(jobItem.getEditor(), schemaItem);
        String actualResult = JobHelper.getExecutionResult();
        MetadataHelper.assertResult(actualResult, schemaItem);
    }

    @After
    public void removePreviousCreateItem() {
        String sql = "drop table " + TABLE_NAME;
        dbItem.executeSQL(sql);
    }
}
