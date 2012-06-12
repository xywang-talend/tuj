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
package tosstudio.components.basicelements;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotTableExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class TSortRowTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "jobTest"; //$NON-NLS-1$

    private static final String FILENAME = "test.csv"; //$NON-NLS-1$

    @Before
    public void createJob() throws IOException, URISyntaxException {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), "tFileInputDelimited", new Point(100, 100));
        SWTBotGefEditPart tFileInputDelimited = getTalendComponentPart(jobItem.getEditor(), "tFileInputDelimited_1");
        Assert.assertNotNull("can not get component 'tFileInputDelimited_1'", tFileInputDelimited);
        tFileInputDelimited.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        // setting file path
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.text(0)
                .selectAll()
                .typeText(
                        "\"" + Utilities.getFileFromCurrentPluginSampleFolder(FILENAME).getAbsolutePath().replace("\\", "/")
                                + "\"", 0);
        // setting schema
        gefBot.button(4).click();
        gefBot.shell("Schema of tFileInputDelimited_1").activate();
        SWTBotTableExt table = new SWTBotTableExt(gefBot.table(0));
        gefBot.buttonWithTooltip("Add").click();
        table.click(0, "Column");
        gefBot.text("newColumn").setText("id");
        table.click(0, "Type");
        gefBot.ccomboBox("String").setSelection("int | Integer");
        table.select(0);
        gefBot.buttonWithTooltip("Add").click();
        table.click(1, "Column");
        gefBot.text("newColumn").setText("name");
        table.select(1);
        gefBot.button("OK").click();
    }

    @Test
    public void tSortRowTest() throws IOException, URISyntaxException {
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        SWTBotGefEditPart tFileInputDelimited = getTalendComponentPart(jobItem.getEditor(), "tFileInputDelimited_1");
        Utilities.dndPaletteToolOntoJob(jobEditor, "tSortRow", new Point(250, 100));
        SWTBotGefEditPart tSortRow = getTalendComponentPart(jobEditor, "tSortRow_1");
        Assert.assertNotNull("can not get component 'tSortRow_1'", tSortRow);
        JobHelper.connect(jobEditor, tFileInputDelimited, tSortRow);

        tSortRow.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotTableExt table = new SWTBotTableExt(gefBot.table(0));
        gefBot.buttonWithTooltip("Add").click();
        table.click(0, "Order asc or desc?");
        gefBot.ccomboBox("asc").setSelection("desc");
        gefBot.buttonWithTooltip("Add").click();
        table.click(1, "Schema column");
        gefBot.ccomboBox("id").setSelection("name");
        table.click(1, "sort num or alpha?");
        gefBot.ccomboBox("num").setSelection("alpha");

        JobHelper.connect2TLogRow(jobEditor, tSortRow, new Point(450, 100));
        JobHelper.runJob(jobEditor);

        String actualResult = JobHelper.getExecutionResult();
        MetadataHelper.assertResult(actualResult, JobHelper.getExpectResultFromFile("tSortRowTest.result"));
    }

}
