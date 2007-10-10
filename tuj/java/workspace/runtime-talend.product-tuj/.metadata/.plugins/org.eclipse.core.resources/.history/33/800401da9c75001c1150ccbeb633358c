package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPRenameBeginJava
{
  protected static String nl;
  public static synchronized TFTPRenameBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPRenameBeginJava result = new TFTPRenameBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\tcom.enterprisedt.net.ftp.FTPClient ftp";
  protected final String TEXT_2 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\tftp";
  protected final String TEXT_3 = ".setRemoteHost(";
  protected final String TEXT_4 = ");" + NL + "\tftp";
  protected final String TEXT_5 = ".setRemotePort(";
  protected final String TEXT_6 = ");" + NL + "\tftp";
  protected final String TEXT_7 = ".connect();" + NL + "    ftp";
  protected final String TEXT_8 = ".login(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");    " + NL + "\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_11 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "\t";
  protected final String TEXT_12 = "    " + NL + "\tjava.util.Map<String,String> map";
  protected final String TEXT_13 = " = new java.util.HashMap<String,String>();\t" + NL + "\tmap";
  protected final String TEXT_14 = ".put(";
  protected final String TEXT_15 = ",";
  protected final String TEXT_16 = ");" + NL + "\tlist";
  protected final String TEXT_17 = ".add(map";
  protected final String TEXT_18 = ");       ";
  protected final String TEXT_19 = "\t" + NL + "" + NL + "\tString remotedir";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "\tftp";
  protected final String TEXT_22 = ".chdir(remotedir";
  protected final String TEXT_23 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();	
	String host = ElementParameterParser.getValue(node, "__HOST__");
	String port = ElementParameterParser.getValue(node, "__PORT__");
	String user = ElementParameterParser.getValue(node, "__USERNAME__");
	String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");	
	String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pass );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    
    for (int i=0; i<files.size(); i++) {
       Map<String, String> line = files.get(i);

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_18);
    
  }

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
