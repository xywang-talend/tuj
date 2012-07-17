package org.talend.swtbot.test.commons;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.results.WidgetResult;
import org.eclipse.swtbot.swt.finder.utils.MessageFormat;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;

public class SWTBotTableItemExt extends SWTBotTableItem {

	private Table table;

	public SWTBotTableItemExt(final SWTBotTableItem tableItem)
			throws WidgetNotFoundException {
		super(tableItem.widget);
		this.table = syncExec(new WidgetResult<Table>() {
			public Table run() {
				return tableItem.widget.getParent();
			}
		});
	}

	public SWTBotTableItem rightClick() {
        assertEnabled();
        Rectangle cellBounds = syncExec(new Result<Rectangle>() {

            public Rectangle run() {
                Rectangle r = widget.getBounds();
                return r;
            }
        });

        int x = (cellBounds.width / 2);
        int y = (cellBounds.height / 2);
        rightClickXY(cellBounds.x + x, cellBounds.y + y);
        return this;
    }
	
	protected void rightClickXY(int x, int y) {
        log.debug(MessageFormat.format("Right clicking on {0}", this)); //$NON-NLS-1$
        notify(SWT.MouseEnter);
        notify(SWT.MouseMove);
        notify(SWT.Activate);
        notify(SWT.FocusIn);
        notify(SWT.MouseDown, createMouseEvent(x, y, 3, SWT.BUTTON3, 1));
        notify(SWT.MouseUp, createMouseEvent(x, y, 3, SWT.BUTTON3, 1));
        notify(SWT.Selection);
        notify(SWT.MouseHover);
        notify(SWT.MouseMove);
        notify(SWT.MouseExit);
        notify(SWT.Deactivate);
        notify(SWT.FocusOut);
        log.debug(MessageFormat.format("Right clicked on {0}", this)); //$NON-NLS-1$
    }

	@Override
	public SWTBotMenu contextMenu(String text) throws WidgetNotFoundException {
		new SWTBot().waitUntil(Conditions.widgetIsEnabled(new SWTBotTable(table)));
		rightClick();
		return super.contextMenu(table, text);
	}
}
