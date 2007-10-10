package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TFileInputDelimitedEndJava
{
  protected static String nl;
  public static synchronized TFileInputDelimitedEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputDelimitedEndJava result = new TFileInputDelimitedEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "}" + NL + "fid_";
  protected final String TEXT_2 = ".close();" + NL + "globalMap.put(\"";
  protected final String TEXT_3 = "_NB_LINE\", fid_";
  protected final String TEXT_4 = ".getRowNumber());";
  protected final String TEXT_5 = NL + "  ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
