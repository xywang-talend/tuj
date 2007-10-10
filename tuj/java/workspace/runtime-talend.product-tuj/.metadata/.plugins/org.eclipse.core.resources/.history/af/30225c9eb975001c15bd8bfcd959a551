package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class Component_part_endmainJava
{
  protected static String nl;
  public static synchronized Component_part_endmainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Component_part_endmainJava result = new Component_part_endmainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "Thread.sleep(2000);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean trace =  codeGenArgument.isTrace();

    stringBuffer.append(TEXT_1);
    
if ((trace)&&(node!=null)&&(!node.isThereLinkWithHash())) {

    stringBuffer.append(TEXT_2);
    
}

    return stringBuffer.toString();
  }
}
