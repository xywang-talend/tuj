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
package org.talend.swtbot.helpers;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class BusinessModelHelper implements Helper {

    public static void assertSelected(SWTBotGefEditPart component) {
        Assert.assertTrue("component isn't selected", component.part().isSelectable());
    }

    public static List<SWTBotGefEditPart> editPartsWithLabel(SWTBotGefEditor editor, String label) {
        List<SWTBotGefEditPart> allEditParts = editor.mainEditPart().children();
        allEditParts.addAll(editor.mainEditPart().sourceConnections());
        return editPartsWithLabel(label, allEditParts);
    }

    private static List<SWTBotGefEditPart> editPartsWithLabel(String label, List<SWTBotGefEditPart> allEditParts) {
        List<SWTBotGefEditPart> fitEditParts = new ArrayList<SWTBotGefEditPart>();
        for (SWTBotGefEditPart child : allEditParts) {
            List<SWTBotGefEditPart> childEditParts = editPartsWithLabel(child, label);
            for (SWTBotGefEditPart temp : childEditParts) {
                fitEditParts.add(temp);
            }
        }
        return fitEditParts;
    }

    /**
     * get this edit part with the label as a single selection
     */
    private static List<SWTBotGefEditPart> editPartsWithLabel(SWTBotGefEditPart editPart, String label) {
        List<SWTBotGefEditPart> allEditParts = editPart.children();
        if (editPart.children().isEmpty() && findLabelFigure(((GraphicalEditPart) editPart.part()).getFigure(), label)) {
            allEditParts.add(editPart);
            return allEditParts;
        }

        allEditParts.addAll(editPart.sourceConnections());
        return editPartsWithLabel(label, allEditParts);
    }

    /**
     * @return if the figure is a label
     */
    private static boolean isLabel(IFigure figure, String label) {
        // case 1 : gef label
        if ((figure instanceof Label && ((Label) figure).getText().equals(label))) {
            return true;
        }

        // case 2 : no gef label
        if ((figure instanceof TextFlow && ((TextFlow) figure).getText().equals(label))) {
            return true;
        }
        return false;
    }

    /**
     * @return if the figure or all its children contain the label
     */
    private static boolean findLabelFigure(IFigure figure, String label) {
        if (isLabel(figure, label)) {
            return true;
        }
        for (Object figureChild : figure.getChildren()) {
            if (isLabel((IFigure) figureChild, label) || findLabelFigure((IFigure) figureChild, label)) {
                return true;
            }
        }
        return false;
    }

}
