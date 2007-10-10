package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMysqlBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TMysqlBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlBulkExecBeginJava result = new TMysqlBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "String field_separator_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ";" + NL + "String file_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "String host_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";" + NL + "String port_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "String db_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "String user_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "String pas_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "String table_";
  protected final String TEXT_16 = " = ";
  protected final String TEXT_17 = ";" + NL + "String replace_";
  protected final String TEXT_18 = " = null;";
  protected final String TEXT_19 = NL + "\treplace_";
  protected final String TEXT_20 = " = \"REPLACE\";" + NL + "\t";
  protected final String TEXT_21 = NL + "\treplace_";
  protected final String TEXT_22 = " = \"\";" + NL + "\t";
  protected final String TEXT_23 = NL + NL + "Class.forName(\"com.mysql.jdbc.Driver\").newInstance();" + NL + "java.sql.Connection con_";
  protected final String TEXT_24 = "=java.sql.DriverManager.getConnection(\"jdbc:MySQL://\"+host_";
  protected final String TEXT_25 = "+\":\"+port_";
  protected final String TEXT_26 = "+\"/\"+db_";
  protected final String TEXT_27 = ", user_";
  protected final String TEXT_28 = ", pas_";
  protected final String TEXT_29 = ");" + NL + "java.sql.Statement stmt_";
  protected final String TEXT_30 = "=con_";
  protected final String TEXT_31 = ".createStatement();" + NL + "stmt_";
  protected final String TEXT_32 = ".execute(\"SET character_set_database=";
  protected final String TEXT_33 = "\");" + NL + "stmt_";
  protected final String TEXT_34 = ".execute(\"LOAD DATA LOCAL INFILE '\" + file_";
  protected final String TEXT_35 = " + \"' \" + replace_";
  protected final String TEXT_36 = " + \" INTO TABLE \"+table_";
  protected final String TEXT_37 = "+\" FIELDS TERMINATED BY '\"+field_separator_";
  protected final String TEXT_38 = "+\"'\");" + NL + "stmt_";
  protected final String TEXT_39 = ".close();" + NL + "con_";
  protected final String TEXT_40 = ".close();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String charset = "utf8";
if(encoding.equals("\"GBK\"")){
	charset = "gbk";
}else if(encoding.equals("\"GB2312\"")){
	charset = "gb2312";
}else if(encoding.equals("\"ISO-8859-1\"")){
	charset = "latin1";
}else if(encoding.equals("\"ISO-8859-2\"")){
	charset = "latin2";
}else if(encoding.equals("\"ISO-8859-15\"")){
	charset = "latin1";//?not sure if this is true for iso-8859-15
}else if(encoding.equals("\"Big5\"")){
	charset = "big5";
}else if(encoding.equals("\"UCS-2\"")){
	charset = "ucs2";
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDS_TERMINATED_BY__") );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILENAME__") );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HOST__") );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PORT__") );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DBNAME__") );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getValue(node, "__USER__") );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PASS__") );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TABLE__") );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
String isUpdate = ElementParameterParser.getValue(node, "__IS_UPDATE__");
if(isUpdate.equals("true"))
{
	
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    
}
else
{
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(charset );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
