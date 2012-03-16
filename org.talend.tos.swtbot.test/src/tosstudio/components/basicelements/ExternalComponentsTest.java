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
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
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
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ExternalComponentsTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "ExternalComponentsTesting"; //$NON-NLS-1$

    private String buildTitle;

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void useComponentInJob() throws IOException, URISyntaxException {
        buildTitle = getBuildTitle();
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        Utilities.dndPaletteToolOntoJob(jobEditor, "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart rowGen = getTalendComponentPart(jobEditor, "tRowGenerator_1");
        Assert.assertNotNull("can not get component 'tRowGenerator'", rowGen);
        Utilities.dndPaletteToolOntoJob(jobEditor, "tMap", new Point(300, 100));
        SWTBotGefEditPart map = getTalendComponentPart(jobEditor, "tMap_1");
        Assert.assertNotNull("can not get component 'tMap'", map);
        Utilities.dndPaletteToolOntoJob(jobEditor, "tFileOutputDelimited", new Point(500, 100));
        SWTBotGefEditPart outputDeliFile = getTalendComponentPart(jobEditor, "tFileOutputDelimited_1");
        Assert.assertNotNull("can not get component 'tFileOutputDelimited'", outputDeliFile);
        outputDeliFile.select();

        /* Edit tRowGenerator */
        rowGen.doubleClick();
        SWTBotShell shell = gefBot.shell(buildTitle + " - tRowGenerator - tRowGenerator_1");
        shell.activate();
        // try {
        /* Add column "id" */
        gefBot.buttonWithTooltip("Add").click();
        gefBot.table(0).click(0, 2);
        gefBot.text("newColumn").setText("id");
        gefBot.table(0).click(0, 4);
        gefBot.ccomboBox("String").setSelection("int | Integer");
        gefBot.table(0).click(0, 10);
        gefBot.ccomboBox().setSelection("Numeric.sequence");
        gefBot.table(0).select(0);
        /* Add column "name" */
        gefBot.buttonWithTooltip("Add").click();
        gefBot.table(0).click(1, 2);
        gefBot.text("newColumn").setText("name");
        gefBot.table(0).click(1, 6);
        gefBot.text().setText("6");
        gefBot.table(0).select(1);

        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));

        jobEditor.select(rowGen);
        jobEditor.clickContextMenu("Row").clickContextMenu("Main");
        jobEditor.click(map);
        SWTBotGefEditPart rowMain = jobEditor.getEditPart("row1 (Main)");
        Assert.assertNotNull("can not draw row line", rowMain);

        /* Edit tMap */
        map.doubleClick();
        shell = gefBot.shell(buildTitle + " - tMap - tMap_1");
        shell.activate();
        gefBot.waitUntil(Conditions.shellIsActive(buildTitle + " - tMap - tMap_1"));

        gefBot.toolbarButtonWithTooltip("Add output table").click();
        gefBot.shell("Add a output").activate();
        gefBot.button("OK").click();

        gefBot.cTabItem("Schema editor").setFocus();
        gefBot.tableWithLabel("row1").select(0, 1);
        gefBot.buttonWithTooltip("Copy selected items", 0).click();
        gefBot.buttonWithTooltip("Paste", 1).click();

        gefBot.tableWithLabel("out1").click(0, 1);
        gefBot.text().setText("row1.id");
        gefBot.tableWithLabel("out1").click(1, 1);
        gefBot.text().setText("row1.name");
        gefBot.button("Apply").click();
        gefBot.button("Ok").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));
        // } catch (WidgetNotFoundException wnfe) {
        // gefBot.button("Cancel").click();
        // gefBot.shell("Close without save").activate();
        // gefBot.button("OK").click();
        // Assert.fail(wnfe.getCause().getMessage());
        // } catch (Exception e) {
        // gefBot.button("Cancel").click();
        // gefBot.shell("Close without save").activate();
        // gefBot.button("OK").click();
        // Assert.fail(e.getMessage());
        // }

        /* Connect tMap and tFileOutputDelimited */
        jobEditor.click(map);
        jobEditor.clickContextMenu("Row").clickContextMenu("out1");
        jobEditor.click(outputDeliFile);
        SWTBotGefEditPart outMain = jobEditor.getEditPart("out1 (Main)");
        Assert.assertNotNull("can not draw row line", outMain);

        jobEditor.save();

        /* Run the job */
        JobHelper.runJob(jobEditor);
    }

}
