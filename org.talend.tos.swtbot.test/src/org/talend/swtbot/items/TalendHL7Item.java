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

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Assert;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendHL7Item extends TalendFileItem {

    private String type;

    private static final String INTPUT = "input";

    private static final String OUTPUT = "output";

    public TalendHL7Item() {
        super(Utilities.TalendItemType.HL7, System.getProperty("hl7.filepath"));
    }

    public TalendHL7Item(String itemName) {
        super(itemName, Utilities.TalendItemType.HL7, System.getProperty("hl7.filepath"));
    }

    public void setTypeAsInput() {
        type = INTPUT;
    }

    public void setTypeAsOutput() {
        type = OUTPUT;
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit HL7", "New HL7 File");
    }

    public void create() {
        SWTBotShell shell = beginCreationWizard("Create HL7", "New HL7 File");

        if (type == null) {
            Assert.fail("type should not be null, please set a type");
        }
        if (INTPUT.equals(type)) {
            /* step 2 of 5 */
            gefBot.button("Next >").click();

            /* step 3 of 5 */
            try {
                gefBot.textWithLabel("HL7 File path:").setText(
                        Utilities.getFileFromCurrentPluginSampleFolder(System.getProperty("hl7.filepath")).getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            gefBot.button("Next >").click();

            /* step 4 of 5 */
            for (int i = 0; i < 3; i++) {
                gefBot.buttonWithTooltip("Add").click();
                gefBot.tableInGroup("Schema View").click(i, 3);
                gefBot.text().setText(System.getProperty("hl7.column.MSH" + i));
                gefBot.tableInGroup("Schema View").select(i);
            }
            gefBot.comboBoxWithLabel("Segment(As Schema)").setSelection("EVN");
            for (int j = 0; j < 2; j++) {
                gefBot.buttonWithTooltip("Add").click();
                gefBot.tableInGroup("Schema View").click(j, 3);
                gefBot.text().setText(System.getProperty("hl7.column.EVN" + j));
                gefBot.tableInGroup("Schema View").select(j);
            }
            gefBot.button("Next >").click();
        } else if (OUTPUT.equals(type)) {
            /* step 2 of 5 */
            Utilities.deselectDefaultSelection("HL7Input");
            gefBot.radio("HL7OutPut").click();
            gefBot.button("Next >").click();

            /* step 3 of 5 */
            gefBot.radio("Create from a file").click();
            try {
                gefBot.textWithLabel("HL7 File path:").setText(
                        Utilities.getFileFromCurrentPluginSampleFolder(System.getProperty("hl7.filepath")).getAbsolutePath());
                gefBot.textWithLabel("Output File Path").setText(
                        Utilities.getFileFromCurrentPluginSampleFolder(System.getProperty("hl7.outputFile")).getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            gefBot.button("Next >").click();

            /* step 4 of 5 */
            gefBot.button("Next >").click();
        }

        finishCreationWizard(shell);
    }

    public void finishCreationWizard(final SWTBotShell shell) {
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return gefBot.button("Finish").isEnabled();
            }

            public String getFailureMessage() {
                shell.close();
                return "finish button is not enabled, item created fail. Maybe the item name already exist";
            }

        });
        gefBot.button("Finish").click();

        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        SWTBotPreferences.TIMEOUT = 100;
        try {
            gefBot.shell("Problem Executing Operation").activate();
            String errorLog = gefBot.label(1).getText();
            gefBot.button("OK").click();
            Assert.fail(errorLog);
        } catch (WidgetNotFoundException e) {
            // ignore this exception, means error dialog didn't pop up, creating item successfully
        } finally {
            SWTBotPreferences.TIMEOUT = defaultTimeout;
        }

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return !shell.isOpen();
            }

            public String getFailureMessage() {
                return "shell did not close automatically";
            }

        }, 30000);

        if (gefBot.toolbarButtonWithTooltip("Save (Ctrl+S)").isEnabled()) {
            gefBot.toolbarButtonWithTooltip("Save (Ctrl+S)").click();
        }

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return getParentNode().expand().getNode(getItemFullName()).isVisible();
            }

            public String getFailureMessage() {
                return "item '" + getItemFullName() + "' did not create";
            }
        });

        setItem(getParentNode().getNode(getItemFullName()));
    }

}
