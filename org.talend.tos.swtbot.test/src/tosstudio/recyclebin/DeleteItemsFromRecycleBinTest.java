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
package tosstudio.recyclebin;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DeleteItemsFromRecycleBinTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private SWTBotTreeItem recycleBinNode;

    private static final String JOBNAME = "jobTest";

    @Before
    public void initialisePrivateField() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.RECYCLE_BIN);
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();
        jobItem.getEditor().saveAndClose();
        jobItem.delete();
    }

    @Test
    public void deleteItemsFromRecycleBin() {
        recycleBinNode = Utilities.getTalendItemNode(Utilities.TalendItemType.RECYCLE_BIN);
        recycleBinNode.getNode(jobItem.getItemFullName() + " ()").contextMenu("Delete forever").click();
        gefBot.shell("Delete forever").activate();
        gefBot.button("Yes").click();
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return (recycleBinNode.rowCount() == 0);
            }

            public String getFailureMessage() {
                Utilities.emptyRecycleBin();
                return "items did not delete forever";
            }
        });
    }
}
