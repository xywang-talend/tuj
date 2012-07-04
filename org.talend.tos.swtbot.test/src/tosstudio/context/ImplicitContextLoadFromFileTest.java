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
package tosstudio.context;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.SWTBotTreeItemExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ImplicitContextLoadFromFileTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOB_NAME = "jobTest";

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.PROCESS);

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
    }

    @Test
    public void implicitContextLoadFromFileTest() throws IOException, URISyntaxException {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        String variableName = "source";
        String variableValue = "local";

        // create context for job
        jobEditor.show();
        gefBot.viewByTitle("Contexts(" + jobEditor.getTitle() + ")").show();
        gefBot.cTabItem("Variables").activate();
        gefBot.button(0).click(); // click add variable button
        SWTBotTreeItemExt var = new SWTBotTreeItemExt(gefBot.tree(0).getTreeItem("new1").select());
        var.click("Name");
        gefBot.text().setText(variableName);
        var.select();
        gefBot.cTabItem("Values as table").activate();
        var = new SWTBotTreeItemExt(gefBot.tree(0).getTreeItem(variableName).select());
        var.click("Default");
        gefBot.text().setText(variableValue);
        var.select();

        // use context in job
        jobEditor.show();
        Utilities.dndPaletteToolOntoJob(jobEditor, "tJava", new Point(100, 100));
        SWTBotGefEditPart tJava = getTalendComponentPart(jobEditor, "tJava_1");
        tJava.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.sleep(1000);
        gefBot.styledText().selectCurrentLine();
        String text = "System.out.println(context." + variableName + ");";
        gefBot.styledText().typeText(text, 0);
        jobEditor.save();

        // implicit context load from file
        gefBot.viewByTitle(jobEditor.getTitle().replaceFirst(" ", "(") + ")").show();
        selecteAllTalendTabbedPropertyListIndex(1);
        gefBot.checkBox("Use Project Settings").deselect();
        gefBot.checkBox("Implicit tContextLoad").select();
        gefBot.radio("From File").click();
        gefBot.sleep(1000);
        int textIndex = 1; // index of text with label "From File"
        if ("TOSBD".equals(getBuildType()))
            textIndex = 0;
        gefBot.text(textIndex)
                .selectAll()
                .typeText(
                        "\"" + Utilities.getFileFromCurrentPluginSampleFolder("context.txt").getAbsolutePath().replace("\\", "/")
                                + "\"", 0); // gefBot.textWithLabel("From File")
        gefBot.text(textIndex + 1).selectAll().typeText("\";\"", 0); // gefBot.textWithLabel("Field Separator")
        JobHelper.runJob(jobEditor);
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("get wrong context value from file", "file", result);
    }

}
