package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;

public class TFileArchiveMainJava
{
  protected static String nl;
  public static synchronized TFileArchiveMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileArchiveMainJava result = new TFileArchiveMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + NL + "        String sourceDir_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = ";      " + NL + "        java.io.File file_";
  protected final String TEXT_4 = " = new java.io.File(sourceDir_";
  protected final String TEXT_5 = ");" + NL + "        String zipFile_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";" + NL + "        int level_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ";" + NL + "        " + NL + "        final java.util.List<java.io.File> list_";
  protected final String TEXT_10 = " = new java.util.ArrayList<java.io.File>();  ";
  protected final String TEXT_11 = "  " + NL + "    \t" + NL + "    \tString[] patterns_";
  protected final String TEXT_12 = " = new String[] {";
  protected final String TEXT_13 = " " + NL + "        \t\t\t";
  protected final String TEXT_14 = ",        ";
  protected final String TEXT_15 = "        " + NL + "  \t\t};  " + NL + "  \t\t" + NL + "  \t\tStringBuffer sbf_";
  protected final String TEXT_16 = " = new StringBuffer(); " + NL + "        sbf_";
  protected final String TEXT_17 = ".append(\"(\");" + NL + "        for (int i_";
  protected final String TEXT_18 = " = 0; i_";
  protected final String TEXT_19 = " < patterns_";
  protected final String TEXT_20 = ".length; i_";
  protected final String TEXT_21 = "++) {" + NL + "            sbf_";
  protected final String TEXT_22 = ".append(patterns_";
  protected final String TEXT_23 = "[i_";
  protected final String TEXT_24 = "].replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\"));" + NL + "            if(i_";
  protected final String TEXT_25 = " != patterns_";
  protected final String TEXT_26 = ".length-1) sbf_";
  protected final String TEXT_27 = ".append(\"|\");" + NL + "        }        " + NL + "        sbf_";
  protected final String TEXT_28 = ".append(\")\");" + NL + "        final String maskStr_";
  protected final String TEXT_29 = " = new String(sbf_";
  protected final String TEXT_30 = ".toString());" + NL + "        " + NL + "        file_";
  protected final String TEXT_31 = ".listFiles(new java.io.FilenameFilter() {" + NL + "" + NL + "            public boolean accept(java.io.File dir, String name) {" + NL + "                java.io.File file = new java.io.File(dir, name);" + NL + "                if (file.isFile()) {                            " + NL + "                    if (name.matches(maskStr_";
  protected final String TEXT_32 = ")) {" + NL + "                        list_";
  protected final String TEXT_33 = ".add(file);" + NL + "                        return true;" + NL + "                    }            " + NL + "                }";
  protected final String TEXT_34 = "  " + NL + "                else" + NL + "                {   " + NL + "                \tfile.listFiles(this);                    " + NL + "                }";
  protected final String TEXT_35 = "                  " + NL + "                return false;" + NL + "            }" + NL + "        });";
  protected final String TEXT_36 = " " + NL + "        file_";
  protected final String TEXT_37 = ".listFiles(new java.io.FilenameFilter() {" + NL + "" + NL + "            public boolean accept(java.io.File dir, String name) {" + NL + "                java.io.File file = new java.io.File(dir, name);" + NL + "                if (file.isFile()) {" + NL + "                    list_";
  protected final String TEXT_38 = ".add(file);" + NL + "                    return true;" + NL + "                }";
  protected final String TEXT_39 = "  " + NL + "                else" + NL + "                {   " + NL + "                \tfile.listFiles(this);                    " + NL + "                }";
  protected final String TEXT_40 = "   " + NL + "                return false;" + NL + "            }" + NL + "        });";
  protected final String TEXT_41 = "     " + NL + "      org.apache.tools.zip.ZipOutputStream out_";
  protected final String TEXT_42 = " = null;" + NL + "      if (list_";
  protected final String TEXT_43 = ".size() > 0) {" + NL + "      \tint beginIndex_";
  protected final String TEXT_44 = " = file_";
  protected final String TEXT_45 = ".getPath().length()+1;" + NL + "        out_";
  protected final String TEXT_46 = " = new org.apache.tools.zip.ZipOutputStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(zipFile_";
  protected final String TEXT_47 = "))); " + NL + "        out_";
  protected final String TEXT_48 = ".setLevel(level_";
  protected final String TEXT_49 = ");" + NL + "        // here get the file list" + NL + "        for (int i_";
  protected final String TEXT_50 = " = 0; i_";
  protected final String TEXT_51 = " < list_";
  protected final String TEXT_52 = ".size(); i_";
  protected final String TEXT_53 = "++) {" + NL + "            java.io.BufferedInputStream in_";
  protected final String TEXT_54 = " = new java.io.BufferedInputStream(new java.io.FileInputStream(list_";
  protected final String TEXT_55 = ".get(i_";
  protected final String TEXT_56 = ")));" + NL + "            out_";
  protected final String TEXT_57 = ".putNextEntry(new org.apache.tools.zip.ZipEntry(list_";
  protected final String TEXT_58 = ".get(i_";
  protected final String TEXT_59 = ").getPath().substring(beginIndex_";
  protected final String TEXT_60 = ")));" + NL + "                        " + NL + "            int readLen_";
  protected final String TEXT_61 = ";" + NL + "            byte[] buf_";
  protected final String TEXT_62 = "=new byte[1024];" + NL + "            while ((readLen_";
  protected final String TEXT_63 = " = in_";
  protected final String TEXT_64 = ".read(buf_";
  protected final String TEXT_65 = ",0,1024)) != -1)  out_";
  protected final String TEXT_66 = ".write(buf_";
  protected final String TEXT_67 = ", 0, readLen_";
  protected final String TEXT_68 = ");" + NL + "            in_";
  protected final String TEXT_69 = ".close();        " + NL + "        }        " + NL + "      }" + NL + "      " + NL + "      if (out_";
  protected final String TEXT_70 = " != null)  out_";
  protected final String TEXT_71 = ".close();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();	

	String directory = ElementParameterParser.getValue(node, "__SOURCE__");
	String zipFile = ElementParameterParser.getValue(node, "__TARGET__");
	String level = ElementParameterParser.getValue(node, "__LEVEL__");
	boolean isAllFile = ElementParameterParser.getValue(node, "__ALL_FILES__").equals("false");
	boolean subDir = ElementParameterParser.getValue(node, "__SUB_DIRECTROY__").equals("true");
	List<Map<String, String>> masks = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MASK__");	

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(zipFile );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(level );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
     
	if (isAllFile==true) { 

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
    for (int i=0; i < masks.size(); i++) {
       Map<String, String> line = masks.get(i);

    stringBuffer.append(TEXT_13);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_14);
    
   }	

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
     
	if (isAllFile==true) { 

    stringBuffer.append(TEXT_34);
    
  }

    stringBuffer.append(TEXT_35);
     
   } else {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
     
	if (subDir==true) { 

    stringBuffer.append(TEXT_39);
    
  }

    stringBuffer.append(TEXT_40);
    
   }

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    return stringBuffer.toString();
  }
}
