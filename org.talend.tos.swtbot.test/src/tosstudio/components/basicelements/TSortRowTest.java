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
package tosstudio.components.basicelements;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class TSortRowTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDelimitedFileItem fileItem;

    private static final String JOBNAME = "jobTest"; //$NON-NLS-1$

    private static final String FILENAME = "fileTest"; //$NON-NLS-1$

    @Before
    public void createJob() {
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        fileItem = new TalendDelimitedFileItem(FILENAME);
        fileItem.setExpectResultFromFile("tSortRowTest.result");
        fileItem.create();
    }

    @Test
    public void tSortRowTest() throws IOException, URISyntaxException {
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        Utilities.dndMetadataOntoJob(jobEditor, fileItem.getItem(), "tFileInputDelimited", new Point(50, 100));
        SWTBotGefEditPart tFileInputDelimited = getTalendComponentPart(jobEditor, fileItem.getItemName());
        Assert.assertNotNull("can not get component '" + fileItem.getItemName() + "'", tFileInputDelimited);
        Utilities.dndPaletteToolOntoJob(jobEditor, "tSortRow", new Point(250, 100));
        SWTBotGefEditPart tSortRow = getTalendComponentPart(jobEditor, "tSortRow_1");
        Assert.assertNotNull("can not get component 'tSortRow_1'", tSortRow);
        JobHelper.connect(jobEditor, tFileInputDelimited, tSortRow);

        tSortRow.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.table(0).click(0, 3);
        gefBot.ccomboBox("asc").setSelection("desc");
        gefBot.buttonWithTooltip("Add").click();
        gefBot.table(0).click(1, 1);
        gefBot.ccomboBox("Column0").setSelection("Column1");
        gefBot.table(0).click(1, 2);
        gefBot.ccomboBox("num").setSelection("alpha");

        JobHelper.connect2TLogRow(jobEditor, tSortRow, new Point(450, 100));
        JobHelper.runJob(jobEditor);

        String actualResult = JobHelper.getExecutionResult();
        MetadataHelper.assertResult(actualResult, fileItem);
    }

    @After
    public void removePreviouslyCreateItems() {
        jobItem.getEditor().saveAndClose();
        Utilities.cleanUpRepository(jobItem.getParentNode());
        Utilities.cleanUpRepository(fileItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
