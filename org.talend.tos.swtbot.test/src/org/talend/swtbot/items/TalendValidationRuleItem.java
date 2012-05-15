package org.talend.swtbot.items;

import junit.framework.Assert;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.talend.swtbot.DndUtil;
import org.talend.swtbot.SWTBotTableExt;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.TalendItemType;

public class TalendValidationRuleItem extends TalendMetadataItem {

    private TalendMetadataItem baseMetadata;

    private String ruleType;

    private static final String REFERENCE_CHECK = "Reference Check"; // $NON-NLS-1$

    private static final String BASIC_VALUE_CHECK = "Basic Value Check"; // $NON-NLS-1$

    private static final String CUSTOM_CHECK = "Custom Check"; // $NON-NLS-1$

    public TalendValidationRuleItem() {
        super(Utilities.TalendItemType.VALIDATION_RULES);
    }

    public TalendValidationRuleItem(String itemName) {
        super(itemName, Utilities.TalendItemType.VALIDATION_RULES);
    }

    public TalendMetadataItem getBaseMetadata() {
        return baseMetadata;
    }

    public void setBaseMetadata(TalendMetadataItem baseMetadata) {
        this.baseMetadata = baseMetadata;
    }

    public String getRuleType() {
        return ruleType;
    }

    private void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public void setRuleTypeAsReferenceCheck() {
        setRuleType(REFERENCE_CHECK);
    }

    public void setRuleTypeAsBasicValueCheck() {
        setRuleType(BASIC_VALUE_CHECK);
    }

    public void setRuleTypeAsCustomCheck() {
        setRuleType(CUSTOM_CHECK);
    }

    @Override
    public void create() {
        if (ruleType == null)
            Assert.fail("please set a rule type");
        SWTBotShell shell = beginCreationWizard("Create validation rule", "New Validation Rule");

        SWTBotTreeItem metadataNode = Utilities.getTalendItemNode(gefBot.tree(), baseMetadata.getItemType());
        if (TalendItemType.DB_CONNECTIONS.equals(baseMetadata.getItemType())) {
            metadataNode.expandNode(baseMetadata.getItemFullName(), "Table schemas").select("test");
        } else {
            metadataNode.expandNode(baseMetadata.getItemFullName()).select("metadata");
        }
        gefBot.button("Select All").click();
        gefBot.button("Next >").click();

        if (REFERENCE_CHECK.equals(ruleType)) {
            gefBot.radio(0).click();
            gefBot.button("Next >").click();
            metadataNode = Utilities.getTalendItemNode(gefBot.tree(), TalendItemType.DB_CONNECTIONS);
            metadataNode.expandNode(baseMetadata.getItemFullName(), "Table schemas").select("reference");
            gefBot.button("Next >").click();
            DndUtil dndUtil = new DndUtil(shell.display);
            SWTBotTableItem sourceItem = null;
            SWTBotTableItem targetItem = null;
            for (int i = 0; i < gefBot.table(0).rowCount(); i++) {
                sourceItem = gefBot.table(0).getTableItem(i);
                targetItem = gefBot.table(1).getTableItem(i);
                dndUtil.dragAndDrop(sourceItem, targetItem);
            }
        } else if (BASIC_VALUE_CHECK.equals(ruleType)) {
            gefBot.radio(1).click();
            gefBot.button("Next >").click();
            gefBot.buttonWithTooltip("Add").click();
            SWTBotTable table = gefBot.tableWithLabel("Conditions");
            SWTBotTableExt tableExt = new SWTBotTableExt(table);
            tableExt.click(0, "input column");
            if (!tableExt.isClicked())
                tableExt.click(0, "input column");
            gefBot.ccomboBox().setSelection("Column0");
            tableExt.click(0, "function");
            if (!tableExt.isClicked())
                tableExt.click(0, "function");
            gefBot.ccomboBox().setSelection("Empty");
            tableExt.click(0, "operator");
            if (!tableExt.isClicked())
                tableExt.click(0, "operator");
            gefBot.ccomboBox().setSelection("Greater");
            tableExt.click(0, "value");
            if (!tableExt.isClicked())
                tableExt.click(0, "value");
            gefBot.text().setText("5");
        } else if (CUSTOM_CHECK.equals(ruleType)) {
            gefBot.radio(2).click();
            gefBot.button("Next >").click();
            gefBot.styledText().setText("after_tFileInputDelimited_1.Column0 > 5");
        }
        gefBot.button("Next >").click();

        finishCreationWizard(shell);
    }
}
