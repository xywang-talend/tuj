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
package tosstudio.metadata.filemanipulation;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DeleteMultipleAttributesForXmlTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOB_NAME = "jobTest";

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
    }

    @Test
    public void deleteMultipleAttributesForXmlTest() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        Utilities.dndPaletteToolOntoJob(jobEditor, "tAdvancedFileOutputXML", new Point(100, 100));
        getTalendComponentPart(jobEditor, "tAdvancedFileOutputXML_1").doubleClick();
        SWTBotShell shell = gefBot.shell("tAdvancedFileOutputXML_1").activate();
        try {
            SWTBotTree tree = gefBot.treeInGroup("Linker Target");
            SWTBotTreeItem rootNode = tree.expandNode("rootTag").select();
            for (int i = 0; i < 10; i++) {
                gefBot.buttonWithTooltip("Add").click();
                gefBot.shell("Selection").activate();
                gefBot.button("OK").click();
                gefBot.shell("Input element's label").activate();
                gefBot.text(0).setText("test" + i);
                gefBot.button("OK").click();
            }
            String[] attributes = new String[10];
            for (int i = 0; i < 10; i++) {
                attributes[i] = "test" + i;
            }
            rootNode.select(attributes);
            gefBot.buttonWithTooltip("Remove").click();
            Assert.assertEquals("attributes did not delete", 0, rootNode.rowCount());
            shell.close();
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }
    }

}
