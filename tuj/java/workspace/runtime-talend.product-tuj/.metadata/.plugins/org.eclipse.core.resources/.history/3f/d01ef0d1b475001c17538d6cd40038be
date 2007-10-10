package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.talend.commons.utils.StringUtils;

public class TOracleSCDMainJava
{
  protected static String nl;
  public static synchronized TOracleSCDMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleSCDMainJava result = new TOracleSCDMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_3 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t";
  protected final String TEXT_5 = ".setNull(";
  protected final String TEXT_6 = ", java.sql.Types.CHAR);" + NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_8 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t";
  protected final String TEXT_10 = ".setNull(";
  protected final String TEXT_11 = ", java.sql.Types.DATE);" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_13 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t";
  protected final String TEXT_15 = ".setNull(";
  protected final String TEXT_16 = ", java.sql.Types.ARRAY);\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_18 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL + "\t\t\t\t";
  protected final String TEXT_20 = ".setNull(";
  protected final String TEXT_21 = ", java.sql.Types.INTEGER);" + NL + "\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_23 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t";
  protected final String TEXT_25 = ".setNull(";
  protected final String TEXT_26 = ", java.sql.Types.VARCHAR);" + NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_28 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t";
  protected final String TEXT_30 = ".setNull(";
  protected final String TEXT_31 = ", java.sql.Types.OTHER);" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_33 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t";
  protected final String TEXT_35 = ".setNull(";
  protected final String TEXT_36 = ", java.sql.Types.BOOLEAN);\t" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_38 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t";
  protected final String TEXT_40 = ".setNull(";
  protected final String TEXT_41 = ", java.sql.Types.DOUBLE);\t" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_43 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t";
  protected final String TEXT_45 = ".setNull(";
  protected final String TEXT_46 = ", java.sql.Types.FLOAT);\t" + NL + "\t\t\t\t";
  protected final String TEXT_47 = "} else {";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\tif (";
  protected final String TEXT_49 = " == null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\tif (String.valueOf(";
  protected final String TEXT_51 = ").toLowerCase().equals(\"null\")) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_53 = ".setNull(";
  protected final String TEXT_54 = ", java.sql.Types.CHAR);" + NL + "\t\t\t\t\t} else if(";
  protected final String TEXT_55 = " == '\\0') {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_56 = ".setString(";
  protected final String TEXT_57 = ", \"\");" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = ".setString(";
  protected final String TEXT_59 = ", String.valueOf(";
  protected final String TEXT_60 = "));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\tif (";
  protected final String TEXT_62 = " != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_63 = ".setTimestamp(";
  protected final String TEXT_64 = ", new java.sql.Timestamp(";
  protected final String TEXT_65 = ".getTime()));" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_66 = ".setNull(";
  protected final String TEXT_67 = ", java.sql.Types.DATE);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t";
  protected final String TEXT_69 = ".set";
  protected final String TEXT_70 = "(";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = "}";
  protected final String TEXT_74 = NL + "    // Lookup source keys";
  protected final String TEXT_75 = NL + "\t    \t\tlookupRow_";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = ";" + NL + "\t    \t\t";
  protected final String TEXT_80 = NL + "    lookupRow_";
  protected final String TEXT_81 = ".hashCodeDirty = true; // Regenerate hash code" + NL + "   \tcacheRow_";
  protected final String TEXT_82 = " = cache_";
  protected final String TEXT_83 = ".get(lookupRow_";
  protected final String TEXT_84 = ");" + NL + "    " + NL + "\tif (cacheRow_";
  protected final String TEXT_85 = " == null) {" + NL + "\t\t// Insert new source id" + NL + "\t\t";
  protected final String TEXT_86 = NL + "\t\tinsertQuery_";
  protected final String TEXT_87 = ".executeUpdate();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\t\tSystem.out.println(\"[";
  protected final String TEXT_89 = "] new source id inserted\");" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + "\t} else {" + NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\t\t// L1 fields" + NL + "\t\t\tif (";
  protected final String TEXT_92 = " || ";
  protected final String TEXT_93 = "((cacheRow_";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " == null && ";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " != null) ||" + NL + "\t\t\t\t\t\t\t\t   (cacheRow_";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " != null && !cacheRow_";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = ".equals(";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = ")))";
  protected final String TEXT_104 = "cacheRow_";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " != ";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t\tl1Query_";
  protected final String TEXT_110 = ".executeUpdate();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\tSystem.out.println(\"[";
  protected final String TEXT_112 = "] l1 update done\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_113 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_114 = NL + "\t\t\t// L2 fields" + NL + "\t\t\tif (";
  protected final String TEXT_115 = " || ";
  protected final String TEXT_116 = "((cacheRow_";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " == null && ";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " != null) ||" + NL + "\t\t\t\t\t\t\t\t   (cacheRow_";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " != null && !cacheRow_";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = ".equals(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = ")))";
  protected final String TEXT_127 = "cacheRow_";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = " != ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_132 = NL + "    \t\t\tl2Query_";
  protected final String TEXT_133 = ".executeUpdate();" + NL + "    \t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\tinsertQuery_";
  protected final String TEXT_135 = ".executeUpdate();" + NL + "\t\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t\t\tSystem.out.println(\"[";
  protected final String TEXT_137 = "] new history line\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_139 = NL + "\t\t\t// L3 fields" + NL + "\t\t\tboolean l3Change_";
  protected final String TEXT_140 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\tif ((cacheRow_";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = " == null && ";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " != null) ||" + NL + "\t\t\t\t\t\t   (cacheRow_";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " != null && !cacheRow_";
  protected final String TEXT_148 = ".";
  protected final String TEXT_149 = ".equals(";
  protected final String TEXT_150 = ".";
  protected final String TEXT_151 = "))) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_152 = NL + "\t                \tif (cacheRow_";
  protected final String TEXT_153 = ".";
  protected final String TEXT_154 = " != ";
  protected final String TEXT_155 = ".";
  protected final String TEXT_156 = ") {" + NL + "\t                \t";
  protected final String TEXT_157 = NL + "\t                \tl3Change_";
  protected final String TEXT_158 = " = true;" + NL + "\t                }" + NL + "\t                ";
  protected final String TEXT_159 = NL + "\t\t\tif (l3Change_";
  protected final String TEXT_160 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\t\tif (!((cacheRow_";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = " == null && ";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " != null) ||" + NL + "\t\t\t\t\t\t\t   (cacheRow_";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = " != null && !cacheRow_";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = ".equals(";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = ")))) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_172 = NL + "\t\t                \tif (cacheRow_";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = " == ";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = ") {" + NL + "\t\t                \t";
  protected final String TEXT_177 = NL + "\t\t                }" + NL + "\t\t                ";
  protected final String TEXT_178 = NL + "\t\t\t\t" + NL + "\t\t\t\tl3Query_";
  protected final String TEXT_179 = ".executeUpdate();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t\tSystem.out.println(\"[";
  protected final String TEXT_181 = "] l3 update done\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_183 = NL + "\t}";
  protected final String TEXT_184 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

// Search incoming schema
IMetadataTable inMetadata = null;
IConnection inConnection = null;
String inConnectionName = null;

List<? extends IConnection> incomingConnections
    = node.getIncomingConnections();
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
    String inConnName = inConnection.getName();
    
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
	
    boolean useVersion = ElementParameterParser.getValue(node, "__USE_L2_VERSION__").equals("true");
    String versionField = ElementParameterParser.getValue(node, "__L2_VERSION_FIELD__");
    String versionType = null;
	if (useVersion) {
		// Search java type for version field
	    for (IMetadataColumn column : metadata.getListColumns()) {
	        String colname = column.getLabel();
			
	        if (colname.equals(versionField)) {
	        	versionType = JavaTypesManager.getTypeToGenerate(column.getTalendType(), false);
				break;
	        }
	    }
	}
	
    String startdateValue = ElementParameterParser.getValue(node, "__L2_STARTDATE_VALUE__");
    String startdateInputField = ElementParameterParser.getValue(node, "__L2_STARTDATE_INPUT_FIELD__");
    
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
    }
	
	// Debug mode
	boolean debug = ElementParameterParser.getValue(node, "__DEBUG__").equals("true");
    
    // Inner class StatementGenerator (@see tMysqlOutput#Operation)
	class StatementGenerator {
		public void generateSetStatement(String cid, String statement, String value,
										 int counter, String typeToGenerate) {
			boolean isObject = false;
			
			if (typeToGenerate.equals("Character")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_2);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_3);
    
				}
				
    stringBuffer.append(TEXT_4);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_6);
    
			} else if (typeToGenerate.equals("Date")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_7);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_8);
    
				}
				
    stringBuffer.append(TEXT_9);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_11);
    
			} else if (typeToGenerate.equals("byte[]")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_12);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_13);
    
				}
				
    stringBuffer.append(TEXT_14);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_16);
    
			} else if (typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") ||
					   typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_17);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_18);
    
				}
				
    stringBuffer.append(TEXT_19);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_21);
    
			} else if (typeToGenerate.equals("String")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_22);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_23);
    
				}
				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_26);
    
			} else if (typeToGenerate.equals("Object")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_27);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_28);
    
				}
				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_31);
    
			} else if (typeToGenerate.equals("Boolean")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_32);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_33);
    
				}
				
    stringBuffer.append(TEXT_34);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_36);
    
			} else if (typeToGenerate.equals("Double")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_37);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_38);
    
				}
				
    stringBuffer.append(TEXT_39);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_41);
    
			} else if (typeToGenerate.equals("Float")) {
				isObject = true;
				if (!value.equals("null")) {
					
    stringBuffer.append(TEXT_42);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_43);
    
				}
				
    stringBuffer.append(TEXT_44);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_46);
    
			}
			
			if (!value.equals("null")) {
				if (isObject) {
					
    stringBuffer.append(TEXT_47);
    
				}
				
				if (typeToGenerate.equals("byte[]")) {
		 	  		typeToGenerate = "Bytes";
		 	   	} else if (typeToGenerate.equals("java.util.Date")) {
		 	   		typeToGenerate = "Date";
		 	  	} else if (typeToGenerate.equals("Integer")) {
		 	   		typeToGenerate = "Int";
		 	   	} else {
					typeToGenerate = typeToGenerate.substring(0, 1).toUpperCase() + typeToGenerate.substring(1);
				}
				
				if (typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
					if (isObject) {
						
    stringBuffer.append(TEXT_48);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_49);
    
					} else {
						
    stringBuffer.append(TEXT_50);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_51);
    
					}
					
    stringBuffer.append(TEXT_52);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_60);
    
				} else if (typeToGenerate.equals("Date")) {
					
    stringBuffer.append(TEXT_61);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_67);
    
				} else {
					
    stringBuffer.append(TEXT_68);
    stringBuffer.append(statement);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(counter);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_72);
    
				}
				if(isObject) {
					
    stringBuffer.append(TEXT_73);
    
				}
			}
		}
	}
	
	StatementGenerator generator = new StatementGenerator();
    
    
    stringBuffer.append(TEXT_74);
    
	for (IMetadataColumn column : inMetadata.getListColumns()) {
        String colname = column.getLabel();
		
        if (typeOfColumn.containsKey(colname)) {
	    	if (typeOfColumn.get(colname).equals("SK")) {
	    		
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_79);
    
	        }
        }
    }
    
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
		int colposition = 1;
		
		// Surrogate key
		if (!surrogateKeyCreation.equals("AUTO_INCREMENT") && !surrogateKeyCreation.equals("DB_SEQUENCE")) {
			for (IMetadataColumn column : metadata.getListColumns()) {
		        String colname = column.getLabel();
				
		        if (colname.equals(surrogateKeyField)) {
		        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		        	
		        	if (surrogateKeyCreation.equals("INPUT_FIELD")) {
			        	generator.generateSetStatement(cid, "insertQuery_" + cid, inConnectionName + "." + skInputField, colposition++, typeToGenerate);
			        } else if (surrogateKeyCreation.equals("ROUTINE")) {
			        	generator.generateSetStatement(cid, "insertQuery_" + cid, skRoutine, colposition++, typeToGenerate);
			        } else if (surrogateKeyCreation.equals("TABLE_MAX")) {
			        	generator.generateSetStatement(cid, "insertQuery_" + cid, "nextSurrogateKey_" + cid + "++", colposition++, typeToGenerate);
			        }
		        }
		    }
		}
		
    	for (IMetadataColumn column : metadata.getListColumns()) {
	        String colname = column.getLabel();
			
	        if (typeOfColumn.containsKey(colname)) {
	        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
	        	if (!typeOfColumn.get(column.getLabel()).equals("L3P")) {
					generator.generateSetStatement(cid, "insertQuery_" + cid, inConnectionName + "." + colname, colposition++, typeToGenerate);
				} else {
					if (column.isNullable()) {
						generator.generateSetStatement(cid, "insertQuery_" + cid, "null", colposition++, typeToGenerate);
					} else {
						generator.generateSetStatement(cid, "insertQuery_" + cid, "" + column.getDefault(), colposition++, typeToGenerate);
					}
				}
			}
		}
		
		if (useVersion) {
			generator.generateSetStatement(cid, "insertQuery_" + cid, "1", colposition++, versionType);
		}
		
	    if (startdateValue.equals("INPUT_FIELD")) {
			generator.generateSetStatement(cid, "insertQuery_" + cid, inConnectionName + "." + startdateInputField, colposition++, "Date");
		}
		
		
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
	    if (debug) {
			
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
	    }
		
    stringBuffer.append(TEXT_90);
    
		// L1 fields
		if (l1fields.size() > 0) {
			boolean isFirstL1 = true;
			
    stringBuffer.append(TEXT_91);
    
				for (IMetadataColumn column : metadata.getListColumns()) {
					String colname = column.getLabel();
					
		            if (typeOfColumn.containsKey(colname)) {
		                if (typeOfColumn.get(colname).equals("L1")) {
		                    if (isFirstL1) {
		                        isFirstL1 = false;
		                    } else {
		                    	
    stringBuffer.append(TEXT_92);
    
		                    }
		                    
			                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			                
			                if (javaType == JavaTypesManager.DATE ||
			                	javaType == JavaTypesManager.OBJECT ||
			                	javaType == JavaTypesManager.STRING ||
			                	column.isNullable()) {
								
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_103);
    
			                } else {
			                	
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(colname);
    
			                }
						}
					}
				}
			
    stringBuffer.append(TEXT_108);
    
				// Bind L1 fields to SQL request
				colposition = 1;
				for (IMetadataColumn column : metadata.getListColumns()) {
			        String colname = column.getLabel();
					
			        if (typeOfColumn.containsKey(colname)) {
			            if (typeOfColumn.get(colname).equals("L1")) {
				        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							generator.generateSetStatement(cid, "l1Query_" + cid, inConnectionName + "." + colname, colposition++, typeToGenerate);
			            }
			        }
			    }
			    
				// Bind SK fields to SQL request
				for (IMetadataColumn column : metadata.getListColumns()) {
			        String colname = column.getLabel();
					
			        if (typeOfColumn.containsKey(colname)) {
			            if (typeOfColumn.get(colname).equals("SK")) {
				        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							generator.generateSetStatement(cid, "l1Query_" + cid, inConnectionName + "." + colname, colposition++, typeToGenerate);
			            }
			        }
			    }
			    
			    
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
				if (debug) {
					
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
				}
				
    stringBuffer.append(TEXT_113);
    
		}
		
		// L2 fields
		if (l2fields.size() > 0) {
        	boolean isFirstL2 = true;
			
    stringBuffer.append(TEXT_114);
    
		        for (IMetadataColumn column : metadata.getListColumns()) {
					String colname = column.getLabel();
					
		            if (typeOfColumn.containsKey(colname)) {
		                if (typeOfColumn.get(colname).equals("L2")) {
		                    if (isFirstL2) {
		                        isFirstL2 = false;
		                    } else {
		                    	
    stringBuffer.append(TEXT_115);
    
		                    }
		                    
			                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			                
			                if (javaType == JavaTypesManager.DATE ||
			                	javaType == JavaTypesManager.OBJECT ||
			                	javaType == JavaTypesManager.STRING ||
			                	column.isNullable()) {
								
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_126);
    
			                } else {
			                	
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(colname);
    
			                }
						}
					}
				}
			
    stringBuffer.append(TEXT_131);
    
				if (startdateValue.equals("INPUT_FIELD")) {
					generator.generateSetStatement(cid, "l2Query_" + cid, inConnectionName + "." + startdateInputField, 1, "Date");
				}
				
				colposition = 2; // Note: parameter #1 is end date (defined in _start)
				for (IMetadataColumn column : metadata.getListColumns()) {
			        String colname = column.getLabel();
					
			        if (typeOfColumn.containsKey(colname)) {
			            if (typeOfColumn.get(colname).equals("SK")) {
				        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							generator.generateSetStatement(cid, "l2Query_" + cid, inConnectionName + "." + colname, colposition++, typeToGenerate);
			            }
			        }
			    }
			    
    			
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
				colposition = 1;
				
				// Surrogate key
				if (!surrogateKeyCreation.equals("AUTO_INCREMENT") && !surrogateKeyCreation.equals("DB_SEQUENCE")) {
					for (IMetadataColumn column : metadata.getListColumns()) {
				        String colname = column.getLabel();
						
				        if (colname.equals(surrogateKeyField)) {
				        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				        	
				        	if (surrogateKeyCreation.equals("INPUT_FIELD")) {
					        	generator.generateSetStatement(cid, "insertQuery_" + cid, inConnectionName + "." + skInputField, colposition++, typeToGenerate);
					        } else if (surrogateKeyCreation.equals("ROUTINE")) {
					        	generator.generateSetStatement(cid, "insertQuery_" + cid, skRoutine, colposition++, typeToGenerate);
					        } else if (surrogateKeyCreation.equals("TABLE_MAX")) {
					        	generator.generateSetStatement(cid, "insertQuery_" + cid, "nextSurrogateKey_" + cid + "++", colposition++, typeToGenerate);
					        }
				        }
				    }
				}
				
				for (IMetadataColumn column : metadata.getListColumns()) {
			        String colname = column.getLabel();
					
			        if (typeOfColumn.containsKey(colname)) {
			        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
			        	if (!typeOfColumn.get(column.getLabel()).equals("L3P")) {
			        		generator.generateSetStatement(cid, "insertQuery_" + cid, inConnectionName + "." + colname, colposition++, typeToGenerate);
			        	} else {
			        		generator.generateSetStatement(cid, "insertQuery_" + cid, "cacheRow_" + cid + "." + colname, colposition++, typeToGenerate);
			        	}
			        }
				}
				
				if (useVersion) {
					generator.generateSetStatement(cid, "insertQuery_" + cid,
						"cacheRow_" + cid + "." + versionField + " + 1", colposition++, versionType);
				}
				
			    if (startdateValue.equals("INPUT_FIELD")) {
					generator.generateSetStatement(cid, "insertQuery_" + cid, inConnectionName + "." + startdateInputField, colposition++, "Date");
				}
				
				
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
				
				if (debug) {
					
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
				}
				
    stringBuffer.append(TEXT_138);
    
		}
		
		// L3 fields
		if (l3fields.size() > 0) {
			
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
			
			// Search L3 fields with a modified value
			colposition = 1;
			for (IMetadataColumn column : metadata.getListColumns()) {
				String colname = column.getLabel();
				
				if (typeOfColumn.containsKey(colname) &&
						typeOfColumn.get(colname).equals("L3C")) {
					// Search previous value field matching current value field
					String prevColname = "";
					for (Map<String, String> l3field : l3fields) {
						if (l3field.get("CURRENT_VALUE").equals(colname)) {
							prevColname = l3field.get("PREV_VALUE");
							break;
						}
					}
					
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
	                
	                if (javaType == JavaTypesManager.DATE ||
	                	javaType == JavaTypesManager.OBJECT ||
	                	javaType == JavaTypesManager.STRING ||
	                	column.isNullable()) {
						
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_151);
    
	                } else {
	                	
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_156);
    
	                }
	                
	                generator.generateSetStatement(cid, "l3Query_" + cid,
	                	inConnectionName + "." + colname, colposition, typeToGenerate);
	                generator.generateSetStatement(cid, "l3Query_" + cid,
	                	"cacheRow_" + cid + "." + colname, colposition + 1, typeToGenerate);
	                
	                
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
	                colposition += 2;
				}
			}
			
			// Do L3 update if at least one L3 field is modified
			
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
				// Unmodified fields
				colposition = 1;
				for (IMetadataColumn column : metadata.getListColumns()) {
					String colname = column.getLabel();
					
					if (typeOfColumn.containsKey(colname) &&
							typeOfColumn.get(colname).equals("L3C")) {
						// Search previous value field matching current value field
						String prevColname = "";
						for (Map<String, String> l3field : l3fields) {
							if (l3field.get("CURRENT_VALUE").equals(colname)) {
								prevColname = l3field.get("PREV_VALUE");
								break;
							}
						}
						
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
			        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                
		                if (javaType == JavaTypesManager.DATE ||
		                	javaType == JavaTypesManager.OBJECT ||
		                	javaType == JavaTypesManager.STRING ||
		                	column.isNullable()) {
							
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_171);
    
		                } else {
		                	
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(inConnectionName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(colname);
    stringBuffer.append(TEXT_176);
    
		                }
		                
		                generator.generateSetStatement(cid, "l3Query_" + cid,
		                	"cacheRow_" + cid + "." + colname, colposition, typeToGenerate);
		                generator.generateSetStatement(cid, "l3Query_" + cid,
		                	"cacheRow_" + cid + "." + prevColname, colposition + 1, typeToGenerate);
	                	
    stringBuffer.append(TEXT_177);
    
		                colposition += 2;
					}
				}
				
				// Bind SK fields to SQL request
				for (IMetadataColumn column : metadata.getListColumns()) {
			        String colname = column.getLabel();
					
			        if (typeOfColumn.containsKey(colname)) {
			            if (typeOfColumn.get(colname).equals("SK")) {
				        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							generator.generateSetStatement(cid, "l3Query_" + cid, inConnectionName + "." + colname, colposition++, typeToGenerate);
			            }
			        }
			    }
				
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
				if (debug) {
					
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
				}
			
    stringBuffer.append(TEXT_182);
    
		}
	
    stringBuffer.append(TEXT_183);
    
}

    stringBuffer.append(TEXT_184);
    return stringBuffer.toString();
  }
}
