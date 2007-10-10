package org.talend.designer.codegen.translators.xml;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.io.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class TDTDValidatorMainJava
{
  protected static String nl;
  public static synchronized TDTDValidatorMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDTDValidatorMainJava result = new TDTDValidatorMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\tString message";
  protected final String TEXT_3 = " = \"\";" + NL + "\t\tint validate";
  protected final String TEXT_4 = " = 0;" + NL + "\t\t" + NL + "\t\tjava.io.InputStream is";
  protected final String TEXT_5 = "=null;" + NL + "\t\tjavax.xml.parsers.DocumentBuilderFactory dbf";
  protected final String TEXT_6 = "=null;" + NL + "\t\tjavax.xml.parsers.DocumentBuilder db";
  protected final String TEXT_7 = "=null;" + NL + "\t\tmessage";
  protected final String TEXT_8 = "=";
  protected final String TEXT_9 = ";" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\tjava.net.URL url";
  protected final String TEXT_11 = " = new java.net.URL(";
  protected final String TEXT_12 = ");" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\tjava.net.URL url";
  protected final String TEXT_14 = " = new java.io.File(";
  protected final String TEXT_15 = ").toURL();" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\t" + NL + "\t\tjava.io.BufferedReader br";
  protected final String TEXT_17 = " = new java.io.BufferedReader(new java.io.InputStreamReader(url";
  protected final String TEXT_18 = ".openStream()));" + NL + "\t\tjava.lang.StringBuffer sb";
  protected final String TEXT_19 = "=new java.lang.StringBuffer(\"\");" + NL + "\t\t" + NL + "\t\tchar[] buffer";
  protected final String TEXT_20 = " = new char[1024];" + NL + "\t\tint length";
  protected final String TEXT_21 = " = -1;" + NL + "\t\twhile ((length";
  protected final String TEXT_22 = " = br";
  protected final String TEXT_23 = ".read(buffer";
  protected final String TEXT_24 = ")) != -1)" + NL + "\t\t\tsb";
  protected final String TEXT_25 = ".append(buffer";
  protected final String TEXT_26 = ", 0, length";
  protected final String TEXT_27 = ");//read xml document" + NL + "\t\t" + NL + "\t\tString doctype";
  protected final String TEXT_28 = " = null;" + NL + "\t\tint start";
  protected final String TEXT_29 = "=sb";
  protected final String TEXT_30 = ".indexOf(\"<!DOCTYPE\");" + NL + "\t\tif(start";
  protected final String TEXT_31 = "!=-1){" + NL + "\t\t\tint end";
  protected final String TEXT_32 = "=sb";
  protected final String TEXT_33 = ".indexOf(\">\", start";
  protected final String TEXT_34 = ");" + NL + "\t\t\tdoctype";
  protected final String TEXT_35 = " = sb";
  protected final String TEXT_36 = ".substring(start";
  protected final String TEXT_37 = ", end";
  protected final String TEXT_38 = "+1);" + NL + "\t\t\tsb";
  protected final String TEXT_39 = ".replace(start";
  protected final String TEXT_40 = ", end";
  protected final String TEXT_41 = "+1, \"\");\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tdbf";
  protected final String TEXT_42 = " = javax.xml.parsers.DocumentBuilderFactory.newInstance();" + NL + "\t\tdbf";
  protected final String TEXT_43 = ".setValidating(false);" + NL + "\t\tdb";
  protected final String TEXT_44 = " = dbf";
  protected final String TEXT_45 = ".newDocumentBuilder(); " + NL + "\t\torg.w3c.dom.Document doc";
  protected final String TEXT_46 = " = db";
  protected final String TEXT_47 = ".parse(new java.io.StringBufferInputStream(sb";
  protected final String TEXT_48 = ".toString()));" + NL + "\t\tString rootnode";
  protected final String TEXT_49 = "=doc";
  protected final String TEXT_50 = ".getDocumentElement().getNodeName();" + NL + "\t\t" + NL + "\t\tString encoding=null;" + NL + "\t\tif(doc";
  protected final String TEXT_51 = ".getXmlEncoding()==null) {" + NL + "\t\t\tencoding=\"ISO-8859-1\";" + NL + "\t\t} else {" + NL + "\t\t\tencoding=doc";
  protected final String TEXT_52 = ".getXmlEncoding();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\tString reference";
  protected final String TEXT_54 = "=\"<?xml version='\"+doc";
  protected final String TEXT_55 = ".getXmlVersion()+\"' encoding='\"+encoding+\"'?>\\n<!DOCTYPE \"+rootnode";
  protected final String TEXT_56 = "+\" SYSTEM '\"+";
  protected final String TEXT_57 = "+\"'>\\n\";" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\tString reference";
  protected final String TEXT_59 = "=\"<?xml version='\"+doc";
  protected final String TEXT_60 = ".getXmlVersion()+\"' encoding='\"+encoding+\"'?>\\n\"+doctype";
  protected final String TEXT_61 = "+\"\\n\";" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t" + NL + "\t\tint offsetRoot";
  protected final String TEXT_63 = "=sb";
  protected final String TEXT_64 = ".indexOf(\"<\"+rootnode";
  protected final String TEXT_65 = ");" + NL + "\t\tsb";
  protected final String TEXT_66 = ".replace(0, offsetRoot";
  protected final String TEXT_67 = ", reference";
  protected final String TEXT_68 = ");\t\t" + NL + "\t\tis";
  protected final String TEXT_69 = "=new java.io.StringBufferInputStream(sb";
  protected final String TEXT_70 = ".toString());" + NL + "\t\t" + NL + "\t\tclass MyHandler";
  protected final String TEXT_71 = " extends org.xml.sax.helpers.DefaultHandler{" + NL + "\t\t    String errorMessage = null;" + NL + "\t\t    public void error(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException {" + NL + "\t\t    \terrorMessage = e.getMessage();" + NL + "\t\t    }" + NL + "\t\t    public void fatalError(org.xml.sax.SAXParseException e) throws org.xml.sax.SAXException {" + NL + "\t\t    \terrorMessage = e.getMessage();" + NL + "\t\t    }" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tMyHandler";
  protected final String TEXT_72 = " handler";
  protected final String TEXT_73 = " = new MyHandler";
  protected final String TEXT_74 = "();" + NL + "\t\tdbf";
  protected final String TEXT_75 = ".setValidating(true);" + NL + "\t\tdb";
  protected final String TEXT_76 = " = dbf";
  protected final String TEXT_77 = ".newDocumentBuilder(); " + NL + "\t\tdb";
  protected final String TEXT_78 = ".setErrorHandler(handler";
  protected final String TEXT_79 = ");" + NL + "\t\tdoc";
  protected final String TEXT_80 = " = db";
  protected final String TEXT_81 = ".parse(is";
  protected final String TEXT_82 = ");" + NL + "\t\t" + NL + "\t\tif (handler";
  protected final String TEXT_83 = ".errorMessage == null) {" + NL + "\t\t\tmessage";
  protected final String TEXT_84 = "= ";
  protected final String TEXT_85 = ";" + NL + "\t\t\tvalidate";
  protected final String TEXT_86 = " = 1;" + NL + "\t\t} else {" + NL + "\t\t\tmessage";
  protected final String TEXT_87 = "= ";
  protected final String TEXT_88 = ";" + NL + "\t\t}\t\t\t\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_89 = "_DIFFERENCE\", \"\" + validate";
  protected final String TEXT_90 = ");\t" + NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\t   System.out.println(message";
  protected final String TEXT_92 = ");" + NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t";
  protected final String TEXT_94 = ".dtdfile = ";
  protected final String TEXT_95 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_96 = ".xmlfile = ";
  protected final String TEXT_97 = ";\t" + NL + "\t\t    \t";
  protected final String TEXT_98 = ".moment = java.util.Calendar.getInstance().getTime();" + NL + "\t\t    \t";
  protected final String TEXT_99 = ".job = jobName;" + NL + "\t\t\t\t";
  protected final String TEXT_100 = ".component = currentComponent;" + NL + "\t\t\t\t";
  protected final String TEXT_101 = ".validate = validate";
  protected final String TEXT_102 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_103 = ".message = message";
  protected final String TEXT_104 = ";" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dtdfile = ElementParameterParser.getValue(node, "__DTDFILE__");
Boolean print = new Boolean(ElementParameterParser.getValue(node, "__PRINT__"));
String validMessage = ElementParameterParser.getValue(node, "__VALID_MESSAGE__");
String invalidMessage = ElementParameterParser.getValue(node, "__INVALID_MESSAGE__");
String xmlfile = ElementParameterParser.getValue(node, "__XMLFILE__");

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(validMessage);
    stringBuffer.append(TEXT_9);
    
		// Protocol defined ?
		if (xmlfile.matches("\\\"[\\w]+://.*")) {
		
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(xmlfile);
    stringBuffer.append(TEXT_12);
    
		} else {
		
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(xmlfile);
    stringBuffer.append(TEXT_15);
    
		}
		
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
		if (dtdfile.length() > 2) {
		
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(dtdfile);
    stringBuffer.append(TEXT_57);
    
		} else {
		
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
		}
		
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
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
    stringBuffer.append(validMessage);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(invalidMessage);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
		if (print) {
		
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
		}
		
		for (IConnection conn : node.getOutgoingConnections()) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		
    stringBuffer.append(TEXT_93);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(dtdfile );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(xmlfile );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
			}
		}
		
    return stringBuffer.toString();
  }
}
