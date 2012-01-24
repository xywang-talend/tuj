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

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.anyOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;

import java.util.List;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.utils.internal.Assert;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.hamcrest.Matcher;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class SWTBotTableExt extends SWTBotTable {

    public SWTBotTableExt(SWTBotTable table) throws WidgetNotFoundException {
        super(table.widget);
    }

    public void click(int row, String columnName) {
        Assert.isLegal(columns().contains(columnName), "The column `" + columnName + "' is not found."); //$NON-NLS-1$ //$NON-NLS-2$
        List<String> columns = columns();
        int columnIndex = columns.indexOf(columnName);
        if (columnIndex == -1)
            return;
        click(row, columnIndex);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public boolean isClicked() {
        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        SWTBotPreferences.TIMEOUT = 50;
        try {
            sleep(50);
            Matcher matcher = anyOf(widgetOfType(CCombo.class), widgetOfType(Text.class));
            new SWTBot().widget(matcher, widget);
        } catch (WidgetNotFoundException e) {
            return false;
        } finally {
            SWTBotPreferences.TIMEOUT = defaultTimeout;
        }
        return true;
    }
}
