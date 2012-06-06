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
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
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
public class LinkManagementTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    public static final String JOBNAME = "linkManagement"; //$NON-NLS-1$

    private String buildTitle;

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void useComponentInJob() {
        buildTitle = getBuildTitle();
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        Utilities.dndPaletteToolOntoJob(jobEditor, "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart rowGen = getTalendComponentPart(jobEditor, "tRowGenerator_1");
        Assert.assertNotNull("can not get component 'tRowGenerator'", rowGen);
        Utilities.dndPaletteToolOntoJob(jobEditor, "tLogRow", new Point(300, 100));
        SWTBotGefEditPart logRow = getTalendComponentPart(jobEditor, "tLogRow_1");
        Assert.assertNotNull("can not get component 'tLogRow'", logRow);
        logRow.select();

        rowGen.doubleClick();
        SWTBotShell shell = gefBot.shell(buildTitle + " - tRowGenerator - tRowGenerator_1");
        shell.activate();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.button("OK").click();

        jobEditor.select(rowGen);
        jobEditor.clickContextMenu("Row").clickContextMenu("Main");
        jobEditor.click(logRow);
        SWTBotGefEditPart rowMain = jobEditor.getEditPart("row1 (Main)");
        Assert.assertNotNull("can not draw row line", rowMain);

        gefBot.viewByTitle("Component").show();
        logRow.click();
        gefBot.buttonWithLabel("Schema Type").click(); // label and button do not correspond
        shell = gefBot.shell("Schema of tLogRow_1");
        shell.activate();
        gefBot.waitUntil(Conditions.shellIsActive("Schema of tLogRow_1"));
        Assert.assertEquals("no automatic transfer of schema", "newColumn",
                gefBot.tableWithLabel("tLogRow_1 (Output)").cell(0, "Column"));
        Assert.assertEquals("no automatic transfer of schema", "newColumn1",
                gefBot.tableWithLabel("tLogRow_1 (Output)").cell(1, "Column"));
        gefBot.button("OK").click();
    }

}
