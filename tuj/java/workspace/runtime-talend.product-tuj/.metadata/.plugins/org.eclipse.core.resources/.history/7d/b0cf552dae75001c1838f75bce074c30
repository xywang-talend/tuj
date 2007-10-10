package org.talend.designer.codegen.translators.databases.postgresql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPostgresqlBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TPostgresqlBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPostgresqlBulkExecBeginJava result = new TPostgresqlBulkExecBeginJava();
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
  protected final String TEXT_17 = ";" + NL + "" + NL + "Class.forName(\"org.postgresql.Driver\").newInstance();" + NL + "java.sql.Connection con_";
  protected final String TEXT_18 = "=java.sql.DriverManager.getConnection(\"jdbc:postgresql://\"+host_";
  protected final String TEXT_19 = "+\":\"+port_";
  protected final String TEXT_20 = "+\"/\"+db_";
  protected final String TEXT_21 = ", user_";
  protected final String TEXT_22 = ", pas_";
  protected final String TEXT_23 = ");" + NL + "java.sql.Statement stmt_";
  protected final String TEXT_24 = "=con_";
  protected final String TEXT_25 = ".createStatement();" + NL + "//stmt.execute(\"SET client_encoding to 'UNICODE'\");" + NL + "stmt_";
  protected final String TEXT_26 = ".execute(\"copy \"+table_";
  protected final String TEXT_27 = "+\" from '\"+file_";
  protected final String TEXT_28 = "+\"' with delimiter '\"+field_separator_";
  protected final String TEXT_29 = "+\"'\");" + NL + "stmt_";
  protected final String TEXT_30 = ".close();" + NL + "con_";
  protected final String TEXT_31 = ".close();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
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
    return stringBuffer.toString();
  }
}
