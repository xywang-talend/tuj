package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TSalesforceOutputMainJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputMainJava result = new TSalesforceOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "///////////////////////\t\t" + NL + NL + NL;
  protected final String TEXT_2 = NL + NL + "\t\t\t\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tjava.util.List<org.apache.axis.message.MessageElement> list_";
  protected final String TEXT_4 = " = new java.util.ArrayList<org.apache.axis.message.MessageElement>();\t\t\t\t";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "   \t\t\t\t" + NL + "\t    \t\tif(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null) { //";
  protected final String TEXT_9 = "              " + NL + "                 list_";
  protected final String TEXT_10 = ".add(sforceManagement_";
  protected final String TEXT_11 = ".newMessageElement(\"";
  protected final String TEXT_12 = "\",    \t\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ")).toString()";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ")";
  protected final String TEXT_23 = NL + "\t\t\t\t\t          ));" + NL + "\t\t\t\t\t          \t\t\t\t          " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t    \t\t} //";
  protected final String TEXT_25 = "  \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_26 = " " + NL + "" + NL + " \t\t\t\t";
  protected final String TEXT_27 = " \t\t\t\t" + NL + " \t\t\t\tsforceManagement_";
  protected final String TEXT_28 = ".insert(\"";
  protected final String TEXT_29 = "\", (org.apache.axis.message.MessageElement[])list_";
  protected final String TEXT_30 = ".toArray(new org.apache.axis.message.MessageElement[list_";
  protected final String TEXT_31 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_32 = " " + NL + "    \t\t\tsforceManagement_";
  protected final String TEXT_33 = ".update(\"";
  protected final String TEXT_34 = "\", ";
  protected final String TEXT_35 = ".Id, (org.apache.axis.message.MessageElement[])list_";
  protected final String TEXT_36 = ".toArray(new org.apache.axis.message.MessageElement[list_";
  protected final String TEXT_37 = ".size()]));    \t\t\t" + NL;
  protected final String TEXT_38 = " " + NL + " " + NL + "    \t\t\t";
  protected final String TEXT_39 = NL + "    \t\t\tsforceManagement_";
  protected final String TEXT_40 = ".delete(";
  protected final String TEXT_41 = ".Id);    \t\t\t" + NL + "    \t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_42 = "     \t\t\t" + NL + "    \t\t\t" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_43 = "++; " + NL + "\t\t\t\t" + NL + "\t\t\t\t    \t\t\t" + NL + "    \t\t\t" + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_44 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String action = ElementParameterParser.getValue(node, "__ACTION__");
String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
        String cid = node.getUniqueName();

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_1);
    
 if ("insert".equals(action)|| "update".equals(action)) {//************

    stringBuffer.append(TEXT_2);
      
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5  			

  			        
    				IMetadataColumn column = columns.get(i);
    				
    				//make sure to filter the schema "Id", when updating
  			        if("Id".equals(column.getLabel())) continue;
    				
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

    stringBuffer.append(TEXT_5);
    
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) { //begin

    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    
    				} 

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_12);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_16);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    				
					} else {//others

    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    				
					}

    stringBuffer.append(TEXT_23);
    
					if(!isPrimitive) {//end

    stringBuffer.append(TEXT_24);
    
					} 

    stringBuffer.append(TEXT_25);
    
				}//5	

    stringBuffer.append(TEXT_26);
    
 if ("insert".equals(action)) {//#######

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
	} else if ("update".equals(action)) {//#######

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modulename );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
  }//#######

    stringBuffer.append(TEXT_38);
    
	} else if ("delete".equals(action)) {//*************	

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_41);
    
  }//************

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
    		}//4
    	}//3
    }//2
}//1

    stringBuffer.append(TEXT_44);
    return stringBuffer.toString();
  }
}
