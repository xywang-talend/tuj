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

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
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
        repositories.add(ERepositoryObjectType.JOBLET);
        jobletItem = new TalendJobletItem(JOBLET_NAME);
        jobletItem.create();
        jobletItem.getEditor().saveAndClose();
        jobletItem.getItem().contextMenu("Edit Properties").click();
        gefBot.button("m").click();
        gefBot.button("Finish").click();
        gefBot.waitUntil(new DefaultCondition() {

            @Override
            public boolean test() throws Exception {
                return jobletItem.getParentNode().getNode(JOBLET_NAME + " 0.2").isVisible();
            }

            @Override
            public String getFailureMessage() {
                return "new version of joblet is not found";
            }
        }, 10000);
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

            gefBot.waitUntil(new DefaultCondition() {

                @Override
                public boolean test() throws Exception {
                    return jobletItem.getParentNode().getNode("Copy_of_" + jobletItem.getItemFullName()).isVisible();
                }

                @Override
                public String getFailureMessage() {
                    return "the copy joblet didn't appear";
                }
            });

            jobletItem.getParentNode().getNode("Copy_of_" + jobletItem.getItemFullName()).contextMenu("Open an other version")
                    .click();
            tempShell = gefBot.shell("New joblet").activate();
            actualVersionCount = gefBot.table(0).rowCount();
            tempShell.close();
            Assert.assertEquals("did not copy all the version", exceptVersionCount, actualVersionCount);

        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }

    }

}
