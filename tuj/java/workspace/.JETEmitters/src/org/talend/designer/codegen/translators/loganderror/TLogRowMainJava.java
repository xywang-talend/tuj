package org.talend.designer.codegen.translators.loganderror;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TLogRowMainJava
{
  protected static String nl;
  public static synchronized TLogRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowMainJava result = new TLogRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "///////////////////////\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + NL + "\t\t\t\tStringBuffer strBuffer_";
  protected final String TEXT_4 = " = new StringBuffer();";
  protected final String TEXT_5 = NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_6 = ".append(\"[";
  protected final String TEXT_7 = "] \");";
  protected final String TEXT_8 = NL + NL;
  protected final String TEXT_9 = NL + NL;
  protected final String TEXT_10 = NL + "\t\t\t\tjava.util.Formatter formatter_";
  protected final String TEXT_11 = "_";
  protected final String TEXT_12 = " = new java.util.Formatter(new StringBuffer());";
  protected final String TEXT_13 = NL + NL;
  protected final String TEXT_14 = NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_15 = ".append(\"";
  protected final String TEXT_16 = ": \");";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = "   \t\t\t\t" + NL + "\t    \t\tif(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = " != null) { //";
  protected final String TEXT_21 = "              " + NL + "                    ";
  protected final String TEXT_22 = NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_23 = ".append(formatter_";
  protected final String TEXT_24 = "_";
  protected final String TEXT_25 = ".format(\"%1$";
  protected final String TEXT_26 = "s\", ";
  protected final String TEXT_27 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ")";
  protected final String TEXT_31 = NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ")).toString()";
  protected final String TEXT_34 = NL + "\t\t\t\t                String.valueOf(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ")\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\t).toString());" + NL + "\t\t\t\t";
  protected final String TEXT_38 = "\t\t\t\t\t\t\t" + NL + "       " + NL + "\t\t\t\tstrBuffer_";
  protected final String TEXT_39 = ".append(";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ", ";
  protected final String TEXT_43 = ")";
  protected final String TEXT_44 = NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ")).toString()";
  protected final String TEXT_47 = NL + "\t\t\t\t                String.valueOf(";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = ")\t\t\t";
  protected final String TEXT_50 = "\t\t\t\t" + NL + "\t\t\t\t);";
  protected final String TEXT_51 = NL + NL + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t    \t\t} //";
  protected final String TEXT_53 = "  \t\t\t" + NL;
  protected final String TEXT_54 = NL + "    \t\t\tstrBuffer_";
  protected final String TEXT_55 = ".append(OUTPUT_FIELD_SEPARATOR_";
  protected final String TEXT_56 = ");" + NL + "    \t\t\t";
  protected final String TEXT_57 = " " + NL + NL;
  protected final String TEXT_58 = NL + "\t\t\t\t" + NL + "\t\t\t\tString[] row_";
  protected final String TEXT_59 = " = new String[";
  protected final String TEXT_60 = "];" + NL;
  protected final String TEXT_61 = NL;
  protected final String TEXT_62 = "   \t\t\t\t" + NL + "\t    \t\tif(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = " != null) { //";
  protected final String TEXT_65 = "              " + NL + "                 row_";
  protected final String TEXT_66 = "[";
  protected final String TEXT_67 = "]=    \t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ")";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = ")).toString()";
  protected final String TEXT_75 = "    " + NL + "\t\t\t\t                String.valueOf(";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = ")\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t          ;\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t    \t\t} //";
  protected final String TEXT_80 = "\t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_81 = " " + NL + "" + NL + "\t\t\t\tutil_";
  protected final String TEXT_82 = ".addRow(row_";
  protected final String TEXT_83 = ");\t" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_84 = "++;";
  protected final String TEXT_85 = NL + "//////";
  protected final String TEXT_86 = "                    " + NL + "" + NL + "                    if (globalMap.get(\"tLogRow_CONSOLE\")!=null)" + NL + "                    {" + NL + "                    \tconsoleOut_";
  protected final String TEXT_87 = " = (java.io.PrintStream) globalMap.get(\"tLogRow_CONSOLE\");" + NL + "                    }" + NL + "                    else" + NL + "                    {" + NL + "                    \tconsoleOut_";
  protected final String TEXT_88 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "                    \tglobalMap.put(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_89 = ");" + NL + "                    }" + NL + "                    " + NL + "                    consoleOut_";
  protected final String TEXT_90 = ".println(strBuffer_";
  protected final String TEXT_91 = ".toString());" + NL + "                    consoleOut_";
  protected final String TEXT_92 = ".flush();" + NL + "                    nb_line_";
  protected final String TEXT_93 = "++;";
  protected final String TEXT_94 = NL + "//////                    " + NL + "                    " + NL + "///////////////////////    \t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2
    
        String cid = node.getUniqueName();        

		String tablePrint = ElementParameterParser.getValue(node,"__TABLE_PRINT__");

        String printUniqueName = ElementParameterParser.getValue(node,"__PRINT_UNIQUE_NAME__");
        String printColumnNames = ElementParameterParser.getValue(node,"__PRINT_COLNAMES__");
        String useFixedLength = ElementParameterParser.getValue(node,"__USE_FIXED_LENGTH__");
        List<Map<String, String>> lengths = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__LENGTHS__");

    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4

    stringBuffer.append(TEXT_1);
      
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();

    stringBuffer.append(TEXT_2);
    
   if (tablePrint.equals("false")) {  // don't print the table form//***

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
     
   if (printUniqueName.equals("true")) {//print the component name.

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
   }

    stringBuffer.append(TEXT_8);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5
  			
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

    stringBuffer.append(TEXT_9);
     
   if (useFixedLength.equals("true")) {//fix the column length

    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
   }

    stringBuffer.append(TEXT_13);
     
   if (printColumnNames.equals("true")) {//print the schema name

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    
   }

    stringBuffer.append(TEXT_17);
    
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) { //begin

    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    
    				} 

    stringBuffer.append(TEXT_21);
     
   if (useFixedLength.equals("true")) {//fixed the column length

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(lengths.get(i).get("LENGTH") );
    stringBuffer.append(TEXT_26);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_30);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_33);
    				
					} else {//others

    stringBuffer.append(TEXT_34);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_36);
    				
					}

    stringBuffer.append(TEXT_37);
    
   } else {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_40);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_43);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_46);
    				
					} else {//others

    stringBuffer.append(TEXT_47);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_49);
    				
					}

    stringBuffer.append(TEXT_50);
    
  }

    stringBuffer.append(TEXT_51);
    
					if(!isPrimitive) {//end

    stringBuffer.append(TEXT_52);
    
					} 

    stringBuffer.append(TEXT_53);
    
				if(i == sizeColumns-1) break;								

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
				}//5	

    stringBuffer.append(TEXT_57);
    
	} else { //print the table form//***

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_60);
        			
    			for (int i = 0; i < sizeColumns; i++) {//5
  			
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());

    stringBuffer.append(TEXT_61);
    
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) { //begin

    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_64);
    
    				} 

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_67);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_68);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_71);
    				
					} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_74);
    				
					} else {//others

    stringBuffer.append(TEXT_75);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_77);
    				
					}

    stringBuffer.append(TEXT_78);
    
					if(!isPrimitive) {//end

    stringBuffer.append(TEXT_79);
    
					} 

    stringBuffer.append(TEXT_80);
    
				}//5	

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
  }	//***

    stringBuffer.append(TEXT_85);
    
	if (tablePrint.equals("false")) {//print record one by one

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
  }

    stringBuffer.append(TEXT_94);
    
    		}//4
    	}//3
    }//2
}//1

    return stringBuffer.toString();
  }
}
