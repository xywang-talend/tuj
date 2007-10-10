package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMysqlConnectionBeginJava
{
  protected static String nl;
  public static synchronized TMysqlConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlConnectionBeginJava result = new TMysqlConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");" + NL + "" + NL + "String url_";
  protected final String TEXT_4 = " = \"jdbc:mysql://\" + ";
  protected final String TEXT_5 = " + \":\" + ";
  protected final String TEXT_6 = " + \"/\" + ";
  protected final String TEXT_7 = " + \"?noDatetimeStringSync=true\";" + NL + "" + NL + "String userName_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "" + NL + "String password_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_12 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_13 = ",userName_";
  protected final String TEXT_14 = ",password_";
  protected final String TEXT_15 = ");" + NL + "" + NL + "conn_";
  protected final String TEXT_16 = ".setAutoCommit(false);" + NL + "" + NL + "globalMap.put(\"conn_\" + \"";
  protected final String TEXT_17 = "\",conn_";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
	String javaDbDriver   = "org.gjt.mm.mysql.Driver";
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbpass);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
