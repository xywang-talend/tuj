package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomOutputEndJava
{
  protected static String nl;
  public static synchronized TMomOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomOutputEndJava result = new TMomOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tsession_";
  protected final String TEXT_3 = ".close();" + NL + "    connection_";
  protected final String TEXT_4 = ".close();";
  protected final String TEXT_5 = NL + "\tremoteQ_";
  protected final String TEXT_6 = ".close();" + NL + "    qMgr_";
  protected final String TEXT_7 = ".disconnect();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
if(serverType.equals("JBoss")){
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
}else{//server judgement   /***WebSphere MQ*****/

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
}

    return stringBuffer.toString();
  }
}
