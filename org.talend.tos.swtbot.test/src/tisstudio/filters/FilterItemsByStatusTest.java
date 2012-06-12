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
package tisstudio.filters;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withTooltip;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
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

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem1 = new TalendJobItem("job_a");
        jobItem1.create();
        jobItem2 = new TalendJobItem("job_b");
        jobItem2.create();
        jobItem3 = new TalendJobItem("job_c");
        jobItem3.create();
        for (SWTBotEditor editor : gefBot.editors())
            editor.saveAndClose();
        jobItem1.setStatus("testing");
        jobItem2.setStatus("development");
        jobItem3.setStatus("production");
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

        SWTBotShell shell = gefBot.shell("Repository Filter").activate();
        gefBot.tableWithLabel("Filter By Status :").getTableItem(1).uncheck();
        gefBot.tableWithLabel("Filter By Status :").getTableItem(2).uncheck();
        gefBot.tableWithLabel("Filter By Status :").getTableItem(3).uncheck();
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));

        filterLabel.click();
        rowCount = jobItem1.getParentNode().rowCount();
        actualJob = jobItem1.getParentNode().expand().getNode(0).getText();

        Assert.assertEquals("items did not filter", 1, rowCount);
        Assert.assertEquals("did not filter the job", expectJob, actualJob);
    }

    @After
    public void removePreviouslyCreateItems() {
        filterLabel.rightClick();
        SWTBotShell shell = gefBot.shell("Repository Filter").activate();
        gefBot.tableWithLabel("Filter By Status :").getTableItem(1).check();
        gefBot.tableWithLabel("Filter By Status :").getTableItem(2).check();
        gefBot.tableWithLabel("Filter By Status :").getTableItem(3).check();
        gefBot.button("OK").click();
        gefBot.waitUntil(Conditions.shellCloses(shell));
        filterLabel.click();
    }

}
