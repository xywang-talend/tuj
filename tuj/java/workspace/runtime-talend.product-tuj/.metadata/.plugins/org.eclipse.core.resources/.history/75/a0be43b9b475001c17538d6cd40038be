package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.SubTreeArgument;
import org.talend.core.model.process.IConnectionCategory;

public class Subtree_endJava
{
  protected static String nl;
  public static synchronized Subtree_endJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Subtree_endJava result = new Subtree_endJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t// end for" + NL + "\t}";
  protected final String TEXT_2 = NL + NL + "} // End of branch \"";
  protected final String TEXT_3 = "\"" + NL;
  protected final String TEXT_4 = NL + NL;
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	SubTreeArgument subTreeArgument = (SubTreeArgument)codeGenArgument.getArgument();
	IConnection connection = subTreeArgument.getInputSubtreeConnection();
	
	if (subTreeArgument.isMultiplyingOutputComponents()) {

    stringBuffer.append(TEXT_1);
    
	}

    if(subTreeArgument.isSourceComponentHasConditionnalOutputs()
    	&& connection.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append( connection.getName());
    stringBuffer.append(TEXT_3);
     
} 

    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
