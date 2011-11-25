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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendCopybookItem extends TalendMetadataItem {

    public TalendCopybookItem() {
        super(Utilities.TalendItemType.COPYBOOK);
    }

    public TalendCopybookItem(String itemName) {
        super(itemName, Utilities.TalendItemType.COPYBOOK);
    }

    public Map<String, SWTBotTreeItem> retrieveSchema(String... schemaName) {
        Map<String, SWTBotTreeItem> schemas = new HashMap<String, SWTBotTreeItem>();
        SWTGefBot gefBot = new SWTGefBot();

        getItem().contextMenu("Retrieve Schema").click();
        SWTBotShell shell = gefBot.shell("Schema").activate();
        try {
            gefBot.button("Next >").click();
            List<String> schemaNames = new ArrayList<String>(Arrays.asList(schemaName));
            for (String schema : schemaNames) {
                gefBot.tableInGroup("Select Schema to create").getTableItem(schema).check();
            }
            gefBot.button("Next >").click();
            gefBot.button("Finish").click();
            for (String schema : schemaNames) {
                schemas.put(schema, getItem().getNode(schema).select());
            }
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }
        return schemas;
    }
}
