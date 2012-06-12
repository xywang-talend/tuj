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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class TunitTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "jobTest"; //$NON-NLS-1$

    private static final String FOLDERPATH = "tUnite"; //$NON-NLS-1$

    private static final String FILENAME = "((String)globalMap.get(\"tFileList_1_CURRENT_FILEPATH\"))"; //$NON-NLS-1$

    private static final String RESULTFILE = "tUnite.result"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void testTUint() throws IOException, URISyntaxException {

        SWTBotGefEditor jobEditor = jobItem.getEditor();
        Utilities.dndPaletteToolOntoJob(jobEditor, "tFileList", new Point(100, 100));
        SWTBotGefEditPart tFileList = getTalendComponentPart(jobEditor, "tFileList_1");
        Assert.assertNotNull("can not get component 'tFileList'", tFileList);
        tFileList.click();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        String folderPath = Utilities.getFileFromCurrentPluginSampleFolder(FOLDERPATH).getAbsolutePath();
        folderPath = "\"" + folderPath.replace("\\", "/") + "\"";
        gefBot.text(0).selectAll();
        gefBot.text(0).typeText(folderPath, 0);

        Utilities.dndPaletteToolOntoJob(jobEditor, "tFileInputDelimited", new Point(300, 100));
        SWTBotGefEditPart tFileInputDelimited = getTalendComponentPart(jobEditor, "tFileInputDelimited_1");
        Assert.assertNotNull("can not get component 'tFileInputDelimited'", tFileInputDelimited);
        tFileInputDelimited.click();

        gefBot.viewByTitle("Component").setFocus();
        gefBot.text(0).selectAll();
        gefBot.text(0).typeText(FILENAME, 0);
        gefBot.sleep(10000);
        gefBot.button(4).click();
        gefBot.shell("Schema of tFileInputDelimited_1").activate();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.button("OK").click();

        Utilities.dndPaletteToolOntoJob(jobEditor, "tUnite", new Point(300, 200));
        SWTBotGefEditPart tUnite = getTalendComponentPart(jobEditor, "tUnite_1");
        Assert.assertNotNull("can not get component 'tUnite'", tUnite);

        JobHelper.connect(jobEditor, tFileList, tFileInputDelimited, "Iterate");
        JobHelper.connect(jobEditor, tFileInputDelimited, tUnite);

        JobHelper.connect2TLogRow(jobEditor, tUnite, new Point(100, 200));

        JobHelper.runJob(jobItem.getItemName());
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        System.out.println(JobHelper.getExpectResultFromFile(RESULTFILE));
        Assert.assertEquals("the result is not the expected result", JobHelper.getExpectResultFromFile(RESULTFILE), result);

    }

}
