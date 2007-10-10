package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileOutputCSVMainJava
{
  protected static String nl;
  public static synchronized TFileOutputCSVMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputCSVMainJava result = new TFileOutputCSVMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "          \tCsvWriter";
  protected final String TEXT_2 = ".setRecordDelimiter('";
  protected final String TEXT_3 = "');";
  protected final String TEXT_4 = NL + "            CsvWriter";
  protected final String TEXT_5 = ".setEscapeMode(com.csvreader.CsvWriter.ESCAPE_MODE_BACKSLASH);";
  protected final String TEXT_6 = NL + "            CsvWriter";
  protected final String TEXT_7 = ".setEscapeMode(com.csvreader.CsvWriter.ESCAPE_MODE_DOUBLED);";
  protected final String TEXT_8 = NL + "            //doesn't work for other escapeChar";
  protected final String TEXT_9 = NL + "  \t\t" + NL + "  \t\tCsvWriter";
  protected final String TEXT_10 = ".setTextQualifier('";
  protected final String TEXT_11 = "'); " + NL + "  \t\tCsvWriter";
  protected final String TEXT_12 = ".setForceQualifier(true);";
  protected final String TEXT_13 = "  \t" + NL + "            \tString[] row";
  protected final String TEXT_14 = "=new String[";
  protected final String TEXT_15 = "];\t\t";
  protected final String TEXT_16 = "row";
  protected final String TEXT_17 = "[";
  protected final String TEXT_18 = "] =String.valueOf(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = "); ";
  protected final String TEXT_21 = "if(";
  protected final String TEXT_22 = ".";
  protected final String TEXT_23 = " == null){" + NL + " row";
  protected final String TEXT_24 = "[";
  protected final String TEXT_25 = "]=\"\";" + NL + " }else{";
  protected final String TEXT_26 = "row";
  protected final String TEXT_27 = "[";
  protected final String TEXT_28 = "] = ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = "row";
  protected final String TEXT_32 = "[";
  protected final String TEXT_33 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = "row";
  protected final String TEXT_38 = "[";
  protected final String TEXT_39 = "] = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ")).toString();";
  protected final String TEXT_42 = "row";
  protected final String TEXT_43 = "[";
  protected final String TEXT_44 = "] = String.valueOf(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = "}";
  protected final String TEXT_48 = NL + "\t\tif(currentRow_";
  protected final String TEXT_49 = " % splitEvery_";
  protected final String TEXT_50 = "==0 && currentRow_";
  protected final String TEXT_51 = "!=0){" + NL + "\t\t\tsplitedFileNo_";
  protected final String TEXT_52 = "++;" + NL + "\t\t\tCsvWriter";
  protected final String TEXT_53 = ".close(); " + NL + "\t\t\t//close original outputStream";
  protected final String TEXT_54 = NL + "\t\t\tCsvWriter";
  protected final String TEXT_55 = "=new com.csvreader.CsvWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "    \t\tnew java.io.FileOutputStream(";
  protected final String TEXT_56 = "\"+splitedFileNo_";
  protected final String TEXT_57 = "+\"";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = "),";
  protected final String TEXT_60 = ")), '";
  protected final String TEXT_61 = "');";
  protected final String TEXT_62 = NL + "\t\t\tCsvWriter";
  protected final String TEXT_63 = "=new com.csvreader.CsvWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "    \t\tnew java.io.FileOutputStream(prefix_fn_";
  protected final String TEXT_64 = "+splitedFileNo_";
  protected final String TEXT_65 = "+suffix_fn_";
  protected final String TEXT_66 = ",";
  protected final String TEXT_67 = "),";
  protected final String TEXT_68 = ")), '";
  protected final String TEXT_69 = "');";
  protected final String TEXT_70 = NL + "    \t\t//set header.";
  protected final String TEXT_71 = NL + "    \t\tCsvWriter";
  protected final String TEXT_72 = ".writeRecord(headColu";
  protected final String TEXT_73 = ");\t";
  protected final String TEXT_74 = NL + "\t\t   \tfile";
  protected final String TEXT_75 = "=new java.io.File(";
  protected final String TEXT_76 = "\"+splitedFileNo_";
  protected final String TEXT_77 = "+\"";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = "  " + NL + "\t\t\tfile";
  protected final String TEXT_80 = "=new java.io.File(prefix_fn_";
  protected final String TEXT_81 = "+splitedFileNo_";
  protected final String TEXT_82 = "+suffix_fn_";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "                \t\t    if(file";
  protected final String TEXT_85 = ".length()==0) {" + NL + "                \t\t    CsvWriter";
  protected final String TEXT_86 = ".writeRecord(headColu";
  protected final String TEXT_87 = "); " + NL + "                \t\t    }\t  " + NL + "                \t\t ";
  protected final String TEXT_88 = NL + "                \t\t//initialize new CsvWriter information " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_90 = ".setRecordDelimiter('";
  protected final String TEXT_91 = "');" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t  CsvWriter";
  protected final String TEXT_93 = ".setEscapeMode(com.csvreader.CsvWriter.ESCAPE_MODE_BACKSLASH);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t\t\t CsvWriter";
  protected final String TEXT_95 = ".setEscapeMode(com.csvreader.CsvWriter.ESCAPE_MODE_DOUBLED);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\t    //doesn't work for other escapeChar" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_97 = " " + NL + "\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_98 = ".setTextQualifier('";
  protected final String TEXT_99 = "'); " + NL + "  \t\t\t\t\t\tCsvWriter";
  protected final String TEXT_100 = ".setForceQualifier(true);            \t\t" + NL + "                \t\tCsvWriter";
  protected final String TEXT_101 = ".writeRecord(row";
  protected final String TEXT_102 = "); " + NL + " \t\t\t\t" + NL + " \t\t\t\t\t}else{" + NL + " \t\t\t\t\tCsvWriter";
  protected final String TEXT_103 = ".writeRecord(row";
  protected final String TEXT_104 = ");\t" + NL + " \t\t\t\t}\t" + NL + " \t\t\t\tcurrentRow_";
  protected final String TEXT_105 = "++;\t\t" + NL + "     \t\t\t";
  protected final String TEXT_106 = NL + " \t\t\t\tCsvWriter";
  protected final String TEXT_107 = ".writeRecord(row";
  protected final String TEXT_108 = ");\t";
  protected final String TEXT_109 = NL + " \t\t\tnb_line_";
  protected final String TEXT_110 = "++;";

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
        String filename = ElementParameterParser.getValue(node,"__FILENAME__");
        String prefixfileName = filename.substring(0,filename.lastIndexOf("."));
        String suffixfileName=filename.substring(filename.lastIndexOf("."),filename.length());
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    	String delim = delim1.substring(1,delim1.length()-1);
    	boolean isIncludeHeader = ElementParameterParser.getValue(node,"__INCLUDEHEADER__").equals("true");
    	boolean isAppend = ElementParameterParser.getValue(node,"__APPEND__").equals("true");
    	String rowSeparator1 = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
    	String rowSeparator = rowSeparator1.substring(1,rowSeparator1.length()-1);
    	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
    	String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
    	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
    	String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
    	if ("".equals(textEnclosure)) textEnclosure = "\0";
    	boolean split = ElementParameterParser.getValue(node, "__SPLIT__").equals("true");
    	List< ? extends IConnection> conns = node.getIncomingConnections();
          	if(!rowSeparator.equals("\\n") && !rowSeparator.equals("\\r")){
 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_3);
    				}
        if(escapeChar.equals("\\\\")){
        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
        }else if(escapeChar.equals(textEnclosure)){
        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
        }else{

    stringBuffer.append(TEXT_8);
    
        }
  
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
          
 
    	if(conns!=null){
    		if (conns.size()>0){
       		IConnection conn =conns.get(0);
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
  
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_15);
    
    			for (int i = 0; i < sizeColumns; i++) {
    			IMetadataColumn column = columns.get(i);
    			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    
    			}else { 
 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_25);
    					if(javaType == JavaTypesManager.STRING ){

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_30);
    
					}else if(javaType == JavaTypesManager.DATE && pattern != null){

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_36);
    
					}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_41);
    
					}else{

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    
 					}

    stringBuffer.append(TEXT_47);
       			}
 				} 
    			if(split){

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
		if(filename.startsWith("\"") && filename.endsWith("\"")){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(prefixfileName );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(suffixfileName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_61);
    
 		}else{

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_69);
    
 		}

    stringBuffer.append(TEXT_70);
    
		if(isIncludeHeader&&!isAppend){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
    	}
    	if(isIncludeHeader&&isAppend){
    		if(filename.startsWith("\"") && filename.endsWith("\"")){

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(prefixfileName );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(suffixfileName);
    stringBuffer.append(TEXT_78);
    
 			}else{

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
			}

    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
                		 }
                		
    stringBuffer.append(TEXT_88);
    
						if(!rowSeparator.equals("\\n") && !rowSeparator.equals("\\r")){
						
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_91);
    
						}if(escapeChar.equals("\\\\")){
						
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
						}else if(escapeChar.equals(textEnclosure)){
						
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
						}else{
						
    stringBuffer.append(TEXT_96);
    
						}
						
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
    			}else{
 
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
       		
    		
    			}
 
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
       		
    		}
    		
 		}
 	  }	
	
	}

}

    return stringBuffer.toString();
  }
}
