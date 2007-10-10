package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TFileCompareMainJava
{
  protected static String nl;
  public static synchronized TFileCompareMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileCompareMainJava result = new TFileCompareMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "boolean result_";
  protected final String TEXT_3 = " = true;" + NL + "java.nio.channels.FileChannel fileChannel_";
  protected final String TEXT_4 = " = new java.io.FileInputStream(";
  protected final String TEXT_5 = ").getChannel();" + NL + "long fileLength_";
  protected final String TEXT_6 = " = fileChannel_";
  protected final String TEXT_7 = ".size();" + NL + "fileChannel_";
  protected final String TEXT_8 = ".close();" + NL + "java.nio.channels.FileChannel fileChannelRef_";
  protected final String TEXT_9 = " = new java.io.FileInputStream(";
  protected final String TEXT_10 = ").getChannel();" + NL + "long fileRefLength_";
  protected final String TEXT_11 = " = fileChannelRef_";
  protected final String TEXT_12 = ".size();" + NL + "fileChannelRef_";
  protected final String TEXT_13 = ".close();" + NL + "if(fileLength_";
  protected final String TEXT_14 = " != fileRefLength_";
  protected final String TEXT_15 = ")" + NL + "{" + NL + "\tresult_";
  protected final String TEXT_16 = " = false;" + NL + "}" + NL + "else" + NL + "{" + NL + "\t";
  protected final String TEXT_17 = NL + "\t\tjava.io.BufferedReader file_";
  protected final String TEXT_18 = " = new java.io.BufferedReader(new java.io.FileReader(";
  protected final String TEXT_19 = "));" + NL + "\t\tjava.io.BufferedReader fileRef_";
  protected final String TEXT_20 = " = new java.io.BufferedReader(new java.io.FileReader(";
  protected final String TEXT_21 = "));" + NL + "\t\tString content_";
  protected final String TEXT_22 = " = null,contentRef_";
  protected final String TEXT_23 = " = null;" + NL + "\t\twhile((content_";
  protected final String TEXT_24 = " = file_";
  protected final String TEXT_25 = ".readLine()) != null && (contentRef_";
  protected final String TEXT_26 = " = fileRef_";
  protected final String TEXT_27 = ".readLine()) != null)" + NL + "\t\t{" + NL + "\t\t\tif(content_";
  protected final String TEXT_28 = ".compareTo(contentRef_";
  protected final String TEXT_29 = ") != 0)" + NL + "\t\t\t{" + NL + "\t\t\t\tresult_";
  protected final String TEXT_30 = " = false;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tfile_";
  protected final String TEXT_31 = ".close();" + NL + "\t\tfileRef_";
  protected final String TEXT_32 = ".close();" + NL + "\t\t";
  protected final String TEXT_33 = NL + "    \tjava.io.BufferedInputStream file_";
  protected final String TEXT_34 = " = new java.io.BufferedInputStream(new java.io.FileInputStream(";
  protected final String TEXT_35 = "));" + NL + "    \tjava.io.BufferedInputStream fileRef_";
  protected final String TEXT_36 = " = new java.io.BufferedInputStream(new java.io.FileInputStream(";
  protected final String TEXT_37 = "));" + NL + "    \tint content_";
  protected final String TEXT_38 = " = -1,contentRef_";
  protected final String TEXT_39 = " = -1;" + NL + "    \twhile((content_";
  protected final String TEXT_40 = " = file_";
  protected final String TEXT_41 = ".read()) != -1 && (contentRef_";
  protected final String TEXT_42 = " = fileRef_";
  protected final String TEXT_43 = ".read()) != -1)" + NL + "    \t{" + NL + "    \t\tif(content_";
  protected final String TEXT_44 = " != contentRef_";
  protected final String TEXT_45 = ")" + NL + "    \t\t{" + NL + "    \t\t\tresult_";
  protected final String TEXT_46 = " = false;" + NL + "    \t\t\tbreak;" + NL + "    \t\t}" + NL + "    \t}" + NL + "    \tfile_";
  protected final String TEXT_47 = ".close();" + NL + "    \tfileRef_";
  protected final String TEXT_48 = ".close();\t\t\t" + NL + "\t\t";
  protected final String TEXT_49 = NL + "}" + NL + "" + NL + "String message";
  protected final String TEXT_50 = " = \"\";" + NL + "if (result_";
  protected final String TEXT_51 = ") {" + NL + "\tmessage";
  protected final String TEXT_52 = " = ";
  protected final String TEXT_53 = ";" + NL + "\t" + NL + "} else {" + NL + "\tmessage";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = ";" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_56 = "_DIFFERENCE\",result_";
  protected final String TEXT_57 = ");" + NL;
  protected final String TEXT_58 = NL + "    System.out.println(message";
  protected final String TEXT_59 = ");";
  protected final String TEXT_60 = NL + "\t\t";
  protected final String TEXT_61 = ".file = ";
  protected final String TEXT_62 = ";" + NL + "\t\t";
  protected final String TEXT_63 = ".file_ref = ";
  protected final String TEXT_64 = ";\t" + NL + "    \t";
  protected final String TEXT_65 = ".moment = java.util.Calendar.getInstance().getTime();" + NL + "    \t";
  protected final String TEXT_66 = ".job = jobName;" + NL + "\t\t";
  protected final String TEXT_67 = ".component = currentComponent;" + NL + "\t\t";
  protected final String TEXT_68 = ".differ = (result_";
  protected final String TEXT_69 = ")?0:1;" + NL + "\t\t";
  protected final String TEXT_70 = ".message = message";
  protected final String TEXT_71 = ";";
  protected final String TEXT_72 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String file = ElementParameterParser.getValue(node, "__FILE__");
Boolean print = new Boolean(ElementParameterParser.getValue(node, "__PRINT__"));
String differMessage = ElementParameterParser.getValue(node, "__DIFFER_MESSAGE__");
String noDifferMessage = ElementParameterParser.getValue(node, "__NO_DIFFER_MESSAGE__");
String fileRef = ElementParameterParser.getValue(node, "__FILE_REF__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fileRef);
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
    
	String cmpMode = ElementParameterParser.getValue(node, "__COMPARISON_MODE__");
	if(cmpMode.equals("TEXT_CMP"))
	{
		
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(fileRef);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	}
	else
	{
		
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(file);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(fileRef);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	}
	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(noDifferMessage);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(differMessage);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    
if (print) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    
}

for (IConnection conn : node.getOutgoingConnections()) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(file );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(fileRef );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
	}
}

    stringBuffer.append(TEXT_72);
    return stringBuffer.toString();
  }
}
