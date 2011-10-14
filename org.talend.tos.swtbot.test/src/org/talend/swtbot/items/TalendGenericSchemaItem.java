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
package org.talend.swtbot.items;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendGenericSchemaItem extends TalendMetadataItem {

    public TalendGenericSchemaItem() {
        super(Utilities.TalendItemType.GENERIC_SCHEMAS);
    }

    public TalendGenericSchemaItem(String itemName) {
        super(itemName, Utilities.TalendItemType.GENERIC_SCHEMAS);
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create generic schema", "Create new generic schema");
        try {
            for (int i = 0; i < 3; i++) {
                gefBot.buttonWithTooltip("Add").click();
            }
            gefBot.button("Finish").click();
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }

        SWTBotTreeItem newItem = null;
        try {
            newItem = parentNode.expand().select(itemName + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("item is not created", newItem);
        }

        setItem(parentNode.getNode(itemName + " 0.1"));
    }

}
