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
package org.talend.swtbot.helpers;

import junit.framework.Assert;

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class BusinessModelHelper implements Helper {

    public static void assertSelected(SWTBotGefEditPart component) {
        Assert.assertTrue("component isn't selected", component.part().isSelectable());
    }
}
