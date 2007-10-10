package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TFileTouchMainJava
{
  protected static String nl;
  public static synchronized TFileTouchMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileTouchMainJava result = new TFileTouchMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = "     " + NL + "        java.io.File file_";
  protected final String TEXT_3 = " = new java.io.File( ";
  protected final String TEXT_4 = ");" + NL + "        boolean result";
  protected final String TEXT_5 = " = file_";
  protected final String TEXT_6 = ".createNewFile();";
  protected final String TEXT_7 = NL + "        if (!result";
  protected final String TEXT_8 = ") {" + NL + "        \tfile_";
  protected final String TEXT_9 = ".delete();" + NL + "        \tfile_";
  protected final String TEXT_10 = ".createNewFile();" + NL + "        }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");	
	boolean replaceFile=ElementParameterParser.getValue(node,"__REPLACE_FILE__").equals("true");
   

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(fileName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
	if (replaceFile) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
	}

    return stringBuffer.toString();
  }
}
