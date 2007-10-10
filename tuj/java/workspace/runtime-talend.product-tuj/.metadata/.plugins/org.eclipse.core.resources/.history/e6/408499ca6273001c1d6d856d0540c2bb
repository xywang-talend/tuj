package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TArrayEndJava
{
  protected static String nl;
  public static synchronized TArrayEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TArrayEndJava result = new TArrayEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "globalMap.put(\"";
  protected final String TEXT_2 = "\",";
  protected final String TEXT_3 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();	
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
