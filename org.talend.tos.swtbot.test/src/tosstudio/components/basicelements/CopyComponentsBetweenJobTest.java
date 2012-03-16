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

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CopyComponentsBetweenJobTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem1;

    private TalendJobItem jobItem2;

    private static final String JOBNAME1 = "CopyComponentsBetweenJob1"; //$NON-NLS-1$

    private static final String JOBNAME2 = "CopyComponentsBetweenJob2"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        /* Create job1 */
        jobItem1 = new TalendJobItem(JOBNAME1);
        jobItem1.create();
        /* Create job2 */
        jobItem2 = new TalendJobItem(JOBNAME2);
        jobItem2.create();
        /* Use components in job1 */
        SWTBotGefEditor jobEditor1 = jobItem1.getEditor();
        jobEditor1.show();

        Utilities.dndPaletteToolOntoJob(jobEditor1, "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart rowGen = getTalendComponentPart(jobEditor1, "tRowGenerator_1");
        Assert.assertNotNull("can not get component 'tRowGenerator'", rowGen);
        Utilities.dndPaletteToolOntoJob(jobEditor1, "tLogRow", new Point(300, 100));
        SWTBotGefEditPart logRow = getTalendComponentPart(jobEditor1, "tLogRow_1");
        Assert.assertNotNull("can not get component 'tLogRow'", logRow);
        logRow.select();

        rowGen.doubleClick();
        SWTBotShell shell = gefBot.shell(getBuildTitle() + " - tRowGenerator - tRowGenerator_1");
        shell.activate();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.button("OK").click();

        rowGen.select();
        jobEditor1.clickContextMenu("Row").clickContextMenu("Main");
        jobEditor1.click(logRow);
        SWTBotGefEditPart rowMain = jobEditor1.getEditPart("row1 (Main)");
        Assert.assertNotNull("can not draw row line", rowMain);
    }

    @Test
    public void copyAndPasteComponents() {
        SWTBotGefEditor jobEditor1 = jobItem1.getEditor();
        /* Copy and paste in own job */
        SWTBotGefEditPart rowGen1 = getTalendComponentPart(jobEditor1, "tRowGenerator_1");
        SWTBotGefEditPart logRow1 = getTalendComponentPart(jobEditor1, "tLogRow_1");
        jobEditor1.select(rowGen1, logRow1);
        jobEditor1.clickContextMenu("Copy");
        jobEditor1.click(100, 300);
        jobEditor1.clickContextMenu("Paste");

        SWTBotGefEditPart rowGen2 = getTalendComponentPart(jobEditor1, "tRowGenerator_2");
        Assert.assertNotNull("no copy the component 'tRowGenerator' in own job", rowGen2);
        SWTBotGefEditPart logRow2 = getTalendComponentPart(jobEditor1, "tLogRow_2");
        Assert.assertNotNull("no copy the component 'tLogRow in own job", logRow2);
        SWTBotGefEditPart rowMain2 = jobEditor1.getEditPart("row2 (Main)");
        Assert.assertNotNull("no copy the row line in own job", rowMain2);

        /* Copy and paste in another job */
        SWTBotGefEditor jobEditor2 = jobItem2.getEditor();
        jobEditor2.setFocus();
        jobEditor2.click(100, 100);
        jobEditor2.clickContextMenu("Paste");

        SWTBotGefEditPart rowGen3 = getTalendComponentPart(jobEditor2, "tRowGenerator_1");
        Assert.assertNotNull("no copy the component 'tRowGenerator' in another job", rowGen3);
        SWTBotGefEditPart logRow3 = getTalendComponentPart(jobEditor2, "tLogRow_1");
        Assert.assertNotNull("no copy the component 'tLogRow in another job", logRow3);
        SWTBotGefEditPart rowMain3 = jobEditor2.getEditPart("row1 (Main)");
        Assert.assertNotNull("no copy the row line in another job", rowMain3);
    }

}
