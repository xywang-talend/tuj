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
package tosstudio.metadata.databaseoperation;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class ImportLowBuildConnectionTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    @Before
    public void importConnection() throws IOException, URISyntaxException {
        Utilities.importItems("mysql_conn.zip");
    }

    @Test
    public void checkConnection() {
        dbItem = new TalendDBItem();
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return (dbItem.getParentNode().rowCount() != 0);
            }

            public String getFailureMessage() {
                return "item did not import";
            }
        });
        SWTBotTreeItem item = dbItem.getParentNode().expand().getNode("old_mysql 0.1");
        dbItem.setItem(item);
        dbItem.setDbType(Utilities.DbConnectionType.MYSQL);

        Assert.assertNotNull("schemas disappear", dbItem.getSchema("user"));
    }

}
