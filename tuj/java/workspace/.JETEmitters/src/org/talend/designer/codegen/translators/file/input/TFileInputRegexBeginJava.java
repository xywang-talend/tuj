package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputRegexBeginJava
{
  protected static String nl;
  public static synchronized TFileInputRegexBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputRegexBeginJava result = new TFileInputRegexBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t" + NL + "\t";
  protected final String TEXT_2 = NL + "\t\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "        " + NL + "        int footer_";
  protected final String TEXT_4 = "  = ";
  protected final String TEXT_5 = ";" + NL + "        boolean removeEmptyRow";
  protected final String TEXT_6 = " = ";
  protected final String TEXT_7 = ";" + NL + "        org.talend.fileprocess.delimited.RowParser in";
  protected final String TEXT_8 = "=null;" + NL + "        \tin";
  protected final String TEXT_9 = " = new org.talend.fileprocess.delimited.RowParser( new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "                    new java.io.FileInputStream(";
  protected final String TEXT_10 = "),";
  protected final String TEXT_11 = ")), ";
  protected final String TEXT_12 = ", removeEmptyRow";
  protected final String TEXT_13 = ");" + NL + "        String str";
  protected final String TEXT_14 = ";" + NL + "        int totalLine";
  protected final String TEXT_15 = "=0,currentLine";
  protected final String TEXT_16 = "=0,beginLine";
  protected final String TEXT_17 = "=0,lastLine";
  protected final String TEXT_18 = "=-1,validRowCount";
  protected final String TEXT_19 = "=0;" + NL + "        int limit";
  protected final String TEXT_20 = "=";
  protected final String TEXT_21 = ";" + NL + "        ";
  protected final String TEXT_22 = "beginLine";
  protected final String TEXT_23 = "=";
  protected final String TEXT_24 = "+1;" + NL + "      \t\t";
  protected final String TEXT_25 = NL + "    \t" + NL + "        if(footer_";
  protected final String TEXT_26 = " > 0){" + NL + "\t\t\twhile (in";
  protected final String TEXT_27 = ".readRecord()) {" + NL + "                str";
  protected final String TEXT_28 = " =in";
  protected final String TEXT_29 = ".getRowRecord();        " + NL + "\t\t\t\t";
  protected final String TEXT_30 = NL + "        \t\t\tjava.util.StringTokenizer strRowToken";
  protected final String TEXT_31 = "=new java.util.StringTokenizer(str";
  protected final String TEXT_32 = ".trim(),";
  protected final String TEXT_33 = ");" + NL + "        \t \t\twhile(strRowToken";
  protected final String TEXT_34 = ".hasMoreTokens()){" + NL + "        \t \t\tstr";
  protected final String TEXT_35 = "=strRowToken";
  protected final String TEXT_36 = ".nextToken();" + NL + "        \t\t";
  protected final String TEXT_37 = NL + "\t\t\t\ttotalLine";
  protected final String TEXT_38 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "    \t\t\t}" + NL + "    \t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t}" + NL + "\t\t\tint lastLineTemp";
  protected final String TEXT_41 = " = totalLine";
  protected final String TEXT_42 = " - footer_";
  protected final String TEXT_43 = "   < 0? 0 : totalLine";
  protected final String TEXT_44 = " - footer_";
  protected final String TEXT_45 = " ;" + NL + "\t\t\tif(lastLine";
  protected final String TEXT_46 = " > 0){" + NL + "\t\t\t\tlastLine";
  protected final String TEXT_47 = " = lastLine";
  protected final String TEXT_48 = " < lastLineTemp";
  protected final String TEXT_49 = " ? lastLine";
  protected final String TEXT_50 = " : lastLineTemp";
  protected final String TEXT_51 = "; " + NL + "\t\t\t}else {" + NL + "\t\t\t\tlastLine";
  protected final String TEXT_52 = " = lastLineTemp";
  protected final String TEXT_53 = ";" + NL + "\t\t\t}" + NL + "\t\t  \tin";
  protected final String TEXT_54 = ".close();" + NL + "        \tin";
  protected final String TEXT_55 = " = new org.talend.fileprocess.delimited.RowParser( new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "                    new java.io.FileInputStream(";
  protected final String TEXT_56 = "),";
  protected final String TEXT_57 = ")), ";
  protected final String TEXT_58 = ", removeEmptyRow";
  protected final String TEXT_59 = ");" + NL + "\t\t}" + NL + "        java.util.StringTokenizer strToken";
  protected final String TEXT_60 = ";" + NL + "        java.util.regex.Pattern pattern";
  protected final String TEXT_61 = " = java.util.regex.Pattern.compile(";
  protected final String TEXT_62 = ");" + NL + "        java.util.regex.Matcher matcher";
  protected final String TEXT_63 = " = null;" + NL + "        while (in";
  protected final String TEXT_64 = ".readRecord()) {" + NL + "            str";
  protected final String TEXT_65 = " =in";
  protected final String TEXT_66 = ".getRowRecord(); " + NL + "        \t";
  protected final String TEXT_67 = NL + "        \tjava.util.StringTokenizer strRowToken";
  protected final String TEXT_68 = "=new java.util.StringTokenizer(str";
  protected final String TEXT_69 = ".trim(), ";
  protected final String TEXT_70 = ");" + NL + "        \t while(strRowToken";
  protected final String TEXT_71 = ".hasMoreTokens()){" + NL + "        \t \tstr";
  protected final String TEXT_72 = "=strRowToken";
  protected final String TEXT_73 = ".nextToken();" + NL + "        \t";
  protected final String TEXT_74 = NL + "        \t" + NL + "        \t" + NL + "       \t\tcurrentLine";
  protected final String TEXT_75 = "++;" + NL + "        \tif(currentLine";
  protected final String TEXT_76 = " < beginLine";
  protected final String TEXT_77 = ") {" + NL + "        \t\tcontinue;" + NL + "        \t}" + NL + "        \tif(lastLine";
  protected final String TEXT_78 = " > -1 && currentLine";
  protected final String TEXT_79 = " > lastLine";
  protected final String TEXT_80 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \tif(removeEmptyRow";
  protected final String TEXT_81 = " && str";
  protected final String TEXT_82 = ".equals(\"\")){" + NL + "        \t\tcontinue;" + NL + "        \t}" + NL + "        \tif(limit";
  protected final String TEXT_83 = "!=-1&& validRowCount";
  protected final String TEXT_84 = " >= limit";
  protected final String TEXT_85 = "){" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "        \tmatcher";
  protected final String TEXT_86 = " = pattern";
  protected final String TEXT_87 = ".matcher(str";
  protected final String TEXT_88 = ");" + NL + "        \tif(!matcher";
  protected final String TEXT_89 = ".find()){//line data not matched with given regex parameter" + NL + "        \t\tcontinue;" + NL + "        \t}" + NL + "        \tint groupCount";
  protected final String TEXT_90 = "=matcher";
  protected final String TEXT_91 = ".groupCount();" + NL;
  protected final String TEXT_92 = NL + "\t\t\t" + NL + "\t\t\tboolean lineIsEmpty";
  protected final String TEXT_93 = " = str";
  protected final String TEXT_94 = ".length() == 0;" + NL + "\t\t\t" + NL + "\t\t\tString[] value";
  protected final String TEXT_95 = " = new String[";
  protected final String TEXT_96 = "];" + NL + "\t\t\tString frontChar";
  protected final String TEXT_97 = ",behindChar";
  protected final String TEXT_98 = ";" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_99 = ";i++){" + NL + "\t\t\t\tvalue";
  protected final String TEXT_100 = "[i] = \"\";" + NL + "\t\t\t\tif(lineIsEmpty";
  protected final String TEXT_101 = "){" + NL + "\t\t\t\t\tcontinue;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(i < groupCount";
  protected final String TEXT_102 = "){" + NL + "\t\t\t\t\tvalue";
  protected final String TEXT_103 = "[i] = matcher";
  protected final String TEXT_104 = ".group(i+1);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tvalidRowCount";
  protected final String TEXT_105 = "++;" + NL + "\t\t\t";
  protected final String TEXT_106 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tif(value";
  protected final String TEXT_107 = "[";
  protected final String TEXT_108 = "].length() > 0) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = value";
  protected final String TEXT_111 = "[";
  protected final String TEXT_112 = "];";
  protected final String TEXT_113 = ".";
  protected final String TEXT_114 = " = ParserUtils.parseTo_Date(value";
  protected final String TEXT_115 = "[";
  protected final String TEXT_116 = "], ";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = " = value";
  protected final String TEXT_120 = "[";
  protected final String TEXT_121 = "].getBytes();";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " = ParserUtils.parseTo_";
  protected final String TEXT_124 = "(value";
  protected final String TEXT_125 = "[";
  protected final String TEXT_126 = "]);";
  protected final String TEXT_127 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_128 = "throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_129 = "', value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = ";";
  protected final String TEXT_133 = "}" + NL + "\t";
  protected final String TEXT_134 = NL + "      \t\t\t\t";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = ";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = ";" + NL + "\t\t\t\t ";
  protected final String TEXT_139 = NL + "\t\t\tnb_line_";
  protected final String TEXT_140 = "++;";

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

	
	String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
    String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    String myHeader = ElementParameterParser.getValue(node, "__HEADER__");
    String myLimit = ElementParameterParser.getValue(node, "__LIMIT__");
    String row_separator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    String regex = ElementParameterParser.getValue(node, "__REGEX__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
     String myFooter = ElementParameterParser.getValue(node, "__FOOTER__"); if (myFooter.equals("")) myFooter = "0"; 
    stringBuffer.append(myFooter);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__") );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(row_separator);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    if (myLimit.equals("")) {myLimit = "-1";}
    stringBuffer.append(myLimit );
    stringBuffer.append(TEXT_21);
     
         	if (myHeader.equals("")) myHeader = "0"; 
        	int header =Integer.parseInt(myHeader);
        	if (header > 0){
        		
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(header);
    stringBuffer.append(TEXT_24);
    }
      		
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    if(!row_separator.equals("\"\\n\"")){
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(row_separator );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    if(!row_separator.equals("\"\\n\"")){
    stringBuffer.append(TEXT_39);
    }
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
    stringBuffer.append(cid );
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
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(row_separator);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( regex );
    stringBuffer.append(TEXT_62);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    if(!row_separator.equals("\"\\n\"")){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(row_separator );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_91);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    	
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

					
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_108);
    
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								/** end **/
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_112);
    
								/** begin **/
							} else if(javaType == JavaTypesManager.DATE) { 
								/** end **/
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_116);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_117);
    
								/** begin **/
							} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
								/** end **/
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_121);
    
								/** begin **/
							} else {
								/** end **/
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_126);
    
								/** begin **/
							}
								/** end **/
						
    stringBuffer.append(TEXT_127);
    
							/** begin **/
							String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
							if(defaultValue == null) {
							/** end **/
								
    stringBuffer.append(TEXT_128);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_129);
    
							/** begin **/
							} else {
							/** end **/
								
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_132);
    
							/** begin **/
							}
							/** end **/
						
						
    stringBuffer.append(TEXT_133);
    					
	/** begin **/
					}
				}
			}
		}
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			     for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    
				 }
				}
			}
		}
	/** end **/
		

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    
		}
	}

    return stringBuffer.toString();
  }
}
