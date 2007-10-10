package org.talend.designer.codegen.translators.test;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TAssertMainJava
{
  protected static String nl;
  public static synchronized TAssertMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAssertMainJava result = new TAssertMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + " if(";
  protected final String TEXT_4 = ") {" + NL + "\t";
  protected final String TEXT_5 = ".addMessage(pid, projectName, jobName, \"java\", \"";
  protected final String TEXT_6 = "\", \"Ok\", \"--\", ";
  protected final String TEXT_7 = ");" + NL + "\t";
  protected final String TEXT_8 = "Process();" + NL + "}else {" + NL + "\t";
  protected final String TEXT_9 = ".addMessage(pid, projectName, jobName, \"java\", \"";
  protected final String TEXT_10 = "\", \"Failed\", \"Test logically failed\", ";
  protected final String TEXT_11 = ");" + NL + "\t";
  protected final String TEXT_12 = "Process();\t" + NL + "}\t\t\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String description = ElementParameterParser.getValue(node, "__DESCRIPTION__");
	String expression = ElementParameterParser.getValue(node, "__EXPRESSION__");

    stringBuffer.append(TEXT_2);
    
			if (node.getProcess().getNodesOfType("tAssertCatcher").size() > 0) {
				List<INode> assertCatchers = (List<INode>)node.getProcess().getNodesOfType("tAssertCatcher");
				for (INode assertCatcher : assertCatchers) {
					if (ElementParameterParser.getValue(assertCatcher, "__CATCH_TASSERT__").equals("true")) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(expression );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(description.trim().length()==0?"null":description );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(description.trim().length()==0?"null":description );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_12);
    
					}
				}
			}

    return stringBuffer.toString();
  }
}
