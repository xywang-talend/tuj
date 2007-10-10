package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TAdvancedFileOutputXMLBeginJava
{
  protected static String nl;
  public static synchronized TAdvancedFileOutputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAdvancedFileOutputXMLBeginJava result = new TAdvancedFileOutputXMLBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_4 = "  = org.dom4j.DocumentHelper.createDocument();" + NL + "boolean needRoot_";
  protected final String TEXT_5 = "  = true;" + NL + "String fileName_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + "java.io.File createFile";
  protected final String TEXT_9 = " = new java.io.File(fileName_";
  protected final String TEXT_10 = "); " + NL + "if(!createFile";
  protected final String TEXT_11 = ".exists()){ " + NL + "\t(new java.io.File(fileName_";
  protected final String TEXT_12 = ".substring(0,fileName_";
  protected final String TEXT_13 = ".lastIndexOf(\"/\")))).mkdirs(); " + NL + "} ";
  protected final String TEXT_14 = NL + "int currentRowCount_";
  protected final String TEXT_15 = " = 0;" + NL + "int currentFileCount_";
  protected final String TEXT_16 = " = 0;" + NL + "String file_";
  protected final String TEXT_17 = " = fileName_";
  protected final String TEXT_18 = ".substring(0,fileName_";
  protected final String TEXT_19 = ".lastIndexOf(\".xml\"));" + NL + "fileName_";
  protected final String TEXT_20 = " = file_";
  protected final String TEXT_21 = "+\"0.xml\";";
  protected final String TEXT_22 = NL + NL + "// sort group root element for judgement of group" + NL + "java.util.List<org.dom4j.Element> groupRootList_";
  protected final String TEXT_23 = " = new java.util.ArrayList<org.dom4j.Element>();" + NL + "" + NL + "org.dom4j.io.OutputFormat format_";
  protected final String TEXT_24 = " = org.dom4j.io.OutputFormat.createPrettyPrint();" + NL + "format_";
  protected final String TEXT_25 = ".setEncoding(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List< ? extends IConnection> conns = node.getIncomingConnections();
		if(conns!=null && conns.size()>0){
    		IConnection conn = conns.get(0);
    		if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){ 
        		String split = ElementParameterParser.getValue(node, "__SPLIT__");
        		String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        		String fileName = ElementParameterParser.getValue(node, "__FILENAME__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_7);
    
				if(ElementParameterParser.getValue(node,"__CREATE__").equals("true")){

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
    
				}
				if(split.equals("true")){

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
				}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_26);
    
			}
		}
	}
}

    stringBuffer.append(TEXT_27);
    return stringBuffer.toString();
  }
}
