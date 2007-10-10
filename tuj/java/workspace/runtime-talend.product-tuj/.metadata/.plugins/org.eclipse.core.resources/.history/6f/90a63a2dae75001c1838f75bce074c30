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

public class TFileInputCSVBeginJava
{
  protected static String nl;
  public static synchronized TFileInputCSVBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputCSVBeginJava result = new TFileInputCSVBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t\t" + NL + "\t\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\t\tint footer_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "\t\tint totalLine";
  protected final String TEXT_6 = " = 0;" + NL + "\t\tint limit";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "\t\tint lastLine";
  protected final String TEXT_9 = " = -1;\t" + NL + "\t\t" + NL + "\t\tcom.csvreader.CsvReader csvReader";
  protected final String TEXT_10 = "=new com.csvreader.CsvReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "                new java.io.FileInputStream(";
  protected final String TEXT_11 = "),";
  protected final String TEXT_12 = ")), '";
  protected final String TEXT_13 = "');" + NL + "                ";
  protected final String TEXT_14 = NL + "          \tcsvReader";
  protected final String TEXT_15 = ".setRecordDelimiter('";
  protected final String TEXT_16 = "');";
  protected final String TEXT_17 = NL + "        csvReader";
  protected final String TEXT_18 = ".setSkipEmptyRecords(";
  protected final String TEXT_19 = ");" + NL + "        csvReader";
  protected final String TEXT_20 = ".setTextQualifier('";
  protected final String TEXT_21 = "');                " + NL;
  protected final String TEXT_22 = NL + "            csvReader";
  protected final String TEXT_23 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_BACKSLASH);";
  protected final String TEXT_24 = NL + "            csvReader";
  protected final String TEXT_25 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_DOUBLED);";
  protected final String TEXT_26 = NL + "            //?????doesn't work for other escapeChar";
  protected final String TEXT_27 = "       " + NL + "" + NL + "\t\tString[] row";
  protected final String TEXT_28 = "=null;" + NL + "\t\t" + NL + "\t\tif(footer_";
  protected final String TEXT_29 = " > 0){" + NL + "\t\t" + NL + "            while (csvReader";
  protected final String TEXT_30 = ".readRecord()) {";
  protected final String TEXT_31 = NL + "\t\t\t\trow";
  protected final String TEXT_32 = "=csvReader";
  protected final String TEXT_33 = ".getValues();" + NL + "\t\t\t\tif(!(row";
  protected final String TEXT_34 = ".length == 1 && row";
  protected final String TEXT_35 = "[0].equals(\"\\015\"))){//empty line when row separator is '\\n'";
  protected final String TEXT_36 = NL + "                " + NL + "                \ttotalLine";
  protected final String TEXT_37 = "++;" + NL + "                ";
  protected final String TEXT_38 = NL + "\t\t\t\t}";
  protected final String TEXT_39 = NL + "                " + NL + "            }" + NL + "            int lastLineTemp";
  protected final String TEXT_40 = " = totalLine";
  protected final String TEXT_41 = " - footer_";
  protected final String TEXT_42 = "   < 0? 0 : totalLine";
  protected final String TEXT_43 = " - footer_";
  protected final String TEXT_44 = " ;" + NL + "            if(lastLine";
  protected final String TEXT_45 = " > 0){" + NL + "                lastLine";
  protected final String TEXT_46 = " = lastLine";
  protected final String TEXT_47 = " < lastLineTemp";
  protected final String TEXT_48 = " ? lastLine";
  protected final String TEXT_49 = " : lastLineTemp";
  protected final String TEXT_50 = "; " + NL + "            }else {" + NL + "                lastLine";
  protected final String TEXT_51 = " = lastLineTemp";
  protected final String TEXT_52 = ";" + NL + "            }" + NL + "         " + NL + "          \tcsvReader";
  protected final String TEXT_53 = ".close();" + NL + "          " + NL + "         \tcsvReader";
  protected final String TEXT_54 = "=new com.csvreader.CsvReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "                  new java.io.FileInputStream(";
  protected final String TEXT_55 = "),";
  protected final String TEXT_56 = ")), '";
  protected final String TEXT_57 = "');";
  protected final String TEXT_58 = NL + "          \tcsvReader";
  protected final String TEXT_59 = ".setRecordDelimiter('";
  protected final String TEXT_60 = "');";
  protected final String TEXT_61 = NL + "        csvReader";
  protected final String TEXT_62 = ".setSkipEmptyRecords(";
  protected final String TEXT_63 = ");" + NL + "        csvReader";
  protected final String TEXT_64 = ".setTextQualifier('";
  protected final String TEXT_65 = "');                " + NL;
  protected final String TEXT_66 = NL + "            csvReader";
  protected final String TEXT_67 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_BACKSLASH);";
  protected final String TEXT_68 = NL + "            csvReader";
  protected final String TEXT_69 = ".setEscapeMode(com.csvreader.CsvReader.ESCAPE_MODE_DOUBLED);";
  protected final String TEXT_70 = NL + "            //?????doesn't work for other escapeChar";
  protected final String TEXT_71 = "  " + NL + "          " + NL + "        }" + NL + "        " + NL + "        " + NL + "        " + NL + "        int currentLine";
  protected final String TEXT_72 = " = 0;" + NL + "        int outputLine";
  protected final String TEXT_73 = " = 0;" + NL + "            " + NL + "        while (csvReader";
  protected final String TEXT_74 = ".readRecord()) { " + NL + "        " + NL + "        \trow";
  protected final String TEXT_75 = "=csvReader";
  protected final String TEXT_76 = ".getValues();" + NL + "        \t";
  protected final String TEXT_77 = NL + "        \tif(row";
  protected final String TEXT_78 = ".length == 1 && row";
  protected final String TEXT_79 = "[0].equals(\"\\015\")){//empty line when row separator is '\\n'" + NL + "        \t\tcontinue;" + NL + "        \t}";
  protected final String TEXT_80 = NL + "        \t" + NL + "        \t" + NL + "        \tcurrentLine";
  protected final String TEXT_81 = "++;" + NL + "        \tif(currentLine";
  protected final String TEXT_82 = " < ";
  protected final String TEXT_83 = "+1) {" + NL + "                continue;" + NL + "            }" + NL + "            " + NL + "            if(lastLine";
  protected final String TEXT_84 = " > -1 && currentLine";
  protected final String TEXT_85 = " > lastLine";
  protected final String TEXT_86 = ") {" + NL + "                break;" + NL + "            }" + NL + "            outputLine";
  protected final String TEXT_87 = "++;" + NL + "            if(limit";
  protected final String TEXT_88 = "!=-1&& outputLine";
  protected final String TEXT_89 = " > limit";
  protected final String TEXT_90 = "){" + NL + "                break;" + NL + "            }  " + NL + "                                                                      ";
  protected final String TEXT_91 = "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\tif(row";
  protected final String TEXT_92 = ".length == 1 && row";
  protected final String TEXT_93 = "[0].equals(\"\\015\")){//empty line when row separator is '\\n'" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + NL + "\t\t\t\t";
  protected final String TEXT_95 = ".";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_98 = NL + "\t\t\t\t" + NL + "\t\t\t}else{" + NL + "\t\t\t";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_100 = " < row";
  protected final String TEXT_101 = ".length){\t\t\t\t";
  protected final String TEXT_102 = NL + "\t\t\t\t\t";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = " = row";
  protected final String TEXT_105 = "[";
  protected final String TEXT_106 = "];";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\tif(row";
  protected final String TEXT_108 = "[";
  protected final String TEXT_109 = "].length() > 0) {" + NL + "\t";
  protected final String TEXT_110 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = " = ParserUtils.parseTo_Date(row";
  protected final String TEXT_113 = "[";
  protected final String TEXT_114 = "], ";
  protected final String TEXT_115 = ");" + NL + "\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " = ParserUtils.parseTo_";
  protected final String TEXT_119 = "(row";
  protected final String TEXT_120 = "[";
  protected final String TEXT_121 = "]);" + NL + "\t";
  protected final String TEXT_122 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t";
  protected final String TEXT_126 = "\t" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t}else{\t\t\t\t\t\t\t\t\t\t" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = ";" + NL + "" + NL + "\t\t\t\t}" + NL;
  protected final String TEXT_130 = NL + NL + "\t\t\t}" + NL + NL;
  protected final String TEXT_131 = NL + "      \t\t\t";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = " = ";
  protected final String TEXT_134 = ".";
  protected final String TEXT_135 = ";" + NL + "\t\t\t\t ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();
        
        String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	if(limit.equals("")){
    		limit="-1";
    	}
    	String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    	String delim = delim1.substring(1,delim1.length()-1);
    	if(delim.equals("'")){
    		delim = "\\'";
    	}
    	String rowSeparator1 = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    	String rowSeparator = rowSeparator1.substring(1,rowSeparator1.length()-1);
    	if(rowSeparator.equals("'")){
    		rowSeparator = "\\'";
    	}
    	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
    	String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
    	if(escapeChar.equals("'")){
    		escapeChar = "\\'";
    	}
    	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
    	String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
    	if ("".equals(textEnclosure)) textEnclosure = "\0";
    	if(textEnclosure.equals("'")){
    		textEnclosure = "\\'";
    	}
    	String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append( footer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( limit );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_13);
              	if(!rowSeparator.equals("\\n") && !rowSeparator.equals("\\r")){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(rowSeparator  );
    stringBuffer.append(TEXT_16);
    				}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_21);
    
        if(escapeChar.equals("\\\\")){
        
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
        }else if(escapeChar.equals(textEnclosure)){
        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
        }else{
        
    stringBuffer.append(TEXT_26);
    
        }
        
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
                	if(removeEmptyRow.equals("true")){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    				}
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
                	if(removeEmptyRow.equals("true")){
    stringBuffer.append(TEXT_38);
    				}
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
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_57);
              	if(!rowSeparator.equals("\\n") && !rowSeparator.equals("\\r")){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(rowSeparator  );
    stringBuffer.append(TEXT_60);
    				}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_65);
    
        if(escapeChar.equals("\\\\")){
        
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
        }else if(escapeChar.equals(textEnclosure)){
        
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    
        }else{
        
    stringBuffer.append(TEXT_70);
    
        }
        
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
   		if(removeEmptyRow.equals("true")){
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    		}
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append( header );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	String firstConnName = "";
	if (conns!=null) {
		if (conns.size()>0) {
			IConnection conn = conns.get(0);
			firstConnName = conn.getName();
			
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				List<IMetadataColumn> columns=metadata.getListColumns();
				int columnSize = columns.size();
				
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
		for (IMetadataColumn column1: metadata.getListColumns()) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column1.getLabel() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaIdType(column1.getTalendType(), column1.isNullable()));
    stringBuffer.append(TEXT_97);
    		}
    stringBuffer.append(TEXT_98);
    
			for (int i=0;i<columnSize;i++) {
					IMetadataColumn column=columns.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
			
    stringBuffer.append(TEXT_99);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_102);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_106);
    
					} else {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_109);
    
							if(javaType == JavaTypesManager.DATE) {
	
    stringBuffer.append(TEXT_110);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_115);
    
							} else {
	
    stringBuffer.append(TEXT_116);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_121);
    
							}
	
    stringBuffer.append(TEXT_122);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_125);
    					
					}
    stringBuffer.append(TEXT_126);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_129);
    			}
    stringBuffer.append(TEXT_130);
    			
			}
		}
		if (conns.size()>1) {
			for (int i=1;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
			    	for (IMetadataColumn column: metadata.getListColumns()) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_135);
    
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
