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
package tisstudio.dataviewer.metadata;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViwerOnAS400Test extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDBItem dbItem;

    private static final String JOBNMAE = "job1"; //$NON-NLS-1$

    private static final String DBNAME = "AS400"; //$NON-NLS-1$

    private static final String TABELNAME = "dataviwer"; //$NON-NLS-1$

    @Before
    public void createJob() {
        repositories.add(ERepositoryObjectType.PROCESS);
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.AS400);
        dbItem.create();
        String sql = "create table " + TABELNAME + "(age int, name varchar(12));\n " + "insert into " + TABELNAME
                + " values(1, 'a');\n";
        dbItem.executeSQL(sql);

        jobItem = new TalendJobItem(JOBNMAE);
        jobItem.create();

    }

    @Test
    public void testDataViewer() {
        // test data viwer
        Utilities.dataViewerOnDBComponent(dbItem, jobItem, "1a", TABELNAME.toUpperCase(), "tAS400Input");

    }

    @After
    public void removePreviousCreateItems() {
        String sql = "drop table dataviwer;\n";
        dbItem.executeSQL(sql);

    }

}
