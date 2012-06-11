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

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class SpecifyAdditionalParameterTest extends TalendSwtBotForTos {

    private SWTBotTreeItem dbNode;

    private static final String DB_NAME = "teradata";

    @Before
    public void createMetadata() {
        repositories.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        dbNode = Utilities.getTalendItemNode(Utilities.TalendItemType.DB_CONNECTIONS);
    }

    @Test
    public void specifyAdditionalParameter() {
        dbNode.contextMenu("Create connection").click();
        gefBot.waitUntil(Conditions.shellIsActive("Database Connection"));
        SWTBotShell shell = gefBot.shell("Database Connection");
        gefBot.textWithLabel("Name").setText(DB_NAME);
        boolean nextButtonIsEnabled = gefBot.button("Next >").isEnabled();
        if (nextButtonIsEnabled) {
            gefBot.button("Next >").click();
        } else {
            shell.close();
            Assert.assertTrue("next button is not enabled, maybe the item name is exist,", nextButtonIsEnabled);
        }

        try {
            gefBot.comboBoxWithLabel("DB Type").setSelection("Teradata");
            boolean isEnabled = gefBot.textWithLabel("Additional parameters").isEnabled();
            Assert.assertTrue("text of additional parameter is not editable", isEnabled);
        } catch (WidgetNotFoundException wnfe) {
            Assert.fail(wnfe.getCause().getMessage());
        } finally {
            shell.close();
        }
    }

}
