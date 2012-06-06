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
package org.talend.swtbot.helpers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.items.TalendEdiItem;
import org.talend.swtbot.items.TalendMetadataItem;
import org.talend.swtbot.items.TalendRecycleBinItem;
import org.talend.swtbot.items.TalendValidationRuleItem;

/**
 * DOC fzhong class global comment. Detailled comment
 */
public class MetadataHelper implements Helper {

    /**
     * DOC fzhong Comment method "output2Console". Use component "tLogRow" to output metadata which has default row name
     * "Main" in context menu to console.
     * 
     * @param jobEditor
     * @param item Metadata item
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void output2Console(SWTBotGefEditor jobEditor, TalendMetadataItem item) throws IOException, URISyntaxException {
        output2Console(jobEditor, item, "Main");
    }

    public static void output2Console(SWTBotGefEditor jobEditor, TalendMetadataItem item, long timeout) throws IOException,
            URISyntaxException {
        output2Console(jobEditor, item, "Main", timeout);
    }

    public static void output2Console(SWTBotGefEditor jobEditor, TalendMetadataItem item, String rowName) throws IOException,
            URISyntaxException {
        output2Console(jobEditor, item, rowName, 60000);
    }

    /**
     * DOC fzhong Comment method "output2Console". Use component "tLogRow" to output metadata to console.
     * 
     * @param jobEditor
     * @param item Metadata item
     * @param rowName The name of row in the context menu of component. "Main" as default.
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void output2Console(SWTBotGefEditor jobEditor, TalendMetadataItem item, String rowName, long timeout)
            throws IOException, URISyntaxException {
        Utilities.dndMetadataOntoJob(jobEditor, item.getItem(), item.getComponentType(), new Point(100, 100));

        SWTBotGefEditPart metadata = UTIL.getTalendComponentPart(jobEditor, item.getComponentLabel());
        Assert.assertNotNull("can not get component '" + item.getComponentType() + "'", metadata);
        if (item instanceof TalendEdiItem) {
            metadata.click();
            GEFBOT.viewByTitle("Component").setFocus();
            UTIL.selecteAllTalendTabbedPropertyListIndex(0);
            GEFBOT.waitUntil(new DefaultCondition() {

                public boolean test() throws Exception {
                    return GEFBOT.textInGroup("EDI parameters", 0).getText().equals("\"\"");
                }

                public String getFailureMessage() {
                    return "component setting panel is not visible";
                }
            }, 10000);
            String fileName = "\"" + ((TalendEdiItem) item).getAbsoluteFilePath() + "\"";
            fileName = fileName.replace("\\", "/");
            SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
            GEFBOT.textInGroup("EDI parameters", 0).selectAll().typeText(fileName, 0);
        }
        JobHelper.connect2TLogRow(jobEditor, metadata, rowName, new Point(300, 100));
        JobHelper.runJob(jobEditor, timeout);
    }

    /**
     * DOC fzhong Comment method "assertResult". Assert the result of running.
     * 
     * @param actualResult Result in console after running
     * @param item Metadata item which contains expect result
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void assertResult(String actualResult, TalendMetadataItem item) throws IOException, URISyntaxException {
        String expectResult = item.getExpectResult();
        assertResult(actualResult, expectResult);
    }

    public static void assertResult(String actualResult, String expectResult) {
        String realResult = JobHelper.execResultFilter(actualResult);
        if (realResult == null || realResult.equals(actualResult))
            Assert.fail("job running fail - " + realResult);
        if (!realResult.contains(expectResult.trim()) && !expectResult.trim().contains(realResult))
            Assert.fail("the result is not expected - " + realResult);
    }

    /**
     * DOC fzhong Comment method "activateValidationRule". Use an existing validation rule for an component.
     * 
     * @param component
     * @param ruleItem
     */
    public static void activateValidationRule(SWTBotGefEditPart component, TalendValidationRuleItem ruleItem) {
        component.click();
        GEFBOT.viewByTitle("Component").setFocus();
        UTIL.selecteAllTalendTabbedPropertyListIndex(5);
        GEFBOT.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return GEFBOT.checkBox("Use an existing validation rule").isVisible();
            }

            public String getFailureMessage() {
                return "component setting panel is not visible";
            }
        }, 10000);
        GEFBOT.checkBox("Use an existing validation rule").click();
        GEFBOT.ccomboBox("Built-In").setSelection("Repository");
        GEFBOT.button(0).click();
        SWTBotShell shell = GEFBOT.shell("Repository Content").activate();
        try {
            GEFBOT.tree().expandNode("Validation Rules").select(ruleItem.getItemFullName());
        } catch (WidgetNotFoundException e) {
            shell.close();
            Assert.fail(e.getCause().getMessage());
        }
        GEFBOT.button("OK").click();
    }

    public static TalendRecycleBinItem getRecycleBinItem(String itemName) {
        TalendRecycleBinItem item = new TalendRecycleBinItem();
        SWTBotTreeItem treeNode = null;
        try {
            treeNode = item.getParentNode().expand().getNode(itemName);
        } catch (Exception e) {
            // ignore this, means if it could not find node, set treeNode as NULL;
        }
        item.setItem(treeNode);
        return item;
    }
}
