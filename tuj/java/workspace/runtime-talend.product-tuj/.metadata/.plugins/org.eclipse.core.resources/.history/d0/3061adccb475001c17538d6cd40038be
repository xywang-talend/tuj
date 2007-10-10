package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IConnection;

public class TFileOutputXMLMainJava
{
  protected static String nl;
  public static synchronized TFileOutputXMLMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputXMLMainJava result = new TFileOutputXMLMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "String tempSt_";
  protected final String TEXT_3 = " = null;" + NL + "" + NL + "boolean flag_";
  protected final String TEXT_4 = " = true;" + NL + " " + NL + "groupby_new_";
  protected final String TEXT_5 = " = 0;" + NL;
  protected final String TEXT_6 = "tempSt_";
  protected final String TEXT_7 = " = \"<";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = "=\\\"\"+";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = "((";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " == null)?\"\":(";
  protected final String TEXT_14 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_15 = "FormatterUtils.format_Date(";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ")";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = "TalendString.replaceSpecialCharForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ")).toString())";
  protected final String TEXT_23 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ")";
  protected final String TEXT_26 = "))";
  protected final String TEXT_27 = "+\"\\\">\";" + NL + "" + NL + "if(!groupby_";
  protected final String TEXT_28 = "[";
  protected final String TEXT_29 = "][0].equals(tempSt_";
  protected final String TEXT_30 = ")){" + NL + "\t" + NL + "\tif(flag_";
  protected final String TEXT_31 = "){" + NL + "\t" + NL + "\t\tgroupby_new_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";" + NL + "" + NL + "\t\tflag_";
  protected final String TEXT_34 = " = false;" + NL + "\t\t" + NL + "\t\tfor(int i_";
  protected final String TEXT_35 = " = ";
  protected final String TEXT_36 = "; i_";
  protected final String TEXT_37 = " >= groupby_new_";
  protected final String TEXT_38 = " && start_";
  protected final String TEXT_39 = "; i_";
  protected final String TEXT_40 = "--){" + NL + "" + NL + "\t\t\tout_";
  protected final String TEXT_41 = ".write(groupby_";
  protected final String TEXT_42 = "[i_";
  protected final String TEXT_43 = "][1]);" + NL + "\t" + NL + "\t\t\tout_";
  protected final String TEXT_44 = ".newLine();" + NL + "\t" + NL + "\t\t}\t" + NL + "\t}" + NL + "" + NL + "\tgroupby_";
  protected final String TEXT_45 = "[";
  protected final String TEXT_46 = "][0] = tempSt_";
  protected final String TEXT_47 = ";" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_48 = ".write(tempSt_";
  protected final String TEXT_49 = ");" + NL + "" + NL + "\tout_";
  protected final String TEXT_50 = ".newLine();" + NL + "\t" + NL + "\tif(!start_";
  protected final String TEXT_51 = "){" + NL + "\t\t\t" + NL + "\t\tstart_";
  protected final String TEXT_52 = " = true;" + NL + "\t\t\t" + NL + "\t}" + NL + "\t\t" + NL + "}else if(!flag_";
  protected final String TEXT_53 = "){" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_54 = ".write(tempSt_";
  protected final String TEXT_55 = ");" + NL + "\t" + NL + "\tout_";
  protected final String TEXT_56 = ".newLine();" + NL + "\t" + NL + "\tif(!start_";
  protected final String TEXT_57 = "){" + NL + "\t\t\t" + NL + "\t\tstart_";
  protected final String TEXT_58 = " = true;" + NL + "\t\t\t" + NL + "\t}" + NL + "\t" + NL + "}" + NL;
  protected final String TEXT_59 = "StringBuilder tempRes_";
  protected final String TEXT_60 = " = new StringBuilder(\"<\"+";
  protected final String TEXT_61 = ");" + NL;
  protected final String TEXT_62 = "tempRes_";
  protected final String TEXT_63 = ".append(\" ";
  protected final String TEXT_64 = "=\\\"\"+";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = "((";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " == null)?\"\":(";
  protected final String TEXT_69 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_70 = "FormatterUtils.format_Date(";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ")";
  protected final String TEXT_74 = ")";
  protected final String TEXT_75 = "TalendString.replaceSpecialCharForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = ")).toString())";
  protected final String TEXT_78 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ")";
  protected final String TEXT_81 = "))";
  protected final String TEXT_82 = "+\"\\\"\");" + NL;
  protected final String TEXT_83 = "tempRes_";
  protected final String TEXT_84 = ".append(\">\");" + NL;
  protected final String TEXT_85 = "tempRes_";
  protected final String TEXT_86 = ".append(\"/>\");" + NL;
  protected final String TEXT_87 = "out_";
  protected final String TEXT_88 = ".write(tempRes_";
  protected final String TEXT_89 = ".toString());" + NL + "" + NL + "out_";
  protected final String TEXT_90 = ".newLine();" + NL;
  protected final String TEXT_91 = "out_";
  protected final String TEXT_92 = ".write(\"<";
  protected final String TEXT_93 = ">\"+";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = "((";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " == null)?\"\":(";
  protected final String TEXT_98 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_99 = "FormatterUtils.format_Date(";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = ", ";
  protected final String TEXT_102 = ")";
  protected final String TEXT_103 = ")";
  protected final String TEXT_104 = "TalendString.replaceSpecialCharForXML(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = ")).toString())";
  protected final String TEXT_107 = "TalendString.replaceSpecialCharForXML(";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = ")";
  protected final String TEXT_110 = "))";
  protected final String TEXT_111 = "+\"</";
  protected final String TEXT_112 = ">\");" + NL + "" + NL + "out_";
  protected final String TEXT_113 = ".newLine();" + NL;
  protected final String TEXT_114 = "out_";
  protected final String TEXT_115 = ".write(\"</\"+";
  protected final String TEXT_116 = "+\">\");" + NL + "" + NL + "out_";
  protected final String TEXT_117 = ".newLine();" + NL;
  protected final String TEXT_118 = "nb_line_";
  protected final String TEXT_119 = "++;" + NL;
  protected final String TEXT_120 = NL + "currentRowCount_";
  protected final String TEXT_121 = "++;" + NL + "if(currentRowCount_";
  protected final String TEXT_122 = " == ";
  protected final String TEXT_123 = "){";
  protected final String TEXT_124 = NL + "out_";
  protected final String TEXT_125 = ".write(groupby_";
  protected final String TEXT_126 = "[";
  protected final String TEXT_127 = "][1]);" + NL + "out_";
  protected final String TEXT_128 = ".newLine();\t\t";
  protected final String TEXT_129 = NL + "out_";
  protected final String TEXT_130 = ".write(footers_";
  protected final String TEXT_131 = "[";
  protected final String TEXT_132 = "]);" + NL + "out_";
  protected final String TEXT_133 = ".newLine();";
  protected final String TEXT_134 = "\t" + NL + "\tout_";
  protected final String TEXT_135 = ".close();" + NL + "\tcurrentFileCount_";
  protected final String TEXT_136 = "++;";
  protected final String TEXT_137 = NL + "\tout_";
  protected final String TEXT_138 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\tnew java.io.FileOutputStream(";
  protected final String TEXT_139 = "\"+currentFileCount_";
  protected final String TEXT_140 = "+\".xml\"), ";
  protected final String TEXT_141 = "));";
  protected final String TEXT_142 = NL + "\tout_";
  protected final String TEXT_143 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\tnew java.io.FileOutputStream(prefix_fn_";
  protected final String TEXT_144 = "+currentFileCount_";
  protected final String TEXT_145 = "+\".xml\"), ";
  protected final String TEXT_146 = "));";
  protected final String TEXT_147 = NL + "\tstart_";
  protected final String TEXT_148 = " = false;  ";
  protected final String TEXT_149 = "\t" + NL + "\tout_";
  protected final String TEXT_150 = ".write(headers_";
  protected final String TEXT_151 = "[";
  protected final String TEXT_152 = "]);" + NL + "\tout_";
  protected final String TEXT_153 = ".newLine();";
  protected final String TEXT_154 = "\t" + NL + "\tgroupby_";
  protected final String TEXT_155 = "[";
  protected final String TEXT_156 = "][0] = \"\";";
  protected final String TEXT_157 = "\t" + NL + "    currentRowCount_";
  protected final String TEXT_158 = " = 0;" + NL + "}";

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
	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
	List rootTags = (List)ElementParameterParser.getObjectValue(node, "__ROOT_TAGS__");
    int footers = rootTags.size();
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
	if(groupby.length>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
	}

    
	List< ? extends IConnection> conns = node.getIncomingConnections();
	if(conns!=null && conns.size()>0){
		IConnection conn = conns.get(0);
		for(int i = 0; i < groupby.length; i++){
			boolean needReplace = false;
			boolean isDate = false;
			boolean isByteArray = false;
			String pattern = null;
			boolean isPrimitive = false;
			for(IMetadataColumn column:metadata.getListColumns()) {
				if(column.getLabel().equals(groupby[i][0])){
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
						needReplace = true;
					}
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
						pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
							needReplace = true;
						}
						isDate = true;
					}
					if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
						isByteArray = true;
					}
					isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
					break;
				}
			}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(groupby[i][2] );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(groupby[i][1] );
    stringBuffer.append(TEXT_9);
    
							if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(groupby[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_13);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_18);
    if(needReplace){
    stringBuffer.append(TEXT_19);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(groupby[i][0] );
    stringBuffer.append(TEXT_22);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(groupby[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_25);
    }
    
									}
    stringBuffer.append(TEXT_26);
    
							}
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(groupby.length-1 );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
		}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_61);
    
for(int i = 0; i < attribute.length; i++){
	boolean needReplace = false;
	boolean isDate = false;
	boolean isByteArray = false;
	String pattern = null;
	boolean isPrimitive = false;
	for(IMetadataColumn column:metadata.getListColumns()) {
		if(column.getLabel().equals(attribute[i][0])){
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
				needReplace = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
				pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
					needReplace = true;
				}
				isDate = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
				isByteArray = true;
			}
			isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			break;
		}
	}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(attribute[i][1] );
    stringBuffer.append(TEXT_64);
    
							if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(attribute[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_68);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_73);
    if(needReplace){
    stringBuffer.append(TEXT_74);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_75);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(attribute[i][0] );
    stringBuffer.append(TEXT_77);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(attribute[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_80);
    }
    
									}
    stringBuffer.append(TEXT_81);
    
							}
    stringBuffer.append(TEXT_82);
    
}

    
if(tags > 0){

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
}else{

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    
}

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
for(int i = 0; i < tag.length; i++){
	boolean needReplace = false;
	boolean isDate = false;
	boolean isByteArray = false;
	String pattern = null;
	boolean isPrimitive = false;
	for(IMetadataColumn column:metadata.getListColumns()) {
		if(column.getLabel().equals(tag[i][0])){
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.STRING){
				needReplace = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.DATE){
				pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				if(pattern != null && (pattern.contains("&") || pattern.contains("<") || pattern.contains(">") || pattern.contains("'") || pattern.contains("\""))){
					needReplace = true;
				}
				isDate = true;
			}
			if(JavaTypesManager.getJavaTypeFromId(column.getTalendType()) == JavaTypesManager.BYTE_ARRAY){
				isByteArray = true;
			}
			isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
			break;
		}
	}

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_93);
    
							if(isPrimitive){
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(tag[i][0] );
    
							}else{
								
    stringBuffer.append(TEXT_95);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_97);
    
									if(isDate && pattern != null){
									
    if(needReplace){
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_102);
    if(needReplace){
    stringBuffer.append(TEXT_103);
    }
    
									}else if(isByteArray){
									
    stringBuffer.append(TEXT_104);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(tag[i][0] );
    stringBuffer.append(TEXT_106);
    
									}else{
									
    if(needReplace){
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(tag[i][0] );
    if(needReplace){
    stringBuffer.append(TEXT_109);
    }
    
									}
    stringBuffer.append(TEXT_110);
    
							}
    stringBuffer.append(TEXT_111);
    stringBuffer.append(tag[i][1]);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
	if(i == tag.length -1){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROW_TAG__"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    
	}
}

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
    if(split.equals("true")){

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SPLIT_EVERY__") );
    stringBuffer.append(TEXT_123);
    
		for(int i = groupby.length - 1; i >=0; i--){

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
		}
		for(int i = footers - 1; i >= 0 ;i--){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
		}

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    
	if(fileName.startsWith("\"") && fileName.endsWith("\"")){
		String fileNameWithoutExtension =  fileName.substring(0,fileName.indexOf(".xml"));

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(fileNameWithoutExtension);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_141);
    
	}else{

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_146);
    
	}
	if(groupby.length > 0){

    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    
	}
	for(int i = 0; i <= footers;i++){

    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
	}
	for(int i = 0; i < groupby.length; i++){

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_156);
    
	}

    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    
	}
		}
	}
}

    return stringBuffer.toString();
  }
}
