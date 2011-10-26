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
package tisstudio.metadata.useinjob;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendCopybookItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class UseCopybookTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private SWTBotTreeItem metadataNode;

    private SWTBotTreeItem metadataItem;

    private SWTBotGefEditor jobEditor;

    private static final String JOBNAME = "jobTest"; // $NON-NLS-1$

    private static final String METADATA_NAME = "copybookTest"; // $NON-NLS-1$

    @Before
    public void createJobAndMetadata() throws IOException, URISyntaxException {
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        jobEditor = jobItem.getEditor();
        metadataNode = Utilities.getTalendItemNode(Utilities.TalendItemType.COPYBOOK);
        metadataItem = Utilities.createCopybook(METADATA_NAME, metadataNode);
    }

    @Test
    public void useMetadataInJob() throws IOException, URISyntaxException {
        TalendCopybookItem cItem = new TalendCopybookItem();
        cItem.setItem(metadataItem);
        SWTBotTreeItem schemaItem = cItem.retrieveSchema("_0").get("_0");
        cItem.setItem(schemaItem);
        cItem.setComponentType("tFileInputEBCDIC");
        cItem.setExpectResultFromFile("copybook.result");
        MetadataHelper.output2Console(jobEditor, cItem, "row__0_1");

        String result = gefBot.styledText().getText();
        MetadataHelper.assertResult(result, cItem);
    }

    @After
    public void removePreviousCreateItems() {
        jobEditor.saveAndClose();
        Utilities.cleanUpRepository(jobItem.getParentNode());
        Utilities.cleanUpRepository(metadataNode);
        Utilities.emptyRecycleBin();
    }
}
