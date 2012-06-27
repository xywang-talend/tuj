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

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendFtpItem extends TalendMetadataItem {

    public TalendFtpItem() {
        super(Utilities.TalendItemType.FTP);
    }

    public TalendFtpItem(String itemName) {
        super(itemName, Utilities.TalendItemType.FTP);
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit FTP", null);
    }

    public void create() {
        SWTBotShell shell = beginCreationWizard("Create FTP", null);

        gefBot.textWithLabel("Username").setText(System.getProperty("ftp.username"));
        gefBot.textWithLabel("Password").setText(System.getProperty("ftp.password"));
        gefBot.textWithLabel("Host").setText(System.getProperty("ftp.host"));
        gefBot.textWithLabel("Port").setText(System.getProperty("ftp.port"));

        finishCreationWizard(shell);
    }
}
