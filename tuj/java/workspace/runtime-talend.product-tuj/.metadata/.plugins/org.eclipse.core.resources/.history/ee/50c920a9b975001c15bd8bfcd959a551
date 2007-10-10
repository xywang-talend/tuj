package org.talend.designer.codegen.translators.databases.mssqlserver;

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

public class TMSSqlOutputMainJava
{
  protected static String nl;
  public static synchronized TMSSqlOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSSqlOutputMainJava result = new TMSSqlOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "if(";
  protected final String TEXT_4 = ".";
  protected final String TEXT_5 = "==null){";
  protected final String TEXT_6 = NL + "    ";
  protected final String TEXT_7 = ".setNull(";
  protected final String TEXT_8 = ",java.sql.Types.CHAR);";
  protected final String TEXT_9 = NL + "if(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "==null){";
  protected final String TEXT_12 = NL + "    ";
  protected final String TEXT_13 = ".setNull(";
  protected final String TEXT_14 = ",java.sql.Types.DATE);";
  protected final String TEXT_15 = NL + "if(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = "==null){";
  protected final String TEXT_18 = NL + "    ";
  protected final String TEXT_19 = ".setNull(";
  protected final String TEXT_20 = ",java.sql.Types.ARRAY);         ";
  protected final String TEXT_21 = NL + "if(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = "==null){";
  protected final String TEXT_24 = NL + "    ";
  protected final String TEXT_25 = ".setNull(";
  protected final String TEXT_26 = ",java.sql.Types.INTEGER);";
  protected final String TEXT_27 = NL + "if(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = "==null){";
  protected final String TEXT_30 = NL + "    ";
  protected final String TEXT_31 = ".setNull(";
  protected final String TEXT_32 = ",java.sql.Types.VARCHAR);";
  protected final String TEXT_33 = NL + "if(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = "==null){";
  protected final String TEXT_36 = NL + "    ";
  protected final String TEXT_37 = ".setNull(";
  protected final String TEXT_38 = ",java.sql.Types.OTHER);";
  protected final String TEXT_39 = NL + "if(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = "==null){";
  protected final String TEXT_42 = NL + "    ";
  protected final String TEXT_43 = ".setNull(";
  protected final String TEXT_44 = ",java.sql.Types.BOOLEAN);   ";
  protected final String TEXT_45 = NL + "if(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = "==null){";
  protected final String TEXT_48 = NL + "    ";
  protected final String TEXT_49 = ".setNull(";
  protected final String TEXT_50 = ",java.sql.Types.DOUBLE);    ";
  protected final String TEXT_51 = NL + "if(";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = "==null){";
  protected final String TEXT_54 = NL + "    ";
  protected final String TEXT_55 = ".setNull(";
  protected final String TEXT_56 = ",java.sql.Types.FLOAT); ";
  protected final String TEXT_57 = NL + NL + "}else{" + NL;
  protected final String TEXT_58 = NL + "    if(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = "==null){";
  protected final String TEXT_61 = NL + "    if(String.valueOf(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ").toLowerCase().equals(\"null\")){";
  protected final String TEXT_64 = NL + "        ";
  protected final String TEXT_65 = ".setNull(";
  protected final String TEXT_66 = ",java.sql.Types.CHAR);" + NL + "        " + NL + "    }else if(";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " == '\\0'){" + NL + "    ";
  protected final String TEXT_69 = NL + "        ";
  protected final String TEXT_70 = ".setString(";
  protected final String TEXT_71 = ",\"\");" + NL + "        " + NL + "    }else{" + NL + "        ";
  protected final String TEXT_72 = NL + "        ";
  protected final String TEXT_73 = ".setString(";
  protected final String TEXT_74 = ",String.valueOf(";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = "));" + NL + "    }";
  protected final String TEXT_77 = NL + "    if(";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = "!=null){" + NL + "    ";
  protected final String TEXT_80 = NL + "        ";
  protected final String TEXT_81 = ".setTimestamp(";
  protected final String TEXT_82 = ",new java.sql.Timestamp(";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = ".getTime()));" + NL + "        " + NL + "    }else{" + NL + "    ";
  protected final String TEXT_85 = NL + "        ";
  protected final String TEXT_86 = ".setNull(";
  protected final String TEXT_87 = ",java.sql.Types.DATE);" + NL + "        " + NL + "    }";
  protected final String TEXT_88 = NL + "    ";
  protected final String TEXT_89 = ".set";
  protected final String TEXT_90 = "(";
  protected final String TEXT_91 = ",";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = NL + "        " + NL + "}" + NL + "    ";
  protected final String TEXT_95 = NL + "    whetherReject_";
  protected final String TEXT_96 = " = false;";
  protected final String TEXT_97 = NL + "        try{" + NL + "            insertedCount_";
  protected final String TEXT_98 = " = insertedCount_";
  protected final String TEXT_99 = " + pstmt_";
  protected final String TEXT_100 = ".executeUpdate();" + NL + "            nb_line_";
  protected final String TEXT_101 = "++;" + NL + "        }catch(Exception e)" + NL + "        {" + NL + "            whetherReject_";
  protected final String TEXT_102 = " = true;";
  protected final String TEXT_103 = NL + "                throw(e);";
  protected final String TEXT_104 = NL + "                        ";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = ";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = ";";
  protected final String TEXT_109 = NL + "                    ";
  protected final String TEXT_110 = ".errorMessage = e.getMessage();";
  protected final String TEXT_111 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_112 = NL + "        }";
  protected final String TEXT_113 = NL + "        try{" + NL + "            updatedCount_";
  protected final String TEXT_114 = " = updatedCount_";
  protected final String TEXT_115 = " + pstmt_";
  protected final String TEXT_116 = ".executeUpdate();" + NL + "            nb_line_";
  protected final String TEXT_117 = "++;" + NL + "        }catch(Exception e)" + NL + "        {" + NL + "            whetherReject_";
  protected final String TEXT_118 = " = true;";
  protected final String TEXT_119 = NL + "                throw(e);";
  protected final String TEXT_120 = NL + "                        ";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = ";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = ";";
  protected final String TEXT_125 = NL + "                    ";
  protected final String TEXT_126 = ".errorMessage = e.getMessage();";
  protected final String TEXT_127 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_128 = NL + "        }";
  protected final String TEXT_129 = NL;
  protected final String TEXT_130 = NL + NL + "        java.sql.ResultSet rs_";
  protected final String TEXT_131 = " = pstmt_";
  protected final String TEXT_132 = ".executeQuery();" + NL + "        int checkCount_";
  protected final String TEXT_133 = " = -1;" + NL + "        while(rs_";
  protected final String TEXT_134 = ".next())" + NL + "        {" + NL + "            checkCount_";
  protected final String TEXT_135 = " = rs_";
  protected final String TEXT_136 = ".getInt(1);" + NL + "        }" + NL + "        if(checkCount_";
  protected final String TEXT_137 = " > 0)" + NL + "        {";
  protected final String TEXT_138 = NL + "            try{" + NL + "                updatedCount_";
  protected final String TEXT_139 = " = updatedCount_";
  protected final String TEXT_140 = " + pstmtUpdate_";
  protected final String TEXT_141 = ".executeUpdate();" + NL + "            }catch(Exception e)" + NL + "            {" + NL + "                whetherReject_";
  protected final String TEXT_142 = " = true;";
  protected final String TEXT_143 = NL + "                    throw(e);";
  protected final String TEXT_144 = NL + "                            ";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = ";";
  protected final String TEXT_149 = NL + "                        ";
  protected final String TEXT_150 = ".errorMessage = e.getMessage();";
  protected final String TEXT_151 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_152 = NL + "            }" + NL + "        }" + NL + "        else" + NL + "        {";
  protected final String TEXT_153 = NL + "            try{" + NL + "                insertedCount_";
  protected final String TEXT_154 = " = insertedCount_";
  protected final String TEXT_155 = " + pstmtInsert_";
  protected final String TEXT_156 = ".executeUpdate();" + NL + "            }catch(Exception e)" + NL + "            {" + NL + "                whetherReject_";
  protected final String TEXT_157 = " = true;";
  protected final String TEXT_158 = NL + "                    throw(e);";
  protected final String TEXT_159 = NL + "                            ";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = ";";
  protected final String TEXT_164 = NL + "                        ";
  protected final String TEXT_165 = ".errorMessage = e.getMessage();";
  protected final String TEXT_166 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_167 = NL + "            }" + NL + "        }" + NL + "        nb_line_";
  protected final String TEXT_168 = "++;";
  protected final String TEXT_169 = NL + "int updateFlag_";
  protected final String TEXT_170 = "=0;";
  protected final String TEXT_171 = NL + "    " + NL + "        try{" + NL + "            updateFlag_";
  protected final String TEXT_172 = "=pstmtUpdate_";
  protected final String TEXT_173 = ".executeUpdate();" + NL + "            updatedCount_";
  protected final String TEXT_174 = " = updatedCount_";
  protected final String TEXT_175 = "+updateFlag_";
  protected final String TEXT_176 = ";" + NL + "        }catch(Exception e)" + NL + "        {" + NL + "            whetherReject_";
  protected final String TEXT_177 = " = true;";
  protected final String TEXT_178 = NL + "                throw(e);";
  protected final String TEXT_179 = NL + "                        ";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = ";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = ";";
  protected final String TEXT_184 = NL + "                    ";
  protected final String TEXT_185 = ".errorMessage = e.getMessage();";
  protected final String TEXT_186 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_187 = NL + "        }" + NL + "        if(updateFlag_";
  protected final String TEXT_188 = " == 0)" + NL + "        {";
  protected final String TEXT_189 = NL + "            try{" + NL + "                insertedCount_";
  protected final String TEXT_190 = " = insertedCount_";
  protected final String TEXT_191 = " + pstmtInsert_";
  protected final String TEXT_192 = ".executeUpdate(); " + NL + "            }catch(Exception e)" + NL + "            {" + NL + "                whetherReject_";
  protected final String TEXT_193 = " = true;";
  protected final String TEXT_194 = NL + "                    throw(e);";
  protected final String TEXT_195 = NL + "                            ";
  protected final String TEXT_196 = ".";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = ";";
  protected final String TEXT_200 = NL + "                        ";
  protected final String TEXT_201 = ".errorMessage = e.getMessage();";
  protected final String TEXT_202 = NL + "                        System.err.print(e.getMessage());";
  protected final String TEXT_203 = NL + "            }" + NL + "        }" + NL + "       " + NL + "        nb_line_";
  protected final String TEXT_204 = "++;";
  protected final String TEXT_205 = NL + "        try{" + NL + "            deletedCount_";
  protected final String TEXT_206 = " = deletedCount_";
  protected final String TEXT_207 = " + pstmt_";
  protected final String TEXT_208 = ".executeUpdate();" + NL + "        }catch(Exception e)" + NL + "        {" + NL + "            whetherReject_";
  protected final String TEXT_209 = " = true;";
  protected final String TEXT_210 = NL + "                throw(e);";
  protected final String TEXT_211 = NL + "                        ";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = ";
  protected final String TEXT_214 = ".";
  protected final String TEXT_215 = ";";
  protected final String TEXT_216 = NL + "                    ";
  protected final String TEXT_217 = ".errorMessage = e.getMessage();";
  protected final String TEXT_218 = NL + "                    System.err.print(e.getMessage());";
  protected final String TEXT_219 = NL + "        }" + NL + "        nb_line_";
  protected final String TEXT_220 = "++;";
  protected final String TEXT_221 = NL + "        if(!whetherReject_";
  protected final String TEXT_222 = ") {";
  protected final String TEXT_223 = NL + "                            ";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = " = ";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = ";";
  protected final String TEXT_228 = NL + "        }";
  protected final String TEXT_229 = NL + "        commitCounter_";
  protected final String TEXT_230 = "++;" + NL + "        " + NL + "        if(commitEvery_";
  protected final String TEXT_231 = "<=commitCounter_";
  protected final String TEXT_232 = "){" + NL + "        " + NL + "            conn_";
  protected final String TEXT_233 = ".commit();" + NL + "            " + NL + "            commitCounter_";
  protected final String TEXT_234 = "=0;" + NL + "        " + NL + "        }" + NL + "    ";

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
    stringBuffer.append(TEXT_6);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_8);
    
    }else if(typeToGenerate.equals("Date")){
    isObject = true;
    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_14);
    
    }else if(typeToGenerate.equals("byte[]")){
    isObject = true;
    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_20);
    
    }else if(typeToGenerate.equals("Long")||typeToGenerate.equals("Byte")||typeToGenerate.equals("Integer")||typeToGenerate.equals("Short")){
    isObject = true;
    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_26);
    
    }else if(typeToGenerate.equals("String")){
    isObject = true;
    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_32);
    
    }else if(typeToGenerate.equals("Object")){
    isObject = true;
    
    stringBuffer.append(TEXT_33);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_38);
    
    }else if(typeToGenerate.equals("Boolean")){
    isObject = true;
    
    stringBuffer.append(TEXT_39);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_44);
    
    }else if(typeToGenerate.equals("Double")){
    isObject = true;
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_50);
    
    }else if(typeToGenerate.equals("Float")){
    isObject = true;
    
    stringBuffer.append(TEXT_51);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_56);
    
    }
if(isObject){
    
    stringBuffer.append(TEXT_57);
    
}
    typeToGenerate = generateType(typeToGenerate);
    
    if(typeToGenerate.equals("Char")||typeToGenerate.equals("Character")){
    
    if(isObject){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_60);
    }else{
    stringBuffer.append(TEXT_61);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_76);
    
    }else if(typeToGenerate.equals("Date")){
    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_87);
    
    }else{
    
    stringBuffer.append(TEXT_88);
    stringBuffer.append(prefix+cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getName());
    stringBuffer.append(TEXT_93);
    
    }
if(isObject){
    
    stringBuffer.append(TEXT_94);
    
}
    }
}


Operation operation = new Operation();

if(incomingConnName != null && columnList != null){
    
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
        
    if(dataAction.equals("INSERT")){
        int counter = 1;
        
        for(Column column:colStruct){
            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
            
            //typeToGenerate = operation.generateType(typeToGenerate);
            
            operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,0);
            
            counter++;
        }
    
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_103);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_104);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_108);
    
                    }
                    
    stringBuffer.append(TEXT_109);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_110);
    
                } else {
                    
    stringBuffer.append(TEXT_111);
    
                }
            } 
            
    stringBuffer.append(TEXT_112);
    
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

    
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_119);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_120);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_124);
    
                    }
                    
    stringBuffer.append(TEXT_125);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_126);
    
                } else {
                    
    stringBuffer.append(TEXT_127);
    
                }
            } 
            
    stringBuffer.append(TEXT_128);
    
    }else if (dataAction.equals("INSERT_OR_UPDATE")){

    stringBuffer.append(TEXT_129);
    
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

    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
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
            
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
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
    
            int counterInsert = 1;
            for(Column columnInsert:colStruct)
            {
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(columnInsert.getColumn().getTalendType(), columnInsert.getColumn().isNullable());
                operation.generateSetStmt(typeToGenerate,columnInsert,counterInsert,incomingConnName,cid,1);
                counterInsert++;
            }
            
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
                if (dieOnError.equals("true")) {
                    
    stringBuffer.append(TEXT_158);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_159);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_163);
    
                        }
                        
    stringBuffer.append(TEXT_164);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_165);
    
                    } else {
                        
    stringBuffer.append(TEXT_166);
    
                    }
                } 
                
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    
    }else if (dataAction.equals("UPDATE_OR_INSERT")){

    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
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
    
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_178);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_179);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_183);
    
                    }
                    
    stringBuffer.append(TEXT_184);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_185);
    
                } else {
                    
    stringBuffer.append(TEXT_186);
    
                }
            } 
            
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
            int counter = 1;
            
            for(Column column:colStruct){
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getColumn().getTalendType(), column.getColumn().isNullable());
                
                //typeToGenerate = operation.generateType(typeToGenerate);
                
                operation.generateSetStmt(typeToGenerate,column,counter,incomingConnName,cid,1);
                
                counter++;
            }
            
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
                if (dieOnError.equals("true")) {
                    
    stringBuffer.append(TEXT_194);
    
                } else {
                    if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_195);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_199);
    
                        }
                        
    stringBuffer.append(TEXT_200);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_201);
    
                    } else {
                        
    stringBuffer.append(TEXT_202);
    
                    }
                } 
                
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
    
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
    
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
            if (dieOnError.equals("true")) {
                
    stringBuffer.append(TEXT_210);
    
            } else {
                if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_211);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_215);
    
                    }
                    
    stringBuffer.append(TEXT_216);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_217);
    
                } else {
                    
    stringBuffer.append(TEXT_218);
    
                }
            } 
            
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
    }
    
    if(outgoingConns != null && outgoingConns.size() > 0) {
        
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
            for(IConnection outgoingConn : outgoingConns) {
                if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                    if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                        for(IMetadataColumn column : columnList) {
                            
    stringBuffer.append(TEXT_223);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_227);
                      
                        }
                    }
                }
            }
        
    stringBuffer.append(TEXT_228);
    
    }    
    
    ////////////commit every////////////
    if(!commitEvery.equals("")&&!commitEvery.equals("0")){
    
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
    }
}

    return stringBuffer.toString();
  }
}
