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
package tisstudio.metadata.useinjob;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Assert;
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
import org.talend.swtbot.items.TalendValidationRuleItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseReferenceCheckRulesTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private TalendValidationRuleItem ruleItem;

    private TalendJobItem jobItem;

    private static final String JOB_NAME = "jobTest";

    private static final String RULE_NAME = "ruleTest";

    private static final String DB_NAME = "mysqlTest";

    @Before
    public void createJobAndMetadata() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_VALIDATION_RULES);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table test(id int, name varchar(12));\n" + "insert into test values(1, 'a');\n"
                + "insert into test values(2, 'b');\n" + "insert into test values(3, 'c');\n"
                + "insert into test values(4, 'd');\n" + "create table reference(id int, name varchar(12));\n"
                + "insert into reference values(1, 'a');\n" + "insert into reference values(2, 'b');\n";
        dbItem.executeSQL(sql);
        dbItem.retrieveDbSchema("test", "reference");

        ruleItem = new TalendValidationRuleItem(RULE_NAME);
        ruleItem.setRuleTypeAsReferenceCheck();
        ruleItem.setBaseMetadata(dbItem);
        ruleItem.create();

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        TalendSchemaItem schema = dbItem.getSchema("test");
        schema.setComponentType("tMysqlInput");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), schema.getItem(), schema.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart metadata = getTalendComponentPart(jobItem.getEditor(), schema.getComponentLabel());
        Assert.assertNotNull("can not get component '" + schema.getComponentType() + "'", metadata);
        MetadataHelper.activateValidationRule(metadata, ruleItem);
        JobHelper.connect2TLogRow(jobItem.getEditor(), metadata, new Point(300, 100));
        JobHelper.runJob(jobItem.getEditor());
        String result = JobHelper.getExecutionResult();
        schema.setExpectResult("1|a\n2|b");
        MetadataHelper.assertResult(result, schema);
    }

    @After
    public void removePreviousCreateItems() {
        String sql = "drop table test;\n" + "drop table reference;";
        dbItem.executeSQL(sql);
    }
}
