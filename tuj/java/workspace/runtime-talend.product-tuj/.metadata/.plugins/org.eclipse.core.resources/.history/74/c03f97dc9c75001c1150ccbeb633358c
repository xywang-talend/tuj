package org.talend.designer.codegen.translators.databases.dbjdbc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class TJDBCRowMainJava
{
  protected static String nl;
  public static synchronized TJDBCRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCRowMainJava result = new TJDBCRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "statement_";
  protected final String TEXT_3 = " = connection_";
  protected final String TEXT_4 = ".prepareStatement(";
  protected final String TEXT_5 = ");" + NL + "" + NL + "whetherReject_";
  protected final String TEXT_6 = " = false;";
  protected final String TEXT_7 = NL + "    commitCounter_";
  protected final String TEXT_8 = "++;";
  protected final String TEXT_9 = NL + "                        statement_";
  protected final String TEXT_10 = ".setString(";
  protected final String TEXT_11 = ", String.valueOf(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = "));";
  protected final String TEXT_14 = NL + "                        if (";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = " != null) {" + NL + "                            statement_";
  protected final String TEXT_17 = ".setDate(";
  protected final String TEXT_18 = ", new java.sql.Date(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ".getTime()));" + NL + "                        } else {" + NL + "                            statement_";
  protected final String TEXT_21 = ".setDate(";
  protected final String TEXT_22 = ", null);" + NL + "                        }";
  protected final String TEXT_23 = NL + "                        statement_";
  protected final String TEXT_24 = ".set";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "try {" + NL + "    statement_";
  protected final String TEXT_30 = ".execute();" + NL + "} catch (Exception e) {" + NL + "    whetherReject_";
  protected final String TEXT_31 = " = true;";
  protected final String TEXT_32 = NL + "        throw(e);";
  protected final String TEXT_33 = NL + "                ";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = ";";
  protected final String TEXT_38 = NL + "            ";
  protected final String TEXT_39 = ".errorMessage = e.getMessage();";
  protected final String TEXT_40 = NL + "            System.err.print(e.getMessage());";
  protected final String TEXT_41 = NL + "}" + NL;
  protected final String TEXT_42 = NL + "    if(!whetherReject_";
  protected final String TEXT_43 = ") {";
  protected final String TEXT_44 = NL + "                        ";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ";";
  protected final String TEXT_49 = NL + "    }";
  protected final String TEXT_50 = NL + "    if (commitEvery_";
  protected final String TEXT_51 = " <= commitCounter_";
  protected final String TEXT_52 = ") {" + NL + "        connection_";
  protected final String TEXT_53 = ".commit();" + NL + "        commitCounter_";
  protected final String TEXT_54 = " = 0;" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid =  node.getUniqueName();

String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

String incomingConnName = null;

List<IMetadataColumn> columnList = null;

String rejectConnName = null;
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectConnName = rejectConn.getName();
}
List<IMetadataColumn> rejectColumnList = null;
IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
if(metadataTable != null) {
    rejectColumnList = metadataTable.getListColumns();      
}

List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
if (!commitEvery.equals("") && !commitEvery.equals("0")) {
    
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
}

int parametersCount = 0;
int index = dbquery.indexOf("?");
while (index >= 0) {
    parametersCount++;
    index = dbquery.indexOf("?", index + 1);
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata != null) {
        List<? extends IConnection> inConnections = node.getIncomingConnections();
        columnList = metadata.getListColumns();
        
        if (inConnections != null && inConnections.size() > 0){
            IConnection inConnection = inConnections.get(0);
            incomingConnName = inConnection.getName();
            int parameterIndex = 1;
            
            for (IMetadataColumn column : columnList) {
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                
                String method;
                if (typeToGenerate.equals("byte[]")) {
                    method = "Bytes";
                } else if (typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                    method = "String";
                } else if (typeToGenerate.equals("java.util.Date")) {
                    method = "Date";
                } else if (typeToGenerate.equals("Integer")) {
                    method = "Int";
                } else {
                    method = typeToGenerate.substring(0, 1).toUpperCase() + typeToGenerate.substring(1);
                }
                
                // Bind parameter to SQL statement
                if (parameterIndex <= parametersCount) {
                    if (typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(parameterIndex);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inConnection.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_13);
    
                    } else if (typeToGenerate.equals("java.util.Date")) {
                        
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inConnection.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(parameterIndex);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(inConnection.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(parameterIndex);
    stringBuffer.append(TEXT_22);
    
                    } else {
                        
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(parameterIndex);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(inConnection.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_28);
    
                    }
                }
                
                parameterIndex++;
            }
        }
    }
}


    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
    if (dieOnError.equals("true")) {
        
    stringBuffer.append(TEXT_32);
    
    } else {
        if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
            for(IMetadataColumn column : columnList) {
                
    stringBuffer.append(TEXT_33);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_37);
    
            }
            
    stringBuffer.append(TEXT_38);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_39);
    
        } else {
            
    stringBuffer.append(TEXT_40);
    
        }
    } 
    
    stringBuffer.append(TEXT_41);
    

if(outgoingConns != null && outgoingConns.size() > 0) {
    
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    
        for(IConnection outgoingConn : outgoingConns) {
            if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
                if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                    for(IMetadataColumn column : columnList) {
                        
    stringBuffer.append(TEXT_44);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
                      
                    }
                }
            }
        }
    
    stringBuffer.append(TEXT_49);
    
}

if (!commitEvery.equals("") && !commitEvery.equals("0")) {
    
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
}

    return stringBuffer.toString();
  }
}
