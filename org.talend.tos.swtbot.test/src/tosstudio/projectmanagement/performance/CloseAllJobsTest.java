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
package tosstudio.projectmanagement.performance;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CloseAllJobsTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    @Before
    public void createJobs() {
        repositories.add(ERepositoryObjectType.PROCESS);
        jobItem = new TalendJobItem("job1");
        jobItem.create();
        jobItem = new TalendJobItem("job2");
        jobItem.create();
        jobItem = new TalendJobItem("job3");
        jobItem.create();
        jobItem = new TalendJobItem("job4");
        jobItem.create();
    }

    @Test
    public void closeAllJobs() {
        gefBot.menu("File").menu("Close All").click();

        Assert.assertTrue("jobs are not all closed", gefBot.editors().isEmpty());
    }

}
