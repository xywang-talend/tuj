package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TNormalizeMainJava
{
  protected static String nl;
  public static synchronized TNormalizeMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TNormalizeMainJava result = new TNormalizeMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                currentRecord_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "                        tmp_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " == null ? null : String.valueOf(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ".getTime());";
  protected final String TEXT_11 = NL + "                            tmp_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = " == null ? null : ";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ".toString();";
  protected final String TEXT_17 = NL + "                            tmp_";
  protected final String TEXT_18 = " = String.valueOf(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "                        tmp_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = " == null ? null : new String(";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "                        tmp_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " == null ? null : String.valueOf(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "                        tmp_";
  protected final String TEXT_34 = " = String.valueOf(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "                    if(tmp_";
  protected final String TEXT_38 = " != null) {" + NL + "                        currentRecord_";
  protected final String TEXT_39 = ".append(tmp_";
  protected final String TEXT_40 = " + tmp_";
  protected final String TEXT_41 = ".length());" + NL + "                    }";
  protected final String TEXT_42 = NL + "                if(!recordSet_";
  protected final String TEXT_43 = ".contains(currentRecord_";
  protected final String TEXT_44 = ".toString())) {" + NL + "                    recordSet_";
  protected final String TEXT_45 = ".add(currentRecord_";
  protected final String TEXT_46 = ".toString());" + NL + "                } else {" + NL + "                    continue;" + NL + "                }";
  protected final String TEXT_47 = NL + "            String [] spliteResult_";
  protected final String TEXT_48 = " = null;" + NL + "            if(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " == null || ";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ".trim().length() == 0) {" + NL + "                spliteResult_";
  protected final String TEXT_53 = " = new String[0];" + NL + "            } else {" + NL + "                spliteResult_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ".split(";
  protected final String TEXT_57 = ");" + NL + "            }" + NL + "            for(int i_";
  protected final String TEXT_58 = " = 0 ; i_";
  protected final String TEXT_59 = " < spliteResult_";
  protected final String TEXT_60 = ".length ; i_";
  protected final String TEXT_61 = "++) {";
  protected final String TEXT_62 = NL + "                        ";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " = spliteResult_";
  protected final String TEXT_65 = "[i_";
  protected final String TEXT_66 = "];";
  protected final String TEXT_67 = NL + "                        ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = ";";
  protected final String TEXT_72 = NL + "                nb_line_";
  protected final String TEXT_73 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

    stringBuffer.append(TEXT_2);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);    
    if (metadata!=null) {//2
       
        String cid = node.getUniqueName();
        String normalizeColumn = ElementParameterParser.getValue(node, "__NORMALIZE_COLUMN__");
        String separator = ElementParameterParser.getValue(node, "__ITEMSEPARATOR__");
        String deduplicate = ElementParameterParser.getValue(node, "__DEDUPLICATE__");
        String incomingConnName = null;
        String outgoingConnName = null;

        List< ? extends IConnection> inConns = node.getIncomingConnections();
        if (inConns != null && !inConns.isEmpty()) {
            IConnection inConn = inConns.get(0);
            incomingConnName = inConn.getName();
        }
        
        List< ? extends IConnection> outConns = node.getOutgoingConnections();
        if (outConns != null && !outConns.isEmpty()) {
            IConnection outConn = outConns.get(0);
            outgoingConnName = outConn.getName();
        }
        List<IMetadataColumn> metadataColumns = metadata.getListColumns();
        if(incomingConnName != null && outgoingConnName != null && 
                metadataColumns != null && !metadataColumns.isEmpty()) {//3           
            if(deduplicate.equals("true")) {//check deduplicate start
                
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
                for(IMetadataColumn metadataColumn : metadataColumns) {
                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
                    String typeName = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
                    if(javaType == JavaTypesManager.DATE) {
                        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_10);
    
                    } else if(javaType == JavaTypesManager.BYTE || 
                            javaType == JavaTypesManager.SHORT || 
                            javaType == JavaTypesManager.FLOAT ||
                            javaType == JavaTypesManager.DOUBLE ||
                            javaType == JavaTypesManager.LONG ||
                            javaType == JavaTypesManager.INTEGER) {
                        if(typeName.equals("Byte") || 
                                typeName.equals("Short") || 
                                typeName.equals("Float") || 
                                typeName.equals("Double") || 
                                typeName.equals("Long") || 
                                typeName.equals("Integer")) {                    
                            
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_16);
    
                        } else {
                            
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_20);
    
                        }
                    } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                        
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_26);
    
                    } else if(javaType == JavaTypesManager.STRING){
                        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_32);
    
                    } else {
                        
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_36);
    
                    }
                    
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
                }
                
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
            }//check deduplicate end
            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(incomingConnName );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(normalizeColumn);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
                for(IMetadataColumn metadataColumn : metadataColumns) {
                    if(metadataColumn.getLabel().equals(normalizeColumn)) {
                        
    stringBuffer.append(TEXT_62);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
                    } else {
                        
    stringBuffer.append(TEXT_67);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_71);
    
                    }
                }
                
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
        }//3
    }//2    
}//1

    return stringBuffer.toString();
  }
}
