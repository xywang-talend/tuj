package org.talend.designer.codegen.translators.dataquality;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFuzzyMatchMainJava
{
  protected static String nl;
  public static synchronized TFuzzyMatchMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFuzzyMatchMainJava result = new TFuzzyMatchMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\t";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = ";" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_7 = NL + "                if(";
  protected final String TEXT_8 = ".VALUE != null){" + NL + "                " + NL + "                \t";
  protected final String TEXT_9 = ".VALUE = null;" + NL + "                }" + NL + "                if(";
  protected final String TEXT_10 = ".MATCHING != null){" + NL + "                \t";
  protected final String TEXT_11 = NL + "                ";
  protected final String TEXT_12 = ".MATCHING = null;" + NL + "                " + NL + "                }\t\t\t\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\tjava.util.Iterator<";
  protected final String TEXT_13 = "Struct> tItr_";
  protected final String TEXT_14 = "_";
  protected final String TEXT_15 = " = tSet_";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = ".iterator();" + NL;
  protected final String TEXT_18 = NL + "                    int value_";
  protected final String TEXT_19 = " = invalid_dis_";
  protected final String TEXT_20 = ";" + NL + "                    " + NL + "                    String tomatch_";
  protected final String TEXT_21 = " = (\"\" + ";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = ")";
  protected final String TEXT_24 = ".toLowerCase()";
  protected final String TEXT_25 = ";" + NL + "                ";
  protected final String TEXT_26 = NL + "                        String matching_";
  protected final String TEXT_27 = " = null;" + NL + "                        " + NL + "                        while(tItr_";
  protected final String TEXT_28 = "_";
  protected final String TEXT_29 = ".hasNext()){" + NL + "                        " + NL + "                        \tString lookUpValue_";
  protected final String TEXT_30 = " = \"\" + tItr_";
  protected final String TEXT_31 = "_";
  protected final String TEXT_32 = ".next().";
  protected final String TEXT_33 = ";" + NL + "                        \t" + NL + "                        \tint distance_";
  protected final String TEXT_34 = " = org.apache.commons.lang.StringUtils.getLevenshteinDistance(tomatch_";
  protected final String TEXT_35 = ", lookUpValue_";
  protected final String TEXT_36 = ".toLowerCase()";
  protected final String TEXT_37 = ");" + NL + "                        \t" + NL + "                        \tif(distance_";
  protected final String TEXT_38 = " < value_";
  protected final String TEXT_39 = "){" + NL + "                        \t\t" + NL + "                        \t\tif(distance_";
  protected final String TEXT_40 = " >= ";
  protected final String TEXT_41 = "){" + NL + "                        \t\t" + NL + "                        \t\t\tvalue_";
  protected final String TEXT_42 = " = distance_";
  protected final String TEXT_43 = ";" + NL + "                        \t\t\t" + NL + "                        \t\t\tmatching_";
  protected final String TEXT_44 = " = lookUpValue_";
  protected final String TEXT_45 = ";\t\t" + NL + "                        \t\t\t" + NL + "                        \t\t}" + NL + "                        \t\t" + NL + "                        \t\tif(value_";
  protected final String TEXT_46 = " == ";
  protected final String TEXT_47 = "){" + NL + "                        \t\t" + NL + "                        \t\t\tbreak;" + NL + "                        \t\t\t\t\t\t\t" + NL + "                        \t\t}" + NL + "                        \t}" + NL + "                        \t" + NL + "                        }" + NL + "                        " + NL + "                        if(value_";
  protected final String TEXT_48 = " >= ";
  protected final String TEXT_49 = " && value_";
  protected final String TEXT_50 = " <= ";
  protected final String TEXT_51 = "){" + NL + "                        " + NL + "                        \t";
  protected final String TEXT_52 = ".VALUE = value_";
  protected final String TEXT_53 = " + \"\";" + NL + "                        " + NL + "                        \t";
  protected final String TEXT_54 = ".MATCHING = matching_";
  protected final String TEXT_55 = ";" + NL + "                        \t" + NL + "                        }" + NL + "                ";
  protected final String TEXT_56 = NL + "                \t\tStringBuilder matching_";
  protected final String TEXT_57 = " = new StringBuilder();" + NL + "                " + NL + "                        while(tItr_";
  protected final String TEXT_58 = "_";
  protected final String TEXT_59 = ".hasNext()){" + NL + "                        " + NL + "                        \tString lookUpValue_";
  protected final String TEXT_60 = " = \"\" + tItr_";
  protected final String TEXT_61 = "_";
  protected final String TEXT_62 = ".next().";
  protected final String TEXT_63 = ";" + NL + "                        \t" + NL + "                        \tint distance_";
  protected final String TEXT_64 = " = org.apache.commons.lang.StringUtils.getLevenshteinDistance(tomatch_";
  protected final String TEXT_65 = ", lookUpValue_";
  protected final String TEXT_66 = ".toLowerCase()";
  protected final String TEXT_67 = ");" + NL + "                        \t" + NL + "                        \tif(distance_";
  protected final String TEXT_68 = " < value_";
  protected final String TEXT_69 = "){" + NL + "                        \t\t" + NL + "                        \t\tif(distance_";
  protected final String TEXT_70 = " >= ";
  protected final String TEXT_71 = "){" + NL + "                        \t\t" + NL + "                        \t\t\tvalue_";
  protected final String TEXT_72 = " = distance_";
  protected final String TEXT_73 = ";" + NL + "                        \t\t\t" + NL + "                        \t\t\tmatching_";
  protected final String TEXT_74 = ".append(lookUpValue_";
  protected final String TEXT_75 = ");\t\t" + NL + "                        \t\t\t" + NL + "                        \t\t}" + NL + "                        \t\t" + NL + "                        \t}else if(distance_";
  protected final String TEXT_76 = " == value_";
  protected final String TEXT_77 = " && value_";
  protected final String TEXT_78 = " <= ";
  protected final String TEXT_79 = "){" + NL + "                        " + NL + "                        \t\tmatching_";
  protected final String TEXT_80 = ".append(";
  protected final String TEXT_81 = ").append(lookUpValue_";
  protected final String TEXT_82 = ");" + NL + "                        " + NL + "                        \t}" + NL + "                        \t" + NL + "                        }" + NL + "                        " + NL + "                        if(value_";
  protected final String TEXT_83 = " >= ";
  protected final String TEXT_84 = " && value_";
  protected final String TEXT_85 = " <= ";
  protected final String TEXT_86 = "){" + NL + "                        " + NL + "                        \t";
  protected final String TEXT_87 = ".VALUE = value_";
  protected final String TEXT_88 = " + \"\";" + NL + "                        " + NL + "                        \t";
  protected final String TEXT_89 = ".MATCHING = matching_";
  protected final String TEXT_90 = ".toString();" + NL + "                        \t" + NL + "                        }" + NL + "                ";
  protected final String TEXT_91 = NL + "                " + NL + "                \t";
  protected final String TEXT_92 = ".VALUE = metaphone_";
  protected final String TEXT_93 = ".metaphone(\"\" + ";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = ");" + NL + "                ";
  protected final String TEXT_96 = NL + "                        while(tItr_";
  protected final String TEXT_97 = "_";
  protected final String TEXT_98 = ".hasNext()){" + NL + "                        " + NL + "                        \tString lookUpValue_";
  protected final String TEXT_99 = " = \"\" + tItr_";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = ".next().";
  protected final String TEXT_102 = ";" + NL + "                        \t" + NL + "                        \tif(metaphone_";
  protected final String TEXT_103 = ".metaphone(lookUpValue_";
  protected final String TEXT_104 = ").equals(";
  protected final String TEXT_105 = ".VALUE)){" + NL + "                        \t" + NL + "                        \t\t";
  protected final String TEXT_106 = ".MATCHING = lookUpValue_";
  protected final String TEXT_107 = ";" + NL + "                        \t\t" + NL + "                        \t\tbreak;" + NL + "                        \t" + NL + "                        \t}" + NL + "                        \t" + NL + "                        }" + NL + "                ";
  protected final String TEXT_108 = NL + "                        StringBuilder matching_";
  protected final String TEXT_109 = " = null;" + NL + "                        " + NL + "                        while(tItr_";
  protected final String TEXT_110 = "_";
  protected final String TEXT_111 = ".hasNext()){" + NL + "                        " + NL + "                        \tString lookUpValue_";
  protected final String TEXT_112 = " = \"\" + tItr_";
  protected final String TEXT_113 = "_";
  protected final String TEXT_114 = ".next().";
  protected final String TEXT_115 = ";" + NL + "                        \t" + NL + "                        \tif(metaphone_";
  protected final String TEXT_116 = ".metaphone(lookUpValue_";
  protected final String TEXT_117 = ").equals(";
  protected final String TEXT_118 = ".VALUE)){" + NL + "                        \t" + NL + "                        \t\tif(matching_";
  protected final String TEXT_119 = " == null){" + NL + "                        \t\t\t" + NL + "                        \t\t\tmatching_";
  protected final String TEXT_120 = " = new StringBuilder(lookUpValue_";
  protected final String TEXT_121 = ");" + NL + "                        \t\t" + NL + "                        \t\t}else{" + NL + "                        \t\t" + NL + "                        \t\t\tmatching_";
  protected final String TEXT_122 = ".append(";
  protected final String TEXT_123 = ").append(lookUpValue_";
  protected final String TEXT_124 = ");" + NL + "                        \t\t\t" + NL + "                        \t\t}" + NL + "                        \t" + NL + "                        \t}" + NL + "                        \t" + NL + "                        }" + NL + "                        " + NL + "                        if(matching_";
  protected final String TEXT_125 = " != null){" + NL + "                        " + NL + "                        \t";
  protected final String TEXT_126 = ".MATCHING = matching_";
  protected final String TEXT_127 = ".toString();" + NL + "                        \t" + NL + "                        }" + NL + "                ";
  protected final String TEXT_128 = NL + "                \t";
  protected final String TEXT_129 = ".VALUE = doublemetaphone_";
  protected final String TEXT_130 = ".doubleMetaphone(\"\" + ";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = ");" + NL + "                ";
  protected final String TEXT_133 = NL + "                        while(tItr_";
  protected final String TEXT_134 = "_";
  protected final String TEXT_135 = ".hasNext()){" + NL + "                        " + NL + "                        \tString lookUpValue_";
  protected final String TEXT_136 = " = \"\" + tItr_";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = ".next().";
  protected final String TEXT_139 = ";" + NL + "                        \t" + NL + "                        \tif(doublemetaphone_";
  protected final String TEXT_140 = ".doubleMetaphone(lookUpValue_";
  protected final String TEXT_141 = ").equals(";
  protected final String TEXT_142 = ".VALUE)){" + NL + "                        \t" + NL + "                        \t\t";
  protected final String TEXT_143 = ".MATCHING = lookUpValue_";
  protected final String TEXT_144 = ";" + NL + "                        \t\t" + NL + "                        \t\tbreak;" + NL + "                        \t" + NL + "                        \t}" + NL + "                        \t" + NL + "                        }" + NL + "                ";
  protected final String TEXT_145 = NL + "                        StringBuilder matching_";
  protected final String TEXT_146 = " = null;" + NL + "                        " + NL + "                        while(tItr_";
  protected final String TEXT_147 = "_";
  protected final String TEXT_148 = ".hasNext()){" + NL + "                        " + NL + "                        \tString lookUpValue_";
  protected final String TEXT_149 = " = \"\" + tItr_";
  protected final String TEXT_150 = "_";
  protected final String TEXT_151 = ".next().";
  protected final String TEXT_152 = ";" + NL + "                        \t" + NL + "                        \tif(doublemetaphone_";
  protected final String TEXT_153 = ".doubleMetaphone(lookUpValue_";
  protected final String TEXT_154 = ").equals(";
  protected final String TEXT_155 = ".VALUE)){" + NL + "                        \t" + NL + "                        \t\tif(matching_";
  protected final String TEXT_156 = " == null){" + NL + "                        \t\t\t" + NL + "                        \t\t\tmatching_";
  protected final String TEXT_157 = " = new StringBuilder(lookUpValue_";
  protected final String TEXT_158 = ");" + NL + "                        \t\t" + NL + "                        \t\t}else{" + NL + "                        \t\t" + NL + "                        \t\t\tmatching_";
  protected final String TEXT_159 = ".append(";
  protected final String TEXT_160 = ").append(lookUpValue_";
  protected final String TEXT_161 = ");" + NL + "                        \t\t\t" + NL + "                        \t\t}" + NL + "                        \t" + NL + "                        \t}" + NL + "                        \t" + NL + "                        }" + NL + "                        " + NL + "                        if(matching_";
  protected final String TEXT_162 = " != null){" + NL + "                        " + NL + "                        \t";
  protected final String TEXT_163 = ".MATCHING = matching_";
  protected final String TEXT_164 = ".toString();" + NL + "                        \t" + NL + "                        }" + NL + "                ";
  protected final String TEXT_165 = NL + "                nb_line_";
  protected final String TEXT_166 = "++;" + NL + "" + NL + "\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = " = ";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = ";    \t\t\t\t";

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
    
    String colName = ElementParameterParser.getValue(node, "__MATCH__");
    String matchingType = ElementParameterParser.getValue(node, "__MATCHING_TYPE__");
    String min = ElementParameterParser.getValue(node, "__MIN__");
    if(min.equals("")){
    	min="0";
    }
    String max = ElementParameterParser.getValue(node, "__MAX__");
    if(max.equals("")){
    	max="0";
    }

	String uniqueS = ElementParameterParser.getValue(node, "__GET_UNIQUE__");
	boolean unique = uniqueS.equals("true");
	String caseS = ElementParameterParser.getValue(node, "__CASE_SENSITIVE__");
	boolean caseSens = caseS.equals("true");
	String separator = ElementParameterParser.getValue(node, "__ITEMSEPARATOR__");
	String lookUpColumn = ElementParameterParser.getValue(node, "__LOOKUP_COLUMN__");
	lookUpColumn = lookUpColumn.substring(lookUpColumn.indexOf(".") + 1);

    List< ? extends IConnection> conns = node.getIncomingConnections();
    IConnection inRefCon = null;
    IConnection inMainCon = null;
    for (IConnection connection : conns) {
        if (connection == null) {
            continue;
        }
        EConnectionType connectionType = connection.getLineStyle();
        if (connectionType == EConnectionType.FLOW_MAIN) {
            inMainCon = connection;
        } else if (connectionType == EConnectionType.FLOW_REF) {
            inRefCon = connection;
        }
    }
	conns = null;

	conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				List<IMetadataColumn> listColumns = inMainCon.getMetadataTable().getListColumns();
				int sizeListColumns = listColumns.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inMainCon.getName() );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_6);
    				
				}
				
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
                if(matchingType.equals("matchLevenshteinDistance")){
                
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(inMainCon.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_23);
    if(!caseSens){
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    
                	if(unique){
                
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(lookUpColumn);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    if(!caseSens){
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(min);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(min);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(min);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(max);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
                	}else{
                
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(lookUpColumn);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    if(!caseSens){
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(min);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(max);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(min);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(max);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
                	}
                }else if(matchingType.equals("matchMetaphone")){
    stringBuffer.append(TEXT_91);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(inMainCon.getName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(colName);
    stringBuffer.append(TEXT_95);
    
                	if(unique){
                
    stringBuffer.append(TEXT_96);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(lookUpColumn);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
                	}else{
                
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(inRefCon.getName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(lookUpColumn);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    
                	}
                }else{
    stringBuffer.append(TEXT_128);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(inMainCon.getName() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(colName );
    stringBuffer.append(TEXT_132);
    
                	if(unique){
                
    stringBuffer.append(TEXT_133);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(lookUpColumn);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
                	}else{
                
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(inRefCon.getName() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(lookUpColumn);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
                	}
                }
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
			}
		}
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	 for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_167);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    
				 	}
				}
			}
		}
	}
}

    return stringBuffer.toString();
  }
}
