package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileOutputPositionalBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalBeginJava result = new TFileOutputPositionalBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "//create directory only if not exists" + NL + "\t\t String fileNewName_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\t\t java.io.File createFile";
  protected final String TEXT_5 = " = new java.io.File(fileNewName_";
  protected final String TEXT_6 = ");" + NL + "\t\t if(!createFile";
  protected final String TEXT_7 = ".exists()){" + NL + "\t\t \t(new java.io.File(fileNewName_";
  protected final String TEXT_8 = ".substring(0,fileNewName_";
  protected final String TEXT_9 = ".lastIndexOf(\"/\")))).mkdirs();" + NL + "\t\t }";
  protected final String TEXT_10 = NL + "\t\tint nb_line_";
  protected final String TEXT_11 = " = 0;" + NL + "\t\tfinal java.io.BufferedWriter out";
  protected final String TEXT_12 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "        \t\tnew java.io.FileOutputStream(";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = "),";
  protected final String TEXT_15 = "));" + NL + "        " + NL + "        ";
  protected final String TEXT_16 = NL + "    \t\t" + NL + "    \t\tString tempStringB";
  protected final String TEXT_17 = "=null;" + NL + "    \t\tint tempLengthB";
  protected final String TEXT_18 = "=0;" + NL + "    \t\t";
  protected final String TEXT_19 = NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\t//get  and format output String begin" + NL + "    \t\t\ttempStringB";
  protected final String TEXT_20 = "=\"";
  protected final String TEXT_21 = "\";" + NL + "    \t\t\ttempLengthB";
  protected final String TEXT_22 = "=tempStringB";
  protected final String TEXT_23 = ".length();" + NL + "    \t\t\t" + NL + "            \tif (tempLengthB";
  protected final String TEXT_24 = " > ";
  protected final String TEXT_25 = ") {";
  protected final String TEXT_26 = NL + "                        ";
  protected final String TEXT_27 = NL + "                        tempStringB";
  protected final String TEXT_28 = " = tempStringB";
  protected final String TEXT_29 = ".substring(tempLengthB";
  protected final String TEXT_30 = "-";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "                        int begin";
  protected final String TEXT_33 = "=(tempLengthB";
  protected final String TEXT_34 = "-";
  protected final String TEXT_35 = ")/2;" + NL + "                        tempStringB";
  protected final String TEXT_36 = " = tempStringB";
  protected final String TEXT_37 = ".substring(begin";
  protected final String TEXT_38 = ", begin";
  protected final String TEXT_39 = "+";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "                    tempStringB";
  protected final String TEXT_42 = " = tempStringB";
  protected final String TEXT_43 = ".substring(0, ";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "                }else if(tempLengthB";
  protected final String TEXT_46 = "<";
  protected final String TEXT_47 = "){" + NL + "                    StringBuilder result";
  protected final String TEXT_48 = " = new StringBuilder();";
  protected final String TEXT_49 = NL + "                        result";
  protected final String TEXT_50 = ".append(tempStringB";
  protected final String TEXT_51 = ");" + NL + "                        for(int i";
  protected final String TEXT_52 = "=0; i";
  protected final String TEXT_53 = "< ";
  protected final String TEXT_54 = "-tempLengthB";
  protected final String TEXT_55 = "; i";
  protected final String TEXT_56 = "++){" + NL + "                            result";
  protected final String TEXT_57 = ".append(";
  protected final String TEXT_58 = ");" + NL + "                        }" + NL + "                        tempStringB";
  protected final String TEXT_59 = " = result";
  protected final String TEXT_60 = ".toString();";
  protected final String TEXT_61 = NL + "                        for(int i";
  protected final String TEXT_62 = "=0; i";
  protected final String TEXT_63 = "< ";
  protected final String TEXT_64 = "-tempLengthB";
  protected final String TEXT_65 = "; i";
  protected final String TEXT_66 = "++){" + NL + "                            result";
  protected final String TEXT_67 = ".append(";
  protected final String TEXT_68 = ");" + NL + "                        }" + NL + "                        result";
  protected final String TEXT_69 = ".append(tempStringB";
  protected final String TEXT_70 = ");" + NL + "                        tempStringB";
  protected final String TEXT_71 = " = result";
  protected final String TEXT_72 = ".toString();";
  protected final String TEXT_73 = NL + "                        int temp";
  protected final String TEXT_74 = "= (";
  protected final String TEXT_75 = "-tempLengthB";
  protected final String TEXT_76 = ")/2;" + NL + "                        for(int i";
  protected final String TEXT_77 = "=0;i";
  protected final String TEXT_78 = "<temp";
  protected final String TEXT_79 = ";i";
  protected final String TEXT_80 = "++){" + NL + "                            result";
  protected final String TEXT_81 = ".append(";
  protected final String TEXT_82 = ");" + NL + "                        }" + NL + "                        result";
  protected final String TEXT_83 = ".append(tempStringB";
  protected final String TEXT_84 = ");" + NL + "                        for(int i";
  protected final String TEXT_85 = "=0;i";
  protected final String TEXT_86 = "<temp";
  protected final String TEXT_87 = ";i";
  protected final String TEXT_88 = "++){" + NL + "                            result";
  protected final String TEXT_89 = ".append(";
  protected final String TEXT_90 = ");" + NL + "                        }" + NL + "                        if((temp";
  protected final String TEXT_91 = "+temp";
  protected final String TEXT_92 = ")!=(";
  protected final String TEXT_93 = "-tempLengthB";
  protected final String TEXT_94 = ")){" + NL + "                            result";
  protected final String TEXT_95 = ".append(";
  protected final String TEXT_96 = ");" + NL + "                        }" + NL + "                        tempStringB";
  protected final String TEXT_97 = " = result";
  protected final String TEXT_98 = ".toString();";
  protected final String TEXT_99 = "       " + NL + "                }" + NL + "                //get  and format output String end" + NL + "    \t\t\t" + NL + "    \t\t\t" + NL + "    \t\t\tout";
  protected final String TEXT_100 = ".write(tempStringB";
  protected final String TEXT_101 = ");" + NL + "    \t\t";
  protected final String TEXT_102 = NL + "    \t\tout";
  protected final String TEXT_103 = ".write(";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL;

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
    	
    	String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
        if (encoding!=null) {
            if (encoding.equals("")) {
                encoding = "undef";
            }
        }
        
        String separator = ElementParameterParser.getValue(
            node,
            "__ROWSEPARATOR__"
        );
        
        String filename = ElementParameterParser.getValue(
            node,
            "__FILENAME__"
        );

        boolean isIncludeHeader = ElementParameterParser.getValue(
            node,
            "__INCLUDEHEADER__"
        ).equals("true");

        boolean isAppend = ElementParameterParser.getValue(
            node,
            "__APPEND__"
        ).equals("true");
        
        List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );

    if(ElementParameterParser.getValue(node,"__CREATE__").equals("true")){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(filename);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_13);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_14);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_15);
    
        if(isIncludeHeader&&!isAppend){      	
        	
    		List<IMetadataColumn> columns = metadata.getListColumns();
    		int sizeColumns = columns.size();
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
    		for (int i = 0; i < sizeColumns; i++) {
    			IMetadataColumn column = columns.get(i);
    			Map<String, String> format=formats.get(i);
    		
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_25);
    
                    if (format.get("KEEP").equals("\'A\'")) {
    stringBuffer.append(TEXT_26);
    
                    } else if (format.get("KEEP").equals("\'R\'")) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_31);
    
                    } else if (format.get("KEEP").equals("\'M\'")) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_40);
    
                    } else {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_44);
    
                    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
                    if (format.get("ALIGN").equals("\'L\'")) {
                    
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    
                    } else if (format.get("ALIGN").equals("\'R\'")) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
                    } else {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(format.get("SIZE"));
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
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
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
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    
                    } 
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
    		}
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_104);
    
		}
    }
}

    stringBuffer.append(TEXT_105);
    return stringBuffer.toString();
  }
}
