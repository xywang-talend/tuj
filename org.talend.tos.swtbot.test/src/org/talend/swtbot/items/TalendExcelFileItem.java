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

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendExcelFileItem extends TalendFileItem {

    public TalendExcelFileItem() {
        super(Utilities.TalendItemType.FILE_EXCEL, System.getProperty("fileExcel.filepath"));
    }

    public TalendExcelFileItem(String itemName) {
        super(itemName, Utilities.TalendItemType.FILE_EXCEL, System.getProperty("fileExcel.filepath"));
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create file Excel", "New Excel File");
        try {
            gefBot.textWithLabel("File").setText(Utilities.getFileFromCurrentPluginSampleFolder(filePath).getAbsolutePath());
            gefBot.waitUntil(Conditions.shellIsActive("Progress Information"));
            gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 60000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            // pass exception if not found progress bar
        }
        gefBot.treeWithLabel("Set sheets parameters").getTreeItem("All sheets/DSelect sheet").check();
        gefBot.button("Next >").click();
        finishCreationWizard(shell);
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit file Excel", "Edit an existing Excel File");
    }
}
