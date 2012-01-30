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

import junit.framework.Assert;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.SWTBotTreeExt;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendContextItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ValuesAsTreeTabOfContextTest extends TalendSwtBotForTos {

    private TalendContextItem contextItem;

    private TalendJobItem jobItem;

    private final static String jobName = "job1"; //$NON-NLS-1$

    private final static String contextName = "context1"; //$NON-NLS-1$

    @Before
    public void initialisePrivateFields() {
        jobItem = new TalendJobItem(jobName);
        jobItem.create();
        contextItem = new TalendContextItem(contextName);
        contextItem.create();
    }

    @Test
    public void valueTreeOfContext() {
        SWTBotGefEditor jobEditor = jobItem.getEditor();
        Utilities.dndMetadataOntoJob(jobEditor, contextItem.getItem(), null, new Point(20, 20));
        gefBot.viewByTitle("Contexts(Job " + jobName + " 0.1)").setFocus();
        gefBot.cTabItem("Values as tree").activate();
        SWTBotTreeExt treeExt = new SWTBotTreeExt(gefBot.tree(0));
        treeExt.header("Variable").click();
        String actual = gefBot.tree(0).cell(0, "Variable");
        Assert.assertEquals("the order is not the expected order ", "var2", actual);

    }

    @After
    public void removePreviousCreateItems() {
        jobItem.getEditor().saveAndClose();
        Utilities.cleanUpRepository(jobItem.getParentNode());
        Utilities.cleanUpRepository(contextItem.getParentNode());
        Utilities.emptyRecycleBin();
    }

}
