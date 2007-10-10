package org.talend.designer.codegen.translators.databases.oracle;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TOracleRowBeginJava
{
  protected static String nl;
  public static synchronized TOracleRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TOracleRowBeginJava result = new TOracleRowBeginJava();
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
  protected final String TEXT_7 = NL + "\tjava.lang.Class.forName(\"oracle.jdbc.driver.OracleDriver\");" + NL + "\t";
  protected final String TEXT_8 = NL + "\tString url_";
  protected final String TEXT_9 = " = url_";
  protected final String TEXT_10 = " = \"jdbc:oracle:thin:@\" + ";
  protected final String TEXT_11 = " + \":\" + ";
  protected final String TEXT_12 = " + \":\" + ";
  protected final String TEXT_13 = ";" + NL + "\t";
  protected final String TEXT_14 = NL + "\tString url_";
  protected final String TEXT_15 = " = url_";
  protected final String TEXT_16 = " = \"jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=\" + ";
  protected final String TEXT_17 = " + \")(port=\" + ";
  protected final String TEXT_18 = " + \"))(connect_data=(service_name=\" + ";
  protected final String TEXT_19 = " + \")))\";" + NL + "\t";
  protected final String TEXT_20 = NL + NL + "\tString dbUser_";
  protected final String TEXT_21 = " = ";
  protected final String TEXT_22 = ";" + NL + "\tString dbPwd_";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = ";" + NL + "" + NL + "\tconn_";
  protected final String TEXT_25 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_26 = ",dbUser_";
  protected final String TEXT_27 = ",dbPwd_";
  protected final String TEXT_28 = ");" + NL + "\t";
  protected final String TEXT_29 = NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_30 = " = null;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_31 = " = false;" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_32 = "_QUERY\",";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + NL + "int commitEvery_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_37 = " = 0;" + NL + "" + NL + "if(conn_";
  protected final String TEXT_38 = ".getAutoCommit())" + NL + "{" + NL + "\tconn_";
  protected final String TEXT_39 = ".setAutoCommit(false);" + NL + "}";
  protected final String TEXT_40 = NL + NL + NL + NL;
  protected final String TEXT_41 = NL;

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
	commitEvery = "0";
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
    
	String connectionType = ElementParameterParser.getValue(node, "__CONNECTION_TYPE__");
	if(connectionType.equals("ORACLE_SID")) {
	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_13);
    
		} else if(connectionType.equals("ORACLE_SERVICE_NAME")) {
	
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_19);
    
	}
	
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_33);
    
if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
