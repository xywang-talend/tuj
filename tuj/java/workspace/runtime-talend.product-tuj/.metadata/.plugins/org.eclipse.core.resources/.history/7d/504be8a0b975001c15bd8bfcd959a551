package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TAggregateOutEndJava
{
  protected static String nl;
  public static synchronized TAggregateOutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateOutEndJava result = new TAggregateOutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "java.util.List<ThenRunStruct";
  protected final String TEXT_4 = "> result_list_";
  protected final String TEXT_5 = " = new java.util.ArrayList<ThenRunStruct";
  protected final String TEXT_6 = ">();" + NL + "//generate result begin";
  protected final String TEXT_7 = NL + "java.util.Iterator<";
  protected final String TEXT_8 = "> ";
  protected final String TEXT_9 = "_iterator_";
  protected final String TEXT_10 = " = hash_";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = "keySet().";
  protected final String TEXT_14 = "iterator();" + NL + "while(";
  protected final String TEXT_15 = "_iterator_";
  protected final String TEXT_16 = ".hasNext()){" + NL + "\t";
  protected final String TEXT_17 = " ";
  protected final String TEXT_18 = "_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "_iterator_";
  protected final String TEXT_21 = ".next();";
  protected final String TEXT_22 = NL + "operation_result_";
  protected final String TEXT_23 = " = hash_";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = ".get(";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "hash_";
  protected final String TEXT_29 = "_";
  protected final String TEXT_30 = " = hash_";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = ".get(";
  protected final String TEXT_33 = "_";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + NL + NL + NL + "//in the deepest begin" + NL + "ThenRunStruct";
  protected final String TEXT_36 = " aggregated_row_";
  protected final String TEXT_37 = " = new ThenRunStruct";
  protected final String TEXT_38 = "();";
  protected final String TEXT_39 = "aggregated_row_";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = " = ";
  protected final String TEXT_42 = "_";
  protected final String TEXT_43 = ";";
  protected final String TEXT_44 = "String s_";
  protected final String TEXT_45 = "_";
  protected final String TEXT_46 = "_";
  protected final String TEXT_47 = " = String.valueOf(";
  protected final String TEXT_48 = "_";
  protected final String TEXT_49 = ");" + NL + "aggregated_row_";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = "s_";
  protected final String TEXT_53 = "_";
  protected final String TEXT_54 = "_";
  protected final String TEXT_55 = "s_";
  protected final String TEXT_56 = "_";
  protected final String TEXT_57 = "_";
  protected final String TEXT_58 = ".getBytes()";
  protected final String TEXT_59 = "s_";
  protected final String TEXT_60 = "_";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = ".equals(\"null\") ? null : ParserUtils.parseTo_Date(s_";
  protected final String TEXT_63 = "_";
  protected final String TEXT_64 = "_";
  protected final String TEXT_65 = ", ";
  protected final String TEXT_66 = ")";
  protected final String TEXT_67 = "ParserUtils.parseTo_";
  protected final String TEXT_68 = "(s_";
  protected final String TEXT_69 = "_";
  protected final String TEXT_70 = "_";
  protected final String TEXT_71 = ")";
  protected final String TEXT_72 = ";";
  protected final String TEXT_73 = NL + "float ";
  protected final String TEXT_74 = "_avg_temp = 0;" + NL + "if(operation_result_";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = "_count > 0){" + NL + "\t";
  protected final String TEXT_77 = "_avg_temp = operation_result_";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = "_sum / operation_result_";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = "_count ;" + NL + "}";
  protected final String TEXT_82 = "aggregated_row_";
  protected final String TEXT_83 = ".";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "_avg_temp;";
  protected final String TEXT_86 = "String temps";
  protected final String TEXT_87 = " = String.valueOf(";
  protected final String TEXT_88 = "(";
  protected final String TEXT_89 = ")";
  protected final String TEXT_90 = "_avg_temp);";
  protected final String TEXT_91 = NL + "aggregated_row_";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = " = operation_result_";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = "_";
  protected final String TEXT_96 = ";";
  protected final String TEXT_97 = NL + "String temps";
  protected final String TEXT_98 = " = String.valueOf(";
  protected final String TEXT_99 = "(";
  protected final String TEXT_100 = ")";
  protected final String TEXT_101 = "operation_result_";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = "_";
  protected final String TEXT_104 = ");//??";
  protected final String TEXT_105 = NL + "if(temps";
  protected final String TEXT_106 = ".length() > 0) {";
  protected final String TEXT_107 = NL + "aggregated_row_";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = " = temps";
  protected final String TEXT_110 = ";";
  protected final String TEXT_111 = NL + "aggregated_row_";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = temps";
  protected final String TEXT_114 = ".getBytes();";
  protected final String TEXT_115 = NL + "aggregated_row_";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " = ParserUtils.parseTo_Date(temps";
  protected final String TEXT_118 = ", ";
  protected final String TEXT_119 = ");";
  protected final String TEXT_120 = NL + "aggregated_row_";
  protected final String TEXT_121 = ".";
  protected final String TEXT_122 = " = ParserUtils.parseTo_";
  protected final String TEXT_123 = "(temps";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = "\t\t\t\t\t" + NL + "} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = "throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_127 = "', value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_128 = NL + "aggregated_row_";
  protected final String TEXT_129 = ".";
  protected final String TEXT_130 = " = ";
  protected final String TEXT_131 = ";";
  protected final String TEXT_132 = NL + "}";
  protected final String TEXT_133 = NL + "aggregated_row_";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = " = \"\";/*empty string for String value*/";
  protected final String TEXT_136 = NL + "//in the deepest end" + NL + "result_list_";
  protected final String TEXT_137 = ".add(aggregated_row_";
  protected final String TEXT_138 = ");" + NL + "nb_line_";
  protected final String TEXT_139 = "++;";
  protected final String TEXT_140 = NL + "}";
  protected final String TEXT_141 = NL + "//generate result end" + NL + "globalMap.put(\"";
  protected final String TEXT_142 = "\",result_list_";
  protected final String TEXT_143 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_144 = "_NB_LINE\",nb_line_";
  protected final String TEXT_145 = ");";

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
    if (metadata!=null) {
        List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
        List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
		int sizeOperations = operations.size();
		int sizeGroupbys = groupbys.size();
		
//modify06-05 begin
String[] groupby_type = new String[sizeGroupbys];
for(int i = 0; i < sizeGroupbys; i++){
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
//modify06-05 end
		
		String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
//
//end
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_6);
    //start
//
		List<IMetadataColumn> listColumns = metadata.getListColumns();
		int sizeColumns = listColumns.size();
		if(sizeOperations > 0||sizeGroupbys > 0){
			for(int i = 0; i < sizeGroupbys; i++){
				Map<String, String> groupby = groupbys.get(i);
				String inputColumn = groupby.get("INPUT_COLUMN");
				String outputColumn = groupby.get("OUTPUT_COLUMN");
				String nextInputColumn = null;
				if(i != sizeGroupbys - 1){
					nextInputColumn = groupbys.get(i+1).get("INPUT_COLUMN");
				}
				//gen loops begin begin

    stringBuffer.append(TEXT_7);
    stringBuffer.append(groupby_type[i] );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if((i != sizeGroupbys - 1) || sizeOperations >0 ){
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(groupby_type[i] );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
				if(i == sizeGroupbys - 1){
					if(sizeOperations > 0){

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(inputColumn);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_27);
    
					}
				}else{

    stringBuffer.append(TEXT_28);
    stringBuffer.append(nextInputColumn );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_34);
    
				}
			//gen loops begin end
			}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_38);
    
			next_column:
			for(int c = 0; c < sizeColumns; c++){
				IMetadataColumn column = listColumns.get(c);
				String columnName = column.getLabel();
				String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				for(int g = 0; g < sizeGroupbys; g++){
					Map<String, String> groupby = groupbys.get(g);
					String inputColumn = groupby.get("INPUT_COLUMN");
					String outputColumn = groupby.get("OUTPUT_COLUMN");
					if(outputColumn.equals(columnName)){
						Boolean sameType = false;
            			
						List<? extends IConnection> incomingConnections = node.getIncomingConnections();
        				if (incomingConnections != null && !incomingConnections.isEmpty()) {
        					loop:
        					for (IConnection conn : incomingConnections) {
								if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            						IMetadataTable inMetadata = conn.getMetadataTable();
            						for (IMetadataColumn inColumn: inMetadata.getListColumns()) {
            							if(inColumn.getLabel().equals(inputColumn)){
            								sameType = (JavaTypesManager.getJavaTypeFromId(inColumn.getTalendType()) == javaType);
            								break loop;
            							}
            						}
            					}
            				}
        				}
        				if(sameType){
        				

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_43);
      					}else{

    stringBuffer.append(TEXT_44);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_51);
    
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								
    stringBuffer.append(TEXT_52);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    
							}else if(javaType == JavaTypesManager.BYTE_ARRAY){
								
    stringBuffer.append(TEXT_55);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
							} else if(javaType == JavaTypesManager.DATE) {
								
    stringBuffer.append(TEXT_59);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_66);
    
							} else {
								
    stringBuffer.append(TEXT_67);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(outputColumn );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
							}
						
    stringBuffer.append(TEXT_72);
    
						}
						continue next_column;
					}
				}
				
				for(int o = 0; o < sizeOperations; o++){
					Map<String, String> operation = operations.get(o);
            		String function = operation.get("FUNCTION");
            		String outOperation = operation.get("OUTPUT_COLUMN");
            		String inOperation = operation.get("INPUT_COLUMN");
            		if(outOperation.equals(columnName)){
            			Boolean sameType = false;
            			
						List<? extends IConnection> incomingConnections = node.getIncomingConnections();
        				if (incomingConnections != null && !incomingConnections.isEmpty()) {
        					loop:
        					for (IConnection conn : incomingConnections) {
								if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            						IMetadataTable inMetadata = conn.getMetadataTable();
            						for (IMetadataColumn inColumn: inMetadata.getListColumns()) {
            							if(inColumn.getLabel().equals(inOperation)){
            								if(function.equals("first")||function.equals("last")||function.equals("min")||function.equals("max")){
            									sameType = (JavaTypesManager.getJavaTypeFromId(inColumn.getTalendType()) == javaType);
            								}else if(function.equals("avg")||function.equals("sum")){
            									sameType = (typeToGenerate.equals("float")||typeToGenerate.equals("double"));
            								}else{
            									sameType = (typeToGenerate.equals("int")||typeToGenerate.equals("long"));
            								}
            								break loop;
            							}
            						}
            					}
            				}
        				}
            			if(function.equals("avg")){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(inOperation );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(inOperation );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(inOperation );
    stringBuffer.append(TEXT_81);
    if(sameType){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_85);
    }else{
    stringBuffer.append(TEXT_86);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_87);
    if(javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.CHARACTER){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_90);
    }
    
            			}else{
							if(sameType){

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(inOperation );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_96);
    
							}else{

    stringBuffer.append(TEXT_97);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_98);
    if(function.equals("sum")&&(javaType == JavaTypesManager.INTEGER || javaType == JavaTypesManager.LONG || javaType == JavaTypesManager.BYTE || javaType == JavaTypesManager.SHORT || javaType == JavaTypesManager.CHARACTER)){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(inOperation );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(function );
    stringBuffer.append(TEXT_104);
    
							}

    
            			}
            			if(!sameType){

    stringBuffer.append(TEXT_105);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_106);
    
								/** begin **/
						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								/** end **/

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_110);
    
								/** begin **/
							} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_114);
    
							} else if(javaType == JavaTypesManager.DATE) {
								/** end **/
								
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_119);
    
								/** begin **/
							}else{
								
								/** end **/
								
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_124);
    
								/** begin **/
							}
								/** end **/
						
    stringBuffer.append(TEXT_125);
    
							/** begin **/
							String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
							if(defaultValue == null) {
							/** end **/
								
    stringBuffer.append(TEXT_126);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_127);
    
							/** begin **/
							} else {
							/** end **/
								
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(outOperation );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_131);
    
							/** begin **/
							}
							/** end **/
						
						
    stringBuffer.append(TEXT_132);
    						}
            			continue next_column;
            		}
            	}

    				if(javaType == JavaTypesManager.STRING){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(columnName );
    stringBuffer.append(TEXT_135);
    
}
    
			}

    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
//in the innest end


///gen loop end begin
			for(int i = 0; i < sizeGroupbys; i++){

    stringBuffer.append(TEXT_140);
    
			}
///gen loop end end




		}//i f(sizeOperations > 0||sizeGroupbys > 0) end

    stringBuffer.append(TEXT_141);
    stringBuffer.append(destination );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    //start
//
	}
}
//
//end all
    return stringBuffer.toString();
  }
}
