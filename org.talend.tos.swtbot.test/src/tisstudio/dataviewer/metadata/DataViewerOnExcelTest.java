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

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendExcelFileItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnExcelTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendExcelFileItem fileItem;

    private static final String JOBNAME = "job1"; //$NON-NLS-1$

    private static final String FILENAME = "excel"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_FILE_EXCEL);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        fileItem = new TalendExcelFileItem(FILENAME);
        fileItem.create();
    }

    @Test
    public void testDataViewer() throws IOException, URISyntaxException {

        // drag metadataItem to job
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), fileItem.getItem(), "", new Point(100, 100));
        SWTBotGefEditPart excel = getTalendComponentPart(jobItem.getEditor(), FILENAME);
        Assert.assertNotNull("cann't get component tFileInputExcel", excel);

        // data Viewer
        Utilities.dataView(jobItem, excel, "tFileInputExcel");
        int number = gefBot.tree().rowCount();
        Assert.assertEquals("the result is not the expected result", 10, number);
        gefBot.activeShell().close();
    }

}
