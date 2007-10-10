package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TContextLoadMainJava
{
  protected static String nl;
  public static synchronized TContextLoadMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TContextLoadMainJava result = new TContextLoadMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t//////////////////////////";
  protected final String TEXT_2 = "    \t\t";
  protected final String TEXT_3 = NL + "\tString ";
  protected final String TEXT_4 = "_";
  protected final String TEXT_5 = " = null;\t\t\t\t";
  protected final String TEXT_6 = "   \t\t\t\t" + NL + "\tif(";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " != null) {";
  protected final String TEXT_9 = NL + "    \t";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = " =";
  protected final String TEXT_12 = "FormatterUtils.format_Date(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ");\t\t\t\t\t";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ";\t\t\t\t\t";
  protected final String TEXT_18 = "String.valueOf(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ");\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t}";
  protected final String TEXT_22 = NL + " \t\t\t\t";
  protected final String TEXT_23 = NL + NL + "\tif (context.getProperty(key_";
  protected final String TEXT_24 = ")!=null)" + NL + "\t{" + NL + "\t\tcontext.setProperty(key_";
  protected final String TEXT_25 = ",value_";
  protected final String TEXT_26 = ");" + NL + "\t\tassignList_";
  protected final String TEXT_27 = ".add(key_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = "\t" + NL + "\t\tSystem.out.println(\"";
  protected final String TEXT_30 = " set key \" + key_";
  protected final String TEXT_31 = " + \" with value \" + value_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t}" + NL + "\telse  {" + NL + "\t\tSystem.err.println(\"";
  protected final String TEXT_34 = ", invalid parameter name : \" + key_";
  protected final String TEXT_35 = ");" + NL + "\t}" + NL + "\tnb_line_";
  protected final String TEXT_36 = "++;";
  protected final String TEXT_37 = "    \t" + NL + "    \t//////////////////////////";

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

    stringBuffer.append(TEXT_1);
    
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {    		

    stringBuffer.append(TEXT_2);
    		
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int i = 0; (sizeColumns >= 2)&&(i < 2); i++) {
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());					

    stringBuffer.append(TEXT_3);
    stringBuffer.append(i==0?"key":"value" );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    					
		if(!isPrimitive) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    
} 

    stringBuffer.append(TEXT_9);
    stringBuffer.append(i==0?"key":"value" );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
      						

    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_15);
    				
					} else if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    				
					} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    				
}					

    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_21);
    					
	} 

    stringBuffer.append(TEXT_22);
     
}//here end the last for, the List "columns"

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
	if (ElementParameterParser.getValue(node, "__PRINT_OPERATIONS__").equals("true")) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
  }	

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
	}
}//here end the first for, the List "conns"

    stringBuffer.append(TEXT_37);
    
  }
}  

    return stringBuffer.toString();
  }
}
