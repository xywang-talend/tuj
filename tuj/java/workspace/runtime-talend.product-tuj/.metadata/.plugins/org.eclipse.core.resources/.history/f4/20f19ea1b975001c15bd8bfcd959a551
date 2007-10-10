package org.talend.designer.codegen.translators.elt.oracle;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.commons.utils.generation.CodeGenerationUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TELTOracleOutputMainJava
{
  protected static String nl;
  public static synchronized TELTOracleOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTOracleOutputMainJava result = new TELTOracleOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString select_query = null;" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tselect_query = (String) globalMap.get(\"";
  protected final String TEXT_4 = "\"+\"QUERY\"+\"";
  protected final String TEXT_5 = "\");" + NL + "\t\t";
  protected final String TEXT_6 = NL + "java.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");" + NL + "" + NL + "String url_";
  protected final String TEXT_7 = " = \"jdbc:oracle:thin:@\"+";
  protected final String TEXT_8 = "+\":\"+";
  protected final String TEXT_9 = "+\":\"+";
  protected final String TEXT_10 = ";" + NL;
  protected final String TEXT_11 = NL + "String dbUser_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "String dbPwd_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_16 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_17 = ",dbUser_";
  protected final String TEXT_18 = ",dbPwd_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + NL + "java.sql.PreparedStatement pstmtInsert_";
  protected final String TEXT_21 = " =null;" + NL + "" + NL + "java.sql.PreparedStatement pstmtUpdate_";
  protected final String TEXT_22 = " =null;" + NL + "" + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_23 = " =null;" + NL;
  protected final String TEXT_24 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_25 = " =null;" + NL + "\t";
  protected final String TEXT_26 = "\t" + NL + "\t" + NL + "\t" + NL + "String insertQuery = \"INSERT INTO ";
  protected final String TEXT_27 = " (\"+select_query+\")\";" + NL + "pstmt_";
  protected final String TEXT_28 = " = conn_";
  protected final String TEXT_29 = ".prepareStatement(insertQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_30 = NL + NL + "String updateQuery = \"UPDATE ";
  protected final String TEXT_31 = " SET (";
  protected final String TEXT_32 = ") = (\"+select_query+\") \"";
  protected final String TEXT_33 = NL + "+\"  WHERE \" + ";
  protected final String TEXT_34 = NL + ";" + NL + "pstmt_";
  protected final String TEXT_35 = " = conn_";
  protected final String TEXT_36 = ".prepareStatement(updateQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_37 = NL + NL + "String insertQuery = \"INSERT INTO ";
  protected final String TEXT_38 = " (\"+select_query+\")\";" + NL + "pstmt_";
  protected final String TEXT_39 = " = conn_";
  protected final String TEXT_40 = ".prepareStatement(insertQuery);" + NL + "" + NL + "String updateQuery = \"UPDATE ";
  protected final String TEXT_41 = " SET (";
  protected final String TEXT_42 = ") = (\"+select_query+\") \"";
  protected final String TEXT_43 = NL + "+\"  WHERE \" + ";
  protected final String TEXT_44 = NL + ";" + NL + "pstmt_";
  protected final String TEXT_45 = " = conn_";
  protected final String TEXT_46 = ".prepareStatement(updateQuery);" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_47 = NL + NL + "String updateQuery = \"UPDATE ";
  protected final String TEXT_48 = " SET (";
  protected final String TEXT_49 = ") = (\"+select_query+\") \"";
  protected final String TEXT_50 = NL + "+\"  WHERE \" + ";
  protected final String TEXT_51 = NL + ";" + NL + "pstmt_";
  protected final String TEXT_52 = " = conn_";
  protected final String TEXT_53 = ".prepareStatement(updateQuery);" + NL + "\t\t\t\t" + NL + "String insertQuery = \"INSERT INTO ";
  protected final String TEXT_54 = " (\"+select_query+\")\";" + NL + "pstmt_";
  protected final String TEXT_55 = " = conn_";
  protected final String TEXT_56 = ".prepareStatement(insertQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_57 = NL + "\t" + NL + "String deleteQuery = \"DELETE  FROM (\"+select_query+\") ";
  protected final String TEXT_58 = "\"";
  protected final String TEXT_59 = NL + "+\"  WHERE \" + ";
  protected final String TEXT_60 = NL + ";" + NL + "pstmt_";
  protected final String TEXT_61 = " = conn_";
  protected final String TEXT_62 = ".prepareStatement(deleteQuery);" + NL + "" + NL + "\t";
  protected final String TEXT_63 = NL + "int nb_line_";
  protected final String TEXT_64 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_65 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_66 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_67 = " = 0;" + NL + "\t";
  protected final String TEXT_68 = NL + NL + "System.out.println(\"Inserting with : \\n\" + insertQuery + \"\\n\");" + NL + "nb_line_inserted_";
  protected final String TEXT_69 = " = pstmt_";
  protected final String TEXT_70 = ".executeUpdate();" + NL + "System.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_71 = " + \" rows inserted. \\n\");" + NL + "" + NL + "\t";
  protected final String TEXT_72 = NL + "System.out.println(\"Updating with : \\n\" + updateQuery +\"\\n\");" + NL + "nb_line_update_";
  protected final String TEXT_73 = " = pstmt_";
  protected final String TEXT_74 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_update_";
  protected final String TEXT_75 = " + \" rows updated. \\n\");" + NL + "\t";
  protected final String TEXT_76 = NL + "\ttry{" + NL + "\t\tSystem.out.println(\"Inserting with : \\n\" + insertQuery + \"\\n\");" + NL + "\t\tnb_line_inserted_";
  protected final String TEXT_77 = " = pstmtInsert_";
  protected final String TEXT_78 = ".executeUpdate();" + NL + "\t\tSystem.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_79 = " + \" rows inserted. \\n\");" + NL + "\t}catch(Exception e){" + NL + "\t\tSystem.out.println(\"Updating with : \\n\" + updateQuery +\"\\n\");" + NL + "\t\tnb_line_update_";
  protected final String TEXT_80 = " = pstmtUpdate_";
  protected final String TEXT_81 = ".executeUpdate();" + NL + "\t\tSystem.out.println(\"--> \" + nb_line_update_";
  protected final String TEXT_82 = " + \" rows updated. \\n\");\t" + NL + "\t}";
  protected final String TEXT_83 = NL + "\ttry{" + NL + "\t\tSystem.out.println(\"Updating with : \\n\" + updateQuery +\"\\n\");" + NL + "\t\tnb_line_update_";
  protected final String TEXT_84 = " = pstmtUpdate_";
  protected final String TEXT_85 = ".executeUpdate();" + NL + "\t\tSystem.out.println(\"--> \" + nb_line_update_";
  protected final String TEXT_86 = " + \" rows updated. \\n\");\t\t" + NL + "\t}catch(Exception e){" + NL + "\t\tSystem.out.println(\"Inserting with : \\n\" + insertQuery + \"\\n\");" + NL + "\t\tnb_line_inserted_";
  protected final String TEXT_87 = " = pstmtInsert_";
  protected final String TEXT_88 = ".executeUpdate();" + NL + "\t\tSystem.out.println(\"--> \" + nb_line_inserted_";
  protected final String TEXT_89 = " + \" rows inserted. \\n\");" + NL + "\t}";
  protected final String TEXT_90 = NL + "\tSystem.out.println(\"Deleting with : \\n\" + deleteQuery +\"\\n\");" + NL + "\t\tnb_line_deleted_";
  protected final String TEXT_91 = " = pstmt_";
  protected final String TEXT_92 = ".executeUpdate();" + NL + "\tSystem.out.println(\"--> \" + nb_line_deleted_";
  protected final String TEXT_93 = " + \" rows deleted. \\n\");" + NL + "\t\t";
  protected final String TEXT_94 = NL + NL + "if(pstmtUpdate_";
  protected final String TEXT_95 = " != null){" + NL + "" + NL + "\tpstmtUpdate_";
  protected final String TEXT_96 = ".close();" + NL + "\t" + NL + "}else if(pstmt_";
  protected final String TEXT_97 = " != null) {" + NL + "" + NL + "\tpstmt_";
  protected final String TEXT_98 = ".close();" + NL + "\t" + NL + "}" + NL + "" + NL + "conn_";
  protected final String TEXT_99 = " .close();" + NL;
  protected final String TEXT_100 = NL + "pstmt_";
  protected final String TEXT_101 = ".close();" + NL + "conn_";
  protected final String TEXT_102 = " .close();";
  protected final String TEXT_103 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_104 = "_NB_LINE\",nb_line_";
  protected final String TEXT_105 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_106 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_107 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_108 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_109 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_110 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();

	String dbtable = null;
	String uniqueNameConnection = null;
	INode previousNode = null;
	
    stringBuffer.append(TEXT_2);
    
	List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
	if(connections != null && connections.size() > 0 && connections.get(0) != null) {
	    IConnection connection = connections.get(0);
	    previousNode = connection.getSource();
	    String previousComponentName = previousNode.getUniqueName();
		dbtable = connection.getName();
		uniqueNameConnection = connection.getUniqueName();
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_5);
    
	}
	
	String dbtypeDefinition = ElementParameterParser.getValue(node, "__TYPE__");
    
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

        String dbhost = null;
        String dbport = null;
        String dbname = null;
        String dbuser = null;
        String dbpwd = null;
        String encoding = null;
        
        if(previousNode != null) {
	        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
	        dbport = ElementParameterParser.getValue(previousNode, "__PORT__");
	        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
	        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
	        dbpwd = ElementParameterParser.getValue(previousNode, "__PASS__");
	        encoding = ElementParameterParser.getValue(
	            previousNode,
	            "__ENCODING__"
	        );
        }

//        String tableAction = ElementParameterParser.getValue(
//            node,
//            "__TABLE_ACTION__"
//        );

        String whereClause = ElementParameterParser.getValue(
                node,
            "__WHERE_CLAUSE__"
        );


    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_10);
    
List<IMetadataColumn> columnList = null;

List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas !=null && metadatas.size()>0){
	IMetadataTable metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    if(dataAction.equals("INSERT_OR_UPDATE")||dataAction.equals("UPDATE_OR_INSERT")){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    }else{
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
}

if(columnList != null && columnList.size()>0){

class Column{

	IMetadataColumn column;
	
	String name;
	
	String sqlStmt;
	
	String value;
	
	boolean addCol;
	
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(String colName,String sqlStmt,boolean addCol){
		this.column = null;
		this.name = colName;
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
			insertColName.append(replacement.getName()+suffix);
			insertValueStmt.append(replacement.getSqlStmt()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append(replacement.getName());
				updateSetStmt.append(replacement.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append(replacement.getName());
				updateWhereStmt.append(replacement.getSqlStmt());
			}
			counterReplace++;
		}
	}else{
		if(counterOuter==(stmtStructure.size()-1)){
			suffix = "";
		}
		if(colStmt.isAddCol()){
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getSqlStmt()+suffix);
			updateSetStmt.append(colStmt.getName());
			updateSetStmt.append(colStmt.getSqlStmt()+suffix);
		}else{
			insertColName.append(colStmt.getName()+suffix);
			insertValueStmt.append(colStmt.getValue()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append(colStmt.getName());
				updateSetStmt.append(colStmt.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append(colStmt.getName());
				updateWhereStmt.append(colStmt.getSqlStmt());
			}
		}
	}
	counterOuter ++;
}


	if(dataAction.equals("INSERT")){
	
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
	}else if (dataAction.equals("UPDATE")){
	
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_32);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    		
	}else if (dataAction.equals("INSERT_OR_UPDATE")){
	
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_42);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
	}else if (dataAction.equals("UPDATE_OR_INSERT")){
	
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_49);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			
	}else if (dataAction.equals("DELETE")){
	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_58);
    if(CodeGenerationUtils.hasAlphaNumericCharacter(whereClause)) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(CodeGenerationUtils.replaceAllCrBySpace(whereClause));
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    		
	}
	
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
	
}



















// MAIN

	String incomingConnName = null;
	columnList = null;
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}
	
	metadatas = node.getMetadataList();
	
	if(metadatas != null && metadatas.size()>0){
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			columnList = metadata.getListColumns();
		}
	}
	
////////////////////////////////////////////////////////////
class Column{

	IMetadataColumn column;
	
	String name;
	
	String sqlStmt;
	
	String value;
	
	boolean addCol;
	
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(String colName,String sqlStmt,boolean addCol){
		this.column = null;
		this.name = colName;
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

////////////////////////////////////////////////////////////
List<Column> colStruct =  new ArrayList();
for(Column colStmt:stmtStructure){
	if(!colStmt.isReplaced()&&!colStmt.isAddCol()){
		colStruct.add(colStmt);
	}
}
///////////////////////////////////////////////////////////

if(incomingConnName != null && columnList != null){
	if(dataAction.equals("INSERT")){
	
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    
	}else if(dataAction.equals("UPDATE")){

	
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
	}else if (dataAction.equals("INSERT_OR_UPDATE")){

    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
	}else if (dataAction.equals("UPDATE_OR_INSERT")){

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
	
	}else if (dataAction.equals("DELETE")){
		
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
	}
}



















// END





	if(dataAction.equals("INSERT_OR_UPDATE")||dataAction.equals("UPDATE_OR_INSERT")){

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    	
	}else{

    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
	}

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(TEXT_112);
    return stringBuffer.toString();
  }
}
