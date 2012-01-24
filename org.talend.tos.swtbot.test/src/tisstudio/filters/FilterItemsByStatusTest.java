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
package tisstudio.filters;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.SWTBotLabelExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class FilterItemsByStatusTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem1;

    private TalendJobItem jobItem2;

    private TalendJobItem jobItem3;

    private SWTBotLabelExt filterLabel;

    private SWTBotShell tempShell;

    @Before
    public void initialisePrivateField() {
        jobItem1 = new TalendJobItem("job_a");
        jobItem1.create();
        jobItem2 = new TalendJobItem("job_b");
        jobItem2.create();
        jobItem3 = new TalendJobItem("job_c");
        jobItem3.create();
        for (SWTBotEditor editor : gefBot.editors())
            editor.saveAndClose();
        editProperties(jobItem1.getItem(), "testing");
        editProperties(jobItem2.getItem(), "development");
        editProperties(jobItem3.getItem(), "production");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void filterItemsByStatus() {
        String expectJob = "job_b 0.1";
        String actualJob = null;
        int rowCount = 0;

        Matcher matcher = withTooltip("Filters...\nRight click to set up");
        SWTBotLabel label = new SWTBotLabel((Label) gefBot.widget(matcher, Utilities.getRepositoryView().getWidget()));
        filterLabel = new SWTBotLabelExt(label);
        filterLabel.rightClick();

        tempShell = gefBot.shell("Repository Filter").activate();
        try {
            gefBot.tableWithLabel("Filter By Status :").getTableItem(1).uncheck();
            gefBot.tableWithLabel("Filter By Status :").getTableItem(2).uncheck();
            gefBot.tableWithLabel("Filter By Status :").getTableItem(3).uncheck();
            gefBot.button("OK").click();

            filterLabel.click();
            rowCount = jobItem1.getParentNode().rowCount();
            actualJob = jobItem1.getParentNode().getNode(0).getText();
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }

        Assert.assertEquals("items did not filter", 1, rowCount);
        Assert.assertEquals("did not filter the job", expectJob, actualJob);
    }

    @After
    public void removePreviouslyCreateItems() {
        filterLabel.rightClick();
        try {
            gefBot.tableWithLabel("Filter By Status :").getTableItem(1).check();
            gefBot.tableWithLabel("Filter By Status :").getTableItem(2).check();
            gefBot.tableWithLabel("Filter By Status :").getTableItem(3).check();
            gefBot.button("OK").click();
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }
        filterLabel.click();

        Utilities.cleanUpRepository(jobItem1.getParentNode());
        Utilities.emptyRecycleBin();
    }

    private void editProperties(SWTBotTreeItem itemNode, String status) {
        SWTBotShell tempShell = null;
        try {
            itemNode.contextMenu("Edit properties").click();
            tempShell = gefBot.shell("Edit properties").activate();
            gefBot.ccomboBoxWithLabel("Status").setText(status);
            gefBot.button("Finish").click();
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }
    }
}
