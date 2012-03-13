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

import junit.framework.Assert;

import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendEmbeddedRulesItem extends TalendMetadataItem {

    private String resourceType;

    public TalendEmbeddedRulesItem() {
        super(Utilities.TalendItemType.EMBEDDED_RULES);
    }

    public TalendEmbeddedRulesItem(String itemName, String resourceType) {
        super(itemName, Utilities.TalendItemType.EMBEDDED_RULES);
        this.resourceType = resourceType;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create Rules", "New Rule ...");
        try {
            if ("XLS".equals(resourceType)) {
                gefBot.radio("select").click();
                gefBot.comboBoxWithLabel("Type of rule resource:").setSelection("New XLS (Excel)");
                gefBot.textWithLabel("DRL/XLS").setText(
                        Utilities.getFileFromCurrentPluginSampleFolder("ExcelRulesTest.xls").getAbsolutePath());
                // can't get download shell at this step
            } else if ("DRL".equals(resourceType)) {
                gefBot.radio("create").click();
                gefBot.comboBoxWithLabel("Type of rule resource:").setSelection("New DRL (rule package)");
            }
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }
        finishCreationWizard(shell);
    }

    public SWTBotGefEditor getEditor() {
        return gefBot.gefEditor(itemFullName);
    }
}
