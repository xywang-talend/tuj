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
package tisstudio.dataviewer.component;

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
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnFilesComponentsTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDelimitedFileItem metadataItem;

    private static final String JOBNAME = "job1"; //$NON-NLS-1$

    private static final String FILENAME = "delimitedFile"; //$NON-NLS-1$

    private static final String CONTENT = "LondonEngland"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_FILE_DELIMITED);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        metadataItem = new TalendDelimitedFileItem(FILENAME);
        metadataItem.setFilePath("dataViewerFile.csv");
        metadataItem.create();

    }

    @Test
    public void testFileDataViewer() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        // drag component to job
        Utilities.dndPaletteToolOntoJob(jobEditor, "tRowGenerator", new Point(100, 100));
        SWTBotGefEditPart tRowGenerator = getTalendComponentPart(jobEditor, "tRowGenerator_1");
        Assert.assertNotNull("can not get component 'tRowGenerator_1'", tRowGenerator);

        metadataItem.setComponentType("tFileOutputDelimited");
        Utilities.dndMetadataOntoJob(jobEditor, metadataItem.getItem(), metadataItem.getComponentType(), new Point(200, 100));
        SWTBotGefEditPart delimitedFile = getTalendComponentPart(jobEditor, FILENAME);
        Assert.assertNotNull("can not get component '" + metadataItem.getComponentType() + "'", delimitedFile);

        JobHelper.connect(jobEditor, tRowGenerator, delimitedFile);
        gefBot.button("Yes").click();

        // set edit schema of tRowGenerator
        tRowGenerator.doubleClick();

        gefBot.shell(getBuildTitle() + " - tRowGenerator - tRowGenerator_1").activate();

        gefBot.tableWithLabel("Schema").click(0, 10);
        gefBot.ccomboBox("...").setFocus();
        gefBot.cTabItem("Function parameters").setFocus();
        gefBot.tableWithLabel("Set your own expression.").click(0, 2);
        gefBot.text(1).setText("\"London\"");
        gefBot.tableWithLabel("Set your own expression.").select(0);

        gefBot.tableWithLabel("Schema").click(1, 10);
        gefBot.ccomboBox("...").setFocus();
        gefBot.cTabItem("Function parameters").setFocus();
        gefBot.tableWithLabel("Set your own expression.").click(0, 2);
        gefBot.text(1).setText("\"England\"");
        gefBot.tableWithLabel("Set your own expression.").select(0);

        gefBot.textWithLabel("Number of Rows for RowGenerator").setText("1");

        gefBot.button("OK").click();

        // run job
        JobHelper.runJob(JOBNAME);

        // data viewer
        Utilities.dataView(jobItem, delimitedFile, metadataItem.getComponentType());
        String london = gefBot.tree().cell(0, 1);
        String england = gefBot.tree().cell(0, 2);
        Assert.assertEquals("the result is not the expected result", CONTENT, london + england);
        gefBot.button("Close").click();

    }

}
