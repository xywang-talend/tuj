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

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendEdiItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseEdiTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendEdiItem ediItem;

    private static final String JOBNAME = "jobTest"; // $NON-NLS-1$

    private static final String METADATA_NAME = "ediTest"; // $NON-NLS-1$

    private static final String STANDARD = "CUSCAR"; // $NON-NLS-1$

    private static final String RELEASE = "d99a"; // $NON-NLS-1$

    private static final String[] SCHEMAS = { "Document_message_name__coded", "Code_list_qualifier",
            "Code_list_responsible_agency__coded", "Document_message_name" };

    @Before
    public void createJobAndMetadata() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_EDIFACT);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        ediItem = new TalendEdiItem(METADATA_NAME, STANDARD, RELEASE, SCHEMAS);
        ediItem.create();
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        ediItem.setFilePath("99a_cuscar.edi");
        ediItem.setExpectResultFromFile("edi.result");
        MetadataHelper.output2Console(jobItem.getEditor(), ediItem);

        String result = gefBot.styledText().getText();
        MetadataHelper.assertResult(result, ediItem);
    }

}
