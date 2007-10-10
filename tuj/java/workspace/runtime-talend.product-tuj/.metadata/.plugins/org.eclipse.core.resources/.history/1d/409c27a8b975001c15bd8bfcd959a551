package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPGetMainJava
{
  protected static String nl;
  public static synchronized TSCPGetMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPGetMainJava result = new TSCPGetMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "        " + NL + "        String parentPath_";
  protected final String TEXT_3 = " = new java.io.File(";
  protected final String TEXT_4 = ").getPath();" + NL + "        java.util.List<String> list_";
  protected final String TEXT_5 = " = new java.util.ArrayList<String>();" + NL + "        for (int i_";
  protected final String TEXT_6 = " = 0; i_";
  protected final String TEXT_7 = " < sourceFileNames_";
  protected final String TEXT_8 = ".length; i_";
  protected final String TEXT_9 = "++) {" + NL + "            String fileName_";
  protected final String TEXT_10 = " = sourceFileNames_";
  protected final String TEXT_11 = "[i_";
  protected final String TEXT_12 = "];" + NL + "            if (!new java.io.File(parentPath_";
  protected final String TEXT_13 = " + \"/\" + fileName_";
  protected final String TEXT_14 = ").exists()) {" + NL + "                list_";
  protected final String TEXT_15 = ".add(fileName_";
  protected final String TEXT_16 = ");" + NL + "            }" + NL + "        }" + NL + "        sourceFileNames_";
  protected final String TEXT_17 = " = (String[]) list_";
  protected final String TEXT_18 = ".toArray(new String[0]);";
  protected final String TEXT_19 = NL + NL + "        if(sourceFileNames_";
  protected final String TEXT_20 = "!=null && sourceFileNames_";
  protected final String TEXT_21 = ".length!=0){" + NL + "            scp_";
  protected final String TEXT_22 = ".get(sourceFileNames_";
  protected final String TEXT_23 = " , ";
  protected final String TEXT_24 = ");" + NL + "        }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
        CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
        INode node = (INode)codeGenArgument.getArgument();
        String cid = node.getUniqueName();      

        String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");
        
        boolean replaceFiles = ElementParameterParser.getValue(node,"__REPLACE_FILES__").equals("true");

     if(!replaceFiles) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(localdir );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
     }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(localdir );
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
