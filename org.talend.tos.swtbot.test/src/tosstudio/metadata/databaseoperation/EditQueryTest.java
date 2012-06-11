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

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendDBItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class EditQueryTest extends TalendSwtBotForTos {

    private TalendDBItem dbItem;

    private static final String DB_NAME = "mysql";

    @Before
    public void createMetadata() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbItem = new TalendDBItem(DB_NAME, Utilities.DbConnectionType.MYSQL);
        dbItem.create();
    }

    @Test
    public void editQuery() {
        SWTBotShell sqlBuilder = dbItem.editQueries();
        try {
            // assert function of button 'Save as'
            String sqlName1 = "create";
            String sql1 = "create table test(id int, name varchar(20));";
            String tabTitle = gefBot.cTabItem(0).getText();
            gefBot.styledText(0).setText(sql1);
            gefBot.toolbarButtonWithTooltip("Save query as").click();
            SWTBotShell saveAs = gefBot.shell("\"" + tabTitle + "\" Save query as").activate();
            gefBot.textWithLabel("Name").setText(sqlName1);
            gefBot.button("Save").click();
            gefBot.waitUntil(Conditions.shellCloses(saveAs));
            String nodeText = gefBot.tree(1).expandNode(System.getProperty("mysql.dataBase"), "Stored Queries").getNode(0)
                    .getText();
            Assert.assertEquals("query did not save as new name(node text)", sqlName1, nodeText);
            tabTitle = gefBot.cTabItem(0).getText();
            Assert.assertEquals("query did not save as new name(tab title)", "Query: " + sqlName1, tabTitle);
            // assert function of button 'Save'
            String sql2 = "drop table test;";
            gefBot.styledText(0).setText(sql2);
            gefBot.toolbarButtonWithTooltip("Save").click();
            nodeText = gefBot.tree(1).expandNode(System.getProperty("mysql.dataBase"), "Stored Queries").getNode(0).getText();
            Assert.assertEquals("query did not keep the name", sqlName1, nodeText);
            String queryContent = gefBot.styledText(0).getText();
            Assert.assertEquals("query content did not save as new", sql2, queryContent);
            gefBot.button("OK").click();
            gefBot.shell("Modification").activate();
            gefBot.button("Yes").click();
            gefBot.shell("No modification needed").activate();
            gefBot.button("OK").click();
        } catch (WidgetNotFoundException e) {
            sqlBuilder.close();
            Assert.fail(e.getCause().getMessage());
        }
    }

}
