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
package tosstudio.components.basicelements;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
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
public class ImportCustomComponentToPaletteTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOBNAME = "jobTest"; //$NON-NLS-1$ 

    private static final String USER_COMPONENT_FOLDER = "components"; //$NON-NLS-1$

    private static final String USER_COMPONENT_NAME = "tttt"; //$NON-NLS-1$

    private static final String USER_COMPONENT_NAME2 = "copy_of_tttt"; //$NON-NLS-1$

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
    }

    @Test
    public void importCustomComponentToPaletteTest() throws IOException, URISyntaxException {
        gefBot.menu("Window").menu("Preferences").click();
        SWTBotShell shell = gefBot.shell("Preferences").activate();
        gefBot.tree().expandNode("Talend").getNode("Components").select();

        // test invalid directory
        gefBot.textWithLabel("User component folder:").setText("invalid directory");
        try {
            gefBot.text("Value must be an existing directory");
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail("did not report error message about invalid directory");
        }

        // test valid directory
        String componentFolderPath = Utilities.getFileFromCurrentPluginSampleFolder(USER_COMPONENT_FOLDER).getAbsolutePath();
        gefBot.textWithLabel("User component folder:").setText(componentFolderPath);
        gefBot.button("Apply").click();
        gefBot.button("OK").click();

        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), USER_COMPONENT_NAME, new Point(100, 100));
        Assert.assertNotNull("could not find user component in palette",
                getTalendComponentPart(jobItem.getEditor(), USER_COMPONENT_NAME + "_1"));

        // test copy user component in Component Designer
        gefBot.menu("Window").menu("Preferences").click();
        gefBot.shell("Preferences").activate();
        gefBot.tree().getTreeItem("Talend Component Designer").select();
        gefBot.textWithLabel("Component Project:").setText(componentFolderPath);
        gefBot.button("Apply").click();
        gefBot.button("OK").click();
        waitInitialization();
        gefBot.menu("Window").menu("Perspective").menu("Component's Designer").click();
        gefBot.viewByTitle("Component Designer").setFocus();
        SWTBotTreeItem projectTree = gefBot.tree().expandNode("COMPONENT_PROJECT");
        projectTree.getNode(USER_COMPONENT_NAME).contextMenu("Copy This Component").click();
        gefBot.shell("Copy Component").activate();
        gefBot.text().setText(USER_COMPONENT_NAME2);
        if (!gefBot.button("OK").isEnabled()) {
            gefBot.activeShell().close();
            gefBot.menu("Window").menu("Perspective").menu("Integration").click();
            Assert.fail("this component has been exist");
        }
        gefBot.button("OK").click();

        Assert.assertNotNull("did not get the copy of user component in Component Designer",
                projectTree.getNode(USER_COMPONENT_NAME2));

        // test push component to palette
        projectTree.getNode(USER_COMPONENT_NAME2).contextMenu("Push Components to Palette").click();
        gefBot.shell("Informaton").activate();
        gefBot.button("OK").click();
        waitInitialization();
        gefBot.menu("Window").menu("Perspective").menu("Integration").click();

        Utilities.dndPaletteToolOntoJob(jobItem.getEditor(), USER_COMPONENT_NAME2, new Point(300, 100));
        Assert.assertNotNull("user component has not been pushed to palette",
                getTalendComponentPart(jobItem.getEditor(), USER_COMPONENT_NAME2 + "_1"));
    }

    @After
    public void removePreviouslyCreateItems() throws IOException, URISyntaxException {
        deleteUserComponent(USER_COMPONENT_FOLDER + "/" + USER_COMPONENT_NAME2);
        if ("Generation Engine Initialization in progress...".equals(gefBot.activeShell().getText()))
            gefBot.button("Run in Background").click();
    }

    private void waitInitialization() {
        gefBot.waitUntil(Conditions.shellIsActive("Generation Engine Initialization in progress..."), 60000);
        SWTBotShell initializationShell = gefBot.shell("Generation Engine Initialization in progress...");
        gefBot.waitUntil(Conditions.shellCloses(initializationShell), 60000);
    }

    private void deleteUserComponent(String name) throws IOException, URISyntaxException {
        File componentFolder = null;
        try {
            componentFolder = Utilities.getFileFromCurrentPluginSampleFolder(name);
        } catch (NullPointerException e) {
            return; // the file did not exist, pass
        }

        if (componentFolder != null) {
            for (File file : componentFolder.listFiles()) {
                file.delete();
            }
            componentFolder.delete();
        }
    }
}
