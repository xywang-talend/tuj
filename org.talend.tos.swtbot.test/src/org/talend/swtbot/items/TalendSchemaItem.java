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
package org.talend.swtbot.items;

import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities.TalendItemType;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendSchemaItem extends TalendMetadataItem {

    TalendSchemaItem() {
        super();
    }

    TalendSchemaItem(TalendItemType itemType) {
        super(itemType);
    }

    public String getComponentLabel() {
        if (this.componentLabel != null)
            return this.componentLabel;
        if (TalendItemType.DB_CONNECTIONS.equals(this.getItemType()))
            return "\"" + this.itemName + "\"";
        return this.itemName;
    }

    /**
     * get the actived shell after click context menu of schema
     * 
     * @return shell of context menu
     */
    private SWTBotShell activeShellOfContextMenu(String contextMenu, String shellTitle) {
        getItem().contextMenu(contextMenu).click();
        gefBot.waitUntil(Conditions.shellIsActive(shellTitle), 10000);
        return gefBot.shell(shellTitle).activate();
    }

    /**
     * Right click schema and click 'Edit Schema'.
     * 
     * @return shell of 'Edit Schema'
     */
    public SWTBotShell editSchema() {
        return activeShellOfContextMenu("Edit Schema", "Schema");
    }

    /**
     * Right click schema and click 'Data Viewer'/
     * 
     * @return shell of 'Data Viewer'
     */
    public SWTBotShell dataViewer() {
        return activeShellOfContextMenu("Data Viewer", "Data Preview: ");
    }
}
