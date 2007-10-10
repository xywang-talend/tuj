package org.talend.designer.codegen.translators.databases.dbjdbc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TJDBCRowBeginJava
{
  protected static String nl;
  public static synchronized TJDBCRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCRowBeginJava result = new TJDBCRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.lang.Class.forName(";
  protected final String TEXT_3 = ");" + NL + "String connectionString_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "java.sql.Connection connection_";
  protected final String TEXT_6 = " =" + NL + "\tjava.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ");" + NL + "java.sql.PreparedStatement statement_";
  protected final String TEXT_10 = " = null;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_11 = " = false;" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_12 = "_QUERY\", ";
  protected final String TEXT_13 = ");" + NL;
  protected final String TEXT_14 = NL + "\tint commitEvery_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "\tint commitCounter_";
  protected final String TEXT_17 = " = 0;" + NL + "\tconnection_";
  protected final String TEXT_18 = ".setAutoCommit(false);" + NL + "\t";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String driverJar = ElementParameterParser.getValue(node, "__DRIVER_JAR__");
String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
String jdbcUrl = ElementParameterParser.getValue(node, "__URL__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
String dbquery = ElementParameterParser.getValue(node, "__QUERY__");
dbquery = dbquery.replaceAll("\n"," ");
dbquery = dbquery.replaceAll("\r"," ");
String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(jdbcUrl);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_13);
    
if (!commitEvery.equals("") && !commitEvery.equals("0")) {
	
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
}

    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
