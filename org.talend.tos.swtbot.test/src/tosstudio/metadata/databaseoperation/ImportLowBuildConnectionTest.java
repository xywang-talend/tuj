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
package tosstudio.metadata.databaseoperation;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
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

    private SWTBotShell shell;

    @Before
    public void importConnection() throws IOException, URISyntaxException {
        gefBot.toolbarButtonWithTooltip("Import Items").click();
        shell = gefBot.shell("Import items").activate();
        gefBot.radio("Select archive file:").click();
        gefBot.text(1).setText(Utilities.getFileFromCurrentPluginSampleFolder("mysql_conn.zip").getAbsolutePath());
        gefBot.tree().setFocus();
        gefBot.button("Select All").click();
        gefBot.button("Finish").click();
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
        SWTBotTreeItem item = dbItem.getParentNode().expand().getNode(0);
        dbItem.setItem(item);
        dbItem.setDbType(Utilities.DbConnectionType.MYSQL);

        Assert.assertNotNull("schemas disappear", dbItem.getSchema("user"));
    }

    @After
    public void removePreviousCreateItem() {
        shell.close();
        Utilities.cleanUpRepository(dbItem.getParentNode());
        Utilities.emptyRecycleBin();
    }
}
