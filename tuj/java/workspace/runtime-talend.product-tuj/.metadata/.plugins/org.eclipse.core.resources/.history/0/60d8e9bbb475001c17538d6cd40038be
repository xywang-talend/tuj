package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileInputExcelEndJava
{
  protected static String nl;
  public static synchronized TFileInputExcelEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelEndJava result = new TFileInputExcelEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tnb_line_";
  protected final String TEXT_2 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tworkbook_";
  protected final String TEXT_3 = ".close();" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\",nb_line_";
  protected final String TEXT_5 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
