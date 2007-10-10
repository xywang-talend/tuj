package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataTable;

public class TAdvancedFileOutputXMLEndJava
{
  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLEndJava result = new TAdvancedFileOutputXMLEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "if(currentRowCount_";
  protected final String TEXT_3 = " > 0){";
  protected final String TEXT_4 = NL + "    org.dom4j.io.XMLWriter output_";
  protected final String TEXT_5 = " = new org.dom4j.io.XMLWriter(new java.io.FileWriter(" + NL + "    \tnew java.io.File(fileName_";
  protected final String TEXT_6 = ")), format_";
  protected final String TEXT_7 = ");" + NL + "    output_";
  protected final String TEXT_8 = ".write(doc_";
  protected final String TEXT_9 = ");" + NL + "    output_";
  protected final String TEXT_10 = ".close();";
  protected final String TEXT_11 = NL + "}";
  protected final String TEXT_12 = NL + "globalMap.put(\"";
  protected final String TEXT_13 = "_NB_LINE\",nb_line_";
  protected final String TEXT_14 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	String split = ElementParameterParser.getValue(node, "__SPLIT__");
	if(split.equals("true")){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
	}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
	if(split.equals("true")){

    stringBuffer.append(TEXT_11);
    
	}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
}

    return stringBuffer.toString();
  }
}
