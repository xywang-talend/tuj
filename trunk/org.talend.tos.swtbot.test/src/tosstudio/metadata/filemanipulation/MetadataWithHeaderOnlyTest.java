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
package tosstudio.metadata.filemanipulation;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class MetadataWithHeaderOnlyTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDelimitedFileItem fileItem;

    private static String JOB_NAME = "job1";

    private static String FILE_NAME = "file_only_header";

    @Before
    public void createMetadata() {
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        fileItem = new TalendDelimitedFileItem(FILE_NAME);
        fileItem.setFilePath("file_only_header.txt");
        fileItem.setHeadingRowAsColumnName();
        fileItem.create();
    }

    @Test
    public void metadataWithHeaderOnlyTest() throws IOException, URISyntaxException {
        fileItem.setComponentType("tFileInputDelimited");
        fileItem.setExpectResult("");
        MetadataHelper.output2Console(jobItem.getEditor(), fileItem);
        MetadataHelper.assertResult(JobHelper.getExecutionResult(), fileItem);
    }

    @After
    public void removePreviousCreateItem() {
        jobItem.getEditor().saveAndClose();
        Utilities.cleanUpRepository(jobItem.getParentNode());
        Utilities.cleanUpRepository(fileItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
