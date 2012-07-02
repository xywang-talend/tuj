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

import junit.framework.Assert;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;
import org.eclipse.swtbot.swt.finder.utils.Position;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
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
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CtrlSpaceToUseContextTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendContextItem contextItem;

    private static final String JOB_NAME = "jobTest";

    private static final String CONTEXT_NAME = "contextTest";

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.CONTEXT);

        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
        contextItem = new TalendContextItem(CONTEXT_NAME);
        contextItem.create();
    }

    @Test
    public void ctrlSpaceToUseContextTest() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();

        // use context in job
        jobEditor.show();
        Utilities.dndMetadataOntoJob(jobEditor, contextItem.getItem(), null, new Point(100, 100));
        Utilities.dndPaletteToolOntoJob(jobEditor, "tJava", new Point(100, 100));
        SWTBotGefEditPart tJava = getTalendComponentPart(jobEditor, "tJava_1");
        tJava.doubleClick();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.sleep(1000);
        SWTBotStyledText styledText = gefBot.styledText();
        styledText.selectCurrentLine();
        gefBot.sleep(3000);
        styledText.typeText("System.out.println(");
        gefBot.styledText().pressShortcut(Keystrokes.CTRL, Keystrokes.SPACE);
        gefBot.styledText().pressShortcut(SWT.CR, SWT.LF); // press button Enter
        Position position = styledText.cursorPosition();
        styledText.typeText(position.line, position.column, ");");
        jobEditor.save();

        JobHelper.runJob(jobEditor);
        String expect = System.getProperty("context.value0");
        String actual = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        Assert.assertEquals("get wrong context value", expect, actual);
    }

}
