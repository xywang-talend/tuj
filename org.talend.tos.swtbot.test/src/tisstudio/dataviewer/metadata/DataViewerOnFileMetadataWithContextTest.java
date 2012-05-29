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
package tisstudio.dataviewer.metadata;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnFileMetadataWithContextTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDelimitedFileItem fileItem;

    private static final String FILENAME = "delimitiedMetadata";

    private static final String JOBNAME = "job1";

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_FILE_DELIMITED);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void testDataViewer() {
        fileItem = new TalendDelimitedFileItem(FILENAME);
        SWTBotShell shell = fileItem.beginCreationWizard("Create file delimited", "New Delimited File");
        try {
            gefBot.textWithLabel("File").setText(
                    Utilities.getFileFromCurrentPluginSampleFolder(fileItem.getFilePath()).getAbsolutePath());
            gefBot.button("Next >").click();

            // export as context
            gefBot.button("Export as context").click();
            gefBot.shell("Create / Edit a context group").activate();
            gefBot.button("Finish").click();

            // finish
            fileItem.finishCreationWizard(shell);

        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }

        fileItem.setComponentType("tFileInputDelimited");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), fileItem.getItem(), fileItem.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart file = getTalendComponentPart(jobItem.getEditor(), FILENAME);
        Assert.assertNotNull("cann't get component " + fileItem.getComponentType() + "", file);

        Utilities.dataView(jobItem, file, fileItem.getComponentType());
        int number = gefBot.tree().rowCount();
        Assert.assertEquals("the result is not the expected result", 12, number);
        gefBot.activeShell().close();

    }

}
