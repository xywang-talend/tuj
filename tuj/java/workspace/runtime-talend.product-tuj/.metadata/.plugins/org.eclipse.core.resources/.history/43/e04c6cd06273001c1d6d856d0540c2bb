package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TFileDeleteMainJava
{
  protected static String nl;
  public static synchronized TFileDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileDeleteMainJava result = new TFileDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    java.io.File file_";
  protected final String TEXT_2 = "=new java.io.File(";
  protected final String TEXT_3 = ");" + NL + "    if(file_";
  protected final String TEXT_4 = ".exists()&& file_";
  protected final String TEXT_5 = ".isFile())" + NL + "    {" + NL + "    \tfile_";
  protected final String TEXT_6 = ".delete();" + NL + "    }";
  protected final String TEXT_7 = NL + "    else{" + NL + "    \tthrow new Exception();" + NL + "    }";
  protected final String TEXT_8 = NL + "    \t" + NL + "    \t" + NL + "     ";
  protected final String TEXT_9 = NL + " ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
String failon = ElementParameterParser.getValue(node, "__FAILON__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
	if(failon.equals("true")){

    stringBuffer.append(TEXT_7);
    
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
