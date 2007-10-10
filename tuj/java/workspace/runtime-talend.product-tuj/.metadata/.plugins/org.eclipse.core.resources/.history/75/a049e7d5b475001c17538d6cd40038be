package org.talend.designer.codegen.translators.databases.javadb;

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

public class TJavaDBOutputBeginJava
{
  protected static String nl;
  public static synchronized TJavaDBOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJavaDBOutputBeginJava result = new TJavaDBOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "    int keyCount_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "    if(keyCount_";
  protected final String TEXT_7 = " < 1)" + NL + "    {" + NL + "    \tthrow new Exception(\"For update or delete, Schema must have a key\");" + NL + "    }";
  protected final String TEXT_8 = " " + NL + "" + NL + "String jdbcDriver_";
  protected final String TEXT_9 = " = null;" + NL + "String url_";
  protected final String TEXT_10 = " = null;";
  protected final String TEXT_11 = NL + "\tjdbcDriver_";
  protected final String TEXT_12 = " = \"org.apache.derby.jdbc.EmbeddedDriver\";" + NL + "\turl_";
  protected final String TEXT_13 = " = \"jdbc:derby:\" + ";
  protected final String TEXT_14 = ";" + NL + "\t//set the root path of the database" + NL + "\tSystem.setProperty(\"derby.system.home\",";
  protected final String TEXT_15 = ");" + NL + "\t";
  protected final String TEXT_16 = NL + "\t\tjdbcDriver_";
  protected final String TEXT_17 = " = \"com.ibm.db2.jcc.DB2Driver\";" + NL + "\t\turl_";
  protected final String TEXT_18 = " = \"jdbc:derby:net://\" + ";
  protected final String TEXT_19 = " + \":\" + ";
  protected final String TEXT_20 = " + \"/\" + ";
  protected final String TEXT_21 = ";" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\tjdbcDriver_";
  protected final String TEXT_23 = " = \"org.apache.derby.jdbc.ClientDriver\";" + NL + "\t\turl_";
  protected final String TEXT_24 = " = \"jdbc:derby://\" + ";
  protected final String TEXT_25 = " + \":\" + ";
  protected final String TEXT_26 = " + \"/\" + ";
  protected final String TEXT_27 = ";" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t";
  protected final String TEXT_29 = NL + "    \torg.apache.derby.drda.NetworkServerControl serverControl_";
  protected final String TEXT_30 = ";" + NL + "    \tserverControl_";
  protected final String TEXT_31 = " = new org.apache.derby.drda.NetworkServerControl(java.net.InetAddress.getByName(";
  protected final String TEXT_32 = "),Integer.parseInt(";
  protected final String TEXT_33 = "));" + NL + "    \t//start server" + NL + "    \tserverControl_";
  protected final String TEXT_34 = ".start(new java.io.PrintWriter(System.out,true));" + NL + "    \tboolean isServerUp_";
  protected final String TEXT_35 = " = false;" + NL + "    \tint timeOut_";
  protected final String TEXT_36 = " = 5;" + NL + "    \twhile(!isServerUp_";
  protected final String TEXT_37 = " && timeOut_";
  protected final String TEXT_38 = " > 0)" + NL + "    \t{" + NL + "    \t\ttry" + NL + "    \t\t{" + NL + "    \t\t\ttimeOut_";
  protected final String TEXT_39 = "--;" + NL + "    \t\t\t/*" + NL + "    \t\t\t* testing for connection to see if the network server is up and running." + NL + "    \t\t\t* if server is not ready yet, this method will throw an exception.\t\t" + NL + "    \t\t\t*/" + NL + "    \t\t\tserverControl_";
  protected final String TEXT_40 = ".ping();" + NL + "    \t\t\tisServerUp_";
  protected final String TEXT_41 = " = true;" + NL + "    \t\t}" + NL + "    \t\tcatch(Exception e) {" + NL + "    \t\t\t//Unable to obtain a connection to network server, trying again after 3000 ms." + NL + "    \t\t\tThread.currentThread().sleep(3000);" + NL + "    \t\t}    \t\t\t\t" + NL + "    \t}" + NL + "    \tif(!isServerUp_";
  protected final String TEXT_42 = ")" + NL + "    \t{" + NL + "    \t\t/*" + NL + "    \t\t * can not obtain a connection to network server." + NL + "    \t\t */ \t " + NL + "    \t\tSystem.exit(1);\t" + NL + "    \t}" + NL + "    \t//derby network server started." + NL + "\t";
  protected final String TEXT_43 = NL + NL + "int nb_line_";
  protected final String TEXT_44 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_45 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_46 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_47 = " = 0;" + NL + "" + NL + "int deletedCount_";
  protected final String TEXT_48 = "=0;" + NL + "int updatedCount_";
  protected final String TEXT_49 = "=0;" + NL + "int insertedCount_";
  protected final String TEXT_50 = "=0;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_51 = " = false;" + NL + "" + NL + "Class.forName(jdbcDriver_";
  protected final String TEXT_52 = ").newInstance();" + NL + "" + NL + "java.util.Properties properties_";
  protected final String TEXT_53 = " = new java.util.Properties();" + NL + "" + NL + "properties_";
  protected final String TEXT_54 = ".put(\"user\",";
  protected final String TEXT_55 = ");" + NL + "" + NL + "properties_";
  protected final String TEXT_56 = ".put(\"password\",";
  protected final String TEXT_57 = ");" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_58 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_59 = ",properties_";
  protected final String TEXT_60 = ");" + NL;
  protected final String TEXT_61 = NL + "java.sql.Statement stmtClear_";
  protected final String TEXT_62 = " = conn_";
  protected final String TEXT_63 = ".createStatement();" + NL + "deletedCount_";
  protected final String TEXT_64 = " = deletedCount_";
  protected final String TEXT_65 = " + stmtClear_";
  protected final String TEXT_66 = ".executeUpdate(\"delete from \\\"\" + ";
  protected final String TEXT_67 = "+\"\\\"\");";
  protected final String TEXT_68 = NL;
  protected final String TEXT_69 = NL + NL + "java.sql.PreparedStatement pstmtInsert_";
  protected final String TEXT_70 = " =null;" + NL + "" + NL + "java.sql.PreparedStatement pstmtUpdate_";
  protected final String TEXT_71 = " =null;" + NL + "" + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_72 = " =null;" + NL;
  protected final String TEXT_73 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_74 = " =null;" + NL + "\t";
  protected final String TEXT_75 = "\t" + NL + "\t" + NL + "pstmt_";
  protected final String TEXT_76 = " = conn_";
  protected final String TEXT_77 = ".prepareStatement(\"INSERT INTO \\\"\"+";
  protected final String TEXT_78 = "+\"\\\" (";
  protected final String TEXT_79 = ") VALUES (";
  protected final String TEXT_80 = ")\");" + NL + "" + NL + "\t";
  protected final String TEXT_81 = NL + "\t" + NL + "pstmt_";
  protected final String TEXT_82 = " = conn_";
  protected final String TEXT_83 = ".prepareStatement(\"UPDATE \\\"\"+";
  protected final String TEXT_84 = "+\"\\\" SET ";
  protected final String TEXT_85 = " WHERE ";
  protected final String TEXT_86 = "\");" + NL + "" + NL + "\t";
  protected final String TEXT_87 = NL + "pstmt_";
  protected final String TEXT_88 = " = conn_";
  protected final String TEXT_89 = ".prepareStatement(\"SELECT COUNT(1) FROM \\\"\" + ";
  protected final String TEXT_90 = " + \"\\\" WHERE ";
  protected final String TEXT_91 = "\");\t" + NL + "\t" + NL + "pstmtInsert_";
  protected final String TEXT_92 = " = conn_";
  protected final String TEXT_93 = ".prepareStatement(\"INSERT INTO \\\"\"+";
  protected final String TEXT_94 = "+\"\\\" (";
  protected final String TEXT_95 = ") VALUES (";
  protected final String TEXT_96 = ")\");" + NL + "" + NL + "pstmtUpdate_";
  protected final String TEXT_97 = " = conn_";
  protected final String TEXT_98 = ".prepareStatement(\"UPDATE \\\"\"+";
  protected final String TEXT_99 = "+\"\\\" SET ";
  protected final String TEXT_100 = " WHERE ";
  protected final String TEXT_101 = "\");" + NL + "" + NL + "\t";
  protected final String TEXT_102 = NL + "pstmtUpdate_";
  protected final String TEXT_103 = " = conn_";
  protected final String TEXT_104 = ".prepareStatement(\"UPDATE \\\"\"+";
  protected final String TEXT_105 = "+\"\\\" SET ";
  protected final String TEXT_106 = " WHERE ";
  protected final String TEXT_107 = "\");" + NL + "" + NL + "pstmtInsert_";
  protected final String TEXT_108 = " = conn_";
  protected final String TEXT_109 = ".prepareStatement(\"INSERT INTO \\\"\"+";
  protected final String TEXT_110 = "+\"\\\" (";
  protected final String TEXT_111 = ") VALUES (";
  protected final String TEXT_112 = ")\");" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_113 = NL + "\t" + NL + "pstmt_";
  protected final String TEXT_114 = " = conn_";
  protected final String TEXT_115 = ".prepareStatement(\"DELETE  FROM \\\"\"+";
  protected final String TEXT_116 = "+\"\\\" WHERE ";
  protected final String TEXT_117 = "\");" + NL + "" + NL + "\t";
  protected final String TEXT_118 = NL + NL + "int commitEvery_";
  protected final String TEXT_119 = " = ";
  protected final String TEXT_120 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_121 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_122 = ".setAutoCommit(false);";
  protected final String TEXT_123 = NL + NL + NL;
  protected final String TEXT_124 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String frameworkType = ElementParameterParser.getValue(node,"__FRAMEWORK_TYPE__");		
	
    String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
    
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    
	String dbport = ElementParameterParser.getValue(node, "__PORT__");	
				
    List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,"__ADD_COLS__" );
	
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
	
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String tableAction = ElementParameterParser.getValue(node,"__CLEAR_TABLE__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String dbRootPath = ElementParameterParser.getValue(node, "__DBPATH__");	


    stringBuffer.append(TEXT_2);
    
List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas !=null && metadatas.size()>0){
	IMetadataTable metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_3);
    
if(!dataAction.equals("INSERT"))
{
    int keyCount = 0;
    for(IMetadataColumn column:columnList)
    {
    	if(column.isKey())
    	{
    		keyCount++;
    	}
    }
    
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
if(frameworkType.equals("EMBEDED"))
{
	
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbRootPath);
    stringBuffer.append(TEXT_15);
    
}
else
{
	if(frameworkType.equals("JCCJDBC"))
	{
		
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_21);
    
	}
	else
	{
		
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_27);
    
	}
	
    stringBuffer.append(TEXT_28);
    
	String connectionFlag = ElementParameterParser.getValue(node, "__CONNECTION_FLAG__");
	if(connectionFlag.equals("false"))
	{
	
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    
	}
}

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
if(tableAction.equals("true"))
{

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_67);
    	
}

    stringBuffer.append(TEXT_68);
    if(dataAction.equals("INSERT_OR_UPDATE")||dataAction.equals("UPDATE_OR_INSERT")){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    }else{
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
}

if(columnList != null && columnList.size()>0){

class Column{

	IMetadataColumn column;
	
	String name;
	
	String DBname;
	
	String sqlStmt;
	
	String value;
	
	boolean addCol;
	
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(String colName,String sqlStmt,boolean addCol){
		this.column = null;
		this.name=colName;
		this.DBname = colName;
		this.sqlStmt = sqlStmt;
		this.value = "?";
		this.addCol =addCol;
	}
	
	public Column(IMetadataColumn column){
		this.column = column;
		this.name = column.getLabel();
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
		this.DBname=column.getOriginalDbColumnName();
	}
	
	public boolean isReplaced(){
		return replacement.size()>0;
	}
	
	public void replace(Column column){
		this.replacement.add(column);
	}
	
	public List<Column> getReplacement(){
		return this.replacement;
	}
	
	public void setColumn(IMetadataColumn column){
		this.column = column;
	}
	
	public IMetadataColumn getColumn(){
		return this.column;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	
	public void setDBName(String DBname){
		this.DBname = DBname;
	}

	public String getDBName(){
		return this.DBname;
	}
	
	public void setIsAddCol(boolean isadd){
		this.addCol = isadd;
	}
	
	public boolean isAddCol(){
		return this.addCol;
	}
	
	public void setSqlStmt(String sql){
		this.sqlStmt = sql;
	}
	
	public String getSqlStmt(){
		return this.sqlStmt;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}

StringBuffer insertColName = new StringBuffer();

StringBuffer insertValueStmt = new StringBuffer();

StringBuffer updateSetStmt = new StringBuffer();

StringBuffer updateWhereStmt = new StringBuffer();

List<Column> stmtStructure =  new LinkedList<Column>();

for(IMetadataColumn column:columnList){

	stmtStructure.add(new Column(column));

}

for(IMetadataColumn column:columnList){
	if(addCols != null && addCols.size()>0){
		for(Map<String, String> addCol:addCols){
			if(addCol.get("REFCOL").equals(column.getLabel())){
				int stmtIndex = 0;
				
				for(Column stmtStr:stmtStructure){					
					if(stmtStr.getName().equals(addCol.get("REFCOL"))){
						break;
					}
					stmtIndex++;
				}
				
				if(addCol.get("POS").equals("AFTER")){
					Column insertAfter = new Column("\"+"+addCol.get("NAME")+"+\"","\"+"+addCol.get("SQL")+"+\"",true);
					stmtStructure.add(stmtIndex+1,insertAfter);
				}else if(addCol.get("POS").equals("BEFORE")){
					Column insertBefore = new Column("\"+"+addCol.get("NAME")+"+\"","\"+"+addCol.get("SQL")+"+\"",true);
					stmtStructure.add(stmtIndex,insertBefore);
				}else if(addCol.get("POS").equals("REPLACE")){
					Column replacementCol = new Column("\"+"+addCol.get("NAME")+"+\"","\"+"+addCol.get("SQL")+"+\"",true);
					Column replacedCol = (Column) stmtStructure.get(stmtIndex);
					replacedCol.replace(replacementCol);
				}
			}
		}
	}
}

int counterOuter =0;
boolean firstKey = true;
boolean firstNoneKey = true;

for(Column colStmt:stmtStructure){
	String suffix = ",";
	
	if(colStmt.isReplaced()){		
		List<Column> replacedColumns = colStmt.getReplacement();
		int counterReplace = 0;
		if(counterOuter==(stmtStructure.size()-1) && counterReplace==(replacedColumns.size()-1) ){
			suffix = "";
		}
		for(Column replacement:replacedColumns){
			insertColName.append("\\\""+replacement.getName()+"\\\""+suffix);
			insertValueStmt.append(replacement.getSqlStmt()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append("\\\""+replacement.getName()+"\\\"");
				updateSetStmt.append("=" + replacement.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append("\\\""+replacement.getName()+"\\\"");
				updateWhereStmt.append("=" + replacement.getSqlStmt());
			}
			counterReplace++;
		}
	}else{
		if(counterOuter==(stmtStructure.size()-1)){
			suffix = "";
		}
		if(colStmt.isAddCol()){
			insertColName.append("\\\""+colStmt.getDBName()+"\\\""+suffix);
			insertValueStmt.append(colStmt.getSqlStmt()+suffix);
			updateSetStmt.append("\\\""+colStmt.getDBName()+"\\\"");
			updateSetStmt.append("=" + colStmt.getSqlStmt()+suffix);
		}else{
			insertColName.append("\\\""+colStmt.getDBName()+"\\\""+suffix);
			insertValueStmt.append(colStmt.getValue()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append("\\\""+colStmt.getDBName()+"\\\"");
				updateSetStmt.append(colStmt.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append("\\\""+colStmt.getDBName()+"\\\"");
				updateWhereStmt.append(colStmt.getSqlStmt());
			}
		}
	}
	counterOuter ++;
}


	if(dataAction.equals("INSERT")){
	
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_80);
    
	}else if (dataAction.equals("UPDATE")){
	
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_86);
    		
	}else if (dataAction.equals("INSERT_OR_UPDATE")){
	
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_101);
    
	}else if (dataAction.equals("UPDATE_OR_INSERT")){
	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_112);
    
			
	}else if (dataAction.equals("DELETE")){
	
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_117);
    		
	}
}
if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
}

    stringBuffer.append(TEXT_123);
    stringBuffer.append(TEXT_124);
    return stringBuffer.toString();
  }
}
