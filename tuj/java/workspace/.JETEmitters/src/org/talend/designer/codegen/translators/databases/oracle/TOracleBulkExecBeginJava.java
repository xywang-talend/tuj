package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.lang.StringBuffer;
import java.util.Map;

public class TOracleBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TOracleBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleBulkExecBeginJava result = new TOracleBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.sql.Connection conn_";
  protected final String TEXT_3 = " = null;" + NL + "String serviceUrl_";
  protected final String TEXT_4 = " = null;" + NL + "String username_";
  protected final String TEXT_5 = " = null;" + NL + "String password_";
  protected final String TEXT_6 = " = null;";
  protected final String TEXT_7 = NL + "    String host_";
  protected final String TEXT_8 = " = (String)globalMap.get(\"";
  protected final String TEXT_9 = "\");" + NL + "    String port_";
  protected final String TEXT_10 = " = (String)globalMap.get(\"";
  protected final String TEXT_11 = "\");" + NL + "    String dbname_";
  protected final String TEXT_12 = " = (String)globalMap.get(\"";
  protected final String TEXT_13 = "\");" + NL + "    username_";
  protected final String TEXT_14 = " = (String)globalMap.get(\"";
  protected final String TEXT_15 = "\");" + NL + "    password_";
  protected final String TEXT_16 = " = (String)globalMap.get(\"";
  protected final String TEXT_17 = "\");" + NL + "    serviceUrl_";
  protected final String TEXT_18 = " = \"(description=(address=(protocol=tcp)(host=\" + host_";
  protected final String TEXT_19 = " + \")(port=\" + port_";
  protected final String TEXT_20 = " + \"))(connect_data=(service_name=\" + dbname_";
  protected final String TEXT_21 = " + \")))\";" + NL + "    conn_";
  protected final String TEXT_22 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_23 = "\");";
  protected final String TEXT_24 = NL + "    serviceUrl_";
  protected final String TEXT_25 = " = \"(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_26 = " + \")(port=\" + ";
  protected final String TEXT_27 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_28 = " + \")))\";" + NL + "    String url_";
  protected final String TEXT_29 = " = null;" + NL + "    username_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ";" + NL + "    password_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";";
  protected final String TEXT_34 = NL + "        url_";
  protected final String TEXT_35 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_36 = " + \":\" + ";
  protected final String TEXT_37 = " + \":\" + ";
  protected final String TEXT_38 = ";";
  protected final String TEXT_39 = NL + "        url_";
  protected final String TEXT_40 = " = \"jdbc:oracle:thin:@\" + serviceUrl_";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "    java.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");" + NL + "    conn_";
  protected final String TEXT_43 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_44 = ",username_";
  protected final String TEXT_45 = ",password_";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + NL + "java.sql.Statement stmt_";
  protected final String TEXT_48 = " = conn_";
  protected final String TEXT_49 = ".createStatement();" + NL + "" + NL + "java.sql.ResultSet rs_";
  protected final String TEXT_50 = " = stmt_";
  protected final String TEXT_51 = ".executeQuery(\"select * from \"+";
  protected final String TEXT_52 = "+\" where 1=2\");" + NL + "" + NL + "java.sql.ResultSetMetaData rsm_";
  protected final String TEXT_53 = " = rs_";
  protected final String TEXT_54 = ".getMetaData();" + NL + "" + NL + "int colCount_";
  protected final String TEXT_55 = " = rsm_";
  protected final String TEXT_56 = ".getColumnCount();" + NL + "" + NL + "StringBuilder sb_";
  protected final String TEXT_57 = " = new StringBuilder();" + NL + "" + NL + "sb_";
  protected final String TEXT_58 = ".append(\"(\");" + NL + "" + NL + "for (int i = 1; i <= colCount_";
  protected final String TEXT_59 = "; i++) {" + NL + "" + NL + "    sb_";
  protected final String TEXT_60 = ".append(rsm_";
  protected final String TEXT_61 = ".getColumnName(i));" + NL + "    " + NL + "    if(i < colCount_";
  protected final String TEXT_62 = "){" + NL + "    " + NL + "        sb_";
  protected final String TEXT_63 = ".append(\", \");" + NL + "    " + NL + "    }\t" + NL + "}" + NL + "" + NL + "sb_";
  protected final String TEXT_64 = ".append(\")\");" + NL;
  protected final String TEXT_65 = NL + "    conn_";
  protected final String TEXT_66 = ".close();";
  protected final String TEXT_67 = NL + NL + "String cltf_";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = "+\".clt\";" + NL + "" + NL + "String badf_";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = "+\".bad\";" + NL + "" + NL + "String dscf_";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = "+\".dsc\";" + NL + "" + NL + "String logf_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = "+\".log\";" + NL + "" + NL + "String enclosure_";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = "\"\\\"\"";
  protected final String TEXT_78 = ";" + NL + "" + NL + "java.io.FileWriter fw_";
  protected final String TEXT_79 = " = new java.io.FileWriter(cltf_";
  protected final String TEXT_80 = ");" + NL + "    " + NL + "fw_";
  protected final String TEXT_81 = ".write(\"\\r\\nLOAD DATA\\r\\nCHARACTERSET ";
  protected final String TEXT_82 = "\\r\\n\" +" + NL + "    \"";
  protected final String TEXT_83 = " INTO TABLE \" + ";
  protected final String TEXT_84 = " + " + NL + "    \"\\r\\nFIELDS TERMINATED BY \\\"\" + ";
  protected final String TEXT_85 = " + " + NL + "    \"\\\"\\r\\nOPTIONALLY ENCLOSED BY '\" + enclosure_";
  protected final String TEXT_86 = " + \"'\\r\\n\" + " + NL + "\t               sb_";
  protected final String TEXT_87 = ");" + NL + "            " + NL + "fw_";
  protected final String TEXT_88 = ".close();" + NL + "" + NL + "java.io.File badFile_";
  protected final String TEXT_89 = " = new java.io.File(badf_";
  protected final String TEXT_90 = ");" + NL + "" + NL + "if(badFile_";
  protected final String TEXT_91 = ".exists()){" + NL + "\t" + NL + "    badFile_";
  protected final String TEXT_92 = ".delete();" + NL + "\t" + NL + "}" + NL + "" + NL + "String command_";
  protected final String TEXT_93 = " = \"sqlldr '\" + username_";
  protected final String TEXT_94 = " + \"/\" + password_";
  protected final String TEXT_95 = " + \"@\" + serviceUrl_";
  protected final String TEXT_96 = " + \"' DATA='\" + ";
  protected final String TEXT_97 = " " + NL + "+ \"', CONTROL='\" + cltf_";
  protected final String TEXT_98 = " + \"', BAD='\" + badf_";
  protected final String TEXT_99 = " + \"', DISCARD='\" + dscf_";
  protected final String TEXT_100 = " + \"', LOG='\" + logf_";
  protected final String TEXT_101 = " + \"',";
  protected final String TEXT_102 = "\";" + NL + "" + NL + "final Process process_";
  protected final String TEXT_103 = " = Runtime.getRuntime().exec(command_";
  protected final String TEXT_104 = "); " + NL + "" + NL + "Thread normal_";
  protected final String TEXT_105 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_106 = ".getInputStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t        ";
  protected final String TEXT_107 = NL + "\t\t\t\t        System.out.println(line);" + NL + "\t\t\t\t        ";
  protected final String TEXT_108 = NL + "\t\t\t\t        globalMap.put(\"";
  protected final String TEXT_109 = "_OUTPUT\",(String)globalMap.get(\"";
  protected final String TEXT_110 = "_OUTPUT\") + \"\\n\" + line);" + NL + "\t\t\t\t        ";
  protected final String TEXT_111 = NL + "\t\t        }" + NL + "\t\t    } finally {" + NL + "\t\t         reader.close();" + NL + "\t\t    }" + NL + "\t    }catch(java.io.IOException ioe) {" + NL + "\t\t\tioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "" + NL + "normal_";
  protected final String TEXT_112 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_113 = " = new Thread() {" + NL + "    public void run() {" + NL + "\t   try {" + NL + "\t\t   java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_114 = ".getErrorStream()));" + NL + "\t\t   String line = \"\";" + NL + "\t\t   try {" + NL + "\t\t\t   while((line = reader.readLine()) != null) {" + NL + "\t\t\t       ";
  protected final String TEXT_115 = NL + "\t\t\t\t\t   System.err.println(line);" + NL + "\t\t\t\t\t   ";
  protected final String TEXT_116 = NL + "\t\t\t\t\t   globalMap.put(\"";
  protected final String TEXT_117 = "_OUTPUT\",(String)globalMap.get(\"";
  protected final String TEXT_118 = "_OUTPUT\")+\"\\n\"+line);" + NL + "\t\t\t\t\t   ";
  protected final String TEXT_119 = NL + "\t\t\t   }" + NL + "\t\t    } finally {" + NL + "\t\t\t    reader.close();" + NL + "\t\t    }" + NL + "\t    } catch(java.io.IOException ioe) {" + NL + "\t\t   ioe.printStackTrace();" + NL + "        }" + NL + "\t}" + NL + "};" + NL + "" + NL + "error_";
  protected final String TEXT_120 = ".start();" + NL + "" + NL + "process_";
  protected final String TEXT_121 = ".waitFor();" + NL + "" + NL + "normal_";
  protected final String TEXT_122 = ".interrupt();" + NL + "" + NL + "error_";
  protected final String TEXT_123 = ".interrupt();" + NL + "\t" + NL + "int nb_line_data_";
  protected final String TEXT_124 = " = (int)(com.delimitedparser.DelimitedDataReaderFactory.createDelimitedDataReader(";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ", \"\\n\", false).getAvailableRowCount(0));" + NL + "" + NL + "int nb_line_bad_";
  protected final String TEXT_127 = " = 0;" + NL + "" + NL + "if(new java.io.File(badf_";
  protected final String TEXT_128 = ").exists()){" + NL + "\t" + NL + "\tnb_line_bad_";
  protected final String TEXT_129 = " = (int)(com.delimitedparser.DelimitedDataReaderFactory.createDelimitedDataReader(badf_";
  protected final String TEXT_130 = ", ";
  protected final String TEXT_131 = ", \"\\n\", false).getAvailableRowCount(0));" + NL + "\t" + NL + "}" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_132 = "_NB_LINE_DATA\", nb_line_data_";
  protected final String TEXT_133 = ");" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_134 = "_NB_LINE_DATA\", nb_line_bad_";
  protected final String TEXT_135 = ");" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_136 = "_NB_LINE_INSERTED\", nb_line_data_";
  protected final String TEXT_137 = " - nb_line_bad_";
  protected final String TEXT_138 = ");" + NL + NL + NL + NL;
  protected final String TEXT_139 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String filename = ElementParameterParser.getValue(node, "__DATA__");
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser   = ElementParameterParser.getValue(node, "__USER__");
String dbpass   = ElementParameterParser.getValue(node, "__PASS__");
String table    = ElementParameterParser.getValue(node, "__TABLE__");
String data_action = ElementParameterParser.getValue(node, "__DATA_ACTION__");
String fields_terminated_by = ElementParameterParser.getValue(node, "__FIELDS_TERMINATED_BY__");
String fields_enclosed_by = ElementParameterParser.getValue(node, "__FIELDS_ENCLOSED_BY__");
   
List<Map<String, String>> options = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPTIONS__");
java.lang.StringBuffer optionStr = new java.lang.StringBuffer();
java.lang.StringBuffer siletModeStr = new java.lang.StringBuffer(); 
for(java.util.Map<String,String> option :options){
   	String key = option.get("KEY");
    if(key.equals("SILENT")){
        if(siletModeStr.length()>0){
        	siletModeStr.append(",").append(option.get("VALUE"));
        }else{
        	siletModeStr.append(option.get("VALUE"));
    	}
    }else{
    	if(optionStr.length()>0){
    		optionStr.append(",").append(key).append("=").append(option.get("VALUE"));
    	}else{
    	optionStr.append(key).append("=").append(option.get("VALUE"));
		}
	}
}
if(optionStr.length()>0 || siletModeStr.length()>0){
	if(siletModeStr.length()>0){
		if(optionStr.length()>0){
			optionStr.append(",");
		}
		if(siletModeStr.indexOf(",")<0){
		    optionStr.append("SILENT=").append(siletModeStr.toString());
		}else{
		    optionStr.append("SILENT=(").append(siletModeStr.toString()).append(")");
		}
	}
}
   
String encoding  = ElementParameterParser.getValue(node, "__ENCODING__");
encoding= encoding.toUpperCase();
if(encoding.equals("\"UTF-8\"")){
    encoding = "'UTF8'";
}else if(encoding.equals("\"ISO-8859-15\"")){
    encoding = "'WE8ISO8859P15'";
}else if(encoding.equals("\"GBK\"")){
    encoding = "'ZHS16GBK'";
}else if(encoding.equals("\"GB2312\"")){
    encoding = "'ZHS16CGB231280'";//ZHS16MACCGB231280 ?
}else if(encoding.equals("\"BIG5\"")){
    encoding = "'ZHT16BIG5'";
} else {
   //will be enhanced later, now default with utf-16
    encoding = "'AL16UTF16'";
}
String outputAction  = ElementParameterParser.getValue(node, "__OUTPUT__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
           
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(useExistingConn.equals("true"))
{
    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
    String conn = "conn_" + connection;
    String existHost = "host_" + connection;
    String existPort = "port_" + connection;
    String existDbName = "dbname_" + connection;
    String existUsername = "username_" + connection;
    String existPassword = "password_" + connection;
    
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(existHost);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(existPort);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(existDbName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(existUsername);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(existPassword);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_23);
    
}
else
{
    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_33);
    
    String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
    if(connectionType.equals("ORACLE_SID"))
    {
        
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_38);
    
    }
    else if(connectionType.equals("ORACLE_SERVICE_NAME"))
    {
        
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
    }
    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(table );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    
if(!useExistingConn.equals("true"))
{
    
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    if(fields_enclosed_by.equals("\"\"\"")){
    stringBuffer.append(TEXT_77);
    }else{
    stringBuffer.append(fields_enclosed_by );
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(data_action );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(table );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(fields_terminated_by );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(optionStr);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
			        if (outputAction.equals("OUTPUT_TO_CONSOLE")) {
			            
    stringBuffer.append(TEXT_107);
    
			        } else if (outputAction.equals("RETRIEVE_OUTPUT")) {
			            
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
			        }
			        
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
				   if (outputAction.equals("OUTPUT_TO_CONSOLE")) {
				       
    stringBuffer.append(TEXT_115);
    
				   } else if (outputAction.equals("RETRIEVE_OUTPUT")) {
				       
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    
				   }
			       
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(fields_terminated_by );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(fields_terminated_by );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    return stringBuffer.toString();
  }
}
