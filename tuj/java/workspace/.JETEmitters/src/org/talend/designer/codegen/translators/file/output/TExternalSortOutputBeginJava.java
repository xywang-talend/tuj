package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TExternalSortOutputBeginJava
{
  protected static String nl;
  public static synchronized TExternalSortOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExternalSortOutputBeginJava result = new TExternalSortOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "//create directory only if not exists" + NL + "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = "\t" + NL + "\t\tString fileNewName_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";\t" + NL + "\t\t java.io.File createFile";
  protected final String TEXT_6 = " = new java.io.File(fileNewName_";
  protected final String TEXT_7 = ");" + NL + "\t\t if(!createFile";
  protected final String TEXT_8 = ".exists()){" + NL + "\t\t \t(new java.io.File(fileNewName_";
  protected final String TEXT_9 = ".substring(0,fileNewName_";
  protected final String TEXT_10 = ".lastIndexOf(\"/\")))).mkdirs();" + NL + "\t\t }" + NL + "\t";
  protected final String TEXT_11 = NL + "\t\tint nb_line_";
  protected final String TEXT_12 = " = 0;" + NL + "\t\t" + NL + "\t\tfinal String OUT_DELIM_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t" + NL + "\t\tfinal String OUT_DELIM_ROWSEP_";
  protected final String TEXT_15 = " = \"\\r\\n\";\t\t" + NL + "\t" + NL + "\t\tfinal java.io.File tempFile_";
  protected final String TEXT_16 = " = java.io.File.createTempFile(\"";
  protected final String TEXT_17 = "\", null);" + NL + "\t\ttempFile_";
  protected final String TEXT_18 = ".deleteOnExit();" + NL + "\t\t" + NL + "\t\tfinal java.io.BufferedWriter out_";
  protected final String TEXT_19 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "        \t\tnew java.io.FileOutputStream(tempFile_";
  protected final String TEXT_20 = ")));";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();	
	String fieldSeparator = ElementParameterParser.getValue(node,"__FIELDSEPARATOR__");
	String tempDir = ElementParameterParser.getValue(node,"__TEMP_DIR__");

    stringBuffer.append(TEXT_1);
    if(ElementParameterParser.getValue(node,"__CREATE__").equals("true")){
    stringBuffer.append(TEXT_2);
    String fileNewname = ElementParameterParser.getValue(node,"__FILENAME__");
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(fileNewname);
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
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
