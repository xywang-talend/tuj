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
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.talend.swtbot.DndUtil;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendXmlFileItem extends TalendFileItem {

    public TalendXmlFileItem() {
        super(Utilities.TalendItemType.FILE_XML, System.getProperty("fileXml.filepath"));
    }

    public TalendXmlFileItem(String itemName) {
        super(itemName, Utilities.TalendItemType.FILE_XML, System.getProperty("fileXml.filepath"));
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create file xml", "New Xml File");
        try {
            gefBot.button("Next >").click();
            gefBot.textWithLabel("XML").setText(Utilities.getFileFromCurrentPluginSampleFolder(filePath).getAbsolutePath());
            gefBot.button("Next >").click();

            DndUtil dndUtil = new DndUtil(shell.display);
            String[] loops = System.getProperty("filexml.loop").split("/");
            SWTBotTreeItem loop = gefBot.treeInGroup("Source Schema").expandNode(loops[0]);
            for (int i = 1; i < loops.length; i++) {
                loop = loop.expandNode(loops[i]);
            }
            SWTBotTable targetItem = gefBot.tableInGroup("Target Schema", 0);
            dndUtil.dragAndDrop(loop, targetItem);
            String[] schemas = new String[3];
            for (int i = 0; i < 3; i++) {
                schemas[i] = System.getProperty("filexml.schema" + i);
            }
            SWTBotTreeItem sourceTarget = loop.getNode(schemas[0]);
            loop.select(schemas);
            targetItem = gefBot.tableInGroup("Target Schema", 1);
            dndUtil.dragAndDrop(sourceTarget, targetItem);
            gefBot.button("Refresh Preview").click();
            // gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")));
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
        return beginEditWizard("Edit file xml", "Edit an existing Xml File");
    }
}
