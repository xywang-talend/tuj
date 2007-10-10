package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TFileOutputExcelMainJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelMainJava result = new TFileOutputExcelMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_2 = ".";
  protected final String TEXT_3 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_4 = NL + "    \t\t\t\t\t\twritableSheet";
  protected final String TEXT_5 = ".addCell(new jxl.write.";
  protected final String TEXT_6 = "Boolean";
  protected final String TEXT_7 = "DateTime";
  protected final String TEXT_8 = "Label";
  protected final String TEXT_9 = "Number";
  protected final String TEXT_10 = "(";
  protected final String TEXT_11 = ", nb_line_";
  protected final String TEXT_12 = ", " + NL + "    \t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ", cell_format_";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ".toString()";
  protected final String TEXT_23 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ")).toString()";
  protected final String TEXT_26 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = NL + "\t\t\t\t\t\t\t));";
  protected final String TEXT_29 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_30 = NL + "    \t\t\tnb_line_";
  protected final String TEXT_31 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_3);
    
    				} 
    				
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
    									if(javaType == JavaTypesManager.BOOLEAN){
    										
    stringBuffer.append(TEXT_6);
    
										}else if(javaType == JavaTypesManager.DATE){
											
    stringBuffer.append(TEXT_7);
    
  									    }else if(javaType == JavaTypesManager.STRING||
  									    		 javaType == JavaTypesManager.CHARACTER||
  									    		 javaType == JavaTypesManager.BYTE_ARRAY||
  									    		 javaType == JavaTypesManager.OBJECT){
  									    	
    stringBuffer.append(TEXT_8);
    
    									}else{
    										
    stringBuffer.append(TEXT_9);
    
    									}
    																	
    stringBuffer.append(TEXT_10);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( cid);
    				
					} else if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    				
					} else if(javaType == JavaTypesManager.OBJECT){

    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    					
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_25);
    					
					}else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    				
					}

    stringBuffer.append(TEXT_28);
    
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_29);
    
    				} 
    			}
    			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
    		}
    	}
    }
}

    return stringBuffer.toString();
  }
}
