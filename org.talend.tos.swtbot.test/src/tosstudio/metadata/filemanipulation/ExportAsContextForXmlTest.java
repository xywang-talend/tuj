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
package tosstudio.metadata.filemanipulation;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.DndUtil;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.helpers.MetadataHelper;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendXmlFileItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class ExportAsContextForXmlTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendXmlFileItem fileItem;

    private static String JOB_NAME = "xmlJob";

    private static String FILE_NAME = "xmlMetadata";

    @Before
    public void createJobAndMetadata() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_FILE_XML);
        repositories.add(ERepositoryObjectType.CONTEXT);
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        fileItem = new TalendXmlFileItem(FILE_NAME);
    }

    @Test
    public void exportAsContextForXmlTest() throws IOException, URISyntaxException {
        SWTBotShell shell = fileItem.beginCreationWizard("Create file xml", "New Xml File");

        gefBot.button("Next >").click();
        gefBot.textWithLabel("XML").setText(
                Utilities.getFileFromCurrentPluginSampleFolder(fileItem.getFilePath()).getAbsolutePath());
        gefBot.button("Next >").click();

        DndUtil dndUtil = new DndUtil(shell.display);
        String[] loops = System.getProperty("filexml.loop").split("/");
        SWTBotTreeItem loop = gefBot.treeInGroup("Source Schema").expandNode(loops[0]);
        for (int i = 1; i < loops.length; i++) {
            loop = loop.expandNode(loops[i]);
        }
        SWTBotTable targetItem = gefBot.tableInGroup("Target Schema", 0);
        dndUtil.dragAndDrop(loop, targetItem);
        String[] schemas = new String[3];
        for (int i = 0; i < 3; i++) {
            schemas[i] = System.getProperty("filexml.schema" + i);
        }
        SWTBotTreeItem sourceTarget = loop.getNode(schemas[0]);
        loop.select(schemas);
        targetItem = gefBot.tableInGroup("Target Schema", 1);
        dndUtil.dragAndDrop(sourceTarget, targetItem);
        // export as context
        gefBot.button("Export as context").click();
        gefBot.shell("Create / Edit a context group").activate();
        gefBot.button("Finish").click();
        gefBot.button("Refresh Preview").click();
        gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 10000);
        boolean isPreviewSuccessful = false;
        int rowCount = 0;
        rowCount = gefBot.table(2).rowCount();
        if (rowCount != 0)
            isPreviewSuccessful = true;
        Assert.assertTrue("preview fail", isPreviewSuccessful);
        // revert context
        gefBot.button("Revert Context").click();
        gefBot.button("Refresh Preview").click();
        gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 10000);
        rowCount = gefBot.table(2).rowCount();
        if (rowCount != 0)
            isPreviewSuccessful = true;
        Assert.assertTrue("preview fail", isPreviewSuccessful);
        // export as context again
        gefBot.button("Export as context").click();
        gefBot.shell("Create / Edit a context group").activate();
        gefBot.button("Finish").click();
        // finish
        fileItem.finishCreationWizard(shell);

        fileItem.setComponentType("tFileInputXML");
        MetadataHelper.output2Console(jobItem.getEditor(), fileItem);
        MetadataHelper.assertResult(JobHelper.getExecutionResult(), fileItem);
    }

}
