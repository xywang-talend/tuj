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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;

/**
 * DOC vivian class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class DataViewerOnMySQLTest extends TalendSwtBotForTos {

    private TalendJobItem jobItem;

    private TalendDBItem dbItem;

    private static final String JOBNMAE = "job1";

    private static final String DBNAME = "mysql";

    @Before
    public void createJob() {
        dbItem = new TalendDBItem(DBNAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
        String sql = "create table dataviwer(id int, name varchar(12));\n " + "insert into dataviwer values(1, 'a');\n";
        dbItem.executeSQL(sql);

        jobItem = new TalendJobItem(JOBNMAE);
        jobItem.create();

    }

    @Test
    public void testMySQL() {
        // test drag Mysql input component to workspace
        dbItem.setComponentType("tMysqlInput");
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), dbItem.getItem(), dbItem.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart mysql = getTalendComponentPart(jobItem.getEditor(), dbItem.getItemName());
        Assert.assertNotNull("cann't get component " + dbItem.getComponentType() + "", mysql);

        // test data viwer
        Utilities.setComponentValueOfDB(mysql, jobItem, "1a", DBNAME, dbItem.getComponentType());

    }

    @After
    public void removePreviousCreateItems() {
        String sql = "drop table dataviwer;\n";
        dbItem.executeSQL(sql);
        Utilities.resetActivePerspective();
    }

}
