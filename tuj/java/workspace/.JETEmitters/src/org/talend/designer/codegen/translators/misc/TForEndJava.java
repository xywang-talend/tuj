package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TForEndJava
{
  protected static String nl;
  public static synchronized TForEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TForEndJava result = new TForEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_3 = "_CURRENT_ITERATION\",((Integer)globalMap.get(\"";
  protected final String TEXT_4 = "_CURRENT_ITERATION\"))+ ";
  protected final String TEXT_5 = ");" + NL + "}" + NL;
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String step = ElementParameterParser.getValue(node, "__STEP__");

if (step.equals("")) {
	step = "1";
}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(step);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
