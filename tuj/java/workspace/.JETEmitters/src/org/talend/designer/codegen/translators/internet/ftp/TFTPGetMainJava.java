package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPGetMainJava
{
  protected static String nl;
  public static synchronized TFTPGetMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPGetMainJava result = new TFTPGetMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t";
  protected final String TEXT_3 = "\t" + NL + "\tftp";
  protected final String TEXT_4 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);";
  protected final String TEXT_5 = "\t" + NL + "\tftp";
  protected final String TEXT_6 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.ASCII);";
  protected final String TEXT_7 = NL + "\tString localdir";
  protected final String TEXT_8 = "  = ";
  protected final String TEXT_9 = ";" + NL + "\tString root";
  protected final String TEXT_10 = " = ftp";
  protected final String TEXT_11 = ".pwd();" + NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_12 = " : list";
  protected final String TEXT_13 = ") " + NL + "\t{" + NL + "\tjava.util.Set<String> keySet";
  protected final String TEXT_14 = " = map";
  protected final String TEXT_15 = ".keySet();" + NL + "   " + NL + "\tfor (String key";
  protected final String TEXT_16 = " : keySet";
  protected final String TEXT_17 = ")" + NL + "\t{     " + NL + "\tString filemask";
  protected final String TEXT_18 = " = key";
  protected final String TEXT_19 = "; " + NL + "\tString dir";
  protected final String TEXT_20 = " = null;" + NL + "\tString mask";
  protected final String TEXT_21 = " = filemask";
  protected final String TEXT_22 = ".replaceAll(\"\\\\\\\\\", \"/\") ;  " + NL + "\tint i";
  protected final String TEXT_23 = " = mask";
  protected final String TEXT_24 = ".lastIndexOf('/');   " + NL + "\tif (i";
  protected final String TEXT_25 = "!=-1)" + NL + "\t{" + NL + "\tdir";
  protected final String TEXT_26 = " = mask";
  protected final String TEXT_27 = ".substring(0, i";
  protected final String TEXT_28 = "); " + NL + "\tmask";
  protected final String TEXT_29 = " = mask";
  protected final String TEXT_30 = ".substring(i";
  protected final String TEXT_31 = "+1);  " + NL + "    }" + NL + "    if (dir";
  protected final String TEXT_32 = "!=null && !\"\".equals(dir";
  protected final String TEXT_33 = ")) ftp";
  protected final String TEXT_34 = ".chdir(dir";
  protected final String TEXT_35 = ");" + NL + "    " + NL + "  \tmask";
  protected final String TEXT_36 = " = mask";
  protected final String TEXT_37 = ".replaceAll(\"\\\\.\", \"\\\\\\\\.\").replaceAll(\"\\\\*\", \".*\");" + NL + "  " + NL + "\tString[] listings";
  protected final String TEXT_38 = " = ftp";
  protected final String TEXT_39 = ".dir(\".\", false);" + NL + "\t" + NL + "    for (int m";
  protected final String TEXT_40 = " = 0; m";
  protected final String TEXT_41 = " < listings";
  protected final String TEXT_42 = ".length; m";
  protected final String TEXT_43 = "++)" + NL + "     { " + NL + "      if (listings";
  protected final String TEXT_44 = "[m";
  protected final String TEXT_45 = "].matches(mask";
  protected final String TEXT_46 = "))" + NL + "      {" + NL + "        java.io.File localFile";
  protected final String TEXT_47 = "=new java.io.File(localdir";
  protected final String TEXT_48 = "+ \"/\" +listings";
  protected final String TEXT_49 = "[m";
  protected final String TEXT_50 = "]);";
  protected final String TEXT_51 = NL + "        \tif(!localFile";
  protected final String TEXT_52 = ".exists())" + NL + "        \t{" + NL + "        \t \tftp";
  protected final String TEXT_53 = ".get(localdir";
  protected final String TEXT_54 = " + \"/\" + listings";
  protected final String TEXT_55 = "[m";
  protected final String TEXT_56 = "] ,listings";
  protected final String TEXT_57 = "[m";
  protected final String TEXT_58 = "]);" + NL + "        \t}";
  protected final String TEXT_59 = NL + "        \tftp";
  protected final String TEXT_60 = ".get(localdir";
  protected final String TEXT_61 = " + \"/\" + listings";
  protected final String TEXT_62 = "[m";
  protected final String TEXT_63 = "] ,listings";
  protected final String TEXT_64 = "[m";
  protected final String TEXT_65 = "]);";
  protected final String TEXT_66 = NL + "        \tif(localFile";
  protected final String TEXT_67 = ".exists())" + NL + "        \t{" + NL + "        \t\tcom.enterprisedt.net.ftp.FTPFile ftpfile";
  protected final String TEXT_68 = "=ftp";
  protected final String TEXT_69 = ".fileDetails(listings";
  protected final String TEXT_70 = "[m";
  protected final String TEXT_71 = "]);" + NL + "        \t\tlong ftpSize";
  protected final String TEXT_72 = "=ftpfile";
  protected final String TEXT_73 = ".size();" + NL + "        \t\tlong localSize";
  protected final String TEXT_74 = "=localFile";
  protected final String TEXT_75 = ".length();" + NL + "        \t\tif(!(ftpSize";
  protected final String TEXT_76 = "==localSize";
  protected final String TEXT_77 = "))" + NL + "        \t\t{" + NL + "        \t \tftp";
  protected final String TEXT_78 = ".get(localdir";
  protected final String TEXT_79 = " + \"/\" + listings";
  protected final String TEXT_80 = "[m";
  protected final String TEXT_81 = "] ,listings";
  protected final String TEXT_82 = "[m";
  protected final String TEXT_83 = "]);\t" + NL + "        \t\t}" + NL + "        \t}else" + NL + "        \t{" + NL + "        \t\tftp";
  protected final String TEXT_84 = ".get(localdir";
  protected final String TEXT_85 = " + \"/\" + listings";
  protected final String TEXT_86 = "[m";
  protected final String TEXT_87 = "] ,listings";
  protected final String TEXT_88 = "[m";
  protected final String TEXT_89 = "]);" + NL + "        \t}";
  protected final String TEXT_90 = NL + "       }" + NL + "    }" + NL + "   }" + NL + "   ftp";
  protected final String TEXT_91 = ".chdir(root";
  protected final String TEXT_92 = ");" + NL + " }";
  protected final String TEXT_93 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");	
	String cid = node.getUniqueName();
	String overwrite=ElementParameterParser.getValue(node, "__OVERWRITE__");

    stringBuffer.append(TEXT_2);
     
	if ("binary".equalsIgnoreCase(ElementParameterParser.getValue(node, "__MODE__"))) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
  }	else {  

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
 }

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(localdir);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    if(overwrite.equals("never")){
        
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
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
    }
    else if(overwrite.equals("always")){
        
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
    }
    if(overwrite.equals("size_differ")){
        
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    return stringBuffer.toString();
  }
}
