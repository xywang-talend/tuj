package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFileListBeginJava
{
  protected static String nl;
  public static synchronized TFileListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileListBeginJava result = new TFileListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//tFileList_Begin";
  protected final String TEXT_2 = NL + NL + "        String directory";
  protected final String TEXT_3 = "       = ";
  protected final String TEXT_4 = ";" + NL + "        String filemask";
  protected final String TEXT_5 = "        = ";
  protected final String TEXT_6 = "+\"$\";" + NL + "        boolean flag";
  protected final String TEXT_7 = "=false;" + NL + "        if(filemask";
  protected final String TEXT_8 = ".indexOf(\"^\")==-1) " + NL + "        {" + NL + "            filemask";
  protected final String TEXT_9 = "=\"^\"+filemask";
  protected final String TEXT_10 = ";" + NL + "        }" + NL + "        if(!(filemask";
  protected final String TEXT_11 = ".lastIndexOf(\".*$\")==-1) &&  filemask";
  protected final String TEXT_12 = ".lastIndexOf(\"*.*$\")==-1)" + NL + "        {" + NL + "            filemask";
  protected final String TEXT_13 = "=filemask";
  protected final String TEXT_14 = ".substring(0,filemask";
  protected final String TEXT_15 = ".length()-3)+\"$\";" + NL + "            flag";
  protected final String TEXT_16 = "=true;" + NL + "        }else{" + NL + "            filemask";
  protected final String TEXT_17 = " = java.util.regex.Pattern.compile(\"[*]\").matcher(filemask";
  protected final String TEXT_18 = ").replaceAll(\".*\");" + NL + "        }" + NL + "       " + NL + "        boolean case_sensitive";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ";" + NL + "\t\tjava.util.regex.Pattern fileNamePattern";
  protected final String TEXT_21 = " = java.util.regex.Pattern.compile(filemask";
  protected final String TEXT_22 = ");" + NL + "\t\tif(!case_sensitive";
  protected final String TEXT_23 = "){" + NL + "        \tfileNamePattern";
  protected final String TEXT_24 = " = java.util.regex.Pattern.compile(filemask";
  protected final String TEXT_25 = ", java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "\t\t}       " + NL + " \t\tjava.io.File file";
  protected final String TEXT_26 = "=new java.io.File(directory";
  protected final String TEXT_27 = ");" + NL + "        final java.util.List<java.io.File> list_";
  protected final String TEXT_28 = "= new java.util.ArrayList<java.io.File>(); ";
  protected final String TEXT_29 = NL + "        file";
  protected final String TEXT_30 = ".listFiles(new java.io.FilenameFilter() {" + NL + "            public boolean accept(java.io.File dir, String name) {" + NL + "                java.io.File file = new java.io.File(dir, name);" + NL + "                if (file.isFile()) {" + NL + "                    list_";
  protected final String TEXT_31 = ".add(file);" + NL + "                    return true;" + NL + "                } else {" + NL + "                " + NL + "                    file.listFiles(this);" + NL + "                }" + NL + "                return false;" + NL + "            }" + NL + "        });";
  protected final String TEXT_32 = " " + NL + " file";
  protected final String TEXT_33 = ".listFiles(new java.io.FilenameFilter() {" + NL + "     public boolean accept(java.io.File dir, String name) {" + NL + "         java.io.File file = new java.io.File(dir, name);" + NL + "             list_";
  protected final String TEXT_34 = ".add(file);" + NL + "             return true;" + NL + "     }" + NL + " });";
  protected final String TEXT_35 = " " + NL + "        for (int i";
  protected final String TEXT_36 = " = 0; i";
  protected final String TEXT_37 = " < list_";
  protected final String TEXT_38 = ".size(); i";
  protected final String TEXT_39 = "++){" + NL + "            " + NL + "            java.io.File files";
  protected final String TEXT_40 = " =list_";
  protected final String TEXT_41 = ".get(i";
  protected final String TEXT_42 = ");" + NL + "            String fileName";
  protected final String TEXT_43 = "=files";
  protected final String TEXT_44 = ".getName();" + NL + "            if(flag";
  protected final String TEXT_45 = "==true)" + NL + "            {" + NL + "                if(!(fileName";
  protected final String TEXT_46 = ".indexOf(\".\")==-1))" + NL + "                {" + NL + "                    if(!fileNamePattern";
  protected final String TEXT_47 = ".matcher(fileName";
  protected final String TEXT_48 = ".substring(0,fileName";
  protected final String TEXT_49 = ".indexOf(\".\"))).find()){" + NL + "                        continue;" + NL + "                    }" + NL + "                }else" + NL + "                {" + NL + "                    if(!fileNamePattern";
  protected final String TEXT_50 = ".matcher(fileName";
  protected final String TEXT_51 = ").find()){" + NL + "                        continue;" + NL + "                    }" + NL + "                }" + NL + "            }else" + NL + "            {" + NL + "                if(!fileNamePattern";
  protected final String TEXT_52 = ".matcher(fileName";
  protected final String TEXT_53 = ").find()){" + NL + "                    continue;" + NL + "                }" + NL + "            }" + NL + "           " + NL + "            String currentFileName_";
  protected final String TEXT_54 = " = files";
  protected final String TEXT_55 = ".getName(); " + NL + "            String currentFilePath_";
  protected final String TEXT_56 = " = files";
  protected final String TEXT_57 = ".getAbsolutePath();" + NL + "            " + NL + "            globalMap.put(\"";
  protected final String TEXT_58 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_59 = ");" + NL + "            globalMap.put(\"";
  protected final String TEXT_60 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
    boolean incldSubdir=ElementParameterParser.getValue(node, "__INCLUDSUBDIR__").equals("true");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILEMASK__"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__").equals("YES") );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
   if(incldSubdir==true)
   {
 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    }else{
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(TEXT_62);
    return stringBuffer.toString();
  }
}
