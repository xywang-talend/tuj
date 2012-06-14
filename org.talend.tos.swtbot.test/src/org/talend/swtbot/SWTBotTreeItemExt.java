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

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withMnemonic;
import static org.hamcrest.Matchers.allOf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.ContextMenuFinder;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.results.WidgetResult;
import org.eclipse.swtbot.swt.finder.utils.internal.Assert;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.hamcrest.Matcher;

/**
 * @author fzhong
 * 
 */
public class SWTBotTreeItemExt extends SWTBotTreeItem {

    private Tree tree;

    /**
     * 
     * @param treeItem - A SWTBotTreeItem object from which we can get a TreeItem widget
     * @throws WidgetNotFoundException
     */
    public SWTBotTreeItemExt(final SWTBotTreeItem treeItem) throws WidgetNotFoundException {
        super(treeItem.widget);
        this.tree = syncExec(new WidgetResult<Tree>() {

            public Tree run() {
                return treeItem.widget.getParent();
            }
        });
    }

    /**
     * Overrides the behavior of {@link SWTBotTreeItem#click()} such that this method now calls
     * {@link SWTBotTreeItemExt#click(int)} with an index of 0 This method will click on the first column cell
     */
    @Override
    public SWTBotTreeItem click() {
        return click(0);
    }

    /**
     * @param column - Index of the column on which the caller wants to click
     * @return
     * 
     * Clicks on the current TreeItem in the column specified by <code>column</code>
     */
    public SWTBotTreeItem click(final int column) {
        assertEnabled();
        Rectangle cellBounds = syncExec(new Result<Rectangle>() {

            public Rectangle run() {
                Rectangle r = widget.getBounds(column);
                return r;
            }
        });

        int x = (cellBounds.width / 2);
        clickXY(cellBounds.x + x, cellBounds.y + (cellBounds.height / 2));
        return this;
    }

    /**
     * @param column - Name of the column on which the caller wants to click
     * @return
     * 
     * Clicks on the current TreeItem in the column specified by <code>column</code>
     */
    public SWTBotTreeItem click(final String columnName) {
        final List<String> columnNames = new ArrayList<String>();
        UIThreadRunnable.syncExec(new VoidResult() {

            public void run() {
                TreeColumn[] columns = tree.getColumns();
                for (TreeColumn column : columns)
                    columnNames.add(column.getText());
            }
        });
        Assert.isLegal(columnNames.contains(columnName), "The column `" + columnName + "' is not found."); //$NON-NLS-1$ //$NON-NLS-2$
        int columnIndex = columnNames.indexOf(columnName);
        if (columnIndex == -1)
            return this;
        return click(columnIndex);
    }

    public String getText(int column) {
        return cell(column);
    }

    /**
     * Improve function of contextMenu to delete two more items at the same time
     */
    @SuppressWarnings("unchecked")
    @Override
    public SWTBotMenu contextMenu(final String text) {
        waitForEnabled();
        notifyTree(SWT.MouseDown, createMouseEvent(0, 0, 3, 0, 1));
        notifyTree(SWT.MouseUp, createMouseEvent(0, 0, 3, 0, 1));
        notifyTree(SWT.MenuDetect);

        Matcher<MenuItem> withMnemonic = withMnemonic(text);
        final Matcher<MenuItem> matcher = allOf(widgetOfType(MenuItem.class), withMnemonic);
        final ContextMenuFinder menuFinder = new ContextMenuFinder(tree);

        new SWTBot().waitUntil(new DefaultCondition() {

            public String getFailureMessage() {
                return "Could not find context menu with text: " + text; //$NON-NLS-1$
            }

            public boolean test() throws Exception {
                return !menuFinder.findMenus(matcher).isEmpty();
            }
        });

        List<MenuItem> menuItems = menuFinder.findMenus(matcher);
        for (MenuItem m : menuItems)
            if (!m.isDisposed())
                return new SWTBotMenu(m, matcher);
        return new SWTBotMenu(menuItems.get(0), matcher);
    }

    private void notifyTree(int eventType) {
        notify(eventType, createEvent(), tree);
    }

    private void notifyTree(int eventType, Event event) {
        notify(eventType, event, tree);
    }

}
