package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TWaitForFileEndJava
{
  protected static String nl;
  public static synchronized TWaitForFileEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWaitForFileEndJava result = new TWaitForFileEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    if(true){" + NL + "        break;" + NL + "    }";
  protected final String TEXT_2 = NL + "    if(false){" + NL + "        break;" + NL + "    }";
  protected final String TEXT_3 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();


    if(ElementParameterParser.getValue(node, "__THEN__").equals("exitloop")){
    stringBuffer.append(TEXT_1);
     } else { 
    stringBuffer.append(TEXT_2);
     }
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
