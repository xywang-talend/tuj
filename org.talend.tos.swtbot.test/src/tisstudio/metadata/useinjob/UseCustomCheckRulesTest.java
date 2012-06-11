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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendValidationRuleItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseCustomCheckRulesTest extends TalendSwtBotForTos {

    private TalendDelimitedFileItem metadataItem;

    private TalendValidationRuleItem ruleItem;

    private TalendJobItem jobItem;

    private static final String JOB_NAME = "jobTest";

    private static final String RULE_NAME = "ruleTest";

    private static final String METADATA_NAME = "delimitedFile";

    @Before
    public void createJobAndMetadata() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_VALIDATION_RULES);
        repositories.add(ERepositoryObjectType.METADATA_FILE_DELIMITED);
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();

        metadataItem = new TalendDelimitedFileItem(METADATA_NAME);
        metadataItem.create();

        ruleItem = new TalendValidationRuleItem(RULE_NAME);
        ruleItem.setRuleTypeAsCustomCheck();
        ruleItem.setBaseMetadata(metadataItem);
        ruleItem.create();
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        metadataItem.setComponentType("tFileInputDelimited");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), metadataItem.getItem(), metadataItem.getComponentType(), new Point(100,
                100));
        SWTBotGefEditPart metadata = getTalendComponentPart(jobItem.getEditor(), metadataItem.getItemName());
        Assert.assertNotNull("can not get component '" + metadataItem.getComponentType() + "'", metadata);
        MetadataHelper.activateValidationRule(metadata, ruleItem);
        JobHelper.connect2TLogRow(jobItem.getEditor(), metadata, new Point(300, 100));
        JobHelper.runJob(jobItem.getEditor());
        String actualResult = JobHelper.getExecutionResult();
        String expectResult = metadataItem.getExpectResult();
        expectResult = expectResult.substring(expectResult.indexOf("6"));
        MetadataHelper.assertResult(actualResult, expectResult);
    }

}
