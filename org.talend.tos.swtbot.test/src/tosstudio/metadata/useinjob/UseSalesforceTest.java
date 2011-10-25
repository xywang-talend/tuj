// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tosstudio.metadata.useinjob;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendSalesforceItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseSalesforceTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendSalesforceItem metadataItem;

    private static final String JOBNAME = "jobTest"; // $NON-NLS-1$

    private static final String METADATA_NAME = "salesforceTest"; // $NON-NLS-1$

    @Before
    public void createJobAndMetadata() throws IOException, URISyntaxException {
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        metadataItem = new TalendSalesforceItem(METADATA_NAME);
        metadataItem.create();
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        TalendSalesforceItem moduleItem = metadataItem.retrieveModules("Account").get("Account");
        moduleItem.setComponentType("tSalesforceInput");
        moduleItem.setExpectResultFromFile("salesforce.result");
        MetadataHelper.output2Console(jobItem.getEditor(), moduleItem);

        String result = gefBot.styledText().getText();
        MetadataHelper.assertResult(result, moduleItem);
    }

    @After
    public void removePreviousCreateItems() {
        jobItem.getEditor().saveAndClose();
        Utilities.cleanUpRepository(jobItem.getParentNode());
        Utilities.cleanUpRepository(metadataItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
