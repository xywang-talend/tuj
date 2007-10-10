package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IContextParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class ContextJava
{
  protected static String nl;
  public static synchronized ContextJava create(String lineSeparator)
  {
    nl = lineSeparator;
    ContextJava result = new ContextJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "=";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	List<IContextParameter> parameterList = (List<IContextParameter>) codeGenArgument.getArgument();
	for (IContextParameter parameter : parameterList) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(parameter.getName() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(parameter.getValue() );
    stringBuffer.append("\r\n" );
    
	}

    return stringBuffer.toString();
  }
}
