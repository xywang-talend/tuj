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
package tisstudio.metadata.embeddedrules;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendEmbeddedRulesItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateDrlEmbeddedRulesTest extends TalendSwtBotForTos {

    private TalendEmbeddedRulesItem ruleItem;

    private static final String EMBEDDED_RULES_NAME = "rulesTest";

    private static final String TYPE_OF_RULE_RESOURCE = "DRL";

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.METADATA_FILE_RULES);
        repositories.add(ERepositoryObjectType.METADATA_RULES_MANAGEMENT);
        ruleItem = new TalendEmbeddedRulesItem(EMBEDDED_RULES_NAME, TYPE_OF_RULE_RESOURCE);
    }

    @Test
    public void creatDrlEmbeddedRules() throws IOException, URISyntaxException {
        ruleItem.create();
    }

}
