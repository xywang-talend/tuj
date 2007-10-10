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

public class TAggregateSortedRowBeginJava
{
  protected static String nl;
  public static synchronized TAggregateSortedRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateSortedRowBeginJava result = new TAggregateSortedRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "int nb_line_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = "boolean  flag_";
  protected final String TEXT_5 = " = true;" + NL + "boolean  flag2_";
  protected final String TEXT_6 = " = true;";
  protected final String TEXT_7 = " group_";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = "=null";
  protected final String TEXT_10 = "=false";
  protected final String TEXT_11 = "=(";
  protected final String TEXT_12 = ")0";
  protected final String TEXT_13 = ";";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = "_";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = "=null";
  protected final String TEXT_18 = "=false";
  protected final String TEXT_19 = "=(";
  protected final String TEXT_20 = ")0";
  protected final String TEXT_21 = ";";
  protected final String TEXT_22 = "int count_";
  protected final String TEXT_23 = "_";
  protected final String TEXT_24 = "=0;";
  protected final String TEXT_25 = "float sum_";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = "=0;";
  protected final String TEXT_28 = "float sum_";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = "=0;" + NL + "int count_";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = "=0;";
  protected final String TEXT_33 = "StringBuilder list_";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = "=null;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {

    IMetadataTable metadata = metadatas.get(0);
    List< ? extends IConnection> conns = node.getIncomingConnections();
    IMetadataTable inMetadata = null;
    if(conns != null){ 
    for (IConnection conn : conns) { 
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
			inMetadata = conn.getMetadataTable();
    		break;
		}
	}
    if (metadata != null && inMetadata != null) { 
    	List<IMetadataColumn> inColumns = inMetadata.getListColumns();
		List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
		IMetadataColumn[] column_op = new IMetadataColumn[operations.size()];
		String[] functions = new String[operations.size()];
		List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
		IMetadataColumn[] column_gr = new IMetadataColumn[groupbys.size()];
		for(int i = 0; i < column_op.length; i++){
			Map<String, String> operation = operations.get(i);
			String in = operation.get("INPUT_COLUMN");
			functions[i] = operation.get("FUNCTION");
			for (IMetadataColumn column: inColumns) {
				if(column.getLabel().equals(in)){
					column_op[i] = column;
					break;
				}
			}
		}
		for(int i = 0; i < column_gr.length; i++){
			Map<String, String> groupby = groupbys.get(i);
			String in = groupby.get("INPUT_COLUMN");
			for (IMetadataColumn column: inColumns) {
				if(column.getLabel().equals(in)){
					column_gr[i] = column;
					break;
				}
			}
		}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    	if(column_gr.length > 0){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    	}
	//gen groups variable
	for(int i = 0; i < column_gr.length; i++){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column_gr[i].getTalendType());

    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column_gr[i].getTalendType(), column_gr[i].isNullable()) );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column_gr[i].getLabel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    
if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT 
|| javaType == JavaTypesManager.DATE || javaType == JavaTypesManager.BYTE_ARRAY){
    stringBuffer.append(TEXT_9);
    }else if(javaType == JavaTypesManager.BOOLEAN){
    stringBuffer.append(TEXT_10);
    }else{
    stringBuffer.append(TEXT_11);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column_gr[i].getTalendType(), column_gr[i].isNullable()) );
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    	}
	//gen aggre variable
	for(int i = 0; i < column_op.length; i++){
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column_op[i].getTalendType());
		boolean duplicate = false;
		for(int j = 0; j < i; j++){
			if(functions[j].equals(functions[i]) && column_op[j].getLabel().equals(column_op[i].getLabel())){
				duplicate = true;
				break;
			}
		}
		if(duplicate){
			continue;
		}
		if(functions[i].equals("min") || functions[i].equals("max") || functions[i].equals("first") || functions[i].equals("last")){

    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(functions[i] );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    
if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT 
|| javaType == JavaTypesManager.DATE || javaType == JavaTypesManager.BYTE_ARRAY){
    stringBuffer.append(TEXT_17);
    }else if(javaType == JavaTypesManager.BOOLEAN){
    stringBuffer.append(TEXT_18);
    }else{
    stringBuffer.append(TEXT_19);
    stringBuffer.append( JavaTypesManager.getTypeToGenerate(column_op[i].getTalendType(), column_op[i].isNullable()) );
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    		}else if(functions[i].equals("count")){
			boolean countHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(functions[j].equals("avg") && column_op[j].getLabel().equals(column_op[i].getLabel())){
					countHasAvg = true;
					break;
				}
			}
			if(!countHasAvg){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    			}
		}else if(functions[i].equals("sum")){
			boolean sumHasAvg = false;
			for(int j = 0; j < functions.length; j++){
				if(functions[j].equals("avg") && column_op[j].getLabel().equals(column_op[i].getLabel())){
					sumHasAvg = true;
					break;
				}
			}
			if(!sumHasAvg){

    stringBuffer.append(TEXT_25);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    			}
		}else if(functions[i].equals("avg")){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    		}else{

    stringBuffer.append(TEXT_33);
    stringBuffer.append(column_op[i].getLabel() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    		}
	}
	
    
	}
	}
}

    return stringBuffer.toString();
  }
}
