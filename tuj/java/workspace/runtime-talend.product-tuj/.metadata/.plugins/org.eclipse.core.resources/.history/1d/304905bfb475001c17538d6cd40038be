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
import java.util.List;
import java.util.Map;

public class TAggregateOutMainJava
{
  protected static String nl;
  public static synchronized TAggregateOutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateOutMainJava result = new TAggregateOutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "//String key_";
  protected final String TEXT_3 = " = null;";
  protected final String TEXT_4 = NL + "//key_";
  protected final String TEXT_5 = " = String.valueOf(";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");" + NL + "if(hash_";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = ".containsKey(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ")){" + NL + "\thash_";
  protected final String TEXT_12 = "_";
  protected final String TEXT_13 = " = hash_";
  protected final String TEXT_14 = "_";
  protected final String TEXT_15 = ".get(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ");                    " + NL + "}else{" + NL + "\thash_";
  protected final String TEXT_18 = "_";
  protected final String TEXT_19 = " = new ";
  protected final String TEXT_20 = "java.util.";
  protected final String TEXT_21 = "Hash";
  protected final String TEXT_22 = "Set<";
  protected final String TEXT_23 = " ";
  protected final String TEXT_24 = "java.util.";
  protected final String TEXT_25 = "Hash";
  protected final String TEXT_26 = "Map<";
  protected final String TEXT_27 = ", OperationStruct";
  protected final String TEXT_28 = "java.util.";
  protected final String TEXT_29 = "Hash";
  protected final String TEXT_30 = "Map<";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = ">";
  protected final String TEXT_33 = "();" + NL + "\thash_";
  protected final String TEXT_34 = "_";
  protected final String TEXT_35 = ".put(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = ",hash_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = ");" + NL + "}";
  protected final String TEXT_40 = NL + "//key_";
  protected final String TEXT_41 = " = String.valueOf(";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");" + NL + "if(hash_";
  protected final String TEXT_44 = "_";
  protected final String TEXT_45 = ".containsKey(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ")){" + NL + "\toperation_result_";
  protected final String TEXT_48 = " = hash_";
  protected final String TEXT_49 = "_";
  protected final String TEXT_50 = ".get(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ");                    " + NL + "}else{" + NL + "\toperation_result_";
  protected final String TEXT_53 = " = new OperationStruct";
  protected final String TEXT_54 = "();";
  protected final String TEXT_55 = NL + "//key_";
  protected final String TEXT_56 = " = String.valueOf(";
  protected final String TEXT_57 = ".";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "if(operation_result_";
  protected final String TEXT_60 = " == null){" + NL + "\toperation_result_";
  protected final String TEXT_61 = " = new OperationStruct";
  protected final String TEXT_62 = "();";
  protected final String TEXT_63 = NL;
  protected final String TEXT_64 = NL + "operation_result_";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = "_";
  protected final String TEXT_67 = " = ";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ";";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\thash_";
  protected final String TEXT_72 = "_";
  protected final String TEXT_73 = ".put(";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = ", operation_result_";
  protected final String TEXT_76 = ");" + NL + "}";
  protected final String TEXT_77 = NL + "\thash_";
  protected final String TEXT_78 = "_";
  protected final String TEXT_79 = ".add(";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ");\t\t";
  protected final String TEXT_82 = NL + "}";
  protected final String TEXT_83 = NL;
  protected final String TEXT_84 = NL + "if(operation_result_";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = ".compareTo(";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = ") ";
  protected final String TEXT_90 = ">";
  protected final String TEXT_91 = "<";
  protected final String TEXT_92 = " 0){" + NL + "\toperation_result_";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ";" + NL + "}";
  protected final String TEXT_98 = NL + "if(";
  protected final String TEXT_99 = "!";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = "){" + NL + "\tif(";
  protected final String TEXT_102 = "!";
  protected final String TEXT_103 = "operation_result_";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = "_";
  protected final String TEXT_106 = "){" + NL + "\t\toperation_result_";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = "_";
  protected final String TEXT_109 = " = ";
  protected final String TEXT_110 = "false";
  protected final String TEXT_111 = "true";
  protected final String TEXT_112 = ";" + NL + "\t}" + NL + "}";
  protected final String TEXT_113 = NL + NL + "if(operation_result_";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = "_";
  protected final String TEXT_116 = " - ";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " ";
  protected final String TEXT_119 = ">";
  protected final String TEXT_120 = "<";
  protected final String TEXT_121 = " 0){" + NL + "\toperation_result_";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = ";" + NL + "}";
  protected final String TEXT_127 = NL + "operation_result_";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = "_sum += ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = ";";
  protected final String TEXT_132 = NL + "operation_result_";
  protected final String TEXT_133 = ".";
  protected final String TEXT_134 = "_count ++;";
  protected final String TEXT_135 = NL + "operation_result_";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = "_last = ";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = ";";
  protected final String TEXT_140 = NL + "operation_result_";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = "_list = " + NL + "operation_result_";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = "_list == null? " + NL + "String.valueOf(";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = ") " + NL + ": " + NL + "operation_result_";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = "_list + \",\" + ";
  protected final String TEXT_149 = ".";
  protected final String TEXT_150 = ";";
  protected final String TEXT_151 = "\t" + NL;
  protected final String TEXT_152 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List< ? extends IConnection> conns = node.getIncomingConnections();
for (IConnection conn : conns) {
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		List<Map<String, String>> operations = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__OPERATIONS__");
        List<Map<String, String>> groupbys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");
        IMetadataTable inMetadata = conn.getMetadataTable();
		List<IMetadataColumn> columns = inMetadata.getListColumns();
		int sizeOperations = operations.size();
		int sizeGroupbys = groupbys.size();
		String lastInputColumn = null;
		if(sizeGroupbys>0){
			lastInputColumn = groupbys.get(sizeGroupbys-1).get("INPUT_COLUMN");
		}
		
		
		//pretreatment opreations before aggregating
		
		//modify06-05 begin
String[] groupby_type = new String[sizeGroupbys];
for(int i = 0; i < sizeGroupbys; i++){
	String columnname = groupbys.get(i).get("INPUT_COLUMN");
	List<? extends IConnection> incomingConnections = node.getIncomingConnections();
    if (incomingConnections != null && !incomingConnections.isEmpty()) {
    	for (IConnection conne : incomingConnections) {
			if (conne.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        		IMetadataTable inMetadatat = conne.getMetadataTable();
       			for (IMetadataColumn column: inMetadatat.getListColumns()) {
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
		String tInputColumn =null;
		
		for (int i=0; i<sizeGroupbys; i++) {
           	Map<String, String> groupby = groupbys.get(i);
			String inputColumn = groupby.get("INPUT_COLUMN");
			String nextInputColumn = null;
			if(i==0){
//
//end
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    //start
//
			}
			if(i != sizeGroupbys - 1){
				nextInputColumn = groupbys.get(i+1).get("INPUT_COLUMN");
			}
			if(i < sizeGroupbys-1){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(nextInputColumn  );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(nextInputColumn  );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
//start
//
					for(int j = i+1; j < sizeGroupbys; j++){
						if(j == sizeGroupbys - 1){
							if(sizeOps == 0){
//
//end

    stringBuffer.append(TEXT_20);
    if(j == i+1){
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(groupby_type[j] );
    stringBuffer.append(TEXT_23);
    
//start
//
							}else{
//
//end

    stringBuffer.append(TEXT_24);
    if(j == i+1){
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    stringBuffer.append(groupby_type[j] );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    
//start
//
							}
						}else{
//
//end

    stringBuffer.append(TEXT_28);
    if(j == i+1){
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    stringBuffer.append(groupby_type[j] );
    stringBuffer.append(TEXT_31);
    
//start
//
						}
					}
					for(int j = i+1; j < sizeGroupbys; j++){
//
//end

    stringBuffer.append(TEXT_32);
    
//start
//
					}
//
//end

    stringBuffer.append(TEXT_33);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(nextInputColumn );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    //start
//
				}else{
					tInputColumn = inputColumn;
					if(sizeOps > 0 ){
//
//end
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    //start
//
					}else{
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(inputColumn );
    stringBuffer.append(TEXT_58);
    
					}
				}
			}
			if(sizeOps>0 && sizeGroupbys == 0){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    
			}

    stringBuffer.append(TEXT_63);
    //start
//
		for(int j = 0; j < sizeOps; j++){
			String[] funin = funinOperations.get(j);
			if(funin[0].equals("first")||funin[0].equals("min")||funin[0].equals("max")){
//
//end
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(funin[0] );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(funin[1]  );
    stringBuffer.append(TEXT_69);
    //start
//
			}
		}
//
//end
    stringBuffer.append(TEXT_70);
    
		if(sizeGroupbys > 0){
			if(sizeOps>0){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(tInputColumn );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(lastInputColumn );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
			}else{

    stringBuffer.append(TEXT_77);
    stringBuffer.append(tInputColumn );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(lastInputColumn );
    stringBuffer.append(TEXT_81);
    
			}
		}else if(sizeOps > 0){
    stringBuffer.append(TEXT_82);
    
		}

    stringBuffer.append(TEXT_83);
    //start
//
		JavaType javaType = null;
        for(int j = 0; j < sizeOps; j++){
			String[] funin = funinOperations.get(j);
            for (IMetadataColumn column: columns) {
            	if(column.toString().equals(funin[1])){
            		javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
            			break;
            	}
            }
			if(funin[0].equals("min")||funin[0].equals("max")){
				if(javaType == JavaTypesManager.BYTE_ARRAY || javaType == JavaTypesManager.OBJECT){
					//do nothing here
				}else if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.DATE){
//
//end
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(funin[0] );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_89);
    if(funin[0].equals("min")){
    stringBuffer.append(TEXT_90);
    }else{
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(funin[0] );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_97);
    //start
//
				}else if(javaType == JavaTypesManager.BOOLEAN){
//
//end
    stringBuffer.append(TEXT_98);
    if(funin[0].equals("min")){
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_101);
    if(funin[0].equals("max")){
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(funin[0] );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(funin[0] );
    stringBuffer.append(TEXT_109);
    if(funin[0].equals("min")){
    stringBuffer.append(TEXT_110);
    }else{
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    //start
//
				}else{
					//for numbers(byte, char, short, int, long, float, double)
//
//end
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(funin[0] );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_118);
    if(funin[0].equals("min")){
    stringBuffer.append(TEXT_119);
    }else{
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(funin[0] );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_126);
    //start
//
				}
			}
			if(funin[0].equals("sum")){
				if(javaType == JavaTypesManager.BYTE_ARRAY || javaType == JavaTypesManager.OBJECT 
					|| javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.BOOLEAN
					|| javaType == JavaTypesManager.DATE){
					//do nothing here
				}else{
//
//end
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_131);
    //start
//
				}
			}
			if(funin[0].equals("count")){
//
//end
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_134);
    //start
//
			}
			if(funin[0].equals("last")){
//
//end
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_139);
    //start
//
			}
			if(funin[0].equals("list")){
//
//end
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(funin[1] );
    stringBuffer.append(TEXT_150);
    //start
//
			}
		}
//
//end
    stringBuffer.append(TEXT_151);
    
	}
}
//
//end
    stringBuffer.append(TEXT_152);
    return stringBuffer.toString();
  }
}
