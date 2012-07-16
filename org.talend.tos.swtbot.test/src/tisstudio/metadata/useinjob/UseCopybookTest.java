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

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendCopybookItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseCopybookTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private SWTBotGefEditor jobEditor;

    private TalendCopybookItem copybookItem;

    private static final String JOBNAME = "jobTest"; // $NON-NLS-1$

    private static final String METADATA_NAME = "copybookTest"; // $NON-NLS-1$

    @Before
    public void createJobAndMetadata() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_FILE_EBCDIC);

        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        jobEditor = jobItem.getEditor();
        copybookItem = new TalendCopybookItem(METADATA_NAME);
        copybookItem.create();
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        TalendSchemaItem schemaItem = copybookItem.retrieveSchema("_0").get("_0");
        schemaItem.setComponentType("tFileInputEBCDIC");
        schemaItem.setExpectResultFromFile("copybook.result");
        MetadataHelper.output2Console(jobEditor, schemaItem);

        String result = gefBot.styledText().getText();
        MetadataHelper.assertResult(result, schemaItem);
    }

}
