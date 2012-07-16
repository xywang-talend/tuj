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

import java.util.ArrayList;
import java.util.List;

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
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class AbilityToUseComponentInJobletTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendJobletItem jobletItem;

    private TalendDBItem dbItem;

    private static final String JOBNAME = "jobTest";

    private static final String JOBLETNAME = "jobletTest";

    private static final String DBNAME = "mysql";

    @Before
    public void createJobandJoblet() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.JOBLET);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        jobletItem = new TalendJobletItem(JOBLETNAME);
        jobletItem.create();

        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();

    }

    @Test
    public void testUseComponentInJoblet() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        SWTBotGefEditor jobletEditor = jobletItem.getEditor();

        jobletEditor.show();
        jobletItem.clearInputandOutput();
        // drag tmysqlconnection to joblet
        Utilities.dndPaletteToolOntoJoblet(jobletEditor, "tMysqlConnection", new Point(100, 100));
        SWTBotGefEditPart tMysqlConnection = getTalendComponentPart(jobletEditor, "tMysqlConnection_1");
        Assert.assertNotNull("cann't get component tMysqlConnection", tMysqlConnection);
        tMysqlConnection.click();
        gefBot.viewByTitle("Component").setFocus();
        gefBot.ccomboBox(0).setSelection("Repository");
        gefBot.button(2).click();
        gefBot.shell("Repository Content").activate();
        gefBot.tree(0).expandNode("Db Connections").getNode(dbItem.getItemFullName()).select();
        gefBot.button("OK").click();
        jobletEditor.saveAndClose();

        jobEditor.show();
        // drag joblet to job
        Utilities.dndMetadataOntoJob(jobEditor, jobletItem.getItem(), null, new Point(100, 100));
        SWTBotGefEditPart joblet = getTalendComponentPart(jobEditor, JOBLETNAME);
        Assert.assertNotNull("cann't drag joblet from repository to job", joblet);

        // drag tmysqlInput to job
        Utilities.dndPaletteToolOntoJob(jobEditor, "tMysqlInput", new Point(100, 200));
        SWTBotGefEditPart tMysqlInput = getTalendComponentPart(jobEditor, "tMysqlInput_1");
        Assert.assertNotNull("cann't get tMysqlInput", tMysqlInput);
        tMysqlInput.click();
        gefBot.viewByTitle("Component").setFocus();
        gefBot.checkBox("Use an existing connection").click();
        String[] items = gefBot.ccomboBox(0).items();
        List<String> item = new ArrayList<String>();
        for (int i = 0; i < items.length; i++) {
            item.add(items[i]);
        }
        Assert.assertEquals("the result is not the expected result ", true, item.contains(JOBLETNAME + "_1_tMysqlConnection_1"));

    }

}
