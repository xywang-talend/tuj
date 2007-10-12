package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPRenameMainJava
{
  protected static String nl;
  public static synchronized TFTPRenameMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPRenameMainJava result = new TFTPRenameMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_2 = " : list";
  protected final String TEXT_3 = ") " + NL + "\t{  \t" + NL + "    \tjava.util.Set<String> keySet";
  protected final String TEXT_4 = " = map";
  protected final String TEXT_5 = ".keySet();   " + NL + "    \tfor (String key";
  protected final String TEXT_6 = " : keySet";
  protected final String TEXT_7 = ")" + NL + "   \t\t{     " + NL + "     \t\t";
  protected final String TEXT_8 = NL + "     \t\tftp";
  protected final String TEXT_9 = ".rename(key";
  protected final String TEXT_10 = ", map";
  protected final String TEXT_11 = ".get(key";
  protected final String TEXT_12 = "));" + NL + "     \t\t";
  protected final String TEXT_13 = NL + "     \t\t";
  protected final String TEXT_14 = NL + "     \t\t\tif(!(ftp";
  protected final String TEXT_15 = ".exists(map";
  protected final String TEXT_16 = ".get(key";
  protected final String TEXT_17 = "))))" + NL + "     \t\t\t{" + NL + "     \t\t\tftp";
  protected final String TEXT_18 = ".rename(key";
  protected final String TEXT_19 = ", map";
  protected final String TEXT_20 = ".get(key";
  protected final String TEXT_21 = "));" + NL + "     \t\t\t}" + NL + "     \t\t";
  protected final String TEXT_22 = NL + "     \t\t";
  protected final String TEXT_23 = NL + "     \t\t\tif((ftp";
  protected final String TEXT_24 = ".exists(map";
  protected final String TEXT_25 = ".get(key";
  protected final String TEXT_26 = "))))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tcom.enterprisedt.net.ftp.FTPFile ftpnewNamefile";
  protected final String TEXT_27 = "=ftp";
  protected final String TEXT_28 = ".fileDetails(map";
  protected final String TEXT_29 = ".get(key";
  protected final String TEXT_30 = "));" + NL + "\t\t\t\t\tcom.enterprisedt.net.ftp.FTPFile ftporigNamefile";
  protected final String TEXT_31 = "=ftp";
  protected final String TEXT_32 = ".fileDetails(key";
  protected final String TEXT_33 = ");" + NL + "\t\t\t\t\tlong newNameSize";
  protected final String TEXT_34 = "=ftpnewNamefile";
  protected final String TEXT_35 = ".size();" + NL + "\t\t\t\t\tlong origNameSize";
  protected final String TEXT_36 = "=ftporigNamefile";
  protected final String TEXT_37 = ".size();" + NL + "\t\t\t\t\tif(!(newNameSize";
  protected final String TEXT_38 = "==origNameSize";
  protected final String TEXT_39 = "))" + NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t\tftp";
  protected final String TEXT_40 = ".rename(key";
  protected final String TEXT_41 = ", map";
  protected final String TEXT_42 = ".get(key";
  protected final String TEXT_43 = "));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}else" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tftp";
  protected final String TEXT_44 = ".rename(key";
  protected final String TEXT_45 = ", map";
  protected final String TEXT_46 = ".get(key";
  protected final String TEXT_47 = "));" + NL + "\t\t\t\t}" + NL + "     \t\t";
  protected final String TEXT_48 = NL + "   \t\t}" + NL + "\t}" + NL;
  protected final String TEXT_49 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String overwrite=ElementParameterParser.getValue(node, "__OVERWRITE__");
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    if(overwrite.equals("always")){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if(overwrite.equals("never")){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
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
    }
    stringBuffer.append(TEXT_22);
    if(overwrite.equals("size_differ")){
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}
