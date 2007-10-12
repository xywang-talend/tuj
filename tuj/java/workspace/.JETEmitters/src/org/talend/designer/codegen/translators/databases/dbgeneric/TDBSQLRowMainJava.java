package org.talend.designer.codegen.translators.databases.dbgeneric;

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

public class TDBSQLRowMainJava
{
  protected static String nl;
  public static synchronized TDBSQLRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDBSQLRowMainJava result = new TDBSQLRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    commitCounter_";
  protected final String TEXT_3 = "++;";
  protected final String TEXT_4 = NL + "whetherReject_";
  protected final String TEXT_5 = " = false;";
  protected final String TEXT_6 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t    pstmt_";
  protected final String TEXT_7 = ".setString(";
  protected final String TEXT_8 = ",String.valueOf(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = "));\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_11 = NL + "                                if(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = "!=null){\t\t\t\t\t\t\t\t\t\t\t\t\t" + NL + "                                \tpstmt_";
  protected final String TEXT_14 = ".set";
  protected final String TEXT_15 = "(";
  protected final String TEXT_16 = ",new java.sql.Date(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ".getTime()));" + NL + "                                }else{" + NL + "                                \tpstmt_";
  protected final String TEXT_19 = ".set";
  protected final String TEXT_20 = "(";
  protected final String TEXT_21 = ",null);" + NL + "                                }\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_22 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t    pstmt_";
  protected final String TEXT_23 = ".set";
  protected final String TEXT_24 = "(";
  protected final String TEXT_25 = ",";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ");\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_28 = NL + "    try {" + NL + "    \tpstmt_";
  protected final String TEXT_29 = ".execute(";
  protected final String TEXT_30 = ");" + NL + "    } catch (Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_31 = " = true;";
  protected final String TEXT_32 = NL + "            throw(e);";
  protected final String TEXT_33 = NL + "                    ";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = ";";
  protected final String TEXT_38 = NL + "                ";
  protected final String TEXT_39 = ".errorMessage = e.getMessage();";
  protected final String TEXT_40 = NL + "                System.err.print(e.getMessage());";
  protected final String TEXT_41 = NL + "    }" + NL + "\t";
  protected final String TEXT_42 = NL + "        if(!whetherReject_";
  protected final String TEXT_43 = ") {";
  protected final String TEXT_44 = NL + "                            ";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ";";
  protected final String TEXT_49 = NL + "        }";
  protected final String TEXT_50 = NL + "    if(commitEvery_";
  protected final String TEXT_51 = "<=commitCounter_";
  protected final String TEXT_52 = "){" + NL + "    " + NL + "    \tconn_";
  protected final String TEXT_53 = ".commit();" + NL + "    \t" + NL + "    \tcommitCounter_";
  protected final String TEXT_54 = "=0;" + NL + "    \t" + NL + "    }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
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

if(!commitEvery.equals("")&&!commitEvery.equals("0")){
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
}
String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       dbquery = dbquery.replaceAll("\n"," ");
    	   dbquery = dbquery.replaceAll("\r"," ");


    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
int counter = 0;
int index=dbquery.indexOf("?");
while (index>=0) {
	counter++;
	index=dbquery.indexOf("?",index+1);
} 

	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
			if (metadata!=null) {
				List< ? extends IConnection> conns = node.getIncomingConnections();
				columnList = metadata.getListColumns();
			
				if(conns != null && conns.size()>0){
				IConnection conn = conns.get(0);
				incomingConnName = conn.getName();
				int parameterIndex = 1;
					for(IMetadataColumn column:columnList){
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					if(typeToGenerate.equals("byte[]")){
	 	  	   			typeToGenerate = "Bytes";
 	   	  			}else if(typeToGenerate.equals("java.util.Date")){
	 	   	  			typeToGenerate = "Date";
 	   	  			}else if(typeToGenerate.equals("Integer")){
 	   	  				typeToGenerate = "Int";
 	   	 			}else{
						typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
		  			}
		  				if(parameterIndex<=counter){
							if(typeToGenerate.equals("Char")||typeToGenerate.equals("Character")){
							
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(parameterIndex);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_10);
    
							}else if(typeToGenerate.equals("Date")){
							
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(parameterIndex);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(parameterIndex);
    stringBuffer.append(TEXT_21);
    
							}else{
							
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(parameterIndex);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
    
							}
						}
						parameterIndex++;
					}

				}//end of connection size.
			}//end of metadatas
	}
	
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbquery);
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
	
if(!commitEvery.equals("")&&!commitEvery.equals("0")){
    
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
