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
public class TalendEdiItem extends TalendMetadataItem {

    private String standard;

    private String release;

    private String[] schemas;

    private String filePath;

    public TalendEdiItem() {
        super(Utilities.TalendItemType.EDI);
    }

    public TalendEdiItem(String itemName, String standard, String release, String[] schema) {
        super(itemName, Utilities.TalendItemType.EDI);
        this.standard = standard;
        this.release = release;
        this.schemas = schema;
    }

    public String getStandard() {
        return this.standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String[] getSchemas() {
        return this.schemas;
    }

    public void setSchemas(String[] schemas) {
        this.schemas = schemas;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAbsoluteFilePath() throws IOException, URISyntaxException {
        return Utilities.getFileFromCurrentPluginSampleFolder(filePath).getAbsolutePath();
    }

    @Override
    public void create() {
        SWTBotShell shell = beginCreationWizard("Create EDI", "Create new EDI schema");
        try {
            gefBot.tree().expandNode(getStandard()).getNode(getRelease()).click();
            gefBot.button("Next >").click();

            String[] schemas = getSchemas();
            SWTBotTreeItem root = gefBot.tree(0).expandNode("BGM(Beginning_of_message)", "DOCUMENT_MESSAGE_NAME");
            SWTBotTreeItem sourceItem = root.getNode(schemas[0]);
            root.select(schemas);
            SWTBotTable targetItem = gefBot.tableInGroup("Schema");
            DndUtil dndUtil = new DndUtil(shell.display);
            dndUtil.dragAndDrop(sourceItem, targetItem);
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
        return beginEditWizard("Edit EDI", "Create new EDI schema");
    }
}
