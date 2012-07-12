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

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendJobletItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ImportStatementInTJavaAppliedInMainJobTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendJobletItem jobletItem;

    private static final String JOBNAME = "jobTest";

    private static final String JOBLETNAME = "jobletTest";

    @Before
    public void createJobandJoblet() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.JOBLET);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        jobletItem = new TalendJobletItem(JOBLETNAME);
        jobletItem.create();
    }

    @Test
    public void testImportStatementAreAppiedInMainJob() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        SWTBotGefEditor jobletEditor = jobletItem.getEditor();

        // drag tJava to joblet
        jobletEditor.show();
        jobletItem.clearInputandOutput();
        Utilities.dndPaletteToolOntoJoblet(jobletEditor, "tJava", new Point(100, 100));
        SWTBotGefEditPart tJava_1 = getTalendComponentPart(jobletEditor, "tJava_1");
        Assert.assertNotNull("cann't get tJava", tJava_1);
        tJava_1.click();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.sleep(1000);
        selecteAllTalendTabbedPropertyListIndex(1);
        String text = "import java.util.Date;";
        gefBot.styledText().selectCurrentLine();
        gefBot.styledText().typeText(text);
        selecteAllTalendTabbedPropertyListIndex(0);
        jobletEditor.saveAndClose();

        // drag joblet into job
        jobEditor.show();
        Utilities.dndMetadataOntoJob(jobEditor, jobletItem.getItem(), null, new Point(100, 100));
        SWTBotGefEditPart joblet = getTalendComponentPart(jobEditor, JOBLETNAME);
        Assert.assertNotNull("cann't drag joblet from repository to job", joblet);

        // run job
        JobHelper.runJob(JOBNAME);

        // change to code
        gefBot.cTabItem("Code").activate();
        SWTBotStyledText styledText = new SWTBotStyledText((StyledText) gefBot.widget(widgetOfType(StyledText.class), gefBot
                .activeEditor().getWidget()));
        String wholeCode = styledText.getText();
        Assert.assertEquals("the result is not the expected result,maybe the statement is not appied in main job", true,
                wholeCode.contains(text));

    }

}
