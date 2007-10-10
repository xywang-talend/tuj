package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.builder.database.ExtractMetaDataUtils;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.talend.commons.utils.StringUtils;

public class TOracleSCDBeginJava
{
  protected static String nl;
  public static synchronized TOracleSCDBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleSCDBeginJava result = new TOracleSCDBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tjava.sql.Connection connection_";
  protected final String TEXT_3 = " = (java.sql.Connection) globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "\t\t";
  protected final String TEXT_5 = NL + "\t\tjava.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tString connectionString_";
  protected final String TEXT_7 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_8 = " + \":\" + ";
  protected final String TEXT_9 = " + \":\" + ";
  protected final String TEXT_10 = ";" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\tString connectionString_";
  protected final String TEXT_12 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_13 = " + \")(port=\" + ";
  protected final String TEXT_14 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_15 = " + \")))\";" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\tjava.sql.Connection connection_";
  protected final String TEXT_17 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ");" + NL + "\t\t";
  protected final String TEXT_21 = NL + "        \t// Error: same column defined for current and previous value (field ";
  protected final String TEXT_22 = ")" + NL + "        \t";
  protected final String TEXT_23 = NL + "    java.sql.Timestamp timestamp_";
  protected final String TEXT_24 = ";" + NL + "\tString value_";
  protected final String TEXT_25 = ";" + NL + "\t" + NL + "    // Source keys" + NL + "    class SCDSK_";
  protected final String TEXT_26 = " {" + NL + "    \tprivate int hashCode;" + NL + "    \tpublic boolean hashCodeDirty = true;" + NL + "    \t";
  protected final String TEXT_27 = NL + "\t\t        \tprivate ";
  protected final String TEXT_28 = " ";
  protected final String TEXT_29 = ";" + NL + "\t\t        \t";
  protected final String TEXT_30 = NL + "\t    " + NL + "\t    public boolean equals(Object o) {" + NL + "\t    \tif (!(o instanceof SCDSK_";
  protected final String TEXT_31 = ")) {" + NL + "\t    \t\treturn false;" + NL + "\t    \t}" + NL + "\t    \t" + NL + "\t    \tSCDSK_";
  protected final String TEXT_32 = " sk = (SCDSK_";
  protected final String TEXT_33 = ") o;" + NL + "\t    \t" + NL + "\t    \treturn ";
  protected final String TEXT_34 = " && ";
  protected final String TEXT_35 = ".equals(sk.";
  protected final String TEXT_36 = ")";
  protected final String TEXT_37 = " == sk.";
  protected final String TEXT_38 = ";" + NL + "\t    }" + NL + "\t    " + NL + "\t    public int hashCode() {" + NL + "\t    \tif (hashCodeDirty) {" + NL + "\t\t    \tint prime = 31;" + NL + "\t\t    \thashCode = 0;" + NL + "\t\t    \t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t    \t\thashCode = prime * hashCode + (";
  protected final String TEXT_40 = " == null ? 0 : ";
  protected final String TEXT_41 = ".hashCode());" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t    \t\thashCode = prime * hashCode + ";
  protected final String TEXT_43 = ";" + NL + "\t\t\t\t\t    \t\t";
  protected final String TEXT_44 = NL + "\t\t\t\thashCodeDirty = false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\treturn hashCode;" + NL + "\t    }" + NL + "    }" + NL + "    " + NL + "    // Lookup cache structure" + NL + "\tclass SCDStruct_";
  protected final String TEXT_45 = " {" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\t        \tprivate ";
  protected final String TEXT_47 = " ";
  protected final String TEXT_48 = ";" + NL + "\t\t        \t";
  protected final String TEXT_49 = NL + "\t\t\t\t\tprivate ";
  protected final String TEXT_50 = " ";
  protected final String TEXT_51 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t}" + NL + "\t";
  protected final String TEXT_53 = NL + "    // Retrieve active records" + NL + "    String dbquery_";
  protected final String TEXT_54 = " = \"SELECT ";
  protected final String TEXT_55 = " FROM \" + ";
  protected final String TEXT_56 = NL + "\t\t\t+ \" WHERE ";
  protected final String TEXT_57 = " IS NULL\"" + NL + "\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t+ \" WHERE EXTRACT(YEAR FROM ";
  protected final String TEXT_59 = ") = \" + ";
  protected final String TEXT_60 = NL + "\t\t\t";
  protected final String TEXT_61 = ";" + NL + "\tjava.sql.Statement statement_";
  protected final String TEXT_62 = " = connection_";
  protected final String TEXT_63 = ".createStatement();" + NL + "\tjava.sql.ResultSet resultSet_";
  protected final String TEXT_64 = " = statement_";
  protected final String TEXT_65 = ".executeQuery(dbquery_";
  protected final String TEXT_66 = ");" + NL + "\t" + NL + "    // Build lookup cache" + NL + "    java.util.HashMap<SCDSK_";
  protected final String TEXT_67 = ", SCDStruct_";
  protected final String TEXT_68 = "> cache_";
  protected final String TEXT_69 = " = new java.util.HashMap<SCDSK_";
  protected final String TEXT_70 = ", SCDStruct_";
  protected final String TEXT_71 = ">();" + NL + "\t" + NL + "\twhile (resultSet_";
  protected final String TEXT_72 = ".next()) {" + NL + "\t\tSCDSK_";
  protected final String TEXT_73 = " sk_";
  protected final String TEXT_74 = " = new SCDSK_";
  protected final String TEXT_75 = "();" + NL + "\t\tSCDStruct_";
  protected final String TEXT_76 = " row_";
  protected final String TEXT_77 = " = new SCDStruct_";
  protected final String TEXT_78 = "();" + NL + "\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\tvalue_";
  protected final String TEXT_80 = " = resultSet_";
  protected final String TEXT_81 = ".getString(";
  protected final String TEXT_82 = ");" + NL + "\t\t\t\t  \tif (value_";
  protected final String TEXT_83 = " != null && value_";
  protected final String TEXT_84 = ".length() > 0) {" + NL + "\t\t\t\t  \t\t";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = resultSet_";
  protected final String TEXT_87 = ".getString(";
  protected final String TEXT_88 = ").charAt(0);" + NL + "\t\t\t\t  \t} else {" + NL + "\t\t\t\t  \t    ";
  protected final String TEXT_89 = NL + "\t\t\t\t  \t    \tif (value_";
  protected final String TEXT_90 = " == null) {" + NL + "\t\t\t\t  \t   \t\t\t";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = null;" + NL + "\t\t\t\t\t  \t\t} else {" + NL + "\t\t\t\t\t  \t\t\t";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = " = '\\0';" + NL + "\t\t\t\t\t  \t\t}" + NL + "\t\t\t\t  \t\t\t";
  protected final String TEXT_95 = NL + "\t\t\t\t\t  \t\tif (value_";
  protected final String TEXT_96 = ".equals(\"\")) {" + NL + "\t\t\t\t  \t\t\t\t";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " = '\\0';" + NL + "\t\t\t\t  \t\t\t} else {" + NL + "\t\t\t\t\t  \t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_99 = "', value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t  \t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t  \t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t\t\t\ttimestamp_";
  protected final String TEXT_102 = " = resultSet_";
  protected final String TEXT_103 = ".getTimestamp(";
  protected final String TEXT_104 = ");" + NL + "\t\t\t\t\tif (timestamp_";
  protected final String TEXT_105 = " != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " = new java.util.Date(timestamp_";
  protected final String TEXT_108 = ".getTime());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = null;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t \t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\tif (resultSet_";
  protected final String TEXT_112 = ".getObject(";
  protected final String TEXT_113 = ") != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = resultSet_";
  protected final String TEXT_116 = ".get";
  protected final String TEXT_117 = "(";
  protected final String TEXT_118 = ");" + NL + " \t\t\t \t\t}" + NL + " \t\t\t\t\t";
  protected final String TEXT_119 = NL + "\t    " + NL + "        cache_";
  protected final String TEXT_120 = ".put(sk_";
  protected final String TEXT_121 = ", row_";
  protected final String TEXT_122 = ");" + NL + "\t}" + NL + "\t" + NL + "\tstatement_";
  protected final String TEXT_123 = ".close();" + NL + "\t" + NL + "\t";
  protected final String TEXT_124 = NL + "\t            ";
  protected final String TEXT_125 = " nextSurrogateKey_";
  protected final String TEXT_126 = " = 1;" + NL + "\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\tif (cache_";
  protected final String TEXT_128 = ".size() > 0) {" + NL + "\t\t\t// Get table max value for surrogate key" + NL + "\t\t\tdbquery_";
  protected final String TEXT_129 = " = \"SELECT MAX(";
  protected final String TEXT_130 = ") FROM \" + ";
  protected final String TEXT_131 = ";" + NL + "\t\t\tstatement_";
  protected final String TEXT_132 = " = connection_";
  protected final String TEXT_133 = ".createStatement();" + NL + "\t\t\tresultSet_";
  protected final String TEXT_134 = " = statement_";
  protected final String TEXT_135 = ".executeQuery(dbquery_";
  protected final String TEXT_136 = ");" + NL + "\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\tif (resultSet_";
  protected final String TEXT_138 = ".next() && resultSet_";
  protected final String TEXT_139 = ".getObject(1) != null) {" + NL + "\t\t\t\t\t\tnextSurrogateKey_";
  protected final String TEXT_140 = " = resultSet_";
  protected final String TEXT_141 = ".get";
  protected final String TEXT_142 = "(1) + 1;" + NL + "\t \t\t\t \t}" + NL + "\t \t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t" + NL + "\t\t\tstatement_";
  protected final String TEXT_144 = ".close();" + NL + "\t    }" + NL + "\t    ";
  protected final String TEXT_145 = NL + "\t\tSystem.out.println(\"[";
  protected final String TEXT_146 = "] comparison cache loaded\");" + NL + "\t\t";
  protected final String TEXT_147 = NL + "    // Build prepared statements" + NL + "    String insertQueryString_";
  protected final String TEXT_148 = " = \"INSERT INTO \" + ";
  protected final String TEXT_149 = " + \" (";
  protected final String TEXT_150 = ") \" +" + NL + "    \t\"VALUES (";
  protected final String TEXT_151 = ")\";" + NL + "    java.sql.PreparedStatement insertQuery_";
  protected final String TEXT_152 = " = connection_";
  protected final String TEXT_153 = ".prepareStatement(insertQueryString_";
  protected final String TEXT_154 = ");";
  protected final String TEXT_155 = NL + "\t    insertQuery_";
  protected final String TEXT_156 = ".setTimestamp(";
  protected final String TEXT_157 = "," + NL + "\t    \tnew java.sql.Timestamp(start_Hash.get(\"";
  protected final String TEXT_158 = "\")));" + NL + "    \t";
  protected final String TEXT_159 = NL + "\t    String l1QueryString_";
  protected final String TEXT_160 = " = \"UPDATE \" + ";
  protected final String TEXT_161 = " + \" SET ";
  protected final String TEXT_162 = " WHERE ";
  protected final String TEXT_163 = "\";" + NL + "\t    java.sql.PreparedStatement l1Query_";
  protected final String TEXT_164 = " = connection_";
  protected final String TEXT_165 = ".prepareStatement(l1QueryString_";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "\t\tString l2QueryString_";
  protected final String TEXT_168 = " = \"UPDATE \" + ";
  protected final String TEXT_169 = " + \" \" +" + NL + "\t\t\t\"SET ";
  protected final String TEXT_170 = " = ? \" +";
  protected final String TEXT_171 = NL + " \t\t\t\", ";
  protected final String TEXT_172 = " = ";
  protected final String TEXT_173 = "'false'";
  protected final String TEXT_174 = "0";
  protected final String TEXT_175 = " \" +";
  protected final String TEXT_176 = NL + "\t\t\t\"WHERE ";
  protected final String TEXT_177 = " \" +" + NL + "\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\" AND ";
  protected final String TEXT_179 = " IS NULL\";" + NL + "\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\" AND EXTRACT(YEAR FROM ";
  protected final String TEXT_181 = ") = \" + ";
  protected final String TEXT_182 = ";" + NL + "\t\t\t";
  protected final String TEXT_183 = NL + "\t    java.sql.PreparedStatement l2Query_";
  protected final String TEXT_184 = " = connection_";
  protected final String TEXT_185 = ".prepareStatement(l2QueryString_";
  protected final String TEXT_186 = ");" + NL + "\t    ";
  protected final String TEXT_187 = NL + "\t\t    l2Query_";
  protected final String TEXT_188 = ".setTimestamp(1, new java.sql.Timestamp(start_Hash.get(\"";
  protected final String TEXT_189 = "\")));" + NL + "\t    \t";
  protected final String TEXT_190 = NL + "\t    String l3QueryString_";
  protected final String TEXT_191 = " = \"UPDATE \" + ";
  protected final String TEXT_192 = " + \" \" +" + NL + "\t    \t\"SET ";
  protected final String TEXT_193 = " \" +" + NL + "\t    \t\"WHERE ";
  protected final String TEXT_194 = "\"";
  protected final String TEXT_195 = NL + "\t\t\t\t+ \" AND ";
  protected final String TEXT_196 = " IS NULL\";" + NL + "\t\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t\t+ \" AND EXTRACT(YEAR FROM ";
  protected final String TEXT_198 = ") = \" + ";
  protected final String TEXT_199 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_200 = ";" + NL + "\t    java.sql.PreparedStatement l3Query_";
  protected final String TEXT_201 = " = connection_";
  protected final String TEXT_202 = ".prepareStatement(l3QueryString_";
  protected final String TEXT_203 = ");" + NL + "\t    ";
  protected final String TEXT_204 = NL + "\tSCDSK_";
  protected final String TEXT_205 = " lookupRow_";
  protected final String TEXT_206 = " = new SCDSK_";
  protected final String TEXT_207 = "();" + NL + "\tSCDStruct_";
  protected final String TEXT_208 = " cacheRow_";
  protected final String TEXT_209 = ";";
  protected final String TEXT_210 = NL + "\t// No code generated: define input and output schema first" + NL + "\t";
  protected final String TEXT_211 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

// Search incoming schema
IMetadataTable inMetadata = null;
IConnection inConnection = null;
String inConnectionName = null;

List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if (incomingConnections != null && !incomingConnections.isEmpty()) {
    inConnection = incomingConnections.get(0);
    inConnectionName = inConnection.getName();
    inMetadata = inConnection.getMetadataTable();
}

// Search outgoing schema
IMetadataTable metadata = null;

List<IMetadataTable> metadatas = node.getMetadataList();
if (metadatas != null && metadatas.size() > 0) {
    metadata = metadatas.get(0);
}

// We only generate output if incoming and outgoing schema are defined
if (inMetadata != null && metadata != null) {
	// Database parameters
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
	String dbtable = ElementParameterParser.getValue(node, "__TABLE__");
	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	boolean useExistingConnection = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__").equals("true");
	
	// Create database connection
	if (useExistingConnection) {
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		String connectionName = "conn_" + connection;
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_4);
    
	} else {
		
    stringBuffer.append(TEXT_5);
    
		String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
		if (connectionType.equals("ORACLE_SID")) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_10);
    
		} else if(connectionType.equals("ORACLE_SERVICE_NAME")) {
			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_15);
    
		}
		
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_20);
    
	}
	
	// SCD parameters
	String surrogateKeyField = ElementParameterParser.getValue(node, "__SURROGATE_KEY__");
	String surrogateKeyCreation = ElementParameterParser.getValue(node, "__SK_CREATION__");
	String skSequence = ElementParameterParser.getValue(node, "__SK_DB_SEQUENCE__");
	String skInputField = ElementParameterParser.getValue(node, "__SK_INPUT_FIELD__");
	String skRoutine = ElementParameterParser.getValue(node, "__SK_ROUTINE__");
	
    List<Map<String, String>> sourceKeys =
        (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");
	
    boolean useL1 = ElementParameterParser.getValue(node, "__USE_L1__").equals("true");
    List<Map<String, String>> l1fields = new ArrayList<Map<String, String>>();
    if (useL1) {
        l1fields = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
    }
	
    boolean useL2 = ElementParameterParser.getValue(node, "__USE_L2__").equals("true");
    List<Map<String, String>> l2fields = new ArrayList<Map<String, String>>();
    if (useL2) {
        l2fields = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
    }
	
    String startdateField = ElementParameterParser.getValue(node, "__L2_STARTDATE_FIELD__");
    String startdateValue = ElementParameterParser.getValue(node, "__L2_STARTDATE_VALUE__");
    String startdateInputField = ElementParameterParser.getValue(node, "__L2_STARTDATE_INPUT_FIELD__");
    String enddateField = ElementParameterParser.getValue(node, "__L2_ENDDATE_FIELD__");
    String enddateValue = ElementParameterParser.getValue(node, "__L2_ENDDATE_VALUE__");
    String enddateYear = ElementParameterParser.getValue(node, "__L2_ENDDATE_FIXED_VALUE__");
    
    boolean useActive = ElementParameterParser.getValue(node, "__USE_L2_ACTIVE__").equals("true");
    String activeField = ElementParameterParser.getValue(node, "__L2_ACTIVE_FIELD__");
    
    JavaType activeFieldType = null;
    for (IMetadataColumn column : metadata.getListColumns()) {
        if (column.getLabel().equals(activeField)) {
        	activeFieldType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			break;
        }
    }
    
    boolean useVersion = ElementParameterParser.getValue(node, "__USE_L2_VERSION__").equals("true");
    String versionField = ElementParameterParser.getValue(node, "__L2_VERSION_FIELD__");
	
	boolean useL3 = ElementParameterParser.getValue(node, "__USE_L3__").equals("true");
	List<Map<String, String>> l3fields = new ArrayList<Map<String, String>>();
    if (useL3) {
        l3fields = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__L3_FIELDS__");
    }
    
	// Build map with type (sk, L1, L2) of each column
    Map<String, String> typeOfColumn = new HashMap<String, String>();
    for (Map<String, String> sk : sourceKeys) {
        typeOfColumn.put(sk.get("NAME"), "SK");
    }
    for (Map<String, String> l1field : l1fields) {
        typeOfColumn.put(l1field.get("NAME"), "L1");
    }
    for (Map<String, String> l2field : l2fields) {
        typeOfColumn.put(l2field.get("NAME"), "L2");
    }
    for (Map<String, String> l3field : l3fields) {
        typeOfColumn.put(l3field.get("CURRENT_VALUE"), "L3C"); // L3 current
        typeOfColumn.put(l3field.get("PREV_VALUE"), "L3P"); // L3 previous
        
        if (l3field.get("CURRENT_VALUE").equals(l3field.get("PREV_VALUE"))) {
        	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(l3field.get("CURRENT_VALUE"));
    stringBuffer.append(TEXT_22);
    
        }
    }
	
	// Debug mode
	boolean debug = ElementParameterParser.getValue(node, "__DEBUG__").equals("true");
    
    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		for (IMetadataColumn column : inMetadata.getListColumns()) {
	        String colname = column.getLabel();
			
	        if (typeOfColumn.containsKey(colname)) {
		    	if (typeOfColumn.get(colname).equals("SK")) {
		        	
    stringBuffer.append(TEXT_27);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_29);
    
		        }
	        }
	    }
	    
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
			boolean isFirstSK = true;
	    	for (IMetadataColumn column : inMetadata.getListColumns()) {
		        String colname = column.getLabel();
				
		        if (typeOfColumn.containsKey(colname)) {
			    	if (typeOfColumn.get(colname).equals("SK")) {
		                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			            
			            if (isFirstSK) {
	                        isFirstSK = false;
	                    } else {
	                    	
    stringBuffer.append(TEXT_34);
    
	                    }
		                
		                if (javaType == JavaTypesManager.DATE ||
		                	javaType == JavaTypesManager.OBJECT ||
		                	javaType == JavaTypesManager.STRING ||
	                		column.isNullable()) {
							
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_36);
    
		                } else {
		                	
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(colname);
    
		                }
			        }
		        }
		    }
		    
    stringBuffer.append(TEXT_38);
    
		    	for (IMetadataColumn column : inMetadata.getListColumns()) {
			        String colname = column.getLabel();
					
			        if (typeOfColumn.containsKey(colname)) {
				    	if (typeOfColumn.get(colname).equals("SK")) {
			                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			                
			                if (javaType == JavaTypesManager.DATE ||
			                	javaType == JavaTypesManager.OBJECT ||
			                	javaType == JavaTypesManager.STRING ||
			                	column.isNullable()) {
					    		
    stringBuffer.append(TEXT_39);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_41);
    
				    		} else {
					    		
    stringBuffer.append(TEXT_42);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_43);
    
				    		}
				    	}
				   	}
				}
				
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
		// L1, L2, L3 fields
		for (IMetadataColumn column : metadata.getListColumns()) {
	        String colname = column.getLabel();
			
	        if (typeOfColumn.containsKey(colname)) {
		    	if (!typeOfColumn.get(colname).equals("SK")) {
		        	
    stringBuffer.append(TEXT_46);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_48);
    
		        }
	        }
	    }
		
	    // Version field
	    if (useVersion) {
		    for (IMetadataColumn column : metadata.getListColumns()) {
		        String colname = column.getLabel();
				
		        if (colname.equals(versionField)) {
			    	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_51);
    
					break;
		        }
		    }
		}
		
    stringBuffer.append(TEXT_52);
    
	
    // Build lookup cache
    List<String> selectColumns = new ArrayList<String>();
    List<String> javaTypeColumns = new ArrayList<String>();
	
    // First we iterate on the input schema columns...
    for (IMetadataColumn column : metadata.getListColumns()) {
        String colname = column.getLabel();
		
        if (typeOfColumn.containsKey(colname)) {
            selectColumns.add(colname);
            javaTypeColumns.add(JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()));
        }
    }
    
    if (useVersion) {
    	for (IMetadataColumn column : metadata.getListColumns()) {
	        String colname = column.getLabel();
			
	        if (colname.equals(versionField)) {
		        selectColumns.add(colname);
				javaTypeColumns.add(JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()));
				break;
	        }
	    }
    }
    
	String[] selectColumnsArray = selectColumns.toArray(new String[selectColumns.size()]);
    String selectColumnsString = StringUtils.join(selectColumnsArray, ", ");
    
    
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(selectColumnsString);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(dbtable);
    
    if (useL2) {
    	if (enddateValue.equals("NULL_VALUE")) {
	    	
    stringBuffer.append(TEXT_56);
    stringBuffer.append(enddateField);
    stringBuffer.append(TEXT_57);
    
		} else {
	    	
    stringBuffer.append(TEXT_58);
    stringBuffer.append(enddateField);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(enddateYear);
    stringBuffer.append(TEXT_60);
    
		}
    }
    
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
		int colPosition = 1;
		
		for (int i = 0; i < selectColumns.size(); i++) {
			String colname = selectColumns.get(i);
			
	        if (typeOfColumn.containsKey(colname) || colname.equals(versionField)) {
	            // Search Java type in order to call fitted method getXxx on ResultSet
	            String typeToGenerate = javaTypeColumns.get(i);
	            String struct = (!colname.equals(versionField) && typeOfColumn.get(colname).equals("SK") ? "sk_" : "row_") + cid;
	            
	            if (typeToGenerate.equals("byte[]")) {
 	  	   			typeToGenerate = "Bytes";
				} else if (typeToGenerate.equals("java.util.Date")) {
					typeToGenerate = "Timestamp";
				} else if (typeToGenerate.equals("Integer")) {
					typeToGenerate = "Int";
				} else {
					typeToGenerate = typeToGenerate.substring(0, 1).toUpperCase() + typeToGenerate.substring(1);
				}
		  		
				if (typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
					
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(colPosition);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(colPosition);
    stringBuffer.append(TEXT_88);
    
				  	    if (typeToGenerate.equals("Character")) {
				  	    	
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_94);
    
				  		} else {
				  			
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_99);
    
				  		}
				  		
    stringBuffer.append(TEXT_100);
    
				} else if (typeToGenerate.equals("Timestamp")) {
					
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(colPosition);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_110);
     	
				} else {
					
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(colPosition);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(struct);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(colPosition);
    stringBuffer.append(TEXT_118);
    
 			 	}
	            
	            colPosition++;
	        }
	    }
	    
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
	if (surrogateKeyCreation.equals("TABLE_MAX")) {
		for (IMetadataColumn column : metadata.getListColumns()) {
	        String colname = column.getLabel();
			
	        if (colname.equals(surrogateKeyField)) {
	            
    stringBuffer.append(TEXT_124);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
			}
		}
		
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(surrogateKeyField);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
	    	for (IMetadataColumn column : metadata.getListColumns()) {
		        String colname = column.getLabel();
				
		        if (colname.equals(surrogateKeyField)) {
		            // Search Java type in order to call fitted method getXxx on ResultSet
		            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		            
		            if (typeToGenerate.equals("Integer")) {
						typeToGenerate = "Int";
					} else {
						typeToGenerate = typeToGenerate.substring(0, 1).toUpperCase() + typeToGenerate.substring(1);
					}
			  		
					
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_142);
    
		        }
			}
			
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
	}
	
	if (debug) {
		
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
	}
	
    // INSERT query generation
    int colposition = 1;
    List colnames = new ArrayList();
    List parameters = new ArrayList();
	
	// Surrogate key
	if (!surrogateKeyCreation.equals("AUTO_INCREMENT") && !surrogateKeyCreation.equals("DB_SEQUENCE")) {
		for (IMetadataColumn column : metadata.getListColumns()) {
	        String colname = column.getLabel();
			
	        if (colname.equals(surrogateKeyField)) {
	            colnames.add(surrogateKeyField);
	            if (surrogateKeyCreation.equals("DB_SEQUENCE")) {
	            	parameters.add(skSequence + ".nextval");
	            } else {
		            parameters.add("?");
	            }
	            colposition++;
	            break;
	        }
	    }
    }
	
    // First we iterate on the input schema columns...
    for (IMetadataColumn column : metadata.getListColumns()) {
        // ... and we add each column only if it was chosen to be in the
        // output, ie if its type was defined.
        if (typeOfColumn.containsKey(column.getLabel())) {
            colnames.add(column.getLabel());
            parameters.add("?");
            colposition++;
        }
    }
	
    // Then we add L2 dedicated columns to store historical informations
    if (useL2) {
        if (useActive) {
        	colnames.add(activeField);
            if (activeFieldType == JavaTypesManager.STRING ||
            		activeFieldType == JavaTypesManager.BOOLEAN) {
	            parameters.add("'true'");
            } else {
            	parameters.add("1");
            }
        }
		
        if (useVersion) {
            colnames.add(versionField);
            parameters.add("?");
            colposition++;
        }
        
        colnames.add(startdateField);
        parameters.add("?");
		colposition++;
		
        colnames.add(enddateField);
        parameters.add(enddateValue.equals("NULL_VALUE") ? "NULL" : "TO_DATE('\" + " + enddateYear + "+ \"-01-01', 'yyyy-mm-dd')");
    }
	
    String colnamesString = StringUtils.join(colnames.toArray(), ", ");
    String parametersString = StringUtils.join(parameters.toArray(), ", ");
    
    
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(surrogateKeyCreation.equals("DB_SEQUENCE") ? surrogateKeyField + ", " : "");
    stringBuffer.append(colnamesString);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(surrogateKeyCreation.equals("DB_SEQUENCE") ? "\" + " + skSequence + " + \".nextval, " : "");
    stringBuffer.append(parametersString);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
    if (startdateValue.equals("JOB_START_TIME")) {
    	
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(colposition - 1);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
    }
    
    // L1 query generation
    List keyClauses = new ArrayList();
	List l1fieldClauses = new ArrayList();
	
    for (IMetadataColumn column : metadata.getListColumns()) {
        String colname = column.getLabel();
		
        if (typeOfColumn.containsKey(colname)) {
            if (typeOfColumn.get(colname).equals("SK")) {
                keyClauses.add(colname + " = ?");
            } else if (typeOfColumn.get(colname).equals("L1")) {
            	l1fieldClauses.add(colname + " = ?");
            }
        }
    }
	
    String keyClausesString = StringUtils.join(keyClauses.toArray(), " AND ");
    String l1fieldClausesString = StringUtils.join(l1fieldClauses.toArray(), ", ");
    
    if (useL1) {
	    
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(l1fieldClausesString);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(keyClausesString);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
    }
    
    // L2 query generation
    if (useL2) {
		
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(enddateField);
    stringBuffer.append(TEXT_170);
    
		if (useActive) {
			
    stringBuffer.append(TEXT_171);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_172);
    
 			if (activeFieldType == JavaTypesManager.STRING ||
            		activeFieldType == JavaTypesManager.BOOLEAN) {
	            
    stringBuffer.append(TEXT_173);
    
            } else {
            	
    stringBuffer.append(TEXT_174);
    
            }
            
    stringBuffer.append(TEXT_175);
    
	    }
	    
    stringBuffer.append(TEXT_176);
    stringBuffer.append(keyClausesString);
    stringBuffer.append(TEXT_177);
    
		if (enddateValue.equals("NULL_VALUE")) {
	    	
    stringBuffer.append(TEXT_178);
    stringBuffer.append(enddateField);
    stringBuffer.append(TEXT_179);
    
		} else {
	    	
    stringBuffer.append(TEXT_180);
    stringBuffer.append(enddateField);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(enddateYear);
    stringBuffer.append(TEXT_182);
    
		}
		
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
	    if (startdateValue.equals("JOB_START_TIME")) {
	    	
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
	    }
	}
	
	// L3 query generation
	if (useL3) {
		List l3fieldClauses = new ArrayList();
		
	    for (IMetadataColumn column : metadata.getListColumns()) {
	        String colname = column.getLabel();
			
	        if (typeOfColumn.containsKey(colname)) {
	            if (typeOfColumn.get(colname).equals("L3C")) {
	            	l3fieldClauses.add(colname + " = ?");
	            	
	            	// Search previous value field matching current value field
					for (Map<String, String> l3field : l3fields) {
						if (l3field.get("CURRENT_VALUE").equals(colname)) {
			            	l3fieldClauses.add(
			            		l3field.get("PREV_VALUE") + " = ?");
							break;
						}
					}
	            }
	        }
	    }
		
	    String l3fieldClausesString = StringUtils.join(l3fieldClauses.toArray(), ", ");
	    
	    
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(dbtable);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(l3fieldClausesString);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(keyClausesString);
    stringBuffer.append(TEXT_194);
    
	    if (useL2) {
	    	if (enddateValue.equals("NULL_VALUE")) {
		    	
    stringBuffer.append(TEXT_195);
    stringBuffer.append(enddateField);
    stringBuffer.append(TEXT_196);
    
			} else {
		    	
    stringBuffer.append(TEXT_197);
    stringBuffer.append(enddateField);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(enddateYear);
    stringBuffer.append(TEXT_199);
    
			}
		}
		
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
	}
	
	
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    
} else {
	
    stringBuffer.append(TEXT_210);
    
}

    stringBuffer.append(TEXT_211);
    return stringBuffer.toString();
  }
}
