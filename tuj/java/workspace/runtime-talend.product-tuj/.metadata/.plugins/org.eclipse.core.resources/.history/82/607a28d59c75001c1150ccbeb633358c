package org.talend.designer.codegen.translators.file.output;

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

public class TFileOutputLDIFMainJava
{
  protected static String nl;
  public static synchronized TFileOutputLDIFMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputLDIFMainJava result = new TFileOutputLDIFMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t//////////////////////////";
  protected final String TEXT_2 = " " + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();\t\t   \t\t";
  protected final String TEXT_4 = NL + "\t\tString value_";
  protected final String TEXT_5 = "_";
  protected final String TEXT_6 = " = \"\";";
  protected final String TEXT_7 = "   \t\t\t\t" + NL + "\t    if(";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = " != null) {";
  protected final String TEXT_10 = NL + "    \tvalue_";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = " =  \t\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\tFormatterUtils.format_Date(";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ";";
  protected final String TEXT_20 = NL + "\t\tString.valueOf(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ");";
  protected final String TEXT_23 = NL + "\t    }";
  protected final String TEXT_24 = "\t\t" + NL + "\t\tutil_";
  protected final String TEXT_25 = ".breakString(sb_";
  protected final String TEXT_26 = ", dn_";
  protected final String TEXT_27 = " + value_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = ", wrap_";
  protected final String TEXT_30 = ");" + NL + "        util_";
  protected final String TEXT_31 = ".breakString(sb_";
  protected final String TEXT_32 = ", changetype_";
  protected final String TEXT_33 = " + \"";
  protected final String TEXT_34 = "\", wrap_";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = "\t\t\t\t\t\t";
  protected final String TEXT_37 = NL + "    \tutil_";
  protected final String TEXT_38 = ".breakString(sb_";
  protected final String TEXT_39 = ", \"";
  protected final String TEXT_40 = ": \" + \"";
  protected final String TEXT_41 = "\", wrap_";
  protected final String TEXT_42 = ");" + NL + "    \tutil_";
  protected final String TEXT_43 = ".breakString(sb_";
  protected final String TEXT_44 = ", \"";
  protected final String TEXT_45 = ": \" + value_";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = ", wrap_";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\t\tsb_";
  protected final String TEXT_50 = ".append(\"-\\n\");\t";
  protected final String TEXT_51 = NL + "\t\tutil_";
  protected final String TEXT_52 = ".breakString(sb_";
  protected final String TEXT_53 = ", \"";
  protected final String TEXT_54 = ": \" + value_";
  protected final String TEXT_55 = "_";
  protected final String TEXT_56 = ", wrap_";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = "\t" + NL + "" + NL + "  \t\t\t\t";
  protected final String TEXT_59 = "\t\t\t\t\t\t" + NL + "\t\tsb_";
  protected final String TEXT_60 = ".append('\\n');\t\t" + NL + "\t\t" + NL + "\t\tpw_";
  protected final String TEXT_61 = ".write(sb_";
  protected final String TEXT_62 = ".toString());" + NL + "    \tnb_line_";
  protected final String TEXT_63 = "++;";
  protected final String TEXT_64 = "    \t" + NL + "    \t//////////////////////////";

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
        String changetype = ElementParameterParser.getValue(node, "__CHANGETYPE__");
		String changes = ElementParameterParser.getValue(node, "__CHANGES__");


    stringBuffer.append(TEXT_1);
    
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {    		

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    		
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());					

    stringBuffer.append(TEXT_4);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    					
					if(!isPrimitive) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_9);
    
} 

    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_16);
    				
					} else if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    				
					} else {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_22);
    				
}					

    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_23);
    					
	} 

     
	if(i==0) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
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
    stringBuffer.append(changetype );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
 } 

    stringBuffer.append(TEXT_36);
     if ("delete".equals(changetype)) { break; } 
     if ("modify".equals(changetype)) {   
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(changes );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    	if(i != sizeColumns - 1) {  
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
}

    
}// here end the if modify

     if ("add".equals(changetype)) {   
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    
}

    stringBuffer.append(TEXT_58);
     
}//here end the last for, the List "columns"

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
	}
}//here end the first for, the List "conns"

    stringBuffer.append(TEXT_64);
    
  }
}  

    return stringBuffer.toString();
  }
}
