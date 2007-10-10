package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileFetchMainJava
{
  protected static String nl;
  public static synchronized TFileFetchMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileFetchMainJava result = new TFileFetchMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString fileName";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\t" + NL + "\t//open directory" + NL + "\tjava.io.File dir";
  protected final String TEXT_5 = " = new java.io.File(";
  protected final String TEXT_6 = ");" + NL + "        \t\t" + NL + "    // open url stream" + NL + "\tjava.net.URL url";
  protected final String TEXT_7 = " = new java.net.URL(";
  protected final String TEXT_8 = ");" + NL + "\tjava.net.URLConnection conn";
  protected final String TEXT_9 = " = url";
  protected final String TEXT_10 = ".openConnection();" + NL + "\t" + NL + "\t//open file dans la directory" + NL + "\tif (fileName";
  protected final String TEXT_11 = ".compareTo(\"\")==0) {" + NL + "\t\tfileName";
  protected final String TEXT_12 = " = url";
  protected final String TEXT_13 = ".getFile();" + NL + "\t\tif (fileName";
  protected final String TEXT_14 = ".compareTo(\"\")==0) {" + NL + "\t\t\tfileName";
  protected final String TEXT_15 = " = \"defaultfilename.txt\";" + NL + "\t\t}" + NL + "\t}" + NL + "    final java.io.DataOutputStream out";
  protected final String TEXT_16 = "= new java.io.DataOutputStream(new java.io.FileOutputStream(new java.io.File(" + NL + "            dir";
  protected final String TEXT_17 = ", fileName";
  protected final String TEXT_18 = "))); " + NL + "\t// copy file" + NL + "    final java.io.DataInputStream in";
  protected final String TEXT_19 = " = new java.io.DataInputStream(conn";
  protected final String TEXT_20 = ".getInputStream());" + NL + "\t//close opened object" + NL + "    byte[] buffer";
  protected final String TEXT_21 = " = new byte[1024];" + NL + "    int count";
  protected final String TEXT_22 = " = 0;" + NL + "    while ((count";
  protected final String TEXT_23 = " = in";
  protected final String TEXT_24 = ".read(buffer";
  protected final String TEXT_25 = ")) > 0) {" + NL + "        out";
  protected final String TEXT_26 = ".write(buffer";
  protected final String TEXT_27 = ", 0, count";
  protected final String TEXT_28 = ");" + NL + "    }" + NL + "    // close opened object" + NL + "    in";
  protected final String TEXT_29 = ".close();" + NL + "    out";
  protected final String TEXT_30 = ".close();";
  protected final String TEXT_31 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");
String uri = ElementParameterParser.getValue(node, "__URI__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append((filename.compareTo("")!=0)?filename:"\"\"");
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
}
