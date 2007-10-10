package org.talend.designer.codegen.translators.file.output;

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

public class TExternalSortOutputEndJava
{
  protected static String nl;
  public static synchronized TExternalSortOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TExternalSortOutputEndJava result = new TExternalSortOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t///////////////////////////////////////////" + NL + "\tout_";
  protected final String TEXT_2 = ".close();" + NL + "" + NL + "" + NL + "java.lang.StringBuffer sb_";
  protected final String TEXT_3 = " = new java.lang.StringBuffer();";
  protected final String TEXT_4 = " sb_";
  protected final String TEXT_5 = ".append(";
  protected final String TEXT_6 = ");   ";
  protected final String TEXT_7 = " sb_";
  protected final String TEXT_8 = ".append(\"sort\"); ";
  protected final String TEXT_9 = NL + NL + "sb_";
  protected final String TEXT_10 = ".append(\" -S \" + ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = " sb_";
  protected final String TEXT_13 = ".append(\" -T \\\"\" + ";
  protected final String TEXT_14 = " + \"\\\"\");   ";
  protected final String TEXT_15 = NL + "sb_";
  protected final String TEXT_16 = ".append(\" -t \" + ";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "sb_";
  protected final String TEXT_19 = ".append(\" -k \");" + NL + "sb_";
  protected final String TEXT_20 = ".append(";
  protected final String TEXT_21 = ");" + NL + "sb_";
  protected final String TEXT_22 = ".append(\",\");" + NL + "sb_";
  protected final String TEXT_23 = ".append(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = "  sb_";
  protected final String TEXT_26 = ".append(\"r\"); ";
  protected final String TEXT_27 = " sb_";
  protected final String TEXT_28 = ".append(\"n\"); ";
  protected final String TEXT_29 = NL + "sb_";
  protected final String TEXT_30 = ".append(\" -o \\\"\" + ";
  protected final String TEXT_31 = " + \"\\\"\");" + NL + "sb_";
  protected final String TEXT_32 = ".append(\" \\\"\" + tempFile_";
  protected final String TEXT_33 = ".getAbsolutePath() + \"\\\"\");" + NL + "" + NL + "" + NL + "Runtime runtime_";
  protected final String TEXT_34 = " = Runtime.getRuntime();" + NL + "final Process ps_";
  protected final String TEXT_35 = " = runtime_";
  protected final String TEXT_36 = ".exec(sb_";
  protected final String TEXT_37 = ".toString());" + NL + "" + NL + "\t\tThread normal_";
  protected final String TEXT_38 = " = new Thread() {" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_39 = ".getInputStream()));" + NL + "\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\twhile ((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\t\tSystem.out.println(line);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch (java.io.IOException ioe) {" + NL + "\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tnormal_";
  protected final String TEXT_40 = ".start();" + NL + "" + NL + "\t\tThread error_";
  protected final String TEXT_41 = " = new Thread() {" + NL + "\t\t\tpublic void run() {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(ps_";
  protected final String TEXT_42 = ".getErrorStream()));" + NL + "\t\t\t\t\tString line = \"\";" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\twhile ((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\t\t\tSystem.err.println(line);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\treader.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch (java.io.IOException ioe) {" + NL + "\t\t\t\t\tioe.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\terror_";
  protected final String TEXT_43 = ".start();" + NL + "" + NL + "\t\tps_";
  protected final String TEXT_44 = ".waitFor();" + NL + "\t\tnormal_";
  protected final String TEXT_45 = ".interrupt();" + NL + "\t\terror_";
  protected final String TEXT_46 = ".interrupt();" + NL + "\t\t";
  protected final String TEXT_47 = "final java.io.BufferedWriter re_out_";
  protected final String TEXT_48 = " = new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "        \t\tnew java.io.FileOutputStream(";
  protected final String TEXT_49 = ", true)));";
  protected final String TEXT_50 = "re_out_";
  protected final String TEXT_51 = ".write(\"false\");";
  protected final String TEXT_52 = "re_out_";
  protected final String TEXT_53 = ".write(String.valueOf(Byte.MIN_VALUE));";
  protected final String TEXT_54 = "re_out_";
  protected final String TEXT_55 = ".write(\"T\");";
  protected final String TEXT_56 = "re_out_";
  protected final String TEXT_57 = ".write(String.valueOf(Integer.MIN_VALUE));";
  protected final String TEXT_58 = "re_out_";
  protected final String TEXT_59 = ".write(String.valueOf(Long.MIN_VALUE));";
  protected final String TEXT_60 = "re_out_";
  protected final String TEXT_61 = ".write(String.valueOf(Short.MIN_VALUE));";
  protected final String TEXT_62 = "re_out_";
  protected final String TEXT_63 = ".write(String.valueOf(Float.MIN_VALUE));";
  protected final String TEXT_64 = "re_out_";
  protected final String TEXT_65 = ".write(String.valueOf(Double.MIN_VALUE));";
  protected final String TEXT_66 = "re_out_";
  protected final String TEXT_67 = ".write(OUT_DELIM_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = "re_out_";
  protected final String TEXT_70 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_71 = ");" + NL + "re_out_";
  protected final String TEXT_72 = ".close();";
  protected final String TEXT_73 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_74 = "_NB_LINE\",nb_line_";
  protected final String TEXT_75 = ");\t\t" + NL + "/////////////////////////////////";

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
			List<Map<String, String>> criteria =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,
                "__CRITERIA__"
            );

        String filename = ElementParameterParser.getValue(
            node,
            "__FILENAME__"
        );

        String fieldSeparator = ElementParameterParser.getValue(
            node,
            "__FIELDSEPARATOR__"
        );

        String tempDir = ElementParameterParser.getValue(
            node,
            "__TEMP_DIR__"
        );

        String maxMemory = ElementParameterParser.getValue(
            node,
            "__MAX_MEMORY__"
        );
        
        String SortCMDPath = ElementParameterParser.getValue(
            node,
            "__SORT_CMDPATH__"
        );

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
     if (!SortCMDPath.equals("")) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(SortCMDPath );
    stringBuffer.append(TEXT_6);
     } else { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(maxMemory);
    stringBuffer.append(TEXT_11);
     if (!tempDir.equals("")) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tempDir );
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_17);
    
        for(int i=0; i<criteria.size(); i++) {
            Map<String, String> line = criteria.get(i);
            
            String colname = line.get("COLNAME");
            int colnum = 0;

            int j = 1;
            for (IMetadataColumn column: metadata.getListColumns()) {
                if (colname.equals(column.getLabel())) {
                    colnum = j;
                }
                j++;
            }	

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(colnum );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(colnum );
    stringBuffer.append(TEXT_24);
     if (line.get("ORDER").toLowerCase().equals("desc")) { 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
     } 
     if (line.get("SORT").toLowerCase().startsWith("num")) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
     } 
    
 }

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    	if(ElementParameterParser.getValue(node, "__ADD_EOF__").equals("true")){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_49);
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.DATE || javaType == JavaTypesManager.BYTE_ARRAY || javaType == JavaTypesManager.OBJECT) {
					} else if(javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    					}else if(javaType == JavaTypesManager.BYTE){

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    					}else if(javaType == JavaTypesManager.CHARACTER){

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    					}else if(javaType == JavaTypesManager.INTEGER){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    					}else if(javaType == JavaTypesManager.LONG){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    					}else if(javaType == JavaTypesManager.SHORT){

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    					}else if(javaType == JavaTypesManager.FLOAT){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    					}else if(javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    					}
					if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
    				}
				}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    
    		}
    	}
    
	}
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    
		}
	}

    return stringBuffer.toString();
  }
}
