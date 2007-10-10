package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileInputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputXMLBeginJava result = new TFileInputXMLBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "" + NL + "org.dom4j.io.SAXReader reader_";
  protected final String TEXT_4 = " = new org.dom4j.io.SAXReader();" + NL + "org.dom4j.Document doc_";
  protected final String TEXT_5 = "= reader_";
  protected final String TEXT_6 = ".read(new java.io.FileInputStream(";
  protected final String TEXT_7 = "));" + NL + "String ns_";
  protected final String TEXT_8 = " = doc_";
  protected final String TEXT_9 = ".getRootElement().getNamespaceURI();" + NL + "java.util.HashMap xmlNameSpaceMap_";
  protected final String TEXT_10 = " = new java.util.HashMap();  " + NL + "xmlNameSpaceMap_";
  protected final String TEXT_11 = ".put(\"ns\",ns_";
  protected final String TEXT_12 = ");" + NL + "" + NL + "org.dom4j.XPath x_";
  protected final String TEXT_13 = " = doc_";
  protected final String TEXT_14 = ".createXPath(";
  protected final String TEXT_15 = ");  " + NL + "x_";
  protected final String TEXT_16 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_17 = "); " + NL + "" + NL + "java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_18 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_19 = ".selectNodes(doc_";
  protected final String TEXT_20 = ");\t" + NL + "" + NL + "String str_";
  protected final String TEXT_21 = " = \"\";" + NL + "for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_22 = ": nodeList_";
  protected final String TEXT_23 = ") {" + NL + "\tnb_line_";
  protected final String TEXT_24 = "++;";
  protected final String TEXT_25 = NL + "\torg.dom4j.XPath xTmp";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = " = temp_";
  protected final String TEXT_28 = ".createXPath(\"";
  protected final String TEXT_29 = "\");" + NL + "    xTmp";
  protected final String TEXT_30 = "_";
  protected final String TEXT_31 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_32 = ");  " + NL + "    str_";
  protected final String TEXT_33 = " = xTmp";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = ".valueOf(temp_";
  protected final String TEXT_36 = ");" + NL + "\tif (str_";
  protected final String TEXT_37 = " != null ) {  ";
  protected final String TEXT_38 = NL + "\t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = str_";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "\t\t";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\t";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = " = ParserUtils.parseTo_";
  protected final String TEXT_50 = "(str_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\t}";
  protected final String TEXT_53 = NL + "\t";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = ";";
  protected final String TEXT_58 = NL + "\t" + NL + "\tif (nb_line_";
  protected final String TEXT_59 = ">";
  protected final String TEXT_60 = ") {" + NL + "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_61 = NL + "\t\t\t";
  protected final String TEXT_62 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
        
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String limit = ElementParameterParser.getValue(node, "__LIMIT__");
if (limit.equals("")) {
	limit = "-1";
}

List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> columns=metadata.getListColumns();
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();        

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(loopQuery.replace("/", "/ns:") );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    	
				for (int i=0;i<mapping.size();i++) { 
					String query = mapping.get(i).get("QUERY");
					if(query.startsWith("\"") && query.endsWith("\"")){
						query = query.substring(1, query.length() - 1);
					}
					if (!query.startsWith("@")) {
	                    if (query.indexOf("@") < 0 && query.indexOf("/") < 0) {
	                        query = "ns:" + query;
	                    } else {
	                        String[] s = query.split("/");
	                        java.lang.StringBuffer result = new java.lang.StringBuffer();
	                        for (String tmp : s) {
	                            if (result.length() > 0) {
	                                result.append("/");
	                            }
	                            if (tmp.length() > 0 && !tmp.startsWith(".") && !tmp.startsWith("@")) {
	                                result.append("ns:").append(tmp);
	                            } else {
	                                result.append(tmp);
	                            }
	                        }
	                        query = result.toString();
	                    }
	                }

    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
					for(IMetadataColumn column:columns) {
						if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
							if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
								if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_41);
    
								} else {
									if (javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_46);
    
									} else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    
									}
								}
							}
						}
					}

    stringBuffer.append(TEXT_52);
    
				}
			}
			if (conns.size()>1) {
				for (int i=1;i<conns.size();i++) {
					IConnection conn = conns.get(i);
					if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
						for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_57);
    
						}
					}
				}
			}
		}
		
		// limit
		if (limit.compareTo("-1")!=0) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(Integer.parseInt(limit));
    stringBuffer.append(TEXT_60);
    
		}
	}
}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(TEXT_62);
    return stringBuffer.toString();
  }
}
