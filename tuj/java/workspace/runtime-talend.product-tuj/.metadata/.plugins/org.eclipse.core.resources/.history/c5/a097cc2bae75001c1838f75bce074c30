package org.talend.designer.codegen.translators.business.sugarcrm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSugarCRMOutputBeginJava
{
  protected static String nl;
  public static synchronized TSugarCRMOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSugarCRMOutputBeginJava result = new TSugarCRMOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "        int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "        String modulename_";
  protected final String TEXT_3 = " = \"";
  protected final String TEXT_4 = "\";" + NL + "        org.talend.SugarManagement.SugarManagement sugarManagement_";
  protected final String TEXT_5 = " = new org.talend.SugarManagement.SugarManagementImpl(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ", \"sugarcrm\",\"4.5.0\");" + NL + "        sugarManagement_";
  protected final String TEXT_9 = ".login(); ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");

	String username = ElementParameterParser.getValue(node, "__USER__");
	String password = ElementParameterParser.getValue(node, "__PASS__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
