// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CopyMultiVersionTest extends TalendSwtBotForTos {

    private TalendJobletItem jobletItem;

    private static final String JOBLET_NAME = "jobletTest";

    @Before
    public void initialisePrivateFields() {
        jobletItem = new TalendJobletItem(JOBLET_NAME);
        jobletItem.create();
        jobletItem.getEditor().saveAndClose();
        jobletItem.getItem().contextMenu("Edit Properties").click();
        gefBot.button("m").click();
        gefBot.button("Finish").click();
        jobletItem.setItem(jobletItem.getParentNode().getNode(JOBLET_NAME + " 0.2"));
    }

    @Test
    public void copyMultiVersion() {
        jobletItem.getItem().contextMenu("Copy").click();
        jobletItem.getParentNode().contextMenu("Paste").click();
        SWTBotShell tempShell = null;
        int exceptVersionCount = 2;
        int actualVersionCount = 0;
        try {
            tempShell = gefBot.shell(JOBLET_NAME + " 0.2 - Version list").activate();
            gefBot.button("Select All").click();
            gefBot.button("OK").click();

            jobletItem.getParentNode().getNode("Copy_of_" + jobletItem.getItemFullName()).contextMenu("Open an other version")
                    .click();
            actualVersionCount = gefBot.table(0).rowCount();
            gefBot.button("Cancel").click();
            Assert.assertEquals("did not copy all the version", exceptVersionCount, actualVersionCount);
            tempShell.close();
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }
    }

    @After
    public void removePreviouslyCreateItems() {
        Utilities.cleanUpRepository(jobletItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
