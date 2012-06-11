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
package tisstudio.metadata.validationrules;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendValidationRuleItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateReferenceCheckRulesTest extends TalendSwtBotForTos {

    private TalendValidationRuleItem ruleItem;

    private TalendDBItem dbItem;

    private static final String VALIDATION_RULE_NAME = "rulesTest";

    private static final String DB_NAME = "testDB";

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.METADATA_VALIDATION_RULES);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        // repositories.add(ERepositoryObjectType.METADATA_CON_TABLE);
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table test(id int, name varchar(12));\n" + "create table reference(id int, name varchar(12));\n";
        dbItem.executeSQL(sql);
        dbItem.retrieveDbSchema("test", "reference");
    }

    @Test
    public void createReferenceCheckRules() {
        ruleItem = new TalendValidationRuleItem(VALIDATION_RULE_NAME);
        ruleItem.setRuleTypeAsReferenceCheck();
        ruleItem.setBaseMetadata(dbItem);
        ruleItem.create();
    }

    @After
    public void removePreviouslyCreateItems() {
        String sql = "drop table test;\n" + "drop table reference;";
        dbItem.executeSQL(sql);
    }
}
