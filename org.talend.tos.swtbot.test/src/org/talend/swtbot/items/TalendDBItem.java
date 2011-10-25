package org.talend.swtbot.items;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Assert;
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
        SWTBotTreeItem schemaNode = item.expand().expandNode("Table schemas");
        TalendSchemaItem schemaItem = new TalendSchemaItem();
        schemaItem.setItem(schemaNode.getNode(name));
        schemaItem.setParentNode(schemaNode);
        schemaItem.setItemName("\"" + schemaItem.getItemName() + "\"");
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
        if (System.getProperty(db + ".password") != null && !"".equals(System.getProperty(db + ".password")))
            gefBot.textWithLabel("Password").setText(System.getProperty(db + ".password"));
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

    public void executeSQL(String sql) {
        SWTGefBot gefBot = new SWTGefBot();
        SWTBotShell shell = null;
        long defaultTimeout = SWTBotPreferences.TIMEOUT;
        SWTBotPreferences.TIMEOUT = 100;
        if (sql != null) {
            try {
                item.contextMenu("Edit queries").click();
                try {
                    if (gefBot.shell("Choose context").isActive())
                        gefBot.button("OK").click();
                } catch (WidgetNotFoundException wnfe) {
                    // ignor this, means it's not context mode, did not pop up context confirm dialog
                }
                shell = gefBot.shell("SQL Builder [Repository Mode]").activate();
                gefBot.styledText(0).setText(sql);
                gefBot.toolbarButtonWithTooltip("Execute SQL (Ctrl+Enter)").click();

                try {
                    if (gefBot.shell("Error Executing SQL").isActive())
                        gefBot.button("OK").click();
                    Assert.fail("execute sql fail");
                } catch (WidgetNotFoundException wnfe) {
                    // ignor this, means did not pop up error dialog, sql executed successfully.
                }
            } catch (WidgetNotFoundException wnfe) {
                Assert.fail(wnfe.getCause().getMessage());
            } catch (Exception e) {
                Assert.fail(e.getMessage());
            } finally {
                shell.close();
            }
        }
        SWTBotPreferences.TIMEOUT = defaultTimeout;
    }

    public void retrieveDbSchema(String... schemas) {
        SWTGefBot gefBot = new SWTGefBot();
        SWTBotShell tempShell = null;
        try {
            getParentNode().getNode(itemName + " 0.1").contextMenu("Retrieve Schema").click();
            tempShell = gefBot.shell("Schema").activate();
            gefBot.button("Next >").click();
            List<String> schemaList = new ArrayList<String>(Arrays.asList(schemas));

            gefBot.waitUntil(Conditions.waitForWidget(widgetOfType(Tree.class)), 10000);
            SWTBotTree root = gefBot.treeInGroup("Select Schema to create");
            SWTBotTreeItem treeNode = null;
            if (getCatalog() != null && getSchema() == null)
                treeNode = root.expandNode(getCatalog());
            if (getCatalog() == null && getSchema() != null)
                treeNode = root.expandNode(getSchema());
            if (getCatalog() != null && getSchema() != null)
                treeNode = root.expandNode(getCatalog(), getSchema());
            for (String schema : schemaList) {
                treeNode.getNode(convertString(schema)).check();
            }
            gefBot.button("Next >").click();
            gefBot.button("Finish").click();
        } catch (WidgetNotFoundException wnfe) {
            tempShell.close();
            Assert.fail(wnfe.getCause().getMessage());
        } catch (Exception e) {
            tempShell.close();
            Assert.fail(e.getMessage());
        }
    }

    public SWTBotShell editQueries() {
        item.contextMenu("Edit queries").click();
        SWTBotShell shell = new SWTGefBot().shell("SQL Builder [Repository Mode]").activate();
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
        String databaseProp = dbType.toString().toLowerCase();
        databaseProp += ".dataBase";
        return convertString(System.getProperty(databaseProp));
    }

    private String getSchema() {
        String schemaProp = dbType.toString().toLowerCase();
        if (dbType == Utilities.DbConnectionType.TERADATA)
            schemaProp += ".dataBase";
        else
            schemaProp += ".schema";
        return convertString(System.getProperty(schemaProp));
    }

    @Override
    public SWTBotShell beginEditWizard() {
        return beginEditWizard("Edit connection", "Database Connection");
    }
}
