package org.talend.designer.codegen.translators.business.sugarcrm;

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

public class TSugarCRMOutputMainJava
{
  protected static String nl;
  public static synchronized TSugarCRMOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSugarCRMOutputMainJava result = new TSugarCRMOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "///////////////////////\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_2 = NL + "\t\t\t\torg.talend.sugarws.Name_value[] nameValues_";
  protected final String TEXT_3 = " = new  org.talend.sugarws.Name_value[";
  protected final String TEXT_4 = "];";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "   \t\t\t\t" + NL + "\t    \t\tif(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null) { //";
  protected final String TEXT_9 = "              " + NL + "                 nameValues_";
  protected final String TEXT_10 = "[";
  protected final String TEXT_11 = "] = new org.talend.sugarws.Name_value(\"";
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
  protected final String TEXT_23 = NL + "\t\t\t\t\t          );\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t    \t\t} //";
  protected final String TEXT_25 = "  \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_26 = " " + NL + " \t\t\t\tString id_";
  protected final String TEXT_27 = " = sugarManagement_";
  protected final String TEXT_28 = ".setRecord(modulename_";
  protected final String TEXT_29 = ", nameValues_";
  protected final String TEXT_30 = ");" + NL + " \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_31 = "_ID\",id_";
  protected final String TEXT_32 = ");    \t\t\t" + NL + "    \t\t\tnb_line_";
  protected final String TEXT_33 = "++;" + NL + "///////////////////////    \t\t\t";
  protected final String TEXT_34 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
        String cid = node.getUniqueName();

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_1);
      
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_4);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5
  			
    				IMetadataColumn column = columns.get(i);
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
    stringBuffer.append(i );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
    		}//4
    	}//3
    }//2
}//1

    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
