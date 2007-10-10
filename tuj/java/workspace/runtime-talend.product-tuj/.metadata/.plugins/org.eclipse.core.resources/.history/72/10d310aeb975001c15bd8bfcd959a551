package org.talend.designer.codegen.translators.dataquality;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TSchemaComplianceCheckMainJava
{
  protected static String nl;
  public static synchronized TSchemaComplianceCheckMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSchemaComplianceCheckMainJava result = new TSchemaComplianceCheckMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = " = null;\t\t\t";
  protected final String TEXT_3 = "    " + NL + "    boolean ifPassed_";
  protected final String TEXT_4 = " = true;" + NL + "    String errorCode_";
  protected final String TEXT_5 = " = null;" + NL + "    String errorMessage_";
  protected final String TEXT_6 = " = null;";
  protected final String TEXT_7 = NL + "                try {";
  protected final String TEXT_8 = NL + "                    ";
  protected final String TEXT_9 = " tester_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".valueOf(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ");" + NL + "                } catch(Exception e) {" + NL + "                    ifPassed_";
  protected final String TEXT_14 = " = false;" + NL + "                    errorCode_";
  protected final String TEXT_15 = " = \"2\";" + NL + "                    errorMessage_";
  protected final String TEXT_16 = " = \"wrong type\";" + NL + "                }";
  protected final String TEXT_17 = NL + "                    if(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = " != null) {" + NL + "                        if(";
  protected final String TEXT_20 = ".";
  protected final String TEXT_21 = ".length() > ";
  protected final String TEXT_22 = ") {" + NL + "                            ifPassed_";
  protected final String TEXT_23 = " = false;" + NL + "                            errorCode_";
  protected final String TEXT_24 = " = \"8\";" + NL + "                            errorMessage_";
  protected final String TEXT_25 = " = \"exceed max length\";                        " + NL + "                        }" + NL + "                    }";
  protected final String TEXT_26 = NL + "                    //validate nullable" + NL + "                    boolean ";
  protected final String TEXT_27 = "_inputTypeCanTestNullable_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";" + NL + "                    if(";
  protected final String TEXT_30 = " && ";
  protected final String TEXT_31 = "_inputTypeCanTestNullable_";
  protected final String TEXT_32 = " && " + NL + "                       \t";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = " == null) {" + NL + "                        ifPassed_";
  protected final String TEXT_35 = " = false;" + NL + "                        errorCode_";
  protected final String TEXT_36 = " = \"4\";" + NL + "                        errorMessage_";
  protected final String TEXT_37 = " = \"empty or null\";                        " + NL + "                    }" + NL + "                    //validate maxlength";
  protected final String TEXT_38 = NL + "                        boolean ";
  protected final String TEXT_39 = "_inputTypeCanTestNullable_";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";" + NL + "                        if(";
  protected final String TEXT_42 = "_inputTypeCanTestNullable_";
  protected final String TEXT_43 = " && " + NL + "                        \t";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = " == null) {" + NL + "                            ifPassed_";
  protected final String TEXT_46 = " = false;" + NL + "                            errorCode_";
  protected final String TEXT_47 = " = \"4\";" + NL + "                            errorMessage_";
  protected final String TEXT_48 = " = \"empty or null\";                        " + NL + "                        }                        ";
  protected final String TEXT_49 = NL + "        if(ifPassed_";
  protected final String TEXT_50 = ") {";
  protected final String TEXT_51 = "            ";
  protected final String TEXT_52 = NL + "                ";
  protected final String TEXT_53 = " = new ";
  protected final String TEXT_54 = "Struct();";
  protected final String TEXT_55 = NL + "                        ";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = ";";
  protected final String TEXT_60 = NL + "        }";
  protected final String TEXT_61 = NL + "        if(!ifPassed_";
  protected final String TEXT_62 = ") {";
  protected final String TEXT_63 = NL + "            ";
  protected final String TEXT_64 = " = new ";
  protected final String TEXT_65 = "Struct();";
  protected final String TEXT_66 = NL + "                ";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ";";
  protected final String TEXT_71 = NL + "            ";
  protected final String TEXT_72 = ".errorCode = errorCode_";
  protected final String TEXT_73 = ";";
  protected final String TEXT_74 = NL + "            ";
  protected final String TEXT_75 = ".errorMessage = errorMessage_";
  protected final String TEXT_76 = ";            " + NL + "        }";
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String incomingConnName = null;
List<? extends IConnection> conns = node.getIncomingConnections();
if(conns != null && conns.size() > 0) {
    for(IConnection conn : conns) {
        incomingConnName = conn.getName();
        break;
    }
}
String rejectConnName = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    for(IConnection conn : rejectConns) {
        rejectConnName = conn.getName();
    }
}
List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
List<IMetadataColumn> columnList = node.getMetadataFromConnector("FLOW").getListColumns();
List<IMetadataColumn> columnListToTest = columnList;

if(incomingConnName != null && columnList != null && columnList.size() > 0) {
    for(IConnection conn : outgoingConns) {
    	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_2);
    
    	}
	}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
    String anotherChecked = ElementParameterParser.getValue(node,"__CHECK_ANOTHER__");
    String checkAll = ElementParameterParser.getValue(node,"__CHECK_ALL__");
    List<IMetadataColumn> schemaOtherColumns = null;
    if(anotherChecked.equals("true")) {
        IMetadataTable schemaOther = node.getMetadataFromConnector("OTHER");
        if(schemaOther != null) {
            columnListToTest = schemaOther.getListColumns();
        }
    }
    class SchemaChecker {
        public void  testDataType(String incomingConnName, IMetadataColumn metadataColumn, String typeSelected, String cid) {
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.STRING) {
                
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(typeSelected);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
            }
        }
        public void testDataLength(String incomingConnName, IMetadataColumn metadataColumn, Integer maxLength, String cid) {
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
            if(javaType == JavaTypesManager.STRING) {
                if(maxLength != null)
                {
                    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(maxLength);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
                }
            }
        }
    }
    SchemaChecker checker = new SchemaChecker();
    List<Map<String, String>> checkedColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CHECKCOLS__");
    for(IMetadataColumn metadataColumn : columnList) {
        for(Map<String, String> checkedColumn : checkedColumns) {
            if(metadataColumn.getLabel().equals(checkedColumn.get("SCHEMA_COLUMN"))) {
            	int columnIndex = columnList.indexOf(metadataColumn);
            	if (anotherChecked.equals("true") && (columnListToTest.size() > columnIndex)) {
            		String typeToTest = columnListToTest.get(columnList.indexOf(metadataColumn)).getTalendType();
            		typeToTest = JavaTypesManager.getTypeToGenerate(typeToTest, true);
            		checker.testDataType(incomingConnName,metadataColumn,typeToTest,cid);
            	} else {
                	checker.testDataType(incomingConnName,metadataColumn,checkedColumn.get("SELECTED_TYPE"),cid);
                }
                if(checkAll.equals("true") || anotherChecked.equals("true")) {
                	if (columnListToTest.size() < columnIndex) {
                		continue;
                	}
                    
    stringBuffer.append(TEXT_26);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(!JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType()).isPrimitive());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(!columnListToTest.get(columnIndex).isNullable());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
                    checker.testDataLength(incomingConnName,metadataColumn,columnListToTest.get(columnIndex).getLength(),cid);
                } else {
                    String checkNullable = checkedColumn.get("NULLABLE");
                    String checkMaxLength = checkedColumn.get("MAX_LENGTH");
                    if(checkNullable.equals("true") && !metadataColumn.isNullable()) { // if the column we test is nullable, no need
                        
    stringBuffer.append(TEXT_38);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(!JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType()).isPrimitive());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
                    }
                    if(checkMaxLength.equals("true")) {
                        checker.testDataLength(incomingConnName,metadataColumn, metadataColumn.getLength(),cid);
                    }
                }
                break;
            }
        }
    }
    if(outgoingConns != null && outgoingConns.size() > 0) {
        
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
        
            for(IConnection conn : outgoingConns) {
                if(rejectConnName == null || (rejectConnName != null && !rejectConnName.equals(conn.getName()))){
            
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    for(IMetadataColumn metadataColumn : columnList) {
                        
    stringBuffer.append(TEXT_55);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_59);
    
                    }
                }
            }
        
    stringBuffer.append(TEXT_60);
    
    }
    if(rejectConnName != null) {
        
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_65);
    
            for(IMetadataColumn metadataColumn : columnList) {
                
    stringBuffer.append(TEXT_66);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_70);
    
            }
            
    stringBuffer.append(TEXT_71);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
    }
}

    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
