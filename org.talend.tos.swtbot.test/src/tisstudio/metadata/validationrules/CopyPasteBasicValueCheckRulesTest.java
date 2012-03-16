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

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendValidationRuleItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CopyPasteBasicValueCheckRulesTest extends TalendSwtBotForTos {

    private TalendValidationRuleItem ruleItem;

    private TalendDelimitedFileItem metadataItem;

    private static final String VALIDATION_RULES_NAME = "rulesTest";

    private static final String METADATA_NAME = "metadata";

    @Before
    public void createBasicValueCheckRules() {
        repositories.add(ERepositoryObjectType.METADATA_VALIDATION_RULES);
        repositories.add(ERepositoryObjectType.METADATA_FILE_DELIMITED);
        metadataItem = new TalendDelimitedFileItem(METADATA_NAME);
        metadataItem.create();
        ruleItem = new TalendValidationRuleItem(VALIDATION_RULES_NAME);
        ruleItem.setRuleTypeAsBasicValueCheck();
        ruleItem.setBaseMetadata(metadataItem);
        ruleItem.create();
    }

    @Test
    public void copyPasteBasicValueCheckRules() {
        ruleItem.copyAndPaste();
    }

}
