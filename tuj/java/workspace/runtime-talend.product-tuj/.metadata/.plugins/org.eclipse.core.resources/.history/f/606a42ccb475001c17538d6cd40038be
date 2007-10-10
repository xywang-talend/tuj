package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSalesforceOutputBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputBeginJava result = new TSalesforceOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "        int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "" + NL + "        org.talend.salesforce.SforceManagement sforceManagement_";
  protected final String TEXT_3 = " = new org.talend.salesforce.SforceManagementImpl();" + NL + "        " + NL + "        sforceManagement_";
  protected final String TEXT_4 = ".login(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    	
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

	String username = ElementParameterParser.getValue(node, "__USER__");
	String password = ElementParameterParser.getValue(node, "__PASS__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
