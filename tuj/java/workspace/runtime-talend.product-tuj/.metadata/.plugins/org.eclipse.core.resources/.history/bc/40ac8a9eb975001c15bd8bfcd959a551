package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TOracleSPBeginJava
{
  protected static String nl;
  public static synchronized TOracleSPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleSPBeginJava result = new TOracleSPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_3 = " = (java.sql.Connection) globalMap.get(\"";
  protected final String TEXT_4 = "\");" + NL + "\t";
  protected final String TEXT_5 = NL + "\tjava.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tString connectionString_";
  protected final String TEXT_7 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_8 = " + \":\" + ";
  protected final String TEXT_9 = " + \":\" + ";
  protected final String TEXT_10 = ";" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\tString connectionString_";
  protected final String TEXT_12 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_13 = " + \")(port=\" + ";
  protected final String TEXT_14 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_15 = " + \")))\";" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\tjava.sql.Connection connection_";
  protected final String TEXT_17 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ");" + NL + "\t";
  protected final String TEXT_21 = NL + "java.sql.CallableStatement statement_";
  protected final String TEXT_22 = " = connection_";
  protected final String TEXT_23 = ".prepareCall(\"{";
  protected final String TEXT_24 = "call ";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = "?,";
  protected final String TEXT_27 = "?";
  protected final String TEXT_28 = ")}\");" + NL + "" + NL + "java.sql.Date tmpDate_";
  protected final String TEXT_29 = ";" + NL + "String tmpString_";
  protected final String TEXT_30 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dbhost = ElementParameterParser.getValue(node, "__HOST__");
String dbport = ElementParameterParser.getValue(node, "__PORT__");
String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbpwd  = ElementParameterParser.getValue(node, "__PASS__");
String spName = ElementParameterParser.getValue(node, "__SP_NAME__");
boolean isFunction = ElementParameterParser.getValue(node, "__IS_FUNCTION__").equals("true");
List<Map<String, String>> spArgs = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SP_ARGS__");
boolean useExistingConnection = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__").equals("true");

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


    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(isFunction ? "? = " : "");
    stringBuffer.append(TEXT_24);
    stringBuffer.append(spName);
    stringBuffer.append(TEXT_25);
    
for (int i = 0; i < spArgs.size(); i++) {
	if (i < spArgs.size() - 1) {
		
    stringBuffer.append(TEXT_26);
    
	} else {
		
    stringBuffer.append(TEXT_27);
    
	}
}

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
