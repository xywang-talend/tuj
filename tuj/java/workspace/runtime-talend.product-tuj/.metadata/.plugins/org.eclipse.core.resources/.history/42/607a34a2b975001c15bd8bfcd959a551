package org.talend.designer.codegen.translators.processing;

import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TDenormalizeInBeginJava
{
  protected static String nl;
  public static synchronized TDenormalizeInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDenormalizeInBeginJava result = new TDenormalizeInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "////////////////////////" + NL + "\t\tint nb_line_";
  protected final String TEXT_4 = " = 0;";
  protected final String TEXT_5 = NL + "  " + NL + "\tboolean hasInvalidType = true;" + NL + "\tif(hasInvalidType)" + NL + "\t{" + NL + "\t \tthrow new Exception(\"The Denormalize fields should be of String type.\");" + NL + "\t}\t" + NL + "\t" + NL + "\t{";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "    class Util_";
  protected final String TEXT_8 = NL + "    {" + NL + "        public String merge(String input) {" + NL + "            if (input == null) {" + NL + "                return null;" + NL + "            }" + NL + "            String[] strings = input.split(";
  protected final String TEXT_9 = ");" + NL + "            StringBuffer sb = new StringBuffer();" + NL + "            java.util.Set<String> set = new java.util.HashSet<String>(java.util.Arrays.asList(strings));" + NL + "            int i = 0;" + NL + "            for (String object : set) {" + NL + "                i++;" + NL + "                sb.append(object);" + NL + "                if (i == set.size()) break;" + NL + "                sb.append(";
  protected final String TEXT_10 = ");" + NL + "            }" + NL + "            return sb.toString();" + NL + "        }" + NL + "    } " + NL + "        " + NL + "\tUtil_";
  protected final String TEXT_11 = " util_";
  protected final String TEXT_12 = " = new Util_";
  protected final String TEXT_13 = "();\t";
  protected final String TEXT_14 = NL + "\t" + NL + "\t" + NL + "\tjava.util.List<";
  protected final String TEXT_15 = "Struct> row_aref_";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = " = (java.util.List<";
  protected final String TEXT_18 = "Struct>) globalMap.get(\"";
  protected final String TEXT_19 = "\");\t" + NL + NL;
  protected final String TEXT_20 = NL + "    " + NL + "" + NL + "    java.util.Map<Object,";
  protected final String TEXT_21 = "Struct> map_";
  protected final String TEXT_22 = " = new java.util.HashMap<Object,";
  protected final String TEXT_23 = "Struct>();" + NL + "" + NL + "    for (java.util.Iterator<";
  protected final String TEXT_24 = "Struct> iter_";
  protected final String TEXT_25 = " = row_aref_";
  protected final String TEXT_26 = "_";
  protected final String TEXT_27 = ".iterator(); iter_";
  protected final String TEXT_28 = ".hasNext();) {" + NL;
  protected final String TEXT_29 = NL + "        ";
  protected final String TEXT_30 = "Struct row_";
  protected final String TEXT_31 = " = iter_";
  protected final String TEXT_32 = ".next();" + NL + "        String key_";
  protected final String TEXT_33 = " = \"\" +";
  protected final String TEXT_34 = "     " + NL + "        row_";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " ";
  protected final String TEXT_37 = " ;";
  protected final String TEXT_38 = NL + "        ";
  protected final String TEXT_39 = "Struct element_";
  protected final String TEXT_40 = " = (";
  protected final String TEXT_41 = "Struct) map_";
  protected final String TEXT_42 = ".get(key_";
  protected final String TEXT_43 = ");" + NL + "        if (element_";
  protected final String TEXT_44 = " == null) {" + NL + "            map_";
  protected final String TEXT_45 = ".put(key_";
  protected final String TEXT_46 = ", row_";
  protected final String TEXT_47 = ");" + NL + "        } else {" + NL + "        " + NL + "////";
  protected final String TEXT_48 = " " + NL + "      element_";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " = element_";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = " + ";
  protected final String TEXT_53 = " + row_";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ";";
  protected final String TEXT_56 = NL + "////        " + NL + "        }" + NL + "    }     " + NL + "    " + NL + "    java.util.Set set_";
  protected final String TEXT_57 = " = map_";
  protected final String TEXT_58 = ".keySet();" + NL + "" + NL + "    for (java.util.Iterator iter_";
  protected final String TEXT_59 = " = set_";
  protected final String TEXT_60 = ".iterator(); iter_";
  protected final String TEXT_61 = ".hasNext();) {" + NL + "        String key_";
  protected final String TEXT_62 = " = (String) iter_";
  protected final String TEXT_63 = ".next();";
  protected final String TEXT_64 = NL + "        ";
  protected final String TEXT_65 = "Struct element_";
  protected final String TEXT_66 = " = (";
  protected final String TEXT_67 = "Struct) map_";
  protected final String TEXT_68 = ".get(key_";
  protected final String TEXT_69 = ");" + NL + "        " + NL + "////";
  protected final String TEXT_70 = " ";
  protected final String TEXT_71 = NL + "     ";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = " = util_";
  protected final String TEXT_74 = ".merge(element_";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = "); ";
  protected final String TEXT_77 = NL + "\t";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " = element_";
  protected final String TEXT_80 = ".";
  protected final String TEXT_81 = ";";
  protected final String TEXT_82 = NL + "////   " + NL + "" + NL + "        ";
  protected final String TEXT_83 = "        " + NL + "\tfor (java.util.Iterator<";
  protected final String TEXT_84 = "Struct> iter_";
  protected final String TEXT_85 = " = row_aref_";
  protected final String TEXT_86 = "_";
  protected final String TEXT_87 = ".iterator(); iter_";
  protected final String TEXT_88 = ".hasNext();) {\t" + NL + "\t\t";
  protected final String TEXT_89 = "Struct element_";
  protected final String TEXT_90 = " = iter_";
  protected final String TEXT_91 = ".next(); \t" + NL + "////";
  protected final String TEXT_92 = " ";
  protected final String TEXT_93 = NL + "      ";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = " = element_";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = ";";
  protected final String TEXT_98 = NL + "////\t\t" + NL;
  protected final String TEXT_99 = NL + "\t" + NL + "\tnb_line_";
  protected final String TEXT_100 = "++;" + NL + "////////////////////////";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();
String rowName = null;
String origin = ElementParameterParser.getValue(node, "__ORIGIN__");

	for (INode pNode : node.getProcess().getNodesOfType("tArray")) {
		if (!pNode.getUniqueName().equals(origin + "_Array")) continue; 
		for (IConnection conn : pNode.getIncomingConnections()) {
			rowName = conn.getName();
			break;
		}
		
	}

String outRowName = "";
if ((node.getOutgoingConnections()!=null)&&(node.getOutgoingConnections().size()>0)) {
	outRowName = node.getOutgoingConnections().get(0).getName();
} else {
	outRowName = "defaultRow";
}


    stringBuffer.append(TEXT_2);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
    
    List<Map<String, String>> groups = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPS__");
    String delimiter = ElementParameterParser.getValue(node, "__DELIMITER__");
    String merge = ElementParameterParser.getValue(node, "__MERGE__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
     
//  check the denormalize fields type, only support String type
	boolean hasInvalidType = false;
	for (IMetadataColumn column : metadata.getListColumns()) { 
	
    	boolean isGroupBy = false;
    	for (int i=0; i<groups.size(); i++) {
    		Map<String, String> line = groups.get(i);
    		String colname = line.get("INPUT_COLUMN");
        	if (column.getLabel().equals(colname)) { isGroupBy = true; break; }
    	}
    	
    	if (!isGroupBy) {
		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
		if(javaType != JavaTypesManager.STRING){
			hasInvalidType = true;
			break;
		}
    }
  }
  
  if(hasInvalidType) {

    stringBuffer.append(TEXT_5);
    
	} else {//check

    stringBuffer.append(TEXT_6);
     if (merge.equals("true")) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(delimiter );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(delimiter );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    
  }

    stringBuffer.append(TEXT_14);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_19);
    
  if (groups.size()>0) { //111

    stringBuffer.append(TEXT_20);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    
    	for (int i=0; i < groups.size(); i++) {
    		Map<String, String> line = groups.get(i);
    		String colname = line.get("INPUT_COLUMN");

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(colname );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(i<(groups.size()-1)?"+":"");
    
    } 

    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
     
    //
	for (IMetadataColumn column : metadata.getListColumns()) { 
	
    	boolean isGroupBy = false;
    	for (int i=0; i<groups.size(); i++) {
    		Map<String, String> line = groups.get(i);
    		String colname = line.get("INPUT_COLUMN");
        	if (column.getLabel().equals(colname)) { isGroupBy = true; break; }
    	}
    	
    	if (!isGroupBy) {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(delimiter );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_55);
    
    }
  }

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
     
    //output columns 
	for (IMetadataColumn column : metadata.getListColumns()) { 
	
    	boolean isGroupBy = false;
    	for (int i=0; i<groups.size(); i++) {
    		Map<String, String> line = groups.get(i);
    		String colname = line.get("INPUT_COLUMN");
        	if (column.getLabel().equals(colname)) { isGroupBy = true; break; }
    	}
    	
    	if ( merge.equals("true") && !isGroupBy) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(outRowName );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_76);
    
    } else { 

    stringBuffer.append(TEXT_77);
    stringBuffer.append(outRowName );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_81);
        
  }
 }

    stringBuffer.append(TEXT_82);
    
  } else {//111

    stringBuffer.append(TEXT_83);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(origin );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(rowName );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
     
    //output columns 
	for (IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(outRowName );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    
  }

    stringBuffer.append(TEXT_98);
    
  }//111

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    
       }//check
    }//2    
}//1

    return stringBuffer.toString();
  }
}
