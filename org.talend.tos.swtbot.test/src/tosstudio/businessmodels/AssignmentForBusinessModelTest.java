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
package tosstudio.businessmodels;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendBusinessModelItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AssignmentForBusinessModelTest extends TalendSwtBotForTos {

    private TalendBusinessModelItem businessModelItem;

    private TalendJobItem jobItem;

    private static final String BUSINESSMODEL_NAME = "businessModel1"; //$NON-NLS-1$

    private static final String JOB_NAME = "job1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.BUSINESS_PROCESS);
        businessModelItem = new TalendBusinessModelItem(BUSINESSMODEL_NAME);
        businessModelItem.create();
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        jobItem.getEditor().saveAndClose();
    }

    @Test
    public void assignmentForBusinessModelTest() {
        SWTBotGefEditor editor = businessModelItem.getEditor();
        String componentName = "test";
        Utilities.dndPaletteToolOntoBusinessModel(editor, "Data", new Point(100, 100), componentName);
        Utilities.dndMetadataOntoBusinessModel(editor, jobItem.getItem(), new Point(100, 100));
        editor.save();
        gefBot.viewByTitle("Business Models(" + businessModelItem.getItemFullName() + ")").setFocus();
        selecteAllTalendTabbedPropertyListIndex(1);
        gefBot.waitUntil(Conditions.tableHasRows(gefBot.table(0), 1));
        Assert.assertEquals("items did not assign to business model", "Job", gefBot.table(0).cell(0, "Type"));
        Assert.assertEquals("items did not assign to business model", jobItem.getItemName(), gefBot.table(0).cell(0, "Name"));
    }

}
