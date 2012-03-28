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
package tisstudio.dataviewer.component;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.DbConnectionType;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnMssqlSDComponentsTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDBItem dbItem1;

    private static final String JOBNAME = "job1"; //$NON-NLS-1$

    private static final String DBNAME1 = "mssql"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        String sql = "create table dataviwer(age int, name varchar(12));\n " + "insert into dataviwer values(1, 'a');\n";
        jobItem = new TalendJobItem(JOBNAME);
        jobItem.create();

        dbItem1 = new TalendDBItem(DBNAME1, DbConnectionType.MSSQL);
        dbItem1.create();
        dbItem1.executeSQL(sql);

    }

    @Test
    public void dataViewer() {

        Utilities.dataViewerOnDBComponent(dbItem1, jobItem, "1a", DBNAME1, "tMSSqlSCD");
    }

    @After
    public void removePreviousCreateItems() {
        String sql = "drop table dataviwer;\n";
        dbItem1.executeSQL(sql);
    }

}
