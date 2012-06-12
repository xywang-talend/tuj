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
package tisstudio.dataviewer.components;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */

@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnMysqlSCDomponentsTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "job1"; //$NON-NLS-1$

    private static final String DBNAME = "mysql"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

    }

    @Test
    public void dataViewer() {
        // drag SCD Component to job
        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), "tMysqlSCD", new Point(100, 100));
        SWTBotGefEditPart gefEditPart = getTalendComponentPart(jobItem.getEditor(), "tMysqlSCD_1");
        Assert.assertNotNull("cann't get component tMysqlSCD_1", gefEditPart);

        gefEditPart.click();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        // set connection parameter
        gefBot.sleep(1000);
        gefBot.text(0).selectAll().typeText("\"" + System.getProperty(DBNAME + ".server") + "\"", 0);
        gefBot.text(2).selectAll().typeText("\"" + System.getProperty(DBNAME + ".dataBase") + "\"", 0);
        gefBot.text(3).selectAll().typeText("\"" + System.getProperty(DBNAME + ".login") + "\"", 0);
        gefBot.text(4).selectAll().typeText("\"" + System.getProperty(DBNAME + ".password") + "\"", 0);
        gefBot.button(3).click();
        Utilities.dataViewOnSCDComponent(jobItem, "tMysqlSCD", DBNAME, gefEditPart);
    }

}
