package org.talend.designer.codegen.translators.databases.postgresql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TPostgresqlRowBeginJava
{
  protected static String nl;
  public static synchronized TPostgresqlRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPostgresqlRowBeginJava result = new TPostgresqlRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "java.sql.Connection conn_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "\tconn_";
  protected final String TEXT_5 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_6 = "\");" + NL + "\t";
  protected final String TEXT_7 = NL + "    java.lang.Class.forName(\"org.postgresql.Driver\");" + NL + "    " + NL + "    String url_";
  protected final String TEXT_8 = " = \"jdbc:postgresql://\"+";
  protected final String TEXT_9 = "+\":\"+";
  protected final String TEXT_10 = "+\"/\"+";
  protected final String TEXT_11 = ";" + NL + "    " + NL + "    String dbUser_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "    " + NL + "    String dbPwd_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "    " + NL + "    conn_";
  protected final String TEXT_16 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_17 = ",dbUser_";
  protected final String TEXT_18 = ",dbPwd_";
  protected final String TEXT_19 = ");\t" + NL + "\t";
  protected final String TEXT_20 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_21 = " = null;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_22 = " = false;" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_23 = "_QUERY\",";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "    " + NL + "        int commitEvery_";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ";" + NL + "        " + NL + "        int commitCounter_";
  protected final String TEXT_28 = " = 0;" + NL + "        " + NL + "        conn_";
  protected final String TEXT_29 = ".setAutoCommit(false);";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL;

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
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
	String dbencoding= ElementParameterParser.getValue(node, "__ENCODING__");
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");    
	       dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
if(useExistingConn.equals("true"))
{
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_6);
    
}
else
{
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_24);
    
if(!useExistingConn.equals("true"))
{
    if(!commitEvery.equals("")&&!commitEvery.equals("0")){
    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
    }
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
