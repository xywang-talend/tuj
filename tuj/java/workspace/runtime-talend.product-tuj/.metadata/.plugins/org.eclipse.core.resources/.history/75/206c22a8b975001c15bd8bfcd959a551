package org.talend.designer.codegen.translators.loganderror;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TWarnMainJava
{
  protected static String nl;
  public static synchronized TWarnMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWarnMainJava result = new TWarnMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = ".addMessage(\"tWarn\", \"";
  protected final String TEXT_5 = "\", ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ");" + NL + "\t";
  protected final String TEXT_9 = "Process();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    
			if (node.getProcess().getNodesOfType("tLogCatcher").size() > 0) {
				List<INode> logCatchers = (List<INode>)node.getProcess().getNodesOfType("tLogCatcher");
				for (INode logCatcher : logCatchers) {
					if (ElementParameterParser.getValue(logCatcher, "__CATCH_TWARN__").equals("true")) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PRIORITY__") );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_9);
    
					}
				}
			}

    return stringBuffer.toString();
  }
}
