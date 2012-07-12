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
package tisstudio.joblets;

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CopyPasteJobletNodesTest extends TalendSwtBotForTos {

    private TalendJobletItem jobletItem;

    private static final String JOBLETNAME = "jobletTest";

    @Before
    public void createJoblet() {
        repositories.add(ERepositoryObjectType.JOBLET);
        jobletItem = new TalendJobletItem(JOBLETNAME);

        jobletItem.create();
    }

    @Test
    public void testCopyPasteJobletNodes() {
        SWTBotGefEditor jobletEditor = jobletItem.getEditor();
        SWTBotGefEditPart input_1 = getTalendComponentPart(jobletEditor, "INPUT_1");
        SWTBotGefEditPart output_1 = getTalendComponentPart(jobletEditor, "OUTPUT_1");

        // copy/paste input_1
        copyPasteComponent(jobletEditor, input_1);
        SWTBotGefEditPart input_2 = getTalendComponentPart(jobletEditor, "INPUT_2");
        Assert.assertNotNull("cann't find input_2,maybe the input_1 is not copied", input_2);

        // copy/paste input_2
        copyPasteComponent(jobletEditor, output_1);
        SWTBotGefEditPart output_2 = getTalendComponentPart(jobletEditor, "OUTPUT_2");
        Assert.assertNotNull("cann't find output_2,maybe the output_1 is not copied", output_2);
    }

    private void copyPasteComponent(SWTBotGefEditor jobletEditor, SWTBotGefEditPart component) {
        jobletEditor.select(component).setFocus();
        component.click();
        jobletEditor.clickContextMenu("Copy");
        jobletEditor.clickContextMenu("Paste");

    }

}
