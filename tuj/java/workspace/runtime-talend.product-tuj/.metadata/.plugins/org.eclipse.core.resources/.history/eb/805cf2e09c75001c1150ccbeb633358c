package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TMysqlOutputMainJava
{
  protected static String nl;
  public static synchronized TMysqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlOutputMainJava result = new TMysqlOutputMainJava();
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
  protected final String TEXT_69 = "!=null){" + NL + "\t\t// timestamp < min java date value (year 1) || timestamp > max mysql value (year 10000) => set 0000-00-00 as date in MySQL" + NL + "\t\tdate_";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ".getTime();" + NL + "\t\tif (date_";
  protected final String TEXT_73 = " < year1_";
  protected final String TEXT_74 = " || date_";
  protected final String TEXT_75 = " >= year10000_";
  protected final String TEXT_76 = ") {" + NL + "\t\t\t";
  protected final String TEXT_77 = ".setString(";
  protected final String TEXT_78 = ", \"0000-00-00 00:00:00\");" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_79 = ".setTimestamp(";
  protected final String TEXT_80 = ", new java.sql.Timestamp(date_";
  protected final String TEXT_81 = "));" + NL + "\t\t}" + NL + "\t}else{" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_82 = ".setNull(";
  protected final String TEXT_83 = ",java.sql.Types.DATE);" + NL + "\t\t" + NL + "\t}" + NL + "\t";
  protected final String TEXT_84 = NL + "\t";
  protected final String TEXT_85 = ".set";
  protected final String TEXT_86 = "(";
  protected final String TEXT_87 = ",";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = ");" + NL + "\t";
  protected final String TEXT_90 = NL + "\t\t" + NL + "}" + NL + "\t";
  protected final String TEXT_91 = NL + "    whetherReject_";
  protected final String TEXT_92 = " = false;";
  protected final String TEXT_93 = NL + "    try{" + NL + "        insertedCount_";
  protected final String TEXT_94 = " = insertedCount_";
  protected final String TEXT_95 = " + pstmt_";
  protected final String TEXT_96 = ".executeUpdate();" + NL + "        nb_line_";
  protected final String TEXT_97 = "++;" + NL + "    }catch(Exception e)" + NL + "    {" + NL + "        whetherReject_";
  protected final String TEXT_98 = " = true;";
  protected final String TEXT_99 = NL + "            throw(e);";
  protected final String TEXT_100 = NL + "                    ";
  protected final String TEXT_101 = ".";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = ";";
  protected final String TEXT_105 = NL + "                ";
  protected final String TEXT_106 = ".errorMessage = e.getMessage();";
  protected final String TEXT_107 = NL + "                System.err.print(e.getMessage());";
  protected final String TEXT_108 = NL + "    }" + NL + "\t";
  protected final String TEXT_109 = NL + "        try{" + NL + "            updatedCount_";
  protected final String TEXT_110 = " = updatedCount_";
  protected final String TEXT_111 = " + pstmt_";
  protected final String TEXT_112 = ".executeUpdate();" + NL + "            nb_line_";
  protected final String TEXT_113 = "++;" + NL + "        }catch(Exception e)" + NL + "        {" + NL + "            whetherReject_";
  protected final String TEXT_114 = " = true;";
  protected final String TEXT_115 = NL + "                throw(e);";
  protected final String TEXT_116 = NL + "                        ";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = ";";
  protected final String TEXT_121 = NL + "                    ";
  protected final String TEXT_122 = ".errorMessage = e.getMessage();";
  protected final String TEXT_123 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_124 = NL + "        }";
  protected final String TEXT_125 = NL;
  protected final String TEXT_126 = NL + NL + "\t\tjava.sql.ResultSet rs_";
  protected final String TEXT_127 = " = pstmt_";
  protected final String TEXT_128 = ".executeQuery();" + NL + "\t\tint checkCount_";
  protected final String TEXT_129 = " = -1;" + NL + "\t\twhile(rs_";
  protected final String TEXT_130 = ".next())" + NL + "\t\t{" + NL + "\t\t\tcheckCount_";
  protected final String TEXT_131 = " = rs_";
  protected final String TEXT_132 = ".getInt(1);" + NL + "\t\t}" + NL + "\t\tif(checkCount_";
  protected final String TEXT_133 = " > 0)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_134 = NL + "            try{" + NL + "                updatedCount_";
  protected final String TEXT_135 = " = updatedCount_";
  protected final String TEXT_136 = " + pstmtUpdate_";
  protected final String TEXT_137 = ".executeUpdate();" + NL + "            }catch(Exception e)" + NL + "            {" + NL + "                whetherReject_";
  protected final String TEXT_138 = " = true;";
  protected final String TEXT_139 = NL + "                    throw(e);";
  protected final String TEXT_140 = NL + "                            ";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = ";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = ";";
  protected final String TEXT_145 = NL + "                        ";
  protected final String TEXT_146 = ".errorMessage = e.getMessage();";
  protected final String TEXT_147 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_148 = NL + "            }" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_149 = NL + "            try{" + NL + "                insertedCount_";
  protected final String TEXT_150 = " = insertedCount_";
  protected final String TEXT_151 = " + pstmtInsert_";
  protected final String TEXT_152 = ".executeUpdate();" + NL + "            }catch(Exception e)" + NL + "            {" + NL + "                whetherReject_";
  protected final String TEXT_153 = " = true;";
  protected final String TEXT_154 = NL + "                    throw(e);";
  protected final String TEXT_155 = NL + "                            ";
  protected final String TEXT_156 = ".";
  protected final String TEXT_157 = " = ";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = ";";
  protected final String TEXT_160 = NL + "                        ";
  protected final String TEXT_161 = ".errorMessage = e.getMessage();";
  protected final String TEXT_162 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_163 = NL + "            }" + NL + "\t\t}" + NL + "\t\tnb_line_";
  protected final String TEXT_164 = "++;";
  protected final String TEXT_165 = NL + "int updateFlag_";
  protected final String TEXT_166 = "=0;";
  protected final String TEXT_167 = NL + "\t" + NL + "        try{" + NL + "            updateFlag_";
  protected final String TEXT_168 = "=pstmtUpdate_";
  protected final String TEXT_169 = ".executeUpdate();" + NL + "            updatedCount_";
  protected final String TEXT_170 = " = updatedCount_";
  protected final String TEXT_171 = "+updateFlag_";
  protected final String TEXT_172 = ";" + NL + "            " + NL + "        }catch(Exception e)" + NL + "        {" + NL + "            whetherReject_";
  protected final String TEXT_173 = " = true;";
  protected final String TEXT_174 = NL + "                throw(e);";
  protected final String TEXT_175 = NL + "                        ";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " = ";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = ";";
  protected final String TEXT_180 = NL + "                    ";
  protected final String TEXT_181 = ".errorMessage = e.getMessage();";
  protected final String TEXT_182 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_183 = NL + "        }" + NL + "        if(updateFlag_";
  protected final String TEXT_184 = " == 0) {" + NL + "    \t\t";
  protected final String TEXT_185 = NL + "            try{" + NL + "                insertedCount_";
  protected final String TEXT_186 = " = insertedCount_";
  protected final String TEXT_187 = " + pstmtInsert_";
  protected final String TEXT_188 = ".executeUpdate();" + NL + "            }catch(Exception e)" + NL + "            {" + NL + "                whetherReject_";
  protected final String TEXT_189 = " = true;";
  protected final String TEXT_190 = NL + "                    throw(e);";
  protected final String TEXT_191 = NL + "                            ";
  protected final String TEXT_192 = ".";
  protected final String TEXT_193 = " = ";
  protected final String TEXT_194 = ".";
  protected final String TEXT_195 = ";";
  protected final String TEXT_196 = NL + "                        ";
  protected final String TEXT_197 = ".errorMessage = e.getMessage();";
  protected final String TEXT_198 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_199 = NL + "            }" + NL + "        }" + NL + "        nb_line_";
  protected final String TEXT_200 = "++;";
  protected final String TEXT_201 = NL + "    try{" + NL + "\t    deletedCount_";
  protected final String TEXT_202 = " = deletedCount_";
  protected final String TEXT_203 = " + pstmt_";
  protected final String TEXT_204 = ".executeUpdate();" + NL + "    }catch(Exception e)" + NL + "    {" + NL + "        whetherReject_";
  protected final String TEXT_205 = " = true;";
  protected final String TEXT_206 = NL + "            throw(e);";
  protected final String TEXT_207 = NL + "                    ";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = " = ";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = ";";
  protected final String TEXT_212 = NL + "                ";
  protected final String TEXT_213 = ".errorMessage = e.getMessage();";
  protected final String TEXT_214 = NL + "                System.err.print(e.getMessage());";
  protected final String TEXT_215 = NL + "    }" + NL + "    nb_line_";
  protected final String TEXT_216 = "++;" + NL + "\t";
  protected final String TEXT_217 = NL + "        if(!whetherReject_";
  protected final String TEXT_218 = ") {";
  protected final String TEXT_219 = NL + "                            ";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = " = ";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = ";";
  protected final String TEXT_224 = NL + "        }";
  protected final String TEXT_225 = NL + "    \t    commitCounter_";
  protected final String TEXT_226 = "++;" + NL + "    " + NL + "            if(commitEvery_";
  protected final String TEXT_227 = " <= commitCounter_";
  protected final String TEXT_228 = "){" + NL + "            " + NL + "            \tconn_";
  protected final String TEXT_229 = ".commit();" + NL + "            \t" + NL + "            \tcommitCounter_";
  protected final String TEXT_230 = "=0;" + NL + "            " + NL + "            }\t" + NL + "" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	
	List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ADD_COLS__");
            
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    
    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	
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
					Column insertAfter = new Column(addCol.get("NAME"),addCol.get("SQL"),true);
					stmtStructure.add(stmtIndex+1,insertAfter);
				}else if(addCol.get("POS").equals("BEFORE")){
					Column insertBefore = new Column(addCol.get("NAME"),addCol.get("SQL"),true);
					stmtStructure.add(stmtIndex,insertBefore);
				}else if(addCol.get("POS").equals("REPLACE")){
					Column replacementCol = new Column(addCol.get("NAME"),addCol.get("SQL"),true);
					Column replacedCol = (Column) stmtStructure.get(stmtIndex);
					replacedCol.replace(replacementCol);
				}
			}
		}
	}
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
 	   	}else if(typeToGenerate.equals("List")){  
 	   	    typeToGenerate = "Object";                 
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_83);
    
	}else{
	
    stringBuffer.append(TEXT_84);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_89);
    
	}
if(isObject){
	
    stringBuffer.append(TEXT_90);
    
}
	}
}


Operation operation = new Operation();

if(incomingConnName != null && columnList != null){
    
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    	
    if(dataAction.equals("INSERT")){
		int counter = 1;
		
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,0);
			
        	counter++;
		}
	
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
        if (dieOnError.equals("true")) {
            
    stringBuffer.append(TEXT_99);
    
        } else {
            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    
    stringBuffer.append(TEXT_100);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_104);
    
                }
                
    stringBuffer.append(TEXT_105);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_106);
    
            } else {
                
    stringBuffer.append(TEXT_107);
    
            }
        } 
        
    stringBuffer.append(TEXT_108);
    
	}else if(dataAction.equals("UPDATE")){
		int counterCol = 1;
		
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			if(!column.getColumn().isKey()){
				
				operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,0);
				
        		counterCol++;
			}
		}

		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			if(column.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,column,counterCol,incomingConnName,cid,0);
				
        		counterCol++;
			}
		}

	
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_115);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_116);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_120);
    
                    }
                    
    stringBuffer.append(TEXT_121);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_122);
    
                } else {
                    
    stringBuffer.append(TEXT_123);
    
                }
            } 
            
    stringBuffer.append(TEXT_124);
    
	}else if (dataAction.equals("INSERT_OR_UPDATE")){

    stringBuffer.append(TEXT_125);
    
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

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
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
			
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
                if (dieOnError.equals("true")) {
                    
    stringBuffer.append(TEXT_139);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_140);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_144);
    
                        }
                        
    stringBuffer.append(TEXT_145);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_146);
    
                    } else {
                        
    stringBuffer.append(TEXT_147);
    
                    }
                } 
                
    stringBuffer.append(TEXT_148);
    
			int counterInsert = 1;
			for(Column columnInsert:colStruct)
			{
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
				operation.generateSetStmt(typeToGenerate,columnInsert,counterInsert,incomingConnName,cid,1);
				counterInsert++;
			}
			
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
                if (dieOnError.equals("true")) {
                    
    stringBuffer.append(TEXT_154);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_155);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_159);
    
                        }
                        
    stringBuffer.append(TEXT_160);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_161);
    
                    } else {
                        
    stringBuffer.append(TEXT_162);
    
                    }
                } 
                
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
	}else if (dataAction.equals("UPDATE_OR_INSERT")){

    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
		int counterColUpdate = 1;
		for(Column columnUpdate:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
			
			if(!columnUpdate.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,columnUpdate,counterColUpdate,incomingConnName,cid,2);
				
        		counterColUpdate++;
			}
		}

		for(Column columnUpdate:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnUpdate.getColumn().getTalendType(), columnUpdate.getColumn().isNullable());
			
			if(columnUpdate.getColumn().isKey()){
			
				operation.generateSetStmt(typeToGenerate,columnUpdate,counterColUpdate,incomingConnName,cid,2);
				
        		counterColUpdate++;
			}
		}
	
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_174);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_175);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_179);
    
                    }
                    
    stringBuffer.append(TEXT_180);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_181);
    
                } else {
                    
    stringBuffer.append(TEXT_182);
    
                }
            } 
            
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
    		int counter = 1;
    		
    		for(Column column:colStruct){
    			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
    			
    			operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,1);
    			
            	counter++;
    		}
    		
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
                if (dieOnError.equals("true")) {
                    
    stringBuffer.append(TEXT_190);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_191);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_195);
    
                        }
                        
    stringBuffer.append(TEXT_196);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_197);
    
                    } else {
                        
    stringBuffer.append(TEXT_198);
    
                    }
                } 
                
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
	
	}else if (dataAction.equals("DELETE")){
		int keyCounter = 1;
		for(Column column:colStruct){
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
			
			if(column.getColumn().isKey()){
				
				operation.generateSetStmt(typeToGenerate,column,keyCounter,incomingConnName,cid,0);
				
        		keyCounter++;
			}
		}
	
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
        if (dieOnError.equals("true")) {
            
    stringBuffer.append(TEXT_206);
    
        } else {
            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    
    stringBuffer.append(TEXT_207);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_211);
    
                }
                
    stringBuffer.append(TEXT_212);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_213);
    
            } else {
                
    stringBuffer.append(TEXT_214);
    
            }
        } 
        
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    
	}
	
    if(outgoingConns != null && outgoingConns.size() > 0) {
        
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    
            for(IConnection outgoingConn : outgoingConns) {
                if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                    if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_219);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_223);
                      
                        }
                    }
                }
            }
        
    stringBuffer.append(TEXT_224);
    
    }	
	
	////////////commit every////////////
	if(!useExistingConn.equals("true"))
	{
		if(!commitEvery.equals("")&&!commitEvery.equals("0")){
	
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
		}
	}
}

    return stringBuffer.toString();
  }
}
