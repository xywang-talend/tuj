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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.helpers.JobHelper;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class MultipleDelimitedFileTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private static final String JOB_NAME = "jobTest";

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem(JOB_NAME);
        jobItem.create();
    }

    @Test
    public void multipleDelimitedFileTest() throws IOException, URISyntaxException {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        Utilities.dndPaletteToolOntoJob(jobEditor, "tFileInputMSDelimited", new Point(100, 100));
        SWTBotGefEditPart tFileInputMSDelimited = getTalendComponentPart(jobEditor, "tFileInputMSDelimited_1").doubleClick();
        SWTBotShell shell = gefBot.shell("Talend Open Studio - tFileInputMSDelimited_1").activate();
        File sourceFile = Utilities.getFileFromCurrentPluginSampleFolder("multipleDelimitedFile.txt");
        try {
            String fileName = sourceFile.getAbsolutePath();
            fileName = "\"" + fileName + "\"";
            gefBot.textWithLabel("File name").setText(fileName);

            gefBot.checkBox("Use Multiple Separator").click();
            gefBot.textWithLabel("Multiple Separators").setText(";,#,@");
            gefBot.textWithLabel("Key Values").setText("bbb,teacher,jim");
            gefBot.textWithLabel("Key Index").setText("1");
            gefBot.button("Preview...").click();
            gefBot.waitUntil(Conditions.tableHasRows(gefBot.table(0), 3));

            gefBot.button("Fetch Codes").click();
            gefBot.waitUntil(Conditions.treeHasRows(gefBot.tree(0), 3));

            gefBot.button("OK").click();
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }
        JobHelper.connect2TLogRow(jobEditor, tFileInputMSDelimited, "row_A_1", new Point(300, 50), "tLogRow_1");
        JobHelper.connect2TLogRow(jobEditor, tFileInputMSDelimited, "row_B_1", new Point(400, 150), "tLogRow_2");
        JobHelper.connect2TLogRow(jobEditor, tFileInputMSDelimited, "row_C_1", new Point(300, 250), "tLogRow_3");

        JobHelper.runJob(jobEditor);
        String actualResult = JobHelper.execResultFilter(JobHelper.getExecutionResult());
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        String tempStr = null;
        StringBuffer rightResult = new StringBuffer();
        while ((tempStr = reader.readLine()) != null)
            rightResult.append(tempStr + "\n");
        String expectResult = rightResult.toString().replaceAll("[;#@]", "|").trim();

        Assert.assertEquals("job execution result is not expected", expectResult, actualResult);
    }

}
