package org.talend.swtbot.items;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.talend.swtbot.Utilities;
import org.talend.swtbot.Utilities.DbConnectionType;

public class TalendDBItem extends TalendMetadataItem {

    private DbConnectionType dbType;

    public TalendDBItem() {
        super(Utilities.TalendItemType.DB_CONNECTIONS);
    }

    public TalendDBItem(String itemName, DbConnectionType dbType) {
        super(itemName, Utilities.TalendItemType.DB_CONNECTIONS);
        this.dbType = dbType;
    }

    public DbConnectionType getDbType() {
        return dbType;
    }

    public void setDbType(DbConnectionType dbType) {
        this.dbType = dbType;
    }

    public TalendSchemaItem getSchema(String name) {
        name = convertString(name);
        SWTBotTreeItem schemaNode = getItem().expand().expandNode("Table schemas");
        SWTBotTreeItem schema = null;
        try {
            schema = schemaNode.getNode(name);
        } catch (WidgetNotFoundException e) {
            return null;
        }
        TalendSchemaItem schemaItem = new TalendSchemaItem(this.getItemType());
        schemaItem.setItem(schema);
        schemaItem.setParentNode(schemaNode);
        return schemaItem;
    }

    @Override
    public void create() {
        final SWTBotShell shell = beginCreationWizard("Create connection", "Database Connection");
        String dbSelect = null;
        String dbProperty = null;
        switch (dbType) {
        case MYSQL:
            dbSelect = "MySQL";
            dbProperty = "mysql";
            break;
        case POSTGRESQL:
            dbSelect = "PostgreSQL";
            dbProperty = "postgresql";
            break;
        case MSSQL:
            dbSelect = "Microsoft SQL Server";
            dbProperty = "mssql";
            break;
        case ORACLE:
            dbSelect = "Oracle with SID";
            dbProperty = "oracle";
            break;
        case AS400:
            dbSelect = "AS400";
            dbProperty = "as400";
            break;
        case SYBASE:
            dbSelect = "Sybase (ASE and IQ)";
            dbProperty = "sybase";
            break;
        case JDBC_MYSQL:
            dbSelect = "General JDBC";
            dbProperty = "jdbc.mysql";
            break;
        case DB2:
            dbSelect = "IBM DB2";
            dbProperty = "db2";
            break;
        case INFORMIX:
            dbSelect = "Informix";
            dbProperty = "informix";
            break;
        case ORACLE_OCI:
            dbSelect = "Oracle OCI";
            dbProperty = "oracle.oci";
            break;
        case TERADATA:
            dbSelect = "Teradata";
            dbProperty = "teradata";
            break;
        case VERTICA:
            dbSelect = "Vertica";
            dbProperty = "vertica";
            break;
        default:
            break;
        }

        try {
            setConnectionInfo(dbSelect, dbProperty);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }

        gefBot.button("Check").click();
        gefBot.waitUntil(new DefaultCondition() {

            public boolean test() throws Exception {
                return gefBot.shell("Check Connection ").isActive();
            }

            public String getFailureMessage() {
                shell.close();
                return "connection failure";
            }
        });

        if (gefBot.label(1).getText().equals("\"" + itemName + "\" connection successful.")) {
            gefBot.button("OK").click();
        }
        finishCreationWizard(shell);
    }

    /**
     * Set connection's informations
     * 
     * @param dbType db type for widget selection
     * @param db the prefix of properties about db connection
     * 
     * @throws URISyntaxException
     * @throws IOException
     */
    private void setConnectionInfo(String dbType, String db) throws IOException, URISyntaxException {
        gefBot.comboBoxWithLabel("DB Type").setSelection(dbType);
        if (System.getProperty(db + ".dbVersion") != null && !"".equals(System.getProperty(db + ".dbVersion")))
            gefBot.comboBoxWithLabel("Db Version").setSelection(System.getProperty(db + ".dbVersion"));
        if (System.getProperty(db + ".login") != null && !"".equals(System.getProperty(db + ".login")))
            gefBot.textWithLabel("Login").setText(System.getProperty(db + ".login"));
        if (System.getProperty(db + ".password") != null && !"".equals(System.getProperty(db + ".password"))) {
            if ("jdbc.mysql".equals(db))
                gefBot.text(7).setText(System.getProperty(db + ".password"));
            else
                gefBot.textWithLabel("Password").setText(System.getProperty(db + ".password"));
        }
        if (System.getProperty(db + ".server") != null && !"".equals(System.getProperty(db + ".server")))
            gefBot.textWithLabel("Server").setText(System.getProperty(db + ".server"));
        if (System.getProperty(db + ".port") != null && !"".equals(System.getProperty(db + ".port")))
            gefBot.textWithLabel("Port").setText(System.getProperty(db + ".port"));
        if (System.getProperty(db + ".dataBase") != null && !"".equals(System.getProperty(db + ".dataBase")))
            gefBot.textWithLabel("DataBase").setText(System.getProperty(db + ".dataBase"));
        if (System.getProperty(db + ".schema") != null && !"".equals(System.getProperty(db + ".schema")))
            gefBot.textWithLabel("Schema").setText(System.getProperty(db + ".schema"));
        if (System.getProperty(db + ".serviceName") != null && !"".equals(System.getProperty(db + ".serviceName")))
            gefBot.textWithLabel("Local service name").setText(System.getProperty(db + ".serviceName"));
        if (System.getProperty(db + ".instance") != null && !"".equals(System.getProperty(db + ".instance")))
            gefBot.textWithLabel("Instance").setText(System.getProperty(db + ".instance"));
        if (System.getProperty(db + ".url") != null && !"".equals(System.getProperty(db + ".url")))
            gefBot.textWithLabel("JDBC URL").setText(System.getProperty(db + ".url"));
        if (System.getProperty(db + ".driver") != null && !"".equals(System.getProperty(db + ".driver")))
            gefBot.textWithLabel("Driver jar").setText(
                    Utilities.getFileFromCurrentPluginSampleFolder(System.getProperty(db + ".driver")).getAbsolutePath());
        if (System.getProperty(db + ".className") != null && !"".equals(System.getProperty(db + ".className")))
            gefBot.comboBoxWithLabel("Class name").setText(System.getProperty(db + ".className"));
        if (System.getProperty(db + ".userName") != null && !"".equals(System.getProperty(db + ".userName")))
            gefBot.textWithLabel("User name ").setText(System.getProperty(db + ".userName"));
        if (System.getProperty(db + ".sid") != null && !"".equals(System.getProperty(db + ".sid")))
            gefBot.textWithLabel("Sid").setText(System.getProperty(db + ".sid"));
        if (System.getProperty(db + ".additionalParameters") != null
                && !"".equals(System.getProperty(db + ".additionalParameters")))
            gefBot.textWithLabel("Additional parameters").setText(System.getProperty(db + ".additionalParameters"));
    }

    public boolean executeSQL(String sql) {
        if (sql == null || "".equals(sql)) {
            log.warn("sql is null");
            return false;
        }
        if (item == null) {
            log.warn("item is null");
            return false;
        }

        SWTBotShell shell = null;
        getItem().contextMenu("Edit queries").click();

        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        SWTBotPreferences.TIMEOUT = 100;
        try {
            if (gefBot.shell("Choose context").isActive())
                gefBot.button("OK").click();
        } catch (WidgetNotFoundException wnfe) {
            // ignor this, means it's not context mode, did not pop up context confirm dialog
        } finally {
            SWTBotPreferences.TIMEOUT = defaultTimeout;
        }
        shell = gefBot.shell("SQL Builder [Repository Mode]").activate();

        String[] sqls = sql.split(";");
        for (String str : sqls) {
            str = str.trim();
            if ("".equals(str))
                continue;
            gefBot.styledText(0).setText(str);
            gefBot.toolbarButtonWithTooltip("Execute SQL (Ctrl+Enter)").click();

            SWTBotPreferences.TIMEOUT = 1000;
            try {
                gefBot.waitUntil(Conditions.shellIsActive("Error Executing SQL"));
                gefBot.shell("Error Executing SQL").activate();
                String errorLog = gefBot.label(1).getText();
                if ((errorLog.contains("Table") && errorLog.contains("already exists"))
                        || errorLog.contains("There is already an object")) {
                    String table = errorLog.split("'")[1];
                    str = "drop table " + table + ";\n" + str;
                }
                if (errorLog.contains("database exists")) {
                    String database = errorLog.split("'")[2];
                    str = "drop database " + database + ";\n" + str;
                }

                if (errorLog.contains("Unknown table") && errorLog.contains("database doesn't exist")) {
                    gefBot.button("OK").click();
                } else {
                    gefBot.button("OK").click();
                    shell.activate();
                    gefBot.styledText(0).setText(str);
                    gefBot.toolbarButtonWithTooltip("Execute SQL (Ctrl+Enter)").click();
                }
            } catch (TimeoutException e) {
                // ignor this, means execute sql successfully, did not pop up error dialog
            } finally {
                SWTBotPreferences.TIMEOUT = defaultTimeout;
            }
        }
        shell.close();
        return true;
    }

    public void retrieveDbSchema(String... schemas) {
        getItem().contextMenu("Retrieve Schema").click();
        gefBot.waitUntil(Conditions.shellIsActive("Schema"), 5000);
        gefBot.shell("Schema").activate();
        gefBot.button("Next >").click();
        List<String> schemaList = new ArrayList<String>(Arrays.asList(schemas));

        gefBot.waitUntil(Conditions.waitForWidget(widgetOfType(Tree.class)), 50000);
        SWTBotTree root = gefBot.treeInGroup("Select Schema to create");
        SWTBotTreeItem treeNode = null;
        if (getCatalog() != null && getSchema() == null)
            treeNode = root.expandNode(getCatalog());
        if (getCatalog() == null && getSchema() != null)
            treeNode = root.expandNode(getSchema());
        if (getCatalog() != null && getSchema() != null)
            treeNode = root.expandNode(getCatalog(), getSchema());
        int checkedCount = 0;
        for (String schema : schemaList) {
            try {
                treeNode.getNode(convertString(schema)).check();
                checkedCount++;
            } catch (WidgetNotFoundException e) {
                log.warn("Could not find schema '" + schema + "'");
            }
        }
        if (checkedCount == 0)
            gefBot.button("Cancel").click();
        else {
            gefBot.waitUntil(Conditions.widgetIsEnabled(gefBot.button("Next >")), 30000);
            gefBot.button("Next >").click();
            gefBot.button("Finish").click();
        }
    }

    public SWTBotShell editQueries() {
        item.contextMenu("Edit queries").click();
        SWTBotShell shell = gefBot.shell("SQL Builder [Repository Mode]").activate();
        return shell;
    }

    /**
     * Some DB schema name and table name should be uppercase, so need to convert.
     * 
     * @param str
     * @return converted string
     */
    private String convertString(String str) {
        if (str == null)
            return null;
        switch (dbType) {
        case DB2:
        case ORACLE:
            return str.toUpperCase();
        default:
            return str;
        }
    }

    private String getCatalog() {
        if (dbType == Utilities.DbConnectionType.TERADATA || dbType == Utilities.DbConnectionType.DB2)
            return null;
        if (dbType == Utilities.DbConnectionType.AS400)
            return "S6581FBD";
        String databaseProp = dbType.toString().toLowerCase();
        databaseProp += ".dataBase";
        return convertString(System.getProperty(databaseProp));
    }

    private String getSchema() {
        String schemaProp = dbType.toString().toLowerCase();
        if (dbType == Utilities.DbConnectionType.TERADATA || dbType == Utilities.DbConnectionType.AS400)
            schemaProp += ".dataBase";
        else
            schemaProp += ".schema";
        return convertString(System.getProperty(schemaProp));
    }

    @Override
    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit connection", "Database Connection");
    }

    private boolean cdcWizard(TalendDBItem linkConnection) {
        boolean isSubscriberCreated = false;
        gefBot.shell("Create Change Data Capture").activate();
        gefBot.button("...").click();
        gefBot.shell("Repository Content").activate();
        gefBot.tree().expandNode("Db Connections").select(linkConnection.getItemFullName());
        gefBot.button("OK").click();
        gefBot.button("Create Subscriber").click();
        gefBot.shell("Create Subscriber and Execute SQL Script").activate();
        gefBot.button("Execute").click();
        gefBot.shell("Execute SQL Statement").activate();
        if ("Table 'tsubscribers' already exists".equals(gefBot.label(1).getText())) {
            isSubscriberCreated = true;
            gefBot.button("Ignore").click();
        }
        gefBot.button("OK").click();
        isSubscriberCreated = true;
        gefBot.button("Close").click();
        gefBot.button("Finish").click();
        return isSubscriberCreated;
    }

    public boolean createCDCWith(TalendDBItem linkConnection) {
        getItem().expand().getNode("CDC Foundation").contextMenu("Create CDC").click();
        return cdcWizard(linkConnection);
    }

    public boolean editCDCWith(TalendDBItem linkConnection) {
        boolean isNewSubscriberCreated = false;
        boolean isOldSubscriberDeleted = false;
        getCDCFoundation().contextMenu("Edit CDC").click();
        isNewSubscriberCreated = cdcWizard(linkConnection);
        gefBot.shell("CDC changed").activate();
        gefBot.button("Yes").click();
        gefBot.shell("Execute SQL Statement").activate();
        gefBot.button("OK").click();
        isOldSubscriberDeleted = true;
        return (isNewSubscriberCreated && isOldSubscriberDeleted);
    }

    public boolean deleteCDC() {
        boolean isSubscriberDeleted = false;
        if (getCDCFoundation() == null)
            return isSubscriberDeleted;
        getCDCFoundation().contextMenu("Delete CDC").click();
        gefBot.shell("Create Subscriber and Execute SQL Script").activate();
        gefBot.button("Execute").click();
        gefBot.shell("Execute SQL Statement").activate();
        gefBot.button("OK").click();
        isSubscriberDeleted = true;
        gefBot.button("Close").click();
        return isSubscriberDeleted;
    }

    /**
     * Add CDC for schema with the default subscriber name 'APP1' and the default events to catch (Insert, Update,
     * Delete).
     * 
     * @param schemaName the schema name which need to add CDC
     * @return
     */
    public boolean addCDCFor(String schemaName) {
        return addCDCFor(schemaName, null, true, true, true);
    }

    /**
     * Add CDC for schema with the default events to catch (Insert, Update, Delete).
     * 
     * @param schemaName the schema name which need to add CDC
     * @param subscriberName the subscriber name
     * @return
     */
    public boolean addCDCFor(String schemaName, String subscriberName) {
        return addCDCFor(schemaName, subscriberName, true, true, true);
    }

    /**
     * Add CDC for schema with the default subscriber name 'APP1'.
     * 
     * @param schemaName the schema name which need to add CDC
     * @param catchInsert to catch insert event
     * @param catchUpdate to catch update event
     * @param catchDelete to catch delete event
     * @return
     */
    public boolean addCDCFor(String schemaName, boolean catchInsert, boolean catchUpdate, boolean catchDelete) {
        return addCDCFor(schemaName, null, catchInsert, catchUpdate, catchDelete);
    }

    /**
     * Add CDC for schema.
     * 
     * @param schemaName the schema name which need to add CDC
     * @param subscriberName the subscriber name
     * @param catchInsert to catch insert event
     * @param catchUpdate to catch update event
     * @param catchDelete to catch delete event
     * @return
     */
    public boolean addCDCFor(String schemaName, String subscriberName, boolean catchInsert, boolean catchUpdate,
            boolean catchDelete) {
        boolean isAddOK = false;
        getSchema(schemaName).getItem().contextMenu("add CDC").click();
        gefBot.shell("Create Subscriber and Execute SQL Script").activate();
        if (subscriberName != null)
            gefBot.textWithLabel("Subscriber Name:").setText(subscriberName);
        if (!catchInsert)
            gefBot.checkBox("Insert").deselect();
        if (!catchUpdate)
            gefBot.checkBox("Update").deselect();
        if (!catchDelete)
            gefBot.checkBox("Delete").deselect();
        gefBot.button("Execute").click();
        boolean ifexists = true; // the created table had exits
        while (ifexists) {
            gefBot.shell("Execute SQL Statement").activate();
            String statement = gefBot.label(1).getText();
            if (statement.contains("sucessfully")) {
                ifexists = false;
            } else {
                gefBot.button("Ignore").click();
            }
        }
        gefBot.button("OK").click();
        isAddOK = true;
        gefBot.button("Close").click();
        return isAddOK;
    }

    public SWTBotTreeItem getCDCFoundation() {
        try {
            return getItem().expandNode("CDC Foundation").getNode(0);
        } catch (Exception e) {
            log.error("exception for getting CDC foundation", e);
            return null;
        }
    }

    /**
     * View all changes for schema.
     * 
     * @param schemaName the name of the schema
     * @return a shell named 'View All Changes' to view all changes
     */
    public SWTBotShell viewAllChangesFor(String schemaName) {
        getSchema(schemaName).getItem().contextMenu("View All Changes").click();
        gefBot.waitUntil(Conditions.shellIsActive("View All Changes"), 20000);
        return gefBot.shell("View All Changes").activate();
    }

    public void addSubscribersFor(String schemaName, String... subscribers) {
        getSchema(schemaName).getItem().contextMenu("Edit CDC Subscribers").click();
        gefBot.shell("Edit CDC").activate();
        for (String subscriber : subscribers) {
            gefBot.button("Add").click();
            gefBot.shell("Input subscriber name").activate();
            gefBot.text().setText(subscriber);
            if (!gefBot.button("OK").isEnabled()) {
                gefBot.button("Cancel").click();
                log.warn("the subscriber name '" + subscriber + "' already exist");
                continue;
            }
            gefBot.button("OK").click();
            gefBot.shell("Create Subscriber and Execute SQL Script").activate();
            gefBot.button("Execute").click();
            gefBot.shell("Execute SQL Statement").activate();
            gefBot.button("OK").click();
            gefBot.button("Close").click();
        }
        gefBot.button("OK").click();
    }

    public void deleteSubscribersFor(String schemaName, String... subscribers) {
        getSchema(schemaName).getItem().contextMenu("Edit CDC Subscribers").click();
        gefBot.shell("Edit CDC").activate();
        gefBot.list().select(subscribers);
        gefBot.button("Delete").click();
        gefBot.shell("Create Subscriber and Execute SQL Script").activate();
        gefBot.button("Execute").click();
        gefBot.shell("Execute SQL Statement").activate();
        gefBot.button("OK").click();
        gefBot.button("Close").click();
        gefBot.button("OK").click();
    }

    public void deactivateCDCFor(String schemaName) {
        getSchema(schemaName).getItem().contextMenu("Deactivate CDC").click();
        gefBot.shell("Create Subscriber and Execute SQL Script").activate();
        gefBot.button("Execute").click();
        gefBot.shell("Execute SQL Statement").activate();
        gefBot.button("OK").click();
        gefBot.button("Close").click();
    }

}
