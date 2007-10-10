package org.talend.designer.codegen.translators.business.vtigercrm;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TVtigerCRMOutputBeginJava
{
  protected static String nl;
  public static synchronized TVtigerCRMOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVtigerCRMOutputBeginJava result = new TVtigerCRMOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "org.talend.vtiger.IVtigerManager vtigerManager_";
  protected final String TEXT_2 = " = new org.talend.vtiger.VtigerManager(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = ", ";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "    java.util.List<org.talend.vtiger.module.outlook.Clndrdetail> clndrDetais_";
  protected final String TEXT_9 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Clndrdetail>(); ";
  protected final String TEXT_10 = NL + "    java.util.List<org.talend.vtiger.module.outlook.Contactdetail> contactdetails_";
  protected final String TEXT_11 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Contactdetail>();";
  protected final String TEXT_12 = NL + "    java.util.List<org.talend.vtiger.module.outlook.Taskdetail> taskdetails_";
  protected final String TEXT_13 = " = new java.util.ArrayList<org.talend.vtiger.module.outlook.Taskdetail>();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String serverAddr = ElementParameterParser.getValue(node, "__SERVERADDR__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String userName = ElementParameterParser.getValue(node, "__USERNAME__");
String password = ElementParameterParser.getValue(node, "__PASSWORD__");
String version = ElementParameterParser.getValue(node, "__VERSION__");
String method = ElementParameterParser.getValue(node, "__METHODNAME__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(serverAddr);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_7);
    
if(method.equals("addClndr") || method.equals("updateClndr")) {
    
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    
} else if(method.equals("addContacts") || method.equals("updateContacts")) {
    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
} else if(method.equals("addTasks") || method.equals("updateTasks")) {
    
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
}

    return stringBuffer.toString();
  }
}
