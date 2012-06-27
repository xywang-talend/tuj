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

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withStyle;
import junit.framework.Assert;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCTabItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.hamcrest.Matcher;
import org.talend.swtbot.Utilities;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class TalendWebServiceItem extends TalendMetadataItem {

    private String type;

    private static final String SIMPLE = "Simple WSDL";

    private static final String ADVANCED = "Advanced WebService";

    public TalendWebServiceItem() {
        super(Utilities.TalendItemType.WEB_SERVICE);
    }

    public TalendWebServiceItem(String itemName) {
        super(itemName, Utilities.TalendItemType.WEB_SERVICE);
    }

    public void setTypeAsSimple() {
        type = SIMPLE;
    }

    public void setTypeAsAdvanced() {
        type = ADVANCED;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void create() {
        final SWTBotShell shell = beginCreationWizard("Create WSDL schema", "Create new WSDL schema");

        if (type == null) {
            Assert.fail("type should not be null, please set a type");
        }
        if (SIMPLE.equals(type)) {
            /* step 2 of 4 */
            gefBot.button("Next >").click();

            /* step 3 of 4 */
            gefBot.textWithLabel("WSDL").setText(System.getProperty("webService.url"));
            gefBot.textWithLabel("Method").setText(System.getProperty("webService.method"));
            gefBot.button("Add ").click();
            gefBot.button("Refresh Preview").click();
            final SWTBotCTabItem outputTab = gefBot.cTabItem("Output");
            Matcher matcher = allOf(widgetOfType(Button.class), withStyle(SWT.PUSH, null));
            final SWTBotButton previewButton = new SWTBotButton(
                    (Button) gefBot.widget(matcher, gefBot.cTabItem("Preview").widget));

            gefBot.waitUntil(new DefaultCondition() {

                public boolean test() throws Exception {
                    shell.setFocus();
                    boolean isPreviewFail = outputTab.isActive();
                    if (isPreviewFail)
                        return true;
                    boolean isPreviewDone = "Refresh Preview".equals(previewButton.getText());
                    return isPreviewDone;
                }

                public String getFailureMessage() {
                    return "refresh preview did not finish";
                }
            }, 30000);

            if (outputTab.isActive()) {
                Assert.fail("Refresh preview fail - " + gefBot.styledText().getText());
            }
            gefBot.button("Next >").click();
        } else if (ADVANCED.equals(type)) {
            /* step 2 of 4 */
            Utilities.deselectDefaultSelection("Simple WSDL");
            gefBot.radio("Advanced WebService").click();
            gefBot.button("Next >").click();

            /* step 3 of 4 */
            gefBot.button(1).click();// click refresh button
            gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 30000);
            gefBot.tableWithLabel("Operation:").click(0, 0);

            // set input mapping
            // left schema
            gefBot.cTabItem(" Input mapping ").activate();
            gefBot.button("Schema Management").click();
            gefBot.shell("Schema").activate();
            gefBot.buttonWithTooltip("Add").click();
            gefBot.button("OK").click();
            // right schema
            gefBot.table(1).click(0, 1);
            gefBot.buttonWithTooltip("Add list element").click();
            gefBot.shell("ParameterTree").activate();
            gefBot.tree().select("City");
            gefBot.button("OK").click();

            gefBot.table(1).click(1, 0);
            gefBot.text().setText("input.newColumn");

            // set output mapping
            // left schema
            gefBot.cTabItem(" Output mapping ").activate();
            gefBot.table(0).click(0, 0);
            gefBot.buttonWithTooltip("Add List element").click();
            gefBot.shell("ParameterTree").activate();
            gefBot.tree().select("GetWeatherResult");
            gefBot.button("OK").click();
            // right schema
            gefBot.button("...").click();
            gefBot.buttonWithTooltip("Add").click();
            gefBot.button("OK").click();

            gefBot.table(1).click(0, 0);
            gefBot.text().setText("parameters.GetWeatherResult");

            gefBot.button("Next >").click();
        }

        finishCreationWizard(shell);
    }

    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit WSDL schema", "Update WSDL schema");
    }
}
