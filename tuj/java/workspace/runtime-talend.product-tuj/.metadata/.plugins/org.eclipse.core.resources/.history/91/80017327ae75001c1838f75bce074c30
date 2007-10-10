package org.talend.designer.codegen.translators.databases.interbase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TInterbaseRowBeginJava
{
  protected static String nl;
  public static synchronized TInterbaseRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TInterbaseRowBeginJava result = new TInterbaseRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "java.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");" + NL + "" + NL + "String url_";
  protected final String TEXT_4 = " = \"jdbc:interbase://\" + ";
  protected final String TEXT_5 = " + \"/\" + ";
  protected final String TEXT_6 = ";" + NL + "" + NL + "String userName_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "String password_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_11 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_12 = ",userName_";
  protected final String TEXT_13 = ",password_";
  protected final String TEXT_14 = ");" + NL + "" + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_15 = " = null;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_16 = " = false;" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_17 = "_QUERY\",";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + NL + "int commitEvery_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_22 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_23 = ".setAutoCommit(false);";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String host =  ElementParameterParser.getValue(node, "__HOST__");
	
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	
	String username = ElementParameterParser.getValue(node, "__USER__");
	
	String password = ElementParameterParser.getValue(node, "__PASS__");
			
	String dbencoding= ElementParameterParser.getValue(node, "__ENCODING__");
	
	String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
		   dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");
    	   
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    
    String javaDbDriver   = "interbase.interclient.Driver";  

    stringBuffer.append(TEXT_2);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_18);
    
if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}
