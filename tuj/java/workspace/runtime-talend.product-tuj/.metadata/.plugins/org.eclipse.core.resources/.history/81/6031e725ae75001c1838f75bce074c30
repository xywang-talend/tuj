package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileRowCountMainJava
{
  protected static String nl;
  public static synchronized TFileRowCountMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileRowCountMainJava result = new TFileRowCountMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "        java.io.FileInputStream fis_";
  protected final String TEXT_3 = " = new java.io.FileInputStream(";
  protected final String TEXT_4 = ");" + NL + "        java.io.BufferedReader br_";
  protected final String TEXT_5 = " = new java.io.BufferedReader(new java.io.InputStreamReader(fis_";
  protected final String TEXT_6 = "));" + NL + "        int lineCount_";
  protected final String TEXT_7 = " = 0;" + NL + "" + NL + "        String rowSeparator_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "        byte[] bytes_";
  protected final String TEXT_10 = " = rowSeparator_";
  protected final String TEXT_11 = ".getBytes();" + NL + "        int index_";
  protected final String TEXT_12 = " = 0;" + NL + "" + NL + "        int oneChar_";
  protected final String TEXT_13 = " = 0;" + NL + "\t\t" + NL + "\t\tif(bytes_";
  protected final String TEXT_14 = ".length > 0) {" + NL + "            while ((oneChar_";
  protected final String TEXT_15 = " = br_";
  protected final String TEXT_16 = ".read()) != -1) {" + NL + "    " + NL + "                if (oneChar_";
  protected final String TEXT_17 = " == bytes_";
  protected final String TEXT_18 = "[index_";
  protected final String TEXT_19 = "]) {" + NL + "                    if (index_";
  protected final String TEXT_20 = " == bytes_";
  protected final String TEXT_21 = ".length - 1) {" + NL + "                        lineCount_";
  protected final String TEXT_22 = "++;" + NL + "                        index_";
  protected final String TEXT_23 = " = 0;" + NL + "                    } else {" + NL + "                        index_";
  protected final String TEXT_24 = "++;" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "        globalMap.put(\"";
  protected final String TEXT_25 = "_COUNT\",lineCount_";
  protected final String TEXT_26 = ");    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String filename = ElementParameterParser.getValue(
    node,
    "__FILENAME__"
);

String rowSeparator = ElementParameterParser.getValue(
    node,
    "__ROWSEPARATOR__"
);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}
