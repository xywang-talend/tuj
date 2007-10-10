package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataTable;

public class TFileOutputXMLEndJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLEndJava result = new TFileOutputXMLEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "out_";
  protected final String TEXT_3 = ".write(\"</";
  protected final String TEXT_4 = ">\");" + NL + "" + NL + "out_";
  protected final String TEXT_5 = ".newLine();" + NL;
  protected final String TEXT_6 = "\tout_";
  protected final String TEXT_7 = ".write(footers_";
  protected final String TEXT_8 = "[";
  protected final String TEXT_9 = "]);" + NL + "" + NL + "\tout_";
  protected final String TEXT_10 = ".newLine();" + NL + "\t";
  protected final String TEXT_11 = "out_";
  protected final String TEXT_12 = ".close();" + NL;
  protected final String TEXT_13 = NL + "\tif(currentRowCount_";
  protected final String TEXT_14 = " == 0){" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_15 = " = new java.io.File(";
  protected final String TEXT_16 = "\"+currentFileCount_";
  protected final String TEXT_17 = "+\".xml\");" + NL + "\t\tfile_";
  protected final String TEXT_18 = ".delete();" + NL + "\t}";
  protected final String TEXT_19 = NL + "\tif(currentRowCount_";
  protected final String TEXT_20 = " == 0){" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_21 = " = new java.io.File(prefix_fn_";
  protected final String TEXT_22 = "+currentFileCount_";
  protected final String TEXT_23 = "+\".xml\");" + NL + "\t\tfile_";
  protected final String TEXT_24 = ".delete();" + NL + "\t}";
  protected final String TEXT_25 = "globalMap.put(\"";
  protected final String TEXT_26 = "_NB_LINE\",nb_line_";
  protected final String TEXT_27 = ");";

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
String split = ElementParameterParser.getValue(node, "__SPLIT__");
String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
List rootTags = (List)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
    int footers = rootTags.size();
String useDynamicGrouping = ElementParameterParser.getValue(
            node,
            "__USE_DYNAMIC_GROUPING__"
        );
List<Map<String, String>> columnMapping = 
    		(List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__MAPPING__"
            );
List<Map<String, String>> groupBys =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__GROUP_BY__"
            );
if (useDynamicGrouping.equals("false")) {
    groupBys.clear();
}


String groupby[][] = new String[groupBys.size()][3];
for(int i = 0; i < groupBys.size(); i++){
    groupby[i][0] = groupBys.get(i).get("COLUMN");
    groupby[i][1] = groupBys.get(i).get("LABEL");
}
for(int i = 0; i < groupby.length; i++){
	for(int j = 0; j < columnMapping.size(); j++){
		Map<String, String> map = columnMapping.get(j);
		String col = metadata.getListColumns().get(j).getLabel();
		if(groupby[i][0].equals(col)){
			if(map.get("SCHEMA_COLUMN_NAME").equals("true")){
    			groupby[i][2] = col;
    		}else{
    			groupby[i][2] = map.get("LABEL");
    		}
    		break;
		}
	}
}

    
for(int i = groupby.length -1; i >= 0; i--){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
}
	for(int i = footers - 1; i >= 0;i--){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
if(split.equals("true")){
	if(fileName.startsWith("\"") && fileName.endsWith("\"")){
	String fileNameWithoutExtension =  fileName.substring(0,fileName.indexOf(".xml"));

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(fileNameWithoutExtension);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
	}else{

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
	}
}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
	}
}
	
    return stringBuffer.toString();
  }
}
