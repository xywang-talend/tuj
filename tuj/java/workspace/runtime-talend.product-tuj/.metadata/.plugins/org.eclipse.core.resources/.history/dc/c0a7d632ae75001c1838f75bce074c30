package org.talend.designer.codegen.translators.databases.informix;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TInformixRowBeginJava
{
  protected static String nl;
  public static synchronized TInformixRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInformixRowBeginJava result = new TInformixRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.lang.Class.forName(\"com.informix.jdbc.IfxDriver\");" + NL + "" + NL + "String url_";
  protected final String TEXT_3 = " = \"jdbc:informix-sqli://\" + ";
  protected final String TEXT_4 = " + \":\" + ";
  protected final String TEXT_5 = " + \"/\" + ";
  protected final String TEXT_6 = " + \":informixserver=\" + ";
  protected final String TEXT_7 = ";" + NL + "" + NL + "String dbUser_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "String dbPwd_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_12 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_13 = ",dbUser_";
  protected final String TEXT_14 = ",dbPwd_";
  protected final String TEXT_15 = ");" + NL + "" + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_16 = " = null;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_17 = " = false;" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_18 = "_QUERY\",";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + NL + "int commitEvery_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_23 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_24 = ".setAutoCommit(false);";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbserver = ElementParameterParser.getValue(node, "__DBSERVER__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
	String dbencoding= ElementParameterParser.getValue(node, "__ENCODING__");
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
		   dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");   
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbserver);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_19);
    
if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
