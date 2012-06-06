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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
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
public class IterateLinkTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "jobTest"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void testLink() {
        String buildTitle = getBuildTitle();
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        Utilities.dndPaletteToolOntoJob(jobEditor, "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart tRowGenerator1 = getTalendComponentPart(jobEditor, "tRowGenerator_1");
        Assert.assertNotNull("can not get component 'tRowGenerator'", tRowGenerator1);
        tRowGenerator1.doubleClick();
        gefBot.shell(buildTitle + " - tRowGenerator - tRowGenerator_1").setFocus();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.textWithLabel("Number of Rows for RowGenerator").setText("2");
        gefBot.button("OK").click();
        JobHelper.connect2TLogRow(jobEditor, tRowGenerator1, new Point(300, 100));

        Utilities.dndPaletteToolOntoJob(jobEditor, "tRowGenerator", new Point(100, 300));
        SWTBotGefEditPart tRowGenerator2 = getTalendComponentPart(jobEditor, "tRowGenerator_2");
        Assert.assertNotNull("can not get component 'tRowGenerator'", tRowGenerator1);
        tRowGenerator2.doubleClick();
        gefBot.shell(buildTitle + " - tRowGenerator - tRowGenerator_2").setFocus();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.textWithLabel("Number of Rows for RowGenerator").setText("2");
        gefBot.button("OK").click();
        JobHelper.connect2TLogRow(jobEditor, tRowGenerator2, new Point(300, 300), "tLogRow_2");
        SWTBotGefEditPart tLogRow2 = getTalendComponentPart(jobEditor, "tLogRow_2");
        tLogRow2.click();
        gefBot.viewByTitle("Component").setFocus();

        gefBot.radio("Basic").click();
        gefBot.radio("Table (print values in cells of a table)").click();
        JobHelper.connect(jobEditor, tRowGenerator1, tRowGenerator2, "Iterate");
        JobHelper.runJob(jobEditor);
        String result = JobHelper.getExecutionResult();
        int number = (result.length() - result.replace("tLogRow_2", "").length()) / "tLogRow_2".length();
        Assert.assertEquals("haven't execute the default times", 2, number);

    }

}
