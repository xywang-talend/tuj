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

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.utils.MessageFormat;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotLabel;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class SWTBotLabelExt extends SWTBotLabel {

    /**
     * @param label A SWTBotLabel object from which we can get a label widget
     * @throws WidgetNotFoundException
     */
    public SWTBotLabelExt(SWTBotLabel label) throws WidgetNotFoundException {
        super(label.widget);
    }

    public SWTBotLabel rightClick() {
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

    public SWTBotLabel click() {
        assertEnabled();
        Rectangle cellBounds = syncExec(new Result<Rectangle>() {

            public Rectangle run() {
                Rectangle r = widget.getBounds();
                return r;
            }
        });

        int x = (cellBounds.width / 2);
        int y = (cellBounds.height / 2);
        clickXY(x, y);
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

    protected void clickXY(int x, int y) {
        log.debug(MessageFormat.format("Clicking on {0}", this)); //$NON-NLS-1$
        notify(SWT.MouseEnter);
        notify(SWT.MouseMove);
        notify(SWT.Activate);
        notify(SWT.FocusIn);
        notify(SWT.MouseDown, createMouseEvent(x, y, 1, SWT.BUTTON1, 1));
        notify(SWT.MouseUp);
        notify(SWT.Selection);
        notify(SWT.MouseHover);
        notify(SWT.MouseMove);
        notify(SWT.MouseExit);
        notify(SWT.Deactivate);
        notify(SWT.FocusOut);
        log.debug(MessageFormat.format("Clicked on {0}", this)); //$NON-NLS-1$
    }

}
