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

public class TXSDValidatorMainJava
{
  protected static String nl;
  public static synchronized TXSDValidatorMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TXSDValidatorMainJava result = new TXSDValidatorMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "javax.xml.validation.SchemaFactory factory";
  protected final String TEXT_3 = " =javax.xml.validation.SchemaFactory.newInstance(\"http://www.w3.org/2001/XMLSchema\");" + NL + "java.io.File schemaLocation";
  protected final String TEXT_4 = " = new java.io.File(";
  protected final String TEXT_5 = ");" + NL + "javax.xml.validation.Schema schema";
  protected final String TEXT_6 = " = factory";
  protected final String TEXT_7 = ".newSchema(schemaLocation";
  protected final String TEXT_8 = ");" + NL + "javax.xml.validation.Validator validator";
  protected final String TEXT_9 = " = schema";
  protected final String TEXT_10 = ".newValidator();" + NL + "java.io.File xmlfile";
  protected final String TEXT_11 = " = new java.io.File(";
  protected final String TEXT_12 = ");" + NL + "javax.xml.transform.Source source";
  protected final String TEXT_13 = " = new javax.xml.transform.stream.StreamSource(xmlfile";
  protected final String TEXT_14 = ");" + NL + "" + NL + "String message";
  protected final String TEXT_15 = " = \"\";" + NL + "int validate";
  protected final String TEXT_16 = " = 0;" + NL + "try {" + NL + "    validator";
  protected final String TEXT_17 = ".validate(source";
  protected final String TEXT_18 = ");" + NL + "  \tmessage";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = ";" + NL + "\tvalidate";
  protected final String TEXT_21 = " = 1;  \t" + NL + "} catch (org.xml.sax.SAXException ex) {" + NL + "\tmessage";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";" + NL + "} " + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_24 = "_DIFFERENCE\", \"\" + validate";
  protected final String TEXT_25 = ");" + NL;
  protected final String TEXT_26 = NL + "    System.out.println(message";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = ".xsdfile = ";
  protected final String TEXT_30 = ";" + NL + "\t\t";
  protected final String TEXT_31 = ".xmlfile = ";
  protected final String TEXT_32 = ";\t" + NL + "    \t";
  protected final String TEXT_33 = ".moment = java.util.Calendar.getInstance().getTime();" + NL + "    \t";
  protected final String TEXT_34 = ".job = jobName;" + NL + "\t\t";
  protected final String TEXT_35 = ".component = currentComponent;" + NL + "\t\t";
  protected final String TEXT_36 = ".validate = validate";
  protected final String TEXT_37 = ";" + NL + "\t\t";
  protected final String TEXT_38 = ".message = message";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String xsdfile = ElementParameterParser.getValue(node, "__XSDFILE__");
Boolean print = new Boolean(ElementParameterParser.getValue(node, "__PRINT__"));
String validMessage = ElementParameterParser.getValue(node, "__VALID_MESSAGE__");
String invalidMessage = ElementParameterParser.getValue(node, "__INVALID_MESSAGE__");
String xmlfile = ElementParameterParser.getValue(node, "__XMLFILE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(xsdfile );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(xmlfile );
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
    stringBuffer.append(validMessage);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(invalidMessage);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
if (print) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
}

for (IConnection conn : node.getOutgoingConnections()) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(xsdfile );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(xmlfile );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
	}
}

    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
