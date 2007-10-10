package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TTeradataFastLoadMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadMainJava result = new TTeradataFastLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t";
  protected final String TEXT_3 = NL + "if(";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "==null){" + NL + "\t";
  protected final String TEXT_6 = ".setNull(";
  protected final String TEXT_7 = ",java.sql.Types.CHAR);" + NL + "\t";
  protected final String TEXT_8 = NL + "if(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = "==null){" + NL + "\t";
  protected final String TEXT_11 = ".setNull(";
  protected final String TEXT_12 = ",java.sql.Types.DATE);" + NL + "\t";
  protected final String TEXT_13 = NL + "if(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = "==null){" + NL + "\t";
  protected final String TEXT_16 = ".setNull(";
  protected final String TEXT_17 = ",java.sql.Types.ARRAY);\t\t\t" + NL + "\t";
  protected final String TEXT_18 = NL + "if(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = "==null){" + NL + "\t";
  protected final String TEXT_21 = ".setNull(";
  protected final String TEXT_22 = ",java.sql.Types.INTEGER);" + NL + "\t";
  protected final String TEXT_23 = NL + "if(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = "==null){" + NL + "\t";
  protected final String TEXT_26 = ".setNull(";
  protected final String TEXT_27 = ",java.sql.Types.VARCHAR);" + NL + "\t";
  protected final String TEXT_28 = NL + "if(";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = "==null){" + NL + "\t";
  protected final String TEXT_31 = ".setNull(";
  protected final String TEXT_32 = ",java.sql.Types.OTHER);" + NL + "\t";
  protected final String TEXT_33 = NL + "if(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = "==null){" + NL + "\t";
  protected final String TEXT_36 = ".setNull(";
  protected final String TEXT_37 = ",java.sql.Types.BOOLEAN);\t" + NL + "\t";
  protected final String TEXT_38 = NL + "if(";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = "==null){" + NL + "\t";
  protected final String TEXT_41 = ".setNull(";
  protected final String TEXT_42 = ",java.sql.Types.DOUBLE);\t" + NL + "\t";
  protected final String TEXT_43 = NL + "if(";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = "==null){" + NL + "\t";
  protected final String TEXT_46 = ".setNull(";
  protected final String TEXT_47 = ",java.sql.Types.FLOAT);\t" + NL + "\t";
  protected final String TEXT_48 = NL + NL + "}else{" + NL + "" + NL + "\t";
  protected final String TEXT_49 = NL + "\t";
  protected final String TEXT_50 = NL + "\tif(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = "==null){" + NL + "\t";
  protected final String TEXT_53 = NL + "\tif(String.valueOf(";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ").toLowerCase().equals(\"null\")){" + NL + "\t";
  protected final String TEXT_56 = NL + "\t\t";
  protected final String TEXT_57 = ".setNull(";
  protected final String TEXT_58 = ",java.sql.Types.CHAR);" + NL + "\t\t" + NL + "\t}else if(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " == '\\0'){" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_61 = ".setString(";
  protected final String TEXT_62 = ",\"\");" + NL + "\t\t" + NL + "\t}else{" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_63 = ".setString(";
  protected final String TEXT_64 = ",String.valueOf(";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = "));" + NL + "\t}" + NL + "\t";
  protected final String TEXT_67 = NL + "\tif(";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = "!=null){" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_70 = ".setTimestamp(";
  protected final String TEXT_71 = ",new java.sql.Timestamp(";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = ".getTime()));" + NL + "\t\t" + NL + "\t}else{" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_74 = ".setNull(";
  protected final String TEXT_75 = ",java.sql.Types.DATE);" + NL + "\t\t" + NL + "\t}" + NL + "\t";
  protected final String TEXT_76 = NL + "\t";
  protected final String TEXT_77 = ".set";
  protected final String TEXT_78 = "(";
  protected final String TEXT_79 = ",";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ");" + NL + "\t";
  protected final String TEXT_82 = NL + "\t\t" + NL + "}" + NL + "\t";
  protected final String TEXT_83 = NL + "        try{" + NL + "\t\tpstmt_";
  protected final String TEXT_84 = ".addBatch();" + NL + "        }catch(Exception e)" + NL + "        {";
  protected final String TEXT_85 = NL + "                throw(e);";
  protected final String TEXT_86 = NL + "                        ";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ";";
  protected final String TEXT_91 = NL + "                    ";
  protected final String TEXT_92 = ".errorMessage = e.getMessage();";
  protected final String TEXT_93 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_94 = NL + "        }" + NL + "\t";
  protected final String TEXT_95 = NL + "        try{" + NL + "\t\tpstmt_";
  protected final String TEXT_96 = ".addBatch();" + NL + "        }catch(Exception e)" + NL + "        {";
  protected final String TEXT_97 = NL + "                throw(e);";
  protected final String TEXT_98 = NL + "                        ";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = " = ";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = ";";
  protected final String TEXT_103 = NL + "                    ";
  protected final String TEXT_104 = ".errorMessage = e.getMessage();";
  protected final String TEXT_105 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_106 = NL + "        }";
  protected final String TEXT_107 = NL;
  protected final String TEXT_108 = NL + NL + "\t\tjava.sql.ResultSet rs_";
  protected final String TEXT_109 = " = pstmt_";
  protected final String TEXT_110 = ".executeQuery();" + NL + "\t\tint checkCount_";
  protected final String TEXT_111 = " = -1;" + NL + "\t\twhile(rs_";
  protected final String TEXT_112 = ".next())" + NL + "\t\t{" + NL + "\t\t\tcheckCount_";
  protected final String TEXT_113 = " = rs_";
  protected final String TEXT_114 = ".getInt(1);" + NL + "\t\t}" + NL + "\t\tif(checkCount_";
  protected final String TEXT_115 = " > 0)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_116 = NL + "            try{" + NL + "\t\tpstmt_";
  protected final String TEXT_117 = ".addBatch();" + NL + "\t\t\t}catch(Exception e)" + NL + "\t\t\t{" + NL + "\t            ";
  protected final String TEXT_118 = NL + "\t                throw(e);" + NL + "\t                ";
  protected final String TEXT_119 = NL + "\t                        ";
  protected final String TEXT_120 = ".";
  protected final String TEXT_121 = " = ";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = ";" + NL + "\t                        ";
  protected final String TEXT_124 = NL + "\t                    ";
  protected final String TEXT_125 = ".errorMessage = e.getMessage();" + NL + "\t                    ";
  protected final String TEXT_126 = NL + "\t                    System.err.print(e.getMessage());" + NL + "\t                    ";
  protected final String TEXT_127 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_128 = NL + "            try{" + NL + "\t\tpstmt_";
  protected final String TEXT_129 = ".addBatch();" + NL + "\t\t\t}catch(Exception e)" + NL + "\t\t\t{" + NL + "\t            ";
  protected final String TEXT_130 = NL + "\t                throw(e);" + NL + "\t                ";
  protected final String TEXT_131 = NL + "\t                        ";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = ";" + NL + "\t                        ";
  protected final String TEXT_136 = NL + "\t                    ";
  protected final String TEXT_137 = ".errorMessage = e.getMessage();" + NL + "\t                    ";
  protected final String TEXT_138 = NL + "\t                    System.err.print(e.getMessage());" + NL + "\t                    ";
  protected final String TEXT_139 = NL + "\t\t\t}" + NL + "\t\t}" + NL;
  protected final String TEXT_140 = NL;
  protected final String TEXT_141 = NL + NL + "    try{" + NL + "\t\tpstmt_";
  protected final String TEXT_142 = ".addBatch();" + NL + "\t}catch(Exception e)" + NL + "\t{";
  protected final String TEXT_143 = NL + "            throw(e);";
  protected final String TEXT_144 = NL + "                    ";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = ";";
  protected final String TEXT_149 = NL + "                ";
  protected final String TEXT_150 = ".errorMessage = e.getMessage();";
  protected final String TEXT_151 = NL + "                System.err.print(e.getMessage());";
  protected final String TEXT_152 = NL + "\t}" + NL + "\tif(updatedCount_";
  protected final String TEXT_153 = " == 0) {" + NL + "\t\t";
  protected final String TEXT_154 = NL + "        try{" + NL + "\t\tpstmt_";
  protected final String TEXT_155 = ".addBatch();" + NL + "            nb_line_inserted_";
  protected final String TEXT_156 = "++;" + NL + "\t\t}catch(Exception e)" + NL + "\t\t{";
  protected final String TEXT_157 = NL + "                throw(e);";
  protected final String TEXT_158 = NL + "                        ";
  protected final String TEXT_159 = ".";
  protected final String TEXT_160 = " = ";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = ";";
  protected final String TEXT_163 = NL + "                    ";
  protected final String TEXT_164 = ".errorMessage = e.getMessage();";
  protected final String TEXT_165 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_166 = NL + "\t\t}" + NL + "\t} else {" + NL + "\t    nb_line_update_";
  protected final String TEXT_167 = " ++;" + NL + "\t}" + NL;
  protected final String TEXT_168 = NL + "    try{" + NL + "\t\tpstmt_";
  protected final String TEXT_169 = ".addBatch();" + NL + "\t\t}catch(Exception e)" + NL + "\t\t{";
  protected final String TEXT_170 = NL + "                throw(e);";
  protected final String TEXT_171 = NL + "                        ";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = " = ";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = ";";
  protected final String TEXT_176 = NL + "                    ";
  protected final String TEXT_177 = ".errorMessage = e.getMessage();";
  protected final String TEXT_178 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_179 = NL + "\t\t}" + NL + "\t";
  protected final String TEXT_180 = NL + "\t                ";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = " = ";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = ";" + NL + "\t                ";
  protected final String TEXT_185 = NL + "        commitCounter_";
  protected final String TEXT_186 = "++;" + NL + "        " + NL + "        if(commitEvery_";
  protected final String TEXT_187 = " <= commitCounter_";
  protected final String TEXT_188 = "){" + NL + "        " + NL + "\t\t\tpstmt_";
  protected final String TEXT_189 = ".executeBatch();" + NL + "\t\t\tpstmt_";
  protected final String TEXT_190 = ".clearBatch();" + NL + "        \tcommitCounter_";
  protected final String TEXT_191 = "=0;" + NL + "        \t" + NL + "        }\t" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = "INSERT";
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
            
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String incomingConnName = null;
	List<IMetadataColumn> columnList = null;
	
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		incomingConnName = conn.getName();
	}
	
	List<IMetadataTable> metadatas = node.getMetadataList();
	
	if(metadatas != null && metadatas.size()>0){
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			columnList = metadata.getListColumns();
		}
	}
	
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    List<IMetadataColumn> rejectColumnList = null;
    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    if(metadataTable != null) {
        rejectColumnList = metadataTable.getListColumns();      
    }
    
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

///////////////Inner Class Column///////////////////////////
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

/////////////////Inner Class Operation///////////////////////
class Operation{
	public static final int NORMAL_TYPE = 0;
	public static final int INSERT_TYPE = 1;
	public static final int UPDATE_TYPE = 2;
	
	public String generateType(String typeToGenerate){
		if(typeToGenerate.equals("byte[]")){
 	  		typeToGenerate = "Bytes";
 	   	}else if(typeToGenerate.equals("java.util.Date")){
 	   		typeToGenerate = "Date";
 	  	}else if(typeToGenerate.equals("Integer")){
 	   		typeToGenerate = "Int";
 	   	}else{
			typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
		}
		return typeToGenerate;
	}
	
	public void generateSetStmt(String typeToGenerate,Column column,
								int counter,String incomingConnName,String cid,int stmtType){
		boolean isObject = false;								
		String prefix = null;								
		if(stmtType == Operation.NORMAL_TYPE){
			prefix = "pstmt_";
		}else if(stmtType == Operation.INSERT_TYPE){
			prefix = "pstmtInsert_";
		}else if(stmtType == Operation.UPDATE_TYPE){
			prefix = "pstmtUpdate_";
		}
		
    stringBuffer.append(TEXT_2);
    if(typeToGenerate.equals("Character")){
	isObject = true;
	
    stringBuffer.append(TEXT_3);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_7);
    
	}else if(typeToGenerate.equals("Date")){
	isObject = true;
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_12);
    
	}else if(typeToGenerate.equals("byte[]")){
	isObject = true;
	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_17);
    
	}else if(typeToGenerate.equals("Long")||typeToGenerate.equals("Byte")||typeToGenerate.equals("Integer")||typeToGenerate.equals("Short")){
	isObject = true;
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_22);
    
	}else if(typeToGenerate.equals("String")){
	isObject = true;
	
    stringBuffer.append(TEXT_23);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_27);
    
	}else if(typeToGenerate.equals("Object")){
	isObject = true;
	
    stringBuffer.append(TEXT_28);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_32);
    
	}else if(typeToGenerate.equals("Boolean")){
	isObject = true;
	
    stringBuffer.append(TEXT_33);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_37);
    
	}else if(typeToGenerate.equals("Double")){
	isObject = true;
	
    stringBuffer.append(TEXT_38);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_42);
    
	}else if(typeToGenerate.equals("Float")){
	isObject = true;
	
    stringBuffer.append(TEXT_43);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_47);
    
	}
if(isObject){
	
    stringBuffer.append(TEXT_48);
    
}
	typeToGenerate = generateType(typeToGenerate);
	
	if(typeToGenerate.equals("Char")||typeToGenerate.equals("Character")){
	
    stringBuffer.append(TEXT_49);
    if(isObject){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_52);
    }else{
    stringBuffer.append(TEXT_53);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_66);
    
	}else if(typeToGenerate.equals("Date")){
	
    stringBuffer.append(TEXT_67);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_75);
    
	}else{
	
    stringBuffer.append(TEXT_76);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_81);
    
	}
if(isObject){
	
    stringBuffer.append(TEXT_82);
    
}
	}
}


Operation operation = new Operation();

if(incomingConnName != null && columnList != null){
	if(dataAction.equals("INSERT")){
		int counter = 1;
		
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,0);
			
        	counter++;
		}
	
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_85);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_86);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    
                    }
                    
    stringBuffer.append(TEXT_91);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_92);
    
                } else {
                    
    stringBuffer.append(TEXT_93);
    
                }
            } 
            
    stringBuffer.append(TEXT_94);
    
	}else if(dataAction.equals("UPDATE")){
		int counterCol = 1;
		
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(!column.getColumn().isKey()){
				
				operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,0);
				
        		counterCol++;
			}
		}

		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(column.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,0);
				
        		counterCol++;
			}
		}

	
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_97);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_98);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_102);
    
                    }
                    
    stringBuffer.append(TEXT_103);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_104);
    
                } else {
                    
    stringBuffer.append(TEXT_105);
    
                }
            } 
            
    stringBuffer.append(TEXT_106);
    
	}else if (dataAction.equals("INSERT_OR_UPDATE")){

    stringBuffer.append(TEXT_107);
    
		int columnIndex = 1;
		for(Column column:colStruct)
		{
			if(column.getColumn().isKey())
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
				operation.generateSetStmt(typeToGenerate,column,columnIndex,incomingConnName,cid,0);
				columnIndex++;				
			}
		}

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
			int counterCol = 1;
			for(Column column:colStruct)
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
				if(!column.getColumn().isKey())
				{
					operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,2);
					counterCol++;
				}
			}
			for(Column column:colStruct)
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
				if(column.getColumn().isKey())
				{
					operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,2);					
	        		counterCol++;
				}
			}
			
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
	            if (dieOnError.equals("true")) {
	                
    stringBuffer.append(TEXT_118);
    
	            } else {
	                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
	                    for(IMetadataColumn column : columnList) {
	                        
    stringBuffer.append(TEXT_119);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_123);
    
	                    }
	                    
    stringBuffer.append(TEXT_124);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_125);
    
	                } else {
	                    
    stringBuffer.append(TEXT_126);
    
	                }
	            } 
	            
    stringBuffer.append(TEXT_127);
    
			int counterInsert = 1;
			for(Column columnInsert:colStruct)
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
				operation.generateSetStmt(typeToGenerate,columnInsert,counterInsert,incomingConnName,cid,1);
				counterInsert++;
			}
			
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    
	            if (dieOnError.equals("true")) {
	                
    stringBuffer.append(TEXT_130);
    
	            } else {
	                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
	                    for(IMetadataColumn column : columnList) {
	                        
    stringBuffer.append(TEXT_131);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_135);
    
	                    }
	                    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_137);
    
	                } else {
	                    
    stringBuffer.append(TEXT_138);
    
	                }
	            } 
	            
    stringBuffer.append(TEXT_139);
    
	}else if (dataAction.equals("UPDATE_OR_INSERT")){

    stringBuffer.append(TEXT_140);
    
		int counterColUpdate = 1;
		for(Column columnUpdate:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(!columnUpdate.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,columnUpdate,counterColUpdate,incomingConnName,cid,2);
				
        		counterColUpdate++;
			}
		}

		for(Column columnUpdate:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(columnUpdate.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,columnUpdate,counterColUpdate,incomingConnName,cid,2);
				
        		counterColUpdate++;
			}
		}
	
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
        if (dieOnError.equals("true")) {
            
    stringBuffer.append(TEXT_143);
    
        } else {
            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    
    stringBuffer.append(TEXT_144);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_148);
    
                }
                
    stringBuffer.append(TEXT_149);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_150);
    
            } else {
                
    stringBuffer.append(TEXT_151);
    
            }
        } 
        
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
		int counter = 1;
		
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,1);
			
        	counter++;
		}
		
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_157);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_158);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_162);
    
                    }
                    
    stringBuffer.append(TEXT_163);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_164);
    
                } else {
                    
    stringBuffer.append(TEXT_165);
    
                }
            } 
            
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
	
	}else if (dataAction.equals("DELETE")){
		int keyCounter = 1;
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			//typeToGenerate = operation.generateType(typeToGenerate);
			
			if(column.getColumn().isKey()){
				
				operation.generateSetStmt(typeToGenerate,column,keyCounter,incomingConnName,cid,0);
				
        		keyCounter++;
			}
		}
	
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_170);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_171);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_175);
    
                    }
                    
    stringBuffer.append(TEXT_176);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_177);
    
                } else {
                    
    stringBuffer.append(TEXT_178);
    
                }
            } 
            
    stringBuffer.append(TEXT_179);
    
	}
	
	if(outgoingConns != null && outgoingConns.size() > 0) {
	    for(IConnection outgoingConn : outgoingConns) {
	        if(!outgoingConn.getName().equals(rejectConnName)) {
	            for(IMetadataColumn column : columnList) {
	                
    stringBuffer.append(TEXT_180);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_184);
    	                
	            }
	        }
	    }
	}
	
	////////////commit every////////////
	if(!commitEvery.equals("") && !commitEvery.equals("0")){
	
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
	}
}

    return stringBuffer.toString();
  }
}
