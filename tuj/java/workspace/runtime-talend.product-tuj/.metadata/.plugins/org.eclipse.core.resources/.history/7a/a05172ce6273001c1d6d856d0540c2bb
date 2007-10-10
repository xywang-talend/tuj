package org.talend.designer.codegen.translators.business;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TJasperOutputExecBeginJava
{
  protected static String nl;
  public static synchronized TJasperOutputExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJasperOutputExecBeginJava result = new TJasperOutputExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "       " + NL + "\tString fileName_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "    String jrxmlName_";
  protected final String TEXT_5 = " = fileName_";
  protected final String TEXT_6 = ".substring(fileName_";
  protected final String TEXT_7 = ".lastIndexOf(\"/\"),fileName_";
  protected final String TEXT_8 = ".lastIndexOf(\".\"));" + NL + "\tString jrxmlPath_";
  protected final String TEXT_9 = " = fileName_";
  protected final String TEXT_10 = ".substring(0,fileName_";
  protected final String TEXT_11 = ".lastIndexOf(\"/\"));" + NL + "    String sourceFile_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "\tString jasperFile_";
  protected final String TEXT_14 = " = jrxmlPath_";
  protected final String TEXT_15 = "+\"/\"+jrxmlName_";
  protected final String TEXT_16 = " + \".jasper\";" + NL + "    String reportFile_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "+jrxmlName_";
  protected final String TEXT_19 = "+\".";
  protected final String TEXT_20 = "\";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String filename = ElementParameterParser.getValue(node,"__JRXML_FILE__");
String sourceFile = ElementParameterParser.getValue(node,"__SOURCE_FILE__");
String destinationDirectory = ElementParameterParser.getValue(node,"__DESTINATION__");
String reportType = ElementParameterParser.getValue(node,"__REPORT_TYPE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(filename);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sourceFile);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(destinationDirectory);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(reportType);
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
