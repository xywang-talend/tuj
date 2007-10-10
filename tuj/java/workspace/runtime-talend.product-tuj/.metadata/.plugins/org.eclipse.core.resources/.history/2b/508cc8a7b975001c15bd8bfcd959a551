package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;
import java.util.Map;

public class TFileOutputXMLBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLBeginJava result = new TFileOutputXMLBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "//create directory only if not exists" + NL + " String fileNewName_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + " java.io.File createFile";
  protected final String TEXT_5 = " = new java.io.File(fileNewName_";
  protected final String TEXT_6 = ");" + NL + " if(!createFile";
  protected final String TEXT_7 = ".exists()){" + NL + " \t(new java.io.File(fileNewName_";
  protected final String TEXT_8 = ".substring(0,fileNewName_";
  protected final String TEXT_9 = ".lastIndexOf(\"/\")))).mkdirs();" + NL + " }" + NL + "\t";
  protected final String TEXT_10 = NL + NL + "String[] headers_";
  protected final String TEXT_11 = " = new String[";
  protected final String TEXT_12 = "];" + NL + "    " + NL + "headers_";
  protected final String TEXT_13 = "[0] = \"<?xml version=\\\"1.0\\\" encoding=\\\"\"+";
  protected final String TEXT_14 = "+\"\\\"?>\";  " + NL;
  protected final String TEXT_15 = "String[] footers_";
  protected final String TEXT_16 = " = new String[";
  protected final String TEXT_17 = "];" + NL;
  protected final String TEXT_18 = "headers_";
  protected final String TEXT_19 = "[";
  protected final String TEXT_20 = "] = \"<\"+";
  protected final String TEXT_21 = "+\">\";" + NL + "" + NL + "footers_";
  protected final String TEXT_22 = "[";
  protected final String TEXT_23 = "] = \"</\"+";
  protected final String TEXT_24 = "+\">\";" + NL;
  protected final String TEXT_25 = "String[][] groupby_";
  protected final String TEXT_26 = " = new String[";
  protected final String TEXT_27 = "][2];" + NL + "" + NL + "int groupby_new_";
  protected final String TEXT_28 = " = 0;" + NL + "" + NL + "boolean start_";
  protected final String TEXT_29 = " = false;" + NL;
  protected final String TEXT_30 = "groupby_";
  protected final String TEXT_31 = "[";
  protected final String TEXT_32 = "][0] = \"\";" + NL + "" + NL + "groupby_";
  protected final String TEXT_33 = "[";
  protected final String TEXT_34 = "][1] = \"</";
  protected final String TEXT_35 = ">\";" + NL;
  protected final String TEXT_36 = "int nb_line_";
  protected final String TEXT_37 = " = 0;" + NL;
  protected final String TEXT_38 = NL + "java.io.BufferedWriter out_";
  protected final String TEXT_39 = " = new java.io.BufferedWriter(" + NL + "\tnew java.io.OutputStreamWriter(new java.io.FileOutputStream(";
  protected final String TEXT_40 = "), ";
  protected final String TEXT_41 = "));";
  protected final String TEXT_42 = "\tout_";
  protected final String TEXT_43 = ".write(headers_";
  protected final String TEXT_44 = "[";
  protected final String TEXT_45 = "]);" + NL + "" + NL + "\tout_";
  protected final String TEXT_46 = ".newLine();" + NL + "\t";
  protected final String TEXT_47 = NL + "int currentRowCount_";
  protected final String TEXT_48 = " = 0;" + NL + "int currentFileCount_";
  protected final String TEXT_49 = " = 0;";
  protected final String TEXT_50 = NL + "java.io.BufferedWriter out_";
  protected final String TEXT_51 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\tnew java.io.FileOutputStream(";
  protected final String TEXT_52 = "\"+currentFileCount_";
  protected final String TEXT_53 = "+\".xml\"), ";
  protected final String TEXT_54 = "));";
  protected final String TEXT_55 = NL + "String fn_";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ";" + NL + "String prefix_fn_";
  protected final String TEXT_58 = " = fn_";
  protected final String TEXT_59 = ".substring(0,fn_";
  protected final String TEXT_60 = ".lastIndexOf(\".xml\"));" + NL + "java.io.BufferedWriter out_";
  protected final String TEXT_61 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\tnew java.io.FileOutputStream(prefix_fn_";
  protected final String TEXT_62 = "+currentFileCount_";
  protected final String TEXT_63 = "+\".xml\"), ";
  protected final String TEXT_64 = "));";
  protected final String TEXT_65 = NL + NL + "\tout_";
  protected final String TEXT_66 = ".write(headers_";
  protected final String TEXT_67 = "[";
  protected final String TEXT_68 = "]);" + NL + "" + NL + "\tout_";
  protected final String TEXT_69 = ".newLine();" + NL + "\t";

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
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    List<Map<String, String>> rootTags = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
    int headers = rootTags.size() + 1;
    String split = ElementParameterParser.getValue(node, "__SPLIT__");
    String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
    
    //**
    List<Map<String, String>> columnMapping = 
    		(List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__MAPPING__"
            );
    String useDynamicGrouping = ElementParameterParser.getValue(
            node,
            "__USE_DYNAMIC_GROUPING__"
        );
    List<Map<String, String>> groupBys =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__GROUP_BY__"
            );
    if (useDynamicGrouping.equals("false")) {
        groupBys.clear();
    }
    if (encoding!=null) {
        if (encoding.equals("")) {
                encoding = "ISO-8859-15";
        }
    }
    String groupby[][] = new String[groupBys.size()][3];
    for(int i = 0; i < groupBys.size(); i++){
    	groupby[i][0] = groupBys.get(i).get("COLUMN");
    	groupby[i][1] = groupBys.get(i).get("LABEL");
    }
    int atts = 0;
    int tags = 0;
    outter1:
    for(int i = 0; i < columnMapping.size(); i++){
    	Map<String, String> map = columnMapping.get(i);
    	String col = metadata.getListColumns().get(i).getLabel();
    	for(int j = 0; j < groupby.length; j++){
    		if(groupby[j][0].equals(col)){
    			if(map.get("SCHEMA_COLUMN_NAME").equals("true")){
    				groupby[j][2] = col;
    			}else{
    				groupby[j][2] = map.get("LABEL");
    			}
    			continue outter1;
    		}
    	}
    	if(map.get("AS_ATTRIBUTE").equals("true")){
    		atts ++;
    	}else{
    		tags ++;
    	}
    }
    String[][] attribute = new String[atts][2];
    String[][] tag = new String[tags][2];
    int ia=0;
    int it=0;
    outter2:
    for(int i = 0; i < columnMapping.size(); i++){
    	Map<String, String> map = columnMapping.get(i);
    	String col = metadata.getListColumns().get(i).getLabel();
    	for(int j = 0; j < groupby.length; j++){
    		if(groupby[j][0].equals(col)){
    			continue outter2;
    		}
    	}
    	if(map.get("AS_ATTRIBUTE").equals("true")){
    		if(map.get("SCHEMA_COLUMN_NAME").equals("true")){
    			attribute[ia][1] = col;
    		}else{
    			attribute[ia][1] = map.get("LABEL");
    		}
    		attribute[ia++][0] = col;
    	}else{
    		if(map.get("SCHEMA_COLUMN_NAME").equals("true")){
    			tag[it][1] = col;
    		}else{
    			tag[it][1] = map.get("LABEL");
    		}
    	    tag[it++][0] = col;
    	}
    }
    //**
    String fileNewname = ElementParameterParser.getValue(node,"__FILENAME__");

    if(ElementParameterParser.getValue(node,"__CREATE__").equals("true")){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(fileNewname);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(headers );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( encoding );
    stringBuffer.append(TEXT_14);
    
if(rootTags.size() > 0){

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rootTags.size());
    stringBuffer.append(TEXT_17);
    
	for (int i=0; i<rootTags.size(); i++){
		Map<String, String> rootTag = rootTags.get(i);

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(rootTag.get("TAG") );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(rootTag.get("TAG") );
    stringBuffer.append(TEXT_24);
    
	}
}

    
if(groupby.length>0){

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(groupby.length );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
	for(int i = 0; i < groupby.length; i++){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_35);
    
	}
}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
if (!split.equals("true")) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_41);
    
	for(int i = 0; i < headers;i++){

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
	}
}else{

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
	if(fileName.startsWith("\"") && fileName.endsWith("\"")){
		String fileNameWithoutExtension =  fileName.substring(0,fileName.indexOf(".xml"));

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(fileNameWithoutExtension);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_54);
    
	}else{

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_64);
    
	}
	for(int i = 0; i < headers;i++){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
	}
}

    
    }
}


    return stringBuffer.toString();
  }
}
