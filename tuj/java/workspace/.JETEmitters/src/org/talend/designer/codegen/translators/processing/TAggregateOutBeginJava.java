package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TAggregateOutBeginJava
{
  protected static String nl;
  public static synchronized TAggregateOutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateOutBeginJava result = new TAggregateOutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "class OperationStruct";
  protected final String TEXT_3 = "{" + NL;
  protected final String TEXT_4 = NL + "\tfloat ";
  protected final String TEXT_5 = "_sum;";
  protected final String TEXT_6 = NL + "\tint ";
  protected final String TEXT_7 = "_count;";
  protected final String TEXT_8 = NL + "\t";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + "}" + NL;
  protected final String TEXT_13 = "java.util.Set<";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = "java.util.Map<";
  protected final String TEXT_16 = ", OperationStruct";
  protected final String TEXT_17 = "java.util.Map<";
  protected final String TEXT_18 = ",";
  protected final String TEXT_19 = ">";
  protected final String TEXT_20 = " hash_";
  protected final String TEXT_21 = "_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = "null;";
  protected final String TEXT_24 = "new ";
  protected final String TEXT_25 = "java.util.";
  protected final String TEXT_26 = "Hash";
  protected final String TEXT_27 = "Set<";
  protected final String TEXT_28 = "java.util.";
  protected final String TEXT_29 = "Hash";
  protected final String TEXT_30 = "Map<";
  protected final String TEXT_31 = ", OperationStruct";
  protected final String TEXT_32 = "java.util.";
  protected final String TEXT_33 = "Hash";
  protected final String TEXT_34 = "Map<";
  protected final String TEXT_35 = ",";
  protected final String TEXT_36 = ">";
  protected final String TEXT_37 = "();";
  protected final String TEXT_38 = NL + "OperationStruct";
  protected final String TEXT_39 = " operation_result_";
  protected final String TEXT_40 = " = null;";
  protected final String TEXT_41 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
int sizeOperations = operations.size();

//pretreatment opreations before aggregating
List<String[]> funinOperations = new java.util.ArrayList<String[]>();
next:
for(int i=0; i<sizeOperations; i++){
	Map<String, String> operation = operations.get(i);
	String fun = operation.get("FUNCTION");
	String in = operation.get("INPUT_COLUMN");
	if(fun.equals("sum") || fun.equals("count")){
		for(int j=0; j<sizeOperations; j++){
			Map<String, String> tOperation = operations.get(j);
			if(tOperation.get("FUNCTION").equals("avg") && tOperation.get("INPUT_COLUMN").equals(in)){
				continue next;
			}
		}
	}
	for(int j = 0; j < i; j++){
		Map<String, String> tOperation = operations.get(j);
		if(tOperation.get("FUNCTION").equals(fun) && tOperation.get("INPUT_COLUMN").equals(in)){
			continue next;
		}
	}
	if(fun.equals("avg")){
		String[] funin = new String[2];
		funin[0]="sum";
		funin[1]=in;
		funinOperations.add(funin);
		funin=new String[2];
		funin[0]="count";
		funin[1]=in;
		funinOperations.add(funin);
	}else{
		String[] funin = new String[2];
		funin[0]=fun;
		funin[1]=in;
		funinOperations.add(funin);
	}
}
int sizeOps = funinOperations.size();
if(sizeOps>0){
//
//end
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    //begin
//
	for (int i = 0; i<sizeOps; i++) {
		String[] funin = funinOperations.get(i);
		if(funin[0].equals("sum")){
//
//end
    stringBuffer.append(TEXT_4);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_5);
    //start
//
   		}else if(funin[0].equals("count")){
//
//end
    stringBuffer.append(TEXT_6);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_7);
    //start
//
   		}else{
			List<? extends IConnection> incomingConnections = node.getIncomingConnections();
        	if (incomingConnections != null && !incomingConnections.isEmpty()) {
        		for (IConnection conn : incomingConnections) {
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        				IMetadataTable inMetadata = conn.getMetadataTable();
       					for (IMetadataColumn column: inMetadata.getListColumns()) {
            				if(column.getLabel().equals(funin[1])){
//
//end
    stringBuffer.append(TEXT_8);
    stringBuffer.append("list".equals(funin[0])?"String":JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable()) );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(funin[0] );
    stringBuffer.append(TEXT_11);
    //start
//
								break;
            				}
						}
					}
				}
  			}
		}
	}
 //
 //end
    stringBuffer.append(TEXT_12);
    //start
//
}
int groupbySize = groupbys.size();
//modify06-04 begin
String[] groupby_type = new String[groupbySize];
for(int i = 0; i < groupbySize; i++){
	String columnname = groupbys.get(i).get("INPUT_COLUMN");
	List<? extends IConnection> incomingConnections = node.getIncomingConnections();
    if (incomingConnections != null && !incomingConnections.isEmpty()) {
    	for (IConnection conn : incomingConnections) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        		IMetadataTable inMetadata = conn.getMetadataTable();
       			for (IMetadataColumn column: inMetadata.getListColumns()) {
            		if(column.getLabel().equals(columnname)){
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if(javaType == JavaTypesManager.BOOLEAN){
							groupby_type[i] = "Boolean";
						}else if(javaType == JavaTypesManager.BYTE){
							groupby_type[i] = "Byte";
						}else if(javaType == JavaTypesManager.BYTE_ARRAY){
							groupby_type[i] = "byte[]";
						}else if(javaType == JavaTypesManager.CHARACTER){
							groupby_type[i] = "Character";
						}else if(javaType == JavaTypesManager.DATE){
							groupby_type[i] = "java.util.Date";
						}else if(javaType == JavaTypesManager.DOUBLE){
							groupby_type[i] = "Double";
						}else if(javaType == JavaTypesManager.FLOAT){
							groupby_type[i] = "Float";
						}else if(javaType == JavaTypesManager.INTEGER){
							groupby_type[i] = "Integer";
						}else if(javaType == JavaTypesManager.LONG){
							groupby_type[i] = "Long";
						}else if(javaType == JavaTypesManager.SHORT){
							groupby_type[i] = "Short";
						}else if(javaType == JavaTypesManager.STRING){
							groupby_type[i] = "String";
						}else if(javaType == JavaTypesManager.OBJECT){
							groupby_type[i] = "Object";
						}
						break;
            		}
				}
			}
		}
  	}
}
//modify06-04 end

for(int ii = 0; ii < groupbySize; ii++){
	String input = groupbys.get(ii).get("INPUT_COLUMN");
	for(int i = ii; i < groupbySize; i++){
		if(i == groupbySize - 1){
			if(sizeOps == 0){
//
//end

    stringBuffer.append(TEXT_13);
    stringBuffer.append(groupby_type[i] );
    stringBuffer.append(TEXT_14);
    
//start
//
			}else{
//
//end

    stringBuffer.append(TEXT_15);
    stringBuffer.append(groupby_type[i] );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    
//start
//
			}
		}else{
//
//end

    stringBuffer.append(TEXT_17);
    stringBuffer.append(groupby_type[i] );
    stringBuffer.append(TEXT_18);
    
//start
//
		}
	}
	for(int i = ii; i < groupbySize; i++){
//
//end

    stringBuffer.append(TEXT_19);
    
//start
//
	}
//
//end

    stringBuffer.append(TEXT_20);
    stringBuffer.append(input );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
	if(ii != 0){

    stringBuffer.append(TEXT_23);
    	}else{

    stringBuffer.append(TEXT_24);
    
//start
//
		for(int i = 0; i < groupbySize; i++){
			if(i == groupbySize - 1){
				if(sizeOps == 0){
//
//end

    stringBuffer.append(TEXT_25);
    
					if(i == 0){

    stringBuffer.append(TEXT_26);
    
					}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(groupby_type[i] );
    
//start
//
				}else{
//
//end

    stringBuffer.append(TEXT_28);
    
					if(i == 0){

    stringBuffer.append(TEXT_29);
    
					}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(groupby_type[i] );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    
//start
//
				}
			}else{
//
//end

    stringBuffer.append(TEXT_32);
    
				if(i == 0){

    stringBuffer.append(TEXT_33);
    
				}

    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupby_type[i] );
    stringBuffer.append(TEXT_35);
    
//start
//
			}
		}
		for(int i = 0; i < groupbySize; i++){
//
//end

    stringBuffer.append(TEXT_36);
    
//start
//
		}
//
//end

    stringBuffer.append(TEXT_37);
    
	}
}
if(sizeOps>0){
//
//end
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    //start
//
}
//
//end
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}
