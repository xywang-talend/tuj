package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.SubTreeArgument;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class Subtree_beginJava
{
  protected static String nl;
  public static synchronized Subtree_beginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Subtree_beginJava result = new Subtree_beginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "// Start of branch \"";
  protected final String TEXT_2 = "\"" + NL + "if(";
  protected final String TEXT_3 = " != null) {" + NL;
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	SubTreeArgument subTreeArgument = (SubTreeArgument)codeGenArgument.getArgument();
	IConnection connection = subTreeArgument.getInputSubtreeConnection();

    if(subTreeArgument.isSourceComponentHasConditionnalOutputs()
    	&& connection.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append( connection.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append( connection.getName());
    stringBuffer.append(TEXT_3);
     
	} 

    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
