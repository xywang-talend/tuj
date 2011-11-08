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
package tosstudio.importexport;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
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

    private SWTBotView view;

    private SWTBotTree tree;

    private SWTBotShell shell;

    private static final String SAMPLE_RELATIVE_FILEPATH = "items.zip"; // $NON-NLS-1$

    private static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator"); // $NON-NLS-1$

    @Before
    public void initialisePrivateFields() throws IOException, URISyntaxException {
        view = Utilities.getRepositoryView();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        gefBot.toolbarButtonWithTooltip("Import Items").click();

        shell = gefBot.shell("Import items").activate();
        gefBot.radio("Select archive file:").click();
        gefBot.text(1).setText(Utilities.getFileFromCurrentPluginSampleFolder(SAMPLE_RELATIVE_FILEPATH).getAbsolutePath());
        gefBot.tree().setFocus();
        gefBot.button("Select All").click();
        gefBot.button("Finish").click();
        gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 10000);
    }

    @Test
    public void exportItems() throws IOException, URISyntaxException {
        gefBot.toolbarButtonWithTooltip("Export Items").click();
        shell = gefBot.shell("Export items").activate();
        gefBot.radio("Select archive file:").click();
        gefBot.text(1).setText(
                Utilities.getFileFromCurrentPluginSampleFolder(SAMPLE_RELATIVE_FILEPATH).getParent() + FILE_SEPARATOR
                        + "output.zip");
        gefBot.tree().setFocus();
        gefBot.button("Select All").click();
        gefBot.button("Finish").click();

        gefBot.waitUntil(new DefaultCondition() {

            @Override
            public boolean test() throws Exception {
                return Utilities.getFileFromCurrentPluginSampleFolder("output.zip").exists();
            }

            @Override
            public String getFailureMessage() {
                return "could not found the exported file";
            }
        });
    }

    @After
    public void removePreviouslyCreateItems() throws IOException, URISyntaxException {
        shell.close();
        Utilities.cleanUpRepository(tree, System.getProperty("buildType"));
        Utilities.emptyRecycleBin();
        Utilities.getFileFromCurrentPluginSampleFolder("output.zip").delete();
    }
}
