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

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ExportItemsTest extends TalendSwtBotForTos {

    private static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator"); // $NON-NLS-1$

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        repositories = Utilities.getERepositoryObjectTypes();
        Utilities.importItems("items_" + getBuildType() + ".zip");
    }

    @Test
    public void exportItems() throws IOException, URISyntaxException {
        gefBot.toolbarButtonWithTooltip("Export Items").click();
        gefBot.shell("Export items").activate();
        gefBot.radio("Select archive file:").click();
        gefBot.text(1).setText(Utilities.getFileFromCurrentPluginSampleFolder("") + FILE_SEPARATOR + "output.zip");
        gefBot.tree().setFocus();
        gefBot.button("Select All").click();
        gefBot.button("Finish").click();

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return Utilities.getFileFromCurrentPluginSampleFolder("output.zip").exists();
            }

            public String getFailureMessage() {
                return "could not find the exported file";
            }
        });
    }

    @After
    public void removePreviouslyCreateItems() throws IOException, URISyntaxException {
        try {
            Utilities.getFileFromCurrentPluginSampleFolder("output1.zip").delete();
        } catch (NullPointerException e) {
            // pass this exception, means no file need to delete
        }
    }
}
