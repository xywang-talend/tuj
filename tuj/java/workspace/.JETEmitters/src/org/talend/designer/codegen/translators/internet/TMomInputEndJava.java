package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMomInputEndJava
{
  protected static String nl;
  public static synchronized TMomInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputEndJava result = new TMomInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t" + NL + "\t}" + NL + "\t";
  protected final String TEXT_3 = " flag";
  protected final String TEXT_4 = "=false;input";
  protected final String TEXT_5 = ".close();";
  protected final String TEXT_6 = "Thread.sleep(";
  protected final String TEXT_7 = "000);";
  protected final String TEXT_8 = "\t\t\t" + NL + "" + NL + "" + NL + "}";
  protected final String TEXT_9 = NL + "\t\t" + NL + "\t\tremoteQ";
  protected final String TEXT_10 = ".close();" + NL + "\t\tqMgr";
  protected final String TEXT_11 = ".disconnect();" + NL + "\t}" + NL + "\t}" + NL + "\tcatch(com.ibm.mq.MQException ex){" + NL + "\t\tSystem.out.println(\"A WebSphere MQ error occurred : Completion code \" + ex.completionCode + \" Reason code \" + ex.reasonCode);" + NL + "\t\tremoteQ";
  protected final String TEXT_12 = ".close();" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String serverType=ElementParameterParser.getValue(node, "__SERVER__");
String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
String timeOut=ElementParameterParser.getValue(node, "__TIMEOUT__");
if(serverType.equals("JBoss")){

    stringBuffer.append(TEXT_2);
    if(kListen.equals("false")){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    }else{
    stringBuffer.append(TEXT_6);
    stringBuffer.append(timeOut);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    
}else{

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
	}
	
    return stringBuffer.toString();
  }
}
