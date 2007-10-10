package org.talend.designer.codegen.translators.databases.dbjdbc;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TJDBCOutputBeginJava
{
  protected static String nl;
  public static synchronized TJDBCOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCOutputBeginJava result = new TJDBCOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tint keyCount_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\t\tif (keyCount_";
  protected final String TEXT_5 = " < 1) {" + NL + "\t\t\tthrow new Exception(\"For update or delete, schema must have a key\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t" + NL + "\tint nb_line_";
  protected final String TEXT_7 = " = 0;" + NL + "\tint nb_line_update_";
  protected final String TEXT_8 = " = 0;" + NL + "\tint nb_line_inserted_";
  protected final String TEXT_9 = " = 0;" + NL + "\tint nb_line_deleted_";
  protected final String TEXT_10 = " = 0;" + NL + "\t" + NL + "\tint deletedCount_";
  protected final String TEXT_11 = "=0;" + NL + "\tint updatedCount_";
  protected final String TEXT_12 = "=0;" + NL + "\tint insertedCount_";
  protected final String TEXT_13 = "=0;" + NL + "" + NL + "\tboolean whetherReject_";
  protected final String TEXT_14 = " = false;" + NL + "\t" + NL + "\tjava.lang.Class.forName(";
  protected final String TEXT_15 = ");" + NL + "\tString connectionString_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";" + NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_18 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ");" + NL + "\t";
  protected final String TEXT_22 = NL + "\t\tjava.sql.Statement statementClear_";
  protected final String TEXT_23 = " = connection_";
  protected final String TEXT_24 = ".createStatement();" + NL + "\t\tdeletedCount_";
  protected final String TEXT_25 = " = deletedCount_";
  protected final String TEXT_26 = " + statementClear_";
  protected final String TEXT_27 = ".executeUpdate(\"delete from \" + ";
  protected final String TEXT_28 = ");" + NL + "\t\t";
  protected final String TEXT_29 = NL + "\t\tjava.sql.PreparedStatement statementInsert_";
  protected final String TEXT_30 = " = null;" + NL + "\t\tjava.sql.PreparedStatement statementUpdate_";
  protected final String TEXT_31 = " = null;" + NL + "\t\tjava.sql.PreparedStatement statement_";
  protected final String TEXT_32 = " = null;" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\tjava.sql.PreparedStatement statement_";
  protected final String TEXT_34 = " = null;" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\tstatement_";
  protected final String TEXT_36 = " = connection_";
  protected final String TEXT_37 = ".prepareStatement(\"INSERT INTO \" + ";
  protected final String TEXT_38 = " + \" (";
  protected final String TEXT_39 = ") VALUES (";
  protected final String TEXT_40 = ")\");" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\tstatement_";
  protected final String TEXT_42 = " = connection_";
  protected final String TEXT_43 = ".prepareStatement(\"UPDATE \" + ";
  protected final String TEXT_44 = " + \" SET ";
  protected final String TEXT_45 = " WHERE ";
  protected final String TEXT_46 = "\");" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\tstatement_";
  protected final String TEXT_48 = " = connection_";
  protected final String TEXT_49 = ".prepareStatement(\"SELECT COUNT(1) FROM \" + ";
  protected final String TEXT_50 = " + \" WHERE ";
  protected final String TEXT_51 = "\");" + NL + "\t\t\tstatementInsert_";
  protected final String TEXT_52 = " = connection_";
  protected final String TEXT_53 = ".prepareStatement(\"INSERT INTO \" + ";
  protected final String TEXT_54 = " + \" (";
  protected final String TEXT_55 = ") VALUES (";
  protected final String TEXT_56 = ")\");" + NL + "\t\t\tstatementUpdate_";
  protected final String TEXT_57 = " = connection_";
  protected final String TEXT_58 = ".prepareStatement(\"UPDATE \" + ";
  protected final String TEXT_59 = " + \" SET ";
  protected final String TEXT_60 = " WHERE ";
  protected final String TEXT_61 = "\");" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\tstatementUpdate_";
  protected final String TEXT_63 = " = connection_";
  protected final String TEXT_64 = ".prepareStatement(\"UPDATE \" + ";
  protected final String TEXT_65 = " + \" SET ";
  protected final String TEXT_66 = " WHERE ";
  protected final String TEXT_67 = "\");" + NL + "\t\t\tstatementInsert_";
  protected final String TEXT_68 = " = connection_";
  protected final String TEXT_69 = ".prepareStatement(\"INSERT INTO \" + ";
  protected final String TEXT_70 = " + \" (";
  protected final String TEXT_71 = ") VALUES (";
  protected final String TEXT_72 = ")\");" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\tstatement_";
  protected final String TEXT_74 = " = connection_";
  protected final String TEXT_75 = ".prepareStatement(\"DELETE  FROM \" + ";
  protected final String TEXT_76 = " + \" WHERE ";
  protected final String TEXT_77 = "\");" + NL + "\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\tint commitEvery_";
  protected final String TEXT_79 = " = ";
  protected final String TEXT_80 = ";" + NL + "\t\t\tint commitCounter_";
  protected final String TEXT_81 = " = 0;" + NL + "\t\t\tconnection_";
  protected final String TEXT_82 = ".setAutoCommit(false);" + NL + "\t\t\t";
  protected final String TEXT_83 = NL;
  protected final String TEXT_84 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<Map<String, String>> addCols =
	(List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__ADD_COLS__");

String driverJar = ElementParameterParser.getValue(node, "__DRIVER_JAR__");
String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
String jdbcUrl = ElementParameterParser.getValue(node, "__URL__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
String tableName = ElementParameterParser.getValue(node, "__TABLE__");
String dataAction = ElementParameterParser.getValue(node, "__DATA_ACTION__");
String clearTable = ElementParameterParser.getValue(node, "__CLEAR_TABLE__");
String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
if (metadatas != null && metadatas.size() > 0) {
	metadata = metadatas.get(0);
}

if (metadata != null) {
	List<IMetadataColumn> columnList = metadata.getListColumns();
	
	// Check that a key is defined for UPDATE / DELETE requests
	if (!dataAction.equals("INSERT")) {
		int keyCount = 0;
		for (IMetadataColumn column : columnList) {
			if (column.isKey()) {
				keyCount++;
			}
		}
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}
	
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(jdbcUrl);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_21);
    
	
	// Clear table
	if (clearTable.equals("true")) {
		
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_28);
    
	}
	
	// Declare statements
	if (dataAction.equals("INSERT_OR_UPDATE") || dataAction.equals("UPDATE_OR_INSERT")) {
		
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	} else {
		
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	}
	
	if (columnList != null && columnList.size() > 0) {
		class Column {
			IMetadataColumn column;
			String name;
			String sqlStmt;
			String value;
			boolean addCol;
			List<Column> replacement = new ArrayList<Column>();
			
			public Column(String colName, String sqlStmt, boolean addCol) {
				this.column = null;
				this.name = colName;
				this.sqlStmt = sqlStmt;
				this.value = "?";
				this.addCol = addCol;
			}
			
			public Column(IMetadataColumn column) {
				this.column = column;
				this.name = column.getLabel();
				this.sqlStmt = "=?";
				this.value = "?";
				this.addCol = false;
			}
			
			public boolean isReplaced() {
				return replacement.size() > 0;
			}
			
			public void replace(Column column) {
				this.replacement.add(column);
			}
			
			public List<Column> getReplacement() {
				return this.replacement;
			}
			
			public void setColumn(IMetadataColumn column) {
				this.column = column;
			}
			
			public IMetadataColumn getColumn() {
				return this.column;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public String getName() {
				return this.name;
			}
			
			public void setIsAddCol(boolean isadd) {
				this.addCol = isadd;
			}
			
			public boolean isAddCol() {
				return this.addCol;
			}
			
			public void setSqlStmt(String sql) {
				this.sqlStmt = sql;
			}
			
			public String getSqlStmt() {
				return this.sqlStmt;
			}
			
			public void setValue(String value) {
				this.value = value;
			}
			
			public String getValue() {
				return this.value;
			}
		}
		
		StringBuffer insertColName = new StringBuffer();
		StringBuffer insertValueStmt = new StringBuffer();
		StringBuffer updateSetStmt = new StringBuffer();
		StringBuffer updateWhereStmt = new StringBuffer();
		List<Column> stmtStructure =  new LinkedList<Column>();
		
		for (IMetadataColumn column : columnList) {
			stmtStructure.add(new Column(column));
		}
		
		for (IMetadataColumn column : columnList) {
			if (addCols != null && addCols.size() > 0) {
				for (Map<String, String> addCol : addCols) {
					if (addCol.get("REFCOL").equals(column.getLabel())) {
						int stmtIndex = 0;
						
						for (Column stmtStr : stmtStructure) {
							if (stmtStr.getName().equals(addCol.get("REFCOL"))) {
								break;
							}
							stmtIndex++;
						}
						
						if (addCol.get("POS").equals("AFTER")) {
							Column insertAfter = new Column("\"+"+addCol.get("NAME")+"+\"", "\"+"+addCol.get("SQL")+"+\"", true);
							stmtStructure.add(stmtIndex+1, insertAfter);
						} else if (addCol.get("POS").equals("BEFORE")) {
							Column insertBefore = new Column("\"+"+addCol.get("NAME")+"+\"", "\"+"+addCol.get("SQL")+"+\"", true);
							stmtStructure.add(stmtIndex, insertBefore);
						} else if (addCol.get("POS").equals("REPLACE")){
							Column replacementCol = new Column("\"+"+addCol.get("NAME")+"+\"", "\"+"+addCol.get("SQL")+"+\"", true);
							Column replacedCol = (Column) stmtStructure.get(stmtIndex);
							replacedCol.replace(replacementCol);
						}
					}
				}
			}
		}
		
		int counterOuter = 0;
		boolean firstKey = true;
		boolean firstNoneKey = true;
		
		for (Column colStmt : stmtStructure) {
			String suffix = ",";
			
			if (colStmt.isReplaced()) {
				List<Column> replacedColumns = colStmt.getReplacement();
				int counterReplace = 0;
				if (counterOuter == stmtStructure.size() - 1 &&
					counterReplace == replacedColumns.size() - 1) {
					suffix = "";
				}
				for (Column replacement : replacedColumns) {
					insertColName.append(replacement.getName() + suffix);
					insertValueStmt.append(replacement.getSqlStmt() + suffix);
					if (!colStmt.getColumn().isKey()) {
						if (!firstNoneKey) {
							updateSetStmt.append(",");
						} else {
							firstNoneKey = false;
						}
						updateSetStmt.append(replacement.getName());
						updateSetStmt.append("=" + replacement.getSqlStmt());
					} else {
						if (!firstKey) {
							updateWhereStmt.append(" AND ");
						} else {
							firstKey = false;
						}
						updateWhereStmt.append(replacement.getName());
						updateWhereStmt.append("=" + replacement.getSqlStmt());
					}
					counterReplace++;
				}
			} else {
				if (counterOuter == stmtStructure.size() - 1){
					suffix = "";
				}
				if (colStmt.isAddCol()) {
					insertColName.append(colStmt.getName() + suffix);
					insertValueStmt.append(colStmt.getSqlStmt() + suffix);
					updateSetStmt.append(colStmt.getName());
					updateSetStmt.append("=" + colStmt.getSqlStmt() + suffix);
				} else {
					insertColName.append(colStmt.getName() + suffix);
					insertValueStmt.append(colStmt.getValue() + suffix);
					if (!colStmt.getColumn().isKey()) {
						if (!firstNoneKey) {
							updateSetStmt.append(",");
						} else {
							firstNoneKey = false;
						}
						updateSetStmt.append(colStmt.getName());
						updateSetStmt.append(colStmt.getSqlStmt());
					} else {
						if (!firstKey) {
							updateWhereStmt.append(" AND ");
						} else {
							firstKey = false;
						}
						updateWhereStmt.append(colStmt.getName());
						updateWhereStmt.append(colStmt.getSqlStmt());
					}
				}
			}
			counterOuter++;
		}
		
		// Build SQL statements
		if (dataAction.equals("INSERT")) {
			
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_40);
    
		} else if (dataAction.equals("UPDATE")) {
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_46);
    
		} else if (dataAction.equals("INSERT_OR_UPDATE")) {
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_61);
    
		} else if (dataAction.equals("UPDATE_OR_INSERT")) {
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_72);
    
		} else if (dataAction.equals("DELETE")) {
			
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_77);
    
		}
		
		// Commit every
		if (!commitEvery.equals("") && !commitEvery.equals("0")) {
			
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
		}

	}
}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    return stringBuffer.toString();
  }
}
