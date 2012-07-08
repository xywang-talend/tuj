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
package tosstudio.importexport;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ExportJobAsWebserviceInWarFileTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "test01"; //$NON-NLS-1$

    private static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator"); //$NON-NLS-1$

    @Before
    public void createAJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void exportJob() throws IOException, URISyntaxException {
        jobItem.getItem().contextMenu("Export Job").click();
        SWTBotShell shell = gefBot.shell("Export Job").activate();
        gefBot.comboBoxWithLabel("Select the export type").setSelection("Axis WebService (WAR)");
        gefBot.comboBoxWithLabel("To &archive file:").setText(
                Utilities.getFileFromCurrentPluginSampleFolder("") + FILE_SEPARATOR + "output_job.war");
        gefBot.button("Finish").click();
        try {
            gefBot.waitUntil(Conditions.shellCloses(shell), 60000);
        } catch (TimeoutException e) {
            gefBot.toolbarButtonWithTooltip("Cancel Operation").click();
            gefBot.waitUntil(Conditions.widgetIsEnabled(gefBot.button("Cancel")), 60000);
            gefBot.button("Cancel").click();
            Assert.fail(e.getMessage());
        }

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return Utilities.getFileFromCurrentPluginSampleFolder("output_job.war").exists();
            }

            public String getFailureMessage() {
                return "could not find the exported file";
            }
        });
    }

    @After
    public void removePreviouslyCreateItems() throws IOException, URISyntaxException {
        try {
            Utilities.getFileFromCurrentPluginSampleFolder("output_job.war").delete();
        } catch (NullPointerException e) {
            // pass this exception, means no file need to delete.
        }
    }
}
