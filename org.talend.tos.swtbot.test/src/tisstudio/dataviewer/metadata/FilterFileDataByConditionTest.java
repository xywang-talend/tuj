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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Assert;
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
public class FilterFileDataByConditionTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDelimitedFileItem fileItem;

    private static final String JOBNAME = "job1";

    private static final String FILENAME = "dfile";

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_FILE_DELIMITED);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        fileItem = new TalendDelimitedFileItem(FILENAME);
        fileItem.create();

    }

    @Test
    public void testFilterByCondition() {
        fileItem.setComponentType("tFileInputDelimited");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), fileItem.getItem(), fileItem.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart file = getTalendComponentPart(jobItem.getEditor(), FILENAME);
        Assert.assertNotNull("cann't get component " + fileItem.getComponentType() + "", file);

        // data viewer
        Utilities.dataView(jobItem, file, fileItem.getComponentType());
        gefBot.textWithLabel("Condition").selectAll().setText("1");
        String result1 = gefBot.tree().cell(0, 1);
        String result2 = gefBot.tree().cell(0, 2);
        Assert.assertEquals("the result is not the expected result", "1Martin", result1 + result2);
        gefBot.activeShell().close();
    }

}
