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

package org.talend.swtbot;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.allOf;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withMnemonic;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withStyle;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefFigureCanvas;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendSchemaItem;

/**
 * DOC sgandon class global comment. Detailled comment <br/>
 * 
 * $Id: talend.epf 1 2006-09-29 17:06:40Z nrousseau $
 * 
 */
public class Utilities {

    /**
     * Define a enum for database type
     */
    public enum DbConnectionType {
        MYSQL,
        POSTGRESQL,
        MSSQL,
        ORACLE,
        AS400,
        SYBASE,
        JDBC_MYSQL,
        DB2,
        INFORMIX,
        ORACLE_OCI,
        TERADATA,
        VERTICA
    }

    /**
     * Define a enum for talend item type
     */
    public enum TalendItemType {
        BUSINESS_MODEL,
        JOB_DESIGNS,
        SERVICES,
        JOBLET_DESIGNS,
        ROUTINES,
        JOBSCRIPTS,
        SQL_TEMPLATES,
        DB_CONNECTIONS,
        SAP_CONNECTIONS,
        FILE_DELIMITED,
        FILE_POSITIONAL,
        FILE_REGEX,
        FILE_XML,
        FILE_EXCEL,
        FILE_LDIF,
        LDAP,
        SALESFORCE,
        GENERIC_SCHEMAS,
        TALEND_MDM,
        SURVIVORSHIP_RULES,
        BRMS,
        EMBEDDED_RULES,
        COPYBOOK,
        WEB_SERVICE,
        VALIDATION_RULES,
        FTP,
        HL7,
        EDI,
        CONTEXTS,
        DOCUMENTATION,
        RECYCLE_BIN
    }

    //    private static final String BUNDLE_NAME = "connectionInfo"; //$NON-NLS-1$
    //
    // private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
    private static SWTGefBot gefBot = new SWTGefBot();

    private static SWTBotView view = getRepositoryView();

    private static SWTBotTree tree = getRepositoryTree();

    private static SWTBotShell shell;

    private static final String SAMPLE_FOLDER_PATH = "/sample/"; //$NON-NLS-1$

    /**
     * return a File instance pointing to the file or folder located below this plugin sample folder
     * 
     * @param subSamplePath, path located below /sample/, so subpath should never start with a /, example : test.xsl
     * @return the File instance pointing to the obsolute path of the subSamplePath
     * @throws IOException
     * @throws URISyntaxException
     */
    public static File getFileFromCurrentPluginSampleFolder(String subSamplePath) throws IOException, URISyntaxException {
        URL url = Utilities.class.getResource(SAMPLE_FOLDER_PATH + subSamplePath);
        URI escapedURI = getFileUrl(url);
        return URIUtil.toFile(escapedURI);
    }

    /**
     * Convert any URL to a file URL
     * 
     * @param url, may be a eclipse URL
     * @return a file:/ url
     * @throws IOException
     * @throws URISyntaxException
     */
    public static URI getFileUrl(URL url) throws IOException, URISyntaxException {
        // bundleresource://875.fwk22949069:4/top400/
        URL unescapedURL = FileLocator.toFileURL(url);// bug 145096
        // file:/E:sv n/org.talend.model.migration.test/samples/top400/
        URI escapedURI = new URI(unescapedURL.getProtocol(), unescapedURL.getPath(), unescapedURL.getQuery());
        // file:/E:sv%20n/org.talend.model.migration.test/samples/top400/
        return escapedURI;
    }

    /**
     * Empty Recycle bin
     * 
     * @author fzhong
     * @return void
     */
    public static void emptyRecycleBin() {
        try {
            SWTBotTreeItem recycleBin = tree.expandNode("Recycle bin").select();
            gefBot.waitUntil(Conditions.widgetIsEnabled(recycleBin));
            if (recycleBin.rowCount() != 0) {
                recycleBin.click();
                recycleBin.contextMenu("Empty recycle bin").click();
                gefBot.waitUntil(Conditions.shellIsActive("Empty recycle bin"));
                gefBot.button("Yes").click();
            }
        } catch (Exception e) {
            gefBot.closeAllShells();
            System.out.println("ERROR: Empty recycle bin error.");
            e.printStackTrace();
        }
    }

    /**
     * DOC fzhong Comment method "createWebService".
     * 
     * @param type 'simple' or 'advanced'
     * @param webServiceName
     * @param treeNode
     */
    public static SWTBotTreeItem createWebService(String type, String webServiceName, SWTBotTreeItem treeNode) {
        treeNode.contextMenu("Create WSDL schema").click();
        gefBot.waitUntil(Conditions.shellIsActive("Create new WSDL schema"));
        shell = gefBot.shell("Create new WSDL schema").activate();
        try {
            /* step 1 of 4 */
            gefBot.textWithLabel("Name").setText(webServiceName);
            boolean nextButtonIsEnabled = gefBot.button("Next >").isEnabled();
            if (nextButtonIsEnabled) {
                gefBot.button("Next >").click();
            } else {
                shell.close();
                Assert.assertTrue("next button is not enabled, maybe the item name is exist,", nextButtonIsEnabled);
            }

            if ("simple".equals(type)) {
                /* step 2 of 4 */
                gefBot.button("Next >").click();

                /* step 3 of 4 */
                gefBot.textWithLabel("WSDL").setText(System.getProperty("webService.url"));
                gefBot.textWithLabel("Method").setText(System.getProperty("webService.method"));
                gefBot.button("Add ").click();
                gefBot.button("Refresh Preview").click();
                gefBot.waitUntil(new DefaultCondition() {

                    public boolean test() throws Exception {

                        return gefBot.button("Next >").isEnabled();
                    }

                    public String getFailureMessage() {
                        shell.close();
                        return "next button was never enabled";
                    }
                }, 60000);
                gefBot.button("Next >").click();
            } else if ("advanced".equals(type)) {
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

            /* step 4 of 4 */
            gefBot.waitUntil(new DefaultCondition() {

                public boolean test() throws Exception {

                    return gefBot.button("Finish").isEnabled();
                }

                public String getFailureMessage() {
                    shell.close();
                    return "finish button was never enabled";
                }
            });
            gefBot.button("Finish").click();
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getCause().getMessage());
        }

        SWTBotTreeItem newWebServiceItem = null;
        try {
            newWebServiceItem = treeNode.expand().select(webServiceName + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("web service item is not created", newWebServiceItem);
        }

        return treeNode.getNode(webServiceName + " 0.1");
    }

    /**
     * DOC fzhong Comment method "createHL7".
     * 
     * @param type HL7 type, 'input' or 'output'
     * @param treeNode
     * @param hl7Name
     */
    public static SWTBotTreeItem createHL7(String type, SWTBotTreeItem treeNode, String hl7Name) {
        treeNode.contextMenu("Create HL7").click();
        shell = gefBot.shell("New HL7 File").activate();
        try {
            /* step 1 of 5 */
            gefBot.textWithLabel("Name").setText(hl7Name);
            boolean nextButtonIsEnabled = gefBot.button("Next >").isEnabled();
            if (nextButtonIsEnabled) {
                gefBot.button("Next >").click();
            } else {
                shell.close();
                Assert.assertTrue("next button is not enabled, maybe the item name is exist,", nextButtonIsEnabled);
            }

            if ("input".equals(type)) {
                /* step 2 of 5 */
                gefBot.button("Next >").click();

                /* step 3 of 5 */
                gefBot.textWithLabel("HL7 File path:").setText(
                        getFileFromCurrentPluginSampleFolder(System.getProperty("hl7.filepath")).getAbsolutePath());
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
            } else if ("output".equals(type)) {
                /* step 2 of 5 */
                Utilities.deselectDefaultSelection("HL7Input");
                gefBot.radio("HL7OutPut").click();
                gefBot.button("Next >").click();

                /* step 3 of 5 */
                gefBot.radio("Create from a file").click();
                gefBot.textWithLabel("HL7 File path:").setText(
                        getFileFromCurrentPluginSampleFolder(System.getProperty("hl7.filepath")).getAbsolutePath());
                gefBot.textWithLabel("Output File Path").setText(
                        getFileFromCurrentPluginSampleFolder(System.getProperty("hl7.outputFile")).getAbsolutePath());
                gefBot.button("Next >").click();

                /* step 4 of 5 */
                gefBot.button("Next >").click();
            }

            /* step 5 of 5 */
            gefBot.button("Finish").click();
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }

        SWTBotTreeItem newHl7Item = null;
        try {
            newHl7Item = treeNode.expand().select(hl7Name + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("hl7 item is not created", newHl7Item);
        }

        return treeNode.getNode(hl7Name + " 0.1");
    }

    /**
     * DOC fzhong Comment method "copyAndPaste". Copy and paste the item(itemName + itemVersion) under tree node
     * (treeNode)
     * 
     * @param treeNode tree item node
     * @param itemName item name
     * @param itemVersion item version
     */
    public static void copyAndPaste(SWTBotTreeItem treeNode, String itemName, String itemVersion) {
        treeNode.getNode(itemName + " " + itemVersion).contextMenu("Copy").click();
        treeNode.contextMenu("Paste").click();

        SWTBotTreeItem newItem = null;
        try {
            newItem = treeNode.select("Copy_of_" + itemName + " " + itemVersion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("copy of item '" + itemName + " " + itemVersion + "' does not exist", newItem);
        }
    }

    /**
     * DOC fzhong Comment method "delete". Delete the item(itemName + itemVersion) under tree node(treeNode) of
     * tree(tree)
     * 
     * @param treeNode tree item node
     * @param itemName item name
     * @param itemVersion item version(if it is a folder, it doen't have version, set it as "null")
     * @param folderPath if no folder set it as "null", otherwise give the folder path(e.g. "a","a/b","a/b/c")
     */
    public static void delete(SWTBotTreeItem treeNode, String itemName, String itemVersion, String folderPath) {
        String nodeName = itemName;
        if (itemVersion != null)
            nodeName = nodeName + " " + itemVersion;
        treeNode.getNode(nodeName).contextMenu("Delete").click();

        SWTBotTreeItem newItem = null;
        SWTBotTreeItem recycleBin = tree.expandNode("Recycle bin").select();
        gefBot.waitUntil(Conditions.widgetIsEnabled(recycleBin));
        try {
            if (folderPath == null)
                folderPath = "";
            newItem = recycleBin.expand().getNode(nodeName + " (" + folderPath + ")");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("item did not delete to recycle bin", newItem);
        }
    }

    /**
     * DOC fzhong Comment method "duplicate". Duplicate the item(itemName + itemVersion) under tree node(treeNode) with
     * new name(newItemName)
     * 
     * @param treeNode tree item node
     * @param itemName item name
     * @param itemVersion item version
     * @param newItemName new item name
     */
    public static void duplicate(SWTBotTreeItem treeNode, String itemName, String itemVersion, String newItemName) {
        treeNode.getNode(itemName + " " + itemVersion).contextMenu("Duplicate").click();
        gefBot.shell("Please input new name ").activate();
        gefBot.textWithLabel("Input new name").setText(newItemName);
        gefBot.button("OK").click();

        SWTBotTreeItem newItem = null;
        try {
            newItem = treeNode.select(newItemName + " " + itemVersion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("duplicate of item '" + itemName + " " + itemVersion + "' does not exist", newItem);
        }
    }

    public static SWTBotTreeItem getTalendItemNode(TalendItemType itemType) {
        return getTalendItemNode(tree, itemType);
    }

    /**
     * DOC fzhong Comment method "getTalendItemNode". Get item node of the tree in repository
     * 
     * @param itemType
     * 
     * @return a tree item
     */
    public static SWTBotTreeItem getTalendItemNode(SWTBotTree tree, TalendItemType itemType) {
        switch (itemType) {
        case BUSINESS_MODEL:
            return tree.expandNode("Business Models");
        case JOB_DESIGNS:
            return tree.expandNode("Job Designs");
        case SERVICES:
            return tree.expandNode("Services");
        case JOBLET_DESIGNS:
            return tree.expandNode("Joblet Designs");
        case CONTEXTS:
            return tree.expandNode("Contexts");
        case ROUTINES:
            return tree.expandNode("Code", "Routines");
        case JOBSCRIPTS:
            return tree.expandNode("Code", "Job Scripts");
        case SQL_TEMPLATES:
            return tree.expandNode("SQL Templates");
        case DB_CONNECTIONS:
            return tree.expandNode("Metadata", "Db Connections");
        case SAP_CONNECTIONS:
            return tree.expandNode("Metadata", "SAP Connections");
        case FILE_DELIMITED:
            return tree.expandNode("Metadata", "File delimited");
        case FILE_POSITIONAL:
            return tree.expandNode("Metadata", "File positional");
        case FILE_REGEX:
            return tree.expandNode("Metadata", "File regex");
        case FILE_XML:
            return tree.expandNode("Metadata", "File xml");
        case FILE_EXCEL:
            return tree.expandNode("Metadata", "File Excel");
        case FILE_LDIF:
            return tree.expandNode("Metadata", "File ldif");
        case LDAP:
            return tree.expandNode("Metadata", "LDAP");
        case SALESFORCE:
            return tree.expandNode("Metadata", "Salesforce");
        case GENERIC_SCHEMAS:
            return tree.expandNode("Metadata", "Generic schemas");
        case TALEND_MDM:
            return tree.expandNode("Metadata", "Talend MDM");
        case SURVIVORSHIP_RULES:
            return tree.expandNode("Metadata", "Rules Management", "Survivorship Rules");
        case BRMS:
            return tree.expandNode("Metadata", "Rules Management", "BRMS");
        case EMBEDDED_RULES:
            return tree.expandNode("Metadata", "Rules Management", "Embedded Rules");
        case COPYBOOK:
            return tree.expandNode("Metadata", "Copybook");
        case WEB_SERVICE:
            return tree.expandNode("Metadata", "Web Service");
        case VALIDATION_RULES:
            return tree.expandNode("Metadata", "Validation Rules");
        case FTP:
            return tree.expandNode("Metadata", "FTP");
        case HL7:
            return tree.expandNode("Metadata", "HL7");
        case EDI:
            return tree.expandNode("Metadata", "UN/EDIFACT");
        case DOCUMENTATION:
            return tree.expandNode("Documentation");
        case RECYCLE_BIN:
            return tree.expandNode("Recycle bin");
        default:
            break;
        }
        return null;
    }

    /**
     * DOC fzhong Comment method "getView".
     * 
     * @param viewTitle
     * 
     * @return the widget of view
     */
    private static SWTBotView getView(String viewTitle) {
        return gefBot.viewByTitle(viewTitle);
    }

    /**
     * DOC fzhong Comment method "getRepositoryView". Get view by title "repository"
     * 
     * @return view widget by title
     */
    public static SWTBotView getRepositoryView() {
        return getView("Repository");
    }

    public static SWTBotTree getRepositoryTree() {
        return new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
    }

    /**
     * DOC fzhong Comment method "cleanUpRepository". Delete all items in repository.
     * 
     */
    public static void cleanUpRepository() {
        List<TalendItemType> itemList = null;
        for (TalendItemType itemType : TalendItemType.values()) {
            if ("TOS".equals(System.getProperty("buildType"))) {
                itemList = getTISItemTypes(); // if TOS, get TIS items and pass next step
            }
            if (itemList != null && itemList.contains(itemType))
                continue; // if TOS, pass TIS items
            SWTBotTreeItem treeNode = getTalendItemNode(itemType);
            if (TalendItemType.SQL_TEMPLATES.equals(itemType))
                treeNode = treeNode.expandNode("Generic", "UserDefined"); // focus on specific sql template type
            if (TalendItemType.DOCUMENTATION.equals(itemType) || TalendItemType.RECYCLE_BIN.equals(itemType))
                continue; // undo with documentation and recycle bin
            cleanUpRepository(treeNode);
        }
        emptyRecycleBin();
    }

    public static List<TalendItemType> getTISItemTypes() {
        List<TalendItemType> itemList = new ArrayList<TalendItemType>();
        itemList.add(TalendItemType.SERVICES);
        itemList.add(TalendItemType.JOBLET_DESIGNS);
        itemList.add(TalendItemType.JOBSCRIPTS);
        itemList.add(TalendItemType.SAP_CONNECTIONS);
        itemList.add(TalendItemType.BRMS);
        itemList.add(TalendItemType.EMBEDDED_RULES);
        itemList.add(TalendItemType.COPYBOOK);
        itemList.add(TalendItemType.VALIDATION_RULES);
        itemList.add(TalendItemType.HL7);
        itemList.add(TalendItemType.EDI);
        return itemList;
    }

    /**
     * DOC fzhong Comment method "cleanUpRepository". Delete all items under the tree node to recycle bin.
     * 
     * @param treeNode treeNode of the tree in repository
     */
    public static void cleanUpRepository(SWTBotTreeItem treeNode) {
        gefBot.waitUntil(Conditions.widgetIsEnabled(treeNode));
        List<String> items = treeNode.expand().getNodes();
        String exceptItem = "system";
        if (items.contains(exceptItem))
            items.remove(exceptItem);
        if (items.isEmpty())
            return;
        SWTBotTreeItemExt treeNodeExt = new SWTBotTreeItemExt(treeNode.select(items.toArray(new String[items.size()])));
        try {
            treeNodeExt.contextMenu("Delete").click();
        } catch (Exception e) {
            System.out.println("ERROR: Could not delete items under tree node '" + treeNode.getText() + "'.");
            e.printStackTrace();
            return;
        }
        cleanUpRepository(treeNode);
    }

    public static SWTBotTreeItem createFTP(String ftpName, SWTBotTreeItem treeNode) {
        treeNode.contextMenu("Create FTP").click();

        gefBot.textWithLabel("Name").setText(ftpName);
        boolean isNextButonEnable = gefBot.button("Next >").isEnabled();
        if (!isNextButonEnable) {
            gefBot.button("Cancel").click();
            Assert.assertTrue("next button is not enable, maybe the item name already exist", isNextButonEnable);
        }
        gefBot.button("Next >").click();

        gefBot.textWithLabel("Username").setText(System.getProperty("ftp.username"));
        gefBot.textWithLabel("Password").setText(System.getProperty("ftp.password"));
        gefBot.textWithLabel("Host").setText(System.getProperty("ftp.host"));
        gefBot.textWithLabel("Port").setText(System.getProperty("ftp.port"));
        gefBot.button("Finish").click();

        SWTBotTreeItem newFTPItem = null;
        try {
            newFTPItem = treeNode.expand().select(ftpName + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("ftp item is not created", newFTPItem);
        }

        return treeNode.getNode(ftpName + " 0.1");
    }

    public static void createTalendMDM(SWTBotTreeItem treeNode, String mdmName) {
        treeNode.contextMenu("Create MDM Connection").click();

        gefBot.textWithLabel("Name").setText(mdmName);
        boolean isNextButtonEnable = gefBot.button("Next >").isEnabled();
        if (!isNextButtonEnable) {
            gefBot.button("Cancel").click();
            Assert.assertTrue("mdm item is not created, maybe the item name already exist", isNextButtonEnable);
        }
        gefBot.button("Next >").click();

        try {
            gefBot.textWithLabel("Username").setText(System.getProperty("mdm.username"));
            gefBot.textWithLabel("password").setText(System.getProperty("mdm.password"));
            gefBot.textWithLabel("Server").setText(System.getProperty("mdm.server"));
            gefBot.textWithLabel("Port").setText(System.getProperty("mdm.port"));
            gefBot.button("Check").click();
            // gefBot.button("OK").click();
            if (!gefBot.button("Next >").isEnabled()) {
                gefBot.button("Cancel").click();
                Assert.fail("connection unsuccessful");
            }
            gefBot.button("Next >").click();

            gefBot.comboBoxWithLabel("Version").setSelection(System.getProperty("mdm.version"));
            gefBot.comboBoxWithLabel("Data-model").setSelection(System.getProperty("mdm.dataModel"));
            gefBot.comboBoxWithLabel("Data-Container").setSelection(System.getProperty("mdm.dataContainer"));
            gefBot.button("Finish").click();
        } catch (WidgetNotFoundException wnfe) {
            shell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            shell.close();
            Assert.fail(e.getMessage());
        }

        SWTBotTreeItem newMDMItem = null;
        try {
            newMDMItem = treeNode.expand().select(mdmName + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("mdm item is not created", newMDMItem);
        }
    }

    /**
     * DOC fzhong Comment method "dndPaletteToolOntoJob". Drag and drop component from palette onto job.
     * 
     * @param jobEditor job editor
     * @param toolLabel component label
     * @param locationOnJob the specific location on job
     */
    public static void dndPaletteToolOntoJob(SWTBotGefEditor jobEditor, String toolLabel, Point locationOnJob) {
        jobEditor.activateTool(toolLabel).click(locationOnJob.x, locationOnJob.y);
        // new JobHelper().activateTool(jobEditor, toolLabel, locationOnJob);
    }

    /**
     * Drag and drop component from palette onto business model.
     * 
     * @param modelEditor business model editor
     * @param toolLabel component label show in palette
     * @param locationOnJob the specific location on job
     * @param toolName component label show in editor
     */
    public static void dndPaletteToolOntoBusinessModel(SWTBotGefEditor modelEditor, String toolLabel, Point locationOnModel,
            String toolName) {
        modelEditor.activateTool(toolLabel).click(locationOnModel.x, locationOnModel.y);
        if (toolName != null) {
            modelEditor.doubleClick(locationOnModel.x + 10, locationOnModel.y + 10);
            List<?> list = gefBot.widgets(widgetOfType(Text.class), modelEditor.getWidget());
            new SWTBotText((Text) list.get(0)).setText(toolName);
            modelEditor.save();
        }
    }

    public static void dndPaletteToolOntoBusinessModel(SWTBotGefEditor modelEditor, String toolLabel, Point locationOnModel) {
        dndPaletteToolOntoBusinessModel(modelEditor, toolLabel, locationOnModel, null);
    }

    /**
     * DOC fzhong Comment method "dndMetadataOntoJob". Drag and drop metadata from repository onto job in specific
     * component type.
     * 
     * @param jobEditor job editor
     * @param sourceItem metadata item in reporitory
     * @param componentLabel the label of specific component type
     * @param locationOnJob the specific location on job
     */
    public static void dndMetadataOntoJob(SWTBotGefEditor jobEditor, SWTBotTreeItem sourceItem, String componentLabel,
            Point locationOnJob) {
        SWTBotGefFigureCanvas figureCanvas = new SWTBotGefFigureCanvas((FigureCanvas) gefBot.widget(
                WidgetOfType.widgetOfType(FigureCanvas.class), jobEditor.getWidget()));
        DndUtil dndUtil = new DndUtil(jobEditor.getWidget().getDisplay());

        sourceItem.select();
        dndUtil.dragAndDrop(sourceItem, figureCanvas, locationOnJob);
        if (componentLabel != null && !"".equals(componentLabel)) {
            gefBot.shell("Components").activate();
            gefBot.table(0).getTableItem(componentLabel).select();
            gefBot.button("OK").click();
            if (componentLabel.equals("tFileInputPositional"))
                gefBot.button("OK").click();
        }
        if (gefBot.activeShell().getText().equals("Added context"))
            gefBot.button("Yes").click();
    }

    public static void dndMetadataOntoBusinessModel(SWTBotGefEditor modelEditor, SWTBotTreeItem sourceItem, Point locationOnModel) {
        SWTBotGefFigureCanvas figureCanvas = new SWTBotGefFigureCanvas((FigureCanvas) gefBot.widget(
                WidgetOfType.widgetOfType(FigureCanvas.class), modelEditor.getWidget()));
        DndUtil dndUtil = new DndUtil(modelEditor.getWidget().getDisplay());

        sourceItem.select();
        dndUtil.dragAndDrop(sourceItem, figureCanvas, locationOnModel);
    }

    /**
     * Helper for radio button, to deselect default selection
     * 
     * @param currSelection the mnemonicText on the radio button.
     */
    public static void deselectDefaultSelection(final String currSelection) {
        UIThreadRunnable.syncExec(new VoidResult() {

            @SuppressWarnings("unchecked")
            public void run() {
                Matcher<Widget> matcher = allOf(widgetOfType(Button.class), withStyle(SWT.RADIO, "SWT.RADIO"),
                        withMnemonic(currSelection));

                Button b = (Button) gefBot.widget(matcher, 0); // the current selection
                b.setSelection(false);
            }

        });
    }

    /**
     * Does a <em>best effort</em> to reset the perspective. This method attempts to:
     * <ul>
     * <li>close all non-workbench windows</li>
     * <li>save and close all open editors</li>
     * <li>clean up all items in repository</li>
     * <li>reset the <em>active</em> perspective</li>
     * <ul>
     */
    public static void resetActivePerspective() {
        gefBot.closeAllShells();
        gefBot.saveAllEditors();
        gefBot.closeAllEditors();
        cleanUpRepository();
        gefBot.resetActivePerspective();
    }

    /**
     * to set the value in the component view of all kinds of DB and test the data viewer
     * 
     * @param dbItem the DB item
     * @param jobItem the job Item
     * @param expected the expected result
     * @param tableName the table name
     * @param componentType the db component type
     */
    public static void dataViewerOnDBComponent(TalendDBItem dbItem, TalendJobItem jobItem, String expected, String tableName,
            String componentType) {
        // retrive schema
        dbItem.retrieveDbSchema(tableName);
        TalendSchemaItem schema = dbItem.getSchema(tableName);
        Assert.assertNotNull("did not retrieve schema", schema.getItem());

        TalendSwtBotForTos swtbot = new TalendSwtBotForTos();
        // test drag db2 input component to workspace
        schema.setComponentType(componentType);
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), schema.getItem(), schema.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart gefEdiPart = swtbot.getTalendComponentPart(jobItem.getEditor(), schema.getItemName());
        Assert.assertNotNull("cann't get component " + schema.getComponentType() + "", gefEdiPart);

        // dataviewer
        dataView(jobItem, gefEdiPart, componentType);

        if (componentType.equals("tTeradataInput")) {
            int result = gefBot.tree().rowCount();
            Assert.assertEquals("the result is not the expected result", Integer.parseInt(expected), result);
        } else {
            String result1 = gefBot.tree().cell(0, 1);
            String result2 = gefBot.tree().cell(0, 2);
            Assert.assertEquals("the result is not the expected result", expected, result1 + result2);
        }
        gefBot.button("Close").click();

    }

    /**
     * data viewer of metadataItem
     * 
     * @param jobItem the job Item
     * @param gefEditPart the specified SWTBoTGefEditPart
     * @param componentType the type of component
     */

    public static void dataView(TalendJobItem jobItem, SWTBotGefEditPart gefEditPart, String componentType) {
        jobItem.getEditor().select(gefEditPart).setFocus();
        gefEditPart.click();
        jobItem.getEditor().clickContextMenu("Data viewer");
        gefBot.waitUntil(Conditions.shellIsActive("Data Preview: " + componentType + "_1"), 50000);
        gefBot.shell("Data Preview: " + componentType + "_1").activate();
    }

    /**
     * data viewer on SCD Component
     * 
     * @param jobItem the job Item
     * @param componentType the type of component
     * @param dbName the name of db
     * @param gefEdiPart
     */
    public static void dataViewOnSCDComponent(TalendJobItem jobItem, String componentType, String dbName,
            SWTBotGefEditPart gefEdiPart) {
        String sql = "create table dataviwer(age int, name varchar(12));\n " + "insert into dataviwer values(1, 'a');\n";

        // create table
        createTable(sql, jobItem, componentType);

        // select table
        selectTable(componentType, dbName);

        // edit schema
        gefBot.button(4).click();
        editSchema(componentType);

        Utilities.dataView(jobItem, gefEdiPart, componentType);

        String result1 = gefBot.tree().cell(0, 1);
        String result2 = gefBot.tree().cell(0, 2);
        Assert.assertEquals("the result is not the expected result", "1a", result1 + result2);
        gefBot.button("Close").click();

        // Drop table
        dropTable(sql, gefEdiPart, jobItem, componentType);
    }

    private static void dropTable(String sql, SWTBotGefEditPart gefEdiPart, TalendJobItem jobItem, String componentType) {
        sql = "drop table dataviwer;";
        gefEdiPart.click();
        gefBot.viewByTitle("Component").setFocus();
        gefBot.button(3).click();
        gefBot.waitUntil(
                Conditions.shellIsActive("SQL Builder [Component Mode] - Job:" + jobItem.getItemName() + " - Component:"
                        + componentType + "_1"), 30000);
        gefBot.shell("SQL Builder [Component Mode] - Job:" + jobItem.getItemName() + " - Component:" + componentType + "_1");
        gefBot.styledText().setText(sql);
        gefBot.toolbarButtonWithTooltip("Execute SQL (Ctrl+Enter)").click();
        gefBot.button("OK").click();
    }

    private static void editSchema(String componentType) {
        gefBot.shell("Schema of " + componentType + "_1").activate();
        gefBot.buttonWithTooltip("Add").click();
        gefBot.table(0).click(0, 3);
        gefBot.text("newColumn").setText("age");
        gefBot.table(0).click(0, 5);
        gefBot.ccomboBox("String").setSelection("int | Integer");
        gefBot.table(0).select(0);
        gefBot.buttonWithTooltip("Add").click();
        gefBot.table(0).click(1, 3);
        gefBot.text("newColumn1").setText("name");
        gefBot.table(0).select(1);
        gefBot.button("OK").click();
    }

    private static void selectTable(String componentType, String dbName) {
        gefBot.buttonWithTooltip("Show the table list for the current conection").click();

        gefBot.waitUntil(Conditions.shellIsActive("Select Table Name"), 30000);
        gefBot.shell("Select Table Name").activate();
        if (componentType.equals("tOracleSCD")) {
            gefBot.tree().expandNode(System.getProperty(dbName + ".sid")).select("DATAVIWER");
        } else {
            gefBot.tree().expandNode(System.getProperty(dbName + ".dataBase")).select("dataviwer");
        }
        gefBot.button("OK").click();
    }

    private static void createTable(String sql, TalendJobItem jobItem, String componentType) {
        gefBot.waitUntil(
                Conditions.shellIsActive("SQL Builder [Component Mode] - Job:" + jobItem.getItemName() + " - Component:"
                        + componentType + "_1"), 30000);
        gefBot.shell("SQL Builder [Component Mode] - Job:" + jobItem.getItemName() + " - Component:" + componentType + "_1")
                .activate();

        gefBot.styledText().setText(sql);
        gefBot.toolbarButtonWithTooltip("Execute SQL (Ctrl+Enter)").click();

        // if table has exist,drop the table ,then create table gain
        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        SWTBotPreferences.TIMEOUT = 100;
        try {
            gefBot.waitUntil(Conditions.shellIsActive("Error Executing SQL"));
            String errorLog = gefBot.label(1).getText();
            if (errorLog.contains("name") && errorLog.contains("existing object") || errorLog.contains("dataviwer")) {
                // String table = errorLog.split("'")[1];
                sql = "drop table dataviwer;\n" + sql;
            }

            if (errorLog.contains("Unknown table") && errorLog.contains("database doesn't exist")) {
                gefBot.button("OK").click();
            } else {
                gefBot.button("OK").click();
                gefBot.shell(
                        "SQL Builder [Component Mode] - Job:" + jobItem.getItemName() + " - Component:" + componentType + "_1")
                        .activate();
                gefBot.styledText(0).setText(sql);
                gefBot.toolbarButtonWithTooltip("Execute SQL (Ctrl+Enter)").click();
            }
        } catch (TimeoutException e) {
            // ignor this, means execute sql successfully, did not pop up error dialog
        } finally {
            SWTBotPreferences.TIMEOUT = defaultTimeout;
            gefBot.button("OK").click();
        }

    }

    /**
     * import items
     * 
     * @param archiveFileName the name of the archive file need to import under folder 'sample'.
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void importItems(String archiveFileName) throws IOException, URISyntaxException {
        gefBot.toolbarButtonWithTooltip("Import Items").click();

        gefBot.shell("Import items").activate();
        gefBot.radio("Select archive file:").click();
        gefBot.text(1).setText(Utilities.getFileFromCurrentPluginSampleFolder(archiveFileName).getAbsolutePath());
        gefBot.tree().setFocus();
        gefBot.button("Select All").click();
        gefBot.button("Finish").click();
        gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")));
    }

}
