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
package tosstudio.context;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
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
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ImplicitContextLoadForTransmitToChildTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem1;

    private TalendJobItem jobItem2;

    private static final String JOBNAME1 = "fatherJob"; //$NON-NLS-1$

    private static final String JOBNAME2 = "childJob"; //$NON-NLS-1$

    private static final String FILE = "contextForJob.txt";//$NON-NLS-1$

    private Map<String, String> context1 = new HashMap<String, String>();

    private Map<String, String> context2 = new HashMap<String, String>();

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);

        jobItem1 = new TalendJobItem(JOBNAME1);
        jobItem1.create();
        jobItem2 = new TalendJobItem(JOBNAME2);
        jobItem2.create();

        context1 = getContextFromPropertyFile();
        context2 = getContextFromPropertyFile();
        context2.put("context.value0", "3");
        context2.put("context.value1", "b");
        context2.put("context.value2", "4");
    }

    @Test
    public void testImplictContextLoadTest() throws IOException, URISyntaxException {
        SWTBotGefEditor jobEditor1 = jobItem1.getEditor();
        SWTBotGefEditor jobEditor2 = jobItem2.getEditor();

        jobEditor1.show();
        createContextForJob(context1, jobEditor1);

        gefBot.viewByTitle("Job(" + jobItem1.getItemFullName() + ")").setFocus();
        selecteAllTalendTabbedPropertyListIndex(1);
        gefBot.checkBox("Use Project Settings").click();
        gefBot.checkBox("Implicit tContextLoad").click();
        gefBot.radio("From File").click();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.sleep(1000);
        String filePath = Utilities.getFileFromCurrentPluginSampleFolder(FILE).getAbsolutePath();
        filePath = "\"" + filePath.replace("\\", "/") + "\"";
        gefBot.text(1).selectAll().typeText(filePath);
        gefBot.text(2).selectAll().typeText("\"" + ";" + "\"");

        // drag tJava and tRunJob to job
        dragTJavaToJob(jobEditor1);

        Utilities.dndPaletteToolOntoJob(jobEditor1, "tRunJob", new Point(200, 200));
        SWTBotGefEditPart tRunJob = getTalendComponentPart(jobEditor1, "tRunJob_1");
        Assert.assertNotNull("cann't get component tRunJob", tRunJob);
        tRunJob.click();
        gefBot.viewByTitle("Component").setFocus();
        gefBot.button(4).click();
        gefBot.shell("Find a Job").activate();
        Utilities.getTalendItemNode(gefBot.tree(), jobItem2.getItemType()).getNode(jobItem2.getItemFullName()).select();
        gefBot.button("OK").click();
        gefBot.checkBox("Transmit whole context").click();

        // create context and drag tJava to job2
        jobEditor2.show();
        createContextForJob(context2, jobEditor2);
        dragTJavaToJob(jobEditor2);
        JobHelper.runJob(jobEditor2);
        String result2 = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("the result is not the expected result,maybe the variable is not available in job", "3b4.0", result2);

        // run job1
        jobEditor1.show();
        JobHelper.runJob(jobEditor1);
        String result1 = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("the result is not the expected result,maybe the context is not from file", "5c6.0\n5c6.0", result1);

    }

    private void createContextForJob(Map<String, String> context, SWTBotGefEditor jobEditor) {
        gefBot.viewByTitle("Contexts(" + jobEditor.getTitle() + ")").show();
        SWTBotTreeItem treeItem;
        SWTBotTreeItemExt treeItemExt;
        for (int i = 0; i < 3; i++) {
            gefBot.cTabItem("Variables").activate();
            gefBot.button(0).click();
            treeItem = gefBot.tree(0).getTreeItem("new1").click();
            treeItemExt = new SWTBotTreeItemExt(treeItem);
            treeItemExt.click(0);
            gefBot.text("new1").setText(context.get("context.variable" + i));
            treeItemExt.click(2);
            gefBot.ccomboBox("String").setSelection(context.get("context.type" + i));
            treeItemExt.click(3);
        }
        gefBot.cTabItem("Values as tree").activate();
        for (int j = 0; j < 3; j++) {
            treeItem = gefBot.tree(0).expandNode(context.get("context.variable" + j)).getNode(0).select().click();
            treeItemExt = new SWTBotTreeItemExt(treeItem);
            treeItemExt.click(4);
            gefBot.text().setText(context.get("context.value" + j));
        }

    }

    private SWTBotGefEditPart dragTJavaToJob(SWTBotGefEditor jobEditor) {
        Utilities.dndPaletteToolOntoJob(jobEditor, "tJava", new Point(100, 100));
        SWTBotGefEditPart tJava = getTalendComponentPart(jobEditor, "tJava_1");
        Assert.assertNotNull("cann't get component tJava", tJava);
        tJava.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        String text = "System.out.println(context.var0+context.var1+context.var2);";
        gefBot.sleep(1000);
        gefBot.styledText().selectCurrentLine();
        gefBot.styledText().typeText(text);
        return tJava;
    }

    private Map<String, String> getContextFromPropertyFile() {
        Map<String, String> map = new HashMap<String, String>();
        String[] keys = { "context.variable", "context.value", "context.type" };
        for (int i = 0; i < 3; i++) {
            for (String key : keys)
                map.put(key + i, System.getProperty(key + i));
        }
        return map;
    }
}
