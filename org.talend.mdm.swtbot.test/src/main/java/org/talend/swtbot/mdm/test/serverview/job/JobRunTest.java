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

package org.talend.swtbot.mdm.test.serverview.job;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.mdm.test.serverview.SWTBotForMDMServiewView;

/**
 * @author rhou
 *
 */
public class JobRunTest extends SWTBotForMDMServiewView {

    private SWTBotTreeItem jobParentItem;

    private SWTBotTreeItem jobItem;

    @Before
    public void runBeforeEveryTest() {
        jobParentItem = serverItem.getNode("Job Repository");
        jobParentItem.expand();
        if(jobParentItem.getNodes().contains("Source Jobs"))
        	jobItem=jobParentItem.getNode("Source Jobs").getNode(0);

    }

    @After
    public void runAfterEveryTest() {

    }
    //new feature in 4.2,see bug 0018022,0018002
    @Test
    public void jobRunTest(){
    	if(jobItem!=null)
        	jobItem.contextMenu("Run").click();
    }
}
