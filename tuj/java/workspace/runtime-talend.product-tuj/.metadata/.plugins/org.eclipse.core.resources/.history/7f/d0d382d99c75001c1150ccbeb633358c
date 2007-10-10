package org.talend.designer.codegen.translators.databases.sqlite;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TSQLiteRowBeginJava
{
  protected static String nl;
  public static synchronized TSQLiteRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSQLiteRowBeginJava result = new TSQLiteRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "java.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");" + NL + "" + NL + "String url_";
  protected final String TEXT_4 = " = \"jdbc:sqlite:\" + \"/\" + ";
  protected final String TEXT_5 = ".toLowerCase();" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_6 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_7 = ");" + NL + "" + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_8 = " = null;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_9 = " = false;" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_10 = "_QUERY\",";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + NL + "int commitEvery_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_15 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_16 = ".setAutoCommit(false);";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbencoding= ElementParameterParser.getValue(node, "__ENCODING__");
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
		   dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String javaDbDriver   = "org.sqlite.JDBC";  

    stringBuffer.append(TEXT_2);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_11);
    
if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
