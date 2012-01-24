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

import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendSchemaItem extends TalendMetadataItem {

    /**
     * Right click schema and click 'Edit Schema'.
     * 
     * @return shell of 'Edit Schema'
     */
    public SWTBotShell editSchema() {
        SWTBotShell shell;
        getItem().contextMenu("Edit Schema").click();
        shell = new SWTGefBot().shell("Schema");
        return shell;
    }
}
