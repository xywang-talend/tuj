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
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendContextItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ParameterOfContextUsingInTJavaTest extends TalendSwtBotForTos {

    private TalendContextItem contextItem;

    private TalendJobItem jobItem;

    private static final String CONTEXTNAME = "context.con1"; //$NON-NLS-1$

    private static final String JOBNAME = "job1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.CONTEXT);

        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        contextItem = new TalendContextItem(CONTEXTNAME);
        contextItem.create();
    }

    @Test
    public void testContextInTJava() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        Utilities.dndMetadataOntoJob(jobEditor, contextItem.getItem(), null, new Point(20, 20));

        Utilities.dndPaletteToolOntoJob(jobEditor, "tJava", new Point(100, 100));
        SWTBotGefEditPart tJava = getTalendComponentPart(jobEditor, "tJava_1");
        Assert.assertNotNull("can not get component 'tJava'", tJava);
        tJava.doubleClick();

        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.sleep(1000);
        gefBot.styledText().selectCurrentLine();
        String text = "System.out.println(context." + System.getProperty("context.variable0") + "+context."
                + System.getProperty("context.variable1") + " );";
        gefBot.styledText().typeText(text, 0);
        JobHelper.runJob(jobItem.getItemName());
        String result = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("result is not the expeected result", "1a", result);
    }

}
