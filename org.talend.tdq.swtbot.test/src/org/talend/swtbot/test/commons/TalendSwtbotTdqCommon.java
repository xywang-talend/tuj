package org.talend.swtbot.test.commons;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.forms.finder.finders.SWTFormsBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTableItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.hamcrest.Matcher;
import org.junit.Assert;

import static org.eclipse.swtbot.swt.finder.matchers.WithText.withText;
import static org.eclipse.swtbot.swt.finder.matchers.AllOf.allOf;
/**
 * 
 * @author xwang
 * 
 */
public class TalendSwtbotTdqCommon {

	public static int TREEITEM_FOUND_TIME = 0;

	public enum TalendItemTypeEnum {
		METADATA, ANALYSIS, REPORT, FILE_DELIMITED, MDM, LIBRARY_DQRULE;
	}

	public enum TalendMetadataTypeEnum {
		MYSQL, POSTGRESQL, MSSQL, ORACLE, SQLITE, AS400, SYBASE, MYSQLODBC, MYSQLJDBC, MSACCESSODBC;
	}

	public enum TalendAnalysisTypeEnum {
		CONNECTION, CATALOG, SCHEMA, DQRULE, FUNCTIONAL, COLUMNSET, COLUMN, REDUNDANCY, NUMERICAL_CORRELATION, TIME_CORRELATION, NOMINAL_CORRELATION;
	}

	public enum TalendReportTemplate {
		Basic, Evolution, User_defined
	}

	public enum TalendReportDBType {
		HSQL, MySQL, Oracle_with_SID
	}

	public enum TalendIndicatorLanguage {
		PostgreSQL(0), MySQL(1), Default(2), Ingres(3), Teradata(4), Adaptive_Server_Enterprise_1_Sybase_Adaptive_Server_IQ(
				5), Microsoft_SQL_Server(6), AS_400(7), Informix(8), Java(9), Oracle(
				10), Access(11), DB2(12);
		private final int value;

		public int getValue() {
			return value;
		}

		TalendIndicatorLanguage(int value) {
			this.value = value;
		}
	}

	private static SWTBotTree tree;

	private static SWTBotShell shell;

	public static void createConnection(SWTWorkbenchBot bot,
			TalendMetadataTypeEnum metadataType) {
		TREEITEM_FOUND_TIME += 1;
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Metadata").select("DB connections");
		try {
			ContextMenuHelper.clickContextMenu(tree, "Create DB Connection");
			bot.waitUntil(Conditions.shellIsActive("Database Connection"));
			shell = bot.shell("Database Connection");
		} catch (Exception e1) {
			if (TREEITEM_FOUND_TIME >= 20) {
				TREEITEM_FOUND_TIME = 0;
				return;
			}
			createConnection(bot, metadataType);
		}

		try {
			switch (metadataType) {
			case MYSQL:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MYSQL.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("MySQL");
				setConnectionInfo(bot, System.getProperty("mysql.login"),
						System.getProperty("mysql.password"),
						System.getProperty("mysql.hostname"),
						System.getProperty("mysql.port"),
						System.getProperty("mysql.dbname"));
				break;
			case POSTGRESQL:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.POSTGRESQL.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("PostgreSQL");
				setConnectionInfo(bot, System.getProperty("postgre.login"),
						System.getProperty("postgre.password"),
						System.getProperty("postgre.hostname"),
						System.getProperty("postgre.port"),
						System.getProperty("postgre.dbname"));
				break;
			case MSSQL:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MSSQL.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection(
						"Microsoft SQL Server 2005/2008");
				setConnectionInfo(bot, System.getProperty("mssql.login"),
						System.getProperty("mssql.password"),
						System.getProperty("mssql.hostname"),
						System.getProperty("mssql.port"),
						System.getProperty("mssql.dbname"));
				break;
			case ORACLE:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.ORACLE.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type")
						.setSelection("Oracle with SID");
				bot.textWithLabel("Login").setText(
						System.getProperty("oracle.login"));
				bot.textWithLabel("Password").setText(
						System.getProperty("oracle.password"));
				bot.textWithLabel("Server").setText(
						System.getProperty("oracle.hostname"));
				bot.textWithLabel("Port").setText(
						System.getProperty("oracle.port"));
				bot.textWithLabel("Sid").setText(
						System.getProperty("oracle.sid"));
				break;
			case SQLITE:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.SQLITE.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("SQLite");
				bot.textWithLabel("File").setText(
						System.getProperty("sqlite.path"));
				break;
			case AS400:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.AS400.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("AS400");
				setConnectionInfo(bot, System.getProperty("as400.login"),
						System.getProperty("as400.password"),
						System.getProperty("as400.hostname"), null,
						System.getProperty("as400.dbname"));
				break;
			case SYBASE:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.SYBASE.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection(
						"Sybase (ASE and IQ)");
				setConnectionInfo(bot, System.getProperty("sybase.login"),
						System.getProperty("sybase.password"),
						System.getProperty("sybase.hostname"),
						System.getProperty("sybase.port"),
						System.getProperty("sybase.dbname"));
				break;
			case MYSQLODBC:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MYSQLODBC.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("Generic ODBC");
				bot.textWithLabel("Login").setText(
						System.getProperty("mysql.login"));
				bot.textWithLabel("Password").setText(
						System.getProperty("mysql.password"));
				bot.textWithLabel("DataSource").setText(
						System.getProperty("mysqlodbc.source"));
				break;
			case MYSQLJDBC:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MYSQLJDBC.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("General JDBC");
				bot.textWithLabel("JDBC URL").setText(
						System.getProperty("mysqljdbc.url"));
				bot.textWithLabel("Driver jar").setText(
						System.getProperty("mysqljdbc.driverpath"));
				bot.buttonWithTooltip("Select class name").click();
				bot.textWithLabel("User name ").setText(
						System.getProperty("mysqljdbc.login"));
				bot.textWithLabel("Password").setText(
						System.getProperty("mysqljdbc.password"));
				break;
			case MSACCESSODBC:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MSACCESSODBC.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("Generic ODBC");
				bot.textWithLabel("Login").setText(
						System.getProperty("mysql.login"));
				bot.textWithLabel("Password").setText(
						System.getProperty("mysql.password"));
				bot.textWithLabel("DataSource").setText(
						System.getProperty("mysqlodbc.source"));
				break;
			}
			bot.button("Check").click();
			bot.waitUntil(Conditions.shellIsActive("Check Connection "));
			if (bot.label(1)
					.getText()
					.equals("\"" + metadataType.toString()
							+ "\" connection successful."))
				bot.button("OK").click();
			bot.button("Finish").click();
		} catch (Exception e) {
			System.out.println("Create Connection failed! ");
			shell.close();
			return;
		}
		bot.waitUntil(Conditions.shellCloses(shell), 10000);
		TREEITEM_FOUND_TIME = 0;
	}

	private static void setConnectionInfo(SWTWorkbenchBot bot, String login,
			String password, String hostname, String port, String dbname) {
		if (login != null)
			bot.textWithLabel("Login").setText(login);
		if (password != null)
			bot.textWithLabel("Password").setText(password);
		if (hostname != null)
			bot.textWithLabel("Server").setText(hostname);
		if (port != null)
			bot.textWithLabel("Port").setText(port);
		if (dbname != null)
			bot.textWithLabel("DataBase").setText(dbname);
	}

	public static void createFileDelimitedConnection(SWTWorkbenchBot bot,
			String fileName) {
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Metadata").select("FileDelimited connections");
		ContextMenuHelper.clickContextMenu(tree,
				"Create File Delimited Connection");
		bot.waitUntil(Conditions.shellIsActive("New Delimited File"));
		try {
			shell = bot.shell("New Delimited File");
			bot.textWithLabel("Name").setText(fileName);
			bot.button("Next >").click();
			bot.textWithLabel("File").setText(
					System.getProperty("delimitedFile.Path"));
			bot.button("Next >").click();
			bot.button("Next >").click();
			bot.button("Finish").click();
		} catch (Exception e) {
			shell.close();
			return;
		}
		SWTBotTreeItem newCsvItem = tree
				.expandNode("Metadata", "FileDelimited connections").select(fileName);
		Assert.assertNotNull(newCsvItem);
	}

	public static void createMDMConnection(SWTWorkbenchBot bot,
			String connectionName) {
		bot.sleep(3000);
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Metadata").select("MDM connections");
		ContextMenuHelper.clickContextMenu(tree, "Create MDM Connection");
		try {
			bot.textWithLabel("Name").setText(connectionName);
			bot.button("Next >").click();
			bot.textWithLabel("Username").setText(
					System.getProperty("mdm.username"));
			bot.textWithLabel("password").setText(
					System.getProperty("mdm.password"));
			bot.textWithLabel("Server").setText(
					System.getProperty("mdm.server"));
			bot.textWithLabel("Port").setText(System.getProperty("mdm.port"));
			bot.button("Check").click();
			try {
				bot.waitUntil(Conditions.shellIsActive("Success"), 60000);
				if (bot.label(1).getText()
						.equals(connectionName + " connected successfully!")) {
					bot.button("确定").click();
				}
			} catch (Exception e) {
				bot.shell("Success").close();
				}
			/**
			 * 	bot.waitUntil(new DefaultCondition() {
//				
//				@Override
//				public boolean test() throws Exception {
//					
//					return bot.shell("Success ").isActive();
//				}
//				
//				@Override
//				public String getFailureMessage() {
//					// TODO Auto-generated method stub
//					return null;
//				}
//			},600000);
			 */
			bot.button("Next >").click();
			bot.comboBoxWithLabel("Data-model").setSelection("DStar");
			
			bot.button("Finish").click();
		} catch (TimeoutException e) {
			bot.shell("").close();
			return;
		}
		bot.waitUntil(Conditions.shellCloses(shell));
	}

	public static void createAnalysis(SWTWorkbenchBot bot,
			TalendAnalysisTypeEnum analysisType) {
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Data Profiling").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "New Analysis");
		bot.waitUntil(Conditions.shellIsActive("Create New Analysis"));

		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		try {
			switch (analysisType) {
			case DQRULE:
				tree.expandNode("Table Analysis").select(
						"Business Rule Analysis");
				break;
			case FUNCTIONAL:
				tree.expandNode("Table Analysis").select(
						"Functional Dependency");
				break;
			case COLUMNSET:
				tree.expandNode("Table Analysis").select("Column Set Analysis");
				break;
			case COLUMN:
				tree.expandNode("Column Analysis").select("Column Analysis");
				break;
			case REDUNDANCY:
				tree.expandNode("Redundancy Analysis").select(
						"Column Content Comparison");
				break;
			case NUMERICAL_CORRELATION:
				tree.expandNode("Column Correlation Analysis").select(
						"Numerical Correlation Analysis");
				break;
			case TIME_CORRELATION:
				tree.expandNode("Column Correlation Analysis").select(
						"Time Correlation Analysis");
				break;
			case NOMINAL_CORRELATION:
				tree.expandNode("Column Correlation Analysis").select(
						"Nominal Correlation Analysis");
				break;
			}
			bot.button("Next >").click();
			bot.textWithLabel("Name").setText(analysisType.toString());
			bot.sleep(2000);
			bot.button("Finish").click();
		} catch (WidgetNotFoundException e) {
			bot.shell("Create New Analysis").close();
			return;
		}
	}

	public static void createAnalysis(SWTWorkbenchBot bot,
			TalendAnalysisTypeEnum analysisType,
			TalendMetadataTypeEnum metadataType) {
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Data Profiling").getNode(0).select();
		ContextMenuHelper.clickContextMenu(tree, "New Analysis");
		bot.waitUntil(Conditions.shellIsActive("Create New Analysis"));

		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		switch (analysisType) {
		case CONNECTION:
			tree.expandNode("Connection Analysis").select(
					"Database Structure Overview");
			break;
		case CATALOG:
			tree.expandNode("Catalog Analysis").select(
					"Catalog Structure Overview");
			break;
		case SCHEMA:
			tree.expandNode("Schema Analysis").select(
					"Schema Structure Overview");
			break;
		}

		bot.button("Next >").click();
		bot.textWithLabel("Name").setText(analysisType.toString());
		bot.button("Next >").click();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		switch (analysisType) {
		case CONNECTION:
			tree.expandNode("DB connections").select(metadataType.toString());
			break;
		case CATALOG:
			tree.expandNode("DB connections", metadataType.toString())
					.getNode(0).select();
			break;
		case SCHEMA:
			tree.expandNode("DB connections", metadataType.toString())
					.getNode(0).select();
			if (!bot.button("Next >").isEnabled())
				tree.expandNode("DB connections", metadataType.toString())
						.getNode(0).expand().getNode(0).select();
			break;
		}
		bot.button("Next >").click();
		bot.button("Finish").click();
	}

	public static void createReport(SWTWorkbenchBot bot, String label) {
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Data Profiling").getNode(1).select();
		ContextMenuHelper.clickContextMenu(tree, "New Report");
		try {
			bot.textWithLabel("Name").setText(label);
			bot.sleep(2000);
			bot.button("Finish").click();
			bot.sleep(2000);
		} catch (Exception e) {
			bot.shell("").close();
		}
	}

	public static void setReportDB(SWTWorkbenchBot bot,
			TalendReportDBType dbType) {
		bot.sleep(1000);
		try {
			bot.menu("Window").menu("Preferences").click();
		} catch (WidgetNotFoundException e1) {
			System.out.println("could not find Preferences!");
		}
		bot.waitUntil(Conditions.shellIsActive("Preferences"));
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		tree.expandNode("Talend", "Data Profiler").select("Reporting");
		bot.textWithLabel("Default Report Folder:").setText(
				System.getProperty("default.reportpath"));

		String tmp = dbType.toString();
		if (dbType == TalendReportDBType.Oracle_with_SID) {
			tmp = tmp.replace("_", " ");
		}
		bot.comboBoxWithLabel("Db Type").setSelection(tmp);

		switch (dbType) {
		case HSQL:
			
			break;
		case MySQL:
			bot.textWithLabel("Host").setText(
					System.getProperty("reportdb.mysql.host"));
			bot.textWithLabel("Port").setText(
					System.getProperty("reportdb.mysql.port"));
			bot.textWithLabel("Db Name").setText(
					System.getProperty("reportdb.mysql.dbname"));
			bot.textWithLabel("User").setText(
					System.getProperty("reportdb.mysql.user"));
			bot.textWithLabel("Password").setText(
					System.getProperty("reportdb.mysql.password"));
		
			break;
		case Oracle_with_SID:
			bot.textWithLabel("Host").setText(
					System.getProperty("reportdb.oracle.host"));
			bot.textWithLabel("Port").setText(
					System.getProperty("reportdb.oracle.port"));
			bot.textWithLabel("SID").setText(
					System.getProperty("reportdb.oracle.sid"));
			bot.textWithLabel("Schema").setText(
					System.getProperty("reportdb.oracle.schema"));
			bot.textWithLabel("User").setText(
					System.getProperty("reportdb.oracle.user"));
			bot.textWithLabel("Password").setText(
					System.getProperty("reportdb.oracle.password"));
			
			break;
		}
		bot.button("Apply").click();
		bot.sleep(6000);
		try {
			bot.waitUntil(Conditions.shellIsActive("Set database"));
			SWTBotShell shell = bot.shell("Set database");
			bot.button("OK").click();
			bot.waitUntil(Conditions.shellCloses(shell), 60000);
			if(bot.activeShell().getText().equals("Confirm")){
				System.out.println(bot.activeShell().getText()+"::::::::::::::::::");
			bot.waitUntil(Conditions.shellIsActive("Confirm"));
			SWTBotShell shell2 = bot.shell("Confirm");
			bot.button("OK").click();
			bot.waitUntil(Conditions.shellCloses(shell2),60000);
			}
			bot.waitUntil(Conditions.shellIsActive("Warning"));
			SWTBotShell shell1 = bot.shell("Warning");
			bot.button("OK").click();
			bot.waitUntil(Conditions.shellCloses(shell1));
			bot.button("OK").click();
			bot.waitUntil(Conditions.shellIsActive("Set database"));
			bot.button("OK").click();
			bot.waitUntil(Conditions.shellCloses(shell));
			if(bot.activeShell().getText().equals("Confirm")){
			bot.waitUntil(Conditions.shellIsActive("Confirm"));
			SWTBotShell shell2 = bot.shell("Confirm");
			bot.button("OK").click();
			bot.waitUntil(Conditions.shellCloses(shell2));
			}
			bot.waitUntil(Conditions.shellIsActive("Warning"));
			bot.button("OK").click();
			bot.waitUntil(Conditions.shellCloses(shell1));
		} catch (TimeoutException e) {
		}
		// System.out.println("aaaaa");
		// bot.button("Apply").click();
		// System.out.println("bbbbbbbb");
		// bot.sleep(50000);
		// bot.waitUntil(Conditions.shellIsActive("Warning"));
		// System.out.println("accccc");
		// bot.sleep(50000);
		// bot.button("OK").click();
		// System.out.println("dddddddddd");
		// bot.textWithLabel("Password").getText().toString().isEmpty();
		// bot.sleep(100000);
		// bot.textWithLabel("Password").setText(
		// System.getProperty("reportdb.oracle.password"));
		//	bot.sleep(50000);
//		System.out.println(System.getProperty("reportdb.oracle.password")
//				+ "qqqq" + bot.textWithLabel("Password").getText() + "bbbbb");
	}

	public static void generateReport(SWTWorkbenchBot bot, SWTFormsBot formBot,
			String label, TalendReportTemplate template, String... analyses) {
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		try {
			tree.expandNode("Data Profiling").getNode(1).expand()
					.select(label + " 0.1");
			ContextMenuHelper.clickContextMenu(tree, "Open Report");
		} catch (Exception e1) {
		
		}
		formBot.hyperlink("Select analyses").click();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));

		for (int i = 0; i < analyses.length; i++) {
			tree.expandNode(analyses[i] + " 0.1").check();
		}
		bot.button("OK").click();

		for (int i = 1; i <= analyses.length; i++) {
			if (template == TalendReportTemplate.User_defined) {
				String tmp = template.toString().replace("_", " ");
				formBot.ccomboBox(i).setSelection(tmp);

				/**
			 * 
			 */
			} else {
				formBot.ccomboBox(i).setSelection(template.toString());
			}
		}
		bot.toolbarButtonWithTooltip("Save").click();
//		try {
//			bot.waitUntil(Conditions.shellCloses(bot.shell("refresh")));
//		} catch (TimeoutException e) {
//		}
		bot.toolbarButtonWithTooltip("Generate Report File").click();
		try {
			bot.waitUntil(
					Conditions.shellCloses(bot.shell("Generate Report File")),
					80000);
			// SWTBotShell shell = bot.shell("refresh");
			// bot.waitUntil(Conditions.shellCloses(shell));
		} catch (TimeoutException e) {
		}
		bot.editorByTitle(label + " 0.1").close();
	}

	public static void createUDI(SWTWorkbenchBot bot,
			TalendIndicatorLanguage language, String label, String expression) {
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries", "Indicators").select(
				"User Defined Indicators");
		ContextMenuHelper.clickContextMenu(tree, "New Indicator");
		bot.waitUntil(Conditions.shellIsActive("New Indicator"));
		bot.textWithLabel("Name").setText(label);
		bot.button("Next >").click();

		// String lang = null;
		// if (language.toString().equals("AS_400")) {                                                                            
		// lang = "AS/400";
		// } else if (language.toString().contains("_")) {
		// lang = language.toString().replace("_", " ");
		// if (lang.contains("1"))
		// lang.replace("1", "|");
		// } else {
		// lang = language.toString();
		// }

		bot.comboBoxWithLabel("Language Selection:").setSelection(
				language.getValue());
		bot.textWithLabel("SQL Template:").setText(expression);
		bot.button("Finish").click();
	}

	public static void createDQRule(SWTWorkbenchBot bot, String lable,
			String expression) {
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		tree.expandNode("Libraries", "Rules").select("SQL");
		ContextMenuHelper.clickContextMenu(tree, "New DQ Rule");
		bot.waitUntil(Conditions.shellIsActive("New DQ Rule"));
		bot.textWithLabel("Name").setText(lable);
		bot.button("Next >").click();
		bot.textWithLabel("Where clause").setText(expression);
		bot.button("Finish").click();
		System.out.println("aaaaaa");
		bot.editorByTitle(lable + " 0.1").close();
	}
	public static void deleteAndCleanCycleBin(SWTWorkbenchBot bot,TalendItemTypeEnum type, String label) {
		TalendSwtbotTdqCommon.deleteToCycleBin(bot, type, label);
		TalendSwtbotTdqCommon.cleanItemFromCycleBin(bot, tree, label);
	}
	
	
	public static void deleteToCycleBin(SWTWorkbenchBot bot,TalendItemTypeEnum type, String label) {
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem treeItem = selectDQItemLabel(tree,type,label);
		int count = 0;
		Matcher matcher = allOf(
			withText(label)
		  );

		do{
			try {
				count ++;
				System.out.println("Trying to delete item " + label + " for " + count + " times!");
				ContextMenuHelper.clickContextMenu(tree, "Delete");
				treeItem = selectDQItemLabel(tree,type,label);
				if(treeItem!=null) {
					bot.waitUntil(Conditions.waitForWidget(matcher), 20000);
				}
			} catch (Exception e) {
				System.out.println("Try to delete item " + label + " for " + count + " times!");
				e.printStackTrace();
			}
		}while(treeItem!=null & count<5);
	}
	
	public static void cleanItemFromCycleBin(SWTWorkbenchBot bot,SWTBotTree tree, String label) {
		SWTBotTreeItem treeItem = tree.expandNode("Recycle Bin").getNode(label).select();
		int count = 0;
		Matcher matcher = allOf(
			withText(label)
		  );
		do{
			try {
				count ++;
				System.out.println("Trying to clean item " + label + " for " + count + " times from cycle bin!");
				ContextMenuHelper.clickContextMenu(tree, "Delete");
				bot.waitUntil(Conditions.shellIsActive("Delete forever"), 200000);
				shell = bot.shell("Delete forever");
				bot.button("Yes").click();
				bot.waitUntil(Conditions.shellCloses(shell));
				
				treeItem = tree.expandNode("Recycle Bin").getNode(label).select();
				if(treeItem!=null) {
					bot.waitUntil(Conditions.waitForWidget(matcher), 20000);
				}
			} catch (Exception e) {
				System.out.println("Try to clean item " + label + " for " + count + " times from cycle bin!");
				e.printStackTrace();
			}
		} while(treeItem!=null & count < 5);
	}
	public static SWTBotTreeItem selectDQItemLabel(SWTBotTree tree,TalendItemTypeEnum type, String label ) {
		SWTBotTreeItem treeItem = null;
		switch (type) {
		case METADATA:
			treeItem = tree.expandNode("Metadata", "DB connections").select(label);
			break;
		case ANALYSIS:
			treeItem = tree.expandNode("Data Profiling").getNode(0).expand()
					.select(label + " 0.1");
			break;
		case REPORT:
			treeItem = tree.expandNode("Data Profiling").getNode(1).expand()
					.select(label + " 0.1");
			break;
		case FILE_DELIMITED:
			treeItem = tree.expandNode("Metadata", "fileDelimited").select(label);
			break;
		case MDM:
			treeItem = tree.expandNode("Metadata", "MDMconnections").select(label);
			break;
		case LIBRARY_DQRULE:
			treeItem = tree.expandNode("Libraries", "Rules", "SQL").select(
					label + " 0.1");
			break;
		}
		return treeItem;
	}
	
	
	
	public static void deleteSource(SWTWorkbenchBot bot,
			TalendItemTypeEnum type, String label) {
		TREEITEM_FOUND_TIME += 1;
		
//		List<SWTBotView> vs = bo
        bot.cTabItem(label + " 0.1").close();
		
//		List<SWTBotView> views = bot.views();
//		for(SWTBotView view: views){
//			System.out.print("--------------------" + view.getTitle());
//			if(view.getTitle().startsWith(label)){
//				view.setFocus();
//				view.close();
//			}
//		}
//		
//		bot.viewByTitle(label + " 0.1").setFocus();
//		bot.viewByTitle(label + " 0.1").close();
		
	//	bot.sleep(1000);
		bot.viewByTitle("DQ Repository").setFocus();
		tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		try {
			switch (type) {
			case METADATA:
				tree.expandNode("Metadata", "DB connections").select(label);
				break;
			case ANALYSIS:
				tree.expandNode("Data Profiling").getNode(0).expand()
						.select(label + " 0.1");
				break;
			case REPORT:
				tree.expandNode("Data Profiling").getNode(1).expand()
						.select(label + " 0.1");
				break;
			case FILE_DELIMITED:
				tree.expandNode("Metadata", "FileDelimited connections").select(label);
				break;
			case MDM:
				tree.expandNode("Metadata", "MDM connections").select(label);
				break;
			case LIBRARY_DQRULE:
				tree.expandNode("Libraries", "Rules", "SQL").select(
						label + " 0.1");
				break;
			}
			ContextMenuHelper.clickContextMenu(tree, "Delete");
		} catch (Exception e) {
			if (TREEITEM_FOUND_TIME >= 20) {
				TREEITEM_FOUND_TIME = 0;
				return;
			}
			deleteSource(bot, type, label);
		}
		try {
			//Assert.assertNotNull(tree.expandNode("Recycle Bin").select(label));
			Assert.assertNotNull(tree.expandNode("Recycle Bin").expand().getNode(0).select());
			boolean b = false;
			do {
				try {
				//	tree.expandNode("Recycle Bin").select(label);
					tree.expandNode("Recycle Bin").expand().getNode(0).select();
					ContextMenuHelper.clickContextMenu(tree, "Delete");
					b = false;
				} catch (Exception e) {
					SWTBotTreeItem[] items = tree.expandNode("Recycle Bin")
							.expand().getItems();
					if (items.length == 0) {
						break;
					}
					b = true;
				}
			} while (b);
		
				bot.waitUntil(Conditions.shellIsActive("Delete forever"));
				shell = bot.shell("Delete forever");
				bot.button("Yes").click();
				bot.waitUntil(Conditions.shellCloses(shell));
			
		} catch (Exception e) {
		}
		TREEITEM_FOUND_TIME = 0;
//		try {
//			while(bot.activeShell().getText().equals("Error")){
//				System.out.println(bot.activeShell().getText()+"::::::::::::::::::");
//			bot.waitUntil(Conditions.shellIsActive("Error"));
//			SWTBotShell shell2 = bot.shell("Error");
//			bot.button("OK").click();
//			bot.waitUntil(Conditions.shellCloses(shell2),5000);
//			}
//		} catch (Exception e) {
//		
//		
//		}
		
		
	}
	public static String[] getColumns(SWTWorkbenchBot bot,
			TalendMetadataTypeEnum metadata, String structure, String table,
			String... column) {
		String[] columns = column;
		bot.viewByTitle("DQ Repository").setFocus();
		SWTBotTree tree = new SWTBotTree((Tree) bot.widget(
				WidgetOfType.widgetOfType(Tree.class),
				bot.viewByTitle("DQ Repository").getWidget()));
		SWTBotTreeItem columnsNode;
		switch (metadata) {
		case MYSQL:
			columnsNode = tree
					.expandNode("Metadata", "DB connections",
							metadata.toString(), structure).getNode(0).expand()
					.expandNode(table).getNode(0);
			SWTBotTreeItem[] columnsItem = columnsNode.expand().getItems();
			int count = Integer.parseInt(columnsNode.getText().substring(
					columnsNode.getText().indexOf("(") + 1,
					columnsNode.getText().indexOf(")")));
			for (int i = 0; i < columns.length; i++) {
				for (int j = 0; j < count - 1; j++) {
					if (columnsItem[j].getText().startsWith(columns[i])) {
						columns[i] = columnsItem[j].getText();
						break;
					}
				}
			}
			break;
		}

		return columns;
	}

	// cheat sheet 数据库连接
	public static void createConn(SWTWorkbenchBot bot,
			TalendMetadataTypeEnum metadataType) {

		try {
			switch (metadataType) {
			case MYSQL:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MYSQL.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("MySQL");
				setConnectionInfo(bot, System.getProperty("mysql.login"),
						System.getProperty("mysql.password"),
						System.getProperty("mysql.hostname"),
						System.getProperty("mysql.port"),
						System.getProperty("mysql.dbname"));
				break;
			case POSTGRESQL:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.POSTGRESQL.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("PostgreSQL");
				setConnectionInfo(bot, System.getProperty("postgre.login"),
						System.getProperty("postgre.password"),
						System.getProperty("postgre.hostname"),
						System.getProperty("postgre.port"),
						System.getProperty("postgre.dbname"));
				break;
			case MSSQL:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MSSQL.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection(
						"Microsoft SQL Server 2005/2008");
				setConnectionInfo(bot, System.getProperty("mssql.login"),
						System.getProperty("mssql.password"),
						System.getProperty("mssql.hostname"),
						System.getProperty("mssql.port"),
						System.getProperty("mssql.dbname"));
				break;
			case ORACLE:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.ORACLE.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type")
						.setSelection("Oracle with SID");
				bot.textWithLabel("Login").setText(
						System.getProperty("oracle.login"));
				bot.textWithLabel("Password").setText(
						System.getProperty("oracle.password"));
				bot.textWithLabel("Server").setText(
						System.getProperty("oracle.hostname"));
				bot.textWithLabel("Port").setText(
						System.getProperty("oracle.port"));
				bot.textWithLabel("Sid").setText(
						System.getProperty("oracle.sid"));
				break;
			case SQLITE:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.SQLITE.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("SQLite");
				bot.textWithLabel("File").setText(
						System.getProperty("sqlite.path"));
				break;
			case AS400:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.AS400.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("AS400");
				setConnectionInfo(bot, System.getProperty("as400.login"),
						System.getProperty("as400.password"),
						System.getProperty("as400.hostname"), null,
						System.getProperty("as400.dbname"));
				break;
			case SYBASE:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.SYBASE.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection(
						"Sybase (ASE and IQ)");
				setConnectionInfo(bot, System.getProperty("sybase.login"),
						System.getProperty("sybase.password"),
						System.getProperty("sybase.hostname"),
						System.getProperty("sybase.port"),
						System.getProperty("sybase.dbname"));
				break;
			case MYSQLODBC:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MYSQLODBC.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("Generic ODBC");
				bot.textWithLabel("DataSource").setText(
						System.getProperty("mysqlodbc.source"));
				break;
			case MYSQLJDBC:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MYSQLJDBC.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("General JDBC");
				bot.textWithLabel("JDBC URL").setText(
						System.getProperty("mysqljdbc.url"));
				bot.textWithLabel("Driver jar").setText(
						System.getProperty("mysqljdbc.driverpath"));
				bot.buttonWithTooltip("Select class name").click();
				bot.textWithLabel("User name ").setText(
						System.getProperty("mysqljdbc.login"));
				bot.textWithLabel("Password").setText(
						System.getProperty("mysqljdbc.password"));
				break;
			case MSACCESSODBC:
				bot.textWithLabel("Name").setText(
						TalendMetadataTypeEnum.MSACCESSODBC.toString());
				bot.button("&Next >").click();
				bot.comboBoxWithLabel("DB Type").setSelection("Generic ODBC");
				bot.textWithLabel("DataSource").setText(
						System.getProperty("msaccessodbc.source"));
				break;
			}
			bot.button("Check").click();
			bot.waitUntil(Conditions.shellIsActive("Check Connection"));
			if (bot.label(1)
					.getText()
					.equals("\"" + metadataType.toString()
							+ "\" connection successful."))
				bot.button("OK").click();
			bot.button("Finish").click();
		} catch (Exception e) {
			shell.close();
			return;
		}
		shell = bot.shell("Database Connection");
		bot.waitUntil(Conditions.shellCloses(shell));
	}

	// creat cheatsheet analysis
	public static void createCSAnalysis(SWTWorkbenchBot bot,
			TalendAnalysisTypeEnum analysisType) {
		try {
			bot.textWithLabel("Name").setText(analysisType.toString());
			bot.button("Finish").click();
		} catch (WidgetNotFoundException e) {
			bot.shell("Create New Analysis").close();
			return;
		}
	}

	public static void createCSAnalysis(SWTWorkbenchBot bot,
			TalendAnalysisTypeEnum analysisType,
			TalendMetadataTypeEnum metadataType) {
		bot.textWithLabel("Name").setText(analysisType.toString());
		bot.button("Next >").click();
		tree = new SWTBotTree((Tree) bot.widget(WidgetOfType
				.widgetOfType(Tree.class)));
		switch (analysisType) {
		case CONNECTION:
			tree.expandNode("DB connections").select(metadataType.toString());
			break;
		case CATALOG:
			tree.expandNode("DB connections", metadataType.toString())
					.getNode(0).select();
			break;
		case SCHEMA:
			tree.expandNode("DB connections", metadataType.toString())
					.getNode(0).select();
			if (!bot.button("Next >").isEnabled())
				tree.expandNode("DB connections", metadataType.toString())
						.getNode(0).expand().getNode(0).select();
			break;
		}
		bot.button("Next >").click();
		bot.button("Finish").click();
	}

	public static boolean deleteItemToCycleBin() {
		boolean deleted = false;
		
		
		return deleted;
	}
	
	
	public static SWTBotTableItem getTableItem(SWTWorkbenchBot bot, String table) {
		SWTBotTableItem tableItem = null;

		int index = table.indexOf("(");
		String first = table.substring(0, index - 1);
		String second = table.substring(index + 1, table.length() - 1);

		List<String> colums = bot.table().columns();
		for (String colum : colums) {
			System.out.println("Colum - " + colum);
		}

		try {
			tableItem = bot.table().getTableItem(
					first.toLowerCase() + "(" + second.toUpperCase() + ")");
			System.out.println("TableItem - " + tableItem.getText());
			return tableItem;
		} catch (WidgetNotFoundException e) {
			e.printStackTrace();
		}
		try {
			tableItem = bot.table().getTableItem(
					first.toUpperCase() + "(" + second.toLowerCase() + ")");
			System.out.println("TableItem - " + tableItem.getText());
			return tableItem;
		} catch (WidgetNotFoundException e) {
			e.printStackTrace();
		}

		try {
			tableItem = bot.table().getTableItem(table.toLowerCase());
			System.out.println("TableItem - " + tableItem.getText());
			return tableItem;
		} catch (WidgetNotFoundException e) {
			e.printStackTrace();
		}

		try {
			tableItem = bot.table().getTableItem(table.toUpperCase());
			System.out.println("TableItem - " + tableItem.getText());
			return tableItem;
		} catch (WidgetNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("TableItem - " + tableItem.getText());

		return tableItem;
	}

}
