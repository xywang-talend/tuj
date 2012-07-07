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
package org.talend.swtbot;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;

/**
 * DOC vivian class global comment. Detailled comment
 */
public class SWTBotTreeExt extends SWTBotTree {

    private Tree tree;

    public SWTBotTreeExt(SWTBotTree tree) throws WidgetNotFoundException {
        super(tree.widget);
        this.tree = tree.widget;
    }

    /**
     * Gets the column matching the given label.
     * 
     * @param label the header text.
     * @return the header of the table.
     * @throws WidgetNotFoundException if the header is not found.
     */
    public SWTBotTreeColumn header(final String label) throws WidgetNotFoundException {
        TreeColumn column = syncExec(new Result<TreeColumn>() {

            public TreeColumn run() {
                TreeColumn[] columns = tree.getColumns();
                for (TreeColumn column : columns) {
                    if (column.getText().equals(label))
                        return column;
                }
                return null;
            }
        });
        return new SWTBotTreeColumn(column, tree);
    }

}
