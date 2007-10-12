package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TOracleConnectionBeginJava
{
  protected static String nl;
  public static synchronized TOracleConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleConnectionBeginJava result = new TOracleConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");";
  protected final String TEXT_4 = NL + "\tString url_";
  protected final String TEXT_5 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_6 = " + \":\" + ";
  protected final String TEXT_7 = " + \":\" + ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + "\tString url_";
  protected final String TEXT_10 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_11 = " + \")(port=\" + ";
  protected final String TEXT_12 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_13 = " + \")))\";";
  protected final String TEXT_14 = NL + NL + "String dbUser_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "String dbPwd_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_19 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_20 = ",dbUser_";
  protected final String TEXT_21 = ",dbPwd_";
  protected final String TEXT_22 = ");" + NL + "" + NL + "conn_";
  protected final String TEXT_23 = ".setAutoCommit(false);" + NL + "" + NL + "globalMap.put(\"conn_\" + \"";
  protected final String TEXT_24 = "\",conn_";
  protected final String TEXT_25 = ");" + NL + "globalMap.put(\"host_\" + \"";
  protected final String TEXT_26 = "\",";
  protected final String TEXT_27 = ");" + NL + "globalMap.put(\"port_\" + \"";
  protected final String TEXT_28 = "\",";
  protected final String TEXT_29 = ");" + NL + "globalMap.put(\"dbname_\" + \"";
  protected final String TEXT_30 = "\",";
  protected final String TEXT_31 = ");" + NL + "globalMap.put(\"username_\" + \"";
  protected final String TEXT_32 = "\",";
  protected final String TEXT_33 = ");" + NL + "globalMap.put(\"password_\" + \"";
  protected final String TEXT_34 = "\",";
  protected final String TEXT_35 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
	String javaDbDriver = "oracle.jdbc.driver.OracleDriver";
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_3);
    
String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
if(connectionType.equals("ORACLE_SID")) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_8);
    
} else if(connectionType.equals("ORACLE_SERVICE_NAME")) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_13);
    
}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
