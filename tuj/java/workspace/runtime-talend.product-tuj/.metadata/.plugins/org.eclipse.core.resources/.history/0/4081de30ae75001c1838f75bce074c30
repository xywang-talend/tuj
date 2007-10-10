package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TContextLoadEndJava
{
  protected static String nl;
  public static synchronized TContextLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TContextLoadEndJava result = new TContextLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "java.util.Enumeration<?> enu_";
  protected final String TEXT_3 = " = context.propertyNames();" + NL + "    while(enu_";
  protected final String TEXT_4 = ".hasMoreElements())" + NL + "    {           " + NL + "    \tString key_";
  protected final String TEXT_5 = " = (String)enu_";
  protected final String TEXT_6 = ".nextElement();" + NL + "        if(!assignList_";
  protected final String TEXT_7 = ".contains(key_";
  protected final String TEXT_8 = "))" + NL + "         {" + NL + "             System.err.println(\"Warning ! Parameter \" + key_";
  protected final String TEXT_9 = " + \" has not been set by ";
  protected final String TEXT_10 = "\");" + NL + "         }          " + NL + "    }";
  protected final String TEXT_11 = "  " + NL + "    globalMap.put(\"";
  protected final String TEXT_12 = "_NB_LINE\",nb_line_";
  protected final String TEXT_13 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    boolean disWarning=ElementParameterParser.getValue(node, "__DISABLE_WARNINGS__").equals("true");
    

    if(!disWarning==true){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
