package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TFileInputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileInputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputPositionalBeginJava result = new TFileInputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "int footer_";
  protected final String TEXT_4 = "  = ";
  protected final String TEXT_5 = ";" + NL + "int limit_";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";";
  protected final String TEXT_8 = NL + "int[] sizes_";
  protected final String TEXT_9 = " = new int[";
  protected final String TEXT_10 = "];" + NL + "int[] begins_";
  protected final String TEXT_11 = " = new int[";
  protected final String TEXT_12 = "];" + NL + "int[] ends_";
  protected final String TEXT_13 = " = new int[";
  protected final String TEXT_14 = "];";
  protected final String TEXT_15 = NL + "sizes_";
  protected final String TEXT_16 = "[";
  protected final String TEXT_17 = "] = ";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL + "sizes_";
  protected final String TEXT_20 = "[";
  protected final String TEXT_21 = "] = ";
  protected final String TEXT_22 = ";\t\t\t\t";
  protected final String TEXT_23 = NL + "begins_";
  protected final String TEXT_24 = "[";
  protected final String TEXT_25 = "] = 0;" + NL + "ends_";
  protected final String TEXT_26 = "[";
  protected final String TEXT_27 = "] = sizes_";
  protected final String TEXT_28 = "[";
  protected final String TEXT_29 = "];";
  protected final String TEXT_30 = NL + "begins_";
  protected final String TEXT_31 = "[";
  protected final String TEXT_32 = "] = begins_";
  protected final String TEXT_33 = "[";
  protected final String TEXT_34 = "] + sizes_";
  protected final String TEXT_35 = "[";
  protected final String TEXT_36 = "];" + NL + "ends_";
  protected final String TEXT_37 = "[";
  protected final String TEXT_38 = "] = -1;";
  protected final String TEXT_39 = NL + "begins_";
  protected final String TEXT_40 = "[";
  protected final String TEXT_41 = "] = begins_";
  protected final String TEXT_42 = "[";
  protected final String TEXT_43 = "] + sizes_";
  protected final String TEXT_44 = "[";
  protected final String TEXT_45 = "];" + NL + "ends_";
  protected final String TEXT_46 = "[";
  protected final String TEXT_47 = "] = ends_";
  protected final String TEXT_48 = "[";
  protected final String TEXT_49 = "] + sizes_";
  protected final String TEXT_50 = "[";
  protected final String TEXT_51 = "];";
  protected final String TEXT_52 = NL + "java.io.BufferedReader in_";
  protected final String TEXT_53 = " = " + NL + "\tnew java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(";
  protected final String TEXT_54 = "), ";
  protected final String TEXT_55 = "));";
  protected final String TEXT_56 = NL + "int rowLength_";
  protected final String TEXT_57 = " = 0;\t\t\t";
  protected final String TEXT_58 = NL + "rowLength_";
  protected final String TEXT_59 = " += sizes_";
  protected final String TEXT_60 = "[";
  protected final String TEXT_61 = "];";
  protected final String TEXT_62 = NL + "rowLength_";
  protected final String TEXT_63 = " += ";
  protected final String TEXT_64 = ";";
  protected final String TEXT_65 = NL + "org.talend.fileprocess.delimited.RowParser reader_";
  protected final String TEXT_66 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_67 = ", rowLength_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "org.talend.fileprocess.delimited.RowParser reader_";
  protected final String TEXT_70 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "reader_";
  protected final String TEXT_75 = ".skipHeaders(";
  protected final String TEXT_76 = ");" + NL + "if(footer_";
  protected final String TEXT_77 = " > 0){" + NL + "\tint available_";
  protected final String TEXT_78 = " = (int)reader_";
  protected final String TEXT_79 = ".getAvailableRowCount(footer_";
  protected final String TEXT_80 = ");" + NL + "\treader_";
  protected final String TEXT_81 = ".close();" + NL + "\tin_";
  protected final String TEXT_82 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(";
  protected final String TEXT_83 = "), ";
  protected final String TEXT_84 = "));";
  protected final String TEXT_85 = NL + "\treader_";
  protected final String TEXT_86 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_87 = ", rowLength_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "\treader_";
  protected final String TEXT_90 = " = new org.talend.fileprocess.delimited.RowParser(in_";
  protected final String TEXT_91 = ", ";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = ");";
  protected final String TEXT_94 = "\t" + NL + "\treader_";
  protected final String TEXT_95 = ".skipHeaders(";
  protected final String TEXT_96 = ");\t" + NL + "\tif(limit_";
  protected final String TEXT_97 = " == -1){" + NL + "\t\tlimit_";
  protected final String TEXT_98 = " = available_";
  protected final String TEXT_99 = "; " + NL + "\t}else{" + NL + "\t\tlimit_";
  protected final String TEXT_100 = " = (limit_";
  protected final String TEXT_101 = " > available_";
  protected final String TEXT_102 = ") ? available_";
  protected final String TEXT_103 = " : limit_";
  protected final String TEXT_104 = ";" + NL + "\t}" + NL + "}" + NL + "String row_";
  protected final String TEXT_105 = " = null;   ";
  protected final String TEXT_106 = NL + "String column_";
  protected final String TEXT_107 = " = null;";
  protected final String TEXT_108 = NL + "String[] columnValue";
  protected final String TEXT_109 = "=new String[";
  protected final String TEXT_110 = "];";
  protected final String TEXT_111 = NL + "while (reader_";
  protected final String TEXT_112 = ".readRecord()) {" + NL + "\trow_";
  protected final String TEXT_113 = " = reader_";
  protected final String TEXT_114 = ".getRowRecord();";
  protected final String TEXT_115 = NL + "    if(begins_";
  protected final String TEXT_116 = "[";
  protected final String TEXT_117 = "] < row_";
  protected final String TEXT_118 = ".length()){" + NL + "    \tcolumn_";
  protected final String TEXT_119 = " = TalendString.talendTrim(row_";
  protected final String TEXT_120 = ".substring(begins_";
  protected final String TEXT_121 = "[";
  protected final String TEXT_122 = "]), ";
  protected final String TEXT_123 = ", ";
  protected final String TEXT_124 = ");" + NL + "    }else{" + NL + "    \tcolumn_";
  protected final String TEXT_125 = " = \"\";" + NL + "    }";
  protected final String TEXT_126 = NL + "\tif(begins_";
  protected final String TEXT_127 = "[";
  protected final String TEXT_128 = "] < row_";
  protected final String TEXT_129 = ".length()){" + NL + "        if(ends_";
  protected final String TEXT_130 = "[";
  protected final String TEXT_131 = "] <= row_";
  protected final String TEXT_132 = ".length()){" + NL + "        \tcolumn_";
  protected final String TEXT_133 = " = TalendString.talendTrim(row_";
  protected final String TEXT_134 = ".substring(begins_";
  protected final String TEXT_135 = "[";
  protected final String TEXT_136 = "], ends_";
  protected final String TEXT_137 = "[";
  protected final String TEXT_138 = "]), ";
  protected final String TEXT_139 = ", ";
  protected final String TEXT_140 = ");" + NL + "        }else{" + NL + "        \tcolumn_";
  protected final String TEXT_141 = " = TalendString.talendTrim(row_";
  protected final String TEXT_142 = ".substring(begins_";
  protected final String TEXT_143 = "[";
  protected final String TEXT_144 = "]), ";
  protected final String TEXT_145 = ", ";
  protected final String TEXT_146 = ");" + NL + "\t\t}" + NL + "    }else{" + NL + "    \tcolumn_";
  protected final String TEXT_147 = " = \"\";" + NL + "    }";
  protected final String TEXT_148 = NL + "\tcolumn_";
  protected final String TEXT_149 = " = column_";
  protected final String TEXT_150 = ".trim();";
  protected final String TEXT_151 = NL + "\t";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = " = column_";
  protected final String TEXT_154 = ";";
  protected final String TEXT_155 = NL + "\tif(column_";
  protected final String TEXT_156 = ".length() > 0) {";
  protected final String TEXT_157 = NL + "\t\t";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = ParserUtils.parseTo_Date(column_";
  protected final String TEXT_160 = ", ";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "\t\t";
  protected final String TEXT_163 = ".";
  protected final String TEXT_164 = " = column_";
  protected final String TEXT_165 = ".getBytes();";
  protected final String TEXT_166 = NL + "\t\t";
  protected final String TEXT_167 = ".";
  protected final String TEXT_168 = " = ParserUtils.parseTo_";
  protected final String TEXT_169 = "(column_";
  protected final String TEXT_170 = ");";
  protected final String TEXT_171 = NL + "    }else{" + NL + "    \t";
  protected final String TEXT_172 = ".";
  protected final String TEXT_173 = " = ";
  protected final String TEXT_174 = ";" + NL + "    }";
  protected final String TEXT_175 = NL + "\tint substringBegin";
  protected final String TEXT_176 = "=0,substringEnd";
  protected final String TEXT_177 = "=0;";
  protected final String TEXT_178 = NL + "\tcolumnValue";
  protected final String TEXT_179 = "[";
  protected final String TEXT_180 = "]=\"\";";
  protected final String TEXT_181 = NL + "    if(substringBegin";
  protected final String TEXT_182 = " >= row_";
  protected final String TEXT_183 = ".length()){" + NL + "    \tcolumnValue";
  protected final String TEXT_184 = "[";
  protected final String TEXT_185 = "]= \"\";" + NL + "    }else{";
  protected final String TEXT_186 = NL + "        substringEnd";
  protected final String TEXT_187 = "=row_";
  protected final String TEXT_188 = ".length();";
  protected final String TEXT_189 = NL + "        substringEnd";
  protected final String TEXT_190 = " = substringEnd";
  protected final String TEXT_191 = " + ";
  protected final String TEXT_192 = ";" + NL + "        if(substringEnd";
  protected final String TEXT_193 = " > row_";
  protected final String TEXT_194 = ".length()){" + NL + "        \tsubstringEnd";
  protected final String TEXT_195 = " = row_";
  protected final String TEXT_196 = ".length();" + NL + "    \t}";
  protected final String TEXT_197 = NL + "        columnValue";
  protected final String TEXT_198 = "[";
  protected final String TEXT_199 = "] = row_";
  protected final String TEXT_200 = ".substring(substringBegin";
  protected final String TEXT_201 = ", substringEnd";
  protected final String TEXT_202 = ");";
  protected final String TEXT_203 = NL + "\t\tcolumnValue";
  protected final String TEXT_204 = "[";
  protected final String TEXT_205 = "] = columnValue";
  protected final String TEXT_206 = "[";
  protected final String TEXT_207 = "].trim();";
  protected final String TEXT_208 = "    \t" + NL + "        substringBegin";
  protected final String TEXT_209 = " = substringEnd";
  protected final String TEXT_210 = ";" + NL + "\t}";
  protected final String TEXT_211 = NL + "\t";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = columnValue";
  protected final String TEXT_214 = "[";
  protected final String TEXT_215 = "];";
  protected final String TEXT_216 = NL + "\tif(columnValue";
  protected final String TEXT_217 = "[";
  protected final String TEXT_218 = "].length() > 0) {";
  protected final String TEXT_219 = "\t" + NL + "\t\t";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = " = ParserUtils.parseTo_Date(columnValue";
  protected final String TEXT_222 = "[";
  protected final String TEXT_223 = "], ";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = "\t" + NL + "\t\t";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = columnValue";
  protected final String TEXT_228 = "[";
  protected final String TEXT_229 = "].getBytes();";
  protected final String TEXT_230 = "\t" + NL + "\t\t";
  protected final String TEXT_231 = ".";
  protected final String TEXT_232 = " = ParserUtils.parseTo_";
  protected final String TEXT_233 = "(columnValue";
  protected final String TEXT_234 = "[";
  protected final String TEXT_235 = "].trim());";
  protected final String TEXT_236 = NL + "        }else{" + NL + "        \t";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = " = ";
  protected final String TEXT_239 = ";" + NL + "        }";
  protected final String TEXT_240 = NL + "\t\t";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = " = ";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = ";";

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
			String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
			
			List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );
            
            List<Map<String, String>> trimSelects =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__TRIMSELECT__"
            );
            
            String pattern = ElementParameterParser.getValue(node, "__PATTERN__");
            
            boolean advanced = ElementParameterParser.getValue(node, "__ADVANCED_OPTION__").equals("true");
            
			String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
			
			String trimAll = ElementParameterParser.getValue(node,"__TRIMALL__");
			boolean isTrimAll = true;
			if(trimAll != null && trimAll.equals("false")){
				isTrimAll = false;
			}
			
   			String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
   			
    		String header = ElementParameterParser.getValue(node, "__HEADER__");
    		
    		String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    		
    		String limit = ElementParameterParser.getValue(node, "__LIMIT__");    		
    		
    		String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
    		
    		if(header.equals("")){
    			header = "0";
    		}
    		
    		if(limit.equals("")){
    			limit = "-1";
    		}
    		
    		if(footer.equals("")){
    			footer = "0";
    		}
    		
    		boolean useStar = false;
    		
    		pattern=pattern.substring(1, pattern.length()-1);
    		String[] positions=(pattern.trim()).split(",");
    		for(int i=0;i<positions.length;i++){
            	if(positions[i].equals("")){
               	 	positions[i]="0";
            	}
            	if(positions[i].equals("*")){
            		useStar = true;
            	}
            }

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(footer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_7);
    
		if(advanced){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(formats.size() );
    stringBuffer.append(TEXT_14);
    
			for(int i = 0; i < formats.size(); i++){ 
				if(i == formats.size() - 1 && !(rowSeparator.equals("") || rowSeparator.equals("\"\""))){
					if(formats.get(i).get("SIZE").equals("*")){ 
						useStar = true;
					}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(useStar ? -1 :  formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_18);
    
				}else{

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(formats.get(i).get("SIZE") );
    stringBuffer.append(TEXT_22);
    
				}
			}
			for(int i = 0; i < formats.size(); i++){ 
				if(i == 0){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_29);
    
				}else if(i == formats.size() - 1 && useStar){

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_38);
    
				}else{

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_51);
    
				}
			}
		}//end if(advanced)

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_55);
    
			if(rowSeparator.equals("") || rowSeparator.equals("\"\"") ){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    
				if(advanced){ 
					for(int i = 0; i < formats.size(); i++){ 

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_61);
    
					}
				}else{
    				for(int i=0;i<positions.length;i++){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(positions[i] );
    stringBuffer.append(TEXT_64);
    
        		}
			}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
			}else{

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_73);
    
			}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_84);
    
			if(rowSeparator.equals("") || rowSeparator.equals("\"\"") ){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    
			}else{

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_93);
    
			}

    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(header );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    
	if(advanced){

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
	}else{

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_110);
    
	}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			if(advanced){
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int sizeListColumns = listColumns.size();
    				for (int valueN=0; valueN<sizeListColumns; valueN++) {
    					String paddingChar = formats.get(valueN).get("PADDING_CHAR");
    					String align = formats.get(valueN).get("ALIGN");
    					if(align.equals("'L'")){
    						align = "-1";
    					}else if(align.equals("'C'")){
    						align = "0";
    					}else{
    						align = "1";
    					}
    					if(valueN == sizeListColumns - 1 && useStar){ //last column

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    
						}else{//other column

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(valueN );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(paddingChar );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(align );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    
						}
						if(isTrimAll || trimSelects.get(valueN).get("TRIM").equals("true")){

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
						}
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_151);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    
					} else {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    
						if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_161);
    
						}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_162);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    
							} else {

    stringBuffer.append(TEXT_166);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_168);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    
							}

    stringBuffer.append(TEXT_171);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_174);
    					
					}
				}
			}else{// end if(advance)

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    
				for(int i=0;i <	metadata.getListColumns().size();i++){
					if(i >=positions.length){

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_180);
    
						continue;
					}

    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_185);
    
					if(positions[i].equals("*")){

    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    
					}else{

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(positions[i]);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    
					}

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
     
       				if(isTrimAll || trimSelects.get(i).get("TRIM").equals("true")){

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_207);
    
					}

    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    
				}//for(...)
				
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_215);
    
					} else {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_218);
    
							if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_223);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_224);
    
							}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_225);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_229);
    
							} else {

    stringBuffer.append(TEXT_230);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_235);
    
							}

    stringBuffer.append(TEXT_236);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_239);
    
        					}
        				}
        			}
        		}
        		if (conns.size()>1) {
        			for (int i=1;i<conns.size();i++) {
        				conn = conns.get(i);
        				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
        					for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_240);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_244);
    
        					}
        				}
        			}
        		}
        	}
		}
	}
}

    return stringBuffer.toString();
  }
}
