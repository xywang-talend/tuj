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
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.swtbot.items.TalendBrmsItem;
import org.talend.swtbot.items.TalendBusinessModelItem;
import org.talend.swtbot.items.TalendContextItem;
import org.talend.swtbot.items.TalendCopybookItem;
import org.talend.swtbot.items.TalendDBItem;
import org.talend.swtbot.items.TalendDelimitedFileItem;
import org.talend.swtbot.items.TalendDocumentationItem;
import org.talend.swtbot.items.TalendEdiItem;
import org.talend.swtbot.items.TalendEmbeddedRulesItem;
import org.talend.swtbot.items.TalendExcelFileItem;
import org.talend.swtbot.items.TalendFtpItem;
import org.talend.swtbot.items.TalendGenericSchemaItem;
import org.talend.swtbot.items.TalendHL7Item;
import org.talend.swtbot.items.TalendItem;
import org.talend.swtbot.items.TalendJobItem;
import org.talend.swtbot.items.TalendJobScriptItem;
import org.talend.swtbot.items.TalendJobletItem;
import org.talend.swtbot.items.TalendLdapItem;
import org.talend.swtbot.items.TalendLdifFileItem;
import org.talend.swtbot.items.TalendMdmItem;
import org.talend.swtbot.items.TalendPositionalFileItem;
import org.talend.swtbot.items.TalendRecycleBinItem;
import org.talend.swtbot.items.TalendRegexFileItem;
import org.talend.swtbot.items.TalendRoutineItem;
import org.talend.swtbot.items.TalendSalesforceItem;
import org.talend.swtbot.items.TalendSapItem;
import org.talend.swtbot.items.TalendSchemaItem;
import org.talend.swtbot.items.TalendSqlTemplateItem;
import org.talend.swtbot.items.TalendSurvivorshipRulesItem;
import org.talend.swtbot.items.TalendValidationRuleItem;
import org.talend.swtbot.items.TalendWebServiceItem;
import org.talend.swtbot.items.TalendXmlFileItem;

/**
 * DOC sgandon class global comment. Detailled comment <br/>
 * 
 * $Id: talend.epf 1 2006-09-29 17:06:40Z nrousseau $
 * 
 */
public class Utilities {

    /**
     * Define a enum for build type
     */
    public enum BuildType {
        TIS,
        TOSDI,
        TOSBD
    }

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

    public static TalendItem getInstanceOfType(TalendItemType itemType) {
        switch (itemType) {
        case BUSINESS_MODEL:
            return new TalendBusinessModelItem();
        case JOB_DESIGNS:
            return new TalendJobItem();
        case SERVICES:
            return null;
        case JOBLET_DESIGNS:
            return new TalendJobletItem();
        case CONTEXTS:
            return new TalendContextItem();
        case ROUTINES:
            return new TalendRoutineItem();
        case JOBSCRIPTS:
            return new TalendJobScriptItem();
        case SQL_TEMPLATES:
            return new TalendSqlTemplateItem();
        case DB_CONNECTIONS:
            return new TalendDBItem();
        case SAP_CONNECTIONS:
            return new TalendSapItem();
        case FILE_DELIMITED:
            return new TalendDelimitedFileItem();
        case FILE_POSITIONAL:
            return new TalendPositionalFileItem();
        case FILE_REGEX:
            return new TalendRegexFileItem();
        case FILE_XML:
            return new TalendXmlFileItem();
        case FILE_EXCEL:
            return new TalendExcelFileItem();
        case FILE_LDIF:
            return new TalendLdifFileItem();
        case LDAP:
            return new TalendLdapItem();
        case SALESFORCE:
            return new TalendSalesforceItem();
        case GENERIC_SCHEMAS:
            return new TalendGenericSchemaItem();
        case TALEND_MDM:
            return new TalendMdmItem();
        case SURVIVORSHIP_RULES:
            return new TalendSurvivorshipRulesItem();
        case BRMS:
            return new TalendBrmsItem();
        case EMBEDDED_RULES:
            return new TalendEmbeddedRulesItem();
        case COPYBOOK:
            return new TalendCopybookItem();
        case WEB_SERVICE:
            return new TalendWebServiceItem();
        case VALIDATION_RULES:
            return new TalendValidationRuleItem();
        case FTP:
            return new TalendFtpItem();
        case HL7:
            return new TalendHL7Item();
        case EDI:
            return new TalendEdiItem();
        case DOCUMENTATION:
            return new TalendDocumentationItem();
        case RECYCLE_BIN:
            return new TalendRecycleBinItem();
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
        List<TalendItemType> itemTypes = new ArrayList<TalendItemType>();
        if (BuildType.TIS == TalendSwtBotForTos.getBuildType())
            itemTypes = getTISItemTypes();
        if (BuildType.TOSDI == TalendSwtBotForTos.getBuildType())
            itemTypes = getTOSDIItemTypes();
        if (BuildType.TOSBD == TalendSwtBotForTos.getBuildType())
            itemTypes = getTOSBDItemTypes();
        for (TalendItemType itemType : itemTypes) {
            SWTBotTreeItem treeNode = getTalendItemNode(itemType);
            if (TalendItemType.SQL_TEMPLATES.equals(itemType))
                treeNode = treeNode.expandNode("Hive", "UserDefined"); // focus on specific sql template type
            if (TalendItemType.DOCUMENTATION.equals(itemType) || TalendItemType.RECYCLE_BIN.equals(itemType))
                continue; // undo with documentation and recycle bin
            cleanUpRepository(treeNode);
        }
        emptyRecycleBin();
    }

    public static List<TalendItemType> getTISItemTypes() {
        List<TalendItemType> itemList = new ArrayList<TalendItemType>();
        for (TalendItemType itemType : TalendItemType.values())
            itemList.add(itemType);
        return itemList;
    }

    public static List<TalendItemType> getTOSDIItemTypes() {
        List<TalendItemType> itemList = new ArrayList<TalendItemType>();
        itemList.add(TalendItemType.BUSINESS_MODEL);
        itemList.add(TalendItemType.JOB_DESIGNS);
        itemList.add(TalendItemType.ROUTINES);
        itemList.add(TalendItemType.SQL_TEMPLATES);
        itemList.add(TalendItemType.DB_CONNECTIONS);
        itemList.add(TalendItemType.FILE_DELIMITED);
        itemList.add(TalendItemType.FILE_POSITIONAL);
        itemList.add(TalendItemType.FILE_REGEX);
        itemList.add(TalendItemType.FILE_XML);
        itemList.add(TalendItemType.FILE_EXCEL);
        itemList.add(TalendItemType.FILE_LDIF);
        itemList.add(TalendItemType.LDAP);
        itemList.add(TalendItemType.SALESFORCE);
        itemList.add(TalendItemType.GENERIC_SCHEMAS);
        itemList.add(TalendItemType.WEB_SERVICE);
        itemList.add(TalendItemType.FTP);
        itemList.add(TalendItemType.CONTEXTS);
        itemList.add(TalendItemType.DOCUMENTATION);
        itemList.add(TalendItemType.RECYCLE_BIN);
        return itemList;
    }

    public static List<TalendItemType> getTOSBDItemTypes() {
        List<TalendItemType> itemList = new ArrayList<TalendItemType>();
        itemList.add(TalendItemType.JOB_DESIGNS);
        itemList.add(TalendItemType.ROUTINES);
        itemList.add(TalendItemType.SQL_TEMPLATES);
        itemList.add(TalendItemType.CONTEXTS);
        itemList.add(TalendItemType.RECYCLE_BIN);
        return itemList;
    }

    /**
     * DOC fzhong Comment method "cleanUpRepository". Delete all items under the tree node to recycle bin.
     * 
     * @param treeNode treeNode of the tree in repository
     */
    public static void cleanUpRepository(SWTBotTreeItem treeNode) {
        List<String> items = getItemsForNode(treeNode);
        if (items.isEmpty())
            return;
        SWTBotTreeItemExt treeNodeExt = new SWTBotTreeItemExt(treeNode.select(items.toArray(new String[items.size()])));
        int count = 0;
        boolean isDeleted = false;
        do {
            try {
                treeNodeExt.contextMenu("Delete").click();
                count++;
                if (count > 3)
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("ERROR: Could not delete items under tree node '" + treeNode.getText() + "'.");
                e.printStackTrace();
                return;
            }
            if (getItemsForNode(treeNode).isEmpty())
                isDeleted = true;
        } while (!isDeleted);
    }

    private static List<String> getItemsForNode(SWTBotTreeItem treeNode) {
        gefBot.waitUntil(Conditions.widgetIsEnabled(treeNode));
        List<String> items = treeNode.expand().getNodes();
        String exceptItem = "system";
        if (items.contains(exceptItem))
            items.remove(exceptItem);
        return items;
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
        dndPaletteToolOntoEditor(jobEditor, toolLabel, locationOnJob);
        // new JobHelper().activateTool(jobEditor, toolLabel, locationOnJob);
    }

    /**
     * DOC vivian Comment method "dndPaletteToolOntoJoblet". Drag and drop component from palette onto joblet.
     * 
     * @param jobletEditor joblet editor
     * @param toolLabel component label
     * @param locationOnJoblet the specific location on joblet
     */
    public static void dndPaletteToolOntoJoblet(SWTBotGefEditor jobletEditor, String toolLabel, Point locationOnJoblet) {
        dndPaletteToolOntoEditor(jobletEditor, toolLabel, locationOnJoblet);
    }

    /**
     * DOC vivian Comment method "dndPaletteToolOntoEditor".
     * 
     * @param gefEditor
     * @param toolLabel
     * @param point
     */
    public static void dndPaletteToolOntoEditor(SWTBotGefEditor gefEditor, String toolLabel, Point point) {
        gefEditor.activateTool(toolLabel).click(point.x, point.y);
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
     * @param componentType the label of specific component type
     * @param locationOnJob the specific location on job
     */
    public static void dndMetadataOntoJob(SWTBotGefEditor jobEditor, SWTBotTreeItem sourceItem, String componentType,
            Point locationOnJob) {
        SWTBotGefFigureCanvas figureCanvas = new SWTBotGefFigureCanvas((FigureCanvas) gefBot.widget(
                WidgetOfType.widgetOfType(FigureCanvas.class), jobEditor.getWidget()));
        DndUtil dndUtil = new DndUtil(jobEditor.getWidget().getDisplay());

        sourceItem.select();
        jobEditor.setFocus();
        dndUtil.dragAndDrop(sourceItem, figureCanvas, locationOnJob);
        if (componentType != null && !"".equals(componentType)) {
            gefBot.shell("Components").activate();
            gefBot.table(0).getTableItem(componentType).select();
            gefBot.button("OK").click();
            if (componentType.equals("tFileInputPositional"))
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

        TalendSwtBotForTos swtbot = new TalendSwtBotForTos();
        // test drag db2 input component to workspace
        schema.setComponentType(componentType);
        Utilities.dndMetadataOntoJob(jobItem.getEditor(), schema.getItem(), schema.getComponentType(), new Point(100, 100));
        SWTBotGefEditPart gefEditPart = swtbot.getTalendComponentPart(jobItem.getEditor(), schema.getComponentLabel());
        Assert.assertNotNull("cann't get component " + schema.getComponentType() + "", gefEditPart);

        // dataviewer
        dataView(jobItem, gefEditPart, componentType);

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

    public static void dataView(TalendJobItem jobItem, SWTBotGefEditPart gefEditPart, final String componentType) {
        jobItem.getEditor().select(gefEditPart).setFocus();
        gefEditPart.click();
        jobItem.getEditor().clickContextMenu("Data viewer");

        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                String shellTitle = gefBot.activeShell().getText();
                return !shellTitle.contains(TalendSwtBotForTos.getBuildTitle()) && !shellTitle.contains("Progress Information");
            }

            public String getFailureMessage() {
                return "the shell of data preview did not activate";
            }
        }, 60000);
        String shellTitle = gefBot.activeShell().getText();
        if ("Progress Information".equals(shellTitle))
            gefBot.button("Cancel").click();
        else if (("Data Preview: " + componentType + "_1").equals(shellTitle))
            gefBot.activeShell().activate();
        else {
            gefBot.activeShell().close();
            Assert.fail("the shell 'Data Preview: " + componentType + "_1' did not activate, but shell '" + shellTitle
                    + "' activate");
        }
    }

    /**
     * data viewer on SCD Component
     * 
     * @param jobItem the job Item
     * @param componentType the type of component
     * @param dbName the name of db
     * @param gefEditPart
     */
    public static void dataViewOnSCDComponent(TalendJobItem jobItem, String componentType, String dbName,
            SWTBotGefEditPart gefEditPart) {
        String sql = "create table dataviwer(age int, name varchar(12));\n " + "insert into dataviwer values(1, 'a');\n";

        // create table
        createTable(sql, jobItem, componentType);

        // select table
        selectTable(componentType, dbName);

        // edit schema
        gefBot.button(4).click();
        editSchema(componentType);

        dataView(jobItem, gefEditPart, componentType);

        String result1 = gefBot.tree().cell(0, 1);
        String result2 = gefBot.tree().cell(0, 2);
        Assert.assertEquals("the result is not the expected result", "1a", result1 + result2);
        gefBot.button("Close").click();

        // Drop table
        dropTable(sql, gefEditPart, jobItem, componentType);
    }

    private static void dropTable(String sql, SWTBotGefEditPart gefEditPart, TalendJobItem jobItem, String componentType) {
        sql = "drop table dataviwer;";
        gefEditPart.click();
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
        try {
            gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Open SQLBuilder Dialog")), 60000);
        } catch (WidgetNotFoundException wnfe) {
            // pass exception if shell not found
        } catch (TimeoutException e) {
            gefBot.button("Cancel").click();
            gefBot.button("Run in Background").click();
            Assert.fail(e.getMessage());
        }
        gefBot.waitUntil(Conditions.shellIsActive("SQL Builder [Component Mode] - Job:" + jobItem.getItemName() + " - Component:"
                + componentType + "_1"));
        SWTBotShell shell = gefBot.shell(
                "SQL Builder [Component Mode] - Job:" + jobItem.getItemName() + " - Component:" + componentType + "_1")
                .activate();

        gefBot.styledText().setText(sql);
        gefBot.toolbarButtonWithTooltip("Execute SQL (Ctrl+Enter)").click();

        // if table has exist,drop the table ,then create table gain
        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        SWTBotPreferences.TIMEOUT = 100;
        try {
            gefBot.waitUntil(Conditions.shellIsActive("Error Executing SQL"));
            String errorLog = gefBot.label(1).getText();
            if (errorLog.contains("name") && errorLog.contains("existing object") || errorLog.contains("dataviwer")
                    || errorLog.contains("already exists")) {
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
            gefBot.waitUntil(Conditions.shellCloses(shell));
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
        gefBot.waitUntil(Conditions.shellCloses(gefBot.shell("Progress Information")), 60000);
    }

    public static List<ERepositoryObjectType> getERepositoryObjectTypes() {
        List<ERepositoryObjectType> list = new ArrayList<ERepositoryObjectType>();
        list.add(ERepositoryObjectType.BUSINESS_PROCESS);
        list.add(ERepositoryObjectType.PROCESS);
        list.add(ERepositoryObjectType.SERVICESOPERATION);
        list.add(ERepositoryObjectType.JOBLET);
        list.add(ERepositoryObjectType.CONTEXT);
        list.add(ERepositoryObjectType.ROUTINES);
        list.add(ERepositoryObjectType.JOB_SCRIPT);
        list.add(ERepositoryObjectType.SQLPATTERNS);
        list.add(ERepositoryObjectType.METADATA_CONNECTIONS);
        list.add(ERepositoryObjectType.METADATA_SAPCONNECTIONS);
        list.add(ERepositoryObjectType.METADATA_FILE_DELIMITED);
        list.add(ERepositoryObjectType.METADATA_FILE_POSITIONAL);
        list.add(ERepositoryObjectType.METADATA_FILE_REGEXP);
        list.add(ERepositoryObjectType.METADATA_FILE_XML);
        list.add(ERepositoryObjectType.METADATA_FILE_EXCEL);
        list.add(ERepositoryObjectType.METADATA_FILE_LDIF);
        list.add(ERepositoryObjectType.METADATA_LDAP_SCHEMA);
        list.add(ERepositoryObjectType.METADATA_SALESFORCE_SCHEMA);
        list.add(ERepositoryObjectType.METADATA_GENERIC_SCHEMA);
        list.add(ERepositoryObjectType.METADATA_MDMCONNECTION);
        list.add(ERepositoryObjectType.METADATA_FILE_RULES);
        list.add(ERepositoryObjectType.METADATA_FILE_EBCDIC);
        list.add(ERepositoryObjectType.METADATA_WSDL_SCHEMA);
        list.add(ERepositoryObjectType.METADATA_VALIDATION_RULES);
        list.add(ERepositoryObjectType.METADATA_FILE_FTP);
        list.add(ERepositoryObjectType.METADATA_FILE_HL7);
        list.add(ERepositoryObjectType.METADATA_EDIFACT);
        list.add(ERepositoryObjectType.DOCUMENTATION);
        list.add(ERepositoryObjectType.RECYCLE_BIN);
        return list;
    }

    public static SWTBotGefEditPart useTJavaAndSetText(SWTBotGefEditor gefEditor, String text) {
        TalendSwtBotForTos tos = new TalendSwtBotForTos();
        gefEditor.show();
        Utilities.dndPaletteToolOntoEditor(gefEditor, "tJava", new Point(100, 100));
        SWTBotGefEditPart tJava_1 = tos.getTalendComponentPart(gefEditor, "tJava_1");
        Assert.assertNotNull("cann't get tJava", tJava_1);
        tJava_1.click();
        gefBot.viewByTitle("Component").setFocus();
        SWTBotPreferences.KEYBOARD_LAYOUT = "EN_US";
        gefBot.sleep(1000);
        gefBot.styledText().selectCurrentLine();
        gefBot.styledText().typeText(text);
        return tJava_1;
    }

}
