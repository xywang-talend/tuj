package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TGroovyFileBeginJava
{
  protected static String nl;
  public static synchronized TGroovyFileBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGroovyFileBeginJava result = new TGroovyFileBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "groovy.lang.GroovyShell shell_";
  protected final String TEXT_3 = " = new groovy.lang.GroovyShell();" + NL + "shell_";
  protected final String TEXT_4 = ".evaluate(new java.io.FileInputStream(new java.io.File(";
  protected final String TEXT_5 = ")));" + NL;
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String groovyFile = ElementParameterParser.getValue(node, "__GROOVY_FILE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(groovyFile);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
