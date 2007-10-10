package org.talend.designer.codegen.translators.dataquality;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TUniqRowMainJava
{
  protected static String nl;
  public static synchronized TUniqRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowMainJava result = new TUniqRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " = null;\t\t\t";
  protected final String TEXT_3 = "\t" + NL + "\tcurrentRowKey";
  protected final String TEXT_4 = " = \"\"";
  protected final String TEXT_5 = NL + "\t+ ";
  protected final String TEXT_6 = NL + "\t\t((";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = "!=null)?";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ".toString()";
  protected final String TEXT_11 = " + ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ".toString().length():null)" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = NL + "\t";
  protected final String TEXT_17 = ";" + NL + "\tif (!keys";
  protected final String TEXT_18 = ".contains(currentRowKey";
  protected final String TEXT_19 = ")) {" + NL + "\t\tkeys";
  protected final String TEXT_20 = ".add(currentRowKey";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = "if(";
  protected final String TEXT_23 = " == null){ " + NL + "\t";
  protected final String TEXT_24 = " = new ";
  protected final String TEXT_25 = "Struct();" + NL + "}";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ";\t\t\t";
  protected final String TEXT_30 = "\t\t" + NL + "\t\tnb_uniques_";
  protected final String TEXT_31 = "++;" + NL + "\t} else {";
  protected final String TEXT_32 = NL + "if(";
  protected final String TEXT_33 = " == null){ " + NL + "\t";
  protected final String TEXT_34 = " = new ";
  protected final String TEXT_35 = "Struct();" + NL + "}\t\t\t\t";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ";\t\t\t";
  protected final String TEXT_40 = NL + "\t  nb_duplicates_";
  protected final String TEXT_41 = "++;" + NL + "\t}";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ";\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String connName = null;
if (node.getIncomingConnections().size()==1) {
	IConnection conn = node.getIncomingConnections().get(0);
	connName = conn.getName();
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null && connName != null) {
		List<? extends IConnection> conns = node.getOutgoingSortedConnections();
		List<? extends IConnection> connsUnique = node.getOutgoingConnections("UNIQUE");
		List<? extends IConnection> connsDuplicate = node.getOutgoingConnections("DUPLICATE");
		
		List<Map<String, String>> keyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__UNIQUE_KEY__");
		boolean hasKey = false;
		for(Map<String, String> keyColumn:keyColumns){
			if(keyColumn.get("KEY_ATTRIBUTE").equals("true")){
				hasKey = true;
				break;
			}
		}
		int ii = 0;
		if(hasKey){

    
	if (conns!=null) {
		if (conns.size()>0) {
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

			    	 
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_2);
    					 
				}
			}
		}
	}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
		for (IMetadataColumn column: metadata.getListColumns()) {
			Map<String, String> keyColumn = keyColumns.get(ii);
			if (keyColumn.get("KEY_ATTRIBUTE").equals("true")) {
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType()); 

    stringBuffer.append(TEXT_5);
     
		if (!javaType.isPrimitive()) { 
	
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(((!keyColumn.get("CASE_SENSITIVE").equals("true"))?".toLowerCase()":""));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
     
		} else {
	
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
     
		}
	
    
			}
			ii++;
		} 

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
	if (connsUnique!=null) {
		if (connsUnique.size()>0) {
			for (int i=0;i<connsUnique.size();i++) {
				IConnection conn = connsUnique.get(i);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_25);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {
			    	 
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    					 }
				}
			}
		}
	}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
	if (connsDuplicate!=null) {
		if (connsDuplicate.size()>0) {
			for (int i=0;i<connsDuplicate.size();i++) {
				IConnection conn = connsDuplicate.get(i);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_35);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {
			    	 
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_39);
    					 }
				}
			}
		}
	}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
	}else{
		if (conns!=null) {
			if (conns.size()>0) {
				for (int i=0;i<conns.size();i++) {
					IConnection conn = conns.get(i);
			    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			    		for (IMetadataColumn column: metadata.getListColumns()) {
			    	 
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(connName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    						}
					}
				}
			}
		}
	}
	}
}

    return stringBuffer.toString();
  }
}
