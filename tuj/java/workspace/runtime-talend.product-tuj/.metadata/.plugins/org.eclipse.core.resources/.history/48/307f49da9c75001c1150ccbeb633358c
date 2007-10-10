package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.commons.utils.generation.LocationUtils;
import org.talend.commons.utils.generation.EntryLocation;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TFilterRowMainJava
{
  protected static String nl;
  public static synchronized TFilterRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFilterRowMainJava result = new TFilterRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        boolean branch_";
  protected final String TEXT_3 = "_is_active = false;" + NL + "        nb_line_";
  protected final String TEXT_4 = "++ ;";
  protected final String TEXT_5 = NL + "            if (true";
  protected final String TEXT_6 = NL + "            if(            ";
  protected final String TEXT_7 = "                ";
  protected final String TEXT_8 = NL + "                    ";
  protected final String TEXT_9 = NL + "                    ";
  protected final String TEXT_10 = NL + "                        ";
  protected final String TEXT_11 = NL + "                                (";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " != null && ";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = NL + "                                ";
  protected final String TEXT_16 = NL + "        ) {" + NL + "            branch_";
  protected final String TEXT_17 = "_is_active = true ;" + NL + "            nb_line_ok_";
  protected final String TEXT_18 = "++ ;" + NL + "        }" + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL + NL;
  protected final String TEXT_19 = NL + "    \t  if(branch_";
  protected final String TEXT_20 = "_is_active){" + NL + "    \t      ";
  protected final String TEXT_21 = " = new ";
  protected final String TEXT_22 = "Struct();" + NL + "    \t      ";
  protected final String TEXT_23 = NL + "    \t              ";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ";" + NL + "    \t              ";
  protected final String TEXT_28 = NL + "    \t  }else{" + NL + "    \t\t";
  protected final String TEXT_29 = " = null;" + NL + "    \t  }";
  protected final String TEXT_30 = NL + NL + NL + NL + NL + NL + " \t\t";
  protected final String TEXT_31 = NL + " \t\t    if(!branch_";
  protected final String TEXT_32 = "_is_active){" + NL + " \t\t        ";
  protected final String TEXT_33 = " = new ";
  protected final String TEXT_34 = "Struct();" + NL + " \t\t        ";
  protected final String TEXT_35 = NL + " \t\t                ";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = "=";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ";" + NL + " \t\t                ";
  protected final String TEXT_40 = NL + " \t\t    }else{" + NL + " \t\t        ";
  protected final String TEXT_41 = "=null;" + NL + " \t\t    }" + NL + "\t    ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class Transfer{
	public String function(String function, String connName, String columnName ,String typeName, JavaType javaType){
		if(function.equals("S_VALUE_OF")){
			return "(" + connName + "." + columnName + ")";
		}else if(function.equals("N_VALUE_OF_FLOAT")){
	        if(javaType == JavaTypesManager.BYTE || 
	                javaType == JavaTypesManager.SHORT ||
	                javaType == JavaTypesManager.INTEGER || 
	                javaType == JavaTypesManager.LONG || 
	                javaType == JavaTypesManager.DOUBLE) {
	            return "((Float)Float.parseFloat(String.valueOf("+connName+"."+columnName+")))";         
	        } else if(javaType == JavaTypesManager.FLOAT) {
	            if(typeName.equals("Float")) {
	                return connName + "." + columnName; 
	            } else {
	                return "((Float)" + connName + "." + columnName + ")";
	            }           
	        } else if(javaType == JavaTypesManager.STRING) {
	            return "((Float)Float.parseFloat(" + connName + "." + columnName + "))";
	        } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
	            return null;
	        } else if(javaType == JavaTypesManager.DATE) {
	            return null;
	        } else if(javaType == JavaTypesManager.BOOLEAN) {
	            return null;
	        } else {
	            return null;
	        }		    
		}else if(function.equals("N_VALUE_OF_INTEGER")){
            if(javaType == JavaTypesManager.BYTE || 
                    javaType == JavaTypesManager.SHORT ||
                    javaType == JavaTypesManager.FLOAT || 
                    javaType == JavaTypesManager.LONG || 
                    javaType == JavaTypesManager.DOUBLE) {
                return "((Integer)Integer.parseInt(String.valueOf("+connName+"."+columnName+")))";         
            } else if(javaType == JavaTypesManager.INTEGER) {
                if(typeName.equals("Integer")) {
                    return connName + "." + columnName; 
                } else {
                    return "((Integer)" + connName + "." + columnName + ")";
                }           
            } else if(javaType == JavaTypesManager.STRING) {
                return "((Integer)Integer.parseInt(" + connName + "." + columnName + "))";
            } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                return null;
            } else if(javaType == JavaTypesManager.DATE) {
                return null;
            } else if(javaType == JavaTypesManager.BOOLEAN) {
                return null;
            } else {
                return null;
            }
		}else if(function.equals("ABS_VALUE_FLOAT")){
            if(javaType == JavaTypesManager.BYTE || 
                    javaType == JavaTypesManager.SHORT ||
                    javaType == JavaTypesManager.INTEGER || 
                    javaType == JavaTypesManager.LONG || 
                    javaType == JavaTypesManager.DOUBLE) {
                return "((Float)Math.abs(Float.parseFloat(String.valueOf("+connName+"."+columnName+"))))";         
            } else if(javaType == JavaTypesManager.FLOAT) {
                if(typeName.equals("Float")) {
                    return "((Float)" + "Math.abs(" + connName + "." + columnName + ".floatValue()))"; 
                } else {
                    return "((Float)" + "Math.abs(" + connName + "." + columnName + "))";
                }           
            } else if(javaType == JavaTypesManager.STRING) {
                return "((Float)Math.abs(Float.parseFloat(" + connName + "." + columnName + ")))";
            } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                return null;
            } else if(javaType == JavaTypesManager.DATE) {
                return null;
            } else if(javaType == JavaTypesManager.BOOLEAN) {
                return null;
            } else {
                return null;
            }		    
		}else if(function.equals("ABS_VALUE_INTEGER")){
            if(javaType == JavaTypesManager.BYTE || 
                    javaType == JavaTypesManager.SHORT ||
                    javaType == JavaTypesManager.FLOAT || 
                    javaType == JavaTypesManager.LONG || 
                    javaType == JavaTypesManager.DOUBLE) {
                return "((Integer)Math.abs(Integer.parseInt(String.valueOf("+connName+"."+columnName+"))))";         
            } else if(javaType == JavaTypesManager.INTEGER) {
                if(typeName.equals("Integer")) {
                    return "((Integer)" + "Math.abs(" + connName + "." + columnName + ".intValue()))"; 
                } else {
                    return "((Integer)" + "Math.abs(" + connName + "." + columnName + "))";
                }           
            } else if(javaType == JavaTypesManager.STRING) {
                return "((Integer)Math.abs(Integer.parseInt(" + connName + "." + columnName + ")))";
            } else if(javaType == JavaTypesManager.BYTE_ARRAY) {
                return null;
            } else if(javaType == JavaTypesManager.DATE) {
                return null;
            } else if(javaType == JavaTypesManager.BOOLEAN) {
                return null;
            } else {
                return null;
            }
		}else if(function.equals("LC")){
		    if(javaType == JavaTypesManager.STRING) {
		        return "(" + connName + "." + columnName + ").toLowerCase()"; 
		    } else {
		        return null;
		    }			
		}else if(function.equals("UC")){
		    if(javaType == JavaTypesManager.STRING) {
		        return "(" + connName + "." + columnName + ").toUpperCase()"; 
		    } else {
		        return null;
		    }			
		}else if(function.equals("LCFIRST")){
		    if(javaType == JavaTypesManager.STRING) {
		        return "((" + connName + "." + columnName + ").substring(0, 1).toLowerCase()+(" + connName + "." + columnName+").substring(1))";
		    } else {
		        return null;
		    }			
		}else if(function.equals("UCFIRST")){
		    if(javaType == JavaTypesManager.STRING) {
		        return "((" + connName + "." + columnName + ").substring(0, 1).toUpperCase()+(" + connName + "." + columnName+").substring(1))";
		    } else {
		        return null;
		    }
		}else if(function.equals("LENGTH")){
		    if(javaType == JavaTypesManager.STRING) {
		        return "((Integer)(" + connName + "." + columnName + ").length())";
		    } else {
		        return null;
		    }
		}
		return null;
	}
	
	public String operator(String operator, String value, String function, String connName, String columnName ,String typeName, JavaType javaType){
		//if(value.startsWith("\""))	
		
		
		if(operator.equals("EQ")){
			return function(function,connName,columnName,typeName,javaType)+".equals("+value+")";
		}else if(operator.equals("NE")){
			return "!("+function(function,connName,columnName,typeName,javaType)+".equals("+value+"))";
		}else if(operator.equals("GT")){
			return "("+function(function,connName,columnName,typeName,javaType)+".compareTo("+value+")>0)";
		}else if(operator.equals("LT")){
			return "("+function(function,connName,columnName,typeName,javaType)+".compareTo("+value+")<0)";
		}else if(operator.equals("GE")){
			return "("+function(function,connName,columnName,typeName,javaType)+".compareTo("+value+")>=0)";
		}else if(operator.equals("LE")){
			return "("+function(function,connName,columnName,typeName,javaType)+".compareTo("+value+")<=0)";
		}else if(operator.equals("MATCH")){
			return "("+function(function,connName,columnName,typeName,javaType)+".matches("+value+"))";
		}else if(operator.equals("NMATCH")){
			return "!("+function(function,connName,columnName,typeName,javaType)+".matches("+value+"))";
		}
		return null;
	}
	
	
	public String logical(String logical){
		if(logical.equals("AND")){
			return "&&";
		}else if(logical.equals("OR")){
			return "||";
		}
		return null;
	}
}

Transfer tr=new Transfer();

CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataColumn> columnList = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
// We need the name of the input connection and the name of the
// previous component
String inputRowName = new String("input_row");
String prevComponentName = new String("prev_component_name");
String cid=null;
boolean flag=true;

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	columnList = metadata.getListColumns();
        cid = metadata.getTableName();       
        String logical = ElementParameterParser.getValue(node,"__LOGICAL_OP__");
        String use_advanced = ElementParameterParser.getValue(node,"__USE_ADVANCED__");
        String advanced = ElementParameterParser.getValue(node,"__ADVANCED_COND__");
        List<Map<String, String>> conditions =
        (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CONDITIONS__");
        JavaType javaType = null;
        String typeName = null;
        if (inConns != null && !inConns.isEmpty()) {
            IConnection inConn = inConns.get(0);
            inputRowName = inConn.getName();
            prevComponentName = inConn.getMetadataTable().getTableName();
        }
        
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
        if(conditions.size() == 0 && use_advanced.equals("false")){
            
    stringBuffer.append(TEXT_5);
    
        }else{
            
    stringBuffer.append(TEXT_6);
    
                if(use_advanced.equals("true")){
                    LocationUtils locationUtils = new LocationUtils(); 
                    //replace column label by column position constant
                    List<EntryLocation> locations = new ArrayList<EntryLocation>();
                    if (inConns != null && !inConns.isEmpty()) {
                        IConnection inConn = inConns.get(0);
                        IMetadataTable inMetadata = inConn.getMetadataTable();
                        List<IMetadataColumn> columns = inMetadata.getListColumns();
                        for(IMetadataColumn column : columns) {
                            locations.add(new EntryLocation(inputRowName,column.getLabel()));
                        }
                    }    
                    advanced = advanced.replaceAll("input_row",inputRowName);              
                    advanced = locationUtils.replaceColumnNameToConstantName(advanced,(EntryLocation[])locations.toArray(new EntryLocation[0]));   
                    
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(advanced);
    
                }
                if(use_advanced.equals("true")) {
                    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tr.logical(logical));
    
                }                
                boolean isFirst = true ;            
                for(int i = 0 ; i < conditions.size() ; i++) {
                    Map<String, String> condition = conditions.get(i);
                    if(!isFirst){
                        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tr.logical(logical));
    
                    }
                    for(IMetadataColumn metadataColumn : columnList) {
                        if(metadataColumn.getLabel().equals(condition.get("INPUT_COLUMN"))) {
                            javaType = JavaTypesManager.getJavaTypeFromId(metadataColumn.getTalendType());
                            typeName = JavaTypesManager.getTypeToGenerate(metadataColumn.getTalendType(), metadataColumn.isNullable());
                            boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType(javaType,metadataColumn.isNullable());
                            if(!isPrimitive) {
                                
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inputRowName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(condition.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tr.operator(condition.get("OPERATOR"),condition.get("RVALUE"),condition.get("FUNCTION"),inputRowName,condition.get("INPUT_COLUMN"),typeName,javaType));
    stringBuffer.append(TEXT_14);
    
                            } else {
                                
    stringBuffer.append(TEXT_15);
    stringBuffer.append(tr.operator(condition.get("OPERATOR"),condition.get("RVALUE"),condition.get("FUNCTION"),inputRowName,condition.get("INPUT_COLUMN"),typeName,javaType));
    
                            }
                            break;
                        }
                    }
                    isFirst = false ;                        
                }//for            
        }
        
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
		List< ? extends IConnection> connsFilter = node.getOutgoingConnections("FILTER");
 		for(int connNO = 0; connNO < connsFilter.size(); connNO++){
    	  IConnection conn2 = connsFilter.get(connNO);
    	  
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_22);
    
    	      if(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    	          for(IMetadataColumn column:columnList){
    	              
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inputRowName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_27);
     
    	          }
    	      }
    	      
    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_29);
    
 		}
 		
    stringBuffer.append(TEXT_30);
    
		List< ? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
 		for(int connNO = 0; connNO < connsReject.size(); connNO++){
 		    IConnection conn2 = connsReject.get(connNO);
 		    
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_34);
    
 		        if(conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
 		            for(IMetadataColumn column:columnList){
 		                
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(inputRowName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_39);
     
 		            }
 		        }
 		        
    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_41);
    
 		}
 		
    
 }
}

    return stringBuffer.toString();
  }
}
