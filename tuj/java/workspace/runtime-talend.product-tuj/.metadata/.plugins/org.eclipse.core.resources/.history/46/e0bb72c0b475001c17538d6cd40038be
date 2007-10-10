package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TSendMailBeginJava
{
  protected static String nl;
  public static synchronized TSendMailBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSendMailBeginJava result = new TSendMailBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tString smtpHost_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\tString smtpPort_";
  protected final String TEXT_5 = " = \"";
  protected final String TEXT_6 = "\";" + NL + "\tString from_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "    String to_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = ";" + NL + "    String cc_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";" + NL + "    String bcc_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "    String subject_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ";" + NL + "    " + NL + "\t" + NL + "\tjava.util.List<java.util.Map<String, String>> headers_";
  protected final String TEXT_17 = " = new java.util.ArrayList<java.util.Map<String,String>>();";
  protected final String TEXT_18 = NL + "\tjava.util.Map<String,String> headerMap_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = " = new java.util.HashMap<String,String>();" + NL + "\theaderMap_";
  protected final String TEXT_21 = "_";
  protected final String TEXT_22 = ".put(\"KEY\", ";
  protected final String TEXT_23 = ");" + NL + "\theaderMap_";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = ".put(\"VALUE\", ";
  protected final String TEXT_26 = ");" + NL + "\theaders_";
  protected final String TEXT_27 = ".add(headerMap_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = ");\t";
  protected final String TEXT_30 = NL + " " + NL + "\tjava.util.List<String> attachments_";
  protected final String TEXT_31 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_32 = NL + "\tattachments_";
  protected final String TEXT_33 = ".add(";
  protected final String TEXT_34 = ");\t";
  protected final String TEXT_35 = " ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();

	String smtpHost    = ElementParameterParser.getValue(node, "__SMTP_HOST__");
	String smtpPort    = ElementParameterParser.getValue(node, "__SMTP_PORT__");
	String to          = ElementParameterParser.getValue(node, "__TO__");
	String from        = ElementParameterParser.getValue(node, "__FROM__");
	String cc          = ElementParameterParser.getValue(node, "__CC__");
	String bcc          = ElementParameterParser.getValue(node, "__BCC__");
	String subject     = ElementParameterParser.getValue(node, "__SUBJECT__");
	
	List<Map<String, String>> tableValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ATTACHMENTS__");
	List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HEADERS__");
	
	// component id
	String cid = node.getUniqueName();
	to = to.replace(";",",");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(smtpHost );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(smtpPort );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(to );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append((cc==null || "".equals(cc))?null:cc.replace(";",",") );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append((bcc==null || "".equals(bcc))?null:bcc.replace(";",",") );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(subject );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
	for (int i = 0; i < headers.size(); i++) {
   		Map<String, String> header = headers.get(i);

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(header.get("KEY"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(header.get("VALUE"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_29);
    
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
	for (int i = 0; i < tableValues.size(); i++) {
    	Map<String,String> attachment = tableValues.get(i);

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(attachment.get("FILE") );
    stringBuffer.append(TEXT_34);
    
}

    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
