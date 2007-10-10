package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileOutputPositionalMainJava
{
  protected static String nl;
  public static synchronized TFileOutputPositionalMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPositionalMainJava result = new TFileOutputPositionalMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t\t\tString tempStringM";
  protected final String TEXT_2 = "= null;" + NL + "\t\t\t\t" + NL + "\t\t\t\tint tempLengthM";
  protected final String TEXT_3 = "= 0;" + NL + "\t\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tStringBuilder sb_";
  protected final String TEXT_5 = " = new StringBuilder();";
  protected final String TEXT_6 = NL + "\t\t\t\t" + NL + "\t\t\t\t" + NL + "\t\t\t\t//get  and format output String begin" + NL + "    \t\t\ttempStringM";
  protected final String TEXT_7 = "=";
  protected final String TEXT_8 = NL + "\t\t\t\t\tString.valueOf(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = NL + "\t\t\t\t\t(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " == null) ? " + NL + "\t\t\t\t\t\"\": ";
  protected final String TEXT_14 = "FormatterUtils.format_Date(";
  protected final String TEXT_15 = ".";
  protected final String TEXT_16 = ", ";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ")).toString()";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = "String.valueOf(";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ")";
  protected final String TEXT_25 = " ;" + NL + "    \t\t\ttempLengthM";
  protected final String TEXT_26 = "=tempStringM";
  protected final String TEXT_27 = ".length();" + NL + "    \t\t\t" + NL + "            \tif (tempLengthM";
  protected final String TEXT_28 = " >=";
  protected final String TEXT_29 = ") {";
  protected final String TEXT_30 = NL + "                        sb_";
  protected final String TEXT_31 = ".append(tempStringM";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "                        sb_";
  protected final String TEXT_34 = ".append(tempStringM";
  protected final String TEXT_35 = ".substring(tempLengthM";
  protected final String TEXT_36 = "-";
  protected final String TEXT_37 = "));";
  protected final String TEXT_38 = NL + "                        int begin";
  protected final String TEXT_39 = "=(tempLengthM";
  protected final String TEXT_40 = "-";
  protected final String TEXT_41 = ")/2;" + NL + "                        sb_";
  protected final String TEXT_42 = ".append(tempStringM";
  protected final String TEXT_43 = ".substring(begin";
  protected final String TEXT_44 = ", begin";
  protected final String TEXT_45 = "+";
  protected final String TEXT_46 = "));";
  protected final String TEXT_47 = NL + "                        sb_";
  protected final String TEXT_48 = ".append(tempStringM";
  protected final String TEXT_49 = ".substring(0, ";
  protected final String TEXT_50 = "));";
  protected final String TEXT_51 = NL + "                }else if(tempLengthM";
  protected final String TEXT_52 = "<";
  protected final String TEXT_53 = "){" + NL + "                   ";
  protected final String TEXT_54 = NL + "                        sb_";
  protected final String TEXT_55 = ".append(tempStringM";
  protected final String TEXT_56 = ");" + NL + "                        for(int i_";
  protected final String TEXT_57 = "=0; i_";
  protected final String TEXT_58 = "< ";
  protected final String TEXT_59 = "-tempLengthM";
  protected final String TEXT_60 = "; i_";
  protected final String TEXT_61 = "++){" + NL + "                            sb_";
  protected final String TEXT_62 = ".append(";
  protected final String TEXT_63 = ");" + NL + "                        }" + NL + "                        ";
  protected final String TEXT_64 = NL + "                        for(int i_";
  protected final String TEXT_65 = "=0; i_";
  protected final String TEXT_66 = "< ";
  protected final String TEXT_67 = "-tempLengthM";
  protected final String TEXT_68 = "; i_";
  protected final String TEXT_69 = "++){" + NL + "                            sb_";
  protected final String TEXT_70 = ".append(";
  protected final String TEXT_71 = ");" + NL + "                        }" + NL + "                        sb_";
  protected final String TEXT_72 = ".append(tempStringM";
  protected final String TEXT_73 = ");" + NL + "                        ";
  protected final String TEXT_74 = NL + "                        int temp";
  protected final String TEXT_75 = "= (";
  protected final String TEXT_76 = "-tempLengthM";
  protected final String TEXT_77 = ")/2;" + NL + "                        for(int i_";
  protected final String TEXT_78 = "=0;i_";
  protected final String TEXT_79 = "<temp";
  protected final String TEXT_80 = ";i_";
  protected final String TEXT_81 = "++){" + NL + "                            sb_";
  protected final String TEXT_82 = ".append(";
  protected final String TEXT_83 = ");" + NL + "                        }" + NL + "                        sb_";
  protected final String TEXT_84 = ".append(tempStringM";
  protected final String TEXT_85 = ");" + NL + "                        for(int i=temp";
  protected final String TEXT_86 = "+tempLengthM";
  protected final String TEXT_87 = ";i<";
  protected final String TEXT_88 = ";i++){" + NL + "                            sb_";
  protected final String TEXT_89 = ".append(";
  protected final String TEXT_90 = ");" + NL + "                        }" + NL + "" + NL + "                        ";
  protected final String TEXT_91 = "       " + NL + "                }" + NL + "                //get  and format output String end\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\tsb_";
  protected final String TEXT_93 = ".append(";
  protected final String TEXT_94 = ");" + NL + "\t\t\tout";
  protected final String TEXT_95 = ".write(sb_";
  protected final String TEXT_96 = ".toString());" + NL + "\t\t\tnb_line_";
  protected final String TEXT_97 = "++;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
        String cid = node.getUniqueName();
        
        String separator = ElementParameterParser.getValue(
            node,
            "__ROWSEPARATOR__"
        );
        
        List<Map<String, String>> formats =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__FORMATS__"
            );

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
	List< ? extends IConnection> conns = node.getIncomingConnections();
	for (IConnection conn : conns) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			List<IMetadataColumn> columns = metadata.getListColumns();
			int sizeColumns = columns.size();
			for (int i = 0; i < sizeColumns; i++) {
				IMetadataColumn column = columns.get(i);
				Map<String,String> format=formats.get(i);
				JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
				String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
				
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    				
				if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable()) ) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    					
				} else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    
					if(javaType == JavaTypesManager.DATE && patternValue!=null){
					
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_17);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY){
					
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    
					}else if(javaType == JavaTypesManager.STRING){
					
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel() );
    
					}else{
					
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    
					}
				}
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_29);
    
                    if (format.get("KEEP").equals("\'A\'")) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
                    } else if (format.get("KEEP").equals("\'R\'")) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_37);
    
                    } else if (format.get("KEEP").equals("\'M\'")) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_46);
    
                    } else {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_50);
    
                    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_53);
    
                    if (format.get("ALIGN").equals("\'L\'")) {
                    
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_63);
    
                    } else if (format.get("ALIGN").equals("\'R\'")) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    
                    } else {
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(format.get("SIZE"));
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
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(format.get("SIZE"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(format.get("PADDING_CHAR"));
    stringBuffer.append(TEXT_90);
    
                    } 
    stringBuffer.append(TEXT_91);
    
			}
			
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
		}
	}
    }
}

    return stringBuffer.toString();
  }
}
