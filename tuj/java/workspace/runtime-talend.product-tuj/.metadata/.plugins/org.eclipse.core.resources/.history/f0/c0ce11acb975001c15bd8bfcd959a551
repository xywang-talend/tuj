package org.talend.designer.codegen.translators.databases.hsqldb;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THSQLDbInputEndJava
{
  protected static String nl;
  public static synchronized THSQLDbInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THSQLDbInputEndJava result = new THSQLDbInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "}" + NL + "stmt_";
  protected final String TEXT_3 = ".close();" + NL + "java.sql.Statement stmtClose_";
  protected final String TEXT_4 = " = conn_";
  protected final String TEXT_5 = ".createStatement();" + NL + "stmtClose_";
  protected final String TEXT_6 = ".execute(\"SHUTDOWN\");" + NL + "conn_";
  protected final String TEXT_7 = " .close();" + NL + "globalMap.put(\"";
  protected final String TEXT_8 = "_NB_LINE\",nb_line_";
  protected final String TEXT_9 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
