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

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendRegexFileItem extends TalendFileItem {

    public TalendRegexFileItem() {
        super(Utilities.TalendItemType.FILE_REGEX, System.getProperty("fileRegex.filepath"));
    }

    public TalendRegexFileItem(String itemName) {
        super(itemName, Utilities.TalendItemType.FILE_REGEX, System.getProperty("fileRegex.filepath"));
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create file regex", "New RegEx File");
        try {
            gefBot.textWithLabel("File").setText(Utilities.getFileFromCurrentPluginSampleFolder(filePath).getAbsolutePath());
            gefBot.button("Next >").click();
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }
        finishCreationWizard(shell);
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit file regex", "Edit an existing RegEx File");
    }
}
